package application.minigame.cableconnect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

public class CableConnectController implements Initializable {
    @FXML
    Button startButton0;
    @FXML
    Button startButton1;
    @FXML
    Button startButton2;
    @FXML
    Button startButton3;
    @FXML
    Button endButton0;
    @FXML
    Button endButton1;
    @FXML
    Button endButton2;
    @FXML
    Button endButton3;

    final private Random rand = new Random();
    final private Colors[] colorsArray = Colors.getColors();
    final private Colors[] randomColorsArray = Colors.getColors();
    final private Map<Button, Colors> startButtonsMap = new HashMap<>();
    final private Map<Button, Colors> endButtonsMap = new HashMap<>();
    final private Set<Colors> colorsDone = new HashSet<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeButtonsMap();
        initializeStartButtons();
        initializeEndButtons();
        initializeEventHandlers();

    }

    /**
     * Initializes start and end buttons' onClick handlers.
     */
    private void initializeEventHandlers() {
        //should draw a line tho [TBI]
        startButtonsMap.forEach((button, color) -> button.setOnMouseClicked(e -> disableOtherButtons(color)));
        endButtonsMap.forEach((button, color) -> button.setOnMouseClicked(e -> enableOtherButtons(color)));
    }

    private void enableOtherButtons(Colors color) {
        colorsDone.add(color);
        //enable the buttons whom color is not contained in the list
        startButtonsMap.forEach((b, c) -> b.setDisable(colorsDone.contains(c)));
        endButtonsMap.forEach((b, c) -> b.setDisable(colorsDone.contains(c)));
    }

    private void disableOtherButtons(Colors color) {
        startButtonsMap.keySet().forEach(b -> b.setDisable(true));
        //disable buttons with a different color
        endButtonsMap.forEach((b,c) -> b.setDisable(!c.equals(color)));
    }

    /**
     * Maps all the start buttons with their own color and the end buttons with a randomized
     * sequence of the same color.
     */
    private void initializeButtonsMap() {
        startButtonsMap.put(startButton0, colorsArray[0]);
        startButtonsMap.put(startButton1, colorsArray[1]);
        startButtonsMap.put(startButton2, colorsArray[2]);
        startButtonsMap.put(startButton3, colorsArray[3]);

        //shuffle end colors array
        for (int i = 0; i < randomColorsArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(randomColorsArray.length);
            Colors temp = randomColorsArray[randomIndexToSwap];
            randomColorsArray[randomIndexToSwap] = randomColorsArray[i];
            randomColorsArray[i] = temp;
        }

        endButtonsMap.put(endButton0, randomColorsArray[0]);
        endButtonsMap.put(endButton1, randomColorsArray[1]);
        endButtonsMap.put(endButton2, randomColorsArray[2]);
        endButtonsMap.put(endButton3, randomColorsArray[3]);
    }

    /**
     * Initialize start buttons giving them their color (static order).
     */
    private void initializeStartButtons() {
        startButton0.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton0));
        startButton1.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton1));
        startButton2.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton2));
        startButton3.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton3));
    }

    /**
     * Initialize end buttons giving them their color (random order).
     */
    private void initializeEndButtons() {
        endButton0.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton0));
        endButton1.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton1));
        endButton2.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton2));
        endButton3.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton3));

        endButton0.setDisable(true);
        endButton1.setDisable(true);
        endButton2.setDisable(true);
        endButton3.setDisable(true);
    }


    //thread per contare i secondi
    //colorazione random 4 bottoni iniziali e finali
    //sul click del bottone si guarda a quale colore corrisponde
    //quando clicca su un bottone finale con lo stesso colore si segna questa cosa
    //quando viene chiuso il quarto si ferma il timer e si verifica
    //se il timer finisce prima si è perso e si torna indietro di 6
}
