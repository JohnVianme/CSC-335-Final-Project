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

        // call meth