package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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

    @FXML
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
    
    @FXML
    private void clickCreditsButton() {
    	final Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
    }
    
    @FXML
    private void clickExitButton() {
    	System.out.println("Calling Platform.exit():");
        Platform.exit();
        System.out.println("Calling System.exit(0):");
        System.exit(0);
    }
    
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
    }

}
