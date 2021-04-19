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
import java.util.Arrays;
import java.util.List;

public class MainPanel extends JPanel implements AEventListener {

    boolean clean = false;

    ATexturedButton close_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("close_button.png"), Lotus.get().resourceManager.getBufferedImage("close_button_hover.png"));
    ATexturedButton reduce_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("reduce_button.png"), Lotus.get().resourceManager.getBufferedImage("reduce_button_hover.png"));
    Aimage search_bar = new Aimage(Lotus.get().resourceManager.getBufferedImage("search_bar.png"));
    JTextField search_box = new JTextField("rechercher...");
    ATexturedButton home_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("icon.png"));

    // left menu
    ATexturedButton item_account = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("item_account.png"),Lotus.get().resourceManager.getBufferedImage("item_account_clicked.png"));
    ATexturedButton item_library = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("item_library.png"),Lotus.get().resourceManager.getBufferedImage("item_library_clicked.png"));
    private boolean menu = false;
    List<ATexturedButton> MenuComponentList = Arrays.asList(item_account, item_library);

    // play menu
    ATexturedButton play_pause_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("play_button.png"));
    ATexturedButton left_skip_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("left_skip_button.png"));
    ATexturedButton right_skip_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("right_skip_button.png"));
    boolean playing = false; // temporary
    JLabel music_title = new JLabel();

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
        home_button.addEventListener(this);
        add(home_button);

        // left menu
        item_account.setBounds(0, 61, 250, 45);
        item_account.setVisible(false);
        add(item_account);

        item_library.setBounds(0, 121, 250, 45);
        item_library.setVisible(false);
        add(item_library);


        // play menu
        play_pause_button.setBounds(500-25,550,40,40);
        play_pause_button.addEventListener(this);
        add(play_pause_button);

        left_skip_button.setBounds(500-25-40-20,550,40,40);
        left_skip_button.addEventListener(this);
        add(left_skip_button);

        right_skip_button.setBounds(500-25+40+20,550,40,40);
        right_skip_button.addEventListener(this);
        add(right_skip_button);

        music_title.setText(Lotus.get().musicPlayer.getCurrentTitle());
        music_title.setBounds(0, 509,999,30);
        music_title.setForeground(Lotus.get().pink);
        music_title.setHorizontalAlignment(SwingConstants.CENTER);
        music_title.setFont(new Font("Serif", Font.PLAIN, 20));
        add(music_title);
    }

    public void onEvent(AEvent event) {
        if(event.getSource() == close_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            System.exit(0);
        }else if(event.getSource() == reduce_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            Lotus.get().panelFrame.setState(Frame.ICONIFIED);
        }else if(event.getSource() == home_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            menu = menu ? false: true;
            unwindMenu(menu);
            repaint();
            System.out.println("menu: " + menu);
        } else if(event.getSource() == play_pause_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            playing = playing ? false : true;
            System.out.println("test");
            if(playing)
            {
                play_pause_button.setTexture(Lotus.get().resourceManager.getBufferedImage("pause_button.png"));
                Lotus.get().musicPlayer.changeMusic("6058-come-with-me-now-feat-austin-mensales.mp3");
                Lotus.get().musicPlayer.changeTitle("6058-come-with-me-now-feat-austin-mensales.mp3", music_title);
                //Lotus.get().musicPlayer.updateTitle(music_title);
                Lotus.get().musicPlayer.play();
            }else{
                Lotus.get().musicPlayer.pause();
                play_pause_button.setTexture(Lotus.get().resourceManager.getBufferedImage("play_button.png"));
            }
            repaint();
        }else if(event.getSource() == left_skip_button && event.getType() == AEvent.AEventList.ON_BUTTON_CLICKED)
        {
            Lotus.get().musicPlayer.changeTitle("Linkin Park - In The End (Mellen Gi & Tommee Profitt Remix)", music_title);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // left menu start
        if(menu)
        {
            g.setColor(Lotus.get().pink);
            g.drawRect(0, 60, 250, 539-60-30);
        }
        // left menu end

        // top menu start
        g.setColor(Lotus.get().green);
        g.drawRect(0,0,999,60);
        // top menu end

        // search bar
        g.drawImage(search_bar.texture, 550, 10, 300, 40, this);

        // music title bar start
        g.setColor(Lotus.get().pink);
        g.drawRect(0,539-30,999,30);
        // music title bar end


        // bottom menu start
        g.setColor(Lotus.get().green);
        g.drawRect(0,539,999,60);
        // bottom menu end
    }

    private void unwindMenu(boolean visible)
    {
        MenuComponentList.forEach(aTexturedButton -> aTexturedButton.setVisible(visible));
    }

}
