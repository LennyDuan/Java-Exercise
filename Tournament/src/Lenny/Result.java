package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 *
 *         This result class is to implement Subject interface.
 */
public class Result implements Subject {

	private ArrayList observers;
	private ArrayList<Score> scores;

	public Result() {
		observers = new ArrayList();
	}

	/**
	 * There will have lots of observes. The observer can be add to the list.
	 */
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	/**
	 * An observer can remove from the observer list.
	 */
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	/**
	 * When the subject change, all the observer in the list will notify.
	 */
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(scores);
		}
	}

	/**
	 * When the subject change, all the observer in the list will notify.
	 */
	public void measurementChanged() {
		notifyObservers();
	}

	public void setMeasurements(ArrayList<Score> scores) {
		this.scores = scores;
		measurementChanged();

	}
}
