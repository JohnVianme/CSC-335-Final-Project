import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HandTest {

	@Test
	final void testGetHand() {
		// create 50 hands and make sure all are size 5
		for (int i = 0; i < 50; i ++) {
			ArrayList<DiceEnum> aHand = Hand.getHand();
			// make sure we have 5 of them
			assertEquals(5, aHand.size());
			// make sure they are all dice
			assertInstanceOf(DiceEnum.class, aHand.get(0));
			assertInstanceOf(DiceEnum.class, aHand.get(1));
			assertInstanceOf(DiceEnum.class, aHand.get(2));
			assertInstanceOf(DiceEnum.class, aHand.get(3));
			assertInstanceOf(DiceEnum.class, aHand.get(4));
		}
		
	}

}