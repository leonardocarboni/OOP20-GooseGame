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

    @FXML
    private Button rock, paper, scissors;

    @FXML
    private Label playerScore, computerScore, result;

    @FXML
    private ImageView player, computer;

    private static final String LAYOUT_LOCATION = "layouts/rps.fxml";
    private static final String LOGO_LOCATION = "logo.png";
    private static final String ROCK = "r";
    private static final String PAPER = "p";
    private static final String SCISSORS = "s";
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

    @FXML
    private void playerTurn(ActionEvent event) {
        String playerChoice = null;
        switch (((Button)event.getSource()).getId()) {
            case "rock":
                image = new Image("src/main/resources/rockPaperScissors/rock.png");
                playerChoice = ROCK;
                break;
            case "paper":
                image = new Image("src/main/resources/rockPaperScissors/paper.png");
                playerChoice = PAPER;
                break;
            case "scissors":
                image = new Image("src/main/resources/rockPaperScissors/scissors.png");
                playerChoice = SCISSORS;
                break;
        }
        player.setImage(image);

        winner(playerChoice, computerTurn());
    }

    @FXML
    private String computerTurn() {
        String computerChoice = null;
        int index = (int) (Math.random() * 3);
        switch (index) {
            case 0:
                image = new Image("src/main/resources/rockPaperScissors/rock.png");
                computerChoice = ROCK;
                break;
            case 1:
                image = new Image("src/main/resources/rockPaperScissors/paper.png");
                computerChoice = PAPER;
                break;
            case 2:
                image = new Image("src/main/resources/rockPaperScissors/scissors.png");
                computerChoice = SCISSORS;
                break;
        }
        computer.setImage(image);
        return computerChoice;
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

    public void winner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            draw();
            return;
        }
        if (playerChoice.equals(ROCK)) {
            if (computerChoice.equals(PAPER)) {
                computerWin();
            } else if (computerChoice.equals(SCISSORS)) {
                playerWin();
            }
        } else if (playerChoice.equals(PAPER)) {
            if (computerChoice.equals(ROCK)) {
                playerWin();
            } else if (computerChoice.equals(SCISSORS)) {
                computerWin();
            }
        } else {
            if (computerChoice.equals(ROCK)) {
                computerWin();
            } else if (computerChoice.equals(PAPER)) {
                playerWin();
            }
        }
    }

    public void show() {
        primaryStage.showAndWait();
    }


}
