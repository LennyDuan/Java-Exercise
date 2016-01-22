
public class ModelDuck extends Duck{

	public ModelDuck() {
		// TODO Auto-generated constructor stub
	
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
		
	}
	
	public void display() {
		System.out.println("I am Model Duck");
	}
}
