
public class DuskTestDriver {

	
	public static void main(String[] args) {
		
		MallardDuck duck  = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		Duck turkyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("Duck :");
		duck.quack();
		duck.fly();
		System.out.println("Turkey :");

		turkey.gobble();
		turkey.fly();
		
		System.out.println("TurkeyAdapter :");
		
		turkyAdapter.quack();
		turkyAdapter.fly();

	}
}
