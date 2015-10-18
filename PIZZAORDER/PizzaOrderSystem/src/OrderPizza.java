import java.util.ArrayList;
import java.util.Scanner;

public class OrderPizza {

	private ArrayList<Customer> cuslist = new ArrayList<Customer>();
	Customer cst = new Customer("Lenny Duan", 19454066, 0);
	int amount = 0;

	private void startOrder() {
		System.out.println(
				"1. Today Recommendation \n2. Check Menu and Pick Yourself" + "\n3. AddSnack" + "\n4. Show My Order\n");

		Scanner sc = new Scanner(System.in);
		int pick = Integer.parseInt(sc.nextLine());
		if (pick == 2)
			pickMenu();
		else if (pick == 1)
			pickToday();
		else if (pick == 3)
			addSnake();
		else if (pick == 4)
			printOrder();
		else
			startOrder();
	}

	private void addSnake() {
		ChooseSnack pc = new ChooseSnack();
		pc.selectPizza();
		
		List list = new List(null, null, null, 0);
		list.base = "Snack: " + pc.base;
		list.source = pc.source;
		list.money = pc.price_b;
		cst.list.add(list);
		amount += list.money;
		startOrder();
	}

	private void pickMenu() {
		ChooseMenu pc = new ChooseMenu();
		pc.selectPizza();
		List list = new List(null, null, null, 0);
		list.base = "Pizza:   " + pc.base;
		list.source = pc.source;
		list.topping = pc.top;
		list.money = pc.price_b + pc.price_s + pc.price_t;
		cst.list.add(list);
		amount += list.money;
		startOrder();
	}

	private void pickToday() {
		ChooseToday pc = new ChooseToday();
		pc.selectPizza();
		List list = new List(null, null, null, 0);
		list.base = "Pizza:   " + pc.base;
		list.source = pc.source;
		list.topping = pc.top;
		list.money = pc.price_b + pc.price_s + pc.price_t;
		cst.list.add(list);
		amount += list.money;
		startOrder();

	}

	private void printOrder() {

		cst.setAmount(amount);
		cuslist.add(cst);
		for (Customer cus : cuslist)
			System.out.println(cus);
		startOrder();
	}

	public static void main(String[] args) {
		System.out.println("Welcome To LOVEPIZA!\n");

		OrderPizza op = new OrderPizza();
		op.startOrder();
	}

}
