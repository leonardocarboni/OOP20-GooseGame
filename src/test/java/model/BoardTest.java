package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.board.Board;
import model.board.BoardImpl;
import model.box.Box;

public class BoardTest {

    private Board board;
    private static final int FIRST_BOARD_SIZE = 2;
    private static final int SECOND_BOARD_SIZE = 9;
    private static final int THIRD_BOARD_SIZE = 1;

    @BeforeEach
    void init() {
        board = new BoardImpl();
    }

    @Test
    void creationSmallestBoard() {
        final List<Box> listExpected = new ArrayList<>();
        listExpected.add(Box.START);
        listExpected.add(Box.END);
        board.setSize(FIRST_BOARD_SIZE);
        assertEquals(listExpected, board.generateBoard());
    }

    @Test
    void createBoard() {
        final List<Box> listExpected = new ArrayList<>();
        listExpected.add(Box.START);
        listExpected.add(Box.NORMAL);
        listExpected.add(Box.NORMAL);
        listExpected.add(Box.NORMAL);
        listExpected.add(Box.NORMAL);
        listExpected.add(Box.TICTACTOE);
        listExpected.add(Box.NORMAL);
        listExpected.add(Box.NORMAL);
        listExpected.add(Box.END);
        board.setSize(SECOND_BOARD_SIZE);
        assertEquals(listExpected, board.generateBoard());
    }

    @Test
    void launchException() {
        assertThrows(IllegalArgumentException.class, () -> board.setSize(THIRD_BOARD_SIZE));
    }
}
