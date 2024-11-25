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
		myScoreCard = new ScoreCard();
		heldDice = new ArrayList<DiceEnum>();
		for (int i = 0; i < 5; i++) {
			heldDice.add(null);
		}
	}

	// @return A String representing the name of this Player.
	public String getName() {
		return name;
	}

	// @return An int 0-3 representing the number of rolls this Player has left.
	public int getRollCount() {
		return rollCount;
	}

	// @post rollCount is reset to be 3. All heldDice values are reset to null.
	public void startNewTurn() {
		rollCount = 3;
		for (int i = 0; i < 5; i++) {
			heldDice.add(null);
		}
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
	 * same spot.
	 * 
	 * @return A boolean that is false if the last roll was just made, otherwise
	 * returns true.
	 */
	public boolean RollDice() {
		Hand hand = new Hand();
		roll = hand.getHand();
		TransferHolds();
		rollCount--;
		if (rollCount == 0) {
			return false;
		}
		return true;
	}

	// @post roll is updated to reflect any held dice.
	private void TransferHolds() {
		for (int i = 0; i < 5; i++) {
			if (heldDice.get(i) != null) {
				roll.set(i, heldDice.get(i));
			}
		}
	}

	/*
	 * @pre RollDice has already been called for this Player this turn.
	 * 
	 * @post The Dice at the given index is stored in the heldDice ArrayList.
	 * 
	 * @param i - The index of the Dice that is to be held.
	 */
	public void SetHold(int i) {
		heldDice.set(i, roll.get(i));
	}

	/*
	 * @post The value at the given index is set to null in the heldDice ArrayList.
	 * 
	 * @param i - The index of the Dice that is to be un-held.
	 */
	public void removeHold(int i) {
		heldDice.set(i, null);
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
	 * @post This Player's ScoreCard will be updated to reflect this Player's
	 * current roll. If this Player has no remaining Categories to be filled, then
	 * ScoreCard will check for the bonus.
	 * 
	 * @return A boolean that is false if this Player has no remaining Categories to
	 * be filled. Otherwise true is returned.
	 */
	public boolean submitHand(Category category) {
		myScoreCard.fillCategory(roll, category);
		List<Category> remainingCategories = getUnfilledCategories();
		if (remainingCategories.size() == 0) {
			myScoreCard.checkForBonus();
			return false;
		}
		return true;
	}

	/*
	 * return copy of the current plays scoreCard
	 */
	public HashMap<Category, Integer> getScoreCard() {
		return myScoreCard.getScoreCardCopy();
	}
}
