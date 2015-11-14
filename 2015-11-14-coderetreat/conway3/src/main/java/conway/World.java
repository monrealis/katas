package conway;

public class World {
	private final Matrix matrix;

	public World(String world) {
		matrix = new Matrix(world);
	}

	public String toString() {
		return matrix.toString();
	}

	public State getState(Coordinates coordinates) {
		return matrix.getState(coordinates);
	}

	public void nextIteration() {
		for (int i = 0; i < matrix.getRows(); ++i) {
			for (int j = 0; j < matrix.getCols(); ++j) {
				getAliveNeighboursCount(i, j);
			}
		}
	}
	
	private State getAliveNeighboursCount(int x, int y) {
		return null;
	}
}
