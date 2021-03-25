package utility.countdown;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownImpl implements Countdown{

    final private Timer timer;
    private int seconds;
    final private UpdateLabel updateLabelTask;
    final private Label timeLabel;

    public CountdownImpl(final int seconds, final Label timeLabel) {
        this.seconds = seconds*10;
        this.timeLabel = timeLabel;
        this.timer = new Timer();
        this.updateLabelTask = new UpdateLabel();
    }

    @Override
    public void start(){
        timer.schedule(updateLabelTask, 0, 100);
    }

    @Override
    public void shutdown(){
        timer.cancel();
        timer.purge();
    }

    @Override
    public int getSecondsLeft(){
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
                    timeLabel.setText(seconds/10 + "." + seconds%10);
                    seconds--;
                } else {
                    shutdown();
                }
            });
        }
    }
}
