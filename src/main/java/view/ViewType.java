package view;

public enum ViewType {

    /**
     * Menu Type.
     */
    STARTING_MENU("Goose Game", "layouts/menu.fxml"),
    /**
     * Choose Player Type.
     */
    CHOOSE_PLAYER("Choose a Player", "layouts/playerselection.fxml"),
    /**
     * Play Game Type.
     */
    GAME("Play Game", "layouts/maingame.fxml"),
    /**
     * Cable Connect Type.
     */
    CABLE_CONNECT("Minigame Cable Connect", "layouts/cableconnect.fxml"),
    /**
     * Rock Paper Scissors Type.
     */
    ROCK_PAPER_SCISSORS("Minigame ROCK PAPER SCISSORS", "layouts/rps.fxml"),
    /**
     * Memory Type.
     */
    MEMORY("Minigame Memory", "layouts/memory.fxml"),
    /**
     * Phrase Catch Type.
     */
    PHRASE_CATCH("Phrase Catch", "layouts/phrasecatch.fxml"),
    /**
     * Three card Type.
     */
    THREE_CARD_GAME("Three Card Game", "layouts/threecard.fxml"),
    /**
     * WinScreen Type.
     */
    WINSCREEN("Final Scoreboard", "layouts/winscreen.fxml"),
    /**
     * How to play Type.
     */
    HOWTOPLAY("How To Play", "layouts/howtoplay.fxml");


    private String title;
    private String layoutLocation;

    ViewType(final String title, final String layoutLocation) {
        this.title = title;
        this.layoutLocation = layoutLocation;
    }

    public String getTitle() {
        return title;
    }

    public String getLayoutLocation() {
        return layoutLocation;
    }
}
