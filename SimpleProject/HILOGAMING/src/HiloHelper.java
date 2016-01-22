import java.util.Scanner;

public class HiloHelper {

	String name_p;
	int answer, guess;

	public boolean compare(String name, int answer, int guess, int max_time) {

		this.name_p = name;
		this.answer = answer;
		this.guess = guess;
		

		if (answer == guess) {
			System.out.println(name_p + ": Win the Game!");
			return true;
		} else if (answer < guess) {
			System.out.println(name_p + ": guess is higher" + "\n" + "You last " + max_time + " times..." + "\n");
			return false;
		} else if (answer > guess) {
			System.out.println(name_p + ": guess is lower" + "\n" + "You last " + max_time + " times..." + "\n");
			return false;
		}
		return false;
	}

	public int question(int key) {
		System.out.println("\n" + "What next step?" + "\n" + "1: Restart" + "\n" + "2: New Player " + "\n" + "3: Record"
				+ "\n" + "4: Finish");
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.nextLine());
		switch (input) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;

		default:
			System.out.println("Invalid Input." + "\n" + "Please try 1/2/3/4 again");
			return 0;
		}

	}
}
