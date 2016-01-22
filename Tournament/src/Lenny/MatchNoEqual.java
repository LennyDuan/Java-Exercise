package Lenny;

/**
 * 
 * @author Lenny
 * 
 *         This class is extend MatchDecorator. The no equal match have to
 *         restart match again if the scores of two sportors are same
 */
public class MatchNoEqual extends MatchDecorator {

	public MatchNoEqual(Sporter sporter_one, Sporter sporter_two, Sport sport) {
		super(sporter_one, sporter_two, sport);
	}

	protected void specialRank() {
		startMatch();
	}
}
