package application.minigame.tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.sound.sampled.*;
import java.io.IOException;


public class TicTacToe extends Application {

    //variabili per la grandezza della schermata
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 500;
    private static Music clip;


    {
        try {
            clip = new Music();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //creo un istanza del controller
    public static final TTTControllerImpl controller = new TTTControllerImpl();


    //avvio della finestra del programma
    @Override
    public void start(final Stage primaryStage) {



        clip.startMusic();
        controller.setStage(primaryStage);

        primaryStage.setTitle("TicTacToe");

        //uso un contoller per creare la griglia
        //grid pane
        GridPane root = controller.createButton();
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static Music getMusic(){
        return clip;
    }

    public static void main(final String[] args) {
        launch(args);
    }


}
