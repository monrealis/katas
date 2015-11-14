package conway4;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.Map;

public class World {
	private String world;

	public World(String world) {
		this.world = world;
	}

	public World nextIteration() {
		String next = "";
		for (int i = 0; i < getRows(); ++i) {
			for (int j = 0; j < getCols(); ++j) {
				next += isAliveInNextIteration(i, j) ? "x" : "-";
			}
			next += "\n";
		}
		return new World(next.trim());
	}

	private boolean isAliveInNextIteration(int row, int column) {
		boolean alive = isAlive(row, column);
		int n = 0;
		for (int i = row - 1; i < row + 2; ++i)
			for (int j = column - 1; j < column + 2; ++j) {
				if (i == row && j == column)
					continue;
				if (isAlive(i, j)) {
					++n;
				}
			}
		Map<Object, Boolean> rules = new HashMap<Object, Boolean>();
		rules.put(asList(false, 0), false);
		rules.put(asList(false, 1), false);
		rules.put(asList(false, 2), false);
		rules.put(asList(false, 3), false);
		rules.put(asList(false, 4), false);
		
		rules.put(asList(true, 0), false);
		rules.put(asList(true, 1), false);
		rules.put(asList(true, 2), true);
		rules.put(asList(true, 3), true);
		rules.put(asList(true, 4), false);
		
		return rules.get(asList(alive, n));
	}

	private boolean isAlive(int rowIndex, int colIndex) {
		return isCellInsideTheWorld(rowIndex, colIndex)
				&& isAliveInsideTheWorld(rowIndex, colIndex);
	}

	private boolean isCellInsideTheWorld(int rowIndex, int colIndex) {
		boolean rowTooSmall = rowIndex < 0;
		boolean colTooSmall = colIndex < 0;
		boolean rowTooBig = rowIndex >= getRows();
		boolean colTooBig = colIndex >= getCols();
		boolean valid = !rowTooBig && !rowTooSmall && !colTooBig
				&& !colTooSmall;
		return valid;
	}

	private boolean isAliveInsideTheWorld(int rowIndex, int colIndex) {
		return world.split("\n")[rowIndex].charAt(colIndex) == 'x';
	}

	private int getRows() {
		return world.split("\n").length;
	}

	private int getCols() {
		return world.split("\n")[0].length();
	}

	@Override
	public String toString() {
		return world;
	}
}
