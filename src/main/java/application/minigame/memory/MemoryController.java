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

    private static final int SECONDS = 7;
    private static final String ASTERISKS = "*****";
    
    private final SecretCode secretCode;
    private final Countdown countdown;
    private List<Integer> inputCode;
    private int result;


    public MemoryController() {
    	final MemoryView view = new MemoryView();
        secretCode = new SecretCodeImpl();
        secretCode.generateSecretCode();
        inputCode = new ArrayList<>();
        view.showSecretLabel(secretCode.getCode());
        view.addButtonListener(new CheckHandler());
        view.addButtonNumber(new ButtonsHandler());
        countdown = new CountdownImpl(SECONDS, view.getTime());
        countdown.editLabelOnEnd(view.getSecretCodeLabel(), ASTERISKS);
        countdown.start();
        view.show();
    }

    @Override
    public int getResult() {
        return result;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class CheckHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            countdown.shutdown();
            double seconsLeft = countdown.getSecondsLeft();
            result = (int) seconsLeft - secretCode.checkCode(inputCode);
        }
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class ButtonsHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            final Button b = (Button) event.getSource();
            inputCode.add(Integer.parseInt(b.getText()));
        }
    }
}
