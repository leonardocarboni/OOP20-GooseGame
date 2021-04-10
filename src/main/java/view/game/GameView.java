package view.game;

import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public interface GameView {

	void changeImageDice(final int value);

	void changeScoreboard(final List<String> list);

	void changeGameStateLabel(final String s);

	void changePlayerLabel(final String s);

	void addButtonListener(final EventHandler<ActionEvent> eventHandler);

	void resetAllButtons();

	void changeAllButtons(final Map<Color,Integer> position);

	
}
