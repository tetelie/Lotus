package fr.elie;

import com.sun.media.jfxmedia.MediaPlayer;
import fr.elie.client.ClientSock;
import fr.elie.music.MusicPlayer;
import fr.elie.frames.Login;
import fr.elie.frames.Panel;
import fr.elie.util.FrameManager;
import fr.elie.util.ResourceManager;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        //musicPlayer.changeMusic("https://r3---sn-25glen7y.googlevideo.com/videoplayback?expire=1620449392&ei=EMSVYLDBBtukxN8PrrCn8Ag&ip=81.50.71.8&id=o-AK2NJKrERJZp5w9t2odhh11r4hvGBsBkB6A4Qp03gc1p&itag=18&source=youtube&requiressl=yes&mh=kn&mm=31%2C29&mn=sn-25glen7y%2Csn-25ge7ns7&ms=au%2Crdu&mv=m&mvi=3&pl=16&initcwndbps=740000&vprv=1&mime=video%2Fmp4&ns=oUPICK-gmC-yVbsk8A0S9-IF&gir=yes&clen=8384832&ratebypass=yes&dur=281.123&lmt=1575294498049084&mt=1620427493&fvip=3&fexp=24001373%2C24007246&c=WEB&txp=5531432&n=4EQiC1kn-XM6uenbEbb&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgO6vsfyBVYX93m3bdOwOhltwps8WzCMbacvm218xykPECIQDEudllRCzCCYgLtph0lEbj1UkNlHNU4UL3VWp24o17WQ%3D%3D&sig=AOq0QJ8wRQIhAOYZsIGw5eXndQmYTkEZwj0DxteTGFpuJKktfodCaY2wAiA4Jw81PzjCqy0tIZ-8Mu9mfTczd8E1VyhrYdtiZ0R1NQ==");
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



        /*String song = "https://r3---sn-25glen7y.googlevideo.com/videoplayback?expire=1620449392&ei=EMSVYLDBBtukxN8PrrCn8Ag&ip=81.50.71.8&id=o-AK2NJKrERJZp5w9t2odhh11r4hvGBsBkB6A4Qp03gc1p&itag=18&source=youtube&requiressl=yes&mh=kn&mm=31%2C29&mn=sn-25glen7y%2Csn-25ge7ns7&ms=au%2Crdu&mv=m&mvi=3&pl=16&initcwndbps=740000&vprv=1&mime=video%2Fmp4&ns=oUPICK-gmC-yVbsk8A0S9-IF&gir=yes&clen=8384832&ratebypass=yes&dur=281.123&lmt=1575294498049084&mt=1620427493&fvip=3&fexp=24001373%2C24007246&c=WEB&txp=5531432&n=4EQiC1kn-XM6uenbEbb&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgO6vsfyBVYX93m3bdOwOhltwps8WzCMbacvm218xykPECIQDEudllRCzCCYgLtph0lEbj1UkNlHNU4UL3VWp24o17WQ%3D%3D&sig=AOq0QJ8wRQIhAOYZsIGw5eXndQmYTkEZwj0DxteTGFpuJKktfodCaY2wAiA4Jw81PzjCqy0tIZ-8Mu9mfTczd8E1VyhrYdtiZ0R1NQ==";
        Player mp3player = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new URL(song).openStream());
            mp3player = new Player(in);
            mp3player.play();
        } catch (MalformedURLException ex) {
        } catch (IOException e) {
        } catch (JavaLayerException e) {
        } catch (NullPointerException ex) {
        }*/

        new Lotus();

        ClientSock client = new ClientSock("localhost", 9999);
        try {
            client.sendRequestToServer("download:0SBUkg_TzNo&list=PL8yjZlkv0uhmE8AYtKcz0otGfD3dv-HUA&index=1");
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
