package application.minigame.rockpaparscissors;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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

public class RPSView {
    //estendere view su develop
    @FXML
    private Button rock, paper, scissors;

    @FXML
    private Label playerScore, computerScore, result;

    @FXML
    private ImageView player, computer;

    private static final String LAYOUT_LOCATION = "layouts/rps.fxml";
    private static final String LOGO_LOCATION = "logo.png";

    private final Stage primaryStage = new Stage();
    private Image image;

    public RPSView() {
        try {
            System.out.println(ClassLoader.getSystemResource(LAYOUT_LOCATION));

            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("[GooseGame] Rock Paper Scissors");
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> primaryStage.setIconified(true));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);


        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void playerWin() {
        result.setText("You Win");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void computerWin() {
        result.setText("You Lose");
        playerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText()) + 1));
    }

    public void draw() {
        result.setText("Draw");
    }

    public void setRockButtonHandler(EventHandler<ActionEvent> e) {
        rock.setOnAction(e);
    }

    public void setPaperButtonHandler(EventHandler<ActionEvent> e) {
        paper.setOnAction(e);
    }

    public void setScissorsButtonHandler(EventHandler<ActionEvent> e) {
        scissors.setOnAction(e);
    }

    public void setPlayerScore(int score) {
        playerScore.setText("" + score);
    }

    public void setComputerScore(int score) {
        computerScore.setText("" + score);
    }

    public void setPlayerChoiceImage(Choice choice) {
        player.setImage(new Image(parseChoiceImagePath(choice)));
    }

    public void setComputerChoiceImage(Choice choice) {
        computer.setImage(new Image(parseChoiceImagePath(choice)));
    }

    private String parseChoiceImagePath(Choice choice) {
        String imagePath = null;
        if (choice == Choice.ROCK) {
            imagePath = "rock.png";
        } else if (choice == Choice.PAPER) {
            imagePath = "paper.png";
        } else {
            imagePath = "scissors.png";
        }
        return imagePath;
    }

    public void show() {
        primaryStage.showAndWait();
    }


}
