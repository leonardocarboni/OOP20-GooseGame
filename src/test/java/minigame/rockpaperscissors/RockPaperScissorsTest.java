package minigame.rockpaperscissors;

import model.choice.RockPaperScissorsChoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RockPaperScissorsTest {


    @Test
    public void checkWinner() {
        var code = RockPaperScissorsChoice.setComputerChoice();
        List<RockPaperScissorsChoice> inputCode = RockPaperScissorsChoice.setInputChoice();
        assertEquals(code, inputCode.get(0));
    }

    @Test
    public void checkLose() {
        var code = RockPaperScissorsChoice.setComputerChoice();
        List<RockPaperScissorsChoice> inputCode = RockPaperScissorsChoice.setInputChoice();

        assertNotEquals(code, inputCode.get(1));
        assertNotEquals(code, inputCode.get(2));
    }
}
