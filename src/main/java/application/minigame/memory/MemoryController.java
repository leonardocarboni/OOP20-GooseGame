package application.minigame.memory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class MemoryController implements Initializable {



    @FXML
    GridPane gridLayoutBOT, gridLayoutPlayer;

    @FXML
    ProgressBar timeBar;



    final private Random random = new Random();
    private List<Pair<Integer,Integer>> posCOM = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void fillGridCOM(GridPane gridLayoutBOT){
       for (int i = 0; i < gridLayoutBOT.getRowCount(); i++) {
           for (int j = 0; j < gridLayoutBOT.getColumnCount(); j++){
               var current = new Pair<>(j,i);
               this.posCOM.add(current);

           }
       }
    }






}
