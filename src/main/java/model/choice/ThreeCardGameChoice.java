package model.choice;

import java.util.List;
import java.util.Random;

public enum ThreeCardGameChoice {
    /**
     * SX_POS.
     */
    SX_POS,
    /**
     * CENTER_POS.
     */
    CENTER_POS,
    /**
     * DX_POS.
     */
    DX_POS;

    /**
     * Gets a random choice.
     * @return choice
     */
    public static ThreeCardGameChoice getRandomChoice() {
        final Random r = new Random();
        return ThreeCardGameChoice.values()[r.nextInt(ThreeCardGameChoice.values().length)];
    }

    /**
     * Is use for testing.
     * Creates a list of hypothetical  choices
     * @return list of choice;
     */
    public static List<ThreeCardGameChoice> setComputerChoice() {
        return List.of(SX_POS, CENTER_POS, DX_POS);
    }
    /**
     * Is use for testing.
     * Creates a list of hypothetical user choices
     * @return list of choice;
     */
    public static List<ThreeCardGameChoice> setInputChoice() {
        return List.of(DX_POS, SX_POS, CENTER_POS);
    }
}
