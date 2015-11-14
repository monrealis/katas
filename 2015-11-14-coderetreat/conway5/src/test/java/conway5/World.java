package conway5;

import java.io.IOException;
import java.io.Writer;

public class World {
	public static final String DEAD = "-";
	public static final String ALIVE = "x";
	private Writer writer;
	private WorldState state;

	public World(WorldState state, Writer writer) {
		this.state = state;
		this.writer = writer;
	}

	public void print() {
		print(state.getWorld());
	}

	public World tick() {
		new Ticker(state).tick();
		return this;
	}

	public void printCell(int row, int col) {
		print(state.getCell(row, col));
	}

	private void print(String s) {
		try {
			writer.append(s);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
