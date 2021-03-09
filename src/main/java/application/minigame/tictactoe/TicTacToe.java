package application.minigame.tictactoe;

import application.minigame.tictactoe.MVC.TTTView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TicTacToe extends Application {

    //variabili per la grandezza della schermata
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 500;


    //creo un istanza del controller
    public static final TTTView controller = new TTTView();


    //avvio della finestra del programma
    @Override
    public void start(final Stage primaryStage) {

        /**
         * Setto lo stage principale
         */
        controller.setStage(primaryStage);

        primaryStage.setTitle("TicTacToe");

        /**
         * Il controllore mi ritorna La griglia coi bottoni
         */
        GridPane root = controller.createButton();
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(final String[] args) {
        launch(args);
    }


}
