package scores;
/*******************************************************
CLASS THAT DEFINES SCORES & SORTING & TOSTRING FUCNTION
*******************************************************/

import java.io.Serializable;
import java.util.*;

public class Score implements Comparable, Serializable {

  private String mName;
  private int mScore;

  public Score (String name, int score) {
    mName = name;
    mScore = score;
  }

  @Override
  public String toString() {
    return String.format("%s:\t%d",
                         mName, mScore);
  }

  @Override
  public int compareTo(Object obj) {
    Score other = (Score) obj;
    int highLow = Integer.toString(mScore).compareTo(Integer.toString(other.mScore));
    return highLow;
  }

  /*****************
  GETTERS
  ******************/

  public String getName() {
    return mName;
  }

  public int getScore() {
    return mScore;
  }
}
