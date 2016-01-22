package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 * 
 *         This is the Observer interface that the supporter should to
 *         implement. The subject for update is the list of scores.
 */
public interface Observer {
	public void update(ArrayList<Score> scores);
}
