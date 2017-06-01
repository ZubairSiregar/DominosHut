package asgn2Restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;

/**
 * This class acts as a �model� of a pizza restaurant. It contains an ArrayList of Pizza objects and an ArrayList of  Customer objects.
 *  It contains a method that can populate the ArrayLists,  several methods to retrieve information about the ArrayLists and 
 *  a method to reset the array list. Information about the x and y location of the restaurant and the time that first and last 
 *  orders are accepted are listed in Section 5 of the Assignment Specification. 
 *  
 *  Any exceptions raised by one of the methods called by this class should be passed to asgn2GUIs.PizzaGUI so that it can be shown to
 *  the user.
 * 
 * @author Person A and Person B
 *
 */
public class PizzaRestaurant {

	private ArrayList<Customer> customers;
	private ArrayList<Pizza> pizzas;

	
	/**
	 * Creates an instance of the PizzaRestaurant and sets the customers and pizzas fields to
	 * an appropriate initial empty state. 
	 * 
	 * <P> PRE: TRUE
	 * <P> POST: The customers and pizzas fields are initialized to an empty state
	 * 
	 */
	public PizzaRestaurant() {
		// TO DO
		this.customers = new ArrayList<Customer>();
		this.pizzas = new ArrayList<Pizza>();
	}

	/**
	 * This method processes the information contained in the log file and populates the customers and pizzas fields.  
	 * The other classes that the method interacts with are listed in Section 11 of the specification document. 
     *
     * <P> PRE: TRUE
     * <P>POST: If no exception is thrown then the customers and pizzas fields are populated with the details in the log file ordered as they appear in the log file.
     * <P>      If an exception is thrown then the customers and pizzas fields should be empty.
     * 
	 * @param filename The log's filename
	 * @return true if the file was processed correctly 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above (passed by another class).
     *
	 */
	public boolean processLog(String filename) throws CustomerException, PizzaException, LogHandlerException{
		// TO DO
		String path = LogHandler.class.getResource("").getPath();
		File inFile = new File(path +"filename");
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inFile));
            String line;
            while ((line = br.readLine()) != null) {
            	String orderTime = line.split(",")[0];
            	timeChecker(orderTime);
            	
            	String deliveryTime = line.split(",")[1];
            	timeChecker(deliveryTime);
            	
            	String name = line.split(",")[2];
            	nameChecker(name);
            	
            	String mobile = line.split(",")[3];
            	phoneChecker(mobile);
            	
            	String code = line.split(",")[4];
            	codeChecker(code);
            	
            	String xLocation = line.split(",")[5];
            	String yLocation = line.split(",")[6];
            	locationChecker(xLocation, yLocation);
            	
            	String pizzaCode = line.split(",")[7];
            	if(pizzaCode != "PZM" && pizzaCode != "PZV" && pizzaCode != "PZL"){
        	    	throw new PizzaException("wrong value for " + pizzaCode);
            	}
            	
            	String pizzaQuantity = line.split(",")[8];
            	quantityChecker(pizzaQuantity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }
        
        return true;
	}

	/**
	 * Returns the Customer object contained at the specified index of the customers field. The index should be the same as the index in the log file.
	 * @param index - The index within the customers field to retrieve.
	 * @return The Customer object located at the specified index.
	 * @throws CustomerException if index is invalid.
	 */
	public Customer getCustomerByIndex(int index) throws CustomerException{
		// TO DO
		if(index > customers.size() - 1){
			throw new CustomerException("Wrong index");
			
		}
		return customers.get(index);
	}
	
	/**
	 * Returns the Pizza object contained at the specified index of the pizzas field. The index should be the same as the index in the log file.
	 * @param index - The index within the pizzas field to retrieve.
	 * @return The Pizza object located at the specified index.
	 * @throws PizzaException if index is invalid.
	 */	
	public Pizza getPizzaByIndex(int index) throws PizzaException{
		// TO DO
		if(this.pizzas.size() > index){
			throw new PizzaException("Wrong index");
		} 
		return pizzas.get(index);
	}
	
	/**
	 * Returns the number of objects contained in the pizzas field. This value SHOULD be the same as 
	 * the value returned by getNumCustomerOrders.
	 * 
	 * @return the number of objects contained in the pizzas field.
	 */
	public int getNumPizzaOrders(){
		// TO DO
		return pizzas.size();
	}

	/**
	 * Returns the number of objects contained in the customers field. This value SHOULD be the same as 
	 * the value returned by getNumPizzaOrders.
	 * 
	 * @return the number of objects contained in the customers field.
	 */
	public int getNumCustomerOrders(){
		// TO DO
		return customers.size();
	}

			
	
	/**
	 * Returns the total delivery distance for all of the customers.
	 * 
	 * @return the total delivery distance for all Customers objects in the customers field.
	 */
	public double getTotalDeliveryDistance(){
		// TO DO
		double totalDistance = 0;
		for(Customer custom: customers){
			totalDistance += custom.getDeliveryDistance();
		}
		return totalDistance;
	}

	/**
	 * Returns the total profit for all of the pizza orders.
	 * 
	 * @return the total profit for all of the Pizza objects in the pizzas field.
	 */	
	public double getTotalProfit(){
		// TO DO
		double totalProfit = 0;
		for(Pizza p : pizzas){
			totalProfit =+ p.getOrderProfit();
		}
		return totalProfit;
	}
	
	/**
	 * Resets the pizzas and customers fields to their initial empty states.
	 * 
	 * <P> PRE: True
	 * <P> POST:  The pizzas and customers fields are set to their initial empty states
	 */
	public void resetDetails(){
		// TO DO
		this.pizzas.clear();
		this.customers.clear();
	}
	
	public static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	 }
	
	public static boolean timeChecker(String s) throws CustomerException, PizzaException, LogHandlerException{
	    if(s.split(":").length != 3){
	    	throw new LogHandlerException("wrong value for " + s);
	    }
	    String[] time = new String[3];
	    
	    for(int i = 0; i < s.split(":").length; i++){
	    	time[i] = s.split(":")[i];
	    }
	    
	    for(int i = 0; i < time.length; i++){
	    	if(isStringDouble(time[i]) == false){
		    	throw new LogHandlerException("wrong value for " + s);
	    	}
	    }
	    
	    return true;
	 }
	
	public static boolean nameChecker(String s) throws CustomerException, PizzaException, LogHandlerException{
		if(s.split(" ").length != 2){
	    	throw new CustomerException("wrong value for " + s);
	    }
		
		return true;
	}
	
	public static boolean phoneChecker(String s) throws CustomerException, PizzaException, LogHandlerException{
		if(s.length() != 10){
	    	throw new CustomerException("wrong value for " + s);
	    }
		
		if(isStringDouble(s) == false){
	    	throw new CustomerException("wrong value for " + s);
		}
		
		return true;
	}
	
	public static boolean codeChecker(String s) throws CustomerException, PizzaException, LogHandlerException{
		if(s.length() != 3){
	    	throw new CustomerException("wrong value for " + s);
	    }
		
		return true;
	}
	
	public static boolean locationChecker(String x, String y) throws CustomerException, PizzaException, LogHandlerException{
		if(isStringDouble(x) == false || isStringDouble(y) == false){
	    	throw new CustomerException("wrong value for locations");
	    }
		
		return true;
	}
	
	public static boolean quantityChecker(String s) throws CustomerException, PizzaException, LogHandlerException{
		if(isStringDouble(s) == false){
	    	throw new CustomerException("wrong value for locations");
	    }
		
		if(Integer.parseInt(s) > 10){
	    	throw new CustomerException("wrong value for locations");
		}
		
		return true;
	}

}
