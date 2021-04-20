package application.minigame.tictactoe.fxItem;

import application.minigame.tictactoe.mainGame.TicTacToe;
import application.minigame.tictactoe.mvc.GettersMVC;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * Class that gives images.
 */
public final class BackgroundLoader {
    private BackgroundLoader() {
    }
    private final static GettersMVC getters = new GettersMVC();
    private final static int factor = getters.getSize();
    /**
     * Maximum grid size is 6x6.
     */
    private final static int MAX_GRID_DIM = 6;
    /**
     * Minimum grid size is 3x3.
     */
    private final static int MIN_GRID_DIM = 3;
    /**
     * Multiplier used for resise X.
     */
    private final static int RESIZE_MULTIPLIER_X = 200;
    /**
     * Multiplier used for resise Y.
     */
    private final static int resizeMultiplierY = 200;
    /**
     * Background image of the game.
     */
    public static final BackgroundImage GAME_BUTTON_BACKGROUND = new BackgroundImage(
            new Image("TicTacToe/Sfondo.png", calcResizeX(), calcResizeY(), false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    /**
     * Black background of the game.
     */
    public static final BackgroundImage GAME_BUTTON_BACKGROUND_BLACK = new BackgroundImage(
            new Image("TicTacToe/SfondoBlack.png", calcResizeX(), calcResizeY(), false, false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    /**
     * Background of the final thread. The difference from gameButtonBackground is
     * the size.
     */
    public static final BackgroundImage END_GAME_BUTTON_BACKGROUND = new BackgroundImage(
            new Image("TicTacToe/Sfondo.png", TicTacToe.getSceneWidth(), TicTacToe.getSceneHeight(), false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    /**
     * Black background of the final thread. The difference from
     * gameButtonBackground is the size.
     */
    public static final BackgroundImage END_GAME_BUTTON_BACKGROUND_BLACK = new BackgroundImage(
            new Image("TicTacToe/SfondoBlack.png", TicTacToe.getSceneWidth(), TicTacToe.getSceneHeight(), false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    /**
     * Button for change color mode.
     */
    public static final BackgroundImage CHANGE_COLOR_BUTTON = new BackgroundImage(
            new Image("TicTacToe/Click.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    /**
     * Black button for change color mode.
     */
    public static final BackgroundImage DARK_BUTTON_ICON = new BackgroundImage(
            new Image("TicTacToe/ClickBlack.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /**
     * Size of the button.
     */
    private static final BackgroundSize BACKGROUND_SIZE = new BackgroundSize(300, 400, true, true, false, true);

    /**
     * Button on the second thread.
     */
    static final BackgroundImage END_GAME_BACKGROUND = new BackgroundImage(new Image("TicTacToe/green_button01.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BACKGROUND_SIZE);
    /**
     * Calc resize of the X when you change the grid dimension.
     * 
     * @return
     */
    private static int calcResizeX() {
        if (factor <= MIN_GRID_DIM - 1 || factor >= MAX_GRID_DIM + 1) {
            throw new IllegalArgumentException();
        }
        if (factor >= MIN_GRID_DIM && factor <= MAX_GRID_DIM) {
            return RESIZE_MULTIPLIER_X - (factor - 3) * 30;
        }
        return 0;
    }
    /**
     * Calc resize of the Y when you change the grid dimension.
     * 
     * @return
     */
    private static int calcResizeY() {
        if (factor >= MIN_GRID_DIM && factor <= MAX_GRID_DIM) {
            return resizeMultiplierY - (factor - 3) * 23;
        }
        return 0;
    }

}
