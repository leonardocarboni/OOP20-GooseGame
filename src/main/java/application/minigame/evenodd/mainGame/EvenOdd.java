package application.minigame.evenodd.mainGame;

import application.minigame.evenodd.mvc.EOView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Inizializzazione del gioco.
 * Viene creato lo stage, la scene e la view del gioco.
 *
 */

public class EvenOdd extends Application {

    /**
     * Questa applicazione fa utilizzo dello stackPane.
     */
    public static StackPane pane = null;

    /**
     * Creo la view del gioco per costruire lo stackPane.
     */
    public static final EOView view = new EOView();

    @Override
    public void start(final Stage primaryStage) {

        /**
         * Tramite il setter presente nella view, creo lo stage principale.
         */
        view.setStage(primaryStage);

        primaryStage.setTitle("Even or Odd");

        /**
         * Assegno un valore allo stackPane precedentemente creato.
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
