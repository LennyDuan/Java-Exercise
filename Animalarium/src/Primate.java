/**
 * 
 * @author Lenny
 *
 */
public class Primate extends Animal{
	/**
	 * This class extends class Animal.
	 * @param id
	 * @param state
	 * @param type
	 * @param keeper
	 */
	public Primate(int id, String state, String type, Keeper keeper) {
		super(id, state, type, keeper);

	}
	
	/**
	 * This method is to feed primate animals.
	 */
	public void setFruitFeed(){
		this.feed = "Fruit";
	}
}
