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

/**
 * Controller del gioco, esso si occupa della creazione di bottoni, di disegnare la "O" e vedere chi vince
 */
public class TTTView {

    /**
     * Numero di bottoni nella griglia
     */

    private static int GRID_DIM;;

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

    /**
     * Lista dei bottoni presenti nella griglia principale 3x3
     */
    private static final List<Button> listButtonGrid = new ArrayList<>();

    /**
     * Lista dei bottono sotto la griglia 3x3
     */
    private final List<Button> listBottomButton = new ArrayList<>();



    /**
     * Costruttore della classe controller. Crea la lista dei bottoni nel gioco
     */
    public TTTView(int gridDim) {
    }




    /**
     * Inserisco i bottoni creati nel costruttore nel pannello
     * @return Griglia coi bottni
     */
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


    /**
     * In caso sia selezionata la darkMode devo mettere uno specifico colore
     * @param event
     */
    public void releaseButton(Event event){

    }





    public void setStage(final Stage stage){
        this.stage = stage;
    }

    public static List<Button> getListButton(){ return listButtonGrid; }

}
