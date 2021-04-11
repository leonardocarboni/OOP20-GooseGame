package model.game;

import java.util.List;

import model.box.Box;
import model.player.PlayerImpl;

public interface Game {

	/**
	 * Initialize game 
	 * @param playerList
	 */
	void start(final List<PlayerImpl> playerList);

	/**
	 * Create the starting queue 
	 * @return value of the dice roll
	 */
	int choosePlayersQueue();

	/**
	 * Roll dice 
	 * @return value of the dice roll
	 */
	int rollCurrentPlayer();
	
	/**
	 * Get the type of box where current player is
	 * @return enum with type of box
	 */
	Box playCurrentPlayer();
	
	/**
	 * Get update scoreboard
	 * @return list of player
	 */
	List<PlayerImpl> getScoreBoard();
	
	/**
	 * Get next player
	 * @return player
	 */
	PlayerImpl nextPlayer();
	
	/**
	 * 
	 * @return
	 */
	boolean endGame();
	
	/**
	 *  Save scoreboard in the file 
	 */
	void saveResultGame();

	/**
	 * Add value to current position of player
	 * @param value
	 */
	void movePlayer(final int value);

	/**
	 * Get State Game
	 * @return enum with current state of game
	 */
	StateGame getStateGame();
}
