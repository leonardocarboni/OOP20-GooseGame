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


    public static final Stage primaryStage = new Stage();

    public EvenOdd() {
        start(primaryStage);
    }

    /**
     * Creo la view del gioco per costruire lo stackPane.
     */
    public static final EOViewImpl view = new EOViewImpl();




    @Override
    public void start(final Stage primaryStage) {

        /**
         * Tramite il setter presente nella view, creo lo stage principale.
         */

        /**
         * Questa applicazione fa utilizzo dello stackPane.
         */
        final StackPane pane = view.createPane();

        this.primaryStage.setTitle("Even or Odd");

        this.primaryStage.setScene(new Scene(pane, 600, 480));
        this.primaryStage.setResizable(false);
        this.primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public int getResult() {
        if (new GettersMVC().getView().result) {
            return 1;
        } else {
            return 2;
        }
    }

    public void close(){
        this.primaryStage.close();
    }
}