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
     * Bonus Box.
     */
    BONUS(BoxType.LUCK, "Bonus"),
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
    CABLE_CONNECT(BoxType.MINIGAMES, "Cable Connect"),
    /**
     * Phrase Catch Box.
     */
    PHRASE_CATCH(BoxType.MINIGAMES, "Phrase Catch"),
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
