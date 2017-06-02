package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// TO DO
	VegetarianPizza veggie;
	MargheritaPizza marg;
	MeatLoversPizza meat;
	
	@Before
	public void beforeTests() throws PizzaException, CustomerException, LogHandlerException{
		veggie = new VegetarianPizza(2, LocalTime.parse("21:00:00"), LocalTime.parse("21:20:20"));
		marg = new MargheritaPizza(5, LocalTime.parse("20:30:00"), LocalTime.parse("20:54:20"));
		meat = new MeatLoversPizza(1, LocalTime.parse("19:15:00"), LocalTime.parse("19:30:20"));
	}
	
	@Test
	public void ToppingTest(){
		assert(veggie.containsTopping(PizzaTopping.CAPSICUM));
		assert(veggie.containsTopping(PizzaTopping.MUSHROOM));
		assert(veggie.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	@Test
	public void PizzaFlavourTest(){
		String expected = "Vegetarian";
		assertEquals(veggie.getPizzaType(), expected);
	}
	
	@Test
	public void QuantityTest(){
		int expected = 2;
		assertEquals(expected, veggie.getQuantity());
	}
	
	@Test
	public void CostPerPizzaTest(){
		double expected = 5.5;
		assertEquals(expected, veggie.getCostPerPizza(), 0.001);
	}
	
	@Test
	public void SalePricePerPizzaTest(){
		double expected = 10.0;
		assertEquals(expected, veggie.getPricePerPizza(), 0.001);
	}
	
	@Test
	public void OrderCostTest(){
		double expected = 11.0;
		assertEquals(expected, veggie.getOrderCost(), 0.001);
	}
	
	@Test
	public void OrderPriceTest(){
		double expected = 20.0;
		assertEquals(expected, veggie.getOrderPrice(), 0.001);
	}
	
	@Test
	public void OrderProfitTest(){
		double expected = 9.0;
		assertEquals(expected, veggie.getOrderProfit(), 0.001);
	}
	
	@Test (expected = PizzaException.class)
	public void QuantityException()throws PizzaException{
		MeatLoversPizza pizza = new MeatLoversPizza(13, LocalTime.parse("18:30:30"), LocalTime.parse("19:10:12"));
		pizza.getOrderPrice();
	}
	
	@Test (expected = PizzaException.class)
	public void LateDeliveryTest()throws PizzaException{
		MeatLoversPizza pizza = new MeatLoversPizza(13, LocalTime.parse("18:30:30"), LocalTime.parse("20:45:12"));
	
	}
		
	
}
