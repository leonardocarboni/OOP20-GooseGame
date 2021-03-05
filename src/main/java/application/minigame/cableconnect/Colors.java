package application.minigame.cableconnect;

public enum Colors {
    RED("#CF0000"),
    BLUE("#0000CF"),
    GREEN("#00CF00"),
    YELLOW("#CFCF00");


    Colors(String color) {
    }

    static Colors[] getColors(){
        return new Colors[]{RED, BLUE, GREEN, YELLOW};
    }
}
