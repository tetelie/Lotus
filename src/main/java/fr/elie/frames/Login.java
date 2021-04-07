package fr.elie.frames;

import fr.elie.Lotus;
import fr.elie.panels.LoginPanel;

import javax.swing.*;

public class Login extends JFrame {

    public Login()
    {
        setTitle("Lotus");
        setIconImage(Lotus.get().resourceManager.getBufferedImage("icon.png"));
        setSize(450,600);
        setUndecorated(true);
        setContentPane(new LoginPanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
