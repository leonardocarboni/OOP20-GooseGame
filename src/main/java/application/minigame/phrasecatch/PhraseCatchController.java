package application.minigame.phrasecatch;

import controller.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import utility.countdown.Countdown;
import utility.countdown.CountdownImpl;

public class PhraseCatchController implements MinigameController {

    private static final int SECONDS = 10;
    private final PhraseCatchView view;
    private final PhraseImpl phraseImpl;
    private final Countdown countdown;
    private int secondsLeft;
    private int errors;

    public PhraseCatchController(){
        view = new PhraseCatchView();
        phraseImpl = new PhraseImpl();

        view.addButtonListener(new PhraseSubmitHandler());

        String sentence = phraseImpl.generatePhrase();
        view.setPhrase(sentence);

        countdown = new CountdownImpl(SECONDS, view.getTimeLabel());
        countdown.start();

        view.show();
    }

    @Override
    public int getResult(){
        return secondsLeft - errors;
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class PhraseSubmitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            double remainingTime = countdown.getSecondsLeft();
            countdown.shutdown();
            String textRead = view.getInputText();
            int errorsMade = phraseImpl.checkText(textRead);
            if (remainingTime == 0.0){
                secondsLeft = -6;
                errors = 0;
            } else {
                secondsLeft = (int) remainingTime;
                errors = errorsMade;
            }
        }
    }
}
