package Lenny;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * @author Lenny
 * @since Jan 15 2016
 *
 *        This is the JUnit behavior test class
 * 
 */
public class JUnitBehaviorTest {

	/**
	 * This is to test that the 2 sports can have match with each other
	 */
	@Test
	public void testDecoraterPatternForMatchesClass() {
		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);
		Sport sport = new SportSoccer();

		MatchNormal normal = new MatchNormal(sporter_one, sporter_two, sport);
		normal.setMatch(normal);
		normal.startMatch();

		if (normal.getSporterOne().getMatchScore() > normal.getSporterTwo().getMatchScore()) {
			assertEquals(3, sporter_one.getRankScore());
			assertEquals(0.1, sporter_one.getLevel(), 1);

			MatchNormal normal_decorater = new MatchNormal(sporter_one, sporter_two, sport);
			normal_decorater.setMatch(normal);
			normal_decorater.startMatch();

			if (normal_decorater.getSporterOne().getMatchScore() > normal_decorater.getSporterTwo().getMatchScore()) {
				assertEquals(6, sporter_one.getRankScore());
				assertEquals(0.2, sporter_one.getLevel(), 1);
			} else if (normal_decorater.getSporterOne().getMatchScore() == normal_decorater.getSporterTwo()
					.getMatchScore()) {
				assertEquals(4, sporter_one.getRankScore());
				assertEquals(0.15, sporter_one.getLevel(), 1);
			} else {
				assertEquals(3, sporter_one.getRankScore());
				assertEquals(0.1, sporter_one.getLevel(), 1);
			}

		} else if (normal.getSporterOne().getMatchScore() == normal.getSporterTwo().getMatchScore()) {
			assertEquals(1, sporter_one.getRankScore());
			assertEquals(0.05, sporter_one.getLevel(), 1);

			MatchNormal normal_decorater = new MatchNormal(sporter_one, sporter_two, sport);
			normal_decorater.setMatch(normal);
			normal_decorater.startMatch();

			if (normal_decorater.getSporterOne().getMatchScore() > normal_decorater.getSporterTwo().getMatchScore()) {
				assertEquals(4, sporter_one.getRankScore());
				assertEquals(0.15, sporter_one.getLevel(), 1);
			} else if (normal_decorater.getSporterOne().getMatchScore() == normal_decorater.getSporterTwo()
					.getMatchScore()) {
				assertEquals(2, sporter_one.getRankScore());
				assertEquals(0.1, sporter_one.getLevel(), 1);
			} else {
				assertEquals(1, sporter_one.getRankScore());
				assertEquals(0.05, sporter_one.getLevel(), 1);
			}

		} else {
			assertEquals(0, sporter_one.getRankScore());
			assertEquals(0, sporter_one.getLevel(), 1);

			MatchNormal normal_decorater = new MatchNormal(sporter_one, sporter_two, sport);
			normal_decorater.setMatch(normal);
			normal_decorater.startMatch();

			if (normal_decorater.getSporterOne().getMatchScore() > normal_decorater.getSporterTwo().getMatchScore()) {
				assertEquals(3, sporter_one.getRankScore());
				assertEquals(0.1, sporter_one.getLevel(), 1);
			} else if (normal_decorater.getSporterOne().getMatchScore() == normal_decorater.getSporterTwo()
					.getMatchScore()) {
				assertEquals(1, sporter_one.getRankScore());
				assertEquals(0.05, sporter_one.getLevel(), 1);
			} else {
				assertEquals(0, sporter_one.getRankScore());
				assertEquals(0, sporter_one.getLevel(), 1);
			}
		}

	}

	/**
	 * This is to test that Strategy Pattern can work well for different sports.
	 */
	@Test
	public void testStrategyPatternForStrategyClass() {
		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);
		Sporter sporter_three = new Player(3);
		Sporter sporter_four = new Player(4);

		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(sporter_one);
		sporters.add(sporter_two);
		sporters.add(sporter_three);
		sporters.add(sporter_four);

		Sport soccer = new SportSoccer();
		RoundModel strategy = new RoundRobin(sporters, soccer);
		strategy.startGame();
		assertEquals(6, strategy.getScores().size());

		Sport basketball = new SportBasketball();
		strategy.setSport(basketball);
		strategy.startGame();
		assertEquals(6, strategy.getScores().size());

		Sport tennis = new SportTennis();
		strategy.setSport(tennis);
		strategy.startGame();
		assertEquals(6, strategy.getScores().size());

	}

	/**
	 * This is to test that Strategy Pattern can work well about choosing
	 * strategy for tournament
	 */
	@Test
	public void testStrategyPatternForTournamentClass() {
		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);
		Sporter sporter_three = new Player(3);
		Sporter sporter_four = new Player(4);

		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(sporter_one);
		sporters.add(sporter_two);
		sporters.add(sporter_three);
		sporters.add(sporter_four);

		Sport sport = new SportBasketball();

		RoundModel roundRobin = new RoundRobin(sporters, sport);
		Tournament tournament = new Tournament(roundRobin);
		tournament.Start();
		assertEquals(6, tournament.getStrategy().getScores().size());

		RoundModel roundRound = new RoundRound(sporters, sport);
		tournament.setStrategy(roundRound);
		tournament.Start();
		assertEquals(12, tournament.getStrategy().getScores().size());

		RoundModel roundKickOut = new RoundKickOut(sporters, sport);
		tournament.setStrategy(roundKickOut);
		tournament.Start();

		boolean result = false;
		if (tournament.getStrategy().getScores().size() >= 3) {
			result = true;
		}
		assertEquals(true, result);

	}

	/**
	 * This is to test that observer pattern can work well.
	 */
	@Test
	public void testOberverPatternForSupporterClasses() {

		Sporter sporter_one = new Player(0);
		Sporter sporter_two = new Player(1);
		Sporter sporter_three = new Player(3);
		Sporter sporter_four = new Player(4);

		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(sporter_one);
		sporters.add(sporter_two);
		sporters.add(sporter_three);
		sporters.add(sporter_four);

		Sport sport = new SportBasketball();
		RoundModel roundRobin = new RoundRobin(sporters, sport);
		Tournament tournament = new Tournament(roundRobin);

		Supporter supporter = new Supporter(0, tournament.getResult());
		assertEquals(null, supporter.getScores());
		tournament.Start();
		supporter.setSporter(sporter_one);
		tournament.getResult().setMeasurements(tournament.getStrategy().getScores());

		assertEquals(6, supporter.getScores().size());

		Score score = new Score(sporter_one, sporter_two);
		tournament.getStrategy().getScores().add(score);
		assertEquals(7, supporter.getScores().size());

	}

	/**
	 * This is to test that a single player can not match with team player
	 */
	@Test
	public void testSinglePlayerCanNotMatchWithTeamPlayer() {
		Sporter player = new Player(0);

		Sporter playersTeam = new PlayersTeam(1);
		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(player);
		sporters.add(playersTeam);

		Sport sport = new SportBasketball();
		RoundModel roundRobin = new RoundRobin(sporters, sport);
		roundRobin.startGame();
		assertEquals(0, roundRobin.getScores().size());

		Sporter player_two = new Player(2);
		sporters.add(player_two);
		RoundModel roundRobin_two = new RoundRobin(sporters, sport);
		roundRobin_two.startGame();
		assertEquals(1, roundRobin_two.getScores().size());
	}

	/**
	 * This is to test that single player can not use team strategy
	 */
	@Test
	public void testSinglePlayerCanNotUseTeamStrategy() {
		Sporter player = new Player(0);
		Sporter player_two = new Player(1);

		ArrayList<Sporter> sporters = new ArrayList<>();
		sporters.add(player);
		sporters.add(player_two);

		Sport sport = new SportBasketball();
		RoundModel roundRobin = new RoundTeamRobin(sporters, sport);
		roundRobin.startGame();
		assertEquals(0, roundRobin.getScores().size());
	}

}
