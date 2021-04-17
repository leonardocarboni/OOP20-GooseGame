package application.minigame.memory;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

public class MemoryController implements MinigameController {

    private final static int SECONDS = 5;
    private final MemoryView view;
    private final SecretCode secretCode;
    private final Countdown countdown;

    public MemoryController() {
        view = new MemoryView();
        secretCode = new SecretCodeImpl();
        countdown = new CountdownImpl(SECONDS,);
        view.show();
    }

    @Override
    public int getResult() {
        return 0;
    }

    public void getCheckSeconds() {
        while (true) {
            if (countdown.getSecondsLeft() == 0) {
                view.hideSecretLabel();
            }
        }
    }


    /**
     * An inner class for the event catching in the minigame view.
     */
    public class SecretCodeCheckHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
        }
    }


}
