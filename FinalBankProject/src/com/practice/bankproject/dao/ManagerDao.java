package com.practice.bankproject.dao;

import java.sql.Date;
import java.text.ParseException;
import java.util.function.BooleanSupplier;

import com.practice.bankproject.model.Customer;

public interface ManagerDao {
	public boolean LoginempCheck(String employee_id,String password);
	//public boolean openSavingsAccount(String customer_id,String customer_name,String password,int customer_age,String pannumber);
	public boolean openExistingFd(String customer_id,String start_date, String end_date, double principle);
	public boolean closeSbAccount(String account_id);
	public Customer getMiniStatement(int  id);
	public boolean opennewfd(String customer_id,String customer_name,String password, int customer_age, String pannumber,String start_date, String end_date, double amount) throws ParseException;
	public boolean openNewSb(String customer_id,String customer_name,String password, int customer_age, String pannumber);
	public boolean openExistingSb(String customer_id);
	public boolean addStaff(int employee_id , String employee_name,String department_id, String password);
	public boolean removeStaff(int employee_id);
	public boolean closeFdAccount(String account_id);


}

