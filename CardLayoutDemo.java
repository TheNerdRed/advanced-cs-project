/** 
* The QuizGame class manages the state of the QuizGame, allowing players to
* switch between the 'Home', 'Game' and 'Leaderboard' pages, and play the game.
*
* @author  Lewis Binnie
* @version 1.0
* @since   07 / 08 / 2020
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
 
public class CardLayoutDemo implements ItemListener {
    
    // "Page" name String variables
    final static String HOMEPANEL = "Home";
    final static String GAMEPANEL = "Game";
    final static String LEADERBOARDPANEL = "Leaderboard";
    
    // Window sizes
    final static int extraWindowWidth = 1800;
    final static int extraWindowHeight = 850;
    
    // Overall cards JPanel
    JPanel cards; 
    
    // Separate page JPanels
    JPanel card1; // Home page
    JPanel card2; // Game page
    JPanel card3; // Leaderboard page
    
    // Program variables
    int score = 0;
     
    /**
    * The addComponentToPane() method sets up the dropdown menu for switching pages, and invokes the
    * methods to setup all three individual pages.
    * @throws IOException 
    */
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
    
    /**
    * Defines and places all of the content for the home page. 
    * @throws IOException 
    */
    public void setupHomePanel() throws IOException {
        int yCoordinate = -20;
        
        // All screen text
        JLabel introText1 = new JLabel();
        introText1.setText("<html><span style='font-size:15px;text-align: center;'> Wh..what! They really did it. You survived! </html>");
        
        JLabel introText2 = new JLabel();
        introText2.setText("<html><span style='font-size: 15px;text-align: center;'>Your inside the Neo World Program. We need your help to take down the systems that Junko Enoshima built up when she took control of Hope's Peak.</html>");
        
        JLabel introText3 = new JLabel();
        introText3.setText("<html><span style='font-size: 15px;text-align: center;'>We're going to answer a series of security questions based after some of Jin Kirigiri, the old Hope's Peak headmasters, favourite things!</html>");
        
        JLabel introText4 = new JLabel();
        introText4.setText("<html><span style='font-size:15px;text-align: center;'>Head to the 'Game' tab in the top menu to begin. Good luck...Naegi and the others are counting on you. </html>");
        
        // Alter ego images
        BufferedImage mainAlterEgoImage = ImageIO.read(new File("AlterEgo/alterego.png"));
        
        // Image file and size arrays
        String[] alterEgoFilePaths = new String[]{"AlterEgo/excited.jpeg", "AlterEgo/happy.jpeg", "AlterEgo/sad.jpeg", "AlterEgo/shocked.jpeg", "AlterEgo/shy.jpeg"};

        BufferedImage[] alterEgoRightImages = new BufferedImage[5];
        JLabel[] alterEgoRightLabels = new JLabel[5];
        
        JLabel mainAlterEgoLabel = new JLabel(new ImageIcon(mainAlterEgoImage));
        
        // Bound constraints for all components - X, Y, Width, Height
        mainAlterEgoLabel.setBounds(510, 150, 550, 300);
        
        introText1.setBounds(500, 375, 750, 300);
        introText2.setBounds(500, 435, 750, 300);
        introText3.setBounds(500, 495, 750, 300);
        introText4.setBounds(500, 555, 750, 300);
        
        // Home page card constructor
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

        for(int i = 0; i < alterEgoRightImages.length; i++) {
            //System.out.println(alterEgoFilePaths[i]);
            alterEgoRightImages[i] = ImageIO.read(new File(alterEgoFilePaths[i])); 
            
            alterEgoRightLabels[i] = new JLabel(new ImageIcon(alterEgoRightImages[i]));
            
            alterEgoRightLabels[i].setBounds(1100, yCoordinate, 550, 300);
            
            card1.add(alterEgoRightLabels[i]);
            
            yCoordinate = yCoordinate + 200;
        }
        
        card1.add(introText1);
        card1.add(introText2);
        card1.add(introText3);
        card1.add(introText4);
        card1.add(mainAlterEgoLabel);
     }
    
    /**
    * Defines and places all of the content for the Game page. 
    * Contains the code for running the quiz game.
    * @throws IOException 
    */
    public void setupGamePanel() throws IOException {
        // Game page card constructor
        card2 = new JPanel() {
            // Make the window the specified sizes
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height += extraWindowHeight;
                return size;
            }
        };
        
        // JAVA COMPONENT DEFINITIONS
        
        // Score counter
        JLabel scoreCounter = new JLabel("");

        scoreCounter.setText("<html><span style='font-size:30px; font-family: Montserrat;'>Score: " + String.valueOf(score) + "</html>");
        
        // Buttons
        JButton continueButton = new JButton("Continue");
        
        // Images
        BufferedImage alterEgoImage = ImageIO.read(new File("AlterEgo/alterego.png"));
        
        JLabel alterEgoImageLabel = new JLabel(new ImageIcon(alterEgoImage));
        
        // X, Y. Width, Height
        alterEgoImageLabel.setBounds(510, 150, 550, 300);
        
        continueButton.setBounds(650, 550, 250, 40);
        
        scoreCounter.setBounds(15, 15, 250, 40);
        
        // Allows for a more dynamic and fluid layout of the page where bounds are specified.
        card2.setLayout(null);
        
        card2.add(continueButton);
        card2.add(scoreCounter);
        card2.add(alterEgoImageLabel);
    } // end setupGamePanel()
    
    /**
    * Defines and places all of the content for the leaderboard page. 
    */
    public void setupLeaderboardPanel() throws IOException {
        // Leaderboard page card constructor
        card3 = new JPanel();
        
        card3.add(new JTextField("TextField", 20));
    } // end setupLeaderboardPanel()
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.
     * @throws IOException 
     */
    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // test
         
        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        try {
            // Both types of graphical interfacen can be chosen.
            
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
        
        // Disable bold fonts.
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