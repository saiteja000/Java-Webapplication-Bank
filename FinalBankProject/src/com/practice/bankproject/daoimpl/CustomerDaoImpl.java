package com.practice.bankproject.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.practice.bankproject.dao.CustomerDao;
import com.practice.bankproject.model.Customer;
import com.practice.bankproject.model.FixedDeposit;
import com.practice.bankproject.model.SStatement;
import com.practice.bankproject.model.SavingsAccount;
import com.practice.bankproject.util.DbUtil;

public class CustomerDaoImpl implements CustomerDao {
	Connection con = null;
	public CustomerDaoImpl(){
		con=DbUtil.getConnection();
	
	}
	public boolean LoginCheck(String customer_id,String password) {
		boolean status =false;
		System.out.println(customer_id+" "+password);
		try {
			String sql="select customer_id,password from customer where customer_id=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,customer_id);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return status;
	}
	
	public boolean deposit(String customer_id,Double amount) {
		boolean status =false;
		SavingsAccount sa = new SavingsAccount();
		System.out.println(customer_id+" "+amount);
		if(amount<100) {
			return status;
		}
		try {
			String sql="select * from SAVINGSACCOUNT where SCUSTOMER_ID = ?";
			String sql1="update SAVINGSACCOUNT set balance = ? where SCUSTOMER_ID = ? ";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,customer_id);
			System.out.println("test");
			ResultSet rs=ps.executeQuery();
			
			
			Double balance=null;
			while(rs.next())
				balance=rs.getDouble("balance");
			System.out.println("balance is"+balance);
			Double updated_bal=null;
			updated_bal=balance+amount;
			
			ps=con.prepareStatement(sql1);
			ps.setDouble(1,updated_bal);
			ps.setString(2,customer_id);
			ps.executeUpdate();
			System.out.println("Updated balance is"+updated_bal);
			status=true;
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return status;
	}
	
	
	
	public boolean withdraw(String customer_id,Double amount) {
		boolean status =false;
		System.out.println(customer_id+" "+amount);
		if(amount<100) {
			return status;
		}
		try {
			String sql="select BALANCE  from SAVINGSACCOUNT where SCUSTOMER_ID = ?";
			String sql1="update SAVINGSACCOUNT set balance = ? where SCUSTOMER_ID = ? ";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,customer_id);
			
			ResultSet rs=ps.executeQuery();
			
			
			Double balance=null;
			while(rs.next())
				balance=rs.getDouble("balance");
			System.out.println("balance is"+balance);
			Double updated_bal=null;
			updated_bal=balance-amount;
			if(updated_bal<1000)
				return status;
			ps=con.prepareStatement(sql1);
			ps.setDouble(1,updated_bal);
			ps.setString(2,customer_id);
			ps.executeUpdate();
			System.out.println("Updated balance is"+updated_bal);
			status=true;
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return status;
	}
	
	

	@Override
	public boolean fundTransfer(String senderscustomer_id, String receiverscustomer_id, double amount,String date2) {
		 
		boolean status=false;
		ResultSet rs = null;
		double sender_balance = 0;
		double receiver_current_balance = 0;
		PreparedStatement pst = null;
		System.out.println(senderscustomer_id);
		try {
			
		
			String sender_account_id="select SACCOUNT_ID  from SAVINGSACCOUNT where SCUSTOMER_ID = ?";
			//String sql_select = "select balance from  savings_account where customer_id = ?";
			
			String sql_select= "select balance from  savingsaccount where saccount_id = ?";
			String sql_select1= "select balance from  savingsaccount where scustomer_id = ?";
			String sql_update ="update savingsaccount set balance = ? where saccount_id = ?";
			String sql_update1 ="update savingsaccount set balance = ? where scustomer_id = ?";
			/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));*/
			
			String sql_mini="insert into mstatement values(?,?,?,?)";
			String receiver_account_id="select SACCOUNT_ID  from SAVINGSACCOUNT where SCUSTOMER_ID = ?";
			con=DbUtil.getConnection();
			pst=con.prepareStatement(receiver_account_id);
			pst.setString(1,receiverscustomer_id);
			rs=pst.executeQuery();//retrives senders savings id
			String rAccId=null;
			while(rs.next()) {
				rAccId=rs.getString("saccount_id");//sender savings id
			}
			String count="select count(*) from savingsaccount where scustomer_id=?";
			pst=con.prepareStatement(count);
			pst.setString(1,receiverscustomer_id);
			System.out.println("check point1");
			rs=pst.executeQuery();
			int count1=0;
			while(rs.next())
				count1=rs.getInt("count(*)");
			System.out.println("count is"+count1);
			if(count1==0)//if receivers account does not exist it interrupts transaction
				return status;			
			pst=con.prepareStatement(sender_account_id);
			pst.setString(1,senderscustomer_id);
			rs=pst.executeQuery();//retrives senders savings id
			String sAccId=null;
			while(rs.next()) {
				sAccId=rs.getString("saccount_id");//sender savings id
			}
			System.out.println("Checkpoint"+sAccId);
			if(senderscustomer_id.equalsIgnoreCase(receiverscustomer_id))
				return status;//if receivers account id is equal to senders account id transaction fails
 
			pst = con.prepareStatement(sql_select);//retriveing senders balance
			pst.setString(1,sAccId );
			rs = pst.executeQuery();
			while(rs.next()) {
			sender_balance = rs.getDouble("balance");
			System.out.println(sender_balance);
			}
			if(sender_balance<amount) {
				return status;
 
			}
			else {
				double sender_updated_balance = sender_balance - amount;
				if(sender_updated_balance<1000) {
						return status;
					}
					else {
						//retriving receivers balance
					pst = con.prepareStatement(sql_select1);
					pst.setString(1, receiverscustomer_id);
					rs = pst.executeQuery();
					while(rs.next()) {
						receiver_current_balance = rs.getDouble("balance");
					}System.out.println("current receiver balance");
					System.out.println(receiver_current_balance);
					/*if(rec_current_balance==0)
					{
						return s;//if amount =0 it interrupts transaction
					}*/
					con.setAutoCommit(false);
					//updating receivers balance
					double  receiver_updated_balance = receiver_current_balance+amount;
					System.out.println(receiver_updated_balance);
					pst = con.prepareStatement(sql_update1);
					pst.setDouble(1, receiver_updated_balance);
					pst.setString(2, receiverscustomer_id);
					rs = pst.executeQuery();
					//updating senders balance
					System.out.println(receiverscustomer_id);
					pst = con.prepareStatement(sql_update);
					pst.setDouble(1, sender_updated_balance);
					pst.setString(2,sAccId);
					rs = pst.executeQuery();
					System.out.println(senderscustomer_id);
					//inserting into  mini statement table about previous transaction
					pst=con.prepareStatement(sql_mini);
					pst.setString(1, date2);
					pst.setString(2,sAccId);
					pst.setString(3, rAccId);
					pst.setDouble(4, amount);
					pst.executeUpdate();
					System.out.println("dateOfTransfer");
					con.commit();
					status=true;
				}
 
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return status;
 
	}

	@Override
	public List<SStatement> getminiStatement(String senderaccout, String fromdate, String todate) {
		List<SStatement> mslist=new ArrayList<>();
		String sql1 = "select saccount_id from savingsaccount where scustomer_id = ? ";
				
				try {
					PreparedStatement ps1=con.prepareStatement(sql1);
					ps1.setString(1, senderaccout);
					String accountid = null;
					ResultSet rs=ps1.executeQuery();
					while(rs.next())
					{
					accountid=rs.getString(1);
					}
					System.out.println(accountid);
					senderaccout=accountid;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(senderaccout);
				System.out.println();
				System.out.println("dateOfTransfer");
				try {
					String sql="select * from mstatement where sendersaccount_id=? and dateOfTransfer between ? AND ? ";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, senderaccout );
					ps.setString(2, fromdate);
					ps.setString(3 , todate);
					System.out.println("hi");
					ResultSet rs=ps.executeQuery();
					System.out.println(rs);
					while(rs.next())
					{
						System.out.println("test");
						SStatement ms=new SStatement();
						
						ms.setDateOfTransfer(rs.getString(1));
						ms.setSendersaccount_id(rs.getString(2));
						ms.setReceiversaccount_id(rs.getString(3));
						ms.setAmount(rs.getDouble(4));
						
						mslist.add(ms);
						System.out.println(ms);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(mslist);
				return mslist;
				
	}
	

	
	
	@Override
	public boolean changePassword(String newpsw, String conpsw, String customer_id) {
boolean status=false;
		
		String sql="update customer set password=? where customer_id=?";
		
		PreparedStatement ps;
		
		try {
			if(newpsw.equals(conpsw)) {
			ps = con.prepareStatement(sql);
			ps.setString(1, newpsw);
			ps.setString(2,customer_id);
			ps.executeUpdate();
			
			status=true;
			}else
			status=false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	@Override
	public Customer viewDetails(String customer_id) {
		Customer c=new Customer();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from customer where customer_id=? ";
		try {
			ps=con.prepareStatement(sql);
		
		ps.setString(1, customer_id );
		System.out.println("hi");
		rs=ps.executeQuery();
		System.out.println(rs);
		
		while(rs.next())
		{
			System.out.println("test");
			
			
			c.setCustomer_id(rs.getString(1));
			c.setCustomer_name(rs.getString(2));
			c.setCustomer_age(rs.getInt(3));
			c.setPanNumber(rs.getString(4));
			c.setPassword(rs.getString(5));
		
			System.out.println(c);
		
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	@Override
	public double viewBalance(String customer_id) {
	
		PreparedStatement pst = null;
		ResultSet rs=null;
		double bal=0;
		try {
			String sql_select = "select balance from savingsaccount where scustomer_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql_select);
			pst.setString(1, customer_id);
			rs=pst.executeQuery();
			while(rs.next()) {
				bal=rs.getDouble(1);
			}

			}catch(SQLException e) {
				e.printStackTrace();
			}
			return bal;		
		// TODO Auto-generated method stub	
	}
	@Override
	public FixedDeposit viewfd(String customer_id) {
		// TODO Auto-generated method stub
		FixedDeposit fd=new FixedDeposit();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from fixeddeposit where fcustomer_id=? ";
		try {
			ps=con.prepareStatement(sql);
		
		ps.setString(1, customer_id );
		System.out.println("hi");
		rs=ps.executeQuery();
		System.out.println(rs);
		
		while(rs.next())
		{
			System.out.println("test");
			
			
			fd.setFcustomer_id(rs.getString(1));
			fd.setFaccount_id(rs.getString(2));
			fd.setAmount(rs.getDouble(6));
			fd.setStartDate(rs.getString(3));
			fd.setEndDate(rs.getString(4));
			fd.setRoi(rs.getInt(5));
			fd.setMaturityamount(rs.getDouble(7));
			System.out.println(fd);
		
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fd;
		
	}

	@Override
	public FixedDeposit foreClose(String customer_id,String end_date) throws ParseException {
		// TODO Auto-generated method stub
		FixedDeposit fd=new FixedDeposit();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from fixeddeposit where fcustomer_id=? ";
		try {
			ps=con.prepareStatement(sql);
		double roi=0;;
		ps.setString(1, customer_id );
		System.out.println("hi");
		rs=ps.executeQuery();
		System.out.println(rs);
		String startdate = null;
		double principle=0;
		while(rs.next())
		{
			
			System.out.println("test");
			
			fd.setFaccount_id(rs.getString(1));
			fd.setFcustomer_id(rs.getString(2));
			
			fd.setAmount(rs.getDouble(6));
			startdate=rs.getString(3);
			System.out.println(startdate);
			fd.setStartDate(startdate);
			principle=rs.getDouble(6);
		    System.out.println(roi);
		    rs.getDouble(7);
		}
		
		System.out.println("test1");
	  //  Date date1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(end_date);  
		fd.setEndDate(end_date);
		/*int eDateYear = Integer.parseInt(end_date.split("-")[0]);
		int eDateMonth = Integer.parseInt(end_date.split("-")[1]);
		int eDateDay = Integer.parseInt(end_date.split("-")[2]);
		int sDateYear = Integer.parseInt(startdate.split("-")[0]);
		int sDateMonth = Integer.parseInt(startdate.split("-")[1]);
		int sDateDay = Integer.parseInt(startdate.split("-")[2]);
*/	
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate endofCentury=LocalDate.parse(startdate, df);
		LocalDate now =LocalDate.parse(end_date, df);
		/*
		LocalDate endofCentury = LocalDate.of(eDateYear, eDateMonth, eDateDay);
		LocalDate now = LocalDate.of(sDateYear, sDateMonth, sDateDay);*/
		Period diff = Period.between(now,endofCentury);
		System.out.printf("Difference is %d years, %d months and %d days ",
                diff.getYears(), diff.getMonths(), diff.getDays());
		if(diff.getMonths()<=12 && diff.getYears()==0) {
			 roi=0.06;
		}
		else if(diff.getYears()<=2) {
			roi=0.07;
		}
		else {
			roi=0.08;
		}
		
		int age=0;
		String sql4="select customer_age from customer where customer_id=?";
		ps=con.prepareStatement(sql4);
		ps.setString(1,customer_id );
		rs=ps.executeQuery();
		while(rs.next()) {
			age=rs.getInt(1);
		}
		if(age>60) {
			roi=roi+0.05;
		}
		System.out.println(roi);
		double time=diff.getYears()+(0.08*diff.getMonths());
		System.out.println(time);
		double maturityamount=0;
		
		double temp=(1+roi);
        maturityamount=principle*Math.pow(temp,(time));
        System.out.println("Fixed deposit: "+ maturityamount);
		fd.setRoi(roi);
		fd.setMaturityamount(maturityamount);
		System.out.println(fd);
		String sql5="delete from fixeddeposit where fcustomer_id=?";
		ps=con.prepareStatement(sql5);
		ps.setString(1,customer_id );
		ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fd;
		
	}


}
