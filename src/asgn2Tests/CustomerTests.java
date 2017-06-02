package asgn2Tests;

import org.junit.Assert;
import org.junit.Test;
import asgn2Customers.*;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Lei Wang
 * 
 *
 */
public class CustomerTests {
	
	private final String nameVALID = "John";
	private final String mobileVALID = "0987654321";
	
	@Test
	public void Pickup_createCustomer() throws CustomerException {
		Customer customer = new PickUpCustomer(nameVALID, mobileVALID, 1, 1);
	}
	
	@Test
	public void Delivery_createCustomer() throws CustomerException {
		Customer customer = new DriverDeliveryCustomer(nameVALID, mobileVALID, 2, 2);
	}

	@Test
	public void Drone_createCustomer() throws CustomerException {
		Customer customer = new DroneDeliveryCustomer(nameVALID, mobileVALID, 2, 3);
	}
	
	@Test
	public void Pickup_Name_getCustomer() throws CustomerException {
		Customer customer = new PickUpCustomer(nameVALID, mobileVALID, 0, 0);
		Assert.assertTrue(customer.getName().equals(nameVALID));
	}
	
	@Test
	public void Mobile_getCustomer() throws CustomerException {
		Customer customer = new PickUpCustomer(nameVALID, mobileVALID, 0, 0);
		Assert.assertTrue(customer.getMobileNumber().equals(mobileVALID));
	}
	
	@Test
	public void LocationX_getCustomer() throws CustomerException {
		Customer customer = new PickUpCustomer(nameVALID, mobileVALID, 0, 0);
		Assert.assertEquals(0, customer.getLocationX());
	}
	
	@Test
	public void LocationY_getCustomer() throws CustomerException {
		Customer customer = new PickUpCustomer(nameVALID, mobileVALID, 0, 0);
		Assert.assertEquals(0, customer.getLocationY());
	}
	
	@Test
	public void DeliveryDistance_getCustomer() throws CustomerException {
		Customer customer = new PickUpCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue(customer.getDeliveryDistance() == 0);
	}
	
	@Test
	public void Name_getCustomer_Delivery() throws CustomerException {
		Customer customer = new DriverDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue(customer.getName().equals(nameVALID));
	}
	
	@Test
	public void MobileDel_getCustomer() throws CustomerException {
		Customer customer = new DriverDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue(customer.getMobileNumber().equals(mobileVALID));
	}
	

	@Test
	public void LocationXDelgetCustomer() throws CustomerException {
		Customer customer = new DriverDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertEquals(1, customer.getLocationX());
	}

	
	@Test
	public void DeliveryDistanceDel_getCustomer() throws CustomerException {
		Customer customer = new DriverDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue((Math.abs(customer.getLocationX()) + Math.abs(customer.getLocationY())) == customer.getDeliveryDistance());
	}
	
	@Test
	public void _Drone_Name_getCustomer() throws CustomerException {
		Customer customer = new DroneDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue(customer.getName().equals(nameVALID));
	}
	
	@Test
	public void _Drone_Mobile_getCustomer() throws CustomerException {
		Customer customer = new DroneDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue(customer.getMobileNumber().equals(mobileVALID));
	}
	
	@Test
	public void _Drone_LocationX_getCustomer() throws CustomerException {
		Customer customer = new DroneDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertEquals(1, customer.getLocationX());
	}
	
	@Test
	public void Drone_LocationY_getCustomer() throws CustomerException {
		Customer customer = new DroneDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertEquals(1, customer.getLocationY());
	}
	
	@Test
	public void Drone_DroneDistanc_getCustomere() throws CustomerException {
		Customer customer = new DroneDeliveryCustomer(nameVALID, mobileVALID, 1, 1);
		Assert.assertTrue(Math.sqrt(customer.getLocationX()*customer.getLocationX() + customer.getLocationY()*customer.getLocationY()) == customer.getDeliveryDistance());
	}
}
