/*******************************************
CLASS FOR SETTING INITIAL PARAMETERS OF JAR
*******************************************/
import java.io.Console;
import java.util.Random;


public class Jar {
    private String mObjectType;
    private int mMaxObjects;
    private int mGuessCounter;
    private int mObjectsInJar;
    private boolean mIsCorrect;
    private String mPlayerName;

    public Jar(String objectType, int maxObjects) {
      Console console = System.console();
      mObjectType = objectType;
      mMaxObjects = maxObjects;
      mGuessCounter = 0;
      mObjectsInJar = new Random().nextInt(maxObjects) + 1;
      mIsCorrect = false;
      mPlayerName = console.readLine("Hi! Please enter your name: ");
    }

/***********************
GUESS APPLICATION
***********************/

    public boolean applyGuess(String guessAsString) {
        int guess = Integer.parseInt(guessAsString);
        return applyGuess(guess);
    }

    public boolean applyGuess(int guess) {
      if (guess > mMaxObjects) {
        throw new IllegalArgumentException("The jar's not that big - try a smaller number! ");
      } else if (guess < 1) {
        throw new IllegalArgumentException("Very funny - please guess a positive number.");

      }
      mIsCorrect = mObjectsInJar  == guess;
      return mIsCorrect;
    }

    public int score() {
      //Calculates & returns score
      //I chose the formula score  = max objects in jar / no of guesses
      //So that a higher maximum no of objects gives a higher score
      int score = (mMaxObjects / mGuessCounter);
      return score;
    }


/*****************
GETTERS
******************/

    public String getObjectType() {
        return mObjectType;
    }

    public int getMaxObjects() {
        return mMaxObjects;
    }

    public int getObjectsInJar() {
        return mObjectsInJar;
    }

    public int getGuessCounter() {
      return mGuessCounter;
    }

    public boolean isSolved() {
        return mIsCorrect;
    }

    public String getPlayerName() {
      return mPlayerName;
    }

/***********************
COUNTER
***********************/

    public int counter() {
      mGuessCounter++;
      return mGuessCounter;
    }
}
