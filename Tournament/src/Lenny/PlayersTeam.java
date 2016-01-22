package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 *
 *
 *         This is team class extend Sporter class. A team is an observer and
 *         need to implement 2 interfaces
 */
public class PlayersTeam extends Sporter implements Observer, DisplayResult {

	private ArrayList<Score> scores;
	private ArrayList<Sporter> sporters;

	public ArrayList<Sporter> getPlayers() {
		return sporters;
	}

	/**
	 * A sporter can be added to a team.
	 * 
	 * @param sporter
	 */
	public void addPlayers(Sporter sporter) {
		this.sporters.add(sporter);
	}

	public PlayersTeam(int id) {
		super(id);
		sporters = new ArrayList<>();
	}

	/**
	 * An observer need to set a subject to observe.
	 */
	public void setSubject(Subject result) {
		this.result = result;
		result.registerObserver(this);
	}

	/**
	 * To implement interface DisplayResult
	 */
	public void display() {
		for (Score score : scores) {
			if (score.getSporterOne().getId() == super.getId() || score.getSporterTwo().getId() == super.getId()) {
				System.out.println(score);
			}
		}
	}

	/**
	 * To implement interface Observer.
	 */
	public void update(ArrayList<Score> scores) {
		this.scores = scores;
		display();
	}

	public String toString() {
		return '\n' + "Team Id: " + this.id + '\n' + sporters;
	}

	@Override
	public String toResString() {
		return '\n' + "Team Id: " + this.id + " Rank: " + this.getRankScore();
	}

}
