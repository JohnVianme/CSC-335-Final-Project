/*
 * a class with static methods used to check if a roll of die meets the criteria
 * of certain scoring categories
 *
 * categories checked: three of a kind, four of a kind, full house, small straight,
 * large straight, yahtzee
 *
 * @authors Garret W., John I., Dylan C. Jason B.
 */

import static org.junit.jupiter.api.Assertions.assertAll;

import java.awt.desktop.AboutHandler;
import java.util.*;

public class CheckRollType {

	/*
	 * checks if a collection of DiceEnums contains 3 of a kind that is, 3 dice with
	 * the same value
	 *
	 * @param dices - an array of DiceEnums
	 */
	public static boolean threeOfAKind(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		HashMap<Integer, Integer> counts = new HashMap<>();

		// count the occurrences
		// if no hashmap key associated with the value, sets it to 1
		// else increments the count by 1
		for (DiceEnum dice : dices) {
			counts.put(dice.getValue(), counts.getOrDefault(dice.getValue(), 0) + 1);
		}

		// check for any dice with a count of 3
		for (int count : counts.values()) {
			if (count == 3) {
				return true;
			}
		}

		return false;
	}

	public static int getThreeOfAKind(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		int score = 0;
		for (DiceEnum dice : dices) {
			score += dice.getValue();
		}
		return score;
	}

	/*
	 * checks if a collection of DiceEnums contains 4 of a kind that is, 4 dice with
	 * the same value
	 *
	 * @param dices - an array of DiceEnums
	 */
	public static boolean fourOfAKind(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		HashMap<Integer, Integer> counts = new HashMap<>();

		for (DiceEnum dice : dices) {
			counts.put(dice.getValue(), counts.getOrDefault(dice.getValue(), 0) + 1);
		}

		for (int count : counts.values()) {
			if (count == 4) {
				return true;
			}
		}

		return false;
	}

	public static int getFourOfAKind(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		int score = 0;
		for (DiceEnum dice : dices) {
			score += dice.getValue();
		}
		return score;
	}

	/*
	 * checks if a collection of DiceEnums contains a full house that is, 3 dice of
	 * the same value and 2 other dice of the same value
	 *
	 * @param dices - an array of DiceEnums
	 */
	public static boolean fullHouse(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		HashMap<Integer, Integer> counts = new HashMap<>();

		for (DiceEnum dice : dices) {
			counts.put(dice.getValue(), counts.getOrDefault(dice.getValue(), 0) + 1);
		}

		// full house should only have two kinds of dice
		// one should have a count of 3, other count of 2
		if (counts.values().size() == 2) {
			return counts.containsValue(2) && counts.containsValue(3);
		}

		return false;
	}

	public static int getFullHouse(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		return 25;
	}

	/*
	 * checks if a collection of DiceEnums contains a small straight that is, 4 dice
	 * of consecutive value
	 *
	 * @param dices - an array of DiceEnums
	 */
	public static boolean smallStraight(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		// sort array of dice
		Collections.sort(dices);

		// track number of dice in order
		int counter = 0;

		for (int i = 0; i < dices.size() - 1; i++) {
			// next dice value is one more than current dice value -> increment counter
			if (dices.get(i).getValue() + 1 == dices.get(i + 1).getValue()) {
				counter++;
			}
			// next dice value is same as current dice value
			else if (dices.get(i + 1).getValue() == dices.get(i).getValue()) {
				continue;
			}
			// next dice value is more than current dice value + 1 -> reset counter
			else {
				counter = 0;
			}

			// if counter gets to 3, have found four consecutive dice
			if (counter == 3) {
				return true;
			}
		}

		return false;
	}

	public static int getSmallStraight(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		return 30;
	}

	/*
	 * checks if a collection of DiceEnums contains a large straight that is, 5 dice
	 * of consecutive value
	 *
	 * @param dices - an array of DiceEnums
	 */
	public static boolean largeStraight(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		// sort array of dice
		Collections.sort(dices);

		// only have 5 dice so all must be consecutive
		for (int i = 0; i < dices.size() - 1; i++) {
			// next dice value is more than current dice + 1 -> cant be large straight
			if (dices.get(i).getValue() + 1 != dices.get(i + 1).getValue()) {
				return false;
			}
		}

		return true;
	}

	public static int getLargeStraight(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		return 40;
	}

	/*
	 * checks if a collection of DiceEnums contains a Yahtzee that is, all 5 dice
	 * have the same value
	 *
	 * @param dices - an array of DiceEnums
	 */
	public static boolean yahtzee(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;

		// value to check against
		int diceValue = dices.get(0).getValue();

		for (int i = 1; i < dices.size(); i++) {
			// found a dice value not equal to the others
			if (dices.get(i).getValue() != diceValue) {
				return false;
			}
		}

		return true;
	}

	/*
	 * This method returns the score for the yahtzee catagory base on the dices
	 * 
	 * @pre dices != null && dices.size() == 5
	 * 
	 * @return the score for the catagory
	 */
	public static int getYahtzee(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;
		if (yahtzee(dices)) {
			return 50;
		}
		return 0;
	}

	/*
	 * This method returns the score for the chance catagory base on the dices
	 * 
	 * @pre dices != null && dices.size() == 5
	 * 
	 * @return the score for the catagory
	 */
	public static int getChance(ArrayList<DiceEnum> dices) {
		assert dices != null && dices.size() == 5;
		int score = 0;
		for (DiceEnum dice : dices) {
			score += dice.getValue();
		}
		return score;
	}

	/*
	 * Method returns the score of the upper section scores given the hand and the
	 * interger value of the upper section.
	 * 
	 * @pre ices != null
	 * 
	 * @pre diceType < 7 && diceType > 0
	 * 
	 * @return the score for the that diceType upper section
	 */
	public static int getUpperSection(ArrayList<DiceEnum> dices, DiceEnum diceType) {
		assert dices != null && diceType.getValue() < 7 && diceType.getValue() > 0;
		int score = 0;
		for (DiceEnum dice : dices) {
			if (dice == diceType) {
				score += dice.getValue();
			}
		}
		return score;
	}
}
