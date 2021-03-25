package application.minigame.evenodd.mvc;

import javafx.scene.control.Button;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class EOModel {


    Random rnd = new Random();
    int rndValue = rnd.nextInt(10);
    GettersMVC getters = new GettersMVC();


    public void checkWin(int value){
        if((value == 2 && rndValue % 2 == 0) || (value != 2 && rndValue % 2 != 0)){
            getters.getView().result=true;
        }
    }


}
