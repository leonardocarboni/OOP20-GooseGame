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

    private static List<ThreeCardGameChoice> computerChoice;

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
     * Creates a list of hypothetical  choices.
     * @param choices of position.
     */
    public static void setComputerChoice(List<ThreeCardGameChoice> choices) {
        computerChoice = choices;
    }

    /**
     * Is use for testing.
     * @return choices set in setComputerChoice.
     */
    public static List<ThreeCardGameChoice> getComputerChoice() {
        return computerChoice;
    }
}
