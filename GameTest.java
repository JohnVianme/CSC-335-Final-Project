/*
 * a suite of tests for the Game class
 *
 * @authors Garret W., John I., Dylan C., Jason B.
 */

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
    public void getPlayerHandTest() {

    }
}