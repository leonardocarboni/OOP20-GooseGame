package application.minigame.tictactoe.mainGame;

import application.minigame.tictactoe.mvc.GettersMVC;
import application.minigame.tictactoe.mvc.TTTView;
import controller.minigame.MinigameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Timestamp;


public class TicTacToe extends Application implements MinigameController {

    //variabili per la grandezza della schermata
    public final static int GRID_DIM = 3;
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;
    public static boolean isWin = false;

    //creo un istanza del controller
    public static final TTTView view = new TTTView(GRID_DIM);

    public TicTacToe(){
        start(new Stage());
    }

    //avvio della finestra del programma
    @Override
    public void start(final Stage primaryStage) {

        /**
         * Setto lo stage principale
         */

        view.setStage(primaryStage);

        primaryStage.setTitle("TicTacToe");

        /**
         * Il controllore mi ritorna La griglia coi bottoni
         */
        GridPane root = view.createButton();

        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
       primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(final String[] args) {
        launch(args);
    }


    @Override
    public int getResult() {
        if(isWin){
            return 1;
        }
        else{
            return 0;
        }
    }
}
