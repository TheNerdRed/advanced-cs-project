/**
* This is a quiz style game using a JFrame user interface in which the
* user will be asked to answer questions to simulate hacking into a 
* terminal with the help of Chihiro Fujisaki, or 'Alter Ego'.
*
* @author  Lewis Binnie
* @version 1.0
* @since   2020-06-04 
*/

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;

public class QuizGame {
  // GLOBAL PROGRAM VARIABLES
  int score = 0;
  
  // JFrame Bounds only need width, height
  int[] frameBounds = {1700, 850};

  // Int arrays for bounds of each element. Each bound is X, Y, Width and Height
  int[] alterEgoBounds = {510, 70, 650, 400};

  int[] homeButtonBounds = {15, 150, 250, 40};
  int[] leaderboardButtonBounds = {15, 250, 250, 40};
  
  int[] scoreCounterBounds = {38, 50, 200, 100};

  int[] screenTextBounds = {510, 500, 650, 200};

  // JFrame
  static JFrame f;

  // JButton definitions
  static JButton homeButton;
  static JButton leaderboardButton;
  static JButton dialogueButton;

  // JTextField
  // static JTextField screenText;

  // JLabel
  JLabel alterEgoLabel;

  JLabel screenText;

  JLabel scoreCounter;

  // BufferedImage
  BufferedImage alterEgoPicture;
  BufferedImage alterEgoHappy;
  
  /**
  * Main process method to be ran for the QuizGame.
  */
  public void quizProcess() throws IOException {

    // Executes a method to setup all the bounds, components of the frame.
    setupFrame();

    // Program variables
    String userInput = "";

    // Adds a new event listener to the button b
    homeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        // Switches Alter Ego's face from shocked to happy.
        alterEgoPicture = alterEgoHappy;
        
        //screenText.setText("<html>I'm...glad though, Naegi. I need your help though to answer these questions and help break through the terminal. Are you in? </html>");
      }
    });

    // Program code begins here
    System.out.println("Test");

  } // end quizProcess()

  /**
  * Method to Initialise / add the components, set their bounds and turn on the JFrame.
  */
  public void setupFrame() throws IOException {
    // Creating instance of JFrame
    f = new JFrame();

    // Creating instance of Main JButton
    homeButton = new JButton("Home");

    leaderboardButton = new JButton("Leaderboard");
    
    dialogueButton = new JButton("Continue");

    // Initialising image files for later loading.
    alterEgoPicture = ImageIO.read(new File("AlterEgo/alterego-bigger.jpg"));
    alterEgoHappy = ImageIO.read(new File("AlterEgo/happy.jpeg"));
    
    // Creating instances of JLabel for graphic on screen.
    alterEgoLabel = new JLabel(new ImageIcon(alterEgoPicture));

    screenText = new JLabel("Screen Text");
    screenText.setText("<html><span style='font-size:15px'>Hello? Is...anyone there? I need your help.</html>");

    scoreCounter = new JLabel("");

    scoreCounter.setText("<html><span style='font-size:30px'>Score: " + String.valueOf(score) + "</html>");

    // Define the x axis, y axis, width, height for the components.

    // JButtons
    homeButton.setBounds(homeButtonBounds[0], homeButtonBounds[1], homeButtonBounds[2], homeButtonBounds[3]);

    leaderboardButton.setBounds(leaderboardButtonBounds[0], leaderboardButtonBounds[1], leaderboardButtonBounds[2], leaderboardButtonBounds[3]);
    
    dialogueButton.setBounds(710, 520, homeButtonBounds[2], homeButtonBounds[3]);
    //{510, 70, 650, 400};

    // Alter Ego Pictures
    alterEgoLabel.setBounds(alterEgoBounds[0], alterEgoBounds[1], alterEgoBounds[2], alterEgoBounds[3]);

    // Screen text
    screenText.setBounds(screenTextBounds[0], screenTextBounds[1], screenTextBounds[2], screenTextBounds[3]);

    scoreCounter.setBounds(scoreCounterBounds[0], scoreCounterBounds[1], scoreCounterBounds[2], scoreCounterBounds[3]);

    // Add each component to the JFrame
    f.add(homeButton);
    f.add(leaderboardButton);
    f.add(dialogueButton);
    f.add(alterEgoLabel);
    f.add(screenText);
    f.add(scoreCounter);

    // Set components of the JFrame
    f.setSize(frameBounds[0], frameBounds[1]);
    f.setLayout(null);

    // Make the JFrame visible
    f.setVisible(true);
  }
  
  public void switchEmotion() throws IOException { 
    alterEgoPicture = ImageIO.read(new File("AlterEgo/happy.jpg"));
    
    alterEgoLabel = new JLabel(new ImageIcon(alterEgoPicture));
  }
  
} // end QuizGame