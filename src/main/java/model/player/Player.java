package model.player;

public interface Player {

	/**
	 * Get name of player
	 * @return String
	 */
	String getName();

	/**
	 * Set player name
	 * @param name
	 */
	void setName(final String name);

	/**
	 * Get actual board position of the player
	 * @return 
	 */
	int getBoardPosition();

	/**
	 * Add dice result to current position of the player
	 * @param diceValue
	 */
	void addPosition(final int diceValue);

	/**
	 * Set position of the player to 0
	 */
	void resetPosition();
	
	/**
	 * Get color of the player
	 * @return PlayerColor 
	 */
	PlayerColor getColor();
}
