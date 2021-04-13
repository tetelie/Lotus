package fr.elie.util;

import fr.elie.listener.MoveMouseListener;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URL;

public class FrameManager {

    private JFrame currentFrame = null;

    public FrameManager()
    {

    }

    public void switchFrame(JFrame jframe)
    {
        if(currentFrame != null)
        {
            currentFrame.setVisible(false);
        }
        currentFrame = jframe;
        jframe.setVisible(true);
    }

    public void addMouseMover(JFrame jframe, JComponent jComponent)
    {
        MoveMouseListener moveMouseListener = new MoveMouseListener(jComponent);
        jframe.addMouseListener(moveMouseListener);
        jframe.addMouseMotionListener(moveMouseListener);
    }

    public void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
