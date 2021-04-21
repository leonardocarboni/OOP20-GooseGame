package application.minigame.evenodd.fxItem;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * Class that give images.
 */

public final class BackgroundLoader {
    private BackgroundLoader() {
    }
    private static final BackgroundSize BACK_SIZE = new BackgroundSize(300, 400, true, true, true, false);

    /**
     * Button style for text odd and even.
     */
    static final BackgroundImage BUTTON_PRINCIPAL = new BackgroundImage(new Image("evenodd/button.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BACK_SIZE);

    /**
     * Background image for the game.
     */
    public static final BackgroundImage BACKGROUND = new BackgroundImage(
            new Image("evenodd/background.png", 600, 480, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Image that say "winner".
     */
    public static final BackgroundImage WINNER_IMG = new BackgroundImage(new Image("evenodd/winner.jpg"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BACK_SIZE);

    /**
     * Image that say "loser".
     */
    public static final BackgroundImage LOSER_IMG = new BackgroundImage(new Image("evenodd/loserr.jpg"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
}
