package Lenny;

/**
 * 
 * @author Lenny
 *
 *         This is the class extend MatchDecorator. A normal match would have
 *         any special rank.
 */
public class MatchNormal extends MatchDecorator {

	public MatchNormal(Sporter sporter_one, Sporter sporter_two, Sport sport) {
		super(sporter_one, sporter_two, sport);
	}

	protected void specialRank() {
	}

}
