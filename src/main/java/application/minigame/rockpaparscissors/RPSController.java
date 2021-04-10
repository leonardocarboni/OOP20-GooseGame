package application.minigame.rockpaparscissors;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

public class RPSController implements MinigameController {


    private final RPSView view;

    public RPSController(){
        view = new RPSView();
        view.show();
    }

    @Override
    public int getResult() {
        return 0;
    }

}
