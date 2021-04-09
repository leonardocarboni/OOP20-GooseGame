package utility.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music extends Thread{

    private Clip clip = null;
    private AudioInputStream audioStream = null;
    File file = new File("src/main/resources/soundtrack/B.wav");

    public void run(){
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.start();
    }

    public void stopMusic(){
        this.clip.stop();
    }

    public Clip getClip(){
        return this.clip;
    }

}