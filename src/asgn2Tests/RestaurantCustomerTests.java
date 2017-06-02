package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Lei Wang
 */
public class RestaurantCustomerTests {
	// TO DO
	private Customer underTest;
	
	@Test (expected = CustomerException.class)
	public void testCustomerConstructorNameNullException() throws CustomerException {
		underTest = new DriverDeliveryCustomer("", "0111111111", 5, 5);
	}
	
	@Test (expected = CustomerException.class)
	public void testCustomerConstructorTooLongNameException() throws CustomerException {
		underTest = new DriverDeliveryCustomer("TheLenthOfTestNameIsOver20", "0111111111", 5, 5);
	}
	
	@Test
	public void testCustomerGetNameFunction() throws CustomerException {
		underTest = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		assertTrue(underTest.getName() == "test");
	}
	
	@Test
	public void testCustomerGetMobileNumberFunction() throws CustomerException {
		underTest = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		assertTrue(underTest.getMobileNumber() == "0111111111");
	}
	
	@Test
	public void testCustomerGetCustomerTypeFunction() throws CustomerException {
		underTest = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		assertTrue(underTest.getCustomerType() == "Driver delivery");
	}
	
	@Test
	public void testCustomerLocationsFunction() throws CustomerException {
		underTest = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		assertTrue(underTest.getLocationX() == 5);
		assertTrue(underTest.getLocationY() == 5);
	}
	
	@Test
	public void testCustomerGetDeliveryDistanceFunction() throws CustomerException {
		underTest = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		assertTrue(underTest.getDeliveryDistance() == 10);
	}
	
	@Test
	public void testCustomerEqualFunction() throws CustomerException {
		underTest = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		Customer other = new DriverDeliveryCustomer("test", "0111111111", 5, 5);
		assertTrue(underTest.equals(other) == true);
	}
}
