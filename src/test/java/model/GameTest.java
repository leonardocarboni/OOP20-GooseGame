package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.game.Game;
import model.game.GameImpl;
import model.player.Player;
import model.player.PlayerColor;
import model.player.PlayerImpl;

class GameTest {

    private static final int BOARD_SIZE = 41;
    private final Game g = new GameImpl();
    private final List<Player> list = new ArrayList<>();

    @BeforeEach 
    void initListPlayers() {
        list.add(new PlayerImpl("Ciao", PlayerColor.PINK));
        list.add(new PlayerImpl("Ciao2", PlayerColor.PINK));
        list.add(new PlayerImpl("Ciao4", PlayerColor.PINK));
    }

    @Test
    void checkEndGame() {
        g.start(list);
        assertFalse(g.endGame());
        do {
            g.rollCurrentPlayer();
        } while (!g.endGame());

        assertEquals(g.getScoreBoard().get(0).getBoardPosition(), BOARD_SIZE);
        assertNotSame(g.getScoreBoard().get(1).getBoardPosition(), BOARD_SIZE);
        assertNotSame(g.getScoreBoard().get(2).getBoardPosition(), BOARD_SIZE);
    }

    @Test
    void chechNewGame() {
        g.start(list);
        while (true) {
            g.rollCurrentPlayer();
            if (g.endGame()) {
                break;
            }
            g.nextPlayer();
        }
        g.start(list);
        assertEquals(g.getScoreBoard().get(0).getBoardPosition(), 0);
        assertEquals(g.getScoreBoard().get(1).getBoardPosition(), 0);
        assertEquals(g.getScoreBoard().get(2).getBoardPosition(), 0);
    }
}
