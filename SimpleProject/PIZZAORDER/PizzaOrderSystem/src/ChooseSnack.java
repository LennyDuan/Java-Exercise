import java.util.Scanner;

public class ChooseSnack extends Pizza {
	enum Snack {
		Pancake(5), Fries(4), Drink(2), Salad(3);
		int snack_price;

		Snack(int price) {
			this.snack_price = price;
		}
	}

	public void selectPizza() {
		snackMenu();
	}

	private void snackMenu() {
		// TODO Auto-generated method stub
		for (Snack s : Snack.values()) {
			System.out.printf(s.toString() + " : " + s.snack_price + "£\n");
		}
		selectSnack();

	}

	private void selectSnack() {
		System.out.printf("1.Pancake 2.Fries 3.Drink 4.Salad\n");
		Scanner sc = new Scanner(System.in);
		int pick = Integer.parseInt(sc.nextLine());
		switch (pick) {
		case 1:
			this.source = Snack.Pancake.toString();
			this.price_b = Snack.Pancake.snack_price;
			break;
		case 2:
			this.source = Snack.Fries.toString();
			this.price_b = Snack.Fries.snack_price;
			break;
		case 3:
			this.source = Snack.Drink.toString();
			this.price_b = Snack.Drink.snack_price;
			break;
		case 4:
			this.source = Snack.Salad.toString();
			this.price_b = Snack.Salad.snack_price;
			break;
		default:
			selectSnack();
		}
	}
}
