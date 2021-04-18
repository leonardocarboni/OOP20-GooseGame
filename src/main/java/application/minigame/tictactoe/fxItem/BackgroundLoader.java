package application.minigame.tictactoe.fxItem;

import application.minigame.tictactoe.mvc.GettersMVC;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BackgroundLoader {
    private final static GettersMVC getters = new GettersMVC();
    private final static int factor = getters.getSize();

    /* sfondo del bottone della griglia principale */
    public static final BackgroundImage gameButtonBackground = new BackgroundImage(
            new Image("TicTacToe/Sfondo.png", calcResizeX(), calcResizeY(), false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /* sfondo del bottone della griglia principale */
    public static final BackgroundImage gameButtonBackgroundBlack = new BackgroundImage(
            new Image("TicTacToe/SfondoBlack.png", calcResizeX(), calcResizeY(), false, false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /* bottone finale che dice chi ha vinto o no */
    public static final BackgroundImage endGameButtonBackground = new BackgroundImage(
            new Image("TicTacToe/Sfondo.png", 600, 480, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /* bottone finale che dice chi ha vinto o no */
    public static final BackgroundImage endGameButtonBackgroundBlack = new BackgroundImage(
            new Image("TicTacToe/SfondoBlack.png", 600, 480, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    public static final BackgroundImage darkButtonIcon = new BackgroundImage(
            new Image("TicTacToe/Click.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    public static final BackgroundImage darkButtonIconDark = new BackgroundImage(
            new Image("TicTacToe/ClickBlack.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    // private static final BackgroundSize darkButtonIconSize =
    // new BackgroundSize(10,10,false,false,true,true);
    static final BackgroundImage pauseMusic = new BackgroundImage(
            new Image("TicTacToe/Pause.png", 50, 40, false, false), BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    private static final BackgroundSize bs = new BackgroundSize(300, 400, true, true, false, true);
    /* sfondo della schermata finale del gioco */
    static final BackgroundImage endGameButton = new BackgroundImage(new Image("TicTacToe/green_button01.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);

    private static int calcResizeX() {
        if (factor <= 2 || factor >= 7) {
            throw new IllegalArgumentException();
        }
        if (factor >= 3 && factor <= 6) {
            return 200 - (factor - 3) * 30;
        }
        return 0;
    }

    private static int calcResizeY() {
        if (factor >= 3 && factor <= 6) {
            return 145 - (factor - 3) * 23;
        }
        return 0;
    }

}
