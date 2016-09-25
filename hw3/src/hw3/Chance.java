package hw3;
/**
 * @author Samuel Guenette
 * @date 4/29/2016 
 * 
 * Scoring category that is satisfied by any hand.
 * The score is the sum of all die values.
 */
public class Chance extends CategorySuper
{
  /**
   * Constructs a Chance category with the given display name.
   * @param displayName
   *   name for this category
   */
  public Chance(String displayName)
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
	  setHand(dice);
	  int[] diceNums = dice.getAll(); //gets array of dice
	  return sum(diceNums); //returns sum of all dice values
	  
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
	  return true; //returns true no matter what since any combination of
  }  
  

}
