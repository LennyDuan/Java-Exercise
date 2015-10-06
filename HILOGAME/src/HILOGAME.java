
public class HILOGAME {

	public static void main(String[] args) {
		Manager manager = new Manager();
		String manager_name = manager.getName();
		int manager_answer = manager.getAnswer();
		int manager_count = manager.getCount();

		Player player = new Player();
		String player_name = player.getName();
		int player_guess = player.getGuess();

		GAME game = new GAME();
		boolean iswin;
		iswin = game.compare(manager_name, player_name, manager_answer, player_guess, manager_count);

		while (iswin == false) {
			manager_count--;
			if (manager_count == 0) {
				System.out.println(player_name + ", you lose the game! ");
				break;
			}
			System.out.println(player_name + ", you last " + manager_count + " times!");
			player_guess = player.getGuess();
			iswin = game.compare(manager_name, player_name, manager_answer, player_guess, manager_count);
		}
	}

}
