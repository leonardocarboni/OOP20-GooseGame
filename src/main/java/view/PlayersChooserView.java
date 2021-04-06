package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayersChooserView implements Initializable {
    @FXML
    private Button startButton;
    @FXML
    private List<TextField> playersName;
    @FXML
    private Label errorLabel;

	private static final String LAYOUT_LOCATION = "layouts/playerselection.fxml";
	private static final String LOGO_LOCATION = "logo.png";
	private final Stage stage = new Stage();
	
	public PlayersChooserView() {
		try {
			final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
	        loader.setController(this);
	        final Scene scene = new Scene(loader.load());
	        /* Stage configuration */
	        stage.setTitle("[GooseGame]");
	        stage.getIcons().add(new Image(LOGO_LOCATION));
	        stage.setOnHiding(e -> {
	        	stage.setIconified(true);
	        });
	        stage.setScene(scene);
	        stage.setResizable(true);
	        stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    	
    }

    public List<String> getPlayersNames() {
    	final List<String> l = new ArrayList<>();
    	for (final TextField s : playersName) {
			l.add(s.getText());
		}
    	return l;
    }
    
    public void setErrorLabelText(final String s) {
    	errorLabel.setText(s);
    }
    
    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        startButton.setOnAction(eventHandler);
    }

	public void close() {
		stage.close();
	}
}
