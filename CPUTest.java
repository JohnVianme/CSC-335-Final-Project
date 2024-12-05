import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CPUTest {

	private CPU EASYCPU = new CPU("EASY MODE", CpuMode.EASY);
	private CPU HARDCPU = new CPU("HARD MODE", CpuMode.HARD);

	@Test
	final void testEASYGetBestCategory() {
		// while the CPU has open categroies
		int size = 13;
		while (EASYCPU.getUnfilledCategories().size() > 0) {
			// make the CPU role thier dice
			EASYCPU.RollDice();
			// get the best Category
			List<Category> unfilledCategories = EASYCPU.getUnfilledCategories();
			Category aCategory = EASYCPU.getFirstCategory();
			// make sure CPU has the best Category
			assertTrue(unfilledCategories.contains(aCategory));
			// sumbit the best Category
			EASYCPU.submitHand(aCategory);
			// start a new turn
			EASYCPU.startNewTurn();
			// make sure size is decreasing
			assertTrue(EASYCPU.getUnfilledCategories().size() == size - 1);
			size--;
		}
	}

	@Test
	final void testHARDGetFirstCategory() {
		// while the CPU has open categroies
		int size = 13;
		while (HARDCPU.getUnfilledCategories().size() > 0) {
			// make the CPU role thier dice
			HARDCPU.RollDice();
			// get the best Category
			List<Category> unfilledCategories = HARDCPU.getUnfilledCategories();
			Category bestCategory = HARDCPU.getBestCategory();
			// make sure CPU has the best Category
			assertTrue(unfilledCategories.contains(bestCategory));
			// make it is really best Category
			assertTrue(IsBest(unfilledCategories, HARDCPU, bestCategory));
			// sumbit the best Category
			HARDCPU.submitHand(bestCategory);
			// start a new turn
			EASYCPU.startNewTurn();
			// make sure size is decreasing
			assertTrue(HARDCPU.getUnfilledCategories().size() == size - 1);
			size--;
		}

	}

	// help to make sure we got best hand
	private boolean IsBest(List<Category> unfilled, CPU cpu, Category bestCat) {
		// for each unfiled categroy
		for (Category cat : unfilled) {
			// get the score
			int aCatScore = cpu.getCategoryScore(cat);
			// get score of bestCategory
			int bestScore = cpu.getCategoryScore(bestCat);
			// if the score of this categroy is better then best Category
			if (aCatScore > bestScore) {
				// return false
				return false;
			}

		}
		return true;
	}

}
