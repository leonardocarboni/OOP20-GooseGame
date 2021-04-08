package model.board;

import java.util.List;

import model.box.Box;
import model.player.PlayerImpl;

public interface Board {

	/*
	 * Function to create the board of game
	 * @param size of game
	 * @param number of minigames in the board
	 * @return List of boxes that equals to the game board
	 */
	List<Box> generateBoard();

	/*
	 * Function to get type of box
	 * @param a player
	 * @return type of box where the player is above now 
	 */
	Box getBox(final PlayerImpl p);
}
