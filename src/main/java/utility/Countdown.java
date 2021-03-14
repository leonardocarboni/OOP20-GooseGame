package utility;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

    Timer timer;
    int seconds;
    boolean running = true;
    UpdateLabel updateLabelTask;
    Label timeLabel;

    public Countdown(int seconds, Label timeLabel) {
        this.seconds = seconds*10;
        this.timeLabel = timeLabel;
        timer = new Timer();
        updateLabelTask = new UpdateLabel();
    }

    /**
     * Starts timer
     */
    public void start(){
        timer.schedule(updateLabelTask, 0, 100);
    }

    /**
     * Force kills timer's thread
     */
    public void shutdown(){
        timer.cancel();
        timer.purge();
        this.running = false;
    }

    /**
     * Returns seconds left
     * @return seconds left
     */
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
