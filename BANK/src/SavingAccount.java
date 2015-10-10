
public class SavingAccount extends Account {

	double interest;
	
	public String toString() {
		return "The account balance: " + balance + '\n' + 
				"The interest: " + interest + '\n' + 
				"Customer Name: "+ customer.forename + " " + customer.surname + '\n' + 
				"The transaction information: \n" + transaction;
	}
}
