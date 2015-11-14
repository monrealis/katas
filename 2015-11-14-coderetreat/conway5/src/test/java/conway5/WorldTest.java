package conway5;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Ignore;
import org.junit.Test;

public class WorldTest {
	private Writer writer = new StringWriter();
	private static final String EMPTY_WORLD = "---\n---\n---";

	@Test
	public void printsWorld() {
		String world = "---\n-x-\n---";
		create(world).print();
		assertWorldIs(world);
	}

	@Test
	public void singleCellWillDieOnNextTick() {
		create("---\n-x-\n---").tick().print();
		assertWorldIs(EMPTY_WORLD);
	}

	@Test
	public void overcrowdedCenterCellWillDieOnNextTick() {
		create("-xx\nxxx\n---").tick().printCell(1, 1);
		assertEquals("-", writer.toString());
	}

	@Test
	@Ignore
	public void stasisCenterCellWillSurviveOnNextTick() {
		create("-x-\n-x-\n-x-").tick().printCell(1, 1);
		assertEquals("x", writer.toString());
	}

	@Test
	@Ignore
	public void overcrowdedWillDieOnNextTickNotImplemented() {
		create("-xx\nxxx\n---").tick().print();
		assertWorldIs("--x\nx-x\n---");
	}

	private World create(String world) {
		return new World(new WorldState(world), writer);
	}

	private void assertWorldIs(String world) {
		assertEquals(world, writer.toString());
	}
}
