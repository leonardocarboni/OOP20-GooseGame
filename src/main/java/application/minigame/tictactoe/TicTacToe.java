package application.minigame.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    //variabili per la grandezza della schermata
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;


    //creo un istanza del controller
    public static final ControllerTicTacToe controller = new ControllerTicTacToe();


    //avvio della finestra del programma
    @Override
    public void start(final Stage primaryStage) {

        controller.setStage(primaryStage);

        primaryStage.setTitle("TicTacToe");

        //uso un contoller per creare la griglia
        //grid pane
        GridPane root = controller.createButton();
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(final String[] args) {
        launch(args);
    }


}
