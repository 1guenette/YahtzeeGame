package hw3;
/**
 * @author Samuel Guenette
 * @date 4/29/2016 
 * 
 * Scoring category for (N-1) of a kind.  A hand
 * with N dice satisfies this category only if at least N - 1 of
 * the values are the same.  For a hand that satisfies
 * this category, the score the sum of all die values;
 * otherwise the score is zero.
 */
public class AllButOneOfAKind extends CategorySuper
{	
  /**
   * Constructs an AllButOneOfAKind category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   */
  public AllButOneOfAKind(String displayName)
  {
    super(displayName);
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
	  setHand(dice);  //sets instance variable with protected method
	  int result = 0;
	  
	  if(isSatisfiedBy(dice) == false)//returns 0 if dice-values from dice variable is 
	  {
		  return result;
	  }
	  else
	  {
		  int[] diceNums = dice.getAll();  //gets array of all the dice
		  
		  for(int i = 0; i<diceNums.length; i++) //loops through the dice numbers
		  {
			  result += diceNums[i];
		  }
		  
	  
	  }
	 
	  return result;
	  
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
	  setHand(dice);//sets hand as instance variable for superclass
	  boolean result = false; //result that's being returned
	  
	  int[] diceNums = dice.getAll();  //gets array for all the dice values
	  
	  for(int i = 0; i<diceNums.length; i++) //loops through the number of dice
	  {
		  int commonTotal = 0;
		  int commonNum = diceNums[i];	//establishes dice that is being compared with all other dice
		  for(int j =0; j<diceNums.length; j++)
		  {
			  if(commonNum == diceNums[j])
			  {
				commonTotal++;  		//updates sum dice that have the same values as commonNum
			  }
		  }
		  if(commonTotal >= dice.getNumDice()-1) //Checks if at least all but one of the dice values are the same
		  {
			  result = true;
			 
		  }		  
	  }
	  
	  return result;
  }
}
