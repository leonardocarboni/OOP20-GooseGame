package utility.countdown;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public interface Countdown {

    /**
     * Starts timer.
     */
    void start();

    /**
     * Force kills timer's thread.
     */
    void shutdown();

    /**
     * Returns seconds left.
     * @return seconds left
     */
    double getSecondsLeft();

    /**
     * Hides a label when the countdown ends.
     * @param labelToEdit - the label to edit
     * @param text - the text that the label needs to be changed to
     */
    void editLabelOnEnd(Label labelToEdit, String text);

    /**
     * Enables the quit button when the timer ends even if the player didn't finish the game.
     * @param quitButton
     */
    void enableQuitButtonOnEnd(Button quitButton);
}
