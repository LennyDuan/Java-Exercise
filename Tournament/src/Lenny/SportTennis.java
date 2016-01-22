package Lenny;

import java.util.Random;

/**
 * 
 * @author Lenny
 *
 *         This is SportTennis class which implements Sport interface
 */
public class SportTennis implements Sport {
	/**
	 * Winner get 1 rank point.
	 */
	public int getWin() {
		return 1;
	}

	/**
	 * Loser get 0 rank point.
	 */
	public int getLose() {
		return 0;
	}

	/**
	 * Equal get 0 rank point.
	 */
	public int getEqual() {

		return 0;
	}

	/**
	 * The score is calculated by sporter's level. In tennis, there are only 4
	 * scores: 0, 15, 30 and 40.
	 */
	public int calculate(double level) {
		Random random;
		int score_ran = 0;
		try {
			random = new Random();
			score_ran = random.nextInt(4);
		} catch (Exception e) {
		}
		int score = (int) (((level + 100) / 100) * score_ran);
		int mark = 0;
		switch (score) {
		case 0:
			mark = 0;
			break;
		case 1:
			mark = 15;
			break;
		case 2:
			mark = 30;
			break;
		case 3:
			mark = 40;
			break;
		default:
			mark = 40;
			break;
		}
		return mark;
	}
}
