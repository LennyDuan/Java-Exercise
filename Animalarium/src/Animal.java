/**
 * @author Hongyi Duan
 * @since 29/01/2015
 */
public class Animal {

	/**
	 * This class is built for animal. Each animal must have a keeper. Also an
	 * animal will be marked with the keeper's id and keeper's name. An animal
	 * includes 5 attributes: id, type, state, clean, feed.
	 */
	public Keeper keeper;
	public int keeper_id;
	public String keeper_name;

	public int id;
	public String type;

	private String state;
	private boolean clean;
	protected String feed;

	/**
	 * When create an animal, you have to add 4 params follow.
	 * 
	 * @param id
	 *            Id is the unique number fo animal
	 * @param state
	 *            State includes birth, death or new.
	 * @param type
	 *            There are 6 animals type in two enum clss.
	 * @param keeper
	 *            This animal belongs to keeper
	 */
	public Animal(int id, String state, String type, Keeper keeper) {
		super();
		this.id = id;
		this.state = state;
		this.type = type;
		this.keeper = keeper;
	}

	/**
	 * @return The String value that what the animal eat.
	 */
	public String getFeed() {
		return feed;
	}

	/**
	 * @param feed
	 *            Get the food String and give to value feed.
	 */
	public void setFeed(String feed) {
		this.feed = feed;
	}

	/**
	 * @return Return the int value ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Return true if the animal is cleaned by keeper
	 */
	public boolean getClean() {
		return true;
	}

	/**
	 * @param isClean
	 *            Give the boolean to value clean. This show the state of animal
	 *            clean or not.
	 */
	public void setClean(boolean isClean) {
		this.clean = isClean;
	}

	/**
	 * @param state
	 *            Set the animal's state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return This method is the animal's format when manager want to view all
	 *         keepers.
	 */
	public String toString() {
		return '\n' + "   Animal ID: " + id + "  Tyle: " + type + "  State: " + state;
	}

	/**
	 * @return This method is the format when save into a file.
	 */
	public String toSaveString() {
		return keeper.name + "   " + keeper.id + "   " + id + "   " + type + "   " + state + "   " + clean + "   "
				+ feed;
	}

	/**
	 * @return This method is the format when manager view all animals
	 */
	public String toListString() {

		return "| Animal ID: " + id + " | Keeper : " + keeper_name + " " + keeper_id + " | Type: " + type + " | State: "
				+ state + " |";
	}

	/**
	 * @return This method is the format when keeper view animals he takes care
	 *         of
	 */
	public String toDetailString() {
		return "Animal ID: " + id + '\n' + "Keeper : " + keeper.name + " " + keeper.id + '\n' + "Type: " + type + '\n'
				+ "State: " + state + '\n' + "Clean: " + clean + '\n' + "Feed: " + feed + '\n';
	}
}
