package model.board;

import java.util.ArrayList;
import java.util.List;

import model.box.Box;
import model.box.BoxType;
import model.player.PlayerImpl;

public class BoardImpl implements Board {

    private final int size;
    private final List<Box> boxes;
    private static final int BOARD_LIMIT = 2;
    private static final int MINIGAME_INTERVAL = 5;
    public BoardImpl(final int size) {
        this.size = size;
        this.boxes = new ArrayList<>(size);
    }

    @Override
    public List<Box> generateBoard() {
        checkSize(size);
        final List<Box> minigames = getAllBoxesByType(BoxType.MINIGAMES);
        boxes.add(Box.START);
        int minigameNumber = 0;
        for (int i = 0; i < size - 1; i++) {
            if (i % MINIGAME_INTERVAL == 0) {
               boxes.add(minigames.get(minigameNumber));
               minigameNumber++;
            } else {
                boxes.add(Box.NORMAL);
            }
        }
        boxes.add(Box.END);
        return boxes;
    }

    @Override
    public Box getBox(final PlayerImpl p) {
        return boxes.get(p.getBoardPosition());
    }

    /*
     * @param size of board
     * 
     * @throw exception in case the number inserted is too small to create a board
     */
    private void checkSize(final int size) {
        if (size < BOARD_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * Function to get all boxes that matches the filter
     * 
     * @param type of Boxes to filter
     * 
     * @return list of boxes
     */
    private List<Box> getAllBoxesByType(final BoxType type) {
        final List<Box> list = new ArrayList<>();
        for (final Box b : Box.values()) {
            if (b.getType().equals(type)) {
                list.add(b);
            }
        }
        return list;
    }
}
