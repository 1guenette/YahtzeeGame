package hw3;
/**
 * @author Samuel Guenette
 * @date 4/29/2016 Category
 * 
 * Scoring category for a "yahtzee".  A hand
 * with N dice satisfies this category only if all N
 * values are the same.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class AllOfAKind extends CategorySuper
{
	/**
	 *Point value thats reqarded if the dice value meet the CategorySuper subclass's criteria
	 */	
	private int pts;
	
  /**
   * Constructs an AllOfAKind with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a hand that satisfies this category
   */  
  public AllOfAKind(String displayName, int points)
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
	  
	  setHand(dice);
	  if(isSatisfiedBy(dice) == false)
	  {
		  return 0;
	  }
	  else
	  {
		  
		 return pts;
		  
	  }
	  
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
	  int[] diceNums = dice.getAll();
	  int num = diceNums[0]; //dice to be compared to all other dice
	  for(int i = 0; i<diceNums.length; i++)
	  {
		  if(num != diceNums[i]) // checks if there is one value in the dice group that is different than the first dice
		  {
			  return false;
		  }
	  }
	 
	 return true;
  }  
 
}
