package fr.elie.components.button;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ATexturedButton extends AButton {

    public Image texture;
    public Image texture_hover;

    public ATexturedButton(BufferedImage texture)
    {
        this(texture, null);
    }

    public ATexturedButton(BufferedImage texture, BufferedImage texture_hover)
    {
        this.texture = texture;
        this.texture_hover = texture_hover;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.hover == true && texture_hover != null) {
            g.drawImage(texture_hover, 0, 0, this.getWidth(), this.getHeight(), this);
        }else{
            g.drawImage(texture, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    public Image getTexture_hover() {
        return texture_hover;
    }

    public void setTexture_hover(Image texture_hover) {
        this.texture_hover = texture_hover;
    }
}
