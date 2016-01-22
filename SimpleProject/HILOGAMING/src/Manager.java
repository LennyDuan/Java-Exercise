import java.util.Random;
import java.util.Scanner;

public class Manager {

	String name;
	int anwser;
	int max_time;
	public String getName() {
		System.out.println("Manager: please input your name!");
		Scanner scanner = new Scanner(System.in);
		name = scanner.nextLine();
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getAnwser() {
		System.out.println("Manager: your guess has setup!");
//		Scanner scanner = new Scanner(System.in);
//		int anwser = Integer.parseInt(scanner.nextLine());	
		Random rand = new Random() ;
	    int answer = rand.nextInt(100) + 1;
		System.out.println(answer);
		this.anwser = answer;
		
		return anwser;
	}
	
	public int resetAnwser() {		
		System.out.println("Manager: please reset your guess and restart new game!");
		Scanner scanner = new Scanner(System.in);
		int anwser = Integer.parseInt(scanner.nextLine());		
		return anwser;
	}
	
	public int getMax_time() {
		System.out.println("Manager: please input the max of guess times!");
		Scanner scanner = new Scanner(System.in);
		int max_time = Integer.parseInt(scanner.nextLine());		
		return max_time;
	}
//	public void setMax_time(int max_time) {
//		this.max_time = max_time;
//	}
}
