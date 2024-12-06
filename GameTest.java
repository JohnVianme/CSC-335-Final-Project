/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
 */

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

public class GameTest {

	// instance of a Game
	private Game game = new Game();

	// put a player and CPU into the game
	public void createGame() {
		game.addPlayer("player1");
		game.addPlayer("player2");
		game.addPlayer("player3");
		game.addPlayer("player4");
	}

	/*
	 * Moves to next player
	 */
	private void nextPlayer(Game aGame) {
		aGame.currRollDice();
		String[] catNames = aGame.getCurPlayerCategories();
		assert catNames.length > 0;
		Category cat = Category.valueOf(catNames[0]);
		aGame.submitHand(cat);
	}

	@Test
	public void testGetRollCount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetPlayerAmount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSubmitHand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddPlayerString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddPlayerCPU() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCurName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCurPlayerCategories() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCategoryScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCurrRollDice() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCurSetHold() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCurRemoveHold() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetCurrIdx() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTotalScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCPUBestCat() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCurGradTotal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetEasyCPUCat() {
		fail("Not yet implemented"); // TODO
	}

}