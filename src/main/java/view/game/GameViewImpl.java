package view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.View;
import view.ViewType;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

public class GameViewImpl extends View implements Initializable, GameView {

    @FXML
    private Button diceButton;
    @FXML
    private Label currentPlayerLabel;
    @FXML
    private ImageView diceImage;
    @FXML
    private List<Label> scoreBoard;
    @FXML
    private List<HBox> gameboard;
    @FXML
    private Label gameState;

    private static final float RADIUS_CIRCLE = 5.0f;
    public GameViewImpl() {
        super.createStage(ViewType.GAME);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

    @Override
    public void changeImageDice(final int value) {
        String nameDiceImage = "";
        switch (value) {
        case 1:
            nameDiceImage = "diceOne.png";
            break;
        case 2:
            nameDiceImage = "diceTwo.png";
            break;
        case 3:
            nameDiceImage = "diceThree.png";
            break;
        case 4:
            nameDiceImage = "diceFour.png";
            break;
        case 5:
            nameDiceImage = "diceFive.png";
            break;
        case 6:
            nameDiceImage = "diceSix.png";
            break;
        default:
            break;
        }
        diceImage.setImage(new Image(ClassLoader.getSystemResource("dice/" + nameDiceImage).toString()));
    }

    @Override
    public void changeScoreboard(final List<String> list) {
        int i = 0;
        for (final String p : list) {
            scoreBoard.get(i).setText(p);
            i++;
        }
    }

    @Override
    public void changeGameStateLabel(final String s) {
        gameState.setText(s);
    }

    @Override
    public void changePlayerLabel(final String s) {
        currentPlayerLabel.setText(s);
    }

    @Override
    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        diceButton.setOnAction(eventHandler);
    }

    @Override
    public void resetAllBoxes() {
        for (final HBox hb : gameboard) {
            hb.getChildren().clear();
        }
    }

    @Override
    public void changeAllBoxes(final Map<Color, Integer> position) {
        resetAllBoxes();
        for (final Entry<Color, Integer> p : position.entrySet()) {
            System.out.println(p.getValue());
            gameboard.get(p.getValue()).getChildren().add(createCircle(p.getKey()));
        }
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
