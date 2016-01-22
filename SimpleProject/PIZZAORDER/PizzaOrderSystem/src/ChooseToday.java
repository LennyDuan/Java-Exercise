import java.util.Scanner;


public class ChooseToday extends Pizza{

	public void selectPizza() {
		pizzaToday();
	}
	public void pizzaToday() {
		System.out.println(
				"1. Base: Regualr/ Sauce: Cheese/ Topping: Chiken/ 19£ \n"
				+ "2. Base: Double/ Sauce: Tikka/ Topping: Meatballs/ 26£");
		Scanner sc = new Scanner(System.in);
		int pick = Integer.parseInt(sc.nextLine());
		if (pick == 1)
			TodayOne();
		else if (pick == 2)
			TodayTwo();
		else
			pizzaToday();
	}

	public void TodayOne() {
		this.base = Base.Regular.toString();
		this.price_b = Base.Regular.base_price;
		this.source = Source.Cheese.toString();
		this.price_s = Source.Cheese.source_price;
		this.top = Toppings.Chiken.toString();
		this.price_t = Toppings.Chiken.top_price;
		
	}

	public void TodayTwo() {
		this.base = Base.Dominator.toString();
		this.price_b = Base.Dominator.base_price;
		this.source = Source.Tikka.toString();
		this.price_s = Source.Tikka.source_price;
		this.top = Toppings.Meatballs.toString();
		this.price_t = Toppings.Meatballs.top_price;
	}

}
