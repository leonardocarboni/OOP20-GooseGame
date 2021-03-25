package utility.countdown;

public interface Countdown {

    /**
     * Starts timer
     */
    void start();

    /**
     * Force kills timer's thread
     */
    void shutdown();

    /**
     * Returns seconds left
     * @return seconds left
     */
    int getSecondsLeft();
}
