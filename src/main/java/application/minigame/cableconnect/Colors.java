package application.minigame.cableconnect;

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
}
