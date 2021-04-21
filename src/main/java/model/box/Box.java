package model.box;

public enum Box {

    /**
     * Start Box.
     */
    START(BoxType.NORMAL, "Start"),
    /**
     * Normal Box.
     */
    NORMAL(BoxType.NORMAL, "Normal"),
    /**
     * End Box.
     */
    END(BoxType.NORMAL, "End"),
    /**
     * Tic Tac Toe Box.
     */
    TICTACTOE(BoxType.MINIGAMES, "Tic Tac Toe"),
    /**
     * Even Or Odd Box.
     */
    EVEN_OR_ODD(BoxType.MINIGAMES, "Even Or Odd"),
    /**
     * Rock Paper Scissors Box.
     */
    ROCK_PAPER_SCISSORS(BoxType.MINIGAMES, "Rock Paper Scissors"),
    /**
     * Cable Connect Box.
     */
    CABLE_CONNECT(BoxType.MINIGAMES, "In this minigame you have to connect the 4 colored cables starting\n" 
     + "from the boxes on the left and ending in the corresponding boxes on the right"),
    /**
     * Phrase Catch Box.
     */
    PHRASE_CATCH(BoxType.MINIGAMES, "In this minigame you have to write the sentence that is proposed to\n" 
     + "you in the shortest possible time, making the minimum number of mistakes possible."),
    /**
     * Space Shooter Box.
     */
    SPACESHOOTER(BoxType.MINIGAMES, "Space Shooter"),
    /**
     * Memory Box.
     */
    MEMORY(BoxType.MINIGAMES, "Memory");

    private BoxType type;
    private String description;

    Box(final BoxType type, final String description) {
        this.type = type;
        this.description = description;
    }

    public BoxType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

}
