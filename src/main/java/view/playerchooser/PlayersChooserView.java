package view.playerchooser;

import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface PlayersChooserView {

    /**
     * Create a Map.
     * @return Map<String,String>
     */
    Map<String, String> getPlayersInfo();

    /**
     * Set Text of Error Label.
     * @param text
     */
    void setErrorLabelText(String text);

    /**
     * Add an eventHandler to check when button is pressed.
     * @param eventHandler
     */
    void addButtonListener(EventHandler<ActionEvent> eventHandler);

    /*
     * Add text to combo box.
     * @param text
     */
    void setTextComboBox(List<String> listName);
}
