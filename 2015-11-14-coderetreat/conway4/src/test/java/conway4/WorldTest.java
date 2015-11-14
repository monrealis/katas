package conway4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorldTest {
	@Test
	public void createsLonelyCell() {
		new World("---\n-x-\n---");
	}

	@Test
	public void lonelyCellDies() {
		World w = new World("---\n-x-\n---").nextIteration();
		assertEquals("---\n---\n---", w.toString());
	}
	
	@Test
	public void overcrowdedCellDies() {
		World w = new World("-xx\nxxx\n---").nextIteration();
		assertEquals("--x\nx-x\n---", w.toString());
	}
}
