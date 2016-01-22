package Lenny;

import java.util.Random;

/**
 * 
 * @author Lenny
 *
 *         This is SportSoccer class which implements Sport interface
 */
public class SportSoccer implements Sport {
	/**
	 * Winner get 3 rank point.
	 */
	public int getWin() {
		return 3;
	}

	/**
	 * Loser get 0 rank point.
	 */
	public int getLose() {
		return 0;
	}

	/**
	 * Equal get 1 rank point.
	 */
	public int getEqual() {

		return 1;
	}

	/**
	 * The score is calculated by sporter's level .
	 */
	public int calculate(double level) {
		Random random = new Random();
		int score = (int) (((10 + level) / 10) * random.nextInt(6));
		return score;
	}

}
