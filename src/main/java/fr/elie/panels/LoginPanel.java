package fr.elie.panels;

import fr.elie.Lotus;
import fr.elie.components.button.ATexturedButton;
import fr.elie.event.AEvent;
import fr.elie.event.AEventListener;
import fr.elie.listener.MoveMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel implements AEventListener {

    JTextField username = new JTextField("username");

    ATexturedButton close_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("close_button.png"), Lotus.get().resourceManager.getBufferedImage("close_button_hover.png"));
    ATexturedButton reduce_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("reduce_button.png"), Lotus.get().resourceManager.getBufferedImage("reduce_button_hover.png"));
    ATexturedButton connect_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("icon.png"));

    JLabel no_account = new JLabel("Create an account ?");

    JTextField id = new JTextField("username");
    JPasswordField pwd = new JPasswordField();

    boolean clean = false;

    public LoginPanel()
    {
        this.setLayout(null);

        username.setBounds(10, 10, 250, 50);
        //add(username);

        // close button
        close_button.setSize(54,54);
        close_button.setLocation(360-close_button.getWidth()-20,20);
        close_button.addEventListener(this);
        add(close_button);

        // reduce button
        reduce_button.setSize(54,54);
        reduce_button.setLocation(20, 20);
        reduce_button.addEventListener(this);
        add(reduce_button);

        // connect button
        connect_button.setSize(128,128);
        connect_button.setLocation(115, 300);
        connect_button.addEventListener(this);
        add(connect_button);

        // no account
        no_account.setLocation(0,410);
        no_account.setSize(360,50);
        no_account.setForeground(new Color(0,255,144));
        no_account.setHorizontalAlignment(SwingConstants.CENTER);
        no_account.setFont(new Font("Serif", Font.PLAIN, 20));
        no_account.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                Lotus.get().frameManager.openWebpage("http://localhost");
            }
        });
        add(no_account);


        id.setBounds(55,130,250,50);
        id.setOpaque(false);
        //id.setBorder(null);
        id.setFont(new Font("Serif", Font.PLAIN, 50));
        id.setForeground(Color.MAGENTA);
        id.setHorizontalAlignment(SwingConstants.CENTER);
        id.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(!clean) {
                    id.setText("");
                    clean = true;
                }
            }
        });
        id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!clean)
                {
                    id.setText("");
                    clean = true;
                }
            }
        });
        add(id);

        pwd.setBounds(55,230,250,50);
        pwd.setOpaque(false);
        pwd.setFont(new Font("Serif", Font.PLAIN, 50));
        pwd.setForeground(new Color(0,255,144));
        pwd.setHorizontalAlignment(SwingConstants.CENTER);
        add(pwd);

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
            // TODO connect system with server
            if(id.getText().equals("tetelie") || id.getText().equals("username"))
            {
                Lotus.get().frameManager.switchFrame(Lotus.get().panelFrame);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
