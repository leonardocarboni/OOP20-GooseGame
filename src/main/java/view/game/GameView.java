package view.game;

import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public interface GameView {

    /**
     * Change image of button according to the value.
     * 
     * @param value
     */
    void changeImageDice(int value);

    /**
     * Change text of every label of score board using list.
     * 
     * @param list
     */
    void changeScoreboard(List<String> list);

    /**
     * Change text of the game state label.
     * 
     * @param text
     */
    void changeGameStateLabel(String text);

    /**
     * Change text of the player label.
     * 
     * @param text
     */
    void changePlayerLabel(String text);

    /**
     * 
     * @param eventHandler
     */
    void addButtonListener(EventHandler<ActionEvent> eventHandler);

    /**
     * Remove all elements inside of the HBoxes.
     */
    void resetAllBoxes();

    /**
     * Update all boxes checking if there is any players on it or not.
     * 
     * @param position
     */
    void changeAllBoxes(Map<Color, Integer> position);

    /**
     * Shows the latest minigame result on a label.
     * @param result - the latest minigame result
     */
    void showResult(int result);
}
