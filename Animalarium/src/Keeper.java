
/**
 * 
 * @author Hongyi Duan
 * @see java.util.ArrayList
 *
 */
import java.util.ArrayList;

public class Keeper {

	/**
	 * The Keeper has his own name and unique ID number. Also a keeper can have
	 * lots of animal. So he will have an arraylist to put his animal
	 */
	public String name;
	public int id;
	public ArrayList<Animal> animals = new ArrayList<Animal>();

	/**
	 * When create a keeper, value String and int must be put in)
	 * 
	 * @param name
	 * @param id
	 */
	public Keeper(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	/**
	 * This method will add animal object to animals arraylist
	 * 
	 * @param animal
	 */
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	/**
	 * This method will let keeper choose an animal to feed food
	 * 
	 * @param animal
	 * @param food
	 * @return
	 */
	public void feed(Animal animal, String food) {
		animal.setFeed(food);
	}

	/**
	 * This method will let keeper to feed a big cat.
	 * 
	 * @param cat
	 */
	public void feedCat(Cat cat) {
		cat.setMeatFeed();
	}

	/**
	 * An keeper can use this method to feed primate animal.
	 * 
	 * @param primate
	 */
	public void feedPrimate(Primate primate) {
		primate.setFruitFeed();
	}

	/**
	 * This method will assignment true to show the animal is cleaned
	 * 
	 * @param animal
	 */
	public void clean(Animal animal) {
		boolean isClean = true;
		animal.setClean(isClean);
	}

	/**
	 * A loop to show all the animal details in the animals List
	 */
	public void viewAnimal() {
		for (Animal animal : animals) {
			System.out.println(animal.toDetailString());
		}
	}

	/**
	 * This will find the what is the index of the animal you want to find. When
	 * you input an animal id. This method will fine where it is in list.
	 * 
	 * @param input_id
	 * @return
	 */
	public int AnimalIndex(int input_id) {
		int result = 0;
		boolean find = false;
		for (Animal animal : animals) {
			if (input_id == animal.id) {
				result = animals.indexOf(animal);
				find = true;
			}
		}
		if (find == true)
			return result;
		else
			return 8023;
	}

	/**
	 * The method will delete the animal in the list.
	 * 
	 * @param id
	 */
	public void deleteAnimal(int id) {
		int index = 0;
		for (Animal animal : animals) {
			if (id == animal.id)
				index = animals.indexOf(animal);
		}
		animals.remove(index);
	}

	/**
	 * The keeper's format when manager want to see the informations about
	 * keeper.
	 */
	public String toString() {
		return "Keeper Name = " + name + ", Keeper Id = " + id + ", Animals = " + animals + '\n';
	}

	/**
	 * @return The format to save the keeper into a file
	 */
	public String toSaveString() {
		return name + "   " + id;
	}

}
