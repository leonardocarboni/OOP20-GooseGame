package model.rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.player.Player;

public class RankImpl implements Rank {

    private List<Player> ranking;

    public RankImpl() {
        ranking = new ArrayList<>();
    }

    @Override
    public void updateRanking() {
        ranking.sort(Comparator.comparing(Player::getBoardPosition).reversed());
    }

    @Override
    public List<Player> getRanking() {
        return ranking;
    }

    @Override
    public void setRanking(final List<Player> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ranking = list;
    }

}
