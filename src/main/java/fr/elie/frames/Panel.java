package fr.elie.frames;

import fr.elie.Lotus;
import fr.elie.panels.MainPanel;

import javax.swing.*;

public class Panel extends JFrame {

    public Panel()
    {
        setSize(1280, 720);
        setUndecorated(true);
        setLocationRelativeTo(null);
        JPanel panel = new MainPanel();
        setContentPane(panel);
        setTitle("Lotus");
        setIconImage(Lotus.get().resourceManager.getBufferedImage("icon.png"));
        Lotus.get().frameManager.addMouseMover(this, panel);
    }

}
