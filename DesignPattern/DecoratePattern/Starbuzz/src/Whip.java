
public class Whip extends CondimentDecorator{

	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getDescription() {
				return beverage.getDescription() + ", Whip";
	}

	public double cost() {
		return 0.3 + beverage.cost();
	}

}
