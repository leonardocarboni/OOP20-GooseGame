package controller.winscreen;

import java.util.List;

import model.player.PlayerImpl;

public interface WinScreen {
    /**
     * 
     * @param playerList
     */
    void start(List<PlayerImpl> playerList);
}
