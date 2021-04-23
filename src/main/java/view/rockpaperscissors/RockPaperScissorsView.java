package view.rockpaperscissors;

import model.choice.RockPaperScissorsChoice;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.MinigameView;
import view.ViewType;


public class RockPaperScissorsView extends MinigameView {

    @FXML
    private Button rockButton, paperButton, scissorsButton;

    @FXML
    private Label playerScoreLabel, computerScoreLabel, resultLabel;

    @FXML
    private ImageView playerImage, computerImage;

    private static final Image ROCK_IMAGE = new Image("rockPaperScissors/rock.png");
    private static final Image PAPER_IMAGE = new Image("rockPaperScissors/paper.png");
    private static final Image SCISSORS_IMAGE = new Image("rockPaperScissors/scissors.png");

    public RockPaperScissorsView() {
        super(ViewType.ROCK_PAPER_SCISSORS);
    }

    public void playerWin() {
        resultLabel.setText("You Win");
    }

    public void computerWin() {
        resultLabel.setText("You Lose");
    }

    public void draw() {
        resultLabel.setText("Draw");
    }

    public void setRockButtonHandler(final EventHandler<ActionEvent> e) {
        rockButton.setOnAction(e);
    }

    public void setPaperButtonHandler(final EventHandler<ActionEvent> e) {
        paperButton.setOnAction(e);
    }

    public void setScissorsButtonHandler(final EventHandler<ActionEvent> e) {
        scissorsButton.setOnAction(e);
    }

    public void setPlayerScoreLabel(final int score) {
        playerScoreLabel.setText(" " + score);
    }

    public void setComputerScoreLabel(final int score) {
        computerScoreLabel.setText(" " + score);
    }

    public void setPlayerChoiceImage(final RockPaperScissorsChoice choice) {
        playerImage.setImage(parseChoiceImagePath(choice));
    }

    public void setComputerChoiceImage(final RockPaperScissorsChoice choice) {
        computerImage.setImage(parseChoiceImagePath(choice));
    }

    private Image parseChoiceImagePath(final RockPaperScissorsChoice choice) {
        if (choice == RockPaperScissorsChoice.ROCK) {
            return ROCK_IMAGE;
        } else if (choice == RockPaperScissorsChoice.PAPER) {
            return PAPER_IMAGE;
        } else {
            return SCISSORS_IMAGE;
        }
    }

}
