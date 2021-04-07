package fr.elie;

import fr.elie.frames.Login;
import fr.elie.util.ResourceManager;

import javax.swing.*;

public class Lotus {

    public JFrame loginFrame;

    public ResourceManager resourceManager;

    static Lotus instance;

    public Lotus()
    {
        instance = this;

        // setup resource manager
        resourceManager = new ResourceManager();
        resourceManager.setResourceDir("/");

        // setup frames
        loginFrame = new Login();
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
