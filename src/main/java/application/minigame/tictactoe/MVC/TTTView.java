package application.minigame.tictactoe.MVC;


import application.minigame.tictactoe.JFXItem.ButtonDropper;
import javafx.scene.control.Button;
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
public class TTTView {


    //creo un hanlder da dare ai bottoni
    private final TTTController handler = new TTTController();

    /**
     * Creo lo stage
     */
    public Stage stage = new Stage();

    protected final TTTModel model = new TTTModel();

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
     * Costruttore della classe controller. Crea la lista dei bottoni nel gioco
     */
    public TTTView(){
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
                model.checkWin();
                return;
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

    public void setStage(final Stage stage){
        this.stage = stage;
    }

    public static List<Button> getListButton(){
        return listButtonGrid;
    }

}
