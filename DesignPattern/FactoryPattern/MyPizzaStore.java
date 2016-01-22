
public class MyPizzaStore extends PizzaStore {

	protected PizzaIngredientFactory myPIF;
	
	public MyPizzaStore() {
		// TODO Auto-generated constructor stub
		myPIF = new MyPizzaIngredientFactory();
	}
	public Pizza createPizza(String type) {
		Pizza p;
		if(type.equals("Cheese"))
		{
			p = new CheesePizza(myPIF);
			p.setName("My Cheese Pizza");
		}
		else if(type.equals("Custard"))
		{
			p = new CustardPizza(myPIF);
			p.setName("My Custard Pizza");
		}
		else
		{
			p = new CheesePizza(myPIF);
			p.setName("My Entry");
		}
		
		return p;
	}

	
}
