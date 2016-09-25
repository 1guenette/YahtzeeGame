package hw3;

import java.util.Arrays;
/**
 * @author Samuel Guenette
 * @date 4/29/2016  
 * 
 * Scoring category for a "small straight".  A hand
 * with N dice satisfies this category only if it includes
 * N - 1 distinct consecutive values.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class SmallStraight extends CategorySuper
{
	private int pts;
  /**
   * Constructs a SmallStraight category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a dice group that satisfies this category
   */  
	public SmallStraight(String displayName, int points)
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
		  return getPtScore(dice, pts); //getPtScore() superclass method is used to get potential score of dice value based on this subclass's criteria 
		  
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
		  boolean result = true; //result being returned
		  boolean exceptionLeft = true; //Exception boolean that accoounts for the one die-number that is not consecutive with all the rest
		  
		  int[] diceNums = dice.getAll(); //Array of all dice values
		  Arrays.sort(diceNums); //Sorts dice values in order 
		  
		  for(int i = 0; i<diceNums.length-1; i++)	//loops through all dice values
		  {
			  if(diceNums[i] != diceNums[i+1]-1 && exceptionLeft == true) //If a nonconsecutive die-value is found and it is the first exception
			  {
				  exceptionLeft = false;
			  }
			  else if(diceNums[i] != diceNums[i+1]-1)  //If a nonconsecutive die-value is found and it is not the first exception made
			  {
				  result = false;
			  }
			  
		  }
		 if(exceptionLeft == true)	//If an exception was not found
		 {
			 result = false;
		 }
		  return result; 		  
	  }  
}


