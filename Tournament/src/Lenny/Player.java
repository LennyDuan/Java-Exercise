package Lenny;

import java.util.ArrayList;

/**
 * This is the single player class extend Sporter class. Player is an observer
 * and need to implement 2 interface.
 */
public class Player extends Sporter implements Observer, DisplayResult {

	private ArrayList<Score> scores;

	public Player(int id) {
		super(id);
	}

	/**
	 * Observer need to set a subject to observer.
	 */
	public void setSubject(Subject result) {
		this.result = result;
		result.registerObserver(this);
	}

	/**
	 * This is the method to implement interface DisplayResult.
	 */
	public void display() {
		for (Score score : scores) {
			if (score.getSporterOne().getId() == super.getId() || score.getSporterTwo().getId() == super.getId()) {
				System.out.println(score);
			}
		}
	}

	/**
	 * This is the method to implement interface Observer.
	 */
	public void update(ArrayList<Score> scores) {
		this.scores = scores;
		display();
	}

	@Override
	public String toResString() {
		return '\n' + "   Id: " + getId() + " Rank: " + getRankScore();
	}

	public String toString() {
		return '\n' + "Id: " + getId();
	}
}
