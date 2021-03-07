package application.minigame.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class TicTacToe extends Application {

    //variabili per la grandezza della schermata
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 500;


    //creo un istanza del controller
    public static final TTTControllerImpl controller = new TTTControllerImpl();


    //avvio della finestra del programma
    @Override
    public void start(final Stage primaryStage) {


        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("src/main/resources/TicTacToe/SoundOfficial.wav")));

            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-25);
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }

        controller.setStage(primaryStage);

        primaryStage.setTitle("TicTacToe");

        //uso un contoller per creare la griglia
        //grid pane
        GridPane root = controller.createButton();
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(final String[] args) {
        launch(args);
    }


}
