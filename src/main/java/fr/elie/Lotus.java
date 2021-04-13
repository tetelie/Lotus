package fr.elie;

import fr.elie.frames.Login;
import fr.elie.frames.Panel;
import fr.elie.util.FrameManager;
import fr.elie.util.ResourceManager;

import javax.swing.*;

public class Lotus {

    public JFrame loginFrame;
    public JFrame panelFrame;

    public ResourceManager resourceManager;

    public FrameManager frameManager;

    static Lotus instance;

    public Lotus()
    {
        instance = this;

        // setup resource manager
        resourceManager = new ResourceManager();
        resourceManager.setResourceDir("/");

        // setup frame manager
        frameManager = new FrameManager();

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
        new Lotus();
    }

}
