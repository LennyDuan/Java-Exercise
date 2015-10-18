
public class List {

	String base;
	String source;
	String topping;
	int money;

	public List(String base, String source, String topping, int money) {
		super();
		this.base = base;
		this.source = source;
		this.topping = topping;
		this.money = money;
	}
	
	public String toString() {
		return "\n" + base + " " + source + " " + topping + " /" + money + "£\n";
	}

}
