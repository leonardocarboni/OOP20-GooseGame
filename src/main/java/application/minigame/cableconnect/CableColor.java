package application.minigame.cableconnect;

import java.util.Random;

public enum CableColor {
    /**
     * Red color (#CF0000).
     */
    RED("#CF0000"),
    /**
     * Blue color (#0000CF).
     */
    BLUE("#0000CF"),
    /**
     * Green color (#00CF00).
     */
    GREEN("#00CF00"),
    /**
     * Yellow color (#CFCF00).
     */
    YELLOW("#CFCF00");

    private String colorHex;

    CableColor(final String color) {
        this.colorHex = color;
    }

    static CableColor[] getColors() {
        return new CableColor[]{RED, BLUE, GREEN, YELLOW};
    }

    /**
     * Generates a random ordered array of colors.
     * @return a random ordered array of colors.
     */
    static CableColor[] getRandomColors() {
        final Random rand = new Random();
        CableColor[] randomColorsArray = getColors();

        //shuffle end colors array
        for (int i = 0; i < randomColorsArray.length; i++) {
            final int randomIndexToSwap = rand.nextInt(randomColorsArray.length);
            final CableColor temp = randomColorsArray[randomIndexToSwap];
            randomColorsArray[randomIndexToSwap] = randomColorsArray[i];
            randomColorsArray[i] = temp;
        }
        return randomColorsArray;
    }
}
