/*
 * a class with static methods used to check if a roll of die meets the criteria
 * of certain scoring categories
 *
 * categories checked: three of a kind, four of a kind, full house, small straight,
 * large straight, yahtzee
 *
 * @authors Garret W., John I., Dylan C. Jason B.
 */

import java.util.*;

public class CheckRollType {

    /*
     * checks if a collection of DiceEnums contains 3 of a kind
     * that is, 3 dice with the same value
     *
     * @param dices - an array of DiceEnums
     */
    public static boolean threeOfAKind(ArrayList<DiceEnum> dices) {
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

    /*
     * checks if a collection of DiceEnums contains 4 of a kind
     * that is, 4 dice with the same value
     *
     * @param dices - an array of DiceEnums
     */
    public static boolean fourOfAKind(ArrayList<DiceEnum> dices) {
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

    /*
     * checks if a collection of DiceEnums contains a full house
     * that is, 3 dice of the same value and 2 other dice of the same value
     *
     * @param dices - an array of DiceEnums
     */
    public static boolean fullHouse(ArrayList<DiceEnum> dices) {
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

    /*
     * checks if a collection of DiceEnums contains a small straight
     * that is, 4 dice of consecutive value
     *
     * @param dices - an array of DiceEnums
     */
    public static boolean smallStraight(ArrayList<DiceEnum> dices) {
        // sort array of dice
        Collections.sort(dices);

        // track number of dice in order
        int counter = 0;

        for (int i=0; i<dices.size()-1; i++) {
            // next dice value is one more than current dice value  ->  increment counter
            if (dices.get(i).getValue() + 1 == dices.get(i + 1).getValue()) {
                counter++;
            }
            // next dice value is same as current dice value
            else if (dices.get(i + 1).getValue() == dices.get(i).getValue()) {
                continue;
            }
            // next dice value is more than current dice value + 1  ->  reset counter
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

    /*
     * checks if a collection of DiceEnums contains a large straight
     * that is, 5 dice of consecutive value
     *
     * @param dices - an array of DiceEnums
     */
    public static boolean largeStraight(ArrayList<DiceEnum> dices) {
        // sort array of dice
        Collections.sort(dices);

        // only have 5 dice so all must be consecutive
        for (int i=0; i<dices.size()-1; i++) {
            // next dice value is more than current dice + 1  ->  cant be large straight
            if (dices.get(i).getValue() + 1 != dices.get(i + 1).getValue()) {
                return false;
            }
        }

        return true;
    }

    /*
     * checks if a collection of DiceEnums contains a Yahtzee
     * that is, all 5 dice have the same value
     *
     * @param dices - an array of DiceEnums
     */
    public static boolean yahtzee(ArrayList<DiceEnum> dices) {
        // value to check against
        int diceValue = dices.get(0).getValue();

        for (int i=1; i<dices.size(); i++) {
            // found a dice value not equal to the others
            if (dices.get(i).getValue() != diceValue) {
                return false;
            }
        }

        return true;
    }
}
