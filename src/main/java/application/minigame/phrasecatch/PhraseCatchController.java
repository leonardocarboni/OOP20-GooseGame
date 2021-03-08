package application.minigame.phrasecatch;

import application.utilities.Countdown;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PhraseCatchController implements Initializable {

    @FXML
    Button submitButton;
    @FXML
    TextField inputTextField;
    @FXML
    Label textLabel, timeLabel;

    private Countdown countdown;
    private String textToCopy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countdown = new Countdown(15, timeLabel);
        countdown.start();
        initializeText();
        initializePhrase();
        initializeEventHandlers();
    }

    private void initializeText() {
        textToCopy = "Sassi Matti cani";
        textLabel.setText(textToCopy);
    }

    private void initializeEventHandlers() {
        submitButton.setOnMouseClicked(e -> {
            int secondsLeft = countdown.getSecondsLeft();
            countdown.shutdown();
            String textRead = inputTextField.getText();
            int errors = checkText(textRead);
            System.out.println("Errori: " + errors + ", Secondi Rimasti: " + secondsLeft);
        });
    }

    private int checkText(String textRead) {
        int errors = Math.abs(textToCopy.length() - textRead.length());

        for(int i = 0; i < Math.min(textToCopy.length(), textRead.length())-1; i++) {
            if(textRead.charAt(i) != textToCopy.charAt(i)) {
                errors++;
            }
        }
        return errors;
    }

    private void initializePhrase() {
        
    }

}
