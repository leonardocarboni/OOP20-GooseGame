package application.minigame.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControllerTicTacToe {
    private final BackgroundImage bi = new BackgroundImage(new Image("TicTacToe/Sfondo.png",200,170,false,false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    //creo un hanlder
    private final Handler handler = new Handler(bi);
    
    private final List<Button> listButton = new ArrayList<>();
    private final List<Integer> number = List.of(0,0,0,1,1,1,2,2,2);
    private final List<String> sign = List.of("X", "O");
    static private final int BOARD_SIZE = 9;
    
    public ControllerTicTacToe(){
        final DropShadow shadow = new DropShadow();
        for(int i = 0; i < 9; i++){
            final Button btn = new Button();
            btn.setEffect(shadow);
            btn.setBackground(new Background(bi));
            btn.setPrefSize(200,200);
            btn.setFont(Font.font("Arial", FontPosture.ITALIC,80));
            btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.eh);
            btn.addEventFilter(MouseEvent.MOUSE_PRESSED, handler.click);
            btn.addEventFilter(MouseEvent.MOUSE_RELEASED, handler.released);
            listButton.add(btn);
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

    protected boolean checkWin(){
        for(int i = 0; i < 7; i+=3){
            for(int j = 0; j < 2; j++){
                if(listButton.get(i).getText() == sign.get(j)
                        && listButton.get(i+1).getText() == sign.get(j)
                        && listButton.get(i+2).getText() == sign.get(j))
                {
                    return true;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                if(listButton.get(i).getText() == sign.get(j)
                        && listButton.get(i+3).getText() == sign.get(j)
                        && listButton.get(i+6).getText() == sign.get(j))
                {
                    return true;
                }
            }
        }
        for(int j = 0; j < 2; j++) {
            if (listButton.get(0).getText() == sign.get(j)
                    && listButton.get(4).getText() == sign.get(j)
                    && listButton.get(8).getText() == sign.get(j)) {
                return true;
            }
            if (listButton.get(2).getText() == sign.get(j)
                    && listButton.get(4).getText() == sign.get(j)
                    && listButton.get(6).getText() == sign.get(j)) {
                return true;
            }
        }
        return false;
    }

    //creo una griglia di bottoni e la ritorno
    //viola 103i123912803180293890 principi ma per ora okay
    public GridPane createButton(){
        final GridPane root = new GridPane();
        listButton.stream()
                .forEach(i -> root.add(i, listButton.indexOf(i) % 3, number.get(listButton.indexOf(i)), 1 , 1));
        return  root;
    }

    //ritorno la lista di bottoni
    public List<Button> getList(){
        return listButton;
    }


}
