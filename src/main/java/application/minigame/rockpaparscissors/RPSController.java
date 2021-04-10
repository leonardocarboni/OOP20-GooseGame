package application.minigame.rockpaparscissors;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

public class RPSController implements MinigameController {


    private static final int SECONDS = 9;
    private final RPSView view;
    //private final Countdown countdown;

    public RPSController(){
        view = new RPSView();

        //countdown = new CountdownImpl(SECONDS,view.getTime());
        //countdown.start();

        view.show();
    }

    @Override
    public int getResult() {
        return 0;
    }


    public class RPSHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {



        }
    }
}
