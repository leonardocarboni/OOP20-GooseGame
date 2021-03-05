package application.minigame.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.util.List;

public class TicTacToe extends Application {

    //variabili per la grandezza della schermata
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;


    //creo un istanza del controller
    public static ControllerTicTacToe controller = new ControllerTicTacToe();


    //avvio della finestra del programma
    @Override
    public void start(Stage primaryStage) throws Exception {

        /* Stage configuration */
        primaryStage.setTitle("TicTacToe");
        //uso un contoller per creare la griglia
        primaryStage.setScene(new Scene(controller.createButton(), SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
