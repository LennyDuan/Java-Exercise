
public class GarageDoorOnCommand implements Command{

	GarageDoor garageDoor;
	
	public GarageDoorOnCommand(GarageDoor garageDoor) {
		// TODO Auto-generated constructor stub
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garageDoor.on();
	}
	
	
}
