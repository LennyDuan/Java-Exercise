import java.util.Scanner;

public class CreateCurrentAccount extends CreateBasicAccount implements CreateAccount {
	
	public int specialNumber() {
		System.out.println("OverDraft");
		Scanner scanner = new Scanner(System.in);
		int special_number = Integer.parseInt(scanner.nextLine());
		return special_number;
	}


}
