package model.queue;

import java.util.List;
import java.util.Map;

import model.player.PlayerImpl;

public interface Queue {

    /**
     * Set playerQueue with map keys and ordering using map values.
     * 
     * @param diceThrowing
     */
    void orderPlayerQueue(Map<PlayerImpl, Integer> diceThrowing);

    /**
     * Set starting player queue.
     * 
     * @param list
     */
    void setStartingQueue(List<PlayerImpl> list);

    /**
     * Get current player.
     * 
     * @return current player
     */
    PlayerImpl getCurrent();

    /**
     * Get starting queue.
     * 
     * @return list of players
     */
    List<PlayerImpl> getStartingQueue();

    /**
     * Reset the queue at the starting point. Usefull when change the player queue
     */
    void resetIterator();

}
