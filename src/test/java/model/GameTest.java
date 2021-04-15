package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import model.game.GameImpl;
import model.player.PlayerColor;
import model.player.PlayerImpl;

class GameTest {

    private static final int BOARD_SIZE = 41;
    private final GameImpl g = new GameImpl();
    private final List<PlayerImpl> list = new ArrayList<>();

    @BeforeEach 
    void initListPlayers() {
        list.add(new PlayerImpl("Ciao", PlayerColor.PINK));
        list.add(new PlayerImpl("Ciao2", PlayerColor.PINK));
        list.add(new PlayerImpl("Ciao4", PlayerColor.PINK));
    }
    @Test
    void test() {
        g.start(list);
        assertFalse(g.endGame());
        do {
            g.rollCurrentPlayer();
        } while (!g.endGame());

        assertEquals(g.getScoreBoard().get(0).getBoardPosition(), BOARD_SIZE);
        assertNotSame(g.getScoreBoard().get(1).getBoardPosition(), BOARD_SIZE);
        assertNotSame(g.getScoreBoard().get(2).getBoardPosition(), BOARD_SIZE);

        g.start(list);

        assertEquals(g.getScoreBoard().get(0).getBoardPosition(), 0);
        assertNotSame(g.getScoreBoard().get(1).getBoardPosition(), 0);
        assertNotSame(g.getScoreBoard().get(2).getBoardPosition(), 0);
    }

    @RepeatedTest(3)
    void checkBoardLimit() {
        int total = 0;
        do {
            total += g.rollCurrentPlayer();
        } while (!g.endGame() || total < BOARD_SIZE);
        assertEquals(g.getScoreBoard().get(0).getBoardPosition(), total - BOARD_SIZE);
    }
}
