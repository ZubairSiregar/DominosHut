package asgn2Tests;

import org.junit.Test;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	
	private final String PICKUP = "PUC";
	private final String DELIVERY = "DVC";
	private final String DRONE = "DNC";
	private final String BAD_TYPE = "BAD";

	@Test(expected = CustomerException.class)
	public void BADTYPE_factory_createAbnormal() throws CustomerException {
		CustomerFactory.getCustomer(BAD_TYPE, "John", "0987654321", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void NULL_factory_createAbnormal() throws CustomerException {
		CustomerFactory.getCustomer(null, "John", "0987654321", 0, 0);
	}
	@Test
	public void DELIVERY_ZERO_factory_createNormal() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", 0, 0);
	}
	
	@Test
	public void DELIVERY_RightNumber_factory_createNormal() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", 3, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void null_factory_createAbnormal() throws CustomerException {
		CustomerFactory.getCustomer("", "John", "0987654321", 0, 0);
	}
	
	@Test
	public void PICKUP_factory_createNormal() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "John", "0987654321", 0, 0);
	}
	
	
	@Test
	public void DELIVERY_NEI_Number_factory_createNormal() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", -5, 0);
	}
	@Test
	public void factory_createNormal_Delivery_SameNumber() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", 5, 5);
	}
	
	@Test
	public void factory_createNormal_Drone_NerNumber5() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", 0, 5);
	}

	@Test
	public void DELIVERY_POSTNumber_factory_createNormal() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", 0, 5);
	}

	@Test
	public void factory_createNormal_Delivery_PostNeiNumber() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", 0, -5);
	}
	
	@Test
	public void factory_createNormal_NeiNumber6() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", 0, -5);
	}
	
	@Test
	public void factory_createNormal_Delivery_NeiNumber2() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", -5, 5);
	}
	
	@Test
	public void factory_createNormal_NeiNumber7() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", 5, 5);
	}
	@Test
	public void factory_createNormal_Delivery_Right_Number() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", 5, -5);
	}
	
	@Test
	public void factory_createNormal_Delivery_NeiNumber3() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "John", "0987654321", -5, -5);
	}
	@Test
	public void factory_createNormal_NeiNumber8() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", 5, -5);
	}
	
	@Test
	public void factory_createNormal_NeiNumber9() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", -5, 5);
	}
	
	@Test
	public void factory_createNormal_Drone_SameNeiNumber() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", -5, -5);
	}	
	
	@Test
	public void factory_createNormal_Drone_NeiNumber4() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "John", "0987654321", -5, 0);
	}
	
	
	

}
