package application.minigame.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToe extends Application {

    //variabili per la grandezza della schermata
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;

    //creo un istanza del controller
    ControllerTicTacToe controller = new ControllerTicTacToe();


    //avvio della finestra del programma
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();


        /* Stage configuration */
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }




}
