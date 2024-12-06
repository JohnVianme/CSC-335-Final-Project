/*
 * a suite of unit tests for the CheckRollType class
 *
 * @authors Garret W., John I., Dylan C. Jason B.
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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

        // get score for the roll
        assertEquals(0, CheckRollType.getThreeOfAKind(dice));
    }

    @Test
    public void threeOfAKindTest_notThreeOfAKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // get score for the roll
        assertEquals(0, CheckRollType.getThreeOfAKind(dice));
    }

    @Test
    public void threeOfAKindTest_isThreeOfKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(three);
        dice.add(four);

        // get score for the roll
        assertEquals(10, CheckRollType.getThreeOfAKind(dice));
    }

    @Test
    public void threeOfAKindTest_isThreeOfKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(two);
        dice.add(five);

        // get score for the roll
        assertEquals(25, CheckRollType.getThreeOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_notFourOfAKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(one);
        dice.add(four);
        dice.add(five);

        // get score for the roll
        assertEquals(0, CheckRollType.getFourOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_notFourOfAKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // get score for the roll
        assertEquals(0, CheckRollType.getFourOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_isFourOfAKind_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(five);


        // get score for the roll
        assertEquals(13, CheckRollType.getFourOfAKind(dice));
    }

    @Test
    public void fourOfAKindTest_isFourOfAKind_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(four);
        dice.add(four);
        dice.add(four);
        dice.add(four);
        dice.add(six);

        // get score for the roll
        assertEquals(22, CheckRollType.getFourOfAKind(dice));
    }

    @Test
    public void fullHouseTest_notFullHouse_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // get score for the roll
        assertEquals(0, CheckRollType.getFullHouse(dice));
    }

    @Test
    public void fullHouseTest_notFullHouse_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(five);
        dice.add(five);
        dice.add(six);
        dice.add(six);
        dice.add(one);

        // get score for the roll
        assertEquals(0, CheckRollType.getFullHouse(dice));
    }

    @Test
    public void fullHouseTest_isFullHouse_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(two);
        dice.add(two);
        dice.add(four);
        dice.add(four);

        // get score for the roll
        assertEquals(25, CheckRollType.getFullHouse(dice));
    }

    @Test
    public void fullHouseTest_isFullHouse_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(five);
        dice.add(five);
        dice.add(five);
        dice.add(six);
        dice.add(six);

        // get score for the roll
        assertEquals(25, CheckRollType.getFullHouse(dice));
    }

    @Test
    public void smallStraightTest_notSmallStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(three);
        dice.add(five);

        // get score for the roll
        assertEquals(0, CheckRollType.getSmallStraight(dice));
    }

    @Test
    public void smallStraightTest_notSmallStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(two);
        dice.add(four);
        dice.add(six);

        // get score for the roll
        assertEquals(0, CheckRollType.getSmallStraight(dice));
    }

    @Test
    public void smallStraightTest_isSmallStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(one);

        // get score for the roll
        assertEquals(30, CheckRollType.getSmallStraight(dice));
    }

    @Test
    public void smallStraightTest_isSmallStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(three);

        // get score for the roll
        assertEquals(30, CheckRollType.getSmallStraight(dice));
    }

    @Test
    public void smallStraightTest_isSmallStraight_v3() {
        // make collection of 5 dice to mimic a roll
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(six);
        dice.add(one);

        // get score for the roll
        assertEquals(30, CheckRollType.getSmallStraight(dice));
    }

    @Test
    public void largeStraightTest_notLargeStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);

        // get score for the roll
        assertEquals(0, CheckRollType.getLargeStraight(dice));
    }

    @Test
    public void largeStraightTest_notLargeStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(four);

        // get score for the roll
        assertEquals(0, CheckRollType.getLargeStraight(dice));
    }

    @Test
    public void largeStraightTest_isLargeStraight_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // get score for the roll
        assertEquals(40, CheckRollType.getLargeStraight(dice));
    }

    @Test
    public void largeStraightTest_isLargeStraight_v2() {
        // make collection of 5 dice to mimic a roll
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        dice.add(six);

        // get score for the roll
        assertEquals(40, CheckRollType.getLargeStraight(dice));
    }

    @Test
    public void yahtzeeTest_notYahtzee_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);

        // get score for the roll
        assertEquals(0, CheckRollType.getYahtzee(dice));
    }

    @Test
    public void yahtzeeTest_isYahtzee_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(six);
        dice.add(six);

        // get score for the roll
        assertEquals(50, CheckRollType.getYahtzee(dice));
    }
    
    @Test
    public void getChanceTest_v1() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(15, CheckRollType.getChance(dice));
    }
    
    @Test
    public void getUpperSection_ones() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(1, CheckRollType.getUpperSection(dice, one));
    }
    
    @Test
    public void getUpperSection_twos() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(2, CheckRollType.getUpperSection(dice, two));
    }
    
    @Test
    public void getUpperSection_threes() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(3, CheckRollType.getUpperSection(dice, three));
    }
    
    @Test
    public void getUpperSection_fours() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(4, CheckRollType.getUpperSection(dice, four));
    }
    
    @Test
    public void getUpperSection_fives() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(5, CheckRollType.getUpperSection(dice, five));
    }
    
    @Test
    public void getUpperSection_sixes() {
        // make collection of 5 dice to mimic a roll
        dice.add(one);
        dice.add(two);
        dice.add(three);
        dice.add(four);
        dice.add(five);
        
        // get score for the roll
        assertEquals(0, CheckRollType.getUpperSection(dice, six));
    }
}
