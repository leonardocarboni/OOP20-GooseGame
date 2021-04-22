package model.choice;

import java.util.Random;

public enum ThreeCardGameChoice {
    SX_POS,
    CENTER_POS,
    DX_POS;

    public static ThreeCardGameChoice getRandomChoice() {
        final Random r = new Random();
        return ThreeCardGameChoice.values()[r.nextInt(ThreeCardGameChoice.values().length)];
    }
}
