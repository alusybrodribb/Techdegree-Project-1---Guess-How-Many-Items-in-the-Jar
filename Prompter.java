/*********************************************
CLASS CONTAINING MAIN PLAY FUNCTIONS FOR GAME
*********************************************/

import java.io.Console;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//High Score Package
import scores.Score;
import scores.Scores;


public class Prompter {
    private Jar mJar;

    public Prompter(Jar jar) {
       mJar = jar;
    }

/**************
PLAY FUNCTION
**************/
    public void play() {
        Console console = System.console();
        System.out.printf("Guess how many %s are in the jar. It could hold up to %d %s\n", mJar.getObjectType(), mJar.getMaxObjects(), mJar.getObjectType());
        while (! mJar.isSolved()) {
            promptForGuess();
            mJar.isSolved();
        }

        System.out.printf("Congratulations. You guessed correctly. There were %d %s in the jar.\n", mJar.getObjectsInJar(), mJar.getObjectType());
        System.out.printf("You took %d tries to get it right.\n", mJar.getGuessCounter());
        System.out.printf("Your score was %d\n\n", mJar.score());
        checkHighScore();
 }

 /*****************
PROMPT & DISPLAY FUNCTIOINS
 *****************/

      public boolean promptForGuess() {
        Console console = System.console();
        boolean isCorrect = false;
        String guessAsString = console.readLine("Please enter a number between 0 and %d: ", mJar.getMaxObjects());
        try {
          isCorrect = mJar.applyGuess(guessAsString);
        }
        //Checks to see if number is less than maximum no of objects
        //Should also check to see if input can be parsed into integer, but this isn't working right now (am trying to fix this bug)
        catch (NumberFormatException e) {
          console.printf("Sorry, that is not a number - please try again.\n");
          return false;
        }
        catch (IllegalArgumentException e) {
          console.printf("%s\n", e.getMessage(), mJar.getMaxObjects(), mJar.getObjectType());
          return false;
        }

        mJar.counter();
        //Tells player if guess is too high or too low
        if (Integer.parseInt(guessAsString) < mJar.getObjectsInJar()) {
          System.out.printf("Sorry - there are more than %s %s in the jar.\n", guessAsString, mJar.getObjectType());
        } else if (Integer.parseInt(guessAsString) > mJar.getObjectsInJar()) {
          System.out.printf("Sorry - there are fewer than %s %s in the jar.\n", guessAsString, mJar.getObjectType());
        }
        return isCorrect;
    }

/********************
HIGH SCORE FUNCTION
********************/

    public void checkHighScore() {
      //Loads high scores and makes sure they are in the correct order
      Console console = System.console();
      Score[] highScores = Scores.load();
      Arrays.sort(highScores, Collections.reverseOrder());
      if (mJar.score() > highScores[2].getScore()) {
        //Checks to see if player's score is high score and adds their
        //score to high score file if it is higher than the 3rd high score
        String name = console.readLine("Congratulations, you got a High Score! Please enter your name: ");
        Score newScore = new Score(name, mJar.score());
        highScores[2] = newScore;
        Arrays.sort(highScores, Collections.reverseOrder());
        Scores.save(highScores);
        System.out.printf("\n");
      }
      //Prints high scores, regardless of whether player score is a
      //High score or not.
      System.out.printf("High Scores\n");
      int index = 1;
      for (Score highScore : highScores) {
        System.out.println((index++) + ". " + highScore);
      }
    }
}
