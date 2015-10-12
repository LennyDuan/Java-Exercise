import java.util.Scanner;

public class BankHelper {

	public int createAccount(int options) {
		System.out.println("Welcome to MyBank!");
		System.out.println("Options:Please return number.");
		System.out.println("1: Create Saving Account" + '\n'
				+ "2: Create Current Account" + '\n'
				+ "3: Show all Accounts" + '\n'
				+ "4: Finish" + '\n');
		Scanner scanner = new Scanner(System.in);
		int option = Integer.parseInt(scanner.nextLine());
		switch (option) {
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
