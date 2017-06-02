package asgn2Tests;


import java.util.ArrayList;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A 
 */
public class LogHandlerCustomerTests {	
	@Test(expected = LogHandlerException.class)
	public void testNullName() throws CustomerException, LogHandlerException{
		String nullName = "11:20:00" + "11:20:00" + "" + "0111111111" + "DVC" + "5" + "5" + "PZV" + "1";
		LogHandler.createCustomer(nullName);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testLongName() throws CustomerException, LogHandlerException{
		String longName = "11:20:00" + "11:20:00" + "TestName IsLongerThan20Letters" + "0111111111" + "DVC" + "5" + "5" + "PZV" + "1";
		LogHandler.createCustomer(longName);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNullType() throws CustomerException, LogHandlerException{
		String typeNullName = "11:20:00" + "11:20:00" + "TestName IsLongerThan20Letters" + "0111111111" + "" + "5" + "5" + "PZV" + "1";
		LogHandler.createCustomer(typeNullName);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testWrongType() throws CustomerException, LogHandlerException{
		String invalidType = "11:20:00" + "11:20:00" + "TestName IsLongerThan20Letters" + "0111111111" + "INV" + "5" + "5" + "PZV" + "1";
		LogHandler.createCustomer(invalidType);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNullLocationX() throws CustomerException, LogHandlerException{
		String nullLocationX = "11:20:00" + "11:20:00" + "TestName IsLongerThan20Letters" + "0111111111" + "DVC" + "" + "5" + "PZV" + "1";
		LogHandler.createCustomer(nullLocationX);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNullLocationY() throws CustomerException, LogHandlerException{
		String nullLocationY = "11:20:00" + "11:20:00" + "TestName IsLongerThan20Letters" + "0111111111" + "DVC" + "5" + "" + "PZV" + "1";
		LogHandler.createCustomer(nullLocationY);
	}
	
	
	@Test(expected = LogHandlerException.class)
	public void testLogFile() throws CustomerException, LogHandlerException{
		ArrayList<Customer> customerList = new ArrayList<Customer>(LogHandler.populateCustomerDataset("Occur an Exception"));
	}
	
}
