import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest {

	@Test
	final void testGetDice() {
		// run getdice and make sure we are getting dices
		assertInstanceOf(DiceEnum.class, Dice.getDice());
		assertInstanceOf(DiceEnum.class, Dice.getDice());
		assertInstanceOf(DiceEnum.class, Dice.getDice());
		assertInstanceOf(DiceEnum.class, Dice.getDice());
		assertInstanceOf(DiceEnum.class, Dice.getDice());
		assertInstanceOf(DiceEnum.class, Dice.getDice());
	}

}
