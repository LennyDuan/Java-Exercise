
public class CustardPizza extends Pizza {

	PizzaIngredientFactory factory;
	public CustardPizza(PizzaIngredientFactory factory) {
		super();
		this.factory = factory;
		toppings.add("Custard");
	}
	
	public void prepare(){
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
		super.prepare();
	}
	
	public void bake()
	{
		System.out.println(factory.getCookingInstructions());
	}
	
	public void serve()
	{
		System.out.println(factory.getServingInstructions());
	}

}
