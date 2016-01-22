package Lenny;

/**
 * 
 * @author Lenny
 *
 *         This is subject interface for observers
 */
public interface Subject {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}
