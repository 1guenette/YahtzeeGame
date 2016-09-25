package hw3;
import java.util.Arrays;

/**
 * @author Samuel Guenette
 * @date 4/29/2016  
 * Scoring category for a "large straight".  A hand
 * with N dice satisfies this category only if there are
 * N distinct consecutive values.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class LargeStraight extends CategorySuper 
{
	private int pts;
	

  /**
   * Constructs a LargeStraight category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a hand that satisfies this category
   */  
  public LargeStraight(String displayName, int points)
  {
	  super(displayName);
	  pts = points;
  }
  
  /**
   * Returns the score value with the given hand object
   * 
   * @param dice
   * 		the Hand-type that holds the dice values 
   *   
   * @return possible score if Hand instance field meets certain criteria
   */      
  public int getPotentialScore(Hand dice)
  {
	  return getPtScore(dice,pts);
	  
  }   
  
  /**
   * Returns the score value with the given hand object
   *  @param dice
   *			the Hand-type that holds the dice values 
   *  			 
   * @return true or false based on if the values in the Hand parameter meets certain criteria
   */        
  public boolean isSatisfiedBy(Hand dice)
  {
	  setHand(dice);
	  boolean result = true;
	  int[] diceNums = dice.getAll();
	  Arrays.sort(diceNums);
	  
	  for(int i = 0; i<diceNums.length-1; i++)
	  {
		  if(diceNums[i] != diceNums[i+1]-1)
		  {
			  result = false;
		  }
	  }
	 return result; 
	  
  }  
}
