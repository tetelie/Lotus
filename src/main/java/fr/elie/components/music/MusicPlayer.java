package fr.elie.components.music;

import fr.elie.Lotus;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
        String fileName_path=new File(fileName).toURI().toString();
        media = new Media(fileName_path);
        mediaPlayer = new MediaPlayer(media);
        setTitle(fileName_path.replaceAll(".mp3", ""));
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

    public boolean isPlaying()
    {
        return mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
    }

    public void setTimeSeconds(double time)
    {
        mediaPlayer.setStartTime(Duration.seconds(time));
    }

    public double getTimeSeconds()
    {
        return mediaPlayer.getCurrentTime().toSeconds();
    }

    public Duration getTime()
    {
        return mediaPlayer.getCurrentTime();
    }

    public double getCurrentMusicDuration()
    {
        return media.getDuration().toSeconds();
    }

    public String getCurrentTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String formatDuration() {
        int sec = (int)getTimeSeconds();
        Date d = new Date(sec * 1000L);
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String time = df.format(d);
        return time;
    }


    public String formatDuration(int sec) {
        Date d = new Date(sec * 1000L);
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String time = df.format(d);
        return time;
    }

}
