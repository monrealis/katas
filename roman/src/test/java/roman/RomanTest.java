package roman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanTest {
	@Test(expected = Throwable.class)
	public void shouldThrowExceptionIfNegative() {
		new Roman(-1);
	}

	@Test
	public void shoudReturnRomansUsingOnesAndFives() {
		assertRoman("", 0);
		assertRoman("I", 1);
		assertRoman("V", 5);
		assertRoman("VI", 6);
		assertRoman("IV", 4);
		assertRoman("VIII", 8);
	}
	@Test
	public void shoudReturnRomansUsingTens() {
		assertRoman("IX", 9);
		assertRoman("X", 10);
		assertRoman("XV", 15);
		assertRoman("XVI", 16);
		assertRoman("XXXVII", 37);		
	}		
	
	@Test
	public void shoudReturnRomansUsingFifties() {
		assertRoman("XL", 40);		
		assertRoman("XLVII", 47);
		assertRoman("XLIX", 49);
	}

	private void assertRoman(String expected, int number) {
		assertEquals(expected, new Roman(number).toString());
	}
}
