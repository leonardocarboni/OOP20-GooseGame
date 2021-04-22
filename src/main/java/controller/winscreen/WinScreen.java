package controller.winscreen;

import java.util.List;

import model.duration.GameDuration;
import model.player.Player;

public interface WinScreen {
    /**
     *
     * @param playerList
     * @param duration
     */
    void start(List<Player> playerList, GameDuration duration);
}
