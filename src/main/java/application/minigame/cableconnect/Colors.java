package application.minigame.cableconnect;

import java.util.Random;

public enum Colors {
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

    Colors(final String color) {
        this.colorHex = color;
    }

    public String getColorHex() {
        return this.colorHex;
    }

    static Colors[] getColors() {
        return new Colors[]{RED, BLUE, GREEN, YELLOW};
    }

    /**
     * Generates a random ordered array of colors.
     * @return a random ordered array of colors.
     */
    static Colors[] getRandomColors() {
        final Random rand = new Random();
        Colors[] randomColorsArray = getColors();

        //shuffle end colors array
        for (int i = 0; i < randomColorsArray.length; i++) {
            final int randomIndexToSwap = rand.nextInt(randomColorsArray.length);
            final Colors temp = randomColorsArray[randomIndexToSwap];
            randomColorsArray[randomIndexToSwap] = randomColorsArray[i];
            randomColorsArray[i] = temp;
        }
        return randomColorsArray;
    }
}
