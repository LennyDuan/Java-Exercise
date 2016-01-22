
/*
 * This example is based on the Abstract Factory and Factory method
 * example project from Head First Design Patterns
 */
public class test {
	public static void main(String args[])
	{
		PizzaStore aberStore = new AberPizzaStore();
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore bStore = new BeijingPizzaStore();
		PizzaStore myStore = new MyPizzaStore();

		Pizza pizza = aberStore.orderPizza("Custard");
		System.out.println("Bernard ordered a " + pizza.getName() + " from Aber store\n");
		
		pizza = nyStore.orderPizza("Buffalo");
		System.out.println("Tom ordered a " + pizza.getName() + " from NY store\n");
		
		pizza = bStore.orderPizza("Vegetable");
		System.out.println("Boychun ordered a " + pizza.getName() + " from Beijing store\n\n\n\n\n");
		
	    pizza = myStore.orderPizza("Cheese");
		System.out.println("I ordered a " + pizza.getName() + " from My store\n");

		
	}
}
