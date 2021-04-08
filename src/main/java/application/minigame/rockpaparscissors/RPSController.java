package application.minigame.rockpaparscissors;

import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

public class RPSController {

    private static final int SECONDS = 9;
    private final RPSView view;
    //private final Countdown countdown;

    public RPSController(){
        view = new RPSView();

        //countdown = new CountdownImpl(SECONDS,);
        //countdown.start();

        view.show();
    }

}
