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


public class TTTControllerImpl implements  TTTController {


    //creo un hanlder
    private final Handler handler = new Handler();
    protected Stage stage = new Stage();

    protected final List<Button> listButtonGrid = new ArrayList<>();
    private final List<Integer> number = List.of(0,0,0,1,1,1,2,2,2);
    private final List<Integer> number2 = List.of(0,0,1,1,2,2);
    private final List<String> sign = List.of("X", "O");
    private final List<Button> listBottomButton = new ArrayList<>();
    private int numberOfClick=0;


    public TTTControllerImpl(){
        final ButtonDropper btn = new ButtonDropper();
        for(int i = 0; i < 9; i++){
            listButtonGrid.add(btn.gridButton(handler));
        }
        handler.setListButton(listButtonGrid);

        listBottomButton.add(0,btn.gameDarkModeIcon(Optional.of(handler),""));
        listBottomButton.add(1,btn.gameDarkModeIconText(Optional.empty(),""));
        listBottomButton.add(2,btn.pauseButtonIcon(Optional.of(handler),""));
        listBottomButton.add(3,btn.pauseButtonIconText(Optional.empty(),""));


        handler.setListButtonBottom(listBottomButton);
    }

    
    //funzione che crea la scelta del pc
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

    //metodo che controlla chi ha vinto
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

    //creo una griglia di bottoni e la ritorno
    public GridPane createButton(){
        final GridPane root = new GridPane();
        listButtonGrid.stream()
                .forEach(i -> root.add(i, listButtonGrid.indexOf(i) % 3, number.get(listButtonGrid.indexOf(i)), 1 , 1));
        listBottomButton.stream()
                .forEach(i -> root.add(i, number2.get(listBottomButton.indexOf(i)), 3, 1 , 1));
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        return  root;
    }

    //ritorno la lista di bottoni
    public List<Button> getList(){
        return listButtonGrid;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

}
