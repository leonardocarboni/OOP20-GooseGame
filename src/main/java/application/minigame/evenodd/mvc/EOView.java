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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


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

    public List<Button> listButton = new ArrayList<>();

    ImageView imgView = null;
    public boolean result;


    Task task1 = new Task<Void>() {
        @Override
        public Void call() {
            try {
                Thread.sleep(1000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        imgView.setImage(null);
                        startWinAnimation();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

        listButton.addAll(List.of(btn1,btn2));
        return pane;
    }

    public void startAnimation() {
        startGifAnimation();
        new Thread(task1).start();
    }

    private void startGifAnimation() {
        changeIcon(BackgroundLoader.animationGif);
    }

    private void startWinAnimation(){
       if(result){
           task1.setOnSucceeded(event -> winImage());
       } else{
           task1.setOnSucceeded(event -> loseImage());
       }
        new Thread(task1).start();
    }

    private void winImage() {
        changeIcon(BackgroundLoader.winner);
    }
    private void loseImage() {
        changeIcon(BackgroundLoader.loser);
    }

    private void changeIcon(BackgroundImage bkg){
        Image imgIcon = new Image(bkg.getImage().getUrl());
        ImageView viewImage = new ImageView(imgIcon);
        this.imgView = viewImage;
        viewImage.setTranslateY(-100);
        EvenOdd.pane.getChildren().add(viewImage);
    }


    public void setStage(final Stage stage){
        this.stage = stage;
    }

}
