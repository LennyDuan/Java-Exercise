
public class AberPizzaIngredientFactory implements PizzaIngredientFactory {

	public AberPizzaIngredientFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Dough createDough() {
		return new ThickCrust();
	}

	@Override
	public Sauce createSauce() {
		return new TomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new WelshChedderCheese();
	}

	@Override
	public String getCookingInstructions() {
		return "Flaming in the breath of a dragon";
	}

	@Override
	public String getServingInstructions() {
		return "Using dragon cutter to cut out dragon slices, and placing on plate";
	}

}
