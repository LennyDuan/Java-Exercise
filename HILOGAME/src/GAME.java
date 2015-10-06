
public class GAME {

	String manager_name, player_name;
	int manager_answer, manager_count, player_guess;

	boolean compare(String name_m, String name_p, int num_a, int num_g, int num_c) {

		manager_name = name_m;
		player_name = name_p;
		manager_answer = num_a;
		manager_count = num_c;
		player_guess = num_g;

		if (manager_answer == player_guess) {
			System.out.println(player_name + "'s guess is right! Win the game!");
			return true;
		}
		else if (player_guess > manager_answer) {
			System.out.println(player_name + "'s guess is higher!");
			return false;
		} else if (player_guess < manager_answer) {
			System.out.println(player_name + "'s guess is lower!");
			return false;
		}
		
		return false;
			
	}

}
