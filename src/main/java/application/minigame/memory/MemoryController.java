package application.minigame.memory;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

import java.util.ArrayList;
import java.util.List;

public class MemoryController implements MinigameController {

    private final static int SECONDS = 10;
    private final MemoryView view;
    private final SecretCode secretCode;
    private final Countdown countdown;
    private List<Integer> inputCode;
    private int result;


    public MemoryController() {
        view = new MemoryView();
        secretCode = new SecretCodeImpl();
        secretCode.generateSecretCode();
        inputCode = new ArrayList<>();
        countdown = new CountdownImpl(SECONDS, view.getTime());
        countdown.start();
        view.showSecretLabel(secretCode.getCode());
        view.show();
    }

    @Override
    public int getResult() {
        return result;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class checkHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(final ActionEvent event) {
            result = (int)countdown.getSecondsLeft();
            countdown.shutdown();
            result -= secretCode.checkCode(inputCode);
        }
    }

    public class buttonsHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(final ActionEvent event) {
            Button b = (Button) event.getSource();
            inputCode.add(Integer.parseInt(b.getText()));
        }
    }

}
