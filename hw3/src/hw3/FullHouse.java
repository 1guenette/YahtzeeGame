package hw3;
import java.util.Arrays;

/**
 * @author Samuel Guenette
 * @date 4/29/2016 CategorySupper uses implements the methods the Category Interface to provide methods common methods that
 * all Category subclasses inherit.  Superclass also provides protected methods that subclasses to in order to simplify code. 
 * 
 * Scoring category for a generalized full house.  A hand
 * with N dice satisfies this category only in the following cases:
 * If N is even, there are two different values, each occurring exactly N/2 times.
 * If N is odd, there are two different values, one of them occurring N/2 times and
 * the other occurring N/2 + 1 times.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class FullHouse extends CategorySuper
{
	/**
	 *Point value thats reqarded if the dice value meet the CategorySuper subclass's criteria
	 */		
	private int pts;
	
  /**
   * Constructs a FullHouse category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a hand that satisfies this category
   */  
  public FullHouse(String displayName, int points)
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
	  return getPtScore(dice, pts);
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
	  	  
	//FIGURE OUT HOW MANY DICE	  
	  if(dice.getNumDice()%2 == 0) //if even number of dice
	  {
		  int val1 = diceNums[0];
		  int val1Count = 0;
		  int val2 = diceNums[diceNums.length-1];
		  int val2Count = 0;
		  for(int i = 0; i<diceNums.length;i++)
		  {
			  if(diceNums[i]!= val1 && diceNums[i] != val2)
			  {
				  result = false;
			  }
			  else if(val1==diceNums[i])
			  {
				  val1Count++;
				  
			  }
			  else if(val2 == diceNums[i])
			  {
				  val2Count++;
			  }
			  
		  }
		  
		  if(val2Count != val1Count)
		  {
			  result = false;
		  }
	  }
	  else						//If odd number of dice
	  {
		  int val1 = diceNums[0];
		  int val1Count = 0;
		  int val2 = diceNums[diceNums.length-1];
		  int val2Count = 0;
		  for(int i = 0; i<diceNums.length;i++)
		  {
			  if(diceNums[i]!= val1 && diceNums[i] != val2)//if there is more than val1 and val2 in the dice combination
			  {
				  result = false;
			  }
			  else if(val1==diceNums[i])
			  {
				  val1Count++;
				  
			  }
			  else if(val2 == diceNums[i])
			  {
				  val2Count++;
			  }
			  
		  }
		  
		  if((val2Count != val1Count+1 ) && (val2Count != val1Count-1 ))
		  {
			  result = false;
		  }
		
	  }
	 
	  
	 return result;
	  
	  
  }  
}
