package application.minigame.evenodd.mainGame;

import application.minigame.evenodd.mvc.EOView;
import controller.minigame.MinigameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Inizializzazione del gioco.
 * Viene creato lo stage, la scene e la view del gioco.
 *
 */

public class EvenOdd extends Application implements MinigameController {


    public EvenOdd(){
        start(new Stage());
    }




    /**
     * Creo la view del gioco per costruire lo stackPane.
     */
    public static final EOView view = new EOView();

    /**
     * Questa applicazione fa utilizzo dello stackPane.
     */
    public static final StackPane pane = view.createPane();

    @Override
    public void start(final Stage primaryStage) {

        /**
         * Tramite il setter presente nella view, creo lo stage principale.
         */


        primaryStage.setTitle("Even or Odd");


        primaryStage.setScene(new Scene(pane,600,480));
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(final String[] args) {
        launch(args);
    }


    @Override
    public int getResult() {
        if(new GettersMVC().getView().result){
            return 1;
        } else{
            return 2;
        }
    }
}
