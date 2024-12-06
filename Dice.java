import java.util.ArrayList;
import java.util.Collections;

/*
 *  Class for getting a Dice
 * @authors Garret W., John I., Dylan C. Jason B.
 */

public final class Dice {
	private static final ArrayList<DiceEnum> diceList = new ArrayList<DiceEnum>();

	static {
		// Add each unique dice value to ArrayList.
		diceList.add(DiceEnum.ONE);
		diceList.add(DiceEnum.TWO);
		diceList.add(DiceEnum.THREE);
		diceList.add(DiceEnum.FOUR);
		diceList.add(DiceEnum.FIVE);
		diceList.add(DiceEnum.SIX);
	}

	public static DiceEnum getDice() {
		// Shuffle the list of unique dice objects.
		Collections.shuffle(diceList);
		// Always retrieve random dice from idx 0.
		return diceList.get(0);
	}
}
