package fr.elie.components.label;

import java.awt.*;

public class ACustomLabel extends ALabel {

    public ACustomLabel(String texte)
    {
        this.texte = texte;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(texte,0,0);
        g.drawRect(0,0, this.getWidth(), this.getHeight());
    }
}
