import java.util.ArrayList;
/*
 * Class for representing a players hand
 * @authors Garret W., John I., Dylan C. Jason B.
 */

public final class Hand {
	//
	// instance variables
	//
	private ArrayList<DiceEnum> aHand;

	//
	// constructor
	//
	public Hand() {
		this.aHand = new ArrayList<DiceEnum>();
	}

	/*
	 * This method will call the dice class to get five dices that will represent a
	 * player hand.
	 *
	 */
	public ArrayList<DiceEnum> getHand() {
		for (int i = 0; i < 5; i++) {
			// create five dices and add them to hand
			aHand.add(Dice.getDice());
		}
		return new ArrayList<>(aHand);
	}

}
