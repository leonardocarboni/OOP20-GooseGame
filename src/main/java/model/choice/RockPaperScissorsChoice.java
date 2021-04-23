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

    private static RockPaperScissorsChoice rps;

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
     * Creates hypothetical computer choice.
     * @param choice between rock, paper and scissors.
     */
    public static void setComputerChoice(final RockPaperScissorsChoice choice) {
        rps  = choice;
    }

    /**
     * Is use for testing.
     * @return returns the choice set in the setComputerChoice.
     */
    public static RockPaperScissorsChoice getComputerChoice() {
        return rps;
    }

}
