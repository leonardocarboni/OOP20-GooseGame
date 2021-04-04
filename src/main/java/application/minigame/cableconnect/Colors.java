package application.minigame.cableconnect;

import java.util.Random;

public enum Colors {
    RED("#CF0000"),
    BLUE("#0000CF"),
    GREEN("#00CF00"),
    YELLOW("#CFCF00");

    final private String colorHex;

    Colors(String colorHex) {
        this.colorHex = colorHex;
    }

    static Colors[] getColors(){
        return new Colors[]{RED, BLUE, GREEN, YELLOW};
    }

    static Colors[] getRandomColors(){
        Random rand = new Random();
        Colors[] randomColorsArray = getColors();

        //shuffle end colors array
        for (int i = 0; i < randomColorsArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(randomColorsArray.length);
            Colors temp = randomColorsArray[randomIndexToSwap];
            randomColorsArray[randomIndexToSwap] = randomColorsArray[i];
            randomColorsArray[i] = temp;
        }
        return randomColorsArray;
    }
}
