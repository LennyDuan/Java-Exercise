package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 * 
 *         This is the RoundTeamKickOut class extend Round Model abstract class.
 *         This strategy is set for teams players. This strategy means every
 *         sporters in a team will fight with players in other teams.only winner
 *         team can continue .
 */
public class RoundTeamKickOut extends RoundModel {

	public RoundTeamKickOut(ArrayList<Sporter> sporters, Sport sport) {
		super(sporters, sport);
	}

	private ArrayList<Sporter> final_sporters = new ArrayList<>(sporters);

	/**
	 * This method define how teams match with each other. After two single player
	 * have be matched, start a match.
	 */
	public void matching() {
		while (final_sporters.size() > 1) {
			for (int i = 0; i < final_sporters.size(); i++) {
				for (int j = i + 1; j < final_sporters.size(); j++) {
					Sporter team_one = final_sporters.get(i);
					Sporter team_two = final_sporters.get(j);

					startKickOutMatch(team_one, team_two);

				}
			}
		}
		endGame();
	}

	private void startKickOutMatch(Sporter team_one, Sporter team_two) {
		int team_rank_one = 0;
		int team_rank_two = 0;
		for (int p = 0; p < ((PlayersTeam) team_one).getPlayers().size(); p++) {
			Sporter player_one = ((PlayersTeam) team_one).getPlayers().get(p);
			Sporter player_two = ((PlayersTeam) team_two).getPlayers().get(p);

			MatchDecorator match = new MatchNoEqual(player_one, player_two, sport);
			match.setMatch(match);
			match.startMatch();
			Score score = new Score(match.getSporterOne(), match.getSporterTwo());
			score.setMatch(match);
			scores.add(score);

			team_rank_one += player_one.getRankScore();
			team_rank_two += player_two.getRankScore();

		}
		team_one.setRankScore(team_rank_one);
		team_two.setRankScore(team_rank_two);

		if (team_one.getRankScore() > team_two.getRankScore()) {
			final_sporters.remove(final_sporters.indexOf(team_two));
		} else if (team_one.getRankScore() < team_two.getRankScore()) {
			final_sporters.remove(final_sporters.indexOf(team_one));
		} else {
			team_one.setRankScore(team_one.getRankScore() - team_rank_one);
			team_two.setRankScore(team_two.getRankScore() - team_rank_two);
			startKickOutMatch(team_one, team_two);

		}
	}

}
