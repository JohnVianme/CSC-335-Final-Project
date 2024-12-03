/*
 * The scorecard that tracks 13 score categories for a Yahtzee game
 *
 * categories: ones, twos, threes, fours, fives, sixes, bonus, three of a kind,
 * four of a kind, full house, small straight, large straight, yahtzee
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
        // required so doesn't appear in unfilled categories
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
        // score category is ONES, add up all dice with value of 1 for score
        if (cat == Category.ONES) {
            int onesScore = CheckRollType.getUpperSection(dices, DiceEnum.ONE);
            scorecard.put(cat, onesScore);
        }

        // score category is TWOS, add up all dice with value of 2 for score
        else if (cat == Category.TWOS) {
            int twosScore = CheckRollType.getUpperSection(dices, DiceEnum.TWO);
            scorecard.put(cat, twosScore);
        }

        // score category is THREES, add up all dice with value of 3 for score
        else if (cat == Category.THREES) {
            int threesScore = CheckRollType.getUpperSection(dices, DiceEnum.THREE);
            scorecard.put(cat, threesScore);
        }

        // score category is FOURS, add up all dice with value of 4 for score
        else if (cat == Category.FOURS) {
            int foursScore = CheckRollType.getUpperSection(dices, DiceEnum.FOUR);
            scorecard.put(cat, foursScore);
        }

        // score category is FIVES, add up all dice with value of 5 for score
        else if (cat == Category.FIVES) {
            int fivesScore = CheckRollType.getUpperSection(dices, DiceEnum.FIVE);
            scorecard.put(cat, fivesScore);
        }

        // score category is SIXES, add up all dice with value of 6 for score
        else if (cat == Category.SIXES) {
            int sixesScore = CheckRollType.getUpperSection(dices, DiceEnum.SIX);
            scorecard.put(cat, sixesScore);
        }

        // score category is THREE OF A KIND
        // call method to check valid three of a kind
        // if valid, add up all dice for score, else score is 0
        else if (cat == Category.THREEOFKIND) {
            int score = CheckRollType.getThreeOfAKind(dices);
            scorecard.put(cat, score);
        }

        // score category is FOUR OF A KIND
        // call method to check valid four of a kind
        // if valid, add up all dice for score, else score is 0
        else if (cat == Category.FOUROFKIND) {
            int score = CheckRollType.getFourOfAKind(dices);
            scorecard.put(cat, score);
        }

        // score category is FULL HOUSE
        // call method to check valid full house
        // if valid, score is 25, else score is 0
        else if (cat == Category.FULLHOUSE) {
            int score = CheckRollType.getFullHouse(dices);
            scorecard.put(cat, score);
        }

        // score category is SMALL STRAIGHT
        // call method to check valid small straight
        // if valid, score is 30, else score is 0
        else if (cat == Category.SMALLSTRAIGHT) {
            int score = CheckRollType.getSmallStraight(dices);
            scorecard.put(cat, score);
        }

        // score category is LARGE STRAIGHT
        // call method to check valid large straight
        // if valid, score is 40, else score is 0
        else if (cat == Category.LARGESTRAIGHT) {
            int score = CheckRollType.getLargeStraight(dices);
            scorecard.put(cat, score);
        }

        // score category is YAHTZEE
        // call method to check valid Yahtzee
        // if valid, score is 50, else score is 0
        else if (cat == Category.YAHTZEE) {
            int score = CheckRollType.getYahtzee(dices);
            scorecard.put(cat, score);
        }

        // score category is CHANCE, add up all dice for score
        else if (cat == Category.CHANCE) {
            int score = CheckRollType.getChance(dices);
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
     * @return int - grand-total from summing all categories
     */
    public int getGrandTotal() {
        int grandTotal = 0;

        for (Category cat : scorecard.keySet()) {
            if (scorecard.get(cat) == null) {
                grandTotal += 0;
            } else {
                grandTotal += scorecard.get(cat);
            }
        }

        return grandTotal;
    }

    /*
     * Returns copy of this scorecard
     *
     * @return HashMap - a copy of the ScoreCard objects HashMap of categories and scores
     */
	public HashMap<Category, Integer> getScoreCardCopy() {
		return new HashMap<Category, Integer>(scorecard);
	}
}
