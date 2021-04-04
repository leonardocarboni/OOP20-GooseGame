package application.minigame.cableconnect;

import controller.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

import java.util.Arrays;
import java.util.Set;

public class CableConnectController implements MinigameController {

    private static final int SECONDS = 9;
    static final private int CABLES = 4;
    private final CableConnectView view;
    private final Countdown countdown;
    private int secondsLeft;

    private Colors[] startColorsArray;
    private Colors[] endColorsArray;
    private Set<Colors> colorsDone;

    public CableConnectController(){
        view = new CableConnectView();

        startColorsArray = Colors.getRandomColors();
        endColorsArray = Colors.getRandomColors();

        view.initializeButtonsMap(startColorsArray, endColorsArray);
        view.initializeStartButtons();
        view.initializeEndButtons();

        view.initializeEventHandlers();
        view.addButtonListener(new LastCableConnectedHandler());

        countdown = new CountdownImpl(SECONDS, view.getTimeLabel());
        countdown.start();

        view.show();
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class LastCableConnectedHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            double remainingSeconds = countdown.getSecondsLeft();
            colorsDone = view.getColorsDone();
            if (colorsDone.size() == CABLES){
                secondsLeft = (int) remainingSeconds;
                countdown.shutdown();
            }
        }
    }

    @Override
    public int getResult(){
        return secondsLeft;
    }

}
