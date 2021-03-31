package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import application.PlayersChooser;

public class MenuController implements Initializable {

    @FXML
    private Button playButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button creditsButton;
    
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
    	playButton.setOnAction(e -> clickPlayButton());
    	settingsButton.setOnAction(e -> clickCreditsButton());
    	creditsButton.setOnAction(e -> clickExitButton());
    }

    private void clickPlayButton() {
    	final Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        final PlayersChooser pc = new PlayersChooser();
        final Stage s = (Stage) playButton.getParent().getScene().getWindow();
        s.close();
        try {
            pc.start(newStage);
        } catch (Exception e){
            System.out.println("Errore nell'apertura");
        }
    }

    private void clickCreditsButton() {
    	final Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
    }

    private void clickExitButton() {
    	System.out.println("Calling Platform.exit():");
        Platform.exit();
        System.out.println("Calling System.exit(0):");
        System.exit(0);
    }
}
