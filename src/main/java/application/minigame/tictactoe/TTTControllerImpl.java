package application.minigame.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller del gioco, esso si occupa della creazione di bottoni, di disegnare la "O" e vedere chi vince
 */
public class TTTControllerImpl implements  TTTController {


    //creo un hanlder da dare ai bottoni
    private final Handler handler = new Handler();

    /**
     * Creo lo stage
     */
    protected Stage stage = new Stage();


    private final List<Integer> number = List.of(0,0,0,1,1,1,2,2,2);
    private final List<Integer> number2 = List.of(0,0,1,1,2,2);
    private final List<String> sign = List.of("X", "O");
    /**
     * Lista dei bottoni presenti nella griglia principale 3x3
     */
    protected final List<Button> listButtonGrid = new ArrayList<>();
    /**
     * Lista dei bottono sotto la griglia 3x3
     */
    private final List<Button> listBottomButton = new ArrayList<>();
    /**
     * Numero di click che viene fatto, viene usata in caso che nessuno vinca
     */
    private int numberOfClick=0;

    /**
     * Costruttore della classe controller. Crea la lista dei bottoni nel gioco
     */
    public TTTControllerImpl(){
        final ButtonDropper btn = new ButtonDropper();
        for(int i = 0; i < 9; i++){
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
        for (int i = 0; i < 9; i++) {
            final Random rnd = new Random();
            final int numCase = rnd.nextInt(9);
            if (listButtonGrid.get(numCase).getText().equals("")) {
                listButtonGrid.get(numCase).setText("O");
                checkWin();
                return;
            }
        }
    }

    /**
     * Metodo che ritorna il vincitore
     * @return Stringa vincitore
     */
    public String checkWin(){
        numberOfClick++;
        for(int i = 0; i < 7; i+=3){
            for(int j = 0; j < 2; j++){
                if(listButtonGrid.get(i).getText().equals(sign.get(j))
                        && listButtonGrid.get(i+1).getText().equals(sign.get(j))
                        && listButtonGrid.get(i+2).getText().equals(sign.get(j)))
                {
                    return sign.get(j);
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                if(listButtonGrid.get(i).getText().equals(sign.get(j))
                        && listButtonGrid.get(i+3).getText().equals(sign.get(j))
                        && listButtonGrid.get(i+6).getText().equals(sign.get(j)))
                {
                    return sign.get(j);
                }
            }
        }
        for(int j = 0; j < 2; j++) {
            if (listButtonGrid.get(0).getText().equals(sign.get(j))
                    && listButtonGrid.get(4).getText().equals(sign.get(j))
                    && listButtonGrid.get(8).getText().equals(sign.get(j))) {
                return sign.get(j);
            }
            if (listButtonGrid.get(2).getText().equals(sign.get(j))
                    && listButtonGrid.get(4).getText().equals(sign.get(j))
                    && listButtonGrid.get(6).getText().equals(sign.get(j))) {
                return sign.get(j);
            }
        }
        if(numberOfClick==9){
            return "No one";
        }
        return "";
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

    public void setStage(Stage stage){
        this.stage = stage;
    }

}
