package fr.elie.components.button;

import fr.elie.event.AEvent;
import fr.elie.event.AEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AButton extends JComponent implements MouseListener {

    private ArrayList<AEventListener> eventListeners = new ArrayList<AEventListener>();

    private String text;
    private Color textColor;
    public boolean hover = false;

    public AButton()
    {
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        if(this.isEnabled())
            for(AEventListener eventListener : this.eventListeners)
                eventListener.onEvent(new AEvent(this, AEvent.AEventList.ON_BUTTON_CLICKED));
    }

    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        System.out.println("hover");
        hover = true;
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        hover = false;
        repaint();

    }

    public void addEventListener(AEventListener eventListener) {
       this.eventListeners.add(eventListener);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        repaint();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
