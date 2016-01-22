import java.util.ArrayList;

public class BANK {

	String name;
	private ArrayList<Account> accountList = new ArrayList<Account>();
	BankHelper helper = new BankHelper();

	private String setName() {
		name = "MyBank";
		return name;
	}

	private void creatCurrentAccount() {
		CurrentAccount account = new CurrentAccount();
		account.balance = Integer.toString(1000);
		Transaction transaction = new Transaction("10/10/2015", "DEBIT", 100);
		account.transaction.add(transaction);
		Customer customer = new Customer("Lenny", "Duan");
		account.customer = customer;
		account.overdraft = 100;
		accountList.add(account);
		beginCreate();
	}

	private void creatSavingAccount() {
		SavingAccount account = new SavingAccount();
		account.balance = Integer.toString(5000);
		Transaction transaction = new Transaction("20/09/2015", "DEBIT", 100);
		account.transaction.add(transaction);
		Customer customer = new Customer("Patricia", "Shaw");
		account.customer = customer;
		account.interest = 0.5;
		accountList.add(account);
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
			creatSavingAccount();
		case 2:
			creatCurrentAccount();
		case 3:
			printAccount();
		case 4:
			break;
		case 0:
			beginCreate();
		}
	}



	public static void main(String[] arg) {
		BANK bank = new BANK();
		bank.setName();
		bank.beginCreate();
	}
}
