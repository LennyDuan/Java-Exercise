
public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
	
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		remote.setComand(0,lightOnCommand, lightOnCommand);
	
		
		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOnCommand garageDoorOnCommand = new GarageDoorOnCommand(garageDoor);
		remote.setComand(1, garageDoorOnCommand, garageDoorOnCommand);
		
		System.out.println(remote);
		
		remote.onButtonWasPressed(0);	
		remote.onButtonWasPressed(1);;

		
	}
}
