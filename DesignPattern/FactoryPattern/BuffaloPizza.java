
public class BuffaloPizza extends Pizza {

	PizzaIngredientFactory factory;
	public BuffaloPizza(PizzaIngredientFactory factory) {
		super();
		this.factory = factory;
		toppings.add("Buffalo");
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
