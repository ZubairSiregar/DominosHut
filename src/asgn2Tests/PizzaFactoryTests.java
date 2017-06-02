package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.PizzaTopping;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Zubair Siregar
 * 
 */
public class PizzaFactoryTests {
	// TO DO
	Pizza veggie, meat, marg;
	
	@Before
	public void Initialise() throws PizzaException{
		veggie = PizzaFactory.getPizza("PZV", 4, LocalTime.parse("22:23:11"),LocalTime.parse("22:42:01"));
		meat = PizzaFactory.getPizza("PZL", 2, LocalTime.parse("19:35:00"),LocalTime.parse("20:00:00"));
		marg = PizzaFactory.getPizza("PZM", 2, LocalTime.parse("22:00:00"),LocalTime.parse("22:15:00"));
	}
	
	@Test
	public void VegetarianTypeTest(){
		String expected = "Vegetarian";
		assertEquals(expected, veggie.getPizzaType());
	}
	
	@Test
	public void MeatTypeTest(){
		String expected = "Meat Lovers";
		assertEquals(expected, meat.getPizzaType());
	}
	
	@Test
	public void MargheritaTypeTest(){
		String expected = "Margherita";
		assertEquals(expected, marg.getPizzaType());
	}
	
	@Test
	public void MeatLoversToppingTest(){
		assert(meat.containsTopping(PizzaTopping.BACON));
	}
	@Test
	public void VegetarianToppingTest(){
		assert(veggie.containsTopping(PizzaTopping.CAPSICUM));
	}
	@Test
	public void MargheritaToppingTest(){
		assert(marg.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void VegetarianProfit(){
		double expected = 18.0;
		assertEquals(expected, veggie.getOrderProfit(), 0.001);
	}
	
	@Test
	public void MeatLoversProfit(){
		double expected = 14.0;
		assertEquals(expected, meat.getOrderProfit(), 0.001);
	}
	
	@Test
	public void MargheritaProfit(){
		double expected = 13.0;
		assertEquals(expected, marg.getOrderProfit(), 0.001);
	}
	
	@Test
	public void VegetarianOrderPriceTest(){
		double expected = 40.0;
		assertEquals(expected, veggie.getOrderPrice(), 0.001);
	}
	
	@Test
	public void MeatLoversOrderPriceTest(){
		double expected = 24.0;
		assertEquals(expected, meat.getOrderPrice(), 0.001);
	}
	
	@Test
	public void MargheritaOrderPriceTest(){
		double expected = 16.0;
		assertEquals(expected, marg.getOrderPrice(), 0.001);
	}
	
	@Test
	public void OrderCostTest(){
		assertEquals(22.0, veggie.getOrderCost(), 0.001);
		assertEquals(20.0, meat.getOrderCost(), 0.001);
		assertEquals(6.0, marg.getOrderCost(), 0.001);
	}
	
	@Test
	public void CostPerPizzaTest(){
		assertEquals(5.5, veggie.getCostPerPizza(), 0.001);
		assertEquals(5.0, meat.getCostPerPizza(), 0.001);
		assertEquals(1.5, marg.getCostPerPizza(), 0.001);
	}
	
}
