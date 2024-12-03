/*
 * a suite of unit tests for the CheckRollType class
 *
 * @authors Garret W., John I., Dylan C. Jason B.
 */

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckRollTypeTest {
    // a collection to add dice to and all dice types
    ArrayList<DiceEnum> dice = new ArrayList<>();
    DiceEnum one = DiceEnum.ONE;
    DiceEnum two = DiceEnum.TWO;
    DiceEnum three = DiceEnum.THREE;
    DiceEnum four = DiceEnum.FOUR;
    DiceEnum five = DiceEnum.FIVE;
    DiceEnum six = DiceEnum.SIX;


    @Test
    public void threeOfAKindTest_notThreeOfAKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ensure dice roll is not three of a kind
        assertFalse(CheckRollType.threeOfAKind(dice));
    }

    @Test
    public void threeOfAKindTest_notThreeOfAKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ensure dice roll is not three of a kind
        assertFalse(CheckRollType.threeOfAKind(dice));
    }

    @Test
    public void threeOfAKindTest_isThreeOfKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(three);
        dice.add(four);

        // ensure dice roll is three of a kind
        assertTrue(CheckRollType.threeOfAKind(dice));
    }

    @Test
    public void threeOfAKindTest_isThreeOfKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(two);
        dice.add(five);

        // ensure dice roll is three of a kind
        assertTrue(CheckRollType.threeOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_notFourOfAKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(four);
        dice.add(five);

        // ensure roll is not four of a kind
        assertFalse(CheckRollType.fourOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_notFourOfAKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ensure roll is not four of a kind
        assertFalse(CheckRollType.fourOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_isFourOfAKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(five);

        // ensure roll a four of a kind
        assertTrue(CheckRollType.fourOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_isFourOfAKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(four);
        dice.add(four);
        dice.add(four);
        dice.add(four);
        dice.add(six);

        // ensure roll a four of a kind
        assertTrue(CheckRollType.fourOfAKind(dice));
    }

    @Test
    public void fullHouseTest_notFullHouse_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ensure roll is not a full house
        assertFalse(CheckRollType.fullHouse(dice));
    }

    @Test
    public void fullHouseTest_notFullHouse_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(five);
        dice.add(five);
        dice.add(six);
        dice.add(six);
        dice.add(one);

        // ensure roll is not a full house
        assertFalse(CheckRollType.fullHouse(dice));
    }

    @Test
    public void fullHouseTest_isFullHouse_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(four);
        dice.add(four);

        // ensure roll is a full house
        assertTrue(CheckRollType.fullHouse(dice));
    }

    @Test
    public void fullHouseTest_isFullHouse_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(five);
        dice.add(five);
        dice.add(five);
        dice.add(six);
        dice.add(six);

        // ensure roll is a full house
        assertTrue(CheckRollType.fullHouse(dice));
    }

    @Test
    public void smallStraightTest_notSmallStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(three);
        dice.add(five);

        // ensure roll is not a small straight
        assertFalse(CheckRollType.smallStraight(dice));
    }

    @Test
    public void smallStraightTest_notSmallStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(two);
        dice.add(four);
        dice.add(six);

        // ensure roll is not a small straight
        assertFalse(CheckRollType.smallStraight(dice));
    }

    @Test
    public void smallStraightTest_isSmallStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(one);

        // ensure roll is a small straight
        assertTrue(CheckRollType.smallStraight(dice));
    }

    @Test
    public void smallStraightTest_isSmallStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(three);

        // ensure roll is a small straight
        assertTrue(CheckRollType.smallStraight(dice));
    }

    @Test
    public void smallStraightTest_isSmallStraight_v3() {
        // make collection of 5 dice to mimic a roll
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(six);
        dice.add(one);

        // ensure roll is a small straight
        assertTrue(CheckRollType.smallStraight(dice));
    }

    @Test
    public void largeStraightTest_notLargeStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);

        // ensure roll is not a large straight
        assertFalse(CheckRollType.largeStraight(dice));
    }

    @Test
    public void largeStraightTest_notLargeStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(four);

        // ensure roll is not a large straight
        assertFalse(CheckRollType.largeStraight(dice));
    }

    @Test
    public void largeStraightTest_isLargeStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ensure roll is a large straight
        assertTrue(CheckRollType.largeStraight(dice));
    }

    @Test
    public void largeStraightTest_isLargeStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(six);

        // ensure roll is a large straight
        assertTrue(CheckRollType.largeStraight(dice));
    }

    @Test
    public void yahtzeeTest_notYahtzee_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // ensure roll is not a Yahtzee
        assertFalse(CheckRollType.yahtzee(dice));
    }

    @Test
    public void yahtzeeTest_isYahtzee_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(six);

        // ensure roll is a Yahtzee
        assertTrue(CheckRollType.yahtzee(dice));
    }
}
