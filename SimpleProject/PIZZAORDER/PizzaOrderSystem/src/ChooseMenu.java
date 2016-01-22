import java.util.Scanner;

public class ChooseMenu extends Pizza {

	public void selectPizza() {
		pizzaMenu();
	}

	public void pizzaMenu() {
		System.out.printf("The Base Menu:\n");
		for (Base b : Base.values()) {
			System.out.printf(b.toString() + " : " + b.base_price + "£\n");
		}
		System.out.printf("\n");
		System.out.printf("The Sauce Menu:\n");
		for (Source s : Source.values()) {
			System.out.printf(s.toString() + " : " + s.source_price + "£\n");
		}
		System.out.printf("\n");
		System.out.printf("The Toppings Menu:\n");
		for (Toppings t : Toppings.values()) {
			System.out.printf(t.toString() + " : " + t.top_price + "£\n");
		}
		pickBase();
		pickSource();
		pickToppings();
	}

	private void pickToppings() {
		System.out.printf("1.Ham 2.Chiken 3.Meatballs 4.Vegetable 5.Mushrooms 6.Bacon\n");
		Scanner sc = new Scanner(System.in);
		int pick = Integer.parseInt(sc.nextLine());
		switch (pick) {
		case 1:
			this.top = Toppings.Ham.toString();
			this.price_t = Toppings.Ham.top_price;
			break;
		case 2:
			this.top = Toppings.Chiken.toString();
			this.price_t = Toppings.Chiken.top_price;
			break;
		case 3:
			this.top = Toppings.Meatballs.toString();
			this.price_t = Toppings.Meatballs.top_price;
			break;
		case 4:
			this.top = Toppings.Vegetable.toString();
			this.price_t = Toppings.Vegetable.top_price;
			break;
		case 5:
			this.top = Toppings.Mushrooms.toString();
			this.price_t = Toppings.Mushrooms.top_price;
			break;
		case 6:
			this.top = Toppings.Bacon.toString();
			this.price_t = Toppings.Bacon.top_price;
			break;
		default:
			pickToppings();
		}

	}

	private void pickSource() {
		System.out.printf("1.BBQ 2.Cheese 3.Tikka 4.Ketchup\n");
		Scanner sc = new Scanner(System.in);
		int pick = Integer.parseInt(sc.nextLine());
		switch (pick) {
		case 1:
			this.source = Source.BBQ.toString();
			this.price_s = Source.BBQ.source_price;
			break;
		case 2:
			this.source = Source.Cheese.toString();
			this.price_s = Source.Cheese.source_price;
			break;
		case 3:
			this.source = Source.Tikka.toString();
			this.price_s = Source.Tikka.source_price;
			break;
		case 4:
			this.source = Source.ketchup.toString();
			this.price_s = Source.ketchup.source_price;
			break;
		default:
			pickSource();
		}

	}

	private void pickBase() {
		System.out.printf("1.Regular 2.Thin 3.Double 4.Dominator\n");
		Scanner sc = new Scanner(System.in);
		int pick = Integer.parseInt(sc.nextLine());
		switch (pick) {
		case 1:
			this.base = Base.Regular.toString();
			this.price_b = Base.Regular.base_price;
			break;
		case 2:
			this.base = Base.Thin.toString();
			this.price_b = Base.Thin.base_price;
			break;
		case 3:
			this.base = Base.Double.toString();
			this.price_b = Base.Double.base_price;
			break;
		case 4:
			this.base = Base.Dominator.toString();
			this.price_b = Base.Dominator.base_price;
			break;
		default:
			pickBase();
		}

	}

}
