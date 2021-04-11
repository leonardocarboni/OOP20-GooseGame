package view.game;

import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public interface GameView {

	/**
	 * Change image of button according to the value 
	 * @param value
	 */
	void changeImageDice(final int value);

	/**
	 * Change text of every label of scoreboard using param
	 * @param list
	 */
	void changeScoreboard(final List<String> list);

	/**
	 * Change text of the game state label
	 * @param text
	 */
	void changeGameStateLabel(final String text);

	/**
	 * Change text of the player label
	 * @param text
	 */
	void changePlayerLabel(final String text);

	/**
	 * 
	 * @param eventHandler
	 */
	void addButtonListener(final EventHandler<ActionEvent> eventHandler);

	/**
	 * Remove all elements inside of the HBoxes
	 */
	void resetAllBoxes();

	/**
	 * Update all boxes checking if there is any players on it or not
	 * @param position
	 */
	void changeAllBoxes(final Map<Color,Integer> position);

	
}
