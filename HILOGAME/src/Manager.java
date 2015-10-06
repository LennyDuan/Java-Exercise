import java.util.Scanner;

public class Manager {

	String name;
	int answer;
	int count;

	public String getName() {
		System.out.println("Please enter manager's name.");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		name = input;
		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getAnswer() {
		System.out.println("Please enter Answer Number");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
	    answer = Integer.parseInt(input);
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getCount() {
		System.out.println("Please enter count times.");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
	    count = Integer.parseInt(input);
		return count;
	}

	public void setCount(int count) {
		
		this.count = count;
	}

}
