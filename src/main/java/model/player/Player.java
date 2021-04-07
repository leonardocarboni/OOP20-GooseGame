package model.player;

public interface Player {

	/*
	 * @return String
	 */
	String getName();

	/*
	 * @param name 
	 * Setting player name
	 */
	void setName(final String name);

	/*
	 * @return actual board position of the player
	 */
	int getBoardPosition();

	/*
	 * @param diceValue
	 * Adding dice result to current position of the player
	 */
	void addPosition(final int diceValue);

	/*
	 * Set position of the player to 0
	 */
	void resetPosition();
	
	/*
	 * @return PlayerColor 
	 * Getting color of the player
	 */
	PlayerColor getColor();
}
