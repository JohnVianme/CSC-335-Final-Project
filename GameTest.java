/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

import org.junit.Test;

public class GameTest {

	// instance of a Game
	private Game game = new Game();

	// put a players into the game
	public void createGame() {
		game.addPlayer("player1");
		game.addPlayer("player2");
	}

	@Test
	public void testGetRollCount() {
		// add 2 players to game
		createGame();

		// ensure roll counts are working correctly
		for (int i = 3; i > 0; i--) {
			assertEquals(i, game.getRollCount());
			game.currRollDice();
			game.setCurrIdx(1);
			assertEquals(i, game.getRollCount());
			game.currRollDice();
			game.setCurrIdx(0);
		}
	}

	@Test
	public void testGetPlayerAmount() {
		// add 2 players to game
		createGame();

		// ensure the two players are being tracked
		assertEquals(2, game.getPlayerAmount());
	}

	@Test
	public void testSubmitHand() {
		// add 2 players to game
		createGame();

		// ensure players can submit hands for all their categories
		for (int i = 0; i < 26; i++) {
			game.currRollDice();
			String[] catNames = game.getCurPlayerCategories();
			assert catNames.length > 0;
			Category cat = Category.valueOf(catNames[0]);

			if (i == 25) {
				assertFalse(game.submitHand(cat));
			} else {
				assertTrue(game.submitHand(cat));
			}
		}

		// ensure no more categories are left to be filled in player 1
		assertEquals(0, game.getCurPlayerCategories().length);

		// go to next player
		game.setCurrIdx(0);

		// ensure no more categories are left to be filled in player 2
		assertEquals(0, game.getCurPlayerCategories().length);
	}

	@Test
	public void testAddPlayerString() {
		// add 2 players to game
		createGame();

		// add a player
		game.addPlayer("player3");

		// ensure there are now 3 players
		assertEquals(3, game.getPlayerAmount());
	}

	@Test
	public void testAddPlayerCPU() {
		// add 2 players to game
		createGame();

		// add a CPU
		game.addPlayer(new CPU("CPU1", CpuMode.EASY));

		// ensure there is another player in the game
		assertEquals(3, game.getPlayerAmount());
	}

	@Test
	public void testGetCurName() {
		createGame();
		// make sure name right
		assertEquals("Player 1", game.getCurName());
		game.setCurrIdx(1);
		assertEquals("Player 2", game.getCurName());

	}

	@Test
	public void testGetCurPlayerCategories() {
		createGame();
		// get first category of player 1
		Category p1cat = getFirstCat(game);
		game.currRollDice();
		// turn that category in
		game.submitHand(p1cat);
		// make sure first categry is not same as prev

		// get first category of player 2
		Category p2cat = getFirstCat(game);
		game.currRollDice();
		// turn that category in
		game.submitHand(p2cat);
		// make sure player 1 first category is not same as prev
		game.setCurrIdx(0);
		assertFalse(getFirstCat(game) == p1cat);
		// make sure player 2 first category is not same as prev
		game.setCurrIdx(1);
		assertFalse(getFirstCat(game) == p1cat);
	}

	private Category getFirstCat(Game game2) {
		String nameString = game2.getCurPlayerCategories()[0];
		return Category.valueOf(nameString);
	}

	@Test
	public void testGetCategoryScore() {
		// make sure start score is zero
		// can not test later since submitted hand could be zero
		createGame();
		for (Category cat : Category.values()) {
			assertEquals(0, game.getCategoryScore(cat));
		}
	}

	@Test
	public void testCurrRollDice() {
		createGame();
		// make player 1 role dices 3 time and make sure updated
		assertEquals(true, game.currRollDice());
		assertEquals(true, game.currRollDice());
		// false since the rolled last turn and have no more rolls left
		assertEquals(false, game.currRollDice());
		// make sure they can't roll
		assertEquals(false, game.currRollDice());
		assertEquals(false, game.currRollDice());
		assertEquals(false, game.currRollDice());

	}

