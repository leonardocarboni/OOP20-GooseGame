package model.rank;

import java.util.List;

import model.player.PlayerImpl;

public interface Rank {

	/**
	 * Update the current rank by boardPosition of player.
	 */
	void updateRanking();

	/**
	 * Get the current rank of players.
	 * @return List<PlayerImpl> 
	 */
	List<PlayerImpl> getRanking();

	/**
	 * Set ranking using the parameter passed.
	 * @param list - list of players. This list must contain at least one element.
	 * @throws IllegalStateException caused by a list with 0 element.
	 */
	void setRanking(List<PlayerImpl> list);
}
