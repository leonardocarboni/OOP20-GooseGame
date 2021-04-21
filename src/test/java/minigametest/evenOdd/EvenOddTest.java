package minigametest.evenodd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import application.minigame.evenodd.fxItem.Choice;



public class EvenOddTest {

    private Choice choice = null;

    @Test
    @DisplayName("Check win")
    public void checkWin() {
        assertEquals(true, checkWin(1, 3)); //TRUE
        assertEquals(Choice.DISPARI, choice); // it is odd

        assertEquals(true, checkWin(2, 4)); //TRUE
        assertEquals(Choice.PARI, choice); // it is even

        assertNotEquals(false, checkWin(1, 4)); //TRUE
        assertNotEquals(Choice.PARI, choice); // it is odd but even is generated
    }





    public boolean checkWin(final int value, final int testValue) {
        if (value == 1) {
            choice = Choice.DISPARI;
        } else {
            choice = Choice.PARI;
        }
        if ((value == 2 && testValue % 2 == 0) || (value == 1 && testValue + 1 % 2 != 0)) {
            return true;
        }
        return false;
    }


}

