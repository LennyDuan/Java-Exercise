import java.util.Scanner;

public class Player {

	String name;
	int guess;
	
	public String getName() {
		System.out.println("Please enter player's name.");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		name = input;
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	
	}
	public int getGuess() {
		System.out.println("Please enter guess Number");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
	    guess = Integer.parseInt(input);
		return guess;
	}
	public void setGuess(int guess) {
	
		this.guess = guess;
	}
	
}
