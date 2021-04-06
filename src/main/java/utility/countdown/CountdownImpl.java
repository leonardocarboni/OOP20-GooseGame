package utility.countdown;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownImpl implements Countdown{

    private static final int DELAY = 0;
    private static final int PERIOD = 100; //every 0.1 seconds

    final private Timer timer;
    private double seconds;
    final private UpdateLabel updateLabelTask;
    final private Label timeLabel;

    public CountdownImpl(final int seconds, final Label timeLabel) {
        this.seconds = seconds;
        this.timeLabel = timeLabel;
        this.timer = new Timer();
        this.updateLabelTask = new UpdateLabel();
    }

    @Override
    public void start(){
        timer.schedule(updateLabelTask, DELAY, PERIOD);
    }

    @Override
    public void shutdown(){
        timer.cancel();
        timer.purge();
    }

    @Override
    public double getSecondsLeft(){
        return this.seconds;
    }

    /**
     * Utility class that extends TimerTask
     */
    private class UpdateLabel extends TimerTask {

        /**
         *  Updates the label with left seconds value (seconds.decimal)
         */
        @Override
        public void run() {
            Platform.runLater(() -> {
                if (seconds >= 0) {
                    timeLabel.setText(String.format("%.1f", seconds));
                    seconds = seconds - 0.1;
                } else {
                    shutdown();
                }
            });
        }
    }
}
