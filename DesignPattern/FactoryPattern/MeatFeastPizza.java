
public class MeatFeastPizza extends Pizza {

	PizzaIngredientFactory factory;
	public MeatFeastPizza(PizzaIngredientFactory factory) {
		super();
		this.factory = factory;
		toppings.add("Buffalo");
		toppings.add("Ham");
		toppings.add("Pepperoni");
		toppings.add("Beef");
		toppings.add("Chicken");
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
