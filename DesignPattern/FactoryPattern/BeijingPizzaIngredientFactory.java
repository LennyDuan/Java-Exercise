
public class BeijingPizzaIngredientFactory implements PizzaIngredientFactory {

	public BeijingPizzaIngredientFactory() {
	}

	@Override
	public Dough createDough() {
		return new ThinCrust();
	}

	@Override
	public Sauce createSauce() {
		return new NagaSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public String getCookingInstructions() {
		return "Bake for 25 minutes at 180C";
	}

	@Override
	public String getServingInstructions() {
		return "Place on a place and cut into squares";
	}

}
