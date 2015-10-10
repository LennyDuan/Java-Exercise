import java.util.ArrayList;

public class Account {
	
	String balance;
	public ArrayList<Transaction> transaction = new ArrayList<Transaction>();
	public Customer customer;
	

//	public void printTran() {
//		for (Transaction tran: transaction) {
//			System.out.println(tran);
//		}
//	}
	

	public String toString() {
		return  balance 
				+'\n' 
				+ customer.forename + '\n'
				+ customer.surname + '\n'
				+ transaction;
	}
	
}
