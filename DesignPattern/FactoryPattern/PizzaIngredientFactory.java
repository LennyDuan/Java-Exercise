
//Abstract Factory
public interface PizzaIngredientFactory {
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	
	String getCookingInstructions();
	String getServingInstructions();
}
