package view.playerchooser;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class PlayersChooserViewImpl extends View implements Initializable,PlayersChooserView {
    @FXML
    private Button startButton;
    @FXML
    private List<TextField> playersName;
    @FXML
    private Label errorLabel;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

    @Override
    public Map<String,String> getPlayersInfo() {
    	final Map<String,String> l = new HashMap<>();
    	for (final TextField s : playersName) {
			l.put(s.getId(), s.getText());
		}
    	return l;
    }

    @Override
    public void setErrorLabelText(final String s) {
    	errorLabel.setText(s);
    }

    @Override
    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        startButton.setOnAction(eventHandler);
    }
}
