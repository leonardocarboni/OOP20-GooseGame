package controller.winscreen;

import java.util.List;

import model.duration.GameDuration;
import model.player.PlayerImpl;

public interface WinScreen {
    /**
     *
     * @param playerList
     * @param duration
     */
    void start(List<PlayerImpl> playerList, GameDuration duration);
}
