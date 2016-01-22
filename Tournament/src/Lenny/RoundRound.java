package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 * 
 *         This is the RoundRound class extend Round Model abstract class. This
 *         strategy means that each sport will match with every other sporters
 *         twice.
 */
public class RoundRound extends RoundModel {

	public RoundRound(ArrayList<Sporter> sporters, Sport sport) {
		super(sporters, sport);
	}

	/**
	 * This method define how players match with each other. After two spoters
	 * have be matched, start a match.
	 */
	public void matching() {
		for (int i = 0; i < sporters.size(); i++) {
			for (int j = 0; j < sporters.size(); j++) {
				if (i != j) {
					Sporter sporter_one = sporters.get(i);
					Sporter sporter_two = sporters.get(j);
					if ((sporter_one instanceof Player && sporter_two instanceof PlayersTeam)
							|| (sporter_one instanceof PlayersTeam && sporter_two instanceof Player)) {
					} else {
						MatchDecorator match = new MatchNormal(sporter_one, sporter_two, sport);
						match.setMatch(match);
						match.startMatch();
						Score score = new Score(match.getSporterOne(), match.getSporterTwo());
						score.setMatch(match);
						scores.add(score);
					}
				}
			}
		}
		endGame();
	}

}
