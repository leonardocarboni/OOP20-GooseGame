package application.minigame.cableconnect;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utility.countdown.CountdownImpl;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

public class CableConnectView {

    @FXML
    private Button startButton0, startButton1, startButton2, startButton3;
    @FXML
    private Button endButton0, endButton1, endButton2, endButton3;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label timeLabel;

    private Line currentLine;

    private final Stage primaryStage = new Stage();
    private static final String LAYOUT_LOCATION = "layouts/cableconnect.fxml";
    private static final String LOGO_LOCATION = "logo.png";

    final private Map<Button, Colors> startButtonsMap = new HashMap<>();
    final private Map<Button, Colors> endButtonsMap = new HashMap<>();
    final private Set<Colors> colorsDone = new HashSet<>();

    public CableConnectView(){
        try {
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("[GooseGame] Cable Connect");
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> primaryStage.setIconified(true));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maps all the start buttons with their own color and the end buttons with a randomized
     * sequence of the same color.
     */
    public void initializeButtonsMap(Colors[] startColorsArray, Colors[] endColorsArray) {
        startButtonsMap.put(startButton0, startColorsArray[0]);
        startButtonsMap.put(startButton1, startColorsArray[1]);
        startButtonsMap.put(startButton2, startColorsArray[2]);
        startButtonsMap.put(startButton3, startColorsArray[3]);

        endButtonsMap.put(endButton0, endColorsArray[0]);
        endButtonsMap.put(endButton1, endColorsArray[1]);
        endButtonsMap.put(endButton2, endColorsArray[2]);
        endButtonsMap.put(endButton3, endColorsArray[3]);
    }

    /**
     * Initialize start buttons giving them their color (random order).
     */
    public void initializeStartButtons() {
        startButton0.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton0));
        startButton1.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton1));
        startButton2.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton2));
        startButton3.setStyle("-fx-background-color: "+ startButtonsMap.get(startButton3));
    }

    /**
     * Initialize end buttons giving them their color (random order).
     */
    public void initializeEndButtons() {
        endButton0.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton0));
        endButton1.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton1));
        endButton2.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton2));
        endButton3.setStyle("-fx-background-color: "+ endButtonsMap.get(endButton3));

        endButton0.setDisable(true);
        endButton1.setDisable(true);
        endButton2.setDisable(true);
        endButton3.setDisable(true);
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
     * Initializes start and end buttons onClick handlers for line drawing.
     */
    public void initializeEventHandlers() {
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
        endButtonsMap.forEach((button, color) -> button.addEventHandler(ActionEvent.ACTION, e-> {
            button.setOpacity(1);
            colorsDone.add(color);
            enableOtherButtons();
            if (currentLine != null) {
                currentLine = null;
            }
        }));
    }

    /**
     * re enables the buttons whom color is not contained in the list
     */
    private void enableOtherButtons() {
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

    public Label getTimeLabel() {
        return this.timeLabel;
    }

    public void addButtonListener(final EventHandler<ActionEvent> cableConnectedHandler) {
        endButtonsMap.forEach((button, color) -> button.addEventHandler(ActionEvent.ACTION, cableConnectedHandler));
    }

    public void show() {
        this.primaryStage.showAndWait();
    }

    public Set<Colors> getColorsDone() {
        return this.colorsDone;
    }
}
