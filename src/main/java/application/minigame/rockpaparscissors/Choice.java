package application.minigame.rockpaparscissors;

import java.util.Random;




public enum Choice {
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
    public static Choice getRandomChoice() {
        final Random r = new Random();
        return Choice.values()[r.nextInt(Choice.values().length)];
    }
}
