
public class ChocolateBoiler {

	private boolean empty;
	private boolean boided;
	
	private volatile static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler() {
		empty = true;
		boided = false;
	}
	
	public static synchronized ChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			synchronized (ChocolateBoiler.class) {
				if(uniqueInstance == null) {

					uniqueInstance = new ChocolateBoiler();
				}
				
			}
		}
		return uniqueInstance;
		
	}
	
	public void fill(int i) {
		if(empty) {
			empty = false;
			boided = false;
			System.out.println("Filling..."+ i);
		}
	}
	public static void main(String[] args) {
		getInstance().fill(1);
		
		ChocolateBoiler chocolateBoiler = new ChocolateBoiler();
		chocolateBoiler.fill(2);
	}
}
