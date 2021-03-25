package model.dice;

public class DiceImpl {

	static private final int MIN_VALUE_DICE = 1;
	static private final int MAX_VALUE_DICE = 6;
	
	/**
	 * @return random value of dice 
	 */
	public int roll() {
		return (int)(Math.random() * ((MAX_VALUE_DICE - MIN_VALUE_DICE) + 1)) + MIN_VALUE_DICE;
	}
}
