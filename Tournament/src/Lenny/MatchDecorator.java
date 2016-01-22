package Lenny;

/**
 * This is the MatchDecorator class extend Match. 
 */
import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class MatchDecorator extends Match {

	public MatchDecorator(Sporter sporter_one, Sporter sporter_two, Sport sport) {
		super(sporter_one, sporter_two, sport);
		// TODO Auto-generated constructor stub
	}

	Match match;

	public void setMatch(Match match) {
		this.match = match;
	}

	/**
	 * The method is to start match between two sporter by using the sport
	 * score.
	 */
	public void startMatch() {

		int score_one = (int) (sport.calculate(sporter_one.getLevel()));
		int score_two = (int) (sport.calculate(sporter_two.getLevel()));

		getSporterOne().setMatchScore(score_one);
		getSporterTwo().setMatchScore(score_two);

		if (this.sport instanceof SportTennis) {
			if ((this.sporter_one.getMatchScore() == 40 && this.sporter_two.getMatchScore() == 40)
					|| (this.sporter_one.getMatchScore() != 40 && this.sporter_two.getMatchScore() != 40)) {
				startMatch();
			}
		}
		if (this.sporter_one.getMatchScore() > this.sporter_two.getMatchScore()) {
			getWinRank(this.sporter_one);
			getLoseRank(this.sporter_two);
		} else if (this.sporter_one.getMatchScore() < this.sporter_two.getMatchScore()) {
			getWinRank(this.sporter_two);
			getLoseRank(this.sporter_one);
		} else {
			specialRank();
			getEqualRank(this.sporter_one);
			getEqualRank(this.sporter_two);
		}
	}

	/**
	 * The winner will change the level and rank.
	 */
	protected void getWinRank(Sporter sporter) {
		double l = sporter.getLevel() + 0.1;
		Double level = new BigDecimal(l).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		sporter.setLevel(level);

		if (match.getSporterOne().getId() == sporter.getId()) {
			sporter.setRankScore(match.getSporterOne().getRankScore() + this.sport.getWin());
		} else if (match.getSporterTwo().getId() == sporter.getId()) {
			sporter.setRankScore(match.getSporterTwo().getRankScore() + this.sport.getWin());
		} else
			sporter.setRankScore(this.sport.getWin());

	}

	/**
	 * The loser will change rank.
	 */
	protected void getLoseRank(Sporter sporter) {

		if (match.getSporterOne().getId() == sporter.getId()) {
			sporter.setRankScore(match.getSporterOne().getRankScore() + this.sport.getLose());
		} else if (match.getSporterTwo().getId() == sporter.getId()) {
			sporter.setRankScore(match.getSporterTwo().getRankScore() + this.sport.getLose());
		} else
			sporter.setRankScore(this.sport.getLose());

	}

	/**
	 * The two sportors will change rank and level.
	 */
	protected void getEqualRank(Sporter sporter) {
		double l = sporter.getLevel() + 0.05;
		Double level = new BigDecimal(l).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		sporter.setLevel(level);

		if (match.getSporterOne().getId() == sporter.getId()) {
			sporter.setRankScore(match.getSporterOne().getRankScore() + this.sport.getEqual());
		} else if (match.getSporterTwo().getId() == sporter.getId()) {
			sporter.setRankScore(match.getSporterTwo().getRankScore() + this.sport.getEqual());
		} else
			sporter.setRankScore(this.sport.getEqual());
	}

	/**
	 * The abstract method is for different or special match
	 */
	protected abstract void specialRank();

}
