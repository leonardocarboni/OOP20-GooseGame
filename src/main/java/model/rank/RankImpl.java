package model.rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.player.PlayerImpl;

public class RankImpl implements Rank{
	
	private List<PlayerImpl> ranking;

	public RankImpl() {
		ranking = new ArrayList<>();
	}

	@Override
	public void updateRanking() {
		ranking.sort(Comparator.comparing(PlayerImpl::getBoardPosition).reversed());
	}
	
	@Override
	public List<PlayerImpl> getRanking() {
		return ranking;
	}

	@Override
	public void setRanking(final List<PlayerImpl> l) {
		ranking = l;
	}
	
}
