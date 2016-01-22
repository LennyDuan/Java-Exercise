
public class BeijingPizzaStore extends PizzaStore{

	protected PizzaIngredientFactory bPIF;
	public BeijingPizzaStore() {
		bPIF = new BeijingPizzaIngredientFactory();
	}

	public Pizza createPizza(String type)
	{
		Pizza p;
		if(type.equals("Cheese"))
		{
			p = new CheesePizza(bPIF);
			p.setName("Beijing Cheese Pizza");
		}
		else if(type.equals("Vegetable"))
		{
			p = new VegetablePizza(bPIF);
			p.setName("Beijing Vegetable Pizza");
		}
		else
		{
			p = new CheesePizza(bPIF);
			p.setName("Beijing Entry");
		}
		
		return p;
	}
}
