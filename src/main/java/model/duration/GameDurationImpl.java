package model.duration;

public class GameDurationImpl implements GameDuration {

    private static final int DIVIDER_SECONDS_MINUTES = 60;
    private static final int DIVIDER_MILLIS = 1000;

    private final String duration;

    public GameDurationImpl(final long milliseconds) {
        final int seconds = (int) milliseconds / DIVIDER_MILLIS;
        final int minutes = seconds / DIVIDER_SECONDS_MINUTES;
        final int h = minutes / DIVIDER_SECONDS_MINUTES;
        final int m = minutes % DIVIDER_SECONDS_MINUTES;
        final int s = seconds % DIVIDER_SECONDS_MINUTES;
        duration = String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
    }

    @Override
    public String getDuration() {
        return duration;
    }
}
