package fr.elie.panels;

import fr.elie.Lotus;
import fr.elie.components.button.ATexturedButton;
import fr.elie.components.image.Aimage;
import fr.elie.event.AEvent;
import fr.elie.event.AEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel implements AEventListener {

    boolean clean = false;

    ATexturedButton close_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("close_button.png"), Lotus.get().resourceManager.getBufferedImage("close_button_hover.png"));
    ATexturedButton reduce_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("reduce_button.png"), Lotus.get().resourceManager.getBufferedImage("reduce_button_hover.png"));
    Aimage search_bar = new Aimage(Lotus.get().resourceManager.getBufferedImage("search_bar.png"));
    JTextField search_box = new JTextField("rechercher...");
    ATexturedButton home_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("icon.png"));

    public MainPanel()
    {
        setLayout(null);
        setBackground(new Color(15, 15, 15));

        // close button
        close_button.setSize(40,40);
        close_button.setLocation(1000-close_button.getWidth()-30,10);
        close_button.addEventListener(this);
        add(close_button);

        // reduce button
        reduce_button.setSize(40,40);
        reduce_button.setLocation(1000-reduce_button.getWidth()*2-40, 10);
        reduce_button.addEventListener(this);
        add(reduce_button);

        // search text box
        search_box.setSize(300-45,40);
        search_box.setLocation(550+45,10);
        search_box.setOpaque(false);
        search_box.setFont(new Font("Serif", Font.PLAIN, 20));
        search_box.setForeground(Color.DARK_GRAY);
        search_box.setBorder(null);
        search_box.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(!clean)
                {
                    search_box.setText("");
                    clean = true;
                }
            }
        });
        search_box.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!clean)
                {
                    search_box.setText("");
                    clean = true;
                }
            }
        });
        add(search_box);

        // home button
        home_button.setSize(64,64);
        home_button.setLocation(30,0);
        add(home_button);
    }

    public void onEvent(AEvent event) {
        if(event.getSource() == close_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0,0,1000,60);
        g.drawImage(search_bar.texture, 550, 10, 300, 40, this);
    }

}
