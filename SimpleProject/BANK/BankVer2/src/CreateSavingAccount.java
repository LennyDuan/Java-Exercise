import java.util.Scanner;

public class CreateSavingAccount extends CreateBasicAccount implements CreateAccount {
	
	public int specialNumber() {
		System.out.println("Interest: N%");
		Scanner scanner = new Scanner(System.in);
		int special_number = Integer.parseInt(scanner.nextLine());
		return special_number;
	}

}
