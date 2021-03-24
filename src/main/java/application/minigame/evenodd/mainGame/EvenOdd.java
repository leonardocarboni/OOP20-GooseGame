package application.minigame.evenodd.mainGame;

import application.minigame.evenodd.mvc.EOView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class EvenOdd extends Application {

    public static StackPane pane = null;

    //creo un istanza del controller
    public static final EOView view = new EOView();

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
        pane = view.createPane();
        primaryStage.setScene(new Scene(pane,600,480));
       primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(final String[] args) {
        launch(args);
    }


}
