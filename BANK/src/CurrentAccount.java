
public class CurrentAccount extends Account {

	int overdraft;

	public String toString() {
		return "The account balance: " + balance + '\n' + 
				"The overdraft: " + overdraft + '\n' + 
				"Customer Name: "+ customer.forename + " " + customer.surname + '\n' + 
				"The transaction information: \n" + transaction + '\n';
	}
}
