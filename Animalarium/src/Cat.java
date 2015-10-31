/**
 * 
 * @author Lenny
 * 
 */
public class Cat extends Animal {

	/**
	 * This class extend Animal class.
	 * 
	 * @param id
	 * @param state
	 * @param type
	 * @param keeper
	 */
	public Cat(int id, String state, String type, Keeper keeper) {
		super(id, state, type, keeper);
	}

	/**
	 * This method is to feed big cat animals.
	 */
	public void setMeatFeed() {
		super.feed = "Meat";
	}

}
