package application.minigame.threecardgame;

import java.util.Random;

public enum Choice {
    SX_POS,
    CENTER_POS,
    DX_POS;

    public static Choice getRandomChoice() {
        final Random r = new Random();
        return Choice.values()[r.nextInt(Choice.values().length)];
    }
}
