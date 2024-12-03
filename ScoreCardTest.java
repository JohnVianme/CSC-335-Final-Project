/*
 * a suite of unit tests for the ScoreCard class
 *
 * @authors Garret W., John I., Dylan C. Jason B.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ScoreCardTest {
    // a collection to add dice to and all dice types
    ArrayList<DiceEnum> dice = new ArrayList<>();
    DiceEnum one = DiceEnum.ONE;
    DiceEnum two = DiceEnum.TWO;
    DiceEnum three = DiceEnum.THREE;
    DiceEnum four = DiceEnum.FOUR;
    DiceEnum five = DiceEnum.FIVE;
    DiceEnum six = DiceEnum.SIX;

    // a score card object
    ScoreCard scorecard = new ScoreCard();


    @Test
    public void getCategoryScoreTest_noScore() {
        // ensure scorecard category is null when no score has been saved
        assertNull(scorecard.getCategoryScore(Category.ONES));
    }

    @Test
    public void getCategoryScoreTest_hasScore() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(two);

        // call method to fill scorecard ones category
        scorecard.fillCategory(dice, Category.ONES);

        // ensure scorecard ones category has correct score value saved
        assertEquals(4, scorecard.getCategoryScore(Category.ONES));
    }

    @Test
    public void fillCategoryTest_Ones_noOnes() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(six);

        // call method to fill scorecard ones category
        scorecard.fillCategory(dice, Category.ONES);

        // ensure scorecard ones category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.ONES));
    }

    @Test
    public void fillCategoryTest_Ones_hasOnes() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(five);
        dice.add(four);
        dice.add(three);
        dice.add(two);

        // call method to fill scorecard ones category
        scorecard.fillCategory(dice, Category.ONES);

        // ensure scorecard ones category has correct score
        assertEquals(1, scorecard.getCategoryScore(Category.ONES));
    }

    @Test
    public void fillCategoryTest_Twos_noTwos() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(six);

        // call method to fill scorecard twos category
        scorecard.fillCategory(dice, Category.TWOS);

        // ensure scorecard twos category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.TWOS));
    }

    @Test
    public void fillCategoryTest_Twos_hasTwos() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(four);
        dice.add(three);
        dice.add(two);

        // call method to fill scorecard twos category
        scorecard.fillCategory(dice, Category.TWOS);

        // ensure scorecard twos category has correct score
        assertEquals(4, scorecard.getCategoryScore(Category.TWOS));
    }

    @Test
    public void fillCategoryTest_Threes_noThrees() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(four);
        dice.add(five);
        dice.add(six);

        // call method to fill scorecard threes category
        scorecard.fillCategory(dice, Category.THREES);

        // ensure scorecard threes category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.THREES));
    }

    @Test
    public void fillCategoryTest_Threes_hasThrees() {
        // make collection of 5 dice to mimic a roll
        dice.add(three);
        dice.add(three);
        dice.add(three);
        dice.add(five);
        dice.add(six);

        // call method to fill scorecard threes category
        scorecard.fillCategory(dice, Category.THREES);

        // ensure scorecard threes category has correct score
        assertEquals(9, scorecard.getCategoryScore(Category.THREES));
    }

    @Test
    public void fillCategoryTest_Fours_noFours() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(five);
        dice.add(five);
        dice.add(six);

        // call method to fill scorecard fours category
        scorecard.fillCategory(dice, Category.FOURS);

        // ensure scorecard fours category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.FOURS));
    }

    @Test
    public void fillCategoryTest_Fours_hasFours() {
        // make collection of 5 dice to mimic a roll
        dice.add(four);
        dice.add(four);
        dice.add(three);
        dice.add(five);
        dice.add(six);

        // call method to fill scorecard fours category
        scorecard.fillCategory(dice, Category.FOURS);

        // ensure scorecard fours category has correct score
        assertEquals(8, scorecard.getCategoryScore(Category.FOURS));
    }

    @Test
    public void fillCategoryTest_Fives_noFives() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(four);
        dice.add(four);
        dice.add(six);

        // call method to fill scorecard fives category
        scorecard.fillCategory(dice, Category.FIVES);

        // ensure scorecard fives category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.FIVES));
    }

    @Test
    public void fillCategoryTest_Fives_hasFives() {
        // make collection of 5 dice to mimic a roll
        dice.add(four);
        dice.add(four);
        dice.add(five);
        dice.add(five);
        dice.add(five);

        // call method to fill scorecard fives category
        scorecard.fillCategory(dice, Category.FIVES);

        // ensure scorecard fives category has correct score
        assertEquals(15, scorecard.getCategoryScore(Category.FIVES));
    }

    @Test
    public void fillCategoryTest_Sixes_noSixes() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(four);
        dice.add(four);
        dice.add(one);

        // call method to fill scorecard sixes category
        scorecard.fillCategory(dice, Category.SIXES);

        // ensure scorecard sixes category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.SIXES));
    }

    @Test
    public void fillCategoryTest_Sixes_hasSixes() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(five);

        // call method to fill scorecard sixes category
        scorecard.fillCategory(dice, Category.SIXES);

        // ensure scorecard sixes category has correct score
        assertEquals(24, scorecard.getCategoryScore(Category.SIXES));
    }

    @Test
    public void fillCategoryTest_ThreeOfAKind_noThreeOfAKind() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(five);
        dice.add(one);
        dice.add(six);
        dice.add(five);

        // call method to fill scorecard three of a kind category
        scorecard.fillCategory(dice, Category.THREEOFKIND);

        // ensure scorecard three of a kind category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.THREEOFKIND));
    }

    @Test
    public void fillCategoryTest_ThreeOfAKind_hasThreeOfAKind() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(one);
        dice.add(six);
        dice.add(five);

        // call method to fill scorecard three of a kind category
        scorecard.fillCategory(dice, Category.THREEOFKIND);

        // ensure scorecard three of a kind category has correct score
        assertEquals(24, scorecard.getCategoryScore(Category.THREEOFKIND));
    }

    @Test
    public void fillCategoryTest_FourOfAKind_noFourOfAKind() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(one);
        dice.add(six);
        dice.add(five);

        // call method to fill scorecard four of a kind category
        scorecard.fillCategory(dice, Category.FOUROFKIND);

        // ensure scorecard four of a kind category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.FOUROFKIND));
    }

    @Test
    public void fillCategoryTest_FourOfAKind_hasFourOfAKind() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(five);

        // call method to fill scorecard four of a kind category
        scorecard.fillCategory(dice, Category.FOUROFKIND);

        // ensure scorecard four of a kind category has correct score
        assertEquals(9, scorecard.getCategoryScore(Category.FOUROFKIND));
    }

    @Test
    public void fillCategoryTest_FullHouse_noFullHouse() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(two);
        dice.add(one);
        dice.add(five);

        // call method to fill scorecard full house category
        scorecard.fillCategory(dice, Category.FULLHOUSE);

        // ensure scorecard full house category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.FULLHOUSE));
    }

    @Test
    public void fillCategoryTest_FullHouse_hasFullHouse() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(five);
        dice.add(five);

        // call method to fill scorecard full house category
        scorecard.fillCategory(dice, Category.FULLHOUSE);

        // ensure scorecard full house category has correct score
        assertEquals(25, scorecard.getCategoryScore(Category.FULLHOUSE));
    }

    @Test
    public void fillCategoryTest_SmallStraight_noSmallStraight() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(five);
        dice.add(five);

        // call method to fill scorecard small straight category
        scorecard.fillCategory(dice, Category.SMALLSTRAIGHT);

        // ensure scorecard small straight category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.SMALLSTRAIGHT));
    }

    @Test
    public void fillCategoryTest_SmallStraight_hasSmallStraight() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(one);

        // call method to fill scorecard small straight category
        scorecard.fillCategory(dice, Category.SMALLSTRAIGHT);

        // ensure scorecard small straight category has correct score
        assertEquals(30, scorecard.getCategoryScore(Category.SMALLSTRAIGHT));
    }

    @Test
    public void fillCategoryTest_LargeStraight_noLargeStraight() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(one);

        // call method to fill scorecard large straight category
        scorecard.fillCategory(dice, Category.LARGESTRAIGHT);

        // ensure scorecard large straight category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.LARGESTRAIGHT));
    }

    @Test
    public void fillCategoryTest_LargeStraight_hasLargeStraight() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // call method to fill scorecard large straight category
        scorecard.fillCategory(dice, Category.LARGESTRAIGHT);

        // ensure scorecard large straight category has correct score
        assertEquals(40, scorecard.getCategoryScore(Category.LARGESTRAIGHT));
    }

    @Test
    public void fillCategory_Yahtzee_noYahtzee() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // call method to fill scorecard yahtzee category
        scorecard.fillCategory(dice, Category.YAHTZEE);

        // ensure scorecard yahtzee category has correct score
        assertEquals(0, scorecard.getCategoryScore(Category.YAHTZEE));
    }

    @Test
    public void fillCategory_Yahtzee_hasYahtzee() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(one);

        // call method to fill scorecard yahtzee category
        scorecard.fillCategory(dice, Category.YAHTZEE);

        // ensure scorecard yahtzee category has correct score
        assertEquals(50, scorecard.getCategoryScore(Category.YAHTZEE));
    }

    @Test
    public void fillCategoryTest_Chance() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(two);
        dice.add(two);
        dice.add(three);

        scorecard.fillCategory(dice, Category.CHANCE);

        assertEquals(9, scorecard.getCategoryScore(Category.CHANCE));
    }

    @Test
    public void checkForBonusTest_noBonus() {
        // make a roll and use it to fill multiple categories for simplicity
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ones category = 1, twos category = 2, threes category = 3, fours category = 4
        // fives category = 5, sixes category = 0
        scorecard.fillCategory(dice, Category.ONES);
        scorecard.fillCategory(dice, Category.TWOS);
        scorecard.fillCategory(dice, Category.THREES);
        scorecard.fillCategory(dice, Category.FOURS);
        scorecard.fillCategory(dice, Category.FIVES);
        scorecard.fillCategory(dice, Category.SIXES);

        // checks if meets bonus criteria and applies bonus if met
        scorecard.checkForBonus();

        // ensure no bonus was applied
        assertEquals(0, scorecard.getCategoryScore(Category.BONUS));
    }

    @Test
    public void checkForBonusTest_hasBonus() {
        // have to make multiple rolls to get higher score for bonus
        ArrayList<DiceEnum> roll1 = new ArrayList<>();
        roll1.add(one);
        roll1.add(one);
        roll1.add(one);
        roll1.add(one);
        roll1.add(five);
        scorecard.fillCategory(roll1, Category.ONES);

        ArrayList<DiceEnum> roll2 = new ArrayList<>();
        roll2.add(two);
        roll2.add(two);
        roll2.add(two);
        roll2.add(two);
        roll2.add(one);
        scorecard.fillCategory(roll2, Category.TWOS);

        ArrayList<DiceEnum> roll3 = new ArrayList<>();
        roll3.add(three);
        roll3.add(three);
        roll3.add(three);
        roll3.add(three);
        roll3.add(six);
        scorecard.fillCategory(roll3, Category.THREES);

        ArrayList<DiceEnum> roll4 = new ArrayList<>();
        roll4.add(four);
        roll4.add(four);
        roll4.add(four);
        roll4.add(four);
        roll4.add(two);
        scorecard.fillCategory(roll4, Category.FOURS);

        ArrayList<DiceEnum> roll5 = new ArrayList<>();
        roll5.add(five);
        roll5.add(five);
        roll5.add(five);
        roll5.add(five);
        roll5.add(six);
        scorecard.fillCategory(roll5, Category.FIVES);

        ArrayList<DiceEnum> roll6 = new ArrayList<>();
        roll6.add(six);
        roll6.add(one);
        roll6.add(one);
        roll6.add(one);
        roll6.add(two);
        scorecard.fillCategory(roll6, Category.SIXES);

        scorecard.checkForBonus();

        assertEquals(35, scorecard.getCategoryScore(Category.BONUS));
    }

    @Test
    public void getUnfilledCategoriesTest_allUnfilled() {
        assertEquals(13, scorecard.getUnfilledCategories().size());
    }

    @Test
    public void getUnfilledCategoriesTest_someFilled() {
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        scorecard.fillCategory(dice, Category.ONES);
        scorecard.fillCategory(dice, Category.TWOS);
        scorecard.fillCategory(dice, Category.SIXES);
        scorecard.fillCategory(dice, Category.LARGESTRAIGHT);
        scorecard.fillCategory(dice, Category.FULLHOUSE);

        assertEquals(8, scorecard.getUnfilledCategories().size());
    }

    @Test
    public void getGrandTotalTest_noScores() {
        // ensure grand-total is 0 when no scores have been filled
        assertEquals(0, scorecard.getGrandTotal());
    }

    @Test
    public void getGrandTotal_someScores() {
        // make a roll and use it to fill all categories for simplicity
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        scorecard.fillCategory(dice, Category.ONES);
        scorecard.fillCategory(dice, Category.TWOS);
        scorecard.fillCategory(dice, Category.THREES);
        scorecard.fillCategory(dice, Category.FOURS);
        scorecard.fillCategory(dice, Category.FIVES);
        scorecard.fillCategory(dice, Category.SIXES);
        scorecard.fillCategory(dice, Category.THREEOFKIND);
        scorecard.fillCategory(dice, Category.FOUROFKIND);
        scorecard.fillCategory(dice, Category.FULLHOUSE);
        scorecard.fillCategory(dice, Category.SMALLSTRAIGHT);
        scorecard.fillCategory(dice, Category.LARGESTRAIGHT);
        scorecard.fillCategory(dice, Category.YAHTZEE);
        scorecard.fillCategory(dice, Category.CHANCE);

        assertEquals(100, scorecard.getGrandTotal());
    }

    @Test
    public void getScoreCardCopyTest_noCategoriesFilled() {
        // get copy of scorecard hashmap
        HashMap<Category, Integer> scoreCardCopy = scorecard.getScoreCardCopy();

        // ensure all categories are null
        assertNull(scoreCardCopy.get(Category.ONES));
        assertNull(scoreCardCopy.get(Category.TWOS));
        assertNull(scoreCardCopy.get(Category.THREES));
        assertNull(scoreCardCopy.get(Category.FOURS));
        assertNull(scoreCardCopy.get(Category.FIVES));
        assertNull(scoreCardCopy.get(Category.SIXES));
        assertNull(scoreCardCopy.get(Category.THREEOFKIND));
        assertNull(scoreCardCopy.get(Category.FOUROFKIND));
        assertNull(scoreCardCopy.get(Category.FULLHOUSE));
        assertNull(scoreCardCopy.get(Category.SMALLSTRAIGHT));
        assertNull(scoreCardCopy.get(Category.LARGESTRAIGHT));
        assertNull(scoreCardCopy.get(Category.YAHTZEE));
        assertNull(scoreCardCopy.get(Category.CHANCE));
    }

    @Test
    public void getScoreCardCopyTest_someCategoriesFilled() {
        // make a roll and use it to fill multiple categories for simplicity
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        scorecard.fillCategory(dice, Category.ONES);
        scorecard.fillCategory(dice, Category.TWOS);
        scorecard.fillCategory(dice, Category.FULLHOUSE);
        scorecard.fillCategory(dice, Category.LARGESTRAIGHT);
        scorecard.fillCategory(dice, Category.FIVES);
        scorecard.fillCategory(dice, Category.CHANCE);

        // get copy of scorecard hashmap
        HashMap<Category, Integer> scoreCardCopy = scorecard.getScoreCardCopy();

        // were filled
        assertEquals(1, scoreCardCopy.get(Category.ONES));
        assertEquals(2, scoreCardCopy.get(Category.TWOS));
        assertEquals(0, scoreCardCopy.get(Category.FULLHOUSE));
        assertEquals(40, scoreCardCopy.get(Category.LARGESTRAIGHT));
        assertEquals(5, scoreCardCopy.get(Category.FIVES));
        assertEquals(15, scoreCardCopy.get(Category.CHANCE));

        // were not filled
        assertNull(scoreCardCopy.get(Category.THREES));
        assertNull(scoreCardCopy.get(Category.FOURS));
        assertNull(scoreCardCopy.get(Category.SIXES));
        assertNull(scoreCardCopy.get(Category.THREEOFKIND));
        assertNull(scoreCardCopy.get(Category.FOUROFKIND));
        assertNull(scoreCardCopy.get(Category.SMALLSTRAIGHT));
        assertNull(scoreCardCopy.get(Category.YAHTZEE));
    }
}
