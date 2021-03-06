package controller.cableconnect;

import model.cablecolor.CableColor;
import view.cableconnect.CableConnectView;
import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

import java.util.Set;

public class CableConnectController implements MinigameController {

    private static final int SECONDS = 9;
    private static final int CABLES = 4;
    private final CableConnectView view;
    private final Countdown countdown;
    private int secondsLeft;

    private Set<CableColor> colorsDone;

    public CableConnectController() {
        view = new CableConnectView();

        final CableColor[] startColorsArray;
        final CableColor[] endColorsArray;

        startColorsArray = CableColor.getRandomColors();
        endColorsArray = CableColor.getRandomColors();

        view.initializeButtonsMap(startColorsArray, endColorsArray);
        view.initializeStartButtons();
        view.initializeEndButtons();

        view.initializeEventHandlers();
        view.addButtonListener(new LastCableConnectedHandler());

        countdown = new CountdownImpl(SECONDS, view.getTimeLabel());
        countdown.enableQuitButtonOnEnd(view.getQuitButton());
        countdown.start();

        view.showAndWaitResult();
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class LastCableConnectedHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            final double remainingSeconds = countdown.getSecondsLeft();
            colorsDone = view.getColorsDone();
            if (colorsDone.size() == CABLES) {
                secondsLeft = (int) remainingSeconds;
                countdown.shutdown();
                view.enableQuitButton();
            }
        }
    }

    @Override
    public int getResult() {
        return secondsLeft;
    }

}
