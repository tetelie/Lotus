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

    // top menu
    ATexturedButton close_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("close_button.png"), Lotus.get().resourceManager.getBufferedImage("close_button_hover.png"));
    ATexturedButton reduce_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("reduce_button.png"), Lotus.get().resourceManager.getBufferedImage("reduce_button_hover.png"));
    Aimage search_bar = new Aimage(Lotus.get().resourceManager.getBufferedImage("search_bar.png"));
    JTextField search_box = new JTextField("rechercher...");
    ATexturedButton home_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("icon.png"));
    ATexturedButton next_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("next_button.png"));
    ATexturedButton previous_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("previous_button.png"));

    // left menu
    ATexturedButton item_account = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("test/profile_button.png"));
    ATexturedButton item_option = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("option_button.png"));
    ATexturedButton item_home = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("home_button.png"));
    ATexturedButton item_library = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("library_button.png"));
    ATexturedButton item_radio = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("radio_button.png"));
    private boolean menu = true;
    List<ATexturedButton> MenuComponentList = Arrays.asList(item_account, item_option, item_home, item_library, item_radio);

    // play menu
    ATexturedButton play_pause_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("play_button.png"));
    ATexturedButton left_skip_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("left_skip_button.png"));
    ATexturedButton right_skip_button = new ATexturedButton(Lotus.get().resourceManager.getBufferedImage("right_skip_button.png"));
    boolean playing = false; // temporary
    JLabel music_title = new JLabel();

    public MainPanel()
    {

        //JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful_design.png"));

        setLayout(null);
        setBackground(new Color(15, 15, 15));

        // close button
        close_button.setSize(64,32);
        close_button.setLocation(1280-close_button.getWidth(),0);
        close_button.addEventListener(this);
        add(close_button);

        // reduce button
        reduce_button.setSize(64,32);
        reduce_button.setLocation(1+1280-reduce_button.getWidth()*2, 0);
        reduce_button.addEventListener(this);
        add(reduce_button);

        // search text box
        search_box.setSize(300-32,24);
        search_box.setLocation(128+32+16,5);
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
        home_button.setSize(32,32);
        home_button.setLocation(15,5);
        home_button.addEventListener(this);
        add(home_button);

        // next button
        next_button.setSize(32,32);
        next_button.setLocation(64+32,0);
        add(next_button);

        // previous button
        previous_button.setSize(32,32);
        previous_button.setLocation(64,0);
        add(previous_button);

        // left menu
        item_account.setBounds(5, 32+590-50-10-50-10-50, 50, 50);
        item_account.setVisible(true);
        add(item_account);

        item_option.setBounds(5, 32+590-50-10-50, 50, 50);
        item_option.setVisible(true);
        add(item_option);

        item_home.setBounds(5, 50+32+10, 50, 50);
        item_home.setVisible(true);
        add(item_home);

        item_library.setBounds(5, 50+32+50+20+10, 50, 50);
        item_library.setVisible(true);
        add(item_library);

        item_radio.setBounds(5, 50+32+50+50+30+20, 50, 50);
        item_radio.setVisible(true);
        add(item_radio);


        // play menu
        play_pause_button.setBounds(1280/2-45/2,720-80/2-45,45,45);
        play_pause_button.addEventListener(this);
        add(play_pause_button);

        left_skip_button.setBounds(1280/2-45/2-40-20,720-80/2-45,45,45);
        left_skip_button.addEventListener(this);
        add(left_skip_button);

        right_skip_button.setBounds(1280/2-45/2+40+20,720-80/2-45,45,45);
        right_skip_button.addEventListener(this);
        add(right_skip_button);

        music_title.setText(Lotus.get().musicPlayer.getCurrentTitle());
        music_title.setBounds(0, 509,999,30);
        music_title.setForeground(Lotus.get().pink);
        music_title.setHorizontalAlignment(SwingConstants.CENTER);
        music_title.setFont(new Font("Serif", Font.PLAIN, 20));
        //add(music_title);
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

        // background
        g.drawImage(Lotus.get().resourceManager.getBufferedImage("test/wallpaper_test.jpg"), 0, 0, 1280, 720, this);

        // main panel
        g.setColor(new Color(15,15,15));
        g.fillRect(60,32, 1220, 590);

        // left menu start
        if(menu)
        {
            g.setColor(Lotus.get().pink);
            //g.drawRect(0, 60, 250, 539-60-30);
        }
        // left menu end

        // top menu start
        g.setColor(Lotus.get().green);
        //g.drawRect(0,0,999,60);
        // top menu end

        // search bar
        g.drawImage(search_bar.texture, 128+16, 4, 300, 24, this);

        // music title bar start
        g.setColor(Lotus.get().pink);
        //g.drawRect(0,539-30,999,30);
        // music title bar end


        // bottom menu start
        g.setColor(Lotus.get().green);
        //g.drawRect(0,539,999,60);
        // bottom menu end
    }

    private void unwindMenu(boolean visible)
    {
        MenuComponentList.forEach(aTexturedButton -> aTexturedButton.setVisible(visible));
    }

}
