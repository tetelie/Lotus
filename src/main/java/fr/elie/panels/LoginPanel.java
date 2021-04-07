package fr.elie.panels;

import fr.elie.Lotus;
import fr.elie.components.button.ATexturedButton;
import fr.elie.event.AEvent;
import fr.elie.event.AEventListener;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel implements AEventListener {

    JTextField username = new JTextField("username");

    ATexturedButton close_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("close_button.png"));
    ATexturedButton reduce_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("reduce_button.png"));
    ATexturedButton connect_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("icon.png"));

    JLabel no_account = new JLabel("Create an account ?");

    public LoginPanel()
    {
        this.setLayout(null);
        username.setBounds(10, 10, 250, 50);
        //add(username);


        // close button
        close_button.setSize(54,54);
        close_button.setLocation(450-close_button.getWidth()-20,20);
        close_button.addEventListener(this);
        add(close_button);

        // reduce button
        reduce_button.setSize(54,54);
        reduce_button.setLocation(20, 20);
        reduce_button.addEventListener(this);
        add(reduce_button);

        // connect button
        connect_button.setSize(128,128);
        connect_button.setLocation(225-64, 380);
        connect_button.addEventListener(this);
        add(connect_button);

        // no account
        no_account.setLocation(0,500);
        no_account.setSize(450,50);
        no_account.setForeground(new Color(0,255,144));
        no_account.setHorizontalAlignment(SwingConstants.CENTER);
        no_account.setFont(new Font("Serif", Font.PLAIN, 20));
        add(no_account);

        setBackground(new Color(15, 15, 15));
    }

    public void onEvent(AEvent event)
    {
        if(event.getSource() == close_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            System.exit(0);
        }else if(event.getSource() == reduce_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            Lotus.get().loginFrame.setState(Frame.ICONIFIED);
        }else if(event.getSource() == connect_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            System.out.println("Connect!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
