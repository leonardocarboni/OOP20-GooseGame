package model.rank;

import java.util.List;

import model.player.Player;

public interface Rank {

    /**
     * Update the current rank by boardPosition of player.
     */
    void updateRanking();

    /**
     * Get the current rank of players.
     * 
     * @return list of players
     */
    List<Player> getRanking();

    /**
     * Set ranking using the parameter passed.
     * 
     * @param list - list of players. This list must contain at least one element.
     * @throws IllegalStateException caused by a list with 0 elements.
     */
    void setRanking(List<Player> list);
}
