package fr.elie.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ComponentMover implements MouseListener, MouseMotionListener {

    JComponent target;
    Point start_drag;
    Point start_loc;

    private boolean restrictX = false;
    private boolean restrictY = false;
    private double x_Min;
    private double x_Max;
    private double y_Min;
    private double y_Max;

    public ComponentMover(JComponent target) {
        this.target = target;
    }

    Point getScreenLocation(MouseEvent e) {
        Point cursor = e.getPoint();
        Point target_location = this.target.getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()),
                (int) (target_location.getY() + cursor.getY()));
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        this.start_drag = this.getScreenLocation(e);
        this.start_loc = target.getLocation();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        Point current = this.getScreenLocation(e);
        Point offset = new Point((int) current.getX() - (int) start_drag.getX(),
                (int) current.getY() - (int) start_drag.getY());
        Point new_location = new Point(
                (int) (this.start_loc.getX() + offset.getX()), (int) (this.start_loc
                .getY() + offset.getY()));

        if(restrictX)
        {
            if(new_location.getX() > x_Max)
            {
                new_location.setLocation(x_Max, new_location.getY());
            }
            if(new_location.getX() < x_Min)
            {
                new_location.setLocation(x_Min, new_location.getY());
            }
        }

        if(restrictY)
        {
            if(new_location.getY() > y_Max)
            {
                new_location.setLocation(new_location.getX(), y_Max);
            }
            if(new_location.getY() < y_Min)
            {
                new_location.setLocation(new_location.getX(), y_Min);
            }
        }

        target.setLocation(new_location);
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void addRestrictX(double min, double max)
    {
        x_Min = min;
        x_Max = max;
        restrictX = true;
    }

    public void addRestrictY(double min, double max)
    {
        y_Min = min;
        y_Max = max;
        restrictY = true;
    }
}