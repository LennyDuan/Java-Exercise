package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 * 
 *         This is the RoundTeamRobin class extend Round Model abstract class.
 *         This strategy is set for teams players. This strategy means every
 *         sporters in a team will fight with players in other teams once
 */
public class RoundTeamRobin extends RoundModel {

	public RoundTeamRobin(ArrayList<Sporter> sporters, Sport sport) {
		super(sporters, sport);
	}

	/**
	 * This method define how teams match with each other. After two single
	 * player have be matched, start a match.
	 */
	public void matching() {
		for (int i = 0; i < sporters.size(); i++) {
			for (int j = i + 1; j < sporters.size(); j++) {
				Sporter team_one = sporters.get(i);
				Sporter team_two = sporters.get(j);

				if (team_one instanceof Player || team_two instanceof Player) {
					endGame();
				} else {
					int team_rank_one = 0;
					int team_rank_two = 0;
					for (int p = 0; p < ((PlayersTeam) team_one).getPlayers().size(); p++) {
						Sporter player_one = ((PlayersTeam) team_one).getPlayers().get(p);
						Sporter player_two = ((PlayersTeam) team_two).getPlayers().get(p);

						MatchDecorator match = new MatchNormal(player_one, player_two, sport);
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
				}
			}
		}
		endGame();
	}

}
