
public class MyPizzaIngredientFactory implements PizzaIngredientFactory{

	public MyPizzaIngredientFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Dough createDough() {
		// TODO Auto-generated method stub
		return new myDough();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new mySauce();
	}

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return new myCheese();
	}

	@Override
	public String getCookingInstructions() {
		// TODO Auto-generated method stub
		return "My cooking intructions";
	}

	@Override
	public String getServingInstructions() {
		// TODO Auto-generated method stub
		return "my serving instructions";
	}

}
