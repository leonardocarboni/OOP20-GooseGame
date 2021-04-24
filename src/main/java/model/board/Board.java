package model.board;

import java.util.List;

import model.box.Box;
import model.player.Player;

public interface Board {

    /**
     * Set size of board.
     * @throws IllegalArgumentException when size is less then 2
     * @param size
     */
    void setSize(int size);
    /**
     * Create the board of game.
     * 
     * @return list of boxes that equals to the game board
     */
    List<Box> generateBoard();

    /**
     * Get type of box where the player is above now.
     * 
     * @param player
     * @return type of the box
     */
    Box getBox(Player player);
}
