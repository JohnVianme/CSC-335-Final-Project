/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
 */

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

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
        for (int i=3; i>0; i--) {
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
        for (int i=0; i < 26; i++) {
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

        // ensure the CPUs best category is not null (null is place holder in scorecard hashmap)
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

        // get the first unfilled category from the CPU and ensure its the same one picked by getEasyCPUCat()
        assertEquals(game.getCurPlayerCategories()[0], game.getEasyCPUCat().toString());
    }
}
