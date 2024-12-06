/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

import org.junit.Test;

public class GameTest {

	// instance of a Game
	private Game game = new Game();

	// put a player and CPU into the game
	public void createGame() {
		game.addPlayer("Player 1");
		game.addPlayer("Player 2");
	}

	@Test
	public void testGetRollCount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetPlayerAmount() {

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
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCurGradTotal() {
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
	

	@Test
	public void testGetEasyCPUCat() {
		fail("Not yet implemented"); // TODO
	}

	private Category getFirstCat(Game aGame) {
		String acat = aGame.getCurPlayerCategories()[0];
		return Category.valueOf(acat);

	}

}