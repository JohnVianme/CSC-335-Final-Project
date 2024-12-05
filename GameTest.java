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
        game.addPlayer(new CPU("CPU", CpuMode.EASY));
    }

	@Test
	final void testGetRollCount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetPlayerAmount() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSubmitHand() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAddPlayerString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAddPlayerCPU() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCurName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCurPlayerCategories() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCategoryScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCurrRollDice() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCurSetHold() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCurRemoveHold() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetCurrIdx() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetTotalScore() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCPUBestCat() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCurGradTotal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetEasyCPUCat() {
		fail("Not yet implemented"); // TODO
	}
    
    
    
}