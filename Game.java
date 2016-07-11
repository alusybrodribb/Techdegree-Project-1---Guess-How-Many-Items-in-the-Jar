/******************
MAIN CLASS FOR GAME
******************/

import java.io.Console;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//High Score Package
import scores.Score;
import  scores.Scores;

public class Game {
    public static void main(String[] args) {

      if (args.length == 0) {
        //Shows High Scores
        Score[] highScores = Scores.load();
        Arrays.sort(highScores);
        System.out.println("High Scores");
        int index = 1;
        for (Score highScore : highScores) {
          System.out.println((index++) + ". " + highScore);
        }
        System.exit(0);
      } else if (args[0].equals("reset")) {
        //Resets High Scores
        Score score = new Score("Anon", 0);
        Score[] highScores = {score, score, score};
        System.out.println("High Scores");
        int index = 1;
        for (Score highScore : highScores) {
          System.out.println((index++) + ". " + highScore);
        }
        Scores.save(highScores);
        System.exit(0);
      } else if (args.length != 2) {
        //Checks for right number of args
        System.out.println("Please enter 2 arguments: an object type and a maxiumum number of objects.");
        System.exit(0);
      }
      try {
        //Checks that 2nd arg is an Integer
        int numberOfObjects = Integer.parseInt(args[1]);
      } catch (NumberFormatException e) {
        System.out.println("Please enter an integer as your second argument.");
        System.exit(0);
      }

      //Initialises Jar class and runs game
      Score[] thisGameScores;
      thisGameScores = new Score[3];
      for(int i = 0; i < 3; i++) {
        Jar jar = new Jar(args[0], Integer.parseInt(args[1]));
        Prompter prompter = new Prompter(jar);
        prompter.play();
        Score playerScore = new Score(jar.getPlayerName(), jar.score());
        thisGameScores[i] = playerScore;
      }
      System.out.printf("Scores for this Game\n");
      int index = 1;
      for (Score score : thisGameScores) {
        System.out.println("Game " + (index++) + ". " + score);
      }
    }
}
