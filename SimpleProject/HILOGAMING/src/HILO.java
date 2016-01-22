
public class HILO {

	String manager_name, player_name;
	int answer, guess, max_time;
	int guess_time = 0;
	int guess_record;

	Manager manager = new Manager();
	Player player = new Player();
	HiloHelper helper = new HiloHelper();
	ArrayListPlayer list = new ArrayListPlayer();
	
	public  void initialize() {
		manager_name = manager.getName();
		
		startGame();
	}
	public void startGame() {
		guess_time = 0;
		max_time = manager.getMax_time();
		answer = manager.getAnwser();
		player_name = player.getName();
		list.addPlayer(player);
		compare();

	}

	public void newPlayer() {
		player_name = player.getName();
		list.addPlayer(player);
		compare();
	}

	private void newGuess() {
		guess = player.getNumber();
	}

	private void restart() {
		startGame();
	}

	private void compare() {
		int times = max_time;
		boolean win = false;
		while (!win) {
			newGuess();
			times --;
			guess_time++;
			win = helper.compare(player_name, answer, guess, times);
			if (max_time == 0) {
				System.out.println(player_name + " you lose the game ");
				break;
			}
		}
	    player.getResult(guess_time);
		question();
	}

	private void question() {
		int key = helper.question(0);
		switch(key) {
		case 1: 
			restart();
		case 2:
			newPlayer();
		case 3:
			getRecord();
		case4:
			break;
		case 0:
			question();
		}
	}

	private void getRecord() {
		list.pinrtRecord();
		question();
	}

}
