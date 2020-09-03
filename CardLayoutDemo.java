/*
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
 
public class CardLayoutDemo implements ItemListener {
    
    // "Page" name Strings
    final static String HOMEPANEL = "Home";
    final static String GAMEPANEL = "Game";
    final static String LEADERBOARDPANEL = "Leaderboard";
    
    // Window sizes
    final static int extraWindowWidth = 1000;
    final static int extraWindowHeight = 750;
    
    // Overall cards JPanel
    JPanel cards; 
    
    // Separate page JPanels
    JPanel card1;
    JPanel card2;
    JPanel card3;
    
    
     
    public void addComponentToPane(Container pane) throws IOException {
        
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { HOMEPANEL, GAMEPANEL, LEADERBOARDPANEL };
        
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        setupHomePanel();
        setupGamePanel();
        setupLeaderboardPanel();
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, HOMEPANEL);
        cards.add(card2, GAMEPANEL);
        cards.add(card3, LEADERBOARDPANEL);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    // Setup all of the content for the "Home" page
    public void setupHomePanel() throws IOException {
        
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        
        BufferedImage alterEgoShocked = ImageIO.read(new File("AlterEgo/alterego.png"));
        
        JLabel shockedPicLabel = new JLabel(new ImageIcon(alterEgoShocked));
        
        // X, Y. Width, Height
        shockedPicLabel.setBounds(590, 150, 550, 300);
        
        button1.setBounds(250, 100, 250, 40);
        button2.setBounds(280, 100, 250, 40);
        button3.setBounds(340, 100, 250, 40);
        
        //Create the "cards".
        card1 = new JPanel() {
            // Make the window 1000x1000
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height += extraWindowHeight;
                return size;
            }
        };
        
        card1.setLayout(null);
        
        
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        card1.add(shockedPicLabel);
        
     }
    
    // Setup all of the content for the "Game" page.
    public void setupGamePanel() throws IOException {
        card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
    }
    
    // Setup all of the content for the "Leaderboard" page
    public void setupLeaderboardPanel() throws IOException {
        card3 = new JPanel();
        card3.add(new JButton("Button 4"));
        card3.add(new JButton("Button 5"));
        card3.add(new JButton("Button 6"));
    }
     
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * @throws IOException 
     */
    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
