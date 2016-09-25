package hw3;
/**
 * @author Samuel Guenette
 * @date 4/29/2016 
 * 
 * Scoring category for (N-2) of a kind.  A hand
 * with N dice satisfies this category only if at least N - 2 of
 * the values are the same.  For a hand that satisfies
 * this category, the score the sum of all die values;
 * otherwise the score is zero.
 */
public class AllButTwoOfAKind extends CategorySuper
{
	
  /**
   * Constructs an AllButOneOfAKind category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   */
  public AllButTwoOfAKind(String displayName)
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
	  int result = 0; //value being returned
	  
	  if(isSatisfiedBy(dice) == false) //use ifSatisfied() method to tell whether a score can be given
	  {
		  return result;
	  }
	  else	//if a value can be given
	  {
		  int[] diceNums = dice.getAll();  //gets array of all the dice
		  
		  for(int i = 0; i<diceNums.length; i++) //loops through the dice numbers
		  {
			  int commonTotal = 0;
			  int commonNum = diceNums[i];
			  for(int j =0; j<diceNums.length; j++)
			  {
				  if(commonNum == diceNums[j])
				  {
					commonTotal++;  
				  }
				  if(commonTotal >= dice.getNumDice()-2)
				  {
					  result = sum(diceNums);
					 
				  }
			  }
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
	  setHand(dice);
	  boolean result = false;  //result to be returned
	  
	  int[] diceNums = dice.getAll();  //gets array of all the dice
	  
	  for(int i = 0; i<diceNums.length; i++) //loops through the dice numbers
	  {
		  int commonTotal = 0;
		  int commonNum = diceNums[i]; //
		  for(int j =0; j<diceNums.length; j++)
		  {
			  if(commonNum == diceNums[j])
			  {
				commonTotal++;  
			  }
		  }
		  if(commonTotal >= dice.getNumDice()-2) //if at least all but two dice are the same
		  {
			  result = true;
			 
		  }		  
	  }
	  
	  return result;
  }
}
