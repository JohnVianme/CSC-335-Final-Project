import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {
	
	private Player player1 = new Player("Player 1");

	@Test
	void gettersTest() {
		assertEquals(player1.getName(), "Player 1");
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
	}
	
	@Test
	void rollNoHoldsTest() {
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
		assertTrue(player1.RollDice());
		assertEquals(player1.getRollCount(), 2);
		assertTrue(player1.RollDice());
		assertEquals(player1.getRollCount(), 1);
		assertFalse(player1.RollDice());
		assertEquals(player1.getRollCount(), 0);
	}
	
	@Test 
	void rollWithHoldsTest() {
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
		assertTrue(player1.RollDice());
		System.out.println(player1.getHand());
		player1.SetHold(0);
		player1.SetHold(1);
		player1.SetHold(2);
		player1.SetHold(3);
		player1.SetHold(4);
		ArrayList<DiceEnum> prevRoll = player1.getHand();
		assertTrue(player1.RollDice());
		System.out.println(player1.getHand());
		assertEquals(player1.getHand().get(0), prevRoll.get(0));
		assertEquals(player1.getHand().get(1), prevRoll.get(1));
		assertEquals(player1.getHand().get(2), prevRoll.get(2));
		assertEquals(player1.getHand().get(3), prevRoll.get(3));
		assertEquals(player1.getHand().get(4), prevRoll.get(4));
		player1.removeHold(0);
		player1.removeHold(1);
		player1.removeHold(2);
		player1.removeHold(3);
		player1.removeHold(4);
		assertFalse(player1.RollDice());
		System.out.println(player1.getHand());
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
		assertTrue(player1.RollDice());
		System.out.println(player1.getHand());
	}
}
