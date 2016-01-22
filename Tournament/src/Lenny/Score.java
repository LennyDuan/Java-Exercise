package Lenny;

/**
 * 
 * @author Lenny
 *
 *         This is Score class. In a score, there should have 2 players and 2
 *         scores for 2 players.
 */
public class Score {
	private Sporter sporter_one;
	private Sporter sporter_two;
	private int score_one;
	private int score_two;
	private Match match;

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Score(Sporter sporter, Sporter sporter2) {
		this.sporter_one = sporter;
		this.score_one = sporter.getMatchScore();
		this.sporter_two = sporter2;
		this.score_two = sporter2.getMatchScore();

	}

	public Sporter getSporterOne() {
		return sporter_one;
	}

	public Sporter getSporterTwo() {
		return sporter_two;
	}

	public String toString() {

		return '\n' + " Id: " + this.sporter_one.getId() + ", Score:" + score_one + ", Level:" + sporter_one.getLevel()
				+ ", Rank: " + this.sporter_one.getRankScore() + " | Id: " + this.sporter_two.getId() + ", Score:"
				+ score_two + ", Level:" + sporter_two.getLevel() + ", Rank: " + this.sporter_two.getRankScore();
	}
}
