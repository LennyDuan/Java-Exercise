package Lenny;

import java.util.ArrayList;

/**
 * 
 * @author Lenny
 *
 *         This is Tournament class. In tournament, ther should have a result
 *         for obervers and a pre-defined strategy
 */
public class Tournament {
	private Result result;
	private Strategy strategy;

	public Tournament(Strategy strategy) {
		this.strategy = strategy;
		this.result = new Result();
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Start stragety after all pre-settings are done.
	 */
	public void Start() {
		strategy.startGame();
	}

	public Result getResult() {
		return result;
	}

	public Strategy getStrategy() {
		return strategy;
	}
}
