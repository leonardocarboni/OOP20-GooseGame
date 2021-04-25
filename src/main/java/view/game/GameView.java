package view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.NormalView;
import view.ViewType;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GameView extends NormalView {

    @FXML
    private Button diceButton;
    @FXML
    private ImageView diceImage;
    @FXML
    private List<Label> scoreBoard;
    @FXML
    private List<HBox> gameboard;
    @FXML
    private Label currentPlayerLabel, gameState, mgResultLabel;

    private static final float RADIUS_CIRCLE = 5.0f;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    public GameView() {
        super(ViewType.GAME);
    }

    /**
     * Change image of button according to the value.
     * 
     * @param value
     */
    public void changeImageDice(final int value) {
        String nameDiceImage = "";
        switch (value) {
            case ONE:
                nameDiceImage = "diceOne.png";
                break;
            case TWO:
                nameDiceImage = "diceTwo.png";
                break;
            case THREE:
                nameDiceImage = "diceThree.png";
                break;
            case FOUR:
                nameDiceImage = "diceFour.png";
                break;
            case FIVE:
                nameDiceImage = "diceFive.png";
                break;
            case SIX:
                nameDiceImage = "diceSix.png";
                break;
            default:
                break;
        }
        diceImage.setImage(new Image(ClassLoader.getSystemResource("dice/" + nameDiceImage).toString()));
    }

    /**
     * Change text of every label of score board using list.
     * 
     * @param list
     */
    public void changeScoreboard(final List<String> list) {
        int i = 0;
        for (final String p : list) {
            scoreBoard.get(i).setText(p);
            i++;
        }
    }

    /**
     * Change text of the game state label.
     * 
     * @param text
     */
    public void changeGameStateLabel(final String text) {
        gameState.setText(text);
    }

    /**
     * Change text of the player label.
     * 
     * @param text
     */
    public void changePlayerLabel(final String text) {
        currentPlayerLabel.setText(text);
    }

    /**
     * Add event listener to diceButton.
     * @param eventHandler
     */
    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        diceButton.setOnAction(eventHandler);
    }

    /**
     * Remove all elements inside of the HBoxes.
     */
    private void resetAllBoxes() {
        for (final HBox hb : gameboard) {
            hb.getChildren().clear();
        }
    }

    /**
     * Update all boxes checking if there is any players on it or not.
     * 
     * @param position
     */
    public void changeAllBoxes(final Map<Color, Integer> position) {
        resetAllBoxes();
        for (final Entry<Color, Integer> p : position.entrySet()) {
            gameboard.get(p.getValue()).getChildren().add(createCircle(p.getKey()));
        }
    }

    /**
     * Shows the latest minigame result on a label.
     * 
     * @param result - the latest minigame result
     */
    public void showResult(final int result) {
        mgResultLabel.setVisible(true);
        gameState.setText(String.valueOf(result));
    }

    /*
     * @param Color - color passed that represents the player
     * 
     * @return Circle - node
     */
    private Circle createCircle(final Color c) {
        final Circle circle = new Circle();
        circle.setFill(c);
        circle.setRadius(RADIUS_CIRCLE);
        return circle;
    }
}
