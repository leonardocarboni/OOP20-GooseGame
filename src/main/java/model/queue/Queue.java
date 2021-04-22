package model.queue;

import java.util.List;
import java.util.Map;

import model.player.Player;

public interface Queue {

    /**
     * Set playerQueue with map keys and ordering using map values.
     * 
     * @param diceThrowing
     */
    void orderPlayerQueue(Map<Player, Integer> diceThrowing);

    /**
     * Set starting player queue.
     * 
     * @param list
     */
    void setStartingQueue(List<Player> list);

    /**
     * Get current player.
     * 
     * @return current player
     */
    Player getCurrent();

    /**
     * Get starting queue.
     * 
     * @return list of players
     */
    List<Player> getStartingQueue();

    /**
     * Reset the queue at the starting point. Useful when change the player queue
     */
    void resetIterator();

}
