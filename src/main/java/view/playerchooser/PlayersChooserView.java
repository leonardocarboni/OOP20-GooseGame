package view.playerchooser;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface PlayersChooserView {

	/*
	 * Create a Map
	 * @return Map<String,String> 
	 */
	Map<String,String> getPlayersInfo();
	
	/*
	 * @param text
	 */
	void setErrorLabelText(final String text);
	
	/*
	 * @param EventHandler<ActionEvent>
	 */
	void addButtonListener(final EventHandler<ActionEvent> eventHandler);
}
