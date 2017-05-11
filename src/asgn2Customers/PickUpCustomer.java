package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to collect their pizza at the restaurant. 
 *  This class extends the abstract Customer class. Since the customer is at the restaurant the delivery 
 *  distance should be zero.  A description of the class's fields and their constraints is provided 
 *  in Section 5.2 of the Assignment Specification.
 *
 * @author Person B
 *
 */
public class PickUpCustomer extends Customer {

	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to pickup their pizza at the restaurant. 
	 *  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment Specification are violated. 
	 *  
	 * <P> PRE: TRUE
 	 * <P> POST: All field values are set
	 *  
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public PickUpCustomer(String name, String mobileNumber, int locationX,  int locationY) throws CustomerException {
		// TO DO	
	}

	/**
	 *  Overrides DeliveryDistance() in Customer. Since the customer is at the restaurant the delivery distance should be zero. 
	 *  
     * @return The value 0
	 */
	@Override
	public double getDeliveryDistance() {
		// TO DO
	}

}
