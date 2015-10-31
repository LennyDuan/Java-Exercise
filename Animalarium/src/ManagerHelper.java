
/**
 * @author Lenny
 * @see
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class ManagerHelper {

	/**
	 * This class is manager helper to help run the program better. Also the
	 * main function is in this class fiel
	 */

	/**
	 * This method is the keyboard input when you type a int value
	 * 
	 * @return Return int value when call this function
	 */
	private int intKeyboardInput() {
		int input = 0;
		boolean tryAgain = true;
		while (tryAgain) {
			try {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextInt();
				tryAgain = false;
			} catch (InputMismatchException ime) {
				System.out.println("Invalid input.");
			}
		}
		return input;
	}

	/**
	 * This method is the keyboard input when you type a String value
	 * 
	 * @return Return String value when call this function
	 */
	private String stringKeyBoardInput() {
		String input = "";
		boolean tryAgain = true;
		while (tryAgain) {
			try {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();
				tryAgain = false;
			} catch (InputMismatchException ime) {
				System.out.println("Invalid input.");
			}
		}
		return input;
	}

	/**
	 * This is the start program method. Choose you are manager or keeper.
	 * 
	 * @return Return what is the choice and make system know who you are
	 */
	private int startSystem() {

		System.out.println("1: Manager  2: Zoo Keeper");
		int member = intKeyboardInput();

		boolean tryAgain = true;
		while (tryAgain) {

			if (member == 1) {
				System.out.println("Welcome Manager!");
				tryAgain = false;
			} else if (member == 2) {
				System.out.println("Welcome Zoo Keeper!" + '\n' + "Please Input Id Number: ");
				tryAgain = false;
			} else {
				System.out.println("Invalid Input.");
				member = intKeyboardInput();
			}
		}
		return member;
	}

	/**
	 * As a keeper you have lots of functions you can choose
	 * 
	 * @return Return a input function number
	 */
	private int KeeperChoose() {
		int input = 0;
		System.out.println("1: View enimals' Details");
		System.out.println("2: Add Animal");
		System.out.println("3: Delete Animal");
		System.out.println("4: Feed Animal");
		System.out.println("5: Clean Enclosure");
		System.out.println("9: Back to Start");
		System.out.println("0: Exit");
		input = intKeyboardInput();
		return input;
	}

	/**
	 * As a manager you have lots of functions you can choose
	 * 
	 * @return Return a input function number
	 */
	private int ManagerChoose() {
		int input = 0;
		System.out.println("1: View All Animals");
		System.out.println("2: View All Zoo Keeper");
		System.out.println("3: Add Zoo Keeper");
		System.out.println("4: Delete Zoo Keeper");
		System.out.println("5: Allocate Zoo Keepers to Ainimals");
		System.out.println("9: Back to Start");
		System.out.println("0: Exit");
		input = intKeyboardInput();
		return input;
	}

	/**
	 * This is the main function
	 * 
	 * @param args
	 * @throws IOException
	 *             This will throw input and output exception when read or save
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * Create a manager and helper. Read the file.
		 */
		Manager manager = new Manager("Borth Animalarium");
		System.out.println("Welcome Borth Animalarium System!");
		manager.readFile();
		ManagerHelper managerH = new ManagerHelper();

		/**
		 * The syetem will not finish unless you choose exit function
		 */
		boolean isContinue = true;
		while (isContinue) {
			int member = managerH.startSystem();
			int choose_m = 0, choose_k = 0;

			/**
			 * Here is when you are manager. You can choose what you want to do
			 * next
			 */
			if (member == 1) {
				boolean mContinue = true;

				/**
				 * Here is what manager can do.
				 * 
				 * @see ManagerChoose()
				 */
				while (mContinue) {
					choose_m = managerH.ManagerChoose();

					switch (choose_m) {

					/**
					 * View all Animals
					 */
					case 1:
						int choose = managerH.viewAllAnimalHelper();
						manager.viewAnimal(choose);
						break;

					/**
					 * view All Zoo Keeper
					 */
					case 2:
						manager.viewKeeper();
						break;

					/**
					 * Add Zoo Keeper
					 */
					case 3:
						System.out.println("Zoo Keeper Name: ");
						String name = managerH.stringKeyBoardInput();
						int id_add;
						for (;;) {
							System.out.println("Unique Keeper ID:   (0: Cancel)");
							// id_add = managerH.intKeyboardInput();
							id_add = managerH.IdRandom();
							boolean find_same = false;
							for (Keeper keeper_add : manager.keepers) {
								if (id_add == keeper_add.id)
									find_same = true;
								else if (id_add == 8023)
									find_same = true;
								else if (id_add == 0)
									break;
							}
							if (find_same == false)
								break;
						}
						if (id_add != 0) {
							System.out.println("Add Successful ID: " + id_add);
							manager.addKeeper(name, id_add);
						}
						break;

					/**
					 * Delete Zoo Keeper
					 */
					case 4:
						System.out.println("Input the Keeper ID:   (0: Cancel)");
						int id_delete = managerH.intKeyboardInput();
						if (id_delete != 0) {
							System.out.println("Delete Successful");
							manager.deleteKeeper(id_delete);
						}

						for (Animal animal : manager.all_animal) {
							if (animal.keeper_id == id_delete) {
								int index = manager.all_animal.indexOf(animal);
								manager.all_animal.get(index).keeper_id = 0;
								manager.all_animal.get(index).keeper_name = null;
							}
						}

						break;

					/**
					 * Allocate Zoo Keeper to Animals
					 */
					case 5:
						int move_from;
						Animal animal;

						boolean find_animal = true;
						while (find_animal == true) {
							System.out.println("Please Input the Animal ID:   (0: cancel)");
							int move_animal = managerH.intKeyboardInput();
							if (move_animal == 0)
								break;
							int index_move_animal = manager.animalIndex(move_animal);

							if (index_move_animal != 8023) {
								find_animal = false;
								animal = manager.all_animal.get(index_move_animal);

								System.out.println("Please Input the Keeper ID You Want to Move to.");
								int move_to = managerH.intKeyboardInput();

								move_from = animal.keeper_id;
								if (move_from != move_to) {

									int index_move_from = manager.keeperIndex(move_from);
									if (index_move_from != 8023) {
										Keeper keeper_from = manager.keepers.get(index_move_from);
										keeper_from.deleteAnimal(move_animal);
									}
									int index_move_to = manager.keeperIndex(move_to);
									if (index_move_to != 8023) {
										Keeper keeper_to = manager.keepers.get(index_move_to);

										animal.keeper = keeper_to;
										animal.keeper_id = keeper_to.id;
										animal.keeper_name = keeper_to.name;
										keeper_to.addAnimal(animal);

									} else
										find_animal = true;
								} else
									find_animal = true;
							}
						}

						break;

					/**
					 * Back to start
					 */
					case 9:
						mContinue = false;
						break;

					/**
					 * Exit
					 */
					case 0:
						System.out.println("Exit Successful.");
						mContinue = false;
						isContinue = false;
						break;
					default:
						System.out.println("Invalid input.");
						break;
					}
				}

			}

			/**
			 * 
			 * Here is when you choose you are keeper. After you input you id
			 * number You can choose what you want to do next
			 */

			else if (member == 2) {
				boolean findID = false;
				int id_keeper = managerH.intKeyboardInput();
				int keeper_index = 0;
				boolean kContinue = false;
				Keeper keeper;

				/**
				 * The id number you input will let the system know who you are
				 * Also can index where you are in the keepers list
				 * 
				 */
				for (Keeper keep : manager.keepers) {
					if (id_keeper == keep.id) {
						keeper_index = manager.keepers.indexOf(keep);
						findID = true;
					}
				}

				if (findID == false)
					System.out.println("Invalid input.");
				else {
					kContinue = true;
				}

				while (kContinue) {
					choose_k = managerH.KeeperChoose();
					keeper = manager.keepers.get(keeper_index);
					switch (choose_k) {

					/**
					 * View enimal's Details
					 */
					case 1:
						keeper.viewAnimal();
						break;

					/**
					 * Add Animal
					 */
					case 2:
						int id_add;
						for (;;) {
							boolean find_same = false;
							// System.out.println("Animal Unique ID: (0:
							// Cancel)");
							// id_add = managerH.intKeyboardInput();
							id_add = managerH.IdRandom();
							for (Animal animal : manager.all_animal) {
								if (id_add == animal.id)
									find_same = true;
								else if (id_add == 8023)
									find_same = true;
								else if (id_add == 0)
									find_same = true;
							}
							if (find_same == false)
								break;
						}

						if (id_add != 0) {
							String state = managerH.getAnimalState();
							System.out.println("Animal Type: ");
							String type = managerH.getAnimalType();
							System.out.println("1.TIGER 2.LEOPARD 3.LYNX" + '\n' + "4.MARMOSET 5.CAPUCHIN 6.QEUIRREL");

							if (type == "TIGER" || type == "LEOPARD" || type == "LYNX") {
								Cat cat = new Cat(id_add, state, type, keeper);
								cat.keeper_name = keeper.name;
								cat.keeper_id = keeper.id;
								if (id_add % 2 == 0)
									cat.setMeatFeed();
								keeper.addAnimal(cat);
								manager.all_animal.add(cat);
								System.out.println("You Have added Animal ID: " + id_add);

							} else if (type == "MARMOSET" || type == "CAPUCHIN" || type == "QEUIRREL") {
								Primate primate = new Primate(id_add, state, type, keeper);
								primate.keeper_name = keeper.name;
								primate.keeper_id = keeper.id;
								if (id_add % 2 == 0)
									primate.setFruitFeed();
								keeper.addAnimal(primate);
								manager.all_animal.add(primate);
								System.out.println("You Have added Animal ID: " + id_add);
							}

						}
						break;

					/**
					 * Delete Animal
					 */
					case 3:
						System.out.println("Delete Animal ID: ");
						int id_del = managerH.intKeyboardInput();

						int index_del_keeper = keeper.AnimalIndex(id_del);
						if (index_del_keeper != 8023) {
							keeper.animals.remove(index_del_keeper);
							System.out.println("You Have Deleted Animal ID: " + id_del);
						}

						int index_del_manager = manager.animalIndex(id_del);
						if (index_del_manager != 8023) {
							manager.all_animal.get(index_del_manager).keeper_id = 0;
							manager.all_animal.get(index_del_manager).keeper_name = null;

						}
						break;

					/**
					 * Feed Animal
					 */
					case 4:
						System.out.println("Feed Animal ID: ");
						int id_feed = managerH.intKeyboardInput();
						// String food;
						// System.out.println("Feed Food: ");
						// food = managerH.stringKeyBoardInput();
						int index_feed_keeper = keeper.AnimalIndex(id_feed);
						if (index_feed_keeper != 8023) {
							if (keeper.animals.get(index_feed_keeper).type.equals("TIGER")
									|| keeper.animals.get(index_feed_keeper).type.equals("LEOPARD")
									|| keeper.animals.get(index_feed_keeper).type.equals("LYNX")) {
								keeper.feed(keeper.animals.get(index_feed_keeper), "Meat");
							} else if (keeper.animals.get(index_feed_keeper).type.equals("MARMOSET")
									|| keeper.animals.get(index_feed_keeper).type.equals("QEUIRREL")
									|| keeper.animals.get(index_feed_keeper).type.equals(PrimateType.CAPUCHIN.name())) {
								keeper.feed(keeper.animals.get(index_feed_keeper), "Fruit");
							}

						}

						int index_feed_manager = manager.animalIndex(id_feed);
						if (index_feed_manager != 8023) {
							if (manager.all_animal.get(index_feed_manager).type.equals("TIGER")
									|| manager.all_animal.get(index_feed_manager).type.equals("LEOPARD")
									|| manager.all_animal.get(index_feed_manager).type.equals(CatType.LYNX.name())) {
								keeper.feed(manager.all_animal.get(index_feed_manager), "Meat");
							} else if (manager.all_animal.get(index_feed_manager).type.equals("MARMOSET")
									|| manager.all_animal.get(index_feed_manager).type.equals("QEUIRREL")
									|| manager.all_animal.get(index_feed_manager).equals(PrimateType.CAPUCHIN.name())) {
								keeper.feed(manager.all_animal.get(index_feed_manager), "Fruit");
							}
						}
						break;

					/**
					 * Clean Enclosure
					 */
					case 5:
						System.out.println("Clean Animal ID: ");
						int id_clean = managerH.intKeyboardInput();

						int index_clean_keeper = keeper.AnimalIndex(id_clean);
						if (index_clean_keeper != 8023) {
							keeper.clean(keeper.animals.get(index_clean_keeper));
							System.out.println("Clean Successful");
						}

						int index_clean_manager = manager.animalIndex(id_clean);
						if (index_clean_manager != 8023) {
							keeper.clean(manager.all_animal.get(index_clean_manager));
						}
						break;

					/**
					 * Back to Start
					 */
					case 9:
						kContinue = false;
						break;

					/**
					 * Exit
					 */
					case 0:
						System.out.println("Exit Successful.");
						kContinue = false;
						isContinue = false;
						break;
					default:
						System.out.println("Invalid input.");
						break;
					}
				}
			}
		}

		/**
		 * When the program will finish. All the informations will be saved in
		 * file
		 */
		manager.saveFile();

	}

	/**
	 * This method is to create 6 random number for animals and keepers
	 * 
	 * @return 6 number ID
	 */
	private int IdRandom() {
		Random random = new Random();
		int id = random.nextInt(899999) + 100000;
		return id;
	}

	/**
	 * As a manager when he view the animals. He can have lots of type to check.
	 * 
	 * @return Return the type manage wants to view the animals System will show
	 *         as manager wants.
	 * 
	 */
	private int viewAllAnimalHelper() {
		System.out.println(
				"1. VIEW ALL ANIMALS  2. TIGER  3. LEOPARD " + '\n' + "4. LYNX 5. MARMOSET 6. CAPUCHIN 7. QEUIRREL");
		int choose = intKeyboardInput();
		int rst;
		switch (choose) {
		case 1:
			rst = 1;
			break;
		case 2:
			rst = 2;
			break;
		case 3:
			rst = 3;
			break;
		case 4:
			rst = 4;
			break;
		case 5:
			rst = 5;
			break;
		case 6:
			rst = 6;
			break;
		case 7:
			rst = 7;
			break;
		default:
			rst = viewAllAnimalHelper();
			break;
		}
		return rst;
	}

	/**
	 * @return A String value to type. You can only have 6 options
	 */
	private String getAnimalType() {
		String result;
		System.out.println("1.TIGER 2.LEOPARD 3.LYNX" + '\n' + "4.MARMOSET 5.CAPUCHIN 6.QEUIRREL");
		int i = intKeyboardInput();

		switch (i) {
		case 1:
			result = CatType.TIGER.name();
			break;
		case 2:
			result = CatType.LEOPARD.name();
			break;
		case 3:
			result = CatType.LYNX.name();
			break;
		case 4:
			result = PrimateType.MARMOSET.name();
			break;
		case 5:
			result = PrimateType.CAPUCHIN.name();
			break;
		case 6:
			result = PrimateType.QEUIRREL.name();
			break;
		default:
			result = getAnimalType();
		}
		return result;
	}

	/**
	 * @return A String value to state which is created by random number
	 */
	private String getAnimalState() {
		String result;
		Random rand = new Random();
		int i = rand.nextInt(4);
		if (i == 1)
			result = State.BIRTH.name();
		else if (i == 2)
			result = State.DEATH.name();
		else
			result = State.NEW.name();
		return result;
	}
}
