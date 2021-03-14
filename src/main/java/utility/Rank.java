package utility;

import java.util.Comparator;
import java.util.List;

import model.Player;

public class Rank {
	
	private final List<Player> ranking;

	public Rank(final List<Player> listPlayer) {
		ranking = listPlayer;
	}

	public void updateRanking() {
		ranking.sort(Comparator.comparing(Player::getBoardPosition).reversed());
	}
	
	
	public List<Player> getRanking() {
		return ranking;
	}
}
