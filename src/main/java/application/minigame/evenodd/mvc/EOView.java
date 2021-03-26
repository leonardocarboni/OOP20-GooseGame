package application.minigame.evenodd.mvc;


import application.minigame.evenodd.fxItem.BackgroundLoader;
import application.minigame.evenodd.fxItem.ItemDropper;
import application.minigame.evenodd.mainGame.EvenOdd;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class EOView {

    /**
     * Creo un'istanza del controller.
     */
    public static final EOController handler = new EOController();

    /**
     * Creo un istanza model.
     */
    public static final EOModel model = new EOModel();

    /**
     * Creo lo stage.
     * Questo valore verrà assegnato dalla classe EvenOdd al lancio dell'applicazione.
     */
    public Stage stage = new Stage();

    /**
     * Lista dei bottoni presenti nel gioco, Pari o Dispari.
     */
    public List<Button> listButton = new ArrayList<>();

    /**
     * Questa imageView verrà assegnata qualora la model deciderà chi ha vinto
     */
    private ImageView imgView = null;

    /**
     * Esito finale.
     * True se ha vinto il player.
     * False se ha perso.
     */
    public boolean result;

    /**
     * Valore uscito casualmente dalla model.
     */
    public int resultValue;

    /**
     * Definizione della task usata per implementare un delay nella GUI
     * Esso setta l'immagine a NULL della imageView, poichè ci sarà l'animazione del dado.
     * Dopodichè chiama un metodo per restituire l'imageView corretta.
     */
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

    /**
     * Esso crea lo stackPane con i bottoni opportunamente posizionati e riempie la lista di bottoni.
     * Metodo chiamato dalla classe EvenOdd.
     *
     * @return Il pannello di gioco
     */
    public StackPane createPane() {
        StackPane pane = new StackPane();
        ItemDropper dropper = new ItemDropper();
        Button btn1 = dropper.evenButton(handler);
        Button btn2 = dropper.oddButton(handler);

        pane.getChildren().add(btn1);
        pane.getChildren().add(btn2);

        pane.setBackground(new Background(BackgroundLoader.background));

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

    /**
     * In base al risultato (dato dal model) setto l'immagine winner o loser
     */
    private void startWinAnimation(){
        createText();
       if(result){
           task1.setOnSucceeded(event -> winImage());
       } else{
           task1.setOnSucceeded(event -> loseImage());
       }
        new Thread(task1).start();
    }

    /**
     * Chiamo la changeIcon con la scritta winner
     */
    private void winImage() {
        changeIcon(BackgroundLoader.winner);
    }

    /**
     * Chiamo la changeIcon con la scritta loser
     */
    private void loseImage() {
        changeIcon(BackgroundLoader.loser);
    }

    /**
     * Il metodo verrà chiamato una volta noto il vincitore.
     * @param bkg Essa è l'immagine da mostrare in caso di vittoria o di sconfitta
     */
    private void changeIcon(BackgroundImage bkg){
        Image imgIcon = new Image(bkg.getImage().getUrl());
        ImageView viewImage = new ImageView(imgIcon);
        viewImage.setFitHeight(200); //no magic number
        viewImage.setFitWidth(400);
        this.imgView = viewImage;
        viewImage.setTranslateY(-100);
        EvenOdd.pane.getChildren().add(viewImage);
    }

    /**
     * Crea il testo che mi dice il valore generato dalla model.
     */
    private void createText(){
        ItemDropper item = new ItemDropper();
        Text text = item.createText(this.resultValue);
        EvenOdd.pane.getChildren().add(text);
    }


    public void setStage(final Stage stage){
        this.stage = stage;
    }

}