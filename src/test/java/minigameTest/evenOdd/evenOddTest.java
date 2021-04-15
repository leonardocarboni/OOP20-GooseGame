package minigameTest.evenOdd;

import application.minigame.evenodd.fxItem.Choice;
import application.minigame.evenodd.mainGame.EvenOdd;
import application.minigame.evenodd.mvc.EOController;
import application.minigame.evenodd.mvc.EOModel;
import application.minigame.evenodd.mvc.EOView;
import application.minigame.evenodd.mvc.GettersMVC;
import application.minigame.spaceshooter.info.InfoGame;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;


public class evenOddTest {

    EOModel model = null;
    GettersMVC getters = new GettersMVC();
    private final Random rnd = new Random();
    private final int rndValue = rnd.nextInt(10);
    EOView view = null;
    EOController controller = null;
    EvenOdd eo = null;

    @Test
    @DisplayName("Check win")
    public void checkWin(){

        eo = new EvenOdd();
        view = getters.getView();
        model = getters.getModel();
        controller = getters.getController();

        model.checkWin(1); // 1 equals to DISPARI

        Assert.assertEquals(Choice.DISPARI,view.playerChoice); //TRUE

        model.checkWin(0); // 0 equals to DISPARI

        Assert.assertEquals(Choice.PARI,view.playerChoice); //TRUE

        Assert.assertNotEquals(Choice.DISPARI,view.playerChoice); //TRUE


    }





    public void checkWin(int value){
        if((value == 2 && rndValue % 2 == 0) || (value == 1 && rndValue % 2 != 0)){
            getters.getView().result=true;
        }
        if(value == 1){
            getters.getView().playerChoice = Choice.DISPARI;
        } else{
            getters.getView().playerChoice = Choice.PARI;
        }
        getters.getView().resultValue=rndValue;

    }


}

