package application.minigame.tictactoe.fxItem;

import application.minigame.tictactoe.mvc.GettersMVC;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * Class that gives images.
 */
public class BackgroundLoader {
    private final static GettersMVC getters = new GettersMVC();
    private final static int factor = getters.getSize();

    /**
     * Background image of the game.
     */
    public static final BackgroundImage gameButtonBackground = new BackgroundImage(
            new Image("TicTacToe/Sfondo.png", calcResizeX(), calcResizeY(), false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Black background of the game.
     */
    public static final BackgroundImage gameButtonBackgroundBlack = new BackgroundImage(
            new Image("TicTacToe/SfondoBlack.png", calcResizeX(), calcResizeY(), false, false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Background of the final thread. The difference from gameButtonBackground is the size.
     */
    public static final BackgroundImage endGameButtonBackground = new BackgroundImage(
            new Image("TicTacToe/Sfondo.png", 600, 480, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Black background of the final thread. The difference from gameButtonBackground is the size.
     */
    public static final BackgroundImage endGameButtonBackgroundBlack = new BackgroundImage(
            new Image("TicTacToe/SfondoBlack.png", 600, 480, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Button for change color mode.
     */
    public static final BackgroundImage darkButtonIcon = new BackgroundImage(
            new Image("TicTacToe/Click.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Black button for change color mode.
     */
    public static final BackgroundImage darkButtonIconDark = new BackgroundImage(
            new Image("TicTacToe/ClickBlack.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    /**
     * Size of the button.
     */
    private static final BackgroundSize bs = new BackgroundSize(300, 400, true, true, false, true);

    /**
     * Button on the second thread.
     */
    static final BackgroundImage endGameButton = new BackgroundImage(new Image("TicTacToe/green_button01.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);

    /**
     * Calc resize of the X when you change the grid dimension.
     * @return
     */
    private static int calcResizeX() {
        if (factor <= 2 || factor >= 7) {
            throw new IllegalArgumentException();
        }
        if (factor >= 3 && factor <= 6) {
            return 200 - (factor - 3) * 30;
        }
        return 0;
    }

    /**
     * Calc resize of the Y when you change the grid dimension.
     * @return
     */
    private static int calcResizeY() {
        if (factor >= 3 && factor <= 6) {
            return 145 - (factor - 3) * 23;
        }
        return 0;
    }

}
