import java.util.Scanner;

public class CreateTransactionInfo {
	
	String date;
	String type;
	int amount;
	
	public String setDate() {
		System.out.println("Transaction Date:DD/MM/YYYY");
		Scanner scanner = new Scanner(System.in);
		String date = scanner.nextLine();
		this.date = date;
		return this.date;
	}
	
	public String setType() {
		System.out.println("Transaction Type :");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		this.type = type;
		return this.type;
	
	}
	public int setAmount() {
		System.out.println("Transaction Amount :");
		Scanner scanner = new Scanner(System.in);
		int amount = Integer.parseInt(scanner.nextLine());
		this.amount = amount;
		return this.amount;
		
	}
	

}
