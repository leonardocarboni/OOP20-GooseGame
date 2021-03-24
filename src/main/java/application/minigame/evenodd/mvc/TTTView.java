package application.minigame.evenodd.mvc;


import application.minigame.evenodd.fxItem.BackgroundLoader;
import application.minigame.evenodd.fxItem.ButtonDropper;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;


public class TTTView {


    /**
     * Creo un'istanza del controller
     */
    public static final TTTController handler = new TTTController();

    /**
     * Creo un istanza model per vedere chi ha vinto
     */
    public static final TTTModel model = new TTTModel();

    /**
     * Creo lo stage
     */
    public Stage stage = new Stage();




    public TTTView(int gridDim) {
    }



    public StackPane createPane(){
        StackPane pane = new StackPane();
        ButtonDropper dropper = new ButtonDropper();
        Button btn1 = dropper.evenButton(null);
        Button btn2 = dropper.oddButton(null);

        pane.getChildren().add(btn1);
        pane.getChildren().add(btn2);
        pane.setBackground(new Background(BackgroundLoader.button));
        return pane;
    }




    public void setStage(final Stage stage){
        this.stage = stage;
    }

}
