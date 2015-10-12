import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BANK {

	String name;
	private ArrayList<Account> accountList = new ArrayList<Account>();
	BankHelper helper = new BankHelper();

	private String setName() {
		name = "MyBank";
		return name;
	}

	String date_info;
	String type_info;
	int amount_info;

	private void createTransactionInformation() {
		CreateTransactionInfo create_info = new CreateTransactionInfo();
		date_info = create_info.setDate();
		type_info = create_info.setType();
		amount_info = create_info.setAmount();

	}

	boolean add_info = true;

	private void addTranInfo() {
		System.out.println("Add Transaction Information? Y/N");
		Scanner scanner = new Scanner(System.in);
		String jungle = scanner.nextLine();
		if (jungle.equals("Y"))
			add_info = true;
		else if (jungle.equals("N"))
			add_info = false;
		else
			addTranInfo();
	}

	private void createCurrentAccount() {

		CreateAccount create_new = new CreateCurrentAccount();
		CurrentAccount account = new CurrentAccount();

		account.accountID = account.setrandID();

		account.balance = create_new.getAccountBalance();
		String forename = create_new.getCustomerForeName();
		String surname = create_new.getCustomerSurName();
		Customer customer = new Customer(forename, surname);
		account.customer = customer;
		account.overdraft = create_new.specialNumber();
		
		addTranInfo();
		while (add_info) {
		
			createTransactionInformation();
			Transaction transaction = new Transaction(date_info, type_info, amount_info);
			account.transaction.add(transaction);
			addTranInfo();
		}

		add_info = true;
		
		accountList.add(account);
		System.out.println(account);

		beginCreate();
	}

	private void createSavingAccount() {

		CreateAccount create_new = new CreateSavingAccount();
		SavingAccount account = new SavingAccount();

		account.accountID = account.setrandID();
		account.balance = create_new.getAccountBalance();
		String forename = create_new.getCustomerForeName();
		String surname = create_new.getCustomerSurName();
		Customer customer = new Customer(forename, surname);
		account.customer = customer;
		account.interest = (create_new.specialNumber()) / 100.0;

		addTranInfo();
		while (add_info) {
		
			createTransactionInformation();
			Transaction transaction = new Transaction(date_info, type_info, amount_info);
			account.transaction.add(transaction);
			addTranInfo();

		}
		add_info = true;

		accountList.add(account);
		System.out.println(account);

		beginCreate();
	}

	private void createRandAccount() {
		Random random = new Random();
		int rand_balance = random.nextInt(10000) + 1;
		double rand_interest = (random.nextInt(100) + 1) / 100.0;

		SavingAccount account = new SavingAccount();
		account.accountID = account.setrandID();
		account.balance = Integer.toString(rand_balance);

		Customer customer = new Customer("Patricia", "Shaw");
		account.customer = customer;
		account.interest = rand_interest;

		Transaction transaction = new Transaction("20/09/2015", "DEBIT", 100);
		account.transaction.add(transaction);

		accountList.add(account);
		System.out.println(account);

		beginCreate();
	}

	private void printAccount() {
		for (Account ac : accountList) {
			System.out.println(ac);
		}
		beginCreate();
	}

	private void beginCreate() {
		int option = helper.createAccount(0);
		switch (option) {
		case 1:
			createSavingAccount();
		case 2:
			createCurrentAccount();
		case 3:
			printAccount();
		case 4:
			break;
		case 0:
			beginCreate();
		case 9:
			createRandAccount();
		}
	}

	public static void main(String[] arg) {
		BANK bank = new BANK();
		bank.setName();
		bank.beginCreate();
	}
}
