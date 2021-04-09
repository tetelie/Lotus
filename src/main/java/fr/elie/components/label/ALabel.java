package fr.elie.components.label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ALabel extends JComponent implements MouseListener {

    public enum Alignement
    {
        NONE,
        HORIZONTAL_CENTER,
        VERTICAL_CENTER
    }

    public String texte;
    public Color color;
    public Alignement alignement = Alignement.NONE;

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
