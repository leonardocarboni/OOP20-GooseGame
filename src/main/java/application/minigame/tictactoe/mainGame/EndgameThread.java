package application.minigame.tictactoe.mainGame;

import application.minigame.tictactoe.fxItem.BackgroundLoader;
import application.minigame.tictactoe.fxItem.ButtonDropper;
import application.minigame.tictactoe.mvc.GettersMVC;
import application.minigame.tictactoe.mvc.TTTController;
import application.minigame.tictactoe.mvc.TTTView;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.Optional;

public class EndgameThread extends Thread{

    private final String winner;

    public EndgameThread(String winner){
        this.winner = winner;
    }

    /* thread che viene creato dopo che la partita a tris finisce */
    public void run(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                final StackPane pane = new StackPane();
                final ButtonDropper button = new ButtonDropper();
                final TTTController handler = new TTTController();
                final GettersMVC getters = new GettersMVC();

                pane.getChildren().add(button.endGameButton(Optional.empty(), winner));
                pane.getChildren().add(button.exitButton(Optional.of(handler), "Exit"));
                if(!getters.getView().isDark){
                    pane.setBackground(new Background(BackgroundLoader.endGameButtonBackground));
                } else{
                    pane.setBackground(new Background(BackgroundLoader.endGameButtonBackgroundBlack));
                }

                FadeTransition ft = new FadeTransition(Duration.millis(2000), pane);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.play();

                getters.getView().stage.setScene(new Scene(pane,600,480));
            }
        });


    }

}
