package application.minigame.evenodd.mvc;

import application.minigame.evenodd.fxItem.BackgroundLoader;
import application.minigame.evenodd.fxItem.Choice;
import application.minigame.evenodd.fxItem.ItemFactoryImpl;
import application.minigame.evenodd.interfaces.EOView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class EOViewImpl implements EOView {

    /**
     * Creo un'istanza del controller.
     */
    public static final EOControllerImpl handler = new EOControllerImpl();

    /**
     * Creo un istanza model.
     */
    public static final EOModelImpl model = new EOModelImpl();

    /**
     * Lista dei bottoni presenti nel gioco, Pari o Dispari.
     */
    public List<Button> listButton = new ArrayList<>();

    /**
     * Questa imageView verrà assegnata qualora la model deciderà chi ha vinto
     */
    private ImageView imgView = null;

    /**
     * Esito finale. True se ha vinto il player. False se ha perso.
     */
    public boolean result;

    /**
     * Valore uscito casualmente dalla model.
     */
    public int resultValue;

    /**
     * Scelta del player, pari o dispari.
     */
    public Choice playerChoice;

    public StackPane pane = null;



    /**
     * Esso crea lo stackPane con i bottoni opportunamente posizionati e riempie la
     * lista di bottoni. Metodo chiamato dalla classe EvenOdd.
     *
     * @return Il pannello di gioco
     */
    public StackPane createPane() {
        ItemFactoryImpl item = new ItemFactoryImpl();
        StackPane pane = new StackPane();
        Button evenButton = item.evenButton(handler);
        Button oddButton = item.oddButton(handler);
        Button exitButton = item.exitButton(handler);

        pane.getChildren().add(evenButton);
        pane.getChildren().add(oddButton);
        pane.getChildren().add(exitButton);

        pane.setBackground(new Background(BackgroundLoader.background));


        listButton.add(0, evenButton);
        listButton.add(1, oddButton);
        listButton.add(2, exitButton);

        this.pane  = pane;
        return pane;
    }

    public void resultPlayer(){
        if(result){
            winImage();
        } else{
            loseImage();
        }
        createText();
        createTextChoice();
        result = false;
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
     *
     * @param bkg Essa è l'immagine da mostrare in caso di vittoria o di sconfitta
     */
    private void changeIcon(BackgroundImage bkg) {
        Image imgIcon = new Image(bkg.getImage().getUrl());
        ImageView viewImage = new ImageView(imgIcon);
        viewImage.setFitHeight(200);
        viewImage.setFitWidth(400);
        this.imgView = viewImage;
        viewImage.setTranslateY(-100);
        addElementToStackPane(viewImage);
    }

    /**
     * Crea il testo che mi dice il valore generato dalla model.
     */
    private void createText() {
        ItemFactoryImpl item = new ItemFactoryImpl();
        Text text = item.createText("The value generated is: ", Integer.toString(this.resultValue), 50);
        addElementToStackPane(text);
    }

    private void createTextChoice() {
        Text text = new ItemFactoryImpl().createText("Your choice is ", this.playerChoice.toString(), 74);
        addElementToStackPane(text);
    }

    private void addElementToStackPane(Node obj) {
        this.pane.getChildren().add(obj);
    }

}