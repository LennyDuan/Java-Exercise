
import java.util.ArrayList;

public abstract class Pizza {

	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Cheese cheese;
	protected ArrayList<String> toppings;
	
	public Pizza()
	{
		toppings = new ArrayList<String>(2);
	}


	public void prepare()
	{
		System.out.println("Preparing " + name);
		System.out.println("Tossing " + dough);
		System.out.println("Adding " + sauce);
		System.out.println("Adding " + cheese);
		System.out.println("Adding toppings:");
		for(String s : toppings)
		{
			System.out.println("\t" + s);
		}
	}
	
	public abstract void bake();
	
	public abstract void serve();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString()
	{
		return "mmmmm, tasty pizza";
	}
}
