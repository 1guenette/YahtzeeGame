package hw3;

import java.util.Arrays;

import hw3.api.Category;

public class Tester {
	public static void main(String[]args)
	{
		
		
		int[] test = {1, 1, 1, 1, 1};
		 Hand dice = new Hand(5, 6, 3, test);
		 Category cat = new Chance("Count threes");
		 System.out.println(cat.isSatisfiedBy(dice)); // should be true
		 System.out.println(cat.getPotentialScore(dice)); // should be 9
		 System.out.println(cat.getScore()); // should be zero
		 cat.fill(dice);
		 System.out.println(cat.getScore()); // should be nine
		 System.out.println();
		 
	
		
		 int[] test2 = {3, 3, 3, 5, 6};
		 Hand dice2 = new Hand(5, 6, 3, test2);
		 int[] avail = dice2.getAvailableDice();
		 System.out.println("ava: "+Arrays.toString(avail)); // [3, 3, 3, 5, 6]
		 int[] fixed = dice2.getFixedDice();
		 System.out.println("fix: "+Arrays.toString(fixed)); // []
		 dice2.keep(3);
		 dice2.keep(5);
		 int[] avail2 = dice2.getAvailableDice();
		 System.out.println(Arrays.toString(avail2)); // [3, 3, 6]
		 int[] fixed2 = dice2.getFixedDice();
		 System.out.println(Arrays.toString(fixed2)); // [3, 5]
		 System.out.println(dice2); // 3 3 6 (3 5)
		 dice2.keepAll();
		 avail2 = dice2.getAvailableDice();
		 fixed2 = dice2.getFixedDice();
		 System.out.println(Arrays.toString(avail2)); // []
		 System.out.println(Arrays.toString(fixed2)); // [3,3,3,5,6]
		 System.out.println(dice2); // (3 3 6 3 5)
	}

}
