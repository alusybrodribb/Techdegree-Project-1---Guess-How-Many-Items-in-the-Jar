package scores;

/*************************************
CLASS CONTAINING SAVE & LOAD FUNCTIONS
**************************************/

import java.io.*;

public class Scores {
  public static void save(Score[] scores) {
    try (
      FileOutputStream fos = new FileOutputStream("scores.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
    ) {
      oos.writeObject(scores);
    } catch(IOException ioe) {
      System.out.println("Problem saving Scores");
      ioe.printStackTrace();
    }
  }

  public static Score[] load() {
      Score[] scores = new Score[0];
      try (
        FileInputStream fis = new FileInputStream("scores.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
      ) {
        scores = (Score[]) ois.readObject();
      } catch(IOException ioe) {
        System.out.println("Error reading file");
        ioe.printStackTrace();
      } catch(ClassNotFoundException cnfe) {
        System.out.println("Error loading scores");
        cnfe.printStackTrace();
      }
    return scores;
  }

}
