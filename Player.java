import java.util.ArrayList;

public class Player {

	private String name;
	private int rollCount;
	private ArrayList<DiceEnum> roll;
	private ArrayList<DiceEnum> heldDice;
	private ScoreCard myScoreCard;
	private ArrayList<Category> availableCategories;

	public Player (String name) {
	  this.name = name;
	  myScoreCard = new ScoreCard();
	  heldDice = new ArrayList<DiceEnum>();
	  for (int i = 0; i < 5; i++) {
		  heldDice.add(null);
	  }
	}
	
	// Returns boolean - If returns false, then disable the roll button in the view.
	// Disable held too if wanted.
	public boolean RollDice() {
		roll = Hand.getHand();
		TransferHolds();
		rolls--;
		if (rolls == 0) {
			return false;
		}
		return true;
	}
	
	private void TransferHolds() {
		for (int i = 0; i < 5; i++) {
			if (heldDice.get() != null) {
				roll.set(i, heldDice.get(i));
			}
		}
	}
	
	public void SetHold(int i) {
		heldDice.set(i, roll.get(i));
	}
	
	public void removeHold(int i) {
		held.set(i, null);
	}
	
	public ArrayList<DiceEnum> getHand() {
		return new ArrayList<DiceEnum>(roll);
	}
}
