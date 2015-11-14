package conway;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class GridTest {
	@Test
	public void shouldReturnEmptySurface() {
		assertEmptyGrid(2, "--\n--");
	}

	@Test
	public void shouldSeedLife() {
		assertEmptyGrid(3, "---\n---\n---");
	}

	@Test
	public void shouldSeedMultipleCells() {
		Grid g = new Grid(2);
		g.seed(1, 0, Cell.ALIVE).seed(1, 1, Cell.ALIVE);
		assertEquals("--\nxx", g.toString());
	}

	@Test
	@Ignore
	public void zzz() {
		Grid g = new Grid(3);
		g.seed(1, 0, Cell.ALIVE);
		assertEquals("---\n-x-\n---\nxx", g.toString());
	}

	private void assertEmptyGrid(int n, String expected) {
		assertEquals(expected, new Grid(n).toString());
	}
}
