package application.minigame.cableconnect;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import view.View;
import view.ViewType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CableConnectView extends View {

    @FXML
    private Button startButton0, startButton1, startButton2, startButton3;
    @FXML
    private Button endButton0, endButton1, endButton2, endButton3;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label timeLabel;

    private Line currentLine;

    private final Map<Button, Colors> startButtonsMap = new HashMap<>();
    private final Map<Button, Colors> endButtonsMap = new HashMap<>();
    private final Set<Colors> colorsDone = new HashSet<>();

    private static final String CSS_BG_COLOR = "-fx-background-color: ";
    private static final String CSS_LINE_STROKE = "-fx-stroke: ";
    private static final int LINE_STROKE = 5;

    public CableConnectView() {
        super.createStage(ViewType.CABLE_CONNECT);
    }

    /**
     * Maps all the start buttons with their own color and the end buttons with a randomized
     * sequence of the same color.
     * @param startColorsArray - the array of the first four colors.
     * @param endColorsArray - the array of the last four colors.
     */
    public void initializeButtonsMap(final Colors[] startColorsArray, final Colors[] endColorsArray) {
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
        startButton0.setStyle(CSS_BG_COLOR + startButtonsMap.get(startButton0));
        startButton1.setStyle(CSS_BG_COLOR + startButtonsMap.get(startButton1));
        startButton2.setStyle(CSS_BG_COLOR + startButtonsMap.get(startButton2));
        startButton3.setStyle(CSS_BG_COLOR + startButtonsMap.get(startButton3));
    }

    /**
     * Initialize end buttons giving them their color (random order).
     */
    public void initializeEndButtons() {
        endButton0.setStyle(CSS_BG_COLOR + endButtonsMap.get(endButton0));
        endButton1.setStyle(CSS_BG_COLOR + endButtonsMap.get(endButton1));
        endButton2.setStyle(CSS_BG_COLOR + endButtonsMap.get(endButton2));
        endButton3.setStyle(CSS_BG_COLOR + endButtonsMap.get(endButton3));

        endButton0.setDisable(true);
        endButton1.setDisable(true);
        endButton2.setDisable(true);
        endButton3.setDisable(true);
    }

    /**
     * generate a starting point for the new line.
     * @param color - the color of the line
     * @param x - x coordinate of the scene
     * @param y - y coordinate of the scene
     */
    private void createLine(final Colors color, final double x, final double y) {
        if (currentLine == null) {
            currentLine = new Line(x, y, x, y);
            currentLine.setStrokeWidth(LINE_STROKE);
            currentLine.setStyle(CSS_LINE_STROKE + color);
            pane.getChildren().add(currentLine);
        } else {
            currentLine = null;
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
        endButtonsMap.forEach((button, color) -> button.addEventHandler(ActionEvent.ACTION, e -> {
            button.setOpacity(1);
            colorsDone.add(color);
            enableOtherButtons();
            if (currentLine != null) {
                currentLine = null;
            }
        }));
    }

    /**
     * re enables the buttons whom color is not contained in the list.
     */
    private void enableOtherButtons() {
        startButtonsMap.forEach((b, c) -> b.setDisable(colorsDone.contains(c)));
        endButtonsMap.forEach((b, c) -> b.setDisable(colorsDone.contains(c)));
    }

    /**
     * disable the buttons with a different color.
     * @param color - the color which doesn't need to be disabled.
     */
    private void disableOtherButtons(final Colors color) {
        startButtonsMap.keySet().forEach(b -> b.setDisable(true));
        endButtonsMap.forEach((b, c) -> {
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

    public Set<Colors> getColorsDone() {
        return this.colorsDone;
    }
}
