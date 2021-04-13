package view;

import controller.menu.MenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuView extends View implements Initializable {

    @FXML
    private Button playButton;
    @FXML
    private Button howToPlayButton;
    @FXML
    private Button exitButton;
    
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
    	exitButton.setOnAction(e -> this.close());
    }

    public void addPlayButtonListener(final EventHandler<ActionEvent> playClicked) {
    	playButton.setOnAction(playClicked);
    }

    public void addHowToPlayButtonListener(final MenuController.HowToPlayClicked howToPlayClicked) {
        howToPlayButton.setOnAction(howToPlayClicked);
    }
}
