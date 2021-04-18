package model.game;

public enum StateGame {

    /**
     * Start Type used to initialize game.
     */
    START,

    /**
     * Phrase where players roll dice to choose starting queue.
     */
    CHOOSE_STARTING_QUEUE,

    /**
     * Phrase where all players play.
     */
    CONTINUE,

    /**
     * End Phrase.
     */
    END;
}
