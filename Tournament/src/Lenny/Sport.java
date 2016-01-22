package Lenny;

/**
 * 
 * @author Lenny
 * 
 *         This is Sport interface. Different sports have different point
 *         calculating and ranking mechanism.
 */
public interface Sport {

	public int calculate(double level);

	public int getWin();

	public int getLose();

	public int getEqual();

}
