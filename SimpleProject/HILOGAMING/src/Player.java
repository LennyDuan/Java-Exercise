import java.util.Scanner;

public class Player {

	String name;
	int number;
	int guess_time;
	
	public String getName() {
	
		System.out.println("Welcon new pleyer!"
				+ " Please input your name!" );
		Scanner scanner = new Scanner(System.in);
		name = scanner.nextLine();
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public int getNumber() {

		System.out.println("Pleyer: please input your guess!");
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());		
		return number;
	}
	
//	public void setNumber(int number) {
//		this.number = number;
//	}
	
	public void getResult(int time) {
		this.guess_time = time;
	}

	
//	}
	
	public String toString() {
		return name + ": the times of guesses is " + guess_time;	
	}
	
}
