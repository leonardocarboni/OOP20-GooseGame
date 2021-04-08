package application;

import application.minigame.memory.Memory;
import application.minigame.sassocartaforbici.SassoCartaFrobici;
import application.minigame.tictactoe.mainGame.TicTacToe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button playButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button creditsButton;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
    	playButton.setOnMouseClicked((event) -> {
            //System.out.println("Play Cliccato");
            final Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            final Memory memory = new Memory();
            try {
                memory.start(newStage);
            } catch (Exception e){
                System.out.println("Errore nell'apertura");
            }

        });
    	settingsButton.setOnMouseClicked((event) -> {
            //System.out.println("Settings Cliccato");
            final Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            final TicTacToe ticTacToe = new TicTacToe();
            try {
                ticTacToe.start(newStage);
            } catch (Exception e){
                System.out.println("Errore nell'apertura");
            }
        });
    	creditsButton.setOnMouseClicked((event) -> {
            //System.out.println("Credits Cliccato");
            final Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            final SassoCartaFrobici sassoCartaFrobici = new SassoCartaFrobici();
            try {
                sassoCartaFrobici.start(newStage);
            } catch (Exception e){
                System.out.println("Errore nell'apertura");
            }
        });
    }

}
