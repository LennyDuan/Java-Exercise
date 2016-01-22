import java.util.ArrayList;

public class ArrayListPlayer {

	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	public void addPlayer(Player p) {
		playerList.add(p);
	}
	
	public void pinrtRecord() {
		for(Player p : playerList) {
			System.out.println(p);
		}
	}
}
