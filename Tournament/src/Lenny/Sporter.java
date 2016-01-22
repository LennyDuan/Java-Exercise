package Lenny;

import java.text.DecimalFormat;

/**
 * 
 * @author Lenny
 *
 *
 *         This is abstract Sporter class inherit People. A sport should have a
 *         rank score, a match score for a score which will save in score list,
 *         a subject to observe and level that will change through matching.
 */
public abstract class Sporter extends People {

	protected int rank_score;
	protected int match_score;
	protected Subject result;
	protected double level;

	public Sporter(int id) {
		super(id);
		this.level = 0;
	}

	public abstract void display();

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	public void setSubject(Subject result) {
		this.result = result;
	}

	public void setRankScore(int rank_score) {
		this.rank_score = rank_score;
	}

	public void setMatchScore(int match_score) {
		this.match_score = match_score;
	}

	public int getRankScore() {
		return rank_score;
	}

	public int getMatchScore() {
		return match_score;
	}

	public abstract String toResString();

	public abstract String toString();
}
