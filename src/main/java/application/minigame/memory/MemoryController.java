package application.minigame.memory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MemoryController implements Initializable {

    @FXML
    GridPane gridLayoutBOT, gridLayoutPlayer;

    @FXML
    ProgressBar timeBar;



    final private Random random = new Random();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void colorGridCom(GridPane gridLayoutBOT){

        
    }




}
