package model.choice;

import java.util.Random;




public enum RockPaperScissorsChoice {
    /**
     * ROCK.
     */
    ROCK,
    /**
     * PAPER.
     */
    PAPER,
    /**
     * SCISSORS.
     */
    SCISSORS;

    /**
     * Gets a random choice.
     * @return choice
     */
    public static RockPaperScissorsChoice getRandomChoice() {
        final Random r = new Random();
        return RockPaperScissorsChoice.values()[r.nextInt(RockPaperScissorsChoice.values().length)];
    }
}
