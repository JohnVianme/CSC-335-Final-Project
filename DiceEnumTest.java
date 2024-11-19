import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceEnumTest {
	public final DiceEnum ONE = DiceEnum.ONE;
	public final DiceEnum TWO = DiceEnum.TWO;
	public final DiceEnum THREE = DiceEnum.THREE;
	public final DiceEnum FOUR = DiceEnum.FOUR;
	public final DiceEnum FIVE = DiceEnum.FIVE;
	public final DiceEnum SIX = DiceEnum.SIX;

	@Test
	final void testGetValue() {
		assertEquals(1, ONE.getValue());
		assertEquals(2, TWO.getValue());
		assertEquals(3, THREE.getValue());
		assertEquals(4, FOUR.getValue());
		assertEquals(5, FIVE.getValue());
		assertEquals(6, SIX.getValue());
	}

	@Test
	final void testGetDice() {
		assertEquals(ONE, DiceEnum.getDice(1));
		assertEquals(TWO, DiceEnum.getDice(2));
		assertEquals(THREE, DiceEnum.getDice(3));
		assertEquals(FOUR, DiceEnum.getDice(4));
		assertEquals(FIVE, DiceEnum.getDice(5));
		assertEquals(SIX, DiceEnum.getDice(6));
	}

}
