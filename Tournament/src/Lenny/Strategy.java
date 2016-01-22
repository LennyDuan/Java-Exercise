package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 *
 *         This is the strategy interface.
 */
public interface Strategy {

	public void startGame();

	public void matching();

	public void endGame();

	public ArrayList<Sporter> getRank();

	public ArrayList<Score> getScores();
}
