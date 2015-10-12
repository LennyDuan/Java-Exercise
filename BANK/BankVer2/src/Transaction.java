
public class Transaction {
	
		String date;
		String type;
		int amount;
		
		public Transaction(String date, String type, int amount) {
			this.date = date;
			this.type = type;
			this.amount = amount;
		}
		
		public String toString() {
			return    '\n'+ "DATE: " + date + "  "
					+ "TYPE: " +type + "  "
					+ "AMOUNT: " + amount + '\n';
		}
		

}
