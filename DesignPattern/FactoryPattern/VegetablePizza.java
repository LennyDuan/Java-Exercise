
public class VegetablePizza extends Pizza {

	PizzaIngredientFactory factory;
	public VegetablePizza(PizzaIngredientFactory factory) {
		super();
		this.factory = factory;
		toppings.add("Onions");
		toppings.add("Peppers");
		toppings.add("Corn");
		toppings.add("Peas");
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
