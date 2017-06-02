package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.VegetarianPizza;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		// TO DO
		ArrayList<Customer> customers = new ArrayList<Customer>();
		BufferedReader br = null;
		
		try{
			String line;
			br = new BufferedReader(new FileReader(filename));
			while((line = br.readLine()) != null){
				customers.add(createCustomer(line));
			}
			br.close();
		} catch (Exception e){
			e.printStackTrace();
			throw new LogHandlerException("Problem reading lines from file");
		}
		return customers;
	}	
		
			

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		// TO DO
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		String path = LogHandler.class.getResource("").getPath();
		File inFile = new File(path +"filename");
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inFile));
            String line;
            while ((line = br.readLine()) != null) {
            	pizzas.add(createPizza(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }
        return pizzas;
		
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		// TO DO
		String[] entries = line.split(",");
		if(entries.length != 9){
			throw new LogHandlerException("Problem paarsing line from log file");
		}
		
		
		String name = entries[2];
		String mobileNumber = entries[3];
		String customerCode = entries[4];
		int locationX = Integer.parseInt(entries[5]);
		int locationY = Integer.parseInt(entries[6]);
		
		
		return CustomerFactory.getCustomer(customerCode, name, mobileNumber, locationX, locationY);
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		// TO DO
		Pizza createdPizza;
		String orderTime = line.split(",")[0];
    	String deliveryTime = line.split(",")[1];
    	String name = line.split(",")[2];
    	String mobile = line.split(",")[3];
    	String code = line.split(",")[4];
    	String xLocation = line.split(",")[5];
    	String yLocation = line.split(",")[6];
    	String pizzaCode = line.split(",")[7];
    	String pizzaQuantity = line.split(",")[8];
		if(pizzaCode.equals("PZM")){
    		MargheritaPizza PZM = new MargheritaPizza(Integer.parseInt(pizzaQuantity), LocalTime.parse(orderTime), LocalTime.parse(deliveryTime));
    		createdPizza = PZM;
    	} else if(pizzaCode.equals("PZV")){
    		VegetarianPizza PZV = new VegetarianPizza(Integer.parseInt(pizzaQuantity), LocalTime.parse(orderTime), LocalTime.parse(deliveryTime));
    		createdPizza = PZV;
    	} else if(pizzaCode.equals("PZL")){
    		MeatLoversPizza PZL = new MeatLoversPizza(Integer.parseInt(pizzaQuantity), LocalTime.parse(orderTime), LocalTime.parse(deliveryTime));
    		createdPizza = PZL;
    	} else{
    		throw new PizzaException("Wrong pizza code");
    	}
		return createdPizza;
		
	}

}
