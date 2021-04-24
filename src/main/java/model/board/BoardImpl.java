package model.board;

import java.util.ArrayList;
import java.util.List;

import model.box.Box;
import model.box.BoxType;
import model.player.Player;

public final class BoardImpl implements Board {

    private static final int BOARD_LIMIT = 2;
    private static final int MINIGAME_INTERVAL = 5;

    private int size;
    private List<Box> boxes;

    @Override
    public void setSize(final int size) {
        if (size < BOARD_LIMIT) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.boxes = new ArrayList<>();
    }

    @Override
    public List<Box> generateBoard() {
        final List<Box> minigames = getAllBoxesByType(BoxType.MINIGAMES);
        boxes.add(Box.START);
        int minigameNumber = 0;
        for (int i = 1; i < size - 1; i++) {
            if (i % MINIGAME_INTERVAL == 0) {
               minigameNumber = minigameNumber == minigames.size() ? 0 : minigameNumber;
               boxes.add(minigames.get(minigameNumber));
               minigameNumber++;
            } else {
                boxes.add(Box.NORMAL);
            }
        }
        boxes.add(Box.END);
        System.out.println(boxes);
        return boxes;
    }

    @Override
    public Box getBox(final Player p) {
        return boxes.get(p.getBoardPosition());
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
