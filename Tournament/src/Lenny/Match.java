package Lenny;

/**
 * 
 * @author Lenny
 *
 *         This is the abstract class Match. In a match, ther should have 2
 *         sporter and define one sport.
 */
public abstract class Match {
	protected Sporter sporter_one;
	protected Sporter sporter_two;
	protected Sport sport;

	public Match(Sporter sporter_one, Sporter sporter_two, Sport sport) {
		this.sport = sport;
		this.sporter_one = sporter_one;
		this.sporter_two = sporter_two;

	}

	public Sporter getSporterOne() {
		return sporter_one;
	}

	public Sporter getSporterTwo() {
		return sporter_two;
	}

	public Sport getSport() {
		return sport;
	}

	/**
	 * Below are abstract methods that should be implement by subclass.
	 */
	public abstract void startMatch();

	protected abstract void getWinRank(Sporter sporter);

	protected abstract void getLoseRank(Sporter sporter);

	protected abstract void getEqualRank(Sporter sporter);

}
