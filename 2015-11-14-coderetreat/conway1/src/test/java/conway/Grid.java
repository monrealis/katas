package conway;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public class Grid {
	private static final String EMPTY_CELL = "-";
	private static final String FILLED_CELL = "x";

	public static final int DEAD = 0;
	public static final int LIVE = 1;
	private int surface[][];

	public Grid(int size) {
		surface = new int[size][size];
	}

	public Grid seed(int row, int col, Cell cell) {
		surface[row][col] = cell.toInt();
		return this;
	}

	@Override
	public String toString() {
		List<String> lines = new ArrayList<String>();
		for (int i = 0; i < getRowCount(); ++i)
			lines.add(formatLine(i));
		return Joiner.on("\n").join(lines);
	}

	private String formatLine(int row) {
		String line = "";
		for (int j = 0; j < getColCount(); ++j) {
			line += cellViewAt(row, j); // EMPTY_CELL;
		}
		return line;
	}

	private String cellViewAt(int row, int col) {
		return isAlive(row, col) ? FILLED_CELL : EMPTY_CELL;
	}

	private boolean isAlive(int row, int col) {
		return surface[row][col] == LIVE;
	}

	private int getRowCount() {
		return surface.length;
	}

	private int getColCount() {
		return surface[0].length;
	}
}
