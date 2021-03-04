package application;

import application.minigame.cableconnect.CableConnect;
import application.minigame.tictactoe.TicTacToe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    Button play_button;
    @FXML
    Button settings_button;
    @FXML
    Button credits_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        play_button.setOnMouseClicked((event) -> {
            //System.out.println("Play Cliccato");
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            CableConnect cc = new CableConnect();
            try {
                cc.start(newStage);
            } catch (Exception e){
                System.out.println("Errore nell'apertura");
            }

        });
        settings_button.setOnMouseClicked((event) -> {
            //System.out.println("Settings Cliccato");
            TicTacToe ticTacToe = new TicTacToe();
            try {
                ticTacToe.start(new Stage());
            } catch (Exception e){
                System.out.println("Errore nell'apertura");
            }
        });
        credits_button.setOnMouseClicked((event) -> {
            //System.out.println("Credits Cliccato");
        });
    }

}
