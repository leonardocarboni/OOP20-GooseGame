package application.minigame.tictactoe;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip = null;

    public Music() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("src/main/resources/TicTacToe/SoundOfficial.wav")));

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-25);
    }

    public void startMusic(){
        clip.start();
    }

    public void stopMusic(){
        clip.stop();
    }

    public Clip getMusic(){
        return clip;
    }

}
