package minigame.rockpaperscissors;

import model.choice.RockPaperScissorsChoice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RockPaperScissorsTest {

    private static RockPaperScissorsChoice rps;

    @Test
    public void checkWinner() {
       RockPaperScissorsChoice.setComputerChoice(RockPaperScissorsChoice.ROCK);
       rps = RockPaperScissorsChoice.getComputerChoice();

       assertEquals(RockPaperScissorsChoice.ROCK, rps);
       assertNotEquals(RockPaperScissorsChoice.PAPER, rps);
       assertNotEquals(RockPaperScissorsChoice.SCISSORS, rps);
    }
}
