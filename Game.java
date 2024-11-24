import java.util.ArrayList;

public class Game {
	private int playerAmount;
	private ArrayList<Player> players;

	/*
	 * Constructor for game with no players
	 */
	public Game() {
		this.playerAmount = 0;
		this.players = new ArrayList<Player>();

	}

	/*
	 * This method adds a player given a name and return true if the player can be
	 * added
	 * 
	 * @param aName -name of player
	 * 
	 * @pre aName != null
	 * @pre playerAmount <= 4
	 * 
	 * @post player will be created and added to list of players
	 * 
	 */
	public boolean addPlayer(String aName) {
		assert this.playerAmount <= 4;
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

}
