import java.util.ArrayList;

public class Game {
	private int playerAmount;
	private ArrayList<Player> players;

	/*
	 * Constructor for game with given amount of players
	 * 
	 * @param players - number of player
	 * 
	 * @pre players >= 2 && players <= 4
	 * 
	 * @post the game will have "players" amount of players
	 */
	public Game(int players) {
		assert players >= 2 && players <= 4;
		this.playerAmount = players;
		this.players = new ArrayList<Player>();
	}

	/*
	 * Constructor for game for 1 playe vs a CPU
	 */
	public Game() {
		this.playerAmount = 1;
		this.players = new ArrayList<Player>();

	}

	/*
	 * This method adds a player given a name and return true if the player can be
	 * added
	 * 
	 * @param 	aName -name of player
	 * 
	 * @pre		aName != null
	 * 
	 * @post	player will be added to list of players
	 * 
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
		return true;
	}

}
