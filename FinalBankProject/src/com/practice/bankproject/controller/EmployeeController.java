package com.practice.bankproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.bankproject.daoimpl.CustomerDaoImpl;
import com.practice.bankproject.daoimpl.EmployeeDaoImpl;
import com.practice.bankproject.model.Customer;
import com.practice.bankproject.model.SStatement;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDaoImpl ed;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        ed=new EmployeeDaoImpl();
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
		
			if(uri.equalsIgnoreCase("EmpLogin")) {
			
			
			String employee_id=request.getParameter("employee_id");
		
			String password = request.getParameter("password");
			System.out.println("servlet"+employee_id+" "+password);
			System.out.println("test controller");
			
			if(ed.LoginempCheck(employee_id,password)) {
				if(ed.emptype(employee_id))
				{
				System.out.println("hi");
				RequestDispatcher rd=request.getRequestDispatcher("employeepage.jsp"); 
				rd.include(request, response);
				
			
				out.print("Welcome to Mphasis Bank</b>&nbsp;&nbsp;&nbsp;"+employee_id);	
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("managerpage.jsp"); 
				rd.include(request, response);
				
			
				out.print("Welcome to Mphasis Bank</b>&nbsp;&nbsp;&nbsp;"+employee_id);	
			}
			}
			else {
				
				RequestDispatcher rd= request.getRequestDispatcher("employeeinvalid.jsp");
				rd.include(request, response);
			}
			
			}
			else  if(uri.equalsIgnoreCase("opennewsb"))
			{
	         String customer_id = request.getParameter("customer_id");
	         
	         String customer_name = request.getParameter("customer_name");
	         
	         String password = request.getParameter("password");
	
	         int customer_age = Integer.parseInt(request.getParameter("customer_age"));
	         
	         String pannumber = request.getParameter("pannumber");
	
	         
	         System.out.println(customer_id+" "+customer_name+" "+password+" "+customer_age+" "+pannumber );
	         
	        
			System.out.println("welcome");
			if(ed.openNewSb(customer_id,customer_name,password,customer_age,pannumber))
			 {
				 
				RequestDispatcher rd=request.getRequestDispatcher("opensbsuccess.jsp");
					rd.include(request, response);
			 }
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("opensbfail.jsp");
					rd.include(request, response);
			 }
	         }
			else  if(uri.equalsIgnoreCase("openexistingsb"))
			{
	         String customer_id = request.getParameter("customer_id");
	         
	         System.out.println(customer_id);
	         
	        
			System.out.println("welcome");
			if(ed.openExistingSb(customer_id))
			 {
				 
				RequestDispatcher rd=request.getRequestDispatcher("opensbsuccess.jsp");
					rd.include(request, response);
			 }
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("opensbfail.jsp");
					rd.include(request, response);
			 }
	         }
			else  if(uri.equalsIgnoreCase("opennewfd"))
			{
	         String customer_id = request.getParameter("customer_id");
	         
	         String customer_name = request.getParameter("customer_name");
	         
	         String password = request.getParameter("password");
	
	         int customer_age = Integer.parseInt(request.getParameter("customer_age"));
	         
	         String pannumber = request.getParameter("pannumber");
	         
	         String start_date = request.getParameter("startdate");
	         
	         String end_date = request.getParameter("enddate");
	         
	         double amount = Double.parseDouble(request.getParameter("amount"));
	
	         
	         System.out.println(customer_id+" "+customer_name+" "+password+" "+customer_age+" "+pannumber+" "+start_date+" "+end_date+" "+amount );
	         
	        
			System.out.println("welcome");
			try {
				if(ed.opennewfd(customer_id,customer_name,password,customer_age,pannumber,start_date,end_date,amount))
				 {
					 
					RequestDispatcher rd=request.getRequestDispatcher("openfdsuccess.jsp");
						rd.include(request, response);
				 }
				 else
				 {
					 RequestDispatcher rd=request.getRequestDispatcher("openfdfail.jsp");
						rd.include(request, response);
				 }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         }
			else  if(uri.equalsIgnoreCase("openexistingfd"))
			{
	         String customer_id = request.getParameter("customer_id");
	         
	         String start_date = request.getParameter("startdate");
	         
	         String end_date = request.getParameter("enddate");
	         
	         double amount = Double.parseDouble(request.getParameter("amount"));
	
	         
	         System.out.println(customer_id+" "+start_date+" "+end_date+" "+amount );
	         
	        
			System.out.println("welcome");
			if(ed.openExistingFd(customer_id,start_date,end_date,amount))
			 {
				 
				RequestDispatcher rd=request.getRequestDispatcher("openfdsuccess.jsp");
					rd.include(request, response);
			 }
			 else
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("openfdfail.jsp");
					rd.include(request, response);
			 }
	         }
			
			else if(uri.equalsIgnoreCase("closesbaccount"))
			{
				String account_id = request.getParameter("account_id");
			
				System.out.println(account_id);
				if(ed.closeSbAccount(account_id))
				{
					RequestDispatcher rd=request.getRequestDispatcher("closesbsuccess.jsp");
					rd.include(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("closesbfail.jsp");
					rd.include(request, response);
				}

			}
			else if(uri.equalsIgnoreCase("closefdaccount"))
			{
				
				String account_id = request.getParameter("account_id");
			
				System.out.println(account_id);
				if(ed.closeFdAccount(account_id))
				{
					System.out.println("test");
					RequestDispatcher rd=request.getRequestDispatcher("closefdsuccess.jsp");
					rd.include(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("closefdfail.jsp");
					rd.include(request, response);
				}

			}
			else if(uri.equalsIgnoreCase("empministatement")) {
				
				String senderaccount=request.getParameter("customer_id");
				
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
					
					RequestDispatcher rd=request.getRequestDispatcher("openministatementsuccess.jsp"); 
					rd.include(request, response);
					
				
					
				}
				else {
					
					RequestDispatcher rd= request.getRequestDispatcher("customerminifail.jsp");
					rd.include(request, response);
				}
			}
		}

						catch(NullPointerException e)
			{
				e.printStackTrace();
			}
	}
	
	
	
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
