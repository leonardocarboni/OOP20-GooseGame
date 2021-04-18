package application.minigame.evenodd.fxItem;

import application.minigame.evenodd.mainGame.GettersMVC;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * Classe che fornisce variabili statiche per prendere immagini.
 */

public class BackgroundLoader {
    private static final BackgroundSize bs = new BackgroundSize(300, 400, true, true, true, false);

    /* sfondo della schermata finale del gioco */
    static final BackgroundImage buttonPrincipal = new BackgroundImage(new Image("evenodd/button.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);

    public static final BackgroundImage background = new BackgroundImage(
            new Image("evenodd/background.png", 600, 480, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public static final BackgroundImage winner = new BackgroundImage(new Image("evenodd/winner.jpg"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);

    public static final BackgroundImage loser = new BackgroundImage(new Image("evenodd/loserr.jpg"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public static final BackgroundImage animationGif = new BackgroundImage(new Image("evenodd/tenor.gif"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);

}
