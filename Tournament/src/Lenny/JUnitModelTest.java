package Lenny;

/**
 * 
 * @author Lenny
 * @since Jan 15 2016
 * 
 *             This is JUnit model test class to test that object can be created.
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JUnitModelTest {

	/**
	 * This is to test that Sport can be created and return correct value.
	 */
	@Test
	public void CreateSportAndReturnCorrectRank() {
		Sport soccer = new SportSoccer();
		assertEquals(3, soccer.getWin());
		assertEquals(1, soccer.getEqual());
		assertEquals(0, soccer.getLose());

		Sport tennis = new SportTennis();
		assertEquals(1, tennis.getWin());
		assertEquals(0, tennis.getEqual());
		assertEquals(0, tennis.getLose());

		Sport basketball = new SportBasketball();
		assertEquals(2, basketball.getWin());
		assertEquals(1, basketball.getEqual());
		assertEquals(0, basketball.getLose());
	}

	/**
	 * This is to test that player and team can be created and a play can be
	 * added to a team
	 */
	@Test
	public void createSporterAndAddToTeam() {
		Sporter sporter = new Player(0);
		assertEquals(0, sporter.getId());

		Sporter sporter2 = new Player(1);
		assertEquals(1, sporter2.getId());

		PlayersTeam team = new PlayersTeam(100);
		assertEquals(100, team.getId());

		team.addPlayers(sporter);
		team.addPlayers(sporter2);
		assertEquals(sporter, team.getPlayers().get(0));
	}

	/**
	 * This is to test that match and score can be created and the scores are
	 * created by matching
	 */
	@Test
	public void createMatchAndScore() {
		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);
		SportSoccer sport = new SportSoccer();

		MatchNormal normal = new MatchNormal(sporter_one, sporter_two, sport);
		normal.setMatch(normal);
		normal.startMatch();

		Score score = new Score(sporter_one, sporter_two);
		score.setMatch(normal);

		if (normal.getSporterOne().getMatchScore() > normal.getSporterTwo().getMatchScore()) {
			assertEquals(3, sporter_one.getRankScore());
			assertEquals(0.1, sporter_one.getLevel(), 1);
		} else if (normal.getSporterOne().getMatchScore() == normal.getSporterTwo().getMatchScore()) {
			assertEquals(1, sporter_one.getRankScore());
			assertEquals(0.05, sporter_one.getLevel(), 1);
		} else {
			assertEquals(0, sporter_one.getRankScore());
		}

		assertEquals(normal.getSporterOne(), score.getSporterOne());
	}

	/**
	 * This is to test that different strategy can be created
	 */
	@Test
	public void createStrategy() {
		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);

		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(sporter_one);
		sporters.add(sporter_two);

		SportSoccer soccer = new SportSoccer();

		Strategy strategy = new RoundRobin(sporters, soccer);
		strategy.startGame();
		assertEquals(2, strategy.getRank().size());
		assertEquals(1, strategy.getScores().size());

		Strategy strategy2 = new RoundRound(sporters, soccer);
		strategy2.startGame();
		assertEquals(2, strategy2.getRank().size());
		assertEquals(2, strategy2.getScores().size());

		Strategy strategy3 = new RoundKickOut(sporters, soccer);
		strategy3.startGame();
		assertEquals(2, strategy3.getRank().size());

		boolean result = false;
		if (strategy3.getScores().size() >= 1) {
			result = true;
		}
		assertEquals(true, result);

	}

	/**
	 * This is to test that tournament and supporter can be created
	 */
	@Test
	public void createTournamentAndSupporter() {
		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);

		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(sporter_one);
		sporters.add(sporter_two);

		SportSoccer soccer = new SportSoccer();
		Strategy strategy = new RoundRobin(sporters, soccer);

		Tournament tournament = new Tournament(strategy);
		tournament.Start();
		assertEquals(2, tournament.getStrategy().getRank().size());
		assertEquals(1, tournament.getStrategy().getScores().size());

		Supporter supporter = new Supporter(0, tournament.getResult());
		supporter.setSporter(sporter_one);
		assertEquals(sporter_one, supporter.getSporter());

	}

}
