package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	// TO DO
	
	public ArrayList<Pizza> Pizzas;
	
	@Before
	public void initialise() throws PizzaException, LogHandlerException{
		Pizzas = LogHandler.populatePizzaDataset("./logs/20170101.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileExceptionTest() throws PizzaException, LogHandlerException{
		Pizzas = LogHandler.populatePizzaDataset("File not found");
	}
	
	
	@Test
	public void flavourTest(){
		String expected = "Margherita";
		assertEquals(Pizzas.get(1).getPizzaType(), expected);
	}
	
	@Test
	public void pizzaCostTest(){
		double expected = 1.5;
		assertEquals(expected,Pizzas.get(1).getOrderCost(), 0.001 );
	}
	
	@Test 
	public void pizzaSalePriceTest(){
		double expected = 8.0;
		assertEquals(expected, Pizzas.get(1).getOrderPrice(), 0.001);
	}
	
	@Test
	public void pizzaCostPerPizzaTest(){
		double expected = 8.0;
		assertEquals(expected, Pizzas.get(1).getPricePerPizza(), 0.001);
	}
	
	@Test
	public void pizzaProfitTest(){
		double expected = 6.5;
		assertEquals(expected, Pizzas.get(1).getOrderProfit(), 0.001);
	}
	
}
