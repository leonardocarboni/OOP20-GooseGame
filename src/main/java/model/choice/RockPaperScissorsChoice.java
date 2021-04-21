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
     * Creates a list of hypothetical computer choices
     * @return list of choice.
     */
    public List<RockPaperScissorsChoice> setComputerChoice() {
        return List.of(PAPER, SCISSORS, ROCK);
    }

    /**
     * Is use for testing.
     * Creates a list of hypothetical user choices
     * @return list of choice;
     */
    public List<RockPaperScissorsChoice> setInputChoice() {
        return List.of(ROCK, PAPER, SCISSORS);
    }
}
