import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class PlayerTest {
	
	private Player player1 = new Player("Player 1");

	@Test
	void playerGettersTest() {
		assertEquals(player1.getName(), "Player 1");
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
		assertEquals(player1.getTotalScore(), 0);
		
	}
	
	@Test
	void playerRollNoHoldsTest() {
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
	void playerRollWithHoldsTest() {
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
		assertTrue(player1.RollDice());
		player1.SetHold(player1.getDiceAt(0));
		player1.SetHold(player1.getDiceAt(1));
		player1.SetHold(player1.getDiceAt(2));
		player1.SetHold(player1.getDiceAt(3));
		player1.SetHold(player1.getDiceAt(4));
		ArrayList<DiceEnum> prevRoll = player1.getHand();
		assertTrue(player1.RollDice());
		assertEquals(player1.getHand().get(0), prevRoll.get(0));
		assertEquals(player1.getHand().get(1), prevRoll.get(1));
		assertEquals(player1.getHand().get(2), prevRoll.get(2));
		assertEquals(player1.getHand().get(3), prevRoll.get(3));
		assertEquals(player1.getHand().get(4), prevRoll.get(4));
		player1.removeHold(player1.getDiceAt(0));
		player1.removeHold(player1.getDiceAt(1));
		player1.removeHold(player1.getDiceAt(2));
		player1.removeHold(player1.getDiceAt(3));
		player1.removeHold(player1.getDiceAt(4));
		assertFalse(player1.RollDice());
		player1.startNewTurn();
		assertEquals(player1.getRollCount(), 3);
		assertTrue(player1.RollDice());
		player1.SetHold(player1.getDiceAt(0));
		player1.SetHold(player1.getDiceAt(2));
		player1.SetHold(player1.getDiceAt(4));
		prevRoll = player1.getHand();
		assertTrue(player1.RollDice());
		assertEquals(player1.getHand().get(0), prevRoll.get(0));
		assertEquals(player1.getHand().get(1), prevRoll.get(2));
		assertEquals(player1.getHand().get(2), prevRoll.get(4));
	}
	
	@Test
	void playerCategoriesTest() {
		player1.startNewTurn();
		List<Category> unfilledCategories = player1.getUnfilledCategories();
		assertEquals(unfilledCategories.size(), 13);
		assertEquals(player1.getCategoryScore(Category.BONUS), 0);
		assertEquals(player1.getCategoryScore(Category.CHANCE), 0);
		assertEquals(player1.getCategoryScore(Category.ONES), 0);
		player1.RollDice();
		player1.submitHand(Category.ONES);
		player1.RollDice();
		player1.submitHand(Category.FIVES);
		player1.RollDice();
		player1.submitHand(Category.FULLHOUSE);
		player1.RollDice();
		player1.submitHand(Category.SMALLSTRAIGHT);
		HashMap<Category, Integer> copiedScoreCard = player1.getScoreCard();
		assertEquals(player1.getCategoryScore(Category.ONES), copiedScoreCard.get(Category.ONES));
		assertEquals(player1.getCategoryScore(Category.FIVES), copiedScoreCard.get(Category.FIVES));
		assertEquals(player1.getCategoryScore(Category.FULLHOUSE), copiedScoreCard.get(Category.FULLHOUSE));
		assertEquals(player1.getCategoryScore(Category.SMALLSTRAIGHT), copiedScoreCard.get(Category.SMALLSTRAIGHT));
	}
}
