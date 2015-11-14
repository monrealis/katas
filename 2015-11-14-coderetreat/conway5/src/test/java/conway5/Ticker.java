package conway5;

public class Ticker {
	private final WorldState state;

	public Ticker(WorldState state) {
		this.state = state;
	}

	public void tick() {
		state.replaceWith(getNext());
	}

	private String getNext() {
		String next = "";
		for (int i = 0; i < 3; ++i) {
			String row = "";
			for (int j = 0; j < 3; ++j)
				row += getCellInNextIteration(i, j);
			next += row + "\n";
		}
		return next.trim();
	}

	private String getCellInNextIteration(int row, int col) {
		return World.DEAD;
	}

}
