/*
 * enums for the Dice objects 
 *
 * Authors:
 * @ Garret W
 * @ John I
 * @ Dylan C
 * @ Jason B
 */
public enum DiceEnum {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

	private final int value;

	// constructor at runtime
	DiceEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	/*
	 * Getter for dice object based on integer values
	 *
	 * @param val A integer for the Dice
	 *
	 * @return A Dice enum representing a Dice if valid ordinal
	 * 
	 * @return null if the value is not related to a Dice Enum
	 */
	public static DiceEnum getDice(int value) {
		for (DiceEnum dice : DiceEnum.values()) {
			if (dice.getValue() == value) {
				return dice;
			}
		}
		return null;
	}
}
