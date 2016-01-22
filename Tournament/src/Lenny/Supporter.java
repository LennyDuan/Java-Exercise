package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 *
 *         This is supporter class which inherit People class. A support is an
 *         observer and have to implement 2 interfaces.
 */
public class Supporter extends People implements Observer, DisplayResult {

	private Sporter favorite_sporter;
	private ArrayList<Score> scores;
	private Subject result;

	public ArrayList<Score> getScores() {
		return scores;
	}

	public Supporter(int id, Subject result) {
		super(id);
		this.result = result;
		result.registerObserver(this);
	}

	/**
	 * 
	 * @param sporter
	 *            A support can choose the sporter he likes
	 */
	public void setSporter(Sporter sporter) {
		this.favorite_sporter = sporter;
	}

	public Sporter getSporter() {
		return this.favorite_sporter;
	}

	/**
	 * To implement DisplayResult interface
	 */
	public void display() {
		for (Score score : scores) {
			if (score.getSporterOne().getId() == favorite_sporter.getId()
					|| score.getSporterTwo().getId() == favorite_sporter.getId()) {
				// System.out.println(score);
			}
		}
	}

	/**
	 * Same as display() method but return string for show result on user
	 * interface
	 */
	public String showResult() {
		String result = "";
		for (Score score : scores) {
			if (score.getSporterOne().getId() == favorite_sporter.getId()
					|| score.getSporterTwo().getId() == favorite_sporter.getId()) {
				result = result + score.toString();
			}
		}
		return result;
	}

	/**
	 * To implement Observer interface.
	 */
	public void update(ArrayList<Score> scores) {
		this.scores = scores;
		display();
	}
}
