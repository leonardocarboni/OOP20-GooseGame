package application.minigame.cableconnect;

import application.utilities.Countdown;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

public class CableConnectController implements Initializable {
    @FXML
    private Button startButton0, startButton1, startButton2, startButton3;
    @FXML
    private Button endButton0, endButton1, endButton2, endButton3;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label timeLabel;

    static final private int SECONDS = 8;
    static final private int CABLES = 4;

    final private Random rand = new Random();
    final private Colors[] colorsArray = Colors.getColors();
    final private Colors[] randomColorsArray = Colors.getColors();
    final private Map<Button, Colors> startButtonsMap = new HashMap<>();
    final private Map<Button, Colors> endButtonsMap = new HashMap<>();
    final private Set<Colors> colorsDone = new HashSet<>();
    private Line currentLine;
    private Countdown c;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c = new Countdown(SECONDS, timeLabel);
        c.start();

        initializeButtonsMap();
        initializeStartButtons();
        initializeEndButtons();
        initializeEventHandlers();

    }

    /**
     * Initializes start and end buttons onClick handlers for line drawing.
     */
    private void initializeEventHandlers() {
        // disable other buttons and generates a starting point for the line.
        startButtonsMap.forEach((button, color) -> button.setOnMouseClicked(e -> {
            button.setOpacity(1);
            disableOtherButtons(color);
            createLine(color, e.getSceneX(), e.getSceneY());
        }));

        // updates the line end point.
        pane.setOnMouseMoved(e -> {
            if (currentLine != null) {
                currentLine.setEndX(e.getX());
                currentLine.setEndY(e.getY());
            }
        });

        // set the definitive line end point.
        endButtonsMap.forEach((button, color) -> button.setOnMouseClicked(e -> {
            button.setOpacity(1);
            enableOtherButtons(color);
            if (currentLine != null) {
                currentLine = null;
                checkEnd();
            }
        }));
    }

    private void checkEnd() {
        int secondsLeft = c.getSecondsLeft();
        if (colorsDone.size() == CABLES){
            //Alert main game [TBD]
            c.shutdown();
        }
        if (secondsLeft < 0){
            timeLabel.setText("LOST");
        }
    }

    /**
     * generate a starting point for the new line
     * @param color - the color of the line
     * @param x - x coordinate of the scene
     * @param y - y coordinate of the scene
     */
    private void createLine(Colors color, double x, double y){
        if (currentLine == null) {
            currentLine = new Line(x, y, x, y);
            currentLine.setStrokeWidth(5);
            currentLine.setStyle("-fx-stroke: " + color);
            pane.getChildren().add(currentLine);
        } else {
            currentLine = null ;
        }
    }

    /**
     * re enable the buttons whom color is not contained in the list
     * @param color - the color which doesn't need to be re enabled
     */
    private void enableOtherButtons(Colors color) {
        colorsDone.add(color);
        startButtonsMap.forEach((b, c) -> b.setDisable(colorsDone.contains(c)));
        endButtonsMap.forEach((b, c) -> b.setDisable(colorsDone.contains(c)));
    }

    /**
     * disable the buttons with a different color
     * @param color - the color which doesn't need to be disabled
     */
    private void disableOtherButtons(Colors color) {
        startButtonsMap.keySet().forEach(b -> b.setDisable(true));
        endButtonsMap.forEach((b,c) -> {
            b.setDisable(!c.equals(color));
            b.setOpacity(1);
        });
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
