import java.util.ArrayList;

public class Game {
	private int playerAmount;
	private ArrayList<Player> players;
	private int currentPlayerIdx;

	/*
	 * Constructor for game with no players
	 */
	public Game() {
		this.playerAmount = 0;
		this.players = new ArrayList<Player>();
		this.currentPlayerIdx = 0;
	}

	public Hand getPlayerHand() {
		Player currPlayer = players.get(currentPlayerIdx);
		return currPlayer.getHand();
	}

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
	public boolean submitHand() {
		Player curPlayer;
		// if we are the last player
		if (currentPlayerIdx == players.size() - 1) {
			// get the last player
			curPlayer = players.get(currentPlayerIdx);
			// try to make make the last player submitHand
			boolean result = curPlayer.submitHand();
			// if not possible
			if (result == false) {
				// end of game
				return false;
			}
		}
		// update current player to next player
		currentPlayerIdx = ((currentPlayerIdx + 1) % playerAmount);
		curPlayer = players.get(currentPlayerIdx);
		// make sure next player restart there roll count to 3 and holds to zero
		curPlayer.startTurn();
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

	public Hand getPlayerHand() {
		return 
	}

}
