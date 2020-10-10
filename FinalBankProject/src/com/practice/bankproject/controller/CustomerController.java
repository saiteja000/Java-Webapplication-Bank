package com.practice.bankproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practice.bankproject.daoimpl.CustomerDaoImpl;
import com.practice.bankproject.model.Customer;
import com.practice.bankproject.model.FixedDeposit;
import com.practice.bankproject.model.SStatement;



/**
 * Servlet implementation class BankContollerTest
 */
@WebServlet("/Bank")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
       HttpSession session=null;
       String customer_id=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
    
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache, no-store, " + "must-revalidate");
			response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			response.setHeader("Pragme", "no-cache");
			response.setDateHeader("Expires", 0);
	
		
		String uri=request.getParameter("action");
		System.out.println(uri);
		CustomerDaoImpl bd=new CustomerDaoImpl();
		
		PrintWriter out=response.getWriter();

  if(uri.equalsIgnoreCase("CusLogin")) {
			String customer_id=request.getParameter("customer_id");
			
			String password = request.getParameter("password");
			
			  session =request.getSession();
		      session.setAttribute("customer",customer_id);
		      session.setAttribute("pass",password);
		      String n=(String )session.getAttribute("customer");
		      System.out.println("the customer id is");
		      System.out.println(n);
		      
			System.out.println(customer_id+" "+password);
			
			if(bd.LoginCheck(customer_id,password)) {
				
				RequestDispatcher rd=request.getRequestDispatcher("customerpage.jsp"); 
				rd.include(request, response);
				
			
				
			}
			else {
				
				RequestDispatcher rd= request.getRequestDispatcher("customerinvalid.jsp");
				rd.include(request, response);

			}
		}
	else if(uri.equalsIgnoreCase("Deposit")) {
			
			String amount=request.getParameter("amount");

			System.out.println(amount);
			
			double depositamt = Double.parseDouble(amount);
			String saccount=request.getParameter("senderaccount");
			
			System.out.println(depositamt);
			
			if(bd.deposit(saccount,depositamt)) {
				
				RequestDispatcher rd=request.getRequestDispatcher("customerdepositsuccess.jsp"); 
				rd.include(request, response);
				
			
				System.out.println("succesfully deposited");
			}
			else {
				
				RequestDispatcher rd= request.getRequestDispatcher("customerdepositfail.jsp");
				rd.include(request, response);
			}
			
		}
		
	else if(uri.equalsIgnoreCase("withdraw")) {
		
		String amount=request.getParameter("amount");

		System.out.println(amount);
		
		double wamount = Double.parseDouble(amount);
		String saccount=request.getParameter("senderaccount");
		
		System.out.println(wamount);
		
		if(bd.withdraw(saccount,wamount)) {
			
			RequestDispatcher rd=request.getRequestDispatcher("customerwithdrawsuccess.jsp"); 
			rd.include(request, response);
			
		
			System.out.println("withdraw success");
		}
		else {
			
			RequestDispatcher rd= request.getRequestDispatcher("customerwithdrawfail.jsp");
			rd.include(request, response);
		}
		
	}
		
		
	else if(uri.equalsIgnoreCase("transfer")) {

		String raccount=request.getParameter("receiversaccount");

		String amount= request.getParameter("amount");


		String saccount=request.getParameter("senderaccount");
		String date1=request.getParameter("date1");
		
		DateTimeFormatter formateer =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date2=LocalDate.parse(date1, formateer);
		
		double damount = Double.parseDouble(amount);





		System.out.println(saccount+" "+raccount+" "+damount );


		if(bd.fundTransfer(saccount, raccount,  damount, date1)) {

			RequestDispatcher rd=request.getRequestDispatcher("customertransfersuccess.jsp"); 
			rd.include(request, response);



		}
		else {

			RequestDispatcher rd= request.getRequestDispatcher("customertransferfail.jsp");
			rd.include(request, response);
		}
	}

		
		
else if(uri.equalsIgnoreCase("ministatement")) {
		
		String senderaccount=request.getParameter("senderaccount");
		
		//String recieveraccount = request.getParameter("recieveraccount");
		
		String fromdate= request.getParameter("fromdate");
		
		String todate=request.getParameter("todate");
		
		DateTimeFormatter formateer =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fromdate1=LocalDate.parse(fromdate, formateer);
		
		LocalDate todate1=LocalDate.parse(todate, formateer);
		System.out.println(senderaccount+" "+fromdate+" "+todate);
		
	
		
			List<SStatement> stmtlist=bd.getminiStatement(senderaccount,fromdate,todate);
			if(!stmtlist.isEmpty()) {
		request.setAttribute("mslist",stmtlist);
			
			RequestDispatcher rd=request.getRequestDispatcher("customerminisuccess.jsp"); 
			rd.include(request, response);
			
		
			
		}
		else {
			
			RequestDispatcher rd= request.getRequestDispatcher("customerminifail.jsp");
			rd.include(request, response);
		}
	}
	
  else if(uri.equalsIgnoreCase("changepsw")) {
		
	  String c=(String )session.getAttribute("customer");
	
		String newpassword=request.getParameter("newpsw");
		
		String confirmpassword= request.getParameter("confirmpsw");
		
		if(bd.changePassword(newpassword, confirmpassword,c)) {
			
			RequestDispatcher rd=request.getRequestDispatcher("customerchangepasswordsuccess.jsp"); 
			rd.include(request, response);
		
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("customerchangepasswordfail.jsp"); 
			rd.include(request, response);
		}
		}
  else if(uri.equalsIgnoreCase("viewbalance")) {
		
		String customer_id=request.getParameter("customer_id");
		double bal=bd.viewBalance(customer_id);
		System.out.println(bal);
		if(bal!=0) {
			request.setAttribute("balance",bal);
			RequestDispatcher rd=request.getRequestDispatcher("viewbalancesuccess.jsp"); 
			rd.include(request, response);
			
		}
		else {
			
			RequestDispatcher rd= request.getRequestDispatcher("viewbalancefail.jsp");
			rd.include(request, response);
		}
		
	}
	
	else if(uri.equalsIgnoreCase("viewdetails")) {
		
		String customer_id=request.getParameter("customer_id");
		

		Customer c=bd.viewDetails(customer_id);
		if(c!=null) {
		request.setAttribute("details",c);
		
		RequestDispatcher rd=request.getRequestDispatcher("customerdetailssuccess.jsp"); 
		rd.include(request, response);
		}
		
	}
	else if(uri.equalsIgnoreCase("viewfd")) {
		
		String customer_id=request.getParameter("customer_id");
		

		FixedDeposit f=bd.viewfd(customer_id);
		if(f!=null) {
		request.setAttribute("fddetails",f);
		
		RequestDispatcher rd=request.getRequestDispatcher("viewfdsuccess.jsp"); 
		rd.include(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("opennewfd.jsp"); 
			rd.include(request, response);
		}
		
	}
	else if(uri.equalsIgnoreCase("foreclose")) {
		
		String customer_id=request.getParameter("customer_id");
		String end_date=request.getParameter("end_date");

		FixedDeposit f;
		try {
			f = bd.foreClose(customer_id,end_date);
			if(f!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("fddetails",f);
				
				RequestDispatcher rd=request.getRequestDispatcher("viewfdsuccess.jsp"); 
				rd.include(request, response);
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("opennewfd.jsp"); 
					rd.include(request, response);
				}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
