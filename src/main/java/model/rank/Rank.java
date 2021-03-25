package model.rank;

import java.util.List;

import model.player.PlayerImpl;

public interface Rank {

	void updateRanking();

	List<PlayerImpl> getRanking();
}
