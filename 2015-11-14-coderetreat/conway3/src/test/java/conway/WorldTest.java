package conway;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorldTest {
	@Test
	public void parsesEmptyWorld() {
		String world = "---\n---\n---";
		assertEquals(world, new World(world).toString());
	}

	@Test
	public void parsesFullCells() {
		String worldMap = "---\n-+-\n---";
		World world = new World(worldMap);
		assertEquals(State.FULL, world.getState(new Coordinates(1, 1)));
		assertEquals(State.EMPTY, world.getState(new Coordinates(0, 1)));
	}
	
	@Test
	public void diesOfLoneliness() {
		World world = new World("---\n-+-\n---");
		world.nextIteration();
		assertEquals("---\n---\n---", world.toString());
	}
}
