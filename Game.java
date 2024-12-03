import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.*;

public class Game {
	private int playerAmount;
	private ArrayList<Player> players;
	private int currentPlayerIdx;

	/*
	 * Constructor for game with no players added yet
	 */
	public Game() {
		this.playerAmount = 0;
		this.players = new ArrayList<Player>();
		this.currentPlayerIdx = 0;
	}

	/*
	 * @return the current plays hand of dices
	 */
	public ArrayList<DiceEnum> getPlayerHand() {
		Player currPlayer = players.get(currentPlayerIdx);
		return currPlayer.getHand();
	}

	/*
	 * @return the current players rollCount
	 */
	public int getRollCount() {
		Player currPlayer = players.get(currentPlayerIdx);
		return currPlayer.getRollCount();
	}

	/*
	 * Method return amount of players
	 * 
	 * @return int rep. amount of players
	 */
	public int getPlayerAmount() {
		return this.playerAmount;
	}

	/*
	 * return the current player
	 * 
	 */
	public boolean submitHand(Category category) {
		Player curPlayer;
		// if we are the last player
		if (currentPlayerIdx == players.size() - 1) {
			// get the last player
			curPlayer = players.get(currentPlayerIdx);
			// try to make make the last player submitHand
			boolean result = curPlayer.submitHand(category);
			// if not possible
			if (result == false) {
				// end of game
				return false;
			}
			// make the player start a new turn
			currentPlayerIdx = ((currentPlayerIdx + 1) % playerAmount);
			curPlayer = players.get(currentPlayerIdx);
			curPlayer.startNewTurn();
			return true;
		}

		// get the current player
		curPlayer = players.get(currentPlayerIdx);
		// make player submit their hand
		curPlayer.submitHand(category);
		// update current player to next player
		currentPlayerIdx = ((currentPlayerIdx + 1) % playerAmount);
		curPlayer = players.get(currentPlayerIdx);
		// make sure next player restart there roll count to 3 and holds to zero
		curPlayer.startNewTurn();
		// return true that we were able to submit hand
		return true;

	}

	/*
	 * This method adds a player given a name and return true if the player can be
	 * added
	 * 
	 * @param aName - name of player
	 * 
	 * @pre aName != null
	 * 
	 * @post player will be created and added to list of players
	 * 
	 * @return true if the player was added and false if not
	 */
	public boolean addPlayer(String aName) {
		assert aName != null;
		// can not add more then 4 players
		if (players.size() > 4) {
			return false;
		}
		// create the player
		Player aPlayer = new Player(aName);
		// add them to list of players
		players.add(aPlayer);
		playerAmount++;
		return true;
	}

	public boolean addPlayer(CPU cpu) {
		// can not add more then 4 players
		if (players.size() > 4) {
			return false;
		}
		// add CPU to list of players
		players.add(cpu);
		playerAmount++;
		return true;

	}

	/*
	 * This method returns the current player's name
	 * 
	 * @return player name
	 */
	public String getCurName() {
		Player currPlayer = players.get(currentPlayerIdx);
		return currPlayer.getName();
	}

	/*
	 * This method return's the current player's available categories.
	 * 
	 * @return list of the player's unfilled categories based on name.
	 */
	public String[] getCurPlayerCategories() {
		Player currPlayer = players.get(currentPlayerIdx);
		// get the categories
		List<Category> unfilledCategories = currPlayer.getUnfilledCategories();
		// new String[] to hold categories
		String result[] = new String[unfilledCategories.size()];
		// add each categories to String[]
		for (int i = 0; i < unfilledCategories.size(); i++) {
			result[i] = unfilledCategories.get(i).name();
		}
		return result;
	}

	/*
	 * This method returns the copy of the current player's ScoreCard
	 * 
	 * @return copy of the plays ScoreCard
	 */
	public HashMap<Category, Integer> getCurCard() {
		Player currPlayer = players.get(currentPlayerIdx);
		return currPlayer.getScoreCard();
	}

	/*
	 * This method return the players for a spacific category
	 * 
	 * @param category -a category
	 * 
	 * @pre category != null
	 * 
	 * @return the score for the current player will be returned for that category
	 */
	public int getCategoryScore(Category category) {
		Player currPlayer = players.get(currentPlayerIdx);
		return currPlayer.getCategoryScore(category);
	}

	/*
	 * This method makes the current player roll the dices
	 * 
	 * @return true if was able to roll, false else
	 */
	public boolean currRollDice() {
		// make current player's roll the dices
		Player currPlayer = players.get(currentPlayerIdx);
		boolean result = currPlayer.RollDice();
		return result;
	}

	public void curSetHold(DiceEnum dice) {
		Player currPlayer = players.get(currentPlayerIdx);
		currPlayer.SetHold(dice);

	}

	public void curRemoveHold(DiceEnum dice) {
		Player currPlayer = players.get(currentPlayerIdx);
		currPlayer.removeHold(dice);

	}

	/*
	 * Helper method to reset currentPlayerIdx for iterating through each player at
	 * the end of the game.
	 * 
	 * @pre newIdx is within the limits of 0 to playerAmount-1.
	 * 
	 * @post currentPlayerIdx is set to parameter.
	 */
	public void setCurrIdx(int newIdx) {
		currentPlayerIdx = newIdx;
	}

	/*
	 * Helper method to get the current player's total game score.
	 * 
	 * @return the current player's total score in the current game.
	 */
	public int getTotalScore() {
		Player curPlayer = players.get(currentPlayerIdx);
		return curPlayer.getTotalScore();
	}

	/*
	 * Method for return the CPU's best cat to fill
	 * 
	 * @pre curPlayer most be a CPU player
	 */
	public Category getCPUBestCat() {
		Player curPlayer = players.get(currentPlayerIdx);
		assert curPlayer instanceof CPU;
		return ((CPU) curPlayer).getBestCategory();
	}

	/*
	 * Method for return a CPU's open cat to fill
	 * 
	 * @pre curPlayer most be a CPU player
	 */
	public Category getACPUCat() {
		Player curPlayer = players.get(currentPlayerIdx);
		assert curPlayer instanceof CPU;
		return ((CPU) curPlayer).getFirstCategory();
	}
}