	@Test
	public void testCurSetHold() {
		createGame();
		// make sure player 1 set a hold
		game.currRollDice();
		ArrayList<DiceEnum> aDiceEnum = game.getPlayerHand();
		// hold a dices
		game.curSetHold(aDiceEnum.get(0));
		game.curSetHold(aDiceEnum.get(1));
		game.curSetHold(aDiceEnum.get(2));
		game.curSetHold(aDiceEnum.get(3));
		game.curSetHold(aDiceEnum.get(4));
		// make player role nothing, since held all dice
		game.currRollDice();
		// make sure all the dices stayed the same
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(0)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(1)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(2)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(3)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(4)));

	}

	@Test
	public void testCurRemoveHold() {
		createGame();
		// make sure player 1 set a hold
		game.currRollDice();
		ArrayList<DiceEnum> aDiceEnum = game.getPlayerHand();
		// hold all dices
		game.curSetHold(aDiceEnum.get(0));
		game.curSetHold(aDiceEnum.get(1));
		game.curSetHold(aDiceEnum.get(2));
		game.curSetHold(aDiceEnum.get(3));
		game.curSetHold(aDiceEnum.get(4));
		game.curRemoveHold(aDiceEnum.get(3));
		game.curRemoveHold(aDiceEnum.get(4));
		game.curSetHold(aDiceEnum.get(3));
		game.curSetHold(aDiceEnum.get(4));
		// remove
		// make player role nothing, since held all dice
		game.currRollDice();
		// make removed dices are put back
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(0)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(1)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(2)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(3)));
		assertTrue(game.getPlayerHand().contains(aDiceEnum.get(4)));
	}

	@Test
	public void testSetCurrIdx() {
		createGame();
		// set curr a few times and make sure names changed
		game.setCurrIdx(0);
		assertEquals("Player 1", game.getCurName());
		game.setCurrIdx(1);
		assertEquals("Player 2", game.getCurName());
		game.setCurrIdx(0);
		assertEquals("Player 1", game.getCurName());
		game.setCurrIdx(1);
		assertEquals("Player 2", game.getCurName());

	}

	@Test
	public void testGetCPUBestCat() {
		// add 2 players to game
		createGame();

		// add a hard CPU to the game
		game.addPlayer(new CPU("CPU1", CpuMode.HARD));

		// set current player index to CPU
		game.setCurrIdx(2);

		// CPU roll dice
		game.currRollDice();

		// get CPU best category
		Category bestCat = game.getCPUBestCat();

		// submit
		game.submitHand(bestCat);

		// ensure the CPUs best category is not null (null is place holder in scorecard
		// hashmap)
		assertNotNull(game.getCategoryScore(bestCat));
	}

	@Test
	public void testGetEasyCPUCat() {
		// add 2 players to game
		createGame();

		// add an easy CPU to the game
		game.addPlayer(new CPU("CPU1", CpuMode.EASY));

		// set the player index to CPU
		game.setCurrIdx(2);

		// CPU roll dice
		game.currRollDice();

		// get the first unfilled category from the CPU and ensure its the same one
		// picked by getEasyCPUCat()
		assertEquals(game.getCurPlayerCategories()[0], game.getEasyCPUCat().toString());
	}

	@Test
	public void getTotalScore() {
		createGame();
		game.setCurrIdx(0);
		// test player 1 grand total
		assertEquals(0, game.getTotalScore());
		// test player 2 grand total
		game.setCurrIdx(1);
		assertEquals(0, game.getTotalScore());
		for (int i = 0; i < 14; i++) {
			// make sure there score is still bigger or equal to zero
			assertTrue(game.getTotalScore() >= 0);
			// make cur player role
			game.currRollDice();
			// get a cat
			String acat = game.getCurPlayerCategories()[0];
			// make the submit it
			game.submitHand(Category.valueOf(acat));
		}

	}
}
