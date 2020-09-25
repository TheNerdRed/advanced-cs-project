import java.io.*;
import java.util.*;

/**
 * Test class for development
 *
 * @author Lewis Binnie
 */
public class Test
{
  Question[] questionList = new Question[2];
  
  public void testProcess() throws IOException {
      readQuestionFile(questionList);
      printCSV(questionList);
  }
    
  public void readQuestionFile(Question[] questionList) throws IOException {
    String csv = "";
    String[] valueList = new String[4];

    // identify file
    String inputFile = "Database/questions.csv";
    // open file
    Scanner fileReader = new Scanner(new File(inputFile));

    // loop for every csv row, fetch from file and store
    for (int i = 0; i < questionList.length; i++) {

      csv = fileReader.nextLine();
      valueList = csv.split(",");
      
      questionList[i] = new Question(valueList[0], valueList[1], valueList[2], valueList[3], valueList[4]);
    }

    fileReader.close();

  } // end readQuestionFile()
  
  public void printCSV(Question[] questionList) {
      for(int i = 0; i < questionList.length; i++) {
          System.out.println("Question: " + questionList[i].getQuestion());
          System.out.println("Answer 1: " + questionList[i].getAnswer1());
          System.out.println("Answer 2: " + questionList[i].getAnswer2());
          System.out.println("Answer 3: " + questionList[i].getAnswer3());
          System.out.println("Answer 4: " + questionList[i].getAnswer4());
      }
  }
}