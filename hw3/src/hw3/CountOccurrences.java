package hw3;
/**
 * @author Samuel Guenette
 * @date 4/29/2016 
 * 
 * Scoring category that is based on counting occurrences
 * of a particular target value (specified in the constructor).
 * This category is satisfied by any hand.  The score
 * is the sum of just the die values that match the target value.
 */
public class CountOccurrences extends CategorySuper
{
	/**
	 *Value that will count for points 
	 */	
	private int value;


  /**
   * Constructs a CountOccurrences category with the given display name and 
   * target value.
   * @param displayName
   *   name for this category
   * @param whichValue
   *   target value that must be matched for a die to count toward the
   *   score
   */
  public CountOccurrences(String displayName, int whichValue)
  {
	super(displayName);
    value = whichValue;
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
	  if(isSatisfiedBy(dice)== false)		//uses isSatisfied method to check if a score is even possible 
	  {
		  return 0;
	  }
	  else
	  {
		  int[] diceNums = dice.getAll();
		  int sum = 0;
		  for(int i = 0; i<diceNums.length; i++) //loops through all dice value and only adds values that are the same as the value instance variable
		  {
			  if(diceNums[i] == value)
			  {
				  sum+= diceNums[i];
			  }
		  }
		 
		  return sum;
		  
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
	  setHand(dice); //sets instance variable with protected method
	  int[] diceNums = dice.getAll(); //gets array of all dice value
	  boolean satisfied = false; //result that is being returned
	  for(int i = 0; i<diceNums.length; i++) //loops through all dice values
	  {
		  if(diceNums[i] == value)//if target value exists, the object is satisfied
		  {
			  satisfied = true;
		  }
	  }
	 
	  return satisfied;
  }  

}
