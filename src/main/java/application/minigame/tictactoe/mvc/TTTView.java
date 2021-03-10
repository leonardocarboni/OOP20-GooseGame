package application.minigame.tictactoe.mvc;


import application.minigame.tictactoe.fxItem.BackgroundLoader;
import application.minigame.tictactoe.fxItem.ButtonDropper;
import application.minigame.tictactoe.mainGame.TicTacToe;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
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
    private final static int NUMBER_OF_BUTTON = 9;

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

    private final List<Integer> number = List.of(0,0,0,1,1,1,2,2,2);
    private final List<Integer> number2 = List.of(0,0,1,1,2,2);
    private final List<String> sign = List.of("X", "O");

    /**
     * Lista dei bottoni presenti nella griglia principale 3x3
     */
    private static final List<Button> listButtonGrid = new ArrayList<>();

    /**
     * Lista dei bottono sotto la griglia 3x3
     */
    private final List<Button> listBottomButton = new ArrayList<>();

    /**
     * Serve per vedere se la dark mode è selezionata
     */
    public boolean isDark = false;


    /**
     * Costruttore della classe controller. Crea la lista dei bottoni nel gioco
     */
    public TTTView(){
        final ButtonDropper btn = new ButtonDropper();
        for(int i = 0; i < NUMBER_OF_BUTTON; i++){
            listButtonGrid.add(btn.gridButton(handler));
        }

        listBottomButton.add(0,btn.gameDarkModeIcon(Optional.of(handler),""));
        listBottomButton.add(1,btn.gameDarkModeIconText(Optional.empty(),""));
        listBottomButton.add(2,btn.pauseButtonIcon(Optional.of(handler),""));
        listBottomButton.add(3,btn.pauseButtonIconText(Optional.empty(),""));

        handler.setListButton(listButtonGrid);
        handler.setListButtonBottom(listBottomButton);
    }


    /**
     * Il computer vede dove puo disegnare un "O" in maniera casuale
     */
    public void drawO(){
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            final Random rnd = new Random();
            final int numCase = rnd.nextInt(9);
            if (listButtonGrid.get(numCase).getText().equals("")) {
                listButtonGrid.get(numCase).setText("O");
                model.winCondition.accept(model.checkWin());
                return;
            }
        }
    }

    /**
     * Disegna una X, creando un numero casuale e controllando quell'indice nella lista dei bottoni, se quel valore è ""
     * allora disegna una X, altrimenti rifà il procedimento
     * @param evt , per prendere il bottone cliccato
     * @param winCondition , controllo se ho vinto
     */
    public void drawX(Event evt, Consumer<String> winCondition){
        for(int i = 0; i < NUMBER_OF_BUTTON ; i++){
            if(evt.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")){
                listButtonGrid.get(i).setText("X");
                winCondition.accept(model.checkWin());
                drawO();
            }
        }
    }

    /**
     * Inserisco i bottoni creati nel costruttore nel pannello
     * @return Griglia coi bottni
     */
    public GridPane createButton(){
        final GridPane root = new GridPane();
        listButtonGrid.stream()
                .forEach(i -> root.add(i, listButtonGrid.indexOf(i) % 3, number.get(listButtonGrid.indexOf(i)), 1 , 1));
        listBottomButton.stream()
                .forEach(i -> root.add(i, number2.get(listBottomButton.indexOf(i)), 3, 1 , 1));
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        return  root;
    }


    /**
     * In caso sia selezionata la darkMode devo mettere uno specifico colore
     * @param event
     */
    public void releaseButton(Event event){
        for(int i = 0; i < NUMBER_OF_BUTTON ; i++){
            if(event.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")){
                if(!isDark){
                } else{
                    listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
                }
            }
        }
    }

    /**
     * Se seleziono la darkMode cambio il colore di tutti i bottoni
     */
    public void changeColor(){
        if(!isDark) {
            isDark = true;
            changeAllDark();
            listBottomButton.get(0).setBackground(new Background(BackgroundLoader.darkButtonIconDark));
        }
        else if(isDark) {
            isDark = false;
            changeAllWhite();
            listBottomButton.get(0).setBackground(new Background(BackgroundLoader.darkButtonIcon));
        }
    }

    /**
     * Funzione a supporto del cambio colore, li mette neri
     */
    private void changeAllDark(){
        for(int i = 0; i < NUMBER_OF_BUTTON; i++){
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
        }
    }

    /**
     * Funzione a supporto del cambio colore, li mette bianchi
     */
    private void changeAllWhite(){
        for(int i = 0; i < NUMBER_OF_BUTTON; i++){
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
        }
    }

    public void setStage(final Stage stage){
        this.stage = stage;
    }

    public static List<Button> getListButton(){ return listButtonGrid; }

}
