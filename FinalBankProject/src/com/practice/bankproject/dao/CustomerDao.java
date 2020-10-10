package com.practice.bankproject.dao;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.function.BooleanSupplier;

import com.practice.bankproject.model.Customer;
import com.practice.bankproject.model.FixedDeposit;
import com.practice.bankproject.model.SStatement;

public interface CustomerDao {
	public boolean fundTransfer(String sender_customer_id, String receivers_account_id, double amount,String date1);
	public List<SStatement> getminiStatement(String senderaccount, String fromdate,String todate);
	
	public boolean deposit(String customer_id,Double amount);
	public boolean withdraw(String customer_id,Double amount);
	public boolean changePassword(String newpsw,String conpsw,String customer_id);
	public Customer viewDetails(String customer_id);
	public FixedDeposit viewfd(String customer_id);
	public double viewBalance(String customer_id);
	public boolean LoginCheck(String customer_id, String password );
	public FixedDeposit foreClose(String customer_id,String end_date) throws ParseException;
}
