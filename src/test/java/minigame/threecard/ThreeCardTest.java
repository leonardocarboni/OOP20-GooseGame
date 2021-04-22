package minigame.threecard;

import model.choice.ThreeCardGameChoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThreeCardTest {


    @Test
    public void checkWin() {
        var computerChoice = ThreeCardGameChoice.setComputerChoice();
        var inputChoice = ThreeCardGameChoice.setInputChoice();

        //sxpos = sxpos
        assertEquals(computerChoice.get(0), inputChoice.get(1));
        //centerpos = centerpos
        assertEquals(computerChoice.get(1), inputChoice.get(2));
        //dxpos = dxpos
        assertEquals(computerChoice.get(2), inputChoice.get(0));
    }

    @Test
    public void checkLose() {
        var computerChoice = ThreeCardGameChoice.setComputerChoice();
        var inputChoice = ThreeCardGameChoice.setInputChoice();

        //sxpos != dxpos
        assertNotEquals(computerChoice.get(0), inputChoice.get(0));
        //centerpos != sxpos
        assertNotEquals(computerChoice.get(1), inputChoice.get(1));
        //dxpos != centerpos
        assertNotEquals(computerChoice.get(2), inputChoice.get(2));
    }
}
