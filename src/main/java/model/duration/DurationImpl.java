package model.duration;

public class DurationImpl implements Duration {

    private final String duration;

    public DurationImpl(long milliseconds){
        int seconds = (int) milliseconds/1000;
        int minutes = seconds/60;
        int h = minutes/60;
        int m = minutes%60;
        int s = seconds%60;
        duration = String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
    }

    @Override
    public String getDuration() {
        return duration;
    }
}
