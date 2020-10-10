package com.practice.bankproject.daoimpl;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.apache.tomcat.util.collections.SynchronizedQueue;

import com.practice.bankproject.dao.EmployeeDao;
import com.practice.bankproject.dao.ManagerDao;
import com.practice.bankproject.model.Customer;
import com.practice.bankproject.util.DbUtil;



public class ManagerDaoImpl implements ManagerDao  {
	Random random = new Random();
	Connection con = null;
	public ManagerDaoImpl(){
		con=DbUtil.getConnection();
	
	}
	@Override
	public boolean LoginempCheck(String employee_id,String password) {
		boolean status =false;
		System.out.println("dao"+employee_id+" "+password);
		try {
			System.out.println("dao2"+employee_id+" "+password);
			System.out.println("test1");
			
			String sql="select employee_id,password from employee where employee_id=? and password=?";
			System.out.println("test2");
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("test");
			ps.setString(1,employee_id);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return status;
	}
	public boolean emptype(String employee_id) {
		String type1="e";
		boolean status=false;
		String type=null;
		try {
			
			String sql="select employee_type from employee where employee_id=?";
			System.out.println("test0");
			PreparedStatement ps=con.prepareStatement(sql);
			System.out.println("test");
			ps.setString(1,employee_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				type=rs.getString(1);
			}
			if(type.equalsIgnoreCase(type1)) {
				status=true;
			}
			
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return status;
	}

	
		@Override
		public boolean openNewSb(String customer_id,String customer_name,String password,int customer_age,String pannumber) {
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean status=true;
			System.out.println("test123");
			String cusidnum=customer_id.substring(3);
			try {
				int count=0;
				int num = random.nextInt((89999) + 10000);
				System.out.println(num);
				String accid_number=String.valueOf(num);
				String saccount_id="sb"+accid_number;
				
				
				//String sql4 = "select saccount_id from savingsaccount where scustomer_id=?";
				double amount=1000;
				System.out.println("p1");
				String sql="select employee_id from employee where employee_id=?";
				ps=con.prepareStatement(sql);
				String emp_id=null;
				ps.setString(1,cusidnum );
				rs=ps.executeQuery();
				while(rs.next()) 
				{
					System.out.println("p2");
					emp_id=rs.getString(1);
				}
				System.out.println(customer_id+" "+emp_id);
				if(cusidnum.equalsIgnoreCase(emp_id))
				{
					status=false;
				System.out.println(status);
				}
				else
				{
				System.out.println("test5");
				int count1=0;
				String check1="select count(*) from fixeddeposit where FCUSTOMER_ID=?";
				ps=con.prepareStatement(check1);
				ps.setString(1,customer_id);
				rs=ps.executeQuery();
				while(rs.next())
				{
					count1=rs.getInt(1);
				}
				if(count1!=0)
				{
					return false;
				}
				String sql2="select count(*) from savingsaccount where SCUSTOMER_ID=?";
				ps=con.prepareStatement(sql2);
		
				ps.setString(1,customer_id);
	
				rs=ps.executeQuery();
		
				while(rs.next())
				{
					count=rs.getInt(1);
				}
				if(count!=0)
				{
					status=false;
				}
				System.out.println(customer_id+" "+emp_id);
				System.out.println(count);
				
				String sql3 = "insert into customer values(?,?,?,?,?)";
				ps=con.prepareStatement(sql3);
				ps.setString(1,customer_id);
				ps.setString(2,customer_name);
				ps.setString(5,password);
				ps.setInt(3,customer_age);
				ps.setString(4,pannumber);
				
				ps.executeUpdate();
				System.out.println("pravi");
				/*String sql4="insert into account values(?,?)";
				ps=con.prepareStatement(sql4);
				String type="Savings";
				ps.setString(1, type);
				ps.setString(2, saccount_id);
				ps.executeUpdate();
				System.out.println(status);*/
				String sql5="insert into savingsaccount values(?,?,?)";
				ps=con.prepareStatement(sql5);
				System.out.println("meggi");
				ps.setString(1, saccount_id);
				ps.setString(2, customer_id);
				ps.setDouble(3, amount);
				System.out.println(accid_number);
				ps.executeUpdate();
				// TODO Auto-generated method stub
				}
				System.out.println("test78");
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return status;
	}


		@Override
		public boolean openExistingFd(String customer_id,String start_date, String end_date, double principle) {
			
			
			boolean status=false;
			PreparedStatement ps=null;
			ResultSet rs=null;
			int count=0;
			int age=0;
			String cusidnum=customer_id.substring(3);
			try {
				String sql="select employee_id from employee where employee_id=?";
				ps=con.prepareStatement(sql);
				String emp_id1=null;
				ps.setString(1,cusidnum );
				rs=ps.executeQuery();
				while(rs.next()) 
				{
					emp_id1=rs.getString(1);
				}
				System.out.println(customer_id+" "+emp_id1);
				if(cusidnum.equalsIgnoreCase(emp_id1))
				{
					return false;
				
				}
			int num = random.nextInt((56678) + 10000);
			String acc_id_number=String.valueOf(num);
			String acc_id="fd"+acc_id_number;
			System.out.println(acc_id);
			int eDateYear = Integer.parseInt(end_date.split("-")[0]);
			int eDateMonth = Integer.parseInt(end_date.split("-")[1]);
			int eDateDay = Integer.parseInt(end_date.split("-")[2]);
			int sDateYear = Integer.parseInt(start_date.split("-")[0]);
			int sDateMonth = Integer.parseInt(start_date.split("-")[1]);
			int sDateDay = Integer.parseInt(start_date.split("-")[2]);
			double roi;
			LocalDate endofCentury = LocalDate.of(eDateYear, eDateMonth, eDateDay);
			LocalDate now = LocalDate.of(sDateYear, sDateMonth, sDateDay);
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
	        System.out.println("Fixed deposit: "+ (maturityamount));
	       
	        String check="select count(*) from fixeddeposit where FACCOUNT_ID=?";
			ps=con.prepareStatement(check);
			ps.setString(1,acc_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			if(count!=0)
			{
				return false;
			}
			String sql5="insert into account values(?,?)";
			ps=con.prepareStatement(sql5);
			String type="FixedDeposit";
			ps.setString(1, type);
			ps.setString(2, acc_id);
			ps.executeUpdate();
			System.out.println("t");
			String sql2="insert into fixeddeposit values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql2);
			ps.setString(1,acc_id);
			System.out.println(acc_id);
			ps.setString(2,customer_id);
			System.out.println(customer_id);
			ps.setString(3,start_date);
			System.out.println(start_date);
			ps.setString(4,end_date);
			System.out.println(end_date);
			ps.setDouble(5,roi);
			System.out.println(roi);
			ps.setDouble(6, principle);
			System.out.println(principle);
			ps.setDouble(7, maturityamount);
			System.out.println(maturityamount);
			System.out.println("test1");
			ps.executeUpdate();
			System.out.println("test2");
			status=true;
			}
			catch(SQLException e) {
				}
			return status;
			}
			
		
	
	@Override
	public boolean closeSbAccount(String id) {
		boolean s=false;
		PreparedStatement pst = null;
		ResultSet rs=null;
		int count=0;
		try {
			 String check="select count(*) from fixeddeposit where FACCOUNT_ID=?";
				pst=con.prepareStatement(check);
				pst.setString(1,id);
				rs=pst.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
				}
				if(count==0)
				{
					return false;
				}
			String sql_select = "select scustomer_id from savingsaccount where  saccount_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql_select);
			pst.setString(1, id);
			String cust_id=null;
			rs=pst.executeQuery();
			while(rs.next()) {
				cust_id=rs.getString(1);
				System.out.println("pravi");
			}
			
			System.out.println(cust_id);
			String sql2 = "delete from savingsaccount where scustomer_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql2);
			pst.setString(1, cust_id);
			pst.executeUpdate();
			System.out.println("test1");
			
			String sql3 = "delete from fixeddeposit where fcustomer_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql3);
			pst.setString(1, cust_id);
			pst.executeUpdate();
			String sql4 = "delete from account where account_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql4);
			pst.setString(1, id);
			pst.executeUpdate();
			String check1="select count(*) from fixeddeposit where FCUSTOMER_ID=?";
			pst=con.prepareStatement(check1);
			pst.setString(1,cust_id);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			System.out.println(count);
			if(count!=0)
			{
				s=true;
			}
			else {
			String sql1 = "delete from customer where customer_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql1);
			pst.setString(1, cust_id);
			pst.executeUpdate();
			System.out.println("test3");
			s=true;
			}


			}catch(SQLException e) {
				e.printStackTrace();
			}
			return s;	
	}
	@Override
	public boolean closeFdAccount(String id) {
		boolean s=false;
		PreparedStatement pst = null;
		ResultSet rs=null;
		int count=0;
		try {
			
			String sql_select = "select fcustomer_id from fixeddeposit where  faccount_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql_select);
			pst.setString(1, id);
			String cust_id=null;
			rs=pst.executeQuery();
			while(rs.next()) {
				cust_id=rs.getString(1);
				System.out.println("pravi");
			}
			
			System.out.println(cust_id);
			System.out.println("test1");
			int count1=0;
			String sql2="select count(*) from fixeddeposit where faccount_id=?";
			pst=con.prepareStatement(sql2);
	
			pst.setString(1,id);

			rs=pst.executeQuery();
	
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			if(count==0)
			{
				return false;
			}
			String sql3 = "delete from fixeddeposit where fcustomer_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql3);
			pst.setString(1, cust_id);
			pst.executeUpdate();
			System.out.println("test2");
			System.out.println(cust_id);
			String sql4 = "delete from account where account_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql4);
			pst.setString(1, id);
			pst.executeUpdate();
			String check="select count(*) from savingsaccount where SCUSTOMER_ID=?";
			pst=con.prepareStatement(check);
			pst.setString(1,cust_id);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			System.out.println(count);
			if(count!=0)
			{
				s=true;
			}
			else {
			String sql1 = "delete from customer where customer_id=?";
			con=DbUtil.getConnection();
			pst = con.prepareStatement(sql1);
			pst.setString(1, cust_id);
			pst.executeUpdate();
			System.out.println("test3");
			s=true;
			}

			}catch(SQLException e) {
				e.printStackTrace();
			}
			return s;	
	}
	
	
	@Override
	public Customer getMiniStatement(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean opennewfd(String customer_id, String customer_name, String password, int customer_age,
			String pannumber, String start_date, String end_date, double principle) throws ParseException
	{
		
		boolean status=false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		if(principle<10000) {
			return false;
		}
		int count=0;
		try {
		String cusidnum=customer_id.substring(3);
		int num = random.nextInt((56678) + 10000);
		String acc_id_number=String.valueOf(num);
		String acc_id="fd"+acc_id_number;
		System.out.println(acc_id);
		int eDateYear = Integer.parseInt(end_date.split("-")[0]);
		int eDateMonth = Integer.parseInt(end_date.split("-")[1]);
		int eDateDay = Integer.parseInt(end_date.split("-")[2]);
		int sDateYear = Integer.parseInt(start_date.split("-")[0]);
		int sDateMonth = Integer.parseInt(start_date.split("-")[1]);
		int sDateDay = Integer.parseInt(start_date.split("-")[2]);
		double roi;
		LocalDate endofCentury = LocalDate.of(eDateYear, eDateMonth, eDateDay);
		LocalDate now = LocalDate.of(sDateYear, sDateMonth, sDateDay);
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
		if(customer_age>60) {
			roi=roi+0.05;
		}
		System.out.println(roi);
		double time=diff.getYears()+(0.08*diff.getMonths());
		System.out.println(time);
		double maturityamount=0;
		
		double temp=(1+roi);
        maturityamount=principle*Math.pow(temp,(time));
        System.out.println("Fixed deposit: "+ (maturityamount));
        String sql="select employee_id from employee where employee_id=?";
		ps=con.prepareStatement(sql);
		String emp_id=null;
		ps.setString(1,cusidnum );
		rs=ps.executeQuery();
		while(rs.next()) 
		{
			System.out.println("check");
			emp_id=rs.getString(1);
		}
		System.out.println(customer_id+" "+emp_id);
		if(cusidnum.equalsIgnoreCase(emp_id))
		{
			System.out.println("check1");
			return false;
		}
		System.out.println(status);
		int count1=0;
		String check1="select count(*) from savingsaccount where SCUSTOMER_ID=?";
		ps=con.prepareStatement(check1);
		ps.setString(1,customer_id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			count1=rs.getInt(1);
		}
		if(count1!=0)
		{
			status=false;
		}
        String check="select count(*) from fixeddeposit where FACCOUNT_ID=?";
		ps=con.prepareStatement(check);
		ps.setString(1,acc_id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			count=rs.getInt(1);
		}
		if(count!=0)
		{
			status=false;
		}
		else {
			
		System.out.println("check5");
		String sql1="insert into customer values(?,?,?,?,?)";
		ps=con.prepareStatement(sql1);
		ps.setString(1,customer_id);
		ps.setString(2,customer_name);
		ps.setInt(3,customer_age);
		ps.setString(4,pannumber);
		ps.setString(5,password);
		ps.executeUpdate();
		System.out.println("test");
		String sql4="insert into account values(?,?)";
		ps=con.prepareStatement(sql4);
		String type="FixedDeposit";
		ps.setString(1, type);
		ps.setString(2, acc_id);
		ps.executeUpdate();
		System.out.println("t");
		String sql2="insert into fixeddeposit values(?,?,?,?,?,?,?)";
		ps=con.prepareStatement(sql2);
		ps.setString(1,acc_id);
		System.out.println(acc_id);
		ps.setString(2,customer_id);
		System.out.println(customer_id);
		ps.setString(3,start_date);
		System.out.println(start_date);
		ps.setString(4,end_date);
		System.out.println(end_date);
		ps.setDouble(5,roi);
		System.out.println(roi);
		ps.setDouble(6, principle);
		System.out.println(principle);
		ps.setDouble(7, maturityamount);
		System.out.println(maturityamount);
		System.out.println("test1");
		ps.executeUpdate();
		System.out.println("test2");
		status=true;
		}
		}
		catch(SQLException e) {
			}
		return status;
		}
	@Override
	public boolean addStaff(int employee_id, String employee_name, String department_id,
			String password) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String emptype="e";
		boolean status=false;
		System.out.println("test123");
		try {
			int count=0;
			String sql2="select count(*) from employee where employee_id=?";
			ps=con.prepareStatement(sql2);
	
			ps.setInt(1,employee_id);

			rs=ps.executeQuery();
	
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			if(count!=0)
			{
				return false;
			}
			System.out.println(status);
			String sql3 = "insert into employee values(?,?,?,?,?)";
			ps=con.prepareStatement(sql3);
			ps.setInt(1,employee_id);
			ps.setString(2,employee_name);
			ps.setString(3, department_id);
			ps.setString(4, emptype);
			ps.setString(5, password);
			System.out.println("test23");
			ps.executeUpdate();
			System.out.println("test54");
			status=true;
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public boolean removeStaff(int employee_id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String emptype="e";
		boolean status=true;
		System.out.println("test123");
		try {
			int count=0;
			
			String sql2="select count(*) from employee where employee_id=?";
			ps=con.prepareStatement(sql2);
	
			ps.setInt(1,employee_id);

			rs=ps.executeQuery();
	
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			if(count==0)
			{
				return false;
			}
			System.out.println(status);
			String sql3 = "delete from employee where employee_id=?";
			ps=con.prepareStatement(sql3);
			ps.setInt(1,employee_id);
			System.out.println("test23");
			ps.executeUpdate();
			System.out.println("test54");
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public boolean openExistingSb(String customer_id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean status=true;
		System.out.println("test123");
		try {
			//String customer1_id="MLA"+customer_id;
			int count=0;
			int num = random.nextInt((89999) + 10000);
			System.out.println(num);
			String accid_number=String.valueOf(num);
			String saccount_id="sb"+accid_number;
			
			
			//String sql4 = "select saccount_id from savingsaccount where scustomer_id=?";
			double amount=1000;
			String cusidnum=customer_id.substring(3);
			System.out.println(cusidnum);
			String sql = "select employee_id from employee where employee_id=?";
			ps=con.prepareStatement(sql);
			String emp_id=null;
			ps.setString(1,cusidnum);
			rs=ps.executeQuery();
			while(rs.next()) 
			{
				emp_id=rs.getString(1);
			}
			System.out.println(customer_id+" "+emp_id);
			if(cusidnum.equalsIgnoreCase(emp_id))
			{
				return false;
			
			}
			else
			{
			
			System.out.println("test5");	
			String sql2="select count(*) from savingsaccount where SACCOUNT_ID=?";
			ps=con.prepareStatement(sql2);
	
			ps.setString(1,saccount_id);

			rs=ps.executeQuery();
	
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			if(count!=0)
			{
				status=false;
			}
			
			System.out.println(customer_id+" "+emp_id);
			String sql4="insert into account values(?,?)";
			ps=con.prepareStatement(sql4);
			String type="Savings";
			ps.setString(1, type);
			ps.setString(2, saccount_id);
			ps.executeUpdate();
			System.out.println(status);
			String sql5="insert into savingsaccount values(?,?,?)";
			ps=con.prepareStatement(sql5);
			System.out.println("meggi");
			ps.setString(1, saccount_id);
			ps.setString(2, customer_id);
			ps.setDouble(3, amount);
			System.out.println(accid_number);
			ps.executeUpdate();
			// TODO Auto-generated method stub
			}
			System.out.println("test78");
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
		
	}

