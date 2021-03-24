package application.minigame.evenodd.mvc;


import application.minigame.evenodd.fxItem.BackgroundLoader;
import application.minigame.evenodd.fxItem.ButtonDropper;
import application.minigame.evenodd.mainGame.EvenOdd;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    Task task1 = new Task<Void>() {
        @Override
        public Void call() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            });
            return null;
        }
    };






    public EOView() {
    }



    public StackPane createPane() {
        StackPane pane = new StackPane();
        ButtonDropper dropper = new ButtonDropper();
        Button btn1 = dropper.evenButton(handler);
        Button btn2 = dropper.oddButton(handler);

        pane.getChildren().add(btn1);
        pane.getChildren().add(btn2);

        pane.setBackground(new Background(BackgroundLoader.button));


        return pane;
    }

    void startAnimation() {
       // EndgameThread animation = new EndgameThread();
        //animation.start();
        task1.setOnSucceeded(event -> finishedSleeping());
        new Thread(task1).start();

    }

    private void finishedSleeping() {
        Image imgIcon = new Image("evenodd/tenor.gif");
        ImageView viewImage = new ImageView(imgIcon);
        viewImage.setTranslateY(-100);
        EvenOdd.pane.getChildren().add(viewImage);
    }


    public void setStage(final Stage stage){
        this.stage = stage;
    }

}
