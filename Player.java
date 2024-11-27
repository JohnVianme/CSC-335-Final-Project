import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

	private String name;
	private int rollCount;
	private ArrayList<DiceEnum> roll;
	private final ArrayList<DiceEnum> heldDice;
	private final ScoreCard myScoreCard;

	/*
	 * @pre name != null.
	 * 
	 * @post A player object will be instantiated with this.name = name(input),
	 * myScoreCard = new ScoreCard(), and heldDice to be an ArrayList of size 5
	 * filled with nulls.
	 * 
	 * @param name - A String representing the name of this Player.
	 */
	public Player(String name) {
		this.name = name;
		this.rollCount = 3;
		myScoreCard = new ScoreCard();
		heldDice = new ArrayList<DiceEnum>();
	}

	// @return A String representing the name of this Player.
	public String getName() {
		return name;
	}

	// @return An int 0-3 representing the number of rolls this Player has left.
	public int getRollCount() {
		return rollCount;
	}

	// @post rollCount is reset to be 3. All heldDice values are removed.
	public void startNewTurn() {
		rollCount = 3;
		heldDice.clear();
	}

	// @return A list of Category enums that this Player has not submitted yet.
	public List<Category> getUnfilledCategories() {
		return myScoreCard.getUnfilledCategories();
	}

	/*
	 * @param category - A Category enum that the player wants to get their current
	 * score for.
	 * 
	 * @return An int representing this Players current score for the given
	 * Category.
	 */
	public int getCategoryScore(Category category) {
		if (myScoreCard.getCategoryScore(category) == null) {
			return 0;
		}
		return myScoreCard.getCategoryScore(category);
	}

	// @return This Players total score.
	public int getTotalScore() {
		return myScoreCard.getGrandTotal();
	}

	/*
	 * @pre rollCount != 0.
	 * 
	 * @post roll is a shuffled hand of Dice with any heldDice remaining in their
	 * roll. The ArrayList heldDice will be cleared.
	 * 
	 * @return A boolean that is false if the last roll was just made, otherwise
	 * returns true.
	 */
	public boolean RollDice() {
		Hand hand = new Hand();
		roll = hand.getHand();
		TransferHolds();
		heldDice.clear();
		rollCount--;
		if (rollCount == 0) {
			return false;
		}
		return true;
	}

	// @post roll is updated to reflect any held dice.
	private void TransferHolds() {
		for (int i = 0; i < 5; i++) {
			if (heldDice.size() != 0 && i < heldDice.size()) {
				roll.set(i, heldDice.get(i));
			}
		}
	}

	/*
	 * @pre RollDice has already been called for this Player this turn.
	 * 
	 * @post The given DiceEnum value is stored in the heldDice ArrayList.
	 * 
	 * @param dice - The DiceEnum value that is to be held.
	 */
	public void SetHold(DiceEnum dice) {
		heldDice.add(dice);
	}

	/*
	 * @post The value at the given index is set to null in the heldDice ArrayList.
	 * 
	 * @param dice - The Dice that is to be un-held.
	 */
	public void removeHold(DiceEnum dice) {
		heldDice.remove(dice);
	}

	/*
	 * @pre index is an int ranging from 0-4.
	 * 
	 * @return The DiceEnum value of the Dice held at the given index in the
	 * ArrayList "roll".
	 */
	public DiceEnum getDiceAt(int idx) {
		return roll.get(idx);
	}

	/*
	 * @pre RollDice has already been called for this Player this turn.
	 * 
	 * @return The current roll of the this Player.
	 */
	public ArrayList<DiceEnum> getHand() {
		return new ArrayList<DiceEnum>(roll);
	}

	/*
	 * @pre RollDice has already been called for this Player this turn.
	 * 
	 * @pre category != Category.BONUS
	 * 
	 * @post This Player's ScoreCard will be updated to reflect this Player's
	 * current roll. If this Player has no remaining Categories to be filled, then
	 * ScoreCard will check for the bonus.
	 * 
	 * @return A boolean that is false if this Player has no remaining Categories to
	 * be filled. Otherwise true is returned.
	 */
	public boolean submitHand(Category category) {
		myScoreCard.fillCategory(roll, category);
		String result = "";
		for (DiceEnum aDiceEnum : roll) {
			result += aDiceEnum.name() + " ";
		}
		System.out.println("Just Sumited:" + result);
		List<Category> remainingCategories = getUnfilledCategories();
		if (remainingCategories.size() == 0) {
			myScoreCard.checkForBonus();
			return false;
		}
		return true;
	}

	/*
	 * @return A copy of this Player's ScoreCard
	 */
	public HashMap<Category, Integer> getScoreCard() {
		return myScoreCard.getScoreCardCopy();
	}
}
