package fr.elie.frames;

import fr.elie.Lotus;
import fr.elie.panels.LoginPanel;

import javax.swing.*;

public class Login extends JFrame {


    public Login()
    {
        setTitle("Lotus");
        setIconImage(Lotus.get().resourceManager.getBufferedImage("icon.png"));
        setSize(720,480);
        setUndecorated(true);
        JPanel jPanel = new LoginPanel();
        setContentPane(jPanel);
        Lotus.get().frameManager.addMouseMover(this, jPanel);
        setLocationRelativeTo(null);
        Lotus.get().frameManager.switchFrame(this);
    }

}
