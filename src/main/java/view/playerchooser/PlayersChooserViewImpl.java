package view.playerchooser;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PlayersChooserViewImpl extends View implements Initializable,PlayersChooserView {
    @FXML
    private Button startButton;
    @FXML
    private List<TextField> playersName;
    @FXML
    private List<ComboBox> playersComboBox;
    @FXML
    private Label errorLabel;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        //temp names list [to be read from file]
        Set<String> names = new HashSet<>();
        names.add("Luca");
        names.add("Maria");
        names.add("Filippo");
        names.add("Alberto");
        names.add("Giovanni");
        for(ComboBox comboBox : playersComboBox)
            comboBox.setItems(FXCollections.observableArrayList(names));
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
