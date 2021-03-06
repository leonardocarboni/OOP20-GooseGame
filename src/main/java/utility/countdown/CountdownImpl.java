package utility.countdown;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownImpl implements Countdown {

    private static final int DELAY = 0;
    private static final int PERIOD = 100; //every 0.1 seconds
    private static final double SEC_DECREASE = 0.1;

    private final Timer timer;
    private double seconds;
    private final UpdateLabel updateLabelTask;
    private final Label timeLabel;
    private Optional<Label> labelToHide;
    private String labelText;
    private Optional<Button> quitButton;

    public CountdownImpl(final int seconds, final Label timeLabel) {
        this.seconds = seconds;
        this.timeLabel = timeLabel;
        this.timer = new Timer();
        this.updateLabelTask = new UpdateLabel();
        this.labelToHide = Optional.empty();
        this.quitButton = Optional.empty();
    }

    @Override
    public void start() {
        timer.schedule(updateLabelTask, DELAY, PERIOD);
    }

    @Override
    public void shutdown() {
        timer.cancel();
        timer.purge();
    }

    @Override
    public double getSecondsLeft() {
        return this.seconds;
    }

    @Override
    public void editLabelOnEnd(final Label labelToEdit, final String text) {
        this.labelToHide = Optional.of(labelToEdit);
        this.labelText = text;
    }

    @Override
    public void enableQuitButtonOnEnd(final Button quitButton) {
        this.quitButton = Optional.of(quitButton);
    }

    /**
     * Utility class that extends TimerTask.
     */
    private class UpdateLabel extends TimerTask {

        /**
         *  Updates the label with left seconds value (seconds.decimal).
         */
        @Override
        public void run() {
            Platform.runLater(() -> {
                if (seconds >= 0) {
                    timeLabel.setText(String.format("%.1f", seconds));
                    seconds = seconds - SEC_DECREASE;
                } else {
                    shutdown();
                    if (labelToHide.isPresent()) {
                        labelToHide.get().setText(labelText);
                    }
                    if (quitButton.isPresent()) {
                        quitButton.get().setDisable(false);
                    }
                }
            });
        }
    }
}
