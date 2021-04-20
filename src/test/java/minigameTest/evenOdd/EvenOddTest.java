package minigameTest.evenOdd;

import application.minigame.evenodd.fxItem.Choice;
import application.minigame.evenodd.mainGame.EvenOdd;
import controller.minigame.MinigameController;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class EvenOddTest {

    Choice choice = null;

    @Test
    @DisplayName("Check win")
    public void checkWin(){
        assertEquals(true,checkWin(1,3)); //TRUE
        assertEquals(Choice.DISPARI,choice); // it is odd

        assertEquals(true,checkWin(2,4)); //TRUE
        assertEquals(Choice.PARI,choice); // it is even

        assertNotEquals(false,checkWin(1,4)); //TRUE
        assertNotEquals(Choice.PARI,choice); // it is odd but even is generated
    }





    public boolean checkWin(int value, int testValue){
        if(value == 1){
            choice = Choice.DISPARI;
        } else{
            choice = Choice.PARI;
        }
        if((value == 2 && testValue % 2 == 0) || (value == 1 && testValue+1 % 2 != 0)){
            return true;
        }
        return false;
    }


}

