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
    TICTACTOE(BoxType.MINIGAMES, "Tic-Tac-Toe is a two players game in a 3x3 grid. \n"
            + "One player puts the X, the other the O, alternating each other.\nThe winner is whoever puts their mark"
            + "lined up in: oblique, vertical and horizontal.\nIn the hope of making it competitive, it can be played "
            + "in 4x4,5x5,6x6."),
    /**
     * Even Or Odd Box.
     */
    EVEN_OR_ODD(BoxType.MINIGAMES, "Even or Odd is a very simple game, you choose whether to bet on EVEN"
            + " or ODD.\nIf your choice matches the computer's one you win, otherwise you loose..."),
    /**
     * Rock Paper Scissors Box.
     */
    ROCK_PAPER_SCISSORS(BoxType.MINIGAMES, "Rock beats scissors, Scissors beats paper, paper beats rock.\n"
            + "The mini-game is composed of 3 rounds, whoever wins 2 of them wins the game.\n"),
    /**
     * Cable Connect Box.
     */
    CABLE_CONNECT(BoxType.MINIGAMES, "In this minigame you have to connect the 4 colored cables starting\n" 
     + "from the boxes on the left and ending in the corresponding boxes on the right"),
    /**
     * Phrase Catch Box.
     */
    PHRASE_CATCH(BoxType.MINIGAMES, "In this minigame you have to write the sentence that is proposed to\n" 
     + "you in the shortest possible time, making the minimum number of mistakes possible.\n" 
     + "Remember to click the submit button to stop the timer or click the Enter Button!"),
    /**
     * Space Shooter Box.
     */
    SPACESHOOTER(BoxType.MINIGAMES, "Space shooter is a minigame in which a player must shoot at\n"
            + "rockets while preventing them from destroying him."),
    /**
     * Memory Box.
     */
    MEMORY(BoxType.MINIGAMES, "The aim of the game is to remember and enter, using the appropriate buttons,\n"
            + "a sequence of 5 numbers that after a short time will be blacked out.\n"
            + "Remember to click Check when you finished!"),
    /**
     * Three card game Box.
     */
    THREE_CARD_GAME(BoxType.MINIGAMES, "The aim of the game is to guess where the \"queen\""
            + "(represented by a green tick) is.\nThere are three cards: one of them will be the \"queen\", while the "
            + "others will be the \"two\" (represented by a red X).\nAt the end of each turn a \"continue\" button "
            + "will be enabled, which will allow a new turn to be taken.\nThe game is played to the best of three.");

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
