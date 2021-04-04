package model.game;

import java.util.List;

import model.box.Box;
import model.player.PlayerImpl;

public interface Game {

	/*
	 * @param 
	 */
	void start(final List<PlayerImpl> playerList);

	/*
	 * 
	 */
	int rollCurrentPlayer();
	
	/*
	 * 
	 */
	Box playCurrentPlayer();
	
	/*
	 * 
	 */
	List<PlayerImpl> getScoreBoard();
	
	/*
	 * 
	 */
	PlayerImpl nextPlayer();
	
	/*
	 * 
	 */
	boolean end();
	
	/*
	 * 
	 */
	void saveResultGame();
}
