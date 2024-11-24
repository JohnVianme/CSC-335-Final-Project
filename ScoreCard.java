/*
 * The scorecard that tracks 13 score categories for a Yahtzee game
 *
 * @authors Garret W., John I., Dylan C. Jason B.
 */

import java.util.*;

import static java.util.Collections.unmodifiableList;

public class ScoreCard {

    //
    // instance variable
    //
    public final HashMap<Category, Integer> scorecard = new HashMap<>();

    //
    // constructor
    //
    public ScoreCard() {
        // fill hashmap with each category of the scorecard and null
        for (Category cat : Category.values()) {
            scorecard.put(cat, null);
        }
    }

    /*
     * fill category of the scorecard using a Hand objects content
     *
     * @param hand: a Hand object with field aHand -> list of DiceEnum objects
     * @param cat: the scoring category to be filled
     */
    public void fillCategory(Hand hand, Category cat) {
        int score = 0;

        // get score from array of dice in hand
        for (DiceEnum dice : hand.getHand()) {
            score += dice.getValue();
        }

        // fill scorecard category with score value
        scorecard.put(cat, score);
    }

    /*
     * get a list of scoring categories yet to be filled
     *
     * @return unmodifiable list of scoring categories
     */
    public List<Category> getUnfilledCategories() {
        ArrayList<Category> unfilledCategories = new ArrayList<>();

        for (Category cat : scorecard.keySet()) {
            if (scorecard.get(cat) == null) {
                unfilledCategories.add(cat);
            }
        }

        return unmodifiableList(unfilledCategories);
    }

    /*
     * add the scores from each category to get grand total
     *
     * shouldn't be called until end of game when all categories have been filled, thus
     * no categories will have null value
     */
    public int getGrandTotal() {
        int grandTotal = 0;

        for (Category cat : scorecard.keySet()) {
            grandTotal += scorecard.get(cat);
        }

        return grandTotal;
    }
    
}
