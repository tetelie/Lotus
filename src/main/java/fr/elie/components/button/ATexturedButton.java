package fr.elie.components.button;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ATexturedButton extends AButton {

    public Image texture;

    public ATexturedButton(BufferedImage texture)
    {
        this.texture = texture;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(texture, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
