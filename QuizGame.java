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
  int score = 10;

  // Int arrays for bounds of each element. Each bound is X, Y, Width and Height
  int[] alterEgoBounds = {190, 70, 450, 400};

  int[] buttonOneBounds = {250, 100, 250, 40};
  int[] buttonTwoBounds = {250, 450, 250, 40};

  int[] screenTextBounds = {250, 500, 250, 200};

  int[] scoreCounterBounds = {50, 50, 100, 100};

  // JFrame Bounds only need width, height
  int[] frameBounds = {800, 650};


  // JAVA SWING COMPONENT VARIABLES

  // JFrame
  static JFrame f;

  // JButton definitions
  static JButton b;
  static JButton b2;

  // JTextField
  // static JTextField screenText;

  // JLabel
  JLabel shockedPicLabel;
  JLabel happyPicLabel;
  JLabel shyPicLabel;

  JLabel screenText;

  JLabel scoreCounter;

  // BufferedImage
  BufferedImage alterEgoShocked;
  BufferedImage alterEgoHappy;
  BufferedImage alterEgoShy;
  
  /**
  * Main process method to be ran for the QuizGame.
  */
  public void quizProcess() throws IOException {

    // Executes a method to setup all the bounds, components of the frame.
    setupFrame();

    // Program variables
    String userInput = "";

    // Adds a new event listener to the button b
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        // Switches Alter Ego's face from shocked to happy.
        shockedPicLabel.setVisible(false);
        happyPicLabel.setVisible(true);

        screenText.setText("<html>I'm...glad though, Naegi. I need your help though to answer these questions and help break through the terminal. Are you in? </html>");
      }
    });

    // Adds a new event listener to the button b2
    b2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        System.out.println("Hello, World!");

        shockedPicLabel.setVisible(false);
        happyPicLabel.setVisible(false);
        shyPicLabel.setVisible(true);

        screenText.setText("<html>Hello, World!</html>");
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
    b = new JButton("Continue");

    b2 = new JButton("Hello, World!");

    // Initialising image files for later loading.
    alterEgoShocked = ImageIO.read(new File("AlterEgo/alterego.png"));

    alterEgoHappy = ImageIO.read(new File("AlterEgo/happy.jpeg"));

    alterEgoShy = ImageIO.read(new File("AlterEgo/shy.jpeg"));

    // Creating instances of JLabel for graphic on screen.
    shockedPicLabel = new JLabel(new ImageIcon(alterEgoShocked));

    happyPicLabel = new JLabel(new ImageIcon(alterEgoHappy));
    
    shyPicLabel = new JLabel(new ImageIcon(alterEgoShy));

    screenText = new JLabel("Screen Text");
    screenText.setText("<html>Wh..what! You actually made it into the mainframe! I...didn't expect someone to make it this far.</html>");

    scoreCounter = new JLabel("<html><span style='font-size:20px'>"+ "<html>Score: </html>");

    scoreCounter.setText("<html>Score: " + String.valueOf(score) + "</html>");

    // Define the x axis, y axis, width, height for the components.

    // JButtons
    b.setBounds(buttonOneBounds[0], buttonOneBounds[1], buttonOneBounds[2], buttonOneBounds[3]);

    b2.setBounds(buttonTwoBounds[0], buttonTwoBounds[1], buttonTwoBounds[2], buttonTwoBounds[3]);

    // Alter Ego Pictures
    shockedPicLabel.setBounds(alterEgoBounds[0], alterEgoBounds[1], alterEgoBounds[2], alterEgoBounds[3]);

    happyPicLabel.setBounds(alterEgoBounds[0], alterEgoBounds[1], alterEgoBounds[2], alterEgoBounds[3]);

    shyPicLabel.setBounds(alterEgoBounds[0], alterEgoBounds[1], alterEgoBounds[2], alterEgoBounds[3]);

    // Screen text
    screenText.setBounds(screenTextBounds[0], screenTextBounds[1], screenTextBounds[2], screenTextBounds[3]);

    scoreCounter.setBounds(scoreCounterBounds[0], scoreCounterBounds[1], scoreCounterBounds[2], scoreCounterBounds[3]);

    // Add each component to the JFrame
    f.add(b);
    f.add(b2);
    f.add(shockedPicLabel);
    f.add(happyPicLabel);
    f.add(shyPicLabel);
    f.add(screenText);
    f.add(scoreCounter);

    // Set components of the JFrame
    f.setSize(frameBounds[0], frameBounds[1]);
    f.setLayout(null);

    // Make the JFrame visible
    f.setVisible(true);
  }
  
} // end QuizGame