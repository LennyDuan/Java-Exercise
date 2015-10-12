import java.util.Random;

public class CurrentAccount extends Account {

	int overdraft;

	public String toString() {
	     return '\n' + "The Current account ID : " + accountID + '\n' +
				"The Current account balance: " + balance + '\n' + 
				"The overdraft: " + overdraft + '\n' + 
				"Customer Name: "+ customer.forename + " " + customer.surname + '\n' + 
				"The transaction information: \n" + transaction + '\n';
	}
}
