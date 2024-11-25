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
            scorecard.put(cat, 0);
        }
    }

    /*
     * fill category of the scorecard using a Hand objects content
     *
     * use different methods for each category since they're each scored differently
     *
     * @param hand: a Hand object with field aHand -> list of DiceEnum objects
     * @param cat: the scoring category to be filled
     */
    public void fillCategory(ArrayList<DiceEnum> dices, Category cat) {
        int score = 0;

        if (cat == Category.ONES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 1) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        else if (cat == Category.TWOS) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 2) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        else if (cat == Category.THREES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 3) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        else if (cat == Category.FOURS) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 4) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        else if (cat == Category.FIVES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 5) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        else if (cat == Category.SIXES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 6) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        else if (cat == Category.THREEOFKIND) {
            return;
        }

        else if (cat == Category.FOUROFKIND) {

            return;
        }

        else if (cat == Category.FULLHOUSE) {

            return;
        }

        else if (cat == Category.SMALLSTRAIGHT) {

            return;
        }

        else if (cat == Category.LARGESTRAIGHT) {

            return;
        }

        else if (cat == Category.YAHTZEE) {

            return;
        }

        else if (cat == Category.CHANCE) {

            return;
        }
    }

    public void checkForBonus() {
        ArrayList<Category> topCategories = new ArrayList<>();
        topCategories.add(Category.ONES);
        topCategories.add(Category.TWOS);
        topCategories.add(Category.THREES);
        topCategories.add(Category.FOURS);
        topCategories.add(Category.FIVES);
        topCategories.add(Category.SIXES);

        int topScore = 0;

        for (Category cat : topCategories) {
            topScore += scorecard.get(cat);
        }

        if (topScore >= 63) {
            scorecard.put(Category.BONUS, 35);
        } else {
            scorecard.put(Category.BONUS, 0);
        }
    }

    public int getCategoryScore(Category cat) {
        return scorecard.get(cat);
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
