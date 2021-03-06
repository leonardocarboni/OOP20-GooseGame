package application.minigame.tictactoe;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.Optional;

public class MyThread extends Thread{

    private final String winner;

    public MyThread(String winner){
        this.winner = winner;
    }

    public void run(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                final StackPane pane = new StackPane();
                final ButtonDropper button = new ButtonDropper();

                pane.getChildren().add(button.endGameButton(Optional.empty(), winner));
                pane.setBackground(new Background(BackgroundLoader.endGameButtonBackground));
                FadeTransition ft = new FadeTransition(Duration.millis(3000), pane);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.play();

                TicTacToe.controller.stage.setScene(new Scene(pane,600,480));
            }
        });


    }

}
