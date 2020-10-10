package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.practice.bankproject.dao.EmployeeDao;
import com.practice.bankproject.daoimpl.EmployeeDaoImpl;

class EmployeeTest {
 
	EmployeeDao edao;
	@BeforeEach
	void setUp() throws Exception {
		edao = new EmployeeDaoImpl();
	}
/*	@Test
	void LoginempCheck()
	{
	//assertTrue(edao.LoginempCheck(12345, "shwetha123"));//valid credientials done
	
	//assertFalse(edao.LoginempCheck(12345, "password"));//incorrect password done
	
	//assertFalse(edao.LoginempCheck(123455, "password"));//incoreect id done
	
	//assertFalse(edao.LoginempCheck(1235, "password"));//incorrect id done
	
	}*/
	@Test
	void  openNewSb() {
		assertTrue(edao.openNewSb("MLA12645", "harsha", "harsha3", 23, "MKLO2345"));//opening account
		
	//	assertFalse(edao.openNewSb("MLA25354", "laksh", "345", 24, "BCDE1222"));//already existing customer done
		
	//	assertFalse(edao.openNewSb("MLA12345", "mounika", "345", 24, "ABED12345"));//PAN FORMAT front end
		
		//assertFalse(edao.openNewSb("MLA12345", "mounika", "345", 24, "ACD134"));//pan format front end
		
	}
	
	@Test
	void openExistingFd()
	{
		//assertTrue(edao.openExistingFd("fd88430","2018-07-16" , "2020-07-16" , 10000));//opening fd for existing sb customer done
		
	//	assertFalse(edao.openExistingFd("fd45840","2018-07-16" , "2022-07-16" , 10000));//already existing user done
		
		assertFalse(edao.openExistingFd("fd12345", "2020-07-15" , "2019-07-15" , 10000));//date format
		
		assertFalse(edao.openExistingFd("fd12345", "2018-07-15" , "2019-07-15" , 1000));//minimum fd amount is 10000
	}
	
 @Test
	void closeSbAccount()
	{
		assertTrue(edao.closeSbAccount("MLA23235"));//closing sb
		
		//assertFalse(edao.closeSbAccount("MLA23789"));//doesnot have sb account done
		
	//	assertFalse(edao.closeSbAccount("MLA66677"));//no customer with this id done
	}
	
	/*@Test
	void getMiniStatement()
	{
		assertCustomer();
	}*/

	@Test
	void opennewfd() throws ParseException
	{
		//assertTrue(edao.opennewfd("MLA23435", "munny","munny", 20, "LMNO2324", "2018-07-15" , "2019-07-15" , 10000));//opening fd done
		
		//assertFalse(edao.opennewfd("MLA25354", "munny","munny", 20, "LMNO2324", "2018-07-16" , "2022-07-16" , 10000));//already having fd cannot add done
	
		//assertFalse(edao.opennewfd("MLA23435", "munny","munny", 20, "LMNO2324", "2018-07-15" , "2019-07-15" , 1000));//minim deposit 10000 done
		
	//	assertFalse(edao.opennewfd("MLA23435", "munny","munny", 20, "LMNO2324", "2020-07-15" , "2019-07-15" , 10000));//incorrect date front end
	
	//	assertFalse(edao.opennewfd("MLA23435", "munny","munny", 20, "LMNO62324", "2018-07-15" , "2019-07-15" , 10000));//pannumber format front end
	
		//assertFalse(edao.opennewfd("MLA23435", "munny","munny", 20, "LMNO224", "2018-07-15" , "2019-07-15" , 10000));//pannumber format front end
	}

	
	@Test
	void addstaff()
	{
	//	assertTrue(edao.addStaff(23235, "harshith", "DEPT01", "harshith123"));//adding employee to dept 1 done
	
	//assertFalse(edao.addStaff(232352, "harshith", "DEPT01", "harshith123"));//employee_id more than 5 values front end 
		
	//	assertFalse(edao.addStaff(3235, "harshith", "DEPT01",  "harshith123"));//employee_id less than 5 values front end
	   
	//	assertFalse(edao.addStaff(25874, "harshith", "DEPT01",  "harshith123"));//already existing employee cannot add done
	
	}
	@Test
	void removestaff()
	{
		//assertTrue(edao.removeStaff(56789)); //removing existing employee done
		
	//	assertFalse(edao.removeStaff(1234));//less than 5 values front end
		
//		assertFalse(edao.removeStaff(123456)); //more than 5 values front end
		
	//	assertFalse(edao.removeStaff(23267)); //not existing employee done
	}
	 @Test
	 void closeFdAccount()
	 {
		 assertTrue(edao.closeFdAccount("fd34465"));//close fd
		 
	//	 assertFalse(edao.closeFdAccount("fd12345"));//no such account exists done
		 
		// assertTrue(edao.closeFdAccount("12345"));//incorrect fd id front end
	 } 
}
