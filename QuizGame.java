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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
 
public class QuizGame implements ItemListener {
    // System variables
    Random rand = new Random();
    
    int openDialoguePos = 0;
    boolean openTextFinished = false;
    
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
    
    // JAVA SWING CARD LAYOUT INTEGRAL METHODS
    public static void main(String[] args) {
        try {
            // Both types of graphical interface can be chosen.
            
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
        QuizGame demo = new QuizGame();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
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
    
    // PANEL SETUP METHODS 
    /**
    * Defines and places all of the content for the home page. 
    * @throws IOException 
    */
    public void setupHomePanel() throws IOException {
        int yCoordinate = -20;
        
        // All screen text
        JLabel introText1 = new JLabel();
        introText1.setText("<html><span style='font-size:40px;text-align: center;'> Hope's Peak Academy Infiltration </html>");
        
        JLabel introText2 = new JLabel();
        introText2.setText("<html><span style='font-size: 15px;text-align: center;'> --> A quiz game with 20 questions where you need to answer successfully in order to help Chihiro Fujisaki's AI creation 'Alter Ego' break into Hope's Peak!</html>");
        
        JLabel introText3 = new JLabel();
        introText3.setText("<html><span style='font-size: 15px;text-align: center;'> --> View your score and other player's scores in the 'Leaderboard' tab in the top menu. </html>");
        
        JLabel introText4 = new JLabel();
        introText4.setText("<html><span style='font-size:15px;text-align: center;'> --> Head to the 'Game' tab in the top menu to begin. Good luck...the whole of Class 78 are counting on you. </html>");
        
        BufferedImage class78Image = ImageIO.read(new File("AlterEgo/class78.jpg"));
        JLabel class78ImageLabel = new JLabel(new ImageIcon(class78Image));
        
        // Image file and size arrays
        String[] alterEgoFilePaths = new String[]{"AlterEgo/excited.jpeg", "AlterEgo/happy.jpeg", "AlterEgo/sad.jpeg", "AlterEgo/shocked.jpeg", "AlterEgo/shy.jpeg"};

        BufferedImage[] alterEgoRightImages = new BufferedImage[5];
        JLabel[] alterEgoRightLabels = new JLabel[5];
       
        
        // Bound constraints for all components - X, Y, Width, Height
        
        introText1.setBounds(500, 1, 950, 300);
        introText2.setBounds(500, 100, 750, 300);
        introText3.setBounds(500, 200, 750, 300);
        introText4.setBounds(500, 300, 750, 300);
        class78ImageLabel.setBounds(280, 320, 1200, 600);
        
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
        card1.add(class78ImageLabel);
     }
    
    /**
    * Defines and places all of the content for the Game page. 
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
        String[] openingDialogue = new String[]{"<html><span style='font-size:20px;'>We need your help. After Junko Enoshima took over Hope’s Peak Academy, she trapped the entire of Class 78 inside a monstrous killing game! My creator, Chihiro Fujisaki, is one of them.", "<html><span style='font-size:20px;'>I managed to patch into the systems that the Ultimate Imposter setup when he fell into despair, but we’ve been hit with a security system implemented by Jin Kirigiri before he…", "<html><span style='font-size:20px;'>Anyway, we need to get a good enough score out of twenty quiz questions in order to get inside the network, where my creator should be waiting for me.", "<html><span style='font-size:20px;'>Let’s do this. Answer the questions as best as you can. Good luck.", ""};
        
        // Score counter
        JLabel scoreCounter = new JLabel("");
        scoreCounter.setText("<html><span style='font-size:30px;'>Score: " + String.valueOf(score) + "</html>");
        
        // Alter ego dialogue text
        JLabel dialogueText = new JLabel("");
        dialogueText.setText("<html><span style='font-size:20px;'>You’re...actually here? You survived. You're inside the first versions of the Neo World Program!</html>");
        
        // Buttons
        JButton beginButton = new JButton("BEGIN THE GAME!");
        JButton continueButton = new JButton("Continue Dialogue");
        
        // Images
        BufferedImage alterEgoImage = ImageIO.read(new File("AlterEgo/alterego.png"));
        BufferedImage alterEgoNeutral = ImageIO.read(new File("AlterEgo/neutral.jpeg"));
        //JLabel alterEgoImageLabel = new JLabel(new ImageIcon(alterEgoImage));
        
        JLabel alterEgoImageLabel = new JLabel(new ImageIcon(alterEgoImage));
        
        // X, Y. Width, Height
        alterEgoImageLabel.setBounds(510, 150, 550, 300);
        scoreCounter.setBounds(15, 15, 250, 40);
        beginButton.setBounds(650, 480, 250, 40);
        continueButton.setBounds(650, 480, 250, 40);
        dialogueText.setBounds(500, 490, 750, 300);
        
        // Allows for a more dynamic and fluid layout of the page where bounds are specified.
        card2.setLayout(null);
        
        // Add the components to the page
        card2.add(beginButton);
        card2.add(continueButton);
        card2.add(dialogueText);
        card2.add(scoreCounter);
        card2.add(alterEgoImageLabel);
        
        continueButton.setVisible(false);
        dialogueText.setVisible(false);
        
        // BEGIN THE QUIZ GAME
        
        // Game begins when the button is clicked
        beginButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              beginButton.setVisible(false);
              continueButton.setVisible(true);
              dialogueText.setVisible(true);
          }
        });
        
        // Continue the opening dialogue with the continue button, and immediately begin the quiz after the dialogue has finished.
        continueButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               dialogueText.setText(openingDialogue[openDialoguePos]);
               openDialoguePos++;
               if(openDialoguePos == openingDialogue.length) {
                   continueButton.setVisible(false);
                   dialogueText.setVisible(false);
                   try {
                     quizLoop();
                   } catch(IOException excep) {
                     // Handle the error here
                   }
               }
          }
        });
    } // end setupGamePanel()
    
    /**
    * The actual loop for the quiz game itself
    */
    public void quizLoop() throws IOException {
        // Question tracker for the loop
        final int amtQuestions = 20;
        
        // Array of alter ego images
        BufferedImage[] goodEmotionImages = new BufferedImage[]{ImageIO.read(new File("AlterEgo/happy.jpeg")), ImageIO.read(new File("AlterEgo/shocked.jpeg")), ImageIO.read(new File("AlterEgo/excited.jpeg"))};
        BufferedImage[] badEmotionImages = new BufferedImage[]{ImageIO.read(new File("AlterEgo/sad.jpeg")), ImageIO.read(new File("AlterEgo/shy.jpeg")), ImageIO.read(new File("AlterEgo/thinking.jpeg"))};
        
        // ALL HARD-CODED TEXT, EVENTUALLY TO BE READ IN BY THE DATABASE.
        String[] questions = new String[20];
        String[] answers = new String[80];
        String[] questionCorrectDialogue = new String[10];
        String[] questionWrongDialogue = new String[10];
        
        questionCorrectDialogue[0] = "Well done!! You solved it! That was quick. Let’s move on quickly before Junko notices something is up.";
        questionCorrectDialogue[1] = "That’s correct! I wouldn’t have even guessed that...I suppose humans do have their strengths.";
        questionCorrectDialogue[2] = "That’s fantastic! Great work, let’s keep that up for the future.";
        questionCorrectDialogue[3] = "Incredible...how you managed to solve that so quickly.";
        questionCorrectDialogue[4] = "That one was tricky! Hopefully none of the others will be as bad as that.";
        questionCorrectDialogue[5] = "Okay, we kept a clear head with that one. Chihiro would be proud of us.";
        questionCorrectDialogue[6] = "Ha! That was easy! Junko won’t stand a chance...I swear I will free them all from despair.";
        questionCorrectDialogue[7] = "Wow! I think we should start calling you the Ultimate Quiz Master!";
        questionCorrectDialogue[8] = "YES! That’s it! That’s the correct answer!";
        questionCorrectDialogue[9] = "Alright let’s keep pushing on...brilliant work!";
        
        questionWrongDialogue[0] = "Oh no! That’s not the right answer...let’s move on quickly.";
        questionWrongDialogue[1] = "To quote the Ultimate Lucky Student Makoto Naegi himself...No, that’s wrong!";
        questionWrongDialogue[2] = "Aah! We got that wrong...we can’t let ourselves slip up like this...";
        questionWrongDialogue[3] = "That’s unlucky, we need to pick ourselves up and move on.";
        questionWrongDialogue[4] = "No! That’s the incorrect answer...";
        questionWrongDialogue[5] = "What? I really thought that one was correct...";
        questionWrongDialogue[6] = "That was an incorrect answer worthy of Kazuichi Soda himself...";
        questionWrongDialogue[7] = "AH! That’s a wrong answer! The goal is to get as many right as possible.";
        questionWrongDialogue[8] = "Oh...looks like that was wrong….okay….";
        questionWrongDialogue[9] = "Don’t get yourself down. It’s okay, everyone makes mistakes.";
        
        answers[0] = "Answer 1";
        answers[1] = "Answer 2";
        answers[2] = "Answer 3";
        answers[3] = "Answer 4";
        
        // Answer buttons
        JButton answerButton1 = new JButton("");
        JButton answerButton2 = new JButton("");
        JButton answerButton3 = new JButton("");
        JButton answerButton4 = new JButton("");
        
        // Bound setting (X, Y, Width, Height)
        answerButton1.setBounds(150, 580, 200, 100);
        answerButton2.setBounds(550, 580, 200, 100);
        answerButton3.setBounds(950, 580, 200, 100);
        answerButton4.setBounds(1350, 580, 200, 100);
        
        // Adding to the JFrame
        card2.add(answerButton1);
        card2.add(answerButton2);
        card2.add(answerButton3);
        card2.add(answerButton4);
        
        for(int i = 0; i < amtQuestions; i++) {
            answerButton1.setText(answers[0]);
            answerButton2.setText(answers[1]);
            answerButton3.setText(answers[2]);
            answerButton4.setText(answers[3]);
        }
    }
    
    /**
    * Defines and places all of the content for the leaderboard page. 
    */
    public void setupLeaderboardPanel() throws IOException {
        // Leaderboard page card constructor
        card3 = new JPanel();
        
        card3.add(new JTextField("TextField", 20));
    } // end setupLeaderboardPanel()
    
    // QUIZ GAME RUNNING CODE METHODS
    public void beginGame() {
        
    }

    
}