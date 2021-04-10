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
    private ProgressBar timeBar;
    @FXML
    private ImageView result;
   @FXML
    private Button rock, paper, scissors;
   @FXML
   private Label numWin, round;

    private final Stage primaryStage = new Stage();
    private static final String LAYOUT_LOCATION = "layouts/rockpaperscissors.fxml";
    private static final String LOGO_LOCATION = "logo.png";

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

    public void rockListener(final EventHandler<ActionEvent> eventHandler) {
        rock.setOnAction(eventHandler);
    }

    public void paperListener(final EventHandler<ActionEvent> eventHandler) {
        paper.setOnAction(eventHandler);
    }

    public void scissorsListener(final EventHandler<ActionEvent> eventHandler) {
        scissors.setOnAction(eventHandler);
    }

    public ImageView getResult() {
        return null;
    }
    

    public Label getNumWin() {
        return numWin;
    }

    public Label getRound() {
        return round;
    }

    public void show() {
        primaryStage.showAndWait();
    }


}
