package asgn2Pizzas;

/**
 * An enumeration that contains a set of pizza toppings and their associated cost.
 * It also contains a method to retrieve a cost for a specific topping. The toppings
 * and their costs are specified in the Assignment Specification in Section 5.1. 
 * 
 * @author Alan Woodley
 *
 */
public enum PizzaTopping {
	
	CHEESE(1),
	TOMATO(0.5),
	BACON(1.5),
	SALAMI(1), 
	PEPPERONI(1),
	CAPSICUM(1.2),
	MUSHROOM(2),
	EGGPLANT(0.8); 
	
	private double cost;
	
	/**
	 * A enumeration that represents a pizza topping 
	 * @param cost the cost of the pizza topping
	 */
	PizzaTopping(double cost){
		this.cost = cost;
	}

	/**
	 * Returns the cost of a topping
	 * @return the cost of the selected topping
	 */
	public double getCost(){
		return cost;
	}
	

}
