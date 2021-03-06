package application.minigame.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControllerTicTacToe {




    //creo un hanlder
    private final Handler handler = new Handler();
    protected Stage stage = new Stage();

    protected final List<Button> listButton = new ArrayList<>();
    private final List<Integer> number = List.of(0,0,0,1,1,1,2,2,2);
    private final List<String> sign = List.of("X", "O");
    static private final int BOARD_SIZE = 9;
    public GridPane grid = new GridPane();
    
    public ControllerTicTacToe(){
        final DropShadow shadow = new DropShadow();
        for(int i = 0; i < 9; i++){
            final ButtonDropper btn = new ButtonDropper();
            listButton.add(btn.gridButton(handler));
        }
        handler.setListButton(listButton);
    }

    protected void drawO() {
        for(int i = 0; i < 9; i++){
            final Random rnd = new Random();
            final int numCase = rnd.nextInt(9);
            if(listButton.get(numCase).getText() == ""){
                listButton.get(numCase).setText("O");
                return;
            }
        }
    }

    protected String checkWin(){
        for(int i = 0; i < 7; i+=3){
            for(int j = 0; j < 2; j++){
                if(listButton.get(i).getText() == sign.get(j)
                        && listButton.get(i+1).getText() == sign.get(j)
                        && listButton.get(i+2).getText() == sign.get(j))
                {
                    return sign.get(j);
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                if(listButton.get(i).getText() == sign.get(j)
                        && listButton.get(i+3).getText() == sign.get(j)
                        && listButton.get(i+6).getText() == sign.get(j))
                {
                    return sign.get(j);
                }
            }
        }
        for(int j = 0; j < 2; j++) {
            if (listButton.get(0).getText() == sign.get(j)
                    && listButton.get(4).getText() == sign.get(j)
                    && listButton.get(8).getText() == sign.get(j)) {
                return sign.get(j);
            }
            if (listButton.get(2).getText() == sign.get(j)
                    && listButton.get(4).getText() == sign.get(j)
                    && listButton.get(6).getText() == sign.get(j)) {
                return sign.get(j);
            }
        }
        return "";
    }

    //creo una griglia di bottoni e la ritorno
    //viola 103i123912803180293890 principi ma per ora okay
    public GridPane createButton(){
        final GridPane root = new GridPane();
        listButton.stream()
                .forEach(i -> root.add(i, listButton.indexOf(i) % 3, number.get(listButton.indexOf(i)), 1 , 1));
        this.grid = root;
        return  root;
    }

    //ritorno la lista di bottoni
    public List<Button> getList(){
        return listButton;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

}
