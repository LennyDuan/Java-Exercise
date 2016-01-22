
public class AberPizzaStore extends PizzaStore{

	protected PizzaIngredientFactory aPIF;
	public AberPizzaStore() {
		aPIF = new AberPizzaIngredientFactory();
	}

	public Pizza createPizza(String type)
	{
		Pizza p;
		if(type.equals("Cheese"))
		{
			p = new CheesePizza(aPIF);
			p.setName("Aber Cheese Pizza");
		}
		else if(type.equals("Custard"))
		{
			p = new CustardPizza(aPIF);
			p.setName("Aber Custard Pizza");
		}
		else
		{
			p = new CheesePizza(aPIF);
			p.setName("Aber Entry");
		}
		
		return p;
	}
}
