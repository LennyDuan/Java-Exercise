
public abstract class Pizza implements ChooseMethod{

	String base = " ", source = " ", top = " ";
	int price_b = 0, price_s = 0, price_t = 0;
	
	enum Base {
		Regular(9), Thin(10), Double(12), Dominator(15);
		int base_price;

		Base(int price) {
			this.base_price = price;
		}
	}

	enum Source {
		BBQ(2), Cheese(3), Tikka(3), ketchup(2);
		int source_price;

		Source(int price) {
			this.source_price = price;
		}
	}

	enum Toppings {
		Ham(5), Chiken(7), Meatballs(8), Vegetable(6), Mushrooms(5), Bacon(5);
		int top_price;

		Toppings(int price) {
			this.top_price = price;
		}
	}
	


}
