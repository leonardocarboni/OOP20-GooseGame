package view.playerchooser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.NormalView;
import view.ViewType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersChooserView extends NormalView {
    @FXML
    private Button startButton;
    @FXML
    private List<TextField> playersName;
    @FXML
    private List<ComboBox<String>> playersComboBox;
    @FXML
    private Label errorLabel;

    public PlayersChooserView() {
        super(ViewType.CHOOSE_PLAYER);
        addComboboxListeners();
    }

    /**
     * Create a Map with player information.
     * @return player info
     */
    public Map<String, String> getPlayersInfo() {
        final Map<String, String> playersInfo = new HashMap<>();
        for (int i = 0; i < playersComboBox.size(); i++) {
            final TextField txtPlayer = playersName.get(i);
            final ComboBox<String> cb = playersComboBox.get(i);

            if ("No Selection".equals(cb.getValue()) || cb.getValue() == null) {
                playersInfo.put(txtPlayer.getId(), txtPlayer.getText());
            } else {
                playersInfo.put(cb.getId(), cb.getValue());
            }
        }
        return playersInfo;
    }

    /**
     * Set Text of Error Label.
     * @param text
     */
    public void setErrorLabelText(final String text) {
        errorLabel.setText(text);
    }

    /**
     * Add an eventHandler to check when button is pressed.
     * @param eventHandler
     */
    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        startButton.setOnAction(eventHandler);
    }

    /*
     * Set text to combo box.
     * @param text
     */
    public void setTextComboBox(final List<String> listNames) {
        listNames.add(0, "No Selection");
        for (final ComboBox<String> cb : playersComboBox) {
            cb.setItems(FXCollections.observableArrayList(listNames));
        }
    }

    /**
     * Function to add a listener combo box.
     */
    private void addComboboxListeners() {
        for (int i = 0; i < playersComboBox.size(); i++) {
            final TextField currentPlayerText = playersName.get(i);
            playersComboBox.get(i).valueProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(final ObservableValue<? extends String> ob, final String ol,
                    final String currentValue) {
                    if ("No Selection".equals(currentValue)) {
                        currentPlayerText.setDisable(false);
                    } else {
                        currentPlayerText.setDisable(true);
                    }
                }
            });
        }
    }
}
