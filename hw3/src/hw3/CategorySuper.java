package hw3;
/**
 * @author Samuel Guenette
 * @date 4/29/2016 
 * 
 * CategorySupper uses implements the methods the Category Interface to provide methods common methods that
 * all Category subclasses inherit.  Superclass also provides protected methods that subclasses to in order to simplify code. 
 */

public abstract class CategorySuper implements hw3.api.Category 
{
	/**
	 *Tracks the categories set name
	 */	
	private String name;
	
	/**
	 *Tracks the hand object that is used for for methods with dice-related functions
	 */		
	private Hand hand;
	
	/**
	 *Tracks if the category is filled with an already valid score
	 */		
	private boolean filled;
	


	 /**
	  * Constructs a category that is given a display name and is initially unfilled. 
	  * 
	  * @param displayName
	  *            the unique name labeled for the category object
	  */	
	 public CategorySuper(String displayName)
	{
		name = displayName;
		hand = null;
		filled = false;
	}

	 /**
	  * Method for subclasses to assign the given Hand object to the instance Field  
	  * 
	  * @param givenHand
	  *            Hand object used for rolling and retrieving the values of dice
	  * @return void
	  */	
	 protected void setHand(Hand givenHand)
	{
		hand = givenHand;
	}
	
	 /**
	  * Method for subclasses to return  possible points if the object's Hand object meets a certain criteria
	  * 
	  * @param displayName
	  *            the unique name labeled for the category object
	  * @param pts
	  *            the points to category subclass under certain conditions   
	  * @return the value of pts or 0 if the dice does not meet the objects criteria                 
	  */	 
	 protected int getPtScore(Hand dice, int pts)
	{
		setHand(dice);
		if(isSatisfiedBy(dice)== false)
		{
			return 0;
		}
		else
		{
			return pts;
		}
	}  
		
	 /**
	  * Method for subclasses to get the sum of integer values in an array
	  * 
	  * @param displayName
	  *            the unique name labeled for the category object
	  * @param pts
	  *            the points to category subclass under certain conditions   
	  * @return The sum of the array                  
	  */	
	 protected int sum(int[] array)
	{
		int result = 0;
		
		for(int i = 0; i<array.length; i++)
		{
			result += array[i];
		}
		
		return result;
	}
			
	 
	 
	 /**
	  * Changes the filled instance variable so that the specific subclass can no longer be given a score
	  * 
	  * @param pts
	  *            the points to category subclass under certain conditions   
	  * @return The sum of the array                  
	  */		 
	 public void fill(Hand dice)
	{
		hand = dice;
		filled = true;
	}   
	
	 /**
	  * Changes the filled instance variable 
	  * 
	  * @param pts
	  *            the points to category subclass under certain conditions   
	  * @return The sum of the array                  
	  */	
	public String getDisplayName()
	{
		return name;
	}   
	
	/**
	  * Returns the hand hand instance variable
	  *   
	  * @return the hand object instance               
	  */	
	public Hand getHand()
	{
		return hand;
	} 
	
	/**
	  * Returns the score value by using the getPotentialScore() method 
	  *   
	  * @return the score value for the score         
	  */		
	public int getScore()
	{
		if(filled == true)
		{
			return getPotentialScore(hand);
		}
		else
		{
			return 0;
		}	
	}
	
	/**
	  * Returns the score value by using the getPotentialScore() method 
	  *   
	  * @return boolean instance varable that tells whether or not the object already has a given score    
	  */	
	public boolean isFilled()
	{
		return filled;
	}
	
	/**
	  * Finds whether or not the dice values meet the subclass's criteria.  It's implementation is defined by the subclass
	  *   
	  * @return boolean value based on the subclass's dice values
	  */		
	public abstract boolean isSatisfiedBy(Hand dice);
	
	/**
	  * Returns the score value with implementation through the subclass
	  *   
	  * @return possible score if Hand instance field meets certain criteria
	  */	
	public abstract int getPotentialScore(Hand dice);
}