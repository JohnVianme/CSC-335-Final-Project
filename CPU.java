import java.util.HashMap;
import java.util.List;

public class CPU extends Player {

	private final CpuMode mode;

	/*
	 * CPU constructer same as player but has a mode
	 */
	public CPU(String name, CpuMode mode) {
		super(name);
		this.mode = mode;
	}

	/*
	 * Method for getting the cpu mode
	 */
	public CpuMode getCpuMode() {
		return mode;
	}

	/*
	 * This the best Category for the cpu to fill, will be used by super submit hand
	 * 
	 * @pre rollCount != 3
	 * 
	 * @post best Category will be submitted
	 */
	public Category getBestCategory() {
		assert this.getRollCount() != 3;

		List<Category> unfilled = this.getUnfilledCategories();

		HashMap<Category, Integer> scores = new HashMap<>();

		for (Category cat : unfilled) {
			switch(cat) {
				case ONES:
					int onesScore = getUpperSection(this.getHand(), 1);
					scores.put(cat, onesScore);
					break;
				case TWOS:
					int twosScore = getUpperSection(this.getHand(), 2);
					scores.put(cat, twosScore);
					break;
				case THREES:
					int threesScore = getUpperSection(this.getHand(), 3);
					scores.put(cat, threesScore);
					break;
				case FOURS:
					int foursScore = getUpperSection(this.getHand(), 4);
					scores.put(cat, foursScore);
					break;
				case FIVES:
					int fivesScore = getUpperSection(this.getHand(), 5);
					scores.put(cat, fivesScore);
					break;
				case SIXES:
					int sixesScore = getUpperSection(this.getHand(), 6);
					scores.put(cat, sixesScore);
					break;
				case THREEOFKIND:
					int threeOfAKindScore = getThreeOfAKind(this.getHand());
					scores.put(cat, threeOfAKindScore);
					break;
				case FOUROFKIND:
					int fourOfAKindScore = getFourOfAKind(this.getHand());
					scores.put(cat, fourOfAKindScore);
				case FULLHOUSE:
					int fullHouseScore = getFullHouse(this.getHand());
					scores.put(cat, fullHouseScore);
					break;
				case SMALLSTRAIGHT:
					int smallStraightScore = getSmallStraight(this.getHand());
					scores.put(cat, smallStraightScore);
					break;
				case LARGESTRAIGHT:
					int largeStraightScore = getLargeStraight(this.getHand());
					scores.put(cat, largeStraightScore);
					break;
				case YAHTZEE:
					int yahzteeScore = getYahtzee(this.getHand());
					scores.put(cat, yahzteeScore);
					break;
				case CHANCE:
					int chanceScore = getChance(this.getHand());
					scores.put(cat, chanceScore);
					break;
			}
		}



		
		return null;
	}

	/*
	 * This returns the first Category for the cpu to fill, will be used by super
	 * submit hand
	 * 
	 * @pre rollCount != 3
	 * 
	 * @post first Category will be submitted
	 */
	public Category getFirstCategory() {
		assert this.getRollCount() != 3;

		
		return this.getUnfilledCategories().get(0);
	}

}
