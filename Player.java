import java.util.ArrayList;

public class Player {

	private String name;
	private int rollCount;
	private ArrayList<DiceEnum> roll;
	private final ArrayList<DiceEnum> heldDice;
	private final ScoreCard myScoreCard;
	private final ArrayList<Category> availableCategories;

	public Player (String name) {
	  this.name = name;
	  myScoreCard = new ScoreCard();
	  availableCategories = myScoreCard.getCurCategories();
	  heldDice = new ArrayList<DiceEnum>();
	  for (int i = 0; i < 5; i++) {
		  heldDice.add(null);
	  }
	}
	
	public String getName() {
		return name;
	}
	
	public int getRollCount() {
		return rollCount;
	}
	
	public void startNewTurn() {
		rollCount = 3;
		for (int i = 0; i < 5; i++) {
			heldDice.add(null);
		 }
	}
	
	// Returns boolean - If returns false, then disable the roll button in the view.
	// Disable held too if wanted.
	public boolean RollDice() {
		roll = Hand.getHand();
		TransferHolds();
		rollCount--;
		if (rollCount == 0) {
			return false;
		}
		return true;
	}
	
	private void TransferHolds() {
		for (int i = 0; i < 5; i++) {
			if (heldDice.get(i) != null) {
				roll.set(i, heldDice.get(i));
			}
		}
	}
	
	public void SetHold(int i) {
		heldDice.set(i, roll.get(i));
	}
	
	public void removeHold(int i) {
		heldDice.set(i, null);
	}
	
	public ArrayList<DiceEnum> getHand() {
		return new ArrayList<DiceEnum>(roll);
	}
}
