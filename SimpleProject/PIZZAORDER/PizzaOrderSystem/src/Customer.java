import java.util.ArrayList;

public class Customer {

	String name;
	int id;
	int amount;

	public ArrayList<List> list = new ArrayList<List>();
	

	public Customer(String string, int i, int j) {
		this.name = string;
		this.id = i;
		this.amount = j;
	}

	public void setAmount(int i) {
		this.amount = i;
	}
	public String toString() {
		return "Name: " + name + '\n' + "ID:" + id + '\n' + "List: \n" + list + '\n' + "Total Price: " + amount +'£';
	}
}
