
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	public NYPizzaIngredientFactory() {
	}

	@Override
	public Dough createDough() {
		return new StuffedCrust();
	}

	@Override
	public Sauce createSauce() {
		return new BBQSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MontereyJackCheese();
	}

	@Override
	public String getCookingInstructions() {
		return "Bake for 25 minutes at 350F";
	}

	@Override
	public String getServingInstructions() {
		return "Place on a place and cut into 8 wedges";
	}

}
