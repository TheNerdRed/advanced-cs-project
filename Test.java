import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class Test extends JFrame {

	  int[] frameBounds = {800, 650};

	  // JAVA SWING COMPONENT VARIABLES

	  // JFrame
	  static JFrame f;
	  
	  // JPanel
	  JPanel cards;
	  
	  JPanel card1;
	  JPanel card2;
	  
	  final static String BUTTONPANEL = "Card with JButtons";
	  final static String TEXTPANEL = "Card with JTextField";
	  
	  /**
	  * Main process method to be ran for the QuizGame.
	  */
	  public void quizProcess() throws IOException {
		  
		  
		  		  
	    // Executes a method to setup all the bounds, components of the frame.
	    //setupFrame();

	    // Program code begins here
	    System.out.println("Test");

	  } // end quizProcess()
	  
	  public void addComponentToPane(Container pane) {
		  
		  JPanel card1 = new JPanel();
		  card1.add(new JButton("Button 1"));
		  
		  JPanel card2 = new JPanel();
		  card2.add(new JButton("Button 2"));
		  
		  cards = new JPanel(new CardLayout());
		  
		  pane.add(cards);
		  
	  }
	  
	  public void createAndShowGUI() {
		  JFrame frame = new JFrame("Test Frame");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  Test demo = new Test();
		  demo.addComponentToPane(frame.getContentPane());
	  }
	  
} // end Test
