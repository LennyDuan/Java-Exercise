import java.util.ArrayList;
import java.util.Random;

public class Account {
	
	int accountID;
	String balance;
	public ArrayList<Transaction> transaction = new ArrayList<Transaction>();
	public Customer customer;
	
	public int setrandID() {
		Random random = new Random();
		int rand_id = random.nextInt(899999) + 100000;
		return this.accountID = rand_id;
	}

//	public void printTran() {
//		for (Transaction tran: transaction) {
//			System.out.println(tran);
//		}
//	}
	

	public String toString() {
		return  '\n' + accountID + '\n'
				+balance +'\n' 
				+ customer.forename + '\n'
				+ customer.surname + '\n'
				+ transaction + '\n';
	}
	
}
