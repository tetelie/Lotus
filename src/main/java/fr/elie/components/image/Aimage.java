package fr.elie.components.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Aimage extends JComponent {

    public Image texture;

    public Aimage(BufferedImage texture)
    {
        this.texture = texture;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("PAINT!");
        g.drawImage(texture, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

}
