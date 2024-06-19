package SoundEffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    Clip clip;
    File[] files = new File[3];

    public Sound() {
        files[0] = new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\sound\\ButtonOver.wav");
        files[1] = new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\sound\\SnakeDie.wav");
        files[2] = new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\sound\\SnakeEat.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(files[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
