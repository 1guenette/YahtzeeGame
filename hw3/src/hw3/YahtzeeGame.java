package hw3;

import java.util.ArrayList;
import java.util.Random;

import hw3.api.Category;

/**
 * @author Samuel Guenette
 * @date 4/29/2016 
 * 
 * Game state for a dice game such as Yahtzee. The game consists
 * of a list of <code>Category</code> objects, each of which is responsible
 * for keeping track of the dice used to satisfy it and of its own 
 * contribution to the total score. Clients interact directly with the
 * category objects, which are obtained using method <code>getCategories()</code>.
 * The total score for the game may be obtained via the <code>getScore</code>
 * method.  This class also keeps track of several game
 * attributes: the number of dice being used in the game, the maximum
 * value (number of "sides") of the dice, and the number of times the
 * dice may be rerolled in each round.
 */
public class YahtzeeGame
{
	/**
	 *Maximum number of dice
	 */		
	private int dieMax;
	
	/**
	 *Number of dice
	 */		
	private int dieNum;
	
	/**
	 *Maximum number of rolls
	 */		
	private int rollMax;
	
	/**
	 *The current number of rolls made
	 */		
	private int currentRoll;
	
	/**
	 *List of different categories based on different dice combinations matching the characteristics of Categeories subclasses
	 */		
	private ArrayList<Category> categories;
	
	/**
	 *Generates dice values when rolled
	 */		
	private Random rand;
	
	
  /**
   * Constructs a new YahtzeeGame based on the given parameters.  
   * Initially the list of categories is empty.
   * @param numDice
   *   number of dice used in this game
   * @param maxDieValue
   *   maximum face value (number of faces) for each die
   * @param numRolls
   *   number of times the dice can be rolled in each round
   */
  public YahtzeeGame(int numDice, int maxDieValue, int numRolls) 
  {
	  dieNum = numDice;
	  dieMax = maxDieValue;
	  rollMax = numRolls;
	  currentRoll = 0;
	  categories = new ArrayList<Category>();
	  rand = new Random();
  }
  
  /**
   * Adds a scoring category to this game.
   * @param category
   *   scoring category to add
   */
  public void addCategory(Category category)
  {
    categories.add(category);
  }
  
  
  /**
   * Returns the list of categories in this game.
   * @return
   *   list of categories 
   */
  public ArrayList<Category> getCategories()
  {
    return categories;
  }
  
  /**
   * Returns a new Hand corresponding to the number of dice,
   * maximum die value, and number of rolls for this game.
   * Initially all dice in the hand are available to be rolled.
   * @return
   *   new Hand based on this game's parameters
   */
  public Hand createNewHand()
  {
	Hand newHand = new Hand(dieNum, dieMax, rollMax);
    return newHand;
  }
  
  /**
   * Returns the current total score for all categories.
   * @return
   *   total score for all categories
   */
  public int getScore()
  {
    int score = 0;
    
	for(int i = 0; i<categories.size();i++)
    {
    	score += categories.get(i).getScore();
    }
	  return score;
  }
  
  /**
   * Returns the number of dice
   * @return
   *   value of dieNum
   */  
  protected int getNumDice()
  {
	  return dieNum;
  }
  
  /**
   * Returns the current the maximum number a dice can get to.
   * @return
   *   value of dieMax
   */ 
  protected int getDieMax()
  {
	  return dieMax;
  }
  

}
