package fr.elie.components.music;

import fr.elie.Lotus;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.io.File;

public class MusicPlayer {

    private String title;

    private Media media;
    private MediaPlayer mediaPlayer;

    public MusicPlayer()
    {
        title="No music currently playing...";
    }



    public void changeMusic(String fileName)
    {
        fileName=new File("C:/Users/elied/Desktop/Developpement/project/Lotus/src/main/resources/6058-come-with-me-now-feat-austin-mensales.mp3").toURI().toString();
        media = new Media(fileName);
        mediaPlayer = new MediaPlayer(media);
        setTitle(fileName.replaceAll(".mp3", ""));
    }

    public void changeTitle(String title, JLabel label)
    {
        this.title = title;
        label.setText(title);
    }

    public void updateTitle(JLabel label)
    {
        label.setText(this.title);
    }

    public boolean play()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.play();
            return true;
        }
        return false;
    }

    public boolean pause()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.pause();
            return true;
        }
        return false;
    }


    public String getCurrentTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
