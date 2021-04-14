package view.playerchooser;

import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface PlayersChooserView {

	/**
	 * Create a Map
	 * @return Map<String,String> 
	 */
	Map<String, String> getPlayersInfo();
	
	/**
	 * @param text
	 */
	void setErrorLabelText(String text);
	
	/**
	 * @param eventHandler
	 */
	void addButtonListener(EventHandler<ActionEvent> eventHandler);

	/*
	 * @param text
	 */
	void setTextComboBox(List<String> listName);
}
