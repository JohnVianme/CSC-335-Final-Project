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
        // fill hashmap with each category of the scorecard with null
        for (Category cat : Category.values()) {
            scorecard.put(cat, null);
        }
        // set the BONUS Category to be 0
        scorecard.put(Category.BONUS, 0);
    }

    /*
     * fill category of the scorecard using an array of DiceEnums
     *
     * if-else chain for each category since scored uniquely
     *
     * @param dices: an array of DiceEnums
     * @param cat: the scoring category to be filled
     */
    public void fillCategory(ArrayList<DiceEnum> dices, Category cat) {
        // initialize score variable
        int score = 0;

        // score category is ONES, add up all dice with value of 1 for score
        if (cat == Category.ONES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 1) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        // score category is TWOS, add up all dice with value of 2 for score
        else if (cat == Category.TWOS) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 2) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        // score category is THREES, add up all dice with value of 3 for score
        else if (cat == Category.THREES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 3) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        // score category is FOURS, add up all dice with value of 4 for score
        else if (cat == Category.FOURS) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 4) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        // score category is FIVES, add up all dice with value of 5 for score
        else if (cat == Category.FIVES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 5) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        // score category is SIXES, add up all dice with value of 6 for score
        else if (cat == Category.SIXES) {
            for (DiceEnum dice : dices) {
                if (dice.getValue() == 6) {
                    score += dice.getValue();
                }
            }
            scorecard.put(cat, score);
        }

        // score category is THREE OF A KIND
        // call method to check valid three of a kind
        // if valid, add up all dice for score, else score is 0
        else if (cat == Category.THREEOFKIND) {
            if (CheckHandType.threeOfAKind(dices)) {
                for (DiceEnum dice : dices) {
                    score += dice.getValue();
                }
                scorecard.put(cat, score);
            } else {
                scorecard.put(cat, 0);
            }
        }

        // score category is FOUR OF A KIND
        // call method to check valid four of a kind
        // if valid, add up all dice for score, else score is 0
        else if (cat == Category.FOUROFKIND) {
            if (CheckHandType.fourOfAKind(dices)) {
                for (DiceEnum dice : dices) {
                    score += dice.getValue();
                }
                scorecard.put(cat, score);
            } else {
                scorecard.put(cat, 0);
            }
        }

        // score category is FULL HOUSE
        // call method to check valid full house
        // if valid, score is 25, else score is 0
        else if (cat == Category.FULLHOUSE) {
            if (CheckHandType.fullHouse(dices)) {
                scorecard.put(cat, 25);
            } else {
                scorecard.put(cat, 0);
            }
        }

        // score category is SMALL STRAIGHT
        // call method to check valid small straight
        // if valid, score is 30, else score is 0
        else if (cat == Category.SMALLSTRAIGHT) {
            if (CheckHandType.smallStraight(dices)) {
                scorecard.put(cat, 30);
            } else {
                scorecard.put(cat, 0);
            }
        }

        // score category is LARGE STRAIGHT
        // call method to check valid large straight
        // if valid, score is 40, else score is 0
        else if (cat == Category.LARGESTRAIGHT) {
            if (CheckHandType.largeStraight(dices)) {
                scorecard.put(cat, 40);
            } else {
                scorecard.put(cat, 0);
            }
        }

        // score category is YAHTZEE
        // call method to check valid Yahtzee
        // if valid, score is 50, else score is 0
        else if (cat == Category.YAHTZEE) {
            if (CheckHandType.yahtzee(dices)) {
                scorecard.put(cat, 50);
            } else {
                scorecard.put(cat, 0);
            }
        }

        // score category is CHANCE, add up all dice for score
        else if (cat == Category.CHANCE) {
            for (DiceEnum dice : dices) {
                score += dice.getValue();
            }
            scorecard.put(cat, score);
        }
    }

    /*
     * checks to see if a players scoring categories meet the requirements
     * for the bonus category
     */
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

    /*
     * returns the score of a category on the scorecard
     *
     * @params cat - a category on the scorecard
     *
     * @return int - the current value of the scoring category
     */
    public Integer getCategoryScore(Category cat) {
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
     * only adds filled categories, avoiding any null values
     */
    public int getGrandTotal() {
        int grandTotal = 0;

        for (Category cat : scorecard.keySet()) {
        	if (scorecard.get(cat) != null) {
        		grandTotal += scorecard.get(cat);
        	}
        }

        return grandTotal;
    }
    /*
     * Returns copy of this scorecard
     */
	public HashMap<Category, Integer> getScoreCardCopy() {
		// TODO Auto-generated method stub
		return new HashMap<Category, Integer>(scorecard);
	}
}
