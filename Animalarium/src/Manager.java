
/**
 * @author Hongyi Duan
 * @see
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

	/**
	 * This class is the manager class. A manager will have his name. Also a
	 * manager will have two arraylist, one for keepers and second for
	 * all_animal
	 */
	private String name;
	public ArrayList<Animal> all_animal = new ArrayList<Animal>();
	public ArrayList<Keeper> keepers = new ArrayList<Keeper>();

	public Manager(String name) {
		super();
		this.name = name;
	}

	/**
	 * This method will show all keepers in the keepers list
	 */
	public void viewKeeper() {
		for (Keeper keeper : keepers)
			System.out.println(keeper);
	}

	/**
	 * The method will add a new keeper to the keepers list A keeper must have
	 * his name and id number
	 * 
	 * @param name
	 * @param id
	 */
	public void addKeeper(String name, int id) {
		Keeper keeper = new Keeper(name, id);
		keepers.add(keeper);
	}

	/**
	 * Manager can delet keeper in the keepers list by keeper's id
	 * 
	 * @param id
	 */
	public void deleteKeeper(int id) {

		boolean findID = false;
		int index = 0;
		for (Keeper keeper : keepers) {
			if (id == keeper.id) {
				index = keepers.indexOf(keeper);
				findID = true;
			}
		}
		if (findID) {
			keepers.remove(index);
		} else {
			System.out.println("Invalid Input.");
		}
	}

	/**
	 * This is an index finding method to find the where animal is in all_animal
	 * list.
	 * 
	 * @param input_id
	 *            Input a id you want to find
	 * @return Return where is the animal in arraylist
	 */
	public int animalIndex(int input_id) {
		int result = 0;
		boolean find = false;
		for (Animal animal : all_animal) {
			if (input_id == animal.id) {
				result = all_animal.indexOf(animal);
				find = true;
			}
		}
		if (find == true)
			return result;
		else
			return 8023;
	}

	/**
	 * This is an index finding method to find the where keeper is in keepers
	 * list.
	 * 
	 * @param input_id
	 *            Input a keeper id you want to find
	 * @return Return where is the keeper in list
	 */
	public int keeperIndex(int input_id) {
		boolean findID = false;
		int index = 0;
		;
		for (Keeper keeper : keepers) {
			if (input_id == keeper.id) {
				index = keepers.indexOf(keeper);
				findID = true;
			}
		}
		if (findID) {
			return index;
		} else {
			return 8023;
		}
	}

	/**
	 * Display the animals in different ways. 7 choices will show the animal
	 * list from the all_animal arraylist
	 * 
	 * @param choose
	 *            Input a choose number
	 */
	public void viewAnimal(int choose) {
		switch (choose) {
		case 1:
			for (Animal animal : all_animal)
				System.out.println(animal.toListString());
			break;
		case 2:
			for (Animal animal : all_animal) {
				if (animal.type.equals(CatType.TIGER.name())) {
					System.out.println(animal.toListString());
				}
			}
			break;
		case 3:
			for (Animal animal : all_animal) {
				if (animal.type.equals(CatType.LEOPARD.name()))
					System.out.println(animal.toListString());
			}
			break;
		case 4:
			for (Animal animal : all_animal) {
				if (animal.type.equals(CatType.LYNX.name()))
					System.out.println(animal.toListString());
			}
			break;
		case 5:
			for (Animal animal : all_animal) {
				if (animal.type.equals(PrimateType.MARMOSET.name()))
					System.out.println(animal.toListString());
			}
			break;
		case 6:
			for (Animal animal : all_animal) {
				if (animal.type.equals(PrimateType.CAPUCHIN.name()))
					System.out.println(animal.toListString());
			}
			break;
		case 7:
			for (Animal animal : all_animal) {
				if (animal.type.equals(PrimateType.QEUIRREL.name()))
					System.out.println(animal.toListString());
			}
			break;
		}

	}

	/**
	 * The method will save the keepers list and all_animal list into two File
	 * "Animal.txt" and "Keeper.txt" when you exist the program
	 * 
	 * @throws IOException
	 *             Will throw input and output exception when save the file
	 */
	public void saveFile() throws IOException {

		PrintWriter pw = new PrintWriter(new FileOutputStream("Animal.txt"));
		for (Animal animal : all_animal)
			pw.println(animal.toSaveString());
		pw.close();

		PrintWriter pw2 = new PrintWriter(new FileOutputStream("Keeper.txt"));
		for (Animal animal : all_animal) {
			pw2.println(animal.keeper.toSaveString());
		}
		pw2.close();

	}

	/**
	 * The method will read the keepers list and all_animal list into two File
	 * "Animal.txt" and "Keeper.txt" when you exist the program
	 * 
	 * Read "Keeper.txt" file first and save keeper in a arraylist Then read
	 * "Animal.txt" to save into the all_animal list
	 * 
	 * @throws IOException
	 *             Will throw input and output exception when save the file
	 */
	public void readFile() throws IOException, FileNotFoundException {
		File theKeeperFile = new File("Keeper.txt");
		Scanner inputKeeper = new Scanner(theKeeperFile);
		while (inputKeeper.hasNext()) {
			String keeper_name = inputKeeper.next();
			int keeper_id = inputKeeper.nextInt();
			boolean find = false;
			for (Keeper keeper : keepers) {
				if (keeper.id == keeper_id)
					find = true;
			}
			if (find == false) {
				addKeeper(keeper_name, keeper_id);
			}
		}
		inputKeeper.close();

		File theAnimalFile = new File("Animal.txt");
		Scanner inputAnimal = new Scanner(theAnimalFile);
		while (inputAnimal.hasNext()) {
			String keeper_name = inputAnimal.next();
			int keeper_id = inputAnimal.nextInt();
			int animal_id = inputAnimal.nextInt();
			String type = inputAnimal.next();
			String state = inputAnimal.next();
			boolean clean = inputAnimal.nextBoolean();
			String food = inputAnimal.next();
			Keeper keeper = new Keeper(keeper_name, keeper_id);

			Animal animal = new Animal(animal_id, state, type, keeper);
			animal.keeper_id = keeper_id;
			animal.keeper_name = keeper_name;
			animal.setClean(clean);
			animal.setFeed(food);

			for (Keeper keeper_add_animal : keepers) {
				if (keeper_add_animal.id == keeper_id) {
					keeper_add_animal.addAnimal(animal);
				}
			}
			all_animal.add(animal);
		}

		inputAnimal.close();

	}

}
