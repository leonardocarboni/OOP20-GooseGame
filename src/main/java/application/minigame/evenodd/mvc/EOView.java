package application.minigame.evenodd.mvc;


import application.minigame.evenodd.fxItem.BackgroundLoader;
import application.minigame.evenodd.fxItem.ButtonDropper;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class EOView {


    /**
     * Creo un'istanza del controller
     */
    public static final EOController handler = new EOController();

    /**
     * Creo un istanza model per vedere chi ha vinto
     */
    public static final EOModel model = new EOModel();

    /**
     * Creo lo stage
     */
    public Stage stage = new Stage();




    public EOView(int gridDim) {
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
