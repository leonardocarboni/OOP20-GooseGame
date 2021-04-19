package application.minigame.rockpaparscissors;

import java.util.Random;

public enum Choice {
    ROCK,
    PAPER,
    SCISSORS;

    public static Choice getRandomChoice() {
        final Random r = new Random();
        return Choice.values()[r.nextInt(Choice.values().length)];
    }
}
