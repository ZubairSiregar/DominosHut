package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	// TO DO
	PizzaRestaurant restaurant;
	
	@Before
	public void initialise() throws CustomerException, PizzaException, LogHandlerException{
		restaurant = new PizzaRestaurant();
		restaurant.processLog("./logs/20170101.txt");
	}
	
	@Test
	public void ResetDetailsTest(){
		restaurant.resetDetails();
		assertEquals(0, restaurant.getNumPizzaOrders());
	}
	
	@Test
	public void TotalPizzaOrdersTest(){
		int expected = 3;
		assertEquals(expected, restaurant.getNumPizzaOrders());
	}
	
	@Test
	public void TotalProfitTest(){
		double expected = 36.5;
		assertEquals(expected, restaurant.getTotalProfit(), 0.001);
	}
	
	
}
