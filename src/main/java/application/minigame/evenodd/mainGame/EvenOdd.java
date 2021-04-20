package application.minigame.evenodd.mainGame;

import application.minigame.evenodd.mvc.EOViewImpl;
import controller.minigame.MinigameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Inizializzazione del gioco. Viene creato lo stage, la scene e la view del
 * gioco.
 *
 */

public class EvenOdd extends Application implements MinigameController {
    /**
     * Main stage of the game.
     */
    public static final Stage PRIMARY_STAGE = new Stage();

    public EvenOdd() {
        start(PRIMARY_STAGE);
    }

    /**
     * Creo la view del gioco per costruire lo stackPane.
     */
    public static final EOViewImpl EO_VIEW = new EOViewImpl();

    @Override
    public void start(final Stage primaryStage) {

        /**
         * Tramite il setter presente nella view, creo lo stage principale.
         */

        /**
         * Questa applicazione fa utilizzo dello stackPane.
         */
        final StackPane pane = EO_VIEW.createPane();

        EvenOdd.PRIMARY_STAGE.setTitle("Even or Odd");

        EvenOdd.PRIMARY_STAGE.setScene(new Scene(pane, 600, 480));
        EvenOdd.PRIMARY_STAGE.setResizable(false);
        EvenOdd.PRIMARY_STAGE.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public int getResult() {
        if (new GettersMVC().getView().isResult()) {
            return 1;
        } else {
            return 2;
        }
    }

    public void close() {
        EvenOdd.PRIMARY_STAGE.close();
    }
}