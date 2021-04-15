package application.minigame.phrasecatch;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

public class PhraseCatchController implements MinigameController {

    private static final int SECONDS = 10;
    private final PhraseCatchView view;
    private final Phrase phrase;
    private final Countdown countdown;
    private int secondsLeft;
    private int errors;

    private static final int MAX_ERRORS = 6;

    public PhraseCatchController() {
        view = new PhraseCatchView();
        phrase = new PhraseImpl();

        view.addButtonListener(new PhraseSubmitHandler());

        final String sentence = phrase.generatePhrase();
        view.setPhrase(sentence);

        countdown = new CountdownImpl(SECONDS, view.getTimeLabel());
        countdown.start();

        view.showAndWait();
    }

    @Override
    public int getResult() {
        return secondsLeft - errors;
    }

    /**
     * An inner class for the event catching in the minigame view.
     */
    public class PhraseSubmitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            final double remainingTime = countdown.getSecondsLeft();
            countdown.shutdown();
            final String textRead = view.getInputText();
            final int errorsMade = phrase.checkText(textRead);
            if (remainingTime == 0.0 || errorsMade >= MAX_ERRORS) {
                secondsLeft = -MAX_ERRORS;
                errors = 0;
            } else {
                secondsLeft = (int) remainingTime;
                errors = errorsMade;
            }
        }
    }
}
