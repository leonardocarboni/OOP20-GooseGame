package model.rank;

import java.util.Comparator;
import java.util.List;

import model.player.PlayerImpl;

public class RankImpl implements Rank{
	
	private final List<PlayerImpl> ranking;

	public RankImpl(final List<PlayerImpl> listPlayer) {
		ranking = listPlayer;
	}

	public void updateRanking() {
		ranking.sort(Comparator.comparing(PlayerImpl::getBoardPosition).reversed());
	}
	
	
	public List<PlayerImpl> getRanking() {
		return ranking;
	}
}
