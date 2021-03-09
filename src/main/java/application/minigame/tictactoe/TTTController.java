package application.minigame.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;

public interface TTTController {

    //funzione che crea la scelta del pc
    void drawO();

    //metodo che controlla chi ha vinto
    String checkWin();

    //creo una griglia di bottoni e la ritorno
    public GridPane createButton();

    public void setStage(Stage stage);

}