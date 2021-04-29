package fr.elie;

import fr.elie.components.music.MusicPlayer;
import fr.elie.frames.Login;
import fr.elie.frames.Panel;
import fr.elie.util.FrameManager;
import fr.elie.util.ResourceManager;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public class Lotus {

    public JFrame loginFrame;
    public JFrame panelFrame;

    public ResourceManager resourceManager;

    public FrameManager frameManager;

    static Lotus instance;

    public Color green = new Color(2,255,146);
    public Color pink = new Color(180,2,255);

    public MusicPlayer musicPlayer;

    public Lotus()
    {
        instance = this;

        // setup resource manager
        resourceManager = new ResourceManager();
        resourceManager.setResourceDir("/");

        // setup frame manager
        frameManager = new FrameManager();

        // setup music player
        musicPlayer = new MusicPlayer();
        musicPlayer.changeMusic("C:/Users/elied/Desktop/Developpement/project/Lotus/src/main/resources/6058-come-with-me-now-feat-austin-mensales.mp3");
        //musicPlayer.setTimeSeconds(60);

        // setup frames
        loginFrame = new Login();
        panelFrame = new Panel();
    }

    public static Lotus get()
    {
        return instance;
    }

    public static void main(String[] args)
    {
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new JFXPanel(); // initializes JavaFX environment
                    latch.countDown();
                }
            });
            latch.await();
        }catch (InterruptedException e) {}



        new Lotus();
    }

}
