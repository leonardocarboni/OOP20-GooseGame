package application.minigame.tictactoe;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyThread extends Thread{
    public void run(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                BackgroundSize bs = new BackgroundSize(200,500,true,true,true,false);
               BackgroundImage bi = new BackgroundImage(new Image("TicTacToe/green_button01.png"),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);

                BackgroundSize bsStack = new BackgroundSize(600,480,false,false,false,false);
                BackgroundImage biStack = new BackgroundImage(new Image("TicTacToe/Sfondo.png",200,170,false,false),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bsStack);

                StackPane pane = new StackPane();
                Button btn = new Button();
                btn.setBackground(new Background(bi));
                btn.setText("Player Won");
                btn.setTranslateY(-130);


                btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,40));
                pane.getChildren().add(btn);
                pane.setBackground(new Background(biStack));
                FadeTransition ft = new FadeTransition(Duration.millis(3000), btn);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.play();
                TicTacToe.controller.stage.setScene(new Scene(pane,600,480));
            }
        });


    }

}
