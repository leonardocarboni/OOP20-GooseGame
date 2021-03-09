package application.minigame.tictactoe.fxItem;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BackgroundLoader {

    /* sfondo del bottone della griglia principale */
    public static final BackgroundImage gameButtonBackground =
            new BackgroundImage(new Image("TicTacToe/Sfondo.png",200,170,false,false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /* sfondo del bottone della griglia principale */
    public static final BackgroundImage gameButtonBackgroundBlack =
            new BackgroundImage(new Image("TicTacToe/SfondoBlack.png",200,170,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    /* bottone finale che dice chi ha vinto o no */
    public static final BackgroundImage endGameButtonBackground =
            new BackgroundImage(new Image("TicTacToe/Sfondo.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    /* bottone finale che dice chi ha vinto o no */
    public static final BackgroundImage endGameButtonBackgroundBlack =
            new BackgroundImage(new Image("TicTacToe/SfondoBlack.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    private static final BackgroundSize bs =
            new BackgroundSize(300,400,true,true,false,true);

    /* sfondo della schermata finale del gioco */
    static final BackgroundImage endGameButton =
            new BackgroundImage(new Image("TicTacToe/green_button01.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);


    private static final BackgroundSize darkButtonIconSize =
            new BackgroundSize(15,10,false,false,true,true);

    public static final BackgroundImage darkButtonIcon =
            new BackgroundImage(new Image("TicTacToe/Click.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, darkButtonIconSize);

    public static final BackgroundImage darkButtonIconDark =
            new BackgroundImage(new Image("TicTacToe/ClickBlack.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, darkButtonIconSize);

    static final BackgroundImage bugReportIcon =
            new BackgroundImage(new Image("TicTacToe/Bug.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, darkButtonIconSize);

    static final BackgroundImage pauseMusic =
            new BackgroundImage(new Image("TicTacToe/Pause.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, darkButtonIconSize);



}
