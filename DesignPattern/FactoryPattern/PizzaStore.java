
public abstract class PizzaStore {

	public PizzaStore() {
		// TODO Auto-generated constructor stub
	}

	
	public Pizza orderPizza(String type)
	{
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.serve();
		
		return pizza;
	}
	
	public abstract Pizza createPizza(String type);	//Factory method
}
