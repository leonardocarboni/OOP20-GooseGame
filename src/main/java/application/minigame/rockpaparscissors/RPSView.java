package application.minigame.rockpaparscissors;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.MinigameView;
import view.ViewType;

import java.io.IOException;

public class RPSView extends MinigameView {
    //estendere view su develop
    @FXML
    private Button rockButton, paperButton, scissorsButton;

    @FXML
    private Label playerScoreLabel, computerScoreLabel, resultLabel;

    @FXML
    private ImageView playerImage, computerImage;

    public RPSView() {
        super(ViewType.ROCK_PAPER_SCISSORS);
    }

    public void playerWin() {
        resultLabel.setText("You Win");
        playerScoreLabel.setText(String.valueOf(Integer.parseInt(playerScoreLabel.getText()) + 1));
    }

    public void computerWin() {
        resultLabel.setText("You Lose");
        playerScoreLabel.setText(String.valueOf(Integer.parseInt(computerScoreLabel.getText()) + 1));
    }

    public void draw() {
        resultLabel.setText("Draw");
    }

    public void setRockButtonHandler(EventHandler<ActionEvent> e) {
        rockButton.setOnAction(e);
    }

    public void setPaperButtonHandler(EventHandler<ActionEvent> e) {
        paperButton.setOnAction(e);
    }

    public void setScissorsButtonHandler(EventHandler<ActionEvent> e) {
        scissorsButton.setOnAction(e);
    }

    public void setPlayerScoreLabel(int score) {
        playerScoreLabel.setText("" + score);
    }

    public void setComputerScoreLabel(int score) {
        computerScoreLabel.setText("" + score);
    }

    public void setPlayerChoiceImage(Choice choice) {
        playerImage.setImage(new Image(parseChoiceImagePath(choice)));
    }

    public void setComputerChoiceImage(Choice choice) {
        computerImage.setImage(new Image(parseChoiceImagePath(choice)));
    }

    private String parseChoiceImagePath(Choice choice) {
        String imagePath;
        if (choice == Choice.ROCK) {
            imagePath = "rockpaperscissors/rock.png";
        } else if (choice == Choice.PAPER) {
            imagePath = "rockpaperscissors/paper.png";
        } else {
            imagePath = "rockpaperscissors/scissors.png";
        }
        return imagePath;
    }

}
