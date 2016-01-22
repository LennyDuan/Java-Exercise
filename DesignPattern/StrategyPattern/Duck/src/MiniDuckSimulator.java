
public class MiniDuckSimulator {
 
	
	public static void main(String[] args) {
		
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performFly();
		mallard.performQuack();
		mallard.swim();
	

		Duck model = new ModelDuck();
		model.display();

		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
