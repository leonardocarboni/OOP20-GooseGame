package model.choice;

import java.util.List;
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

    /**
     * Is use for testing.
     * Creates hypothetical computer choices
     * @return choice.
     */
    public static RockPaperScissorsChoice setComputerChoice() {
        return RockPaperScissorsChoice.ROCK;
    }

    /**
     * Is use for testing.
     * Creates a list of hypothetical user choices
     * @return list of choice;
     */
    public static List<RockPaperScissorsChoice> setInputChoice() {
        return List.of(ROCK, PAPER, SCISSORS);
    }
}
