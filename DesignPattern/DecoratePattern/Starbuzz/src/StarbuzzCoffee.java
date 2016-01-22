
public class StarbuzzCoffee {
	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		beverage2 = new Whip(beverage2);

		System.out.println(beverage2.getDescription() + " $" + String.format("%.2f", beverage2.cost()));

		Beverage beverage3 = new Espresso();
		beverage3 = new Mocha(beverage3);
		beverage3 = new Mocha(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

		Beverage beverage4 = new Mocha(beverage);
		System.out.println(beverage4.getDescription() + " $" + beverage4.cost());
	}
}
