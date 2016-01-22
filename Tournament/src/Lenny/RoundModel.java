package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 * 
 *         This is abstract RoundModel class which implements Strategy
 *         interface. In a strategy, the sport should be defined and there
 *         should have a list of sporters and scores.
 */
public abstract class RoundModel implements Strategy {

	protected ArrayList<Sporter> sporters;
	protected ArrayList<Score> scores;
	protected Sport sport;

	public RoundModel(ArrayList<Sporter> sporters, Sport sport) {
		this.sporters = sporters;
		this.sport = sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public void startGame() {
		scores = new ArrayList<Score>();
		matching();
	}

	/**
	 * Different strategies will have different matching model.
	 */
	public abstract void matching();

	/**
	 * After the tournament end, rank the sporters' rank score.
	 */
	public void endGame() {
		for (int i = 0; i < sporters.size(); i++) {
			for (int j = i + 1; j < sporters.size(); j++) {
				if (sporters.get(i).getRankScore() < sporters.get(j).getRankScore()) {
					Sporter sporter = sporters.get(i);
					sporters.set(i, sporters.get(j));
					sporters.set(j, sporter);
				}
			}
		}
	}

	public ArrayList<Score> getScores() {
		return scores;
	}

	public ArrayList<Sporter> getRank() {
		return sporters;
	}
}
