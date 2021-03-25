package application.minigame.evenodd.fxItem;

import application.minigame.evenodd.mvc.GettersMVC;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BackgroundLoader {
    private final static GettersMVC getters = new GettersMVC();


    private static final BackgroundSize bs =
            new BackgroundSize(300,400,true,true,true,false);

    /* sfondo della schermata finale del gioco */
    static final BackgroundImage endGameButton =
            new BackgroundImage(new Image("evenodd/button.png"),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);


    public static final BackgroundImage button =
            new BackgroundImage(new Image("evenodd/background.png",600,480,false,false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    public static final BackgroundImage winner =
            new BackgroundImage(new Image("evenodd/winner.jpg"),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);


    public static final BackgroundImage loser =
            new BackgroundImage(new Image("evenodd/loserr.jpg"),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    public static final BackgroundImage animationGif =
            new BackgroundImage(new Image("evenodd/tenor.gif"),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bs);



    /* bottone finale che dice chi ha vinto o no */
    public static final BackgroundImage endGameButtonBackground =
            new BackgroundImage(new Image("TicTacToe/Sfondo.png",600,480,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    static final BackgroundImage pauseMusic =
            new BackgroundImage(new Image("TicTacToe/Pause.png",50,40,false,false),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);





}
