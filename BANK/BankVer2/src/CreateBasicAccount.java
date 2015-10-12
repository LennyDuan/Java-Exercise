import java.util.Scanner;

public abstract class CreateBasicAccount implements CreateAccount {

	public String getAccountBalance() {
		System.out.println("Balance:");
		Scanner scanner = new Scanner(System.in);
		String balance = scanner.nextLine();
		return balance;
	}

	public String getCustomerForeName() {
		System.out.println("ForeName:");
		Scanner scanner = new Scanner(System.in);
		String fore_name = scanner.nextLine();
		return fore_name;
	}

	public String getCustomerSurName() {
		System.out.println("SurName:");
		Scanner scanner = new Scanner(System.in);
		String sur_name = scanner.nextLine();
		return sur_name;

	}

}
