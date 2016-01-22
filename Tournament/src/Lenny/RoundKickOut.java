package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 * 
 *         This is the RoundKickOut class extend Round Model abstract class.
 *         This strategy means that only the winner can still in the match list.
 *         The loser will be removed.
 */
public class RoundKickOut extends RoundModel {

	public RoundKickOut(ArrayList<Sporter> sporters, Sport sport) {
		super(sporters, sport);
	}

	private ArrayList<Sporter> final_sporters = new ArrayList<>(sporters);

	/**
	 * This method define how players match with each other.
	 */
	public void matching() {

		while (final_sporters.size() > 1) {
			for (int i = 0; i < final_sporters.size(); i++) {
				int j = i + 1;
				if (j < final_sporters.size()) {
					Sporter sporter_one = final_sporters.get(i);
					Sporter sporter_two = final_sporters.get(j);
					if ((sporter_one instanceof Player && sporter_two instanceof PlayersTeam)
							|| (sporter_two instanceof Player && sporter_one instanceof PlayersTeam)) {

					} else {
						startKickOutMatch(sporter_one, sporter_two);
					}
				}
			}
		}

		endGame();
	}

	/**
	 * Start a match between two sportorts.
	 */
	private void startKickOutMatch(Sporter sporter_one, Sporter sporter_two) {

		MatchDecorator match = new MatchNormal(sporter_one, sporter_two, sport);
		match.setMatch(match);
		match.startMatch();
		Score score = new Score(match.getSporterOne(), match.getSporterTwo());
		score.setMatch(match);
		scores.add(score);

		if (match.getSporterOne().getMatchScore() > match.getSporterTwo().getMatchScore()) {
			final_sporters.remove(final_sporters.indexOf(sporter_two));
		} else if (match.getSporterOne().getMatchScore() < match.getSporterTwo().getMatchScore()) {
			final_sporters.remove(final_sporters.indexOf(sporter_one));
		} else {
			startKickOutMatch(sporter_one, sporter_two);
		}

	}

}
