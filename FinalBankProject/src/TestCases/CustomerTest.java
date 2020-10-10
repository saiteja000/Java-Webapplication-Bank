package TestCases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.practice.bankproject.dao.CustomerDao;
import com.practice.bankproject.daoimpl.CustomerDaoImpl;
import com.practice.bankproject.model.Customer;

class CustomerTest {
	
      CustomerDao cdao;
	@BeforeEach
	void setUp() throws Exception {
		cdao=new CustomerDaoImpl();
	}
	@After
	public void tearDown() throws Exception {
		cdao=null;
	}
	@Test
	void LoginCheck()
	{
		assertTrue(cdao.LoginCheck("MLA23235", "pravi"));//valid credientials
		
		assertFalse(cdao.LoginCheck("MLA23235", "meggi"));//invalid
		
		assertFalse(cdao.LoginCheck("MLA1345", "meggi"));//invalid
		
		assertFalse(cdao.LoginCheck("MLA123452", "meggi"));//invalid
		
		assertFalse(cdao.LoginCheck("12345", "meggi"));//invalid
		
		assertFalse(cdao.LoginCheck("mla12345", "meggi"));//invalid
	} 
	@Test
	void fundTransfer() {
		
	assertTrue(cdao.fundTransfer("MLA25899" ,"MLA23235",100,"2018-07-17"));//valid transfer
	
	assertFalse(cdao.fundTransfer("MLA25899","MLA34567", 1000, "2018-07-16"));//reciever does not exists
	
     assertFalse(cdao.fundTransfer("MLA25899","MLA23235", 10, "2018-07-16"));//mimimum transfer is 100
	
   // assertFalse(cdao.fundTransfer("MLA25354","23235", 1000, "2018-07-16"));//inalid recievr front end
	
	//assertFalse(cdao.fundTransfer("MLA25354","mla23235", 1000, "2018-07-16"));//invalid recipents id front end
	
    //assertFalse(cdao.fundTransfer("MLA25354","MLA2323", 1000, "2018-07-16"));//invalid recipents id less than 5 digits front end

	//assertFalse(cdao.fundTransfer("MLA25354","MLA273235", 1000, "2018-07-16"));//invalid recipents id more than 5 digits frontend

	//assertFalse(cdao.fundTransfer("MLA25899" ,"MLA23235",1000,"2018-07-19"));//no transfer at that date front end
	
	//assertFalse(cdao.fundTransfer("MLA23235","MLA23235",1000,"2018-07-16"));//sender and reciever both are same done

	}
 @Test
    void SStatement()
    {
	
	ArrayList<String> la=new ArrayList<String>();
	la.add("25354");
	la.add("25899");
	la.add("2018-07-16");
    
    } 

/*@Test
 	void getDetails()
 	{
	  Customer customer = new   Customer();    
      Assert.assertNotNull(customer);
      Assert.assertEquals(testId, student.getId());
      Assert.assertEquals(testName, student.getName());
      Assert.assertEquals(testSection, student.getSection());
 	}
*/


@Test
	void deposit()
	{
	assertTrue(cdao.deposit("MLA25354", 1000.0));//amount  deposited
	
	assertTrue(cdao.deposit("MLA25354", 100.0));//amount deposited
	
	assertFalse(cdao.deposit("MLA25354", 10.78));//cannot deposit less than 100
	
	//assertFalse(cdao.deposit("MLA1234", 1500.0));//inalid cus id front end
	
 //assertFalse(cdao.deposit("mla12345", 1000.0));//invalid cusid front end
	
	}
@Test
  void withdraw()
  {
	assertTrue(cdao.withdraw("MLA25354",100.0));//amount withdrawed
	
	assertFalse(cdao.withdraw("MLA25354", 15000.0));//amount entered to withdraw is greater than balance
	
	//assertFalse(cdao.withdraw("12345", 1000.0));//inalid cusid 
	
	assertFalse(cdao.withdraw("MLA25354", 15.0));//cannot withdraw less than 100
	
  }
@Test 
	void changePassword()
	{
	 	assertTrue(cdao.changePassword("munny","munny", "MLA12345"));//password changed
	 	
	 	//assertFalse(cdao.changePassword("munny", "meggi", "MLA12345"));//new pswd does not match to confirm pswd done
	 	
	} 
} 