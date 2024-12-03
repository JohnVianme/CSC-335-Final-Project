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
			switch (cat) {
			case ONES:
				int onesScore = CheckRollType.getUpperSection(this.getHand(), DiceEnum.ONE);
				scores.put(cat, onesScore);
				break;
			case TWOS:
				int twosScore = CheckRollType.getUpperSection(this.getHand(), DiceEnum.TWO);
				scores.put(cat, twosScore);
				break;
			case THREES:
				int threesScore = CheckRollType.getUpperSection(this.getHand(), DiceEnum.THREE);
				scores.put(cat, threesScore);
				break;
			case FOURS:
				int foursScore = CheckRollType.getUpperSection(this.getHand(), DiceEnum.FOUR);
				scores.put(cat, foursScore);
				break;
			case FIVES:
				int fivesScore = CheckRollType.getUpperSection(this.getHand(), DiceEnum.FIVE);
				scores.put(cat, fivesScore);
				break;
			case SIXES:
				int sixesScore = CheckRollType.getUpperSection(this.getHand(), DiceEnum.SIX);
				scores.put(cat, sixesScore);
				break;
			case THREEOFKIND:
				int threeOfAKindScore = CheckRollType.getThreeOfAKind(this.getHand());
				scores.put(cat, threeOfAKindScore);
				break;
			case FOUROFKIND:
				int fourOfAKindScore = CheckRollType.getFourOfAKind(this.getHand());
				scores.put(cat, fourOfAKindScore);
			case FULLHOUSE:
				int fullHouseScore = CheckRollType.getFullHouse(this.getHand());
				scores.put(cat, fullHouseScore);
				break;
			case SMALLSTRAIGHT:
				int smallStraightScore = CheckRollType.getSmallStraight(this.getHand());
				scores.put(cat, smallStraightScore);
				break;
			case LARGESTRAIGHT:
				int largeStraightScore = CheckRollType.getLargeStraight(this.getHand());
				scores.put(cat, largeStraightScore);
				break;
			case YAHTZEE:
				int yahzteeScore = CheckRollType.getYahtzee(this.getHand());
				scores.put(cat, yahzteeScore);
				break;
			case CHANCE:
				int chanceScore = CheckRollType.getChance(this.getHand());
				scores.put(cat, chanceScore);
				break;
			}
		}
		int maxValue = 0;
		Category maxCategory = Category.CHANCE;
		// for each category
		for (Category cat : scores.keySet()) {
			// get the score
			int aScore = scores.get(cat);
			// if score is bigger the maxValues
			if (aScore >= maxValue) {
				// make that the new maxValue and maxCategory
				maxValue = aScore;
				maxCategory = cat;
			}
		}

		return maxCategory;
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
