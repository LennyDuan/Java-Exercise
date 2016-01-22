
public class NYPizzaStore extends PizzaStore{

	protected PizzaIngredientFactory nyPIF;
	public NYPizzaStore() {
		nyPIF = new NYPizzaIngredientFactory();
	}

	public Pizza createPizza(String type)
	{
		Pizza p;
		if(type.equals("Cheese"))
		{
			p = new CheesePizza(nyPIF);
			p.setName("NY Cheese Pizza");
		}
		else if(type.equals("Buffalo"))
		{
			p = new BuffaloPizza(nyPIF);
			p.setName("NY Buffalo Pizza");
		}
		else if(type.equals("MeatFeast"))
		{
			p = new MeatFeastPizza(nyPIF);
			p.setName("NY Meat Feast Pizza");
		}
		else
		{
			p = new CheesePizza(nyPIF);
			p.setName("NY Entry");
		}
		
		return p;
	}
}
