import java.util.ArrayList;

public final class Hand {
	/*
	 * This method will call the dice class to get five dices that will represent a
	 * player hand.
	 * 
	 */
	public static ArrayList<DiceEnum> getHand() {
		ArrayList<DiceEnum> aHand = new ArrayList<DiceEnum>();
		for (int i = 0; i < 5; i++) {
			// create five dices and add them to hand
			aHand.add(Dice.getDice());
		}
		return aHand;
	}
}
