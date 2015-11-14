package conway;

public class Matrix {
	State[][] matrix;

	public Matrix(String world) {
		String[] lines = world.split("\n");
		int rows = lines.length;
		int cols = lines[0].length();
		matrix = new State[rows][cols];
		parseRows(lines);
	}

	private void parseRows(String[] rowStrings) {
		for (int i = 0; i < getRows(); ++i)
			parseRow(i, rowStrings[i]);
	}

	private void parseRow(int rowIndex, String rowString) {
		for (int j = 0; j < getCols(); ++j)
			matrix[rowIndex][j] = parseCell(rowString.charAt(j));
	}

	private State parseCell(char symbol) {
		if (symbol == '-')
			return State.EMPTY;
		else
			return State.FULL;
	}

	public State getState(Coordinates coordinates) {
		return matrix[coordinates.x][coordinates.y];
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < getRows(); ++i)
			result += toLine(i) + "\n";
		return result.trim();
	}

	private String toLine(int rowIndex) {
		String line = "";
		for (int j = 0; j < getCols(); ++j)
			line += matrix[rowIndex][j] == State.FULL ? '+' : '-';
		return line;
	}

	public int getRows() {
		return matrix.length;
	}

	public int getCols() {
		return matrix[0].length;
	}
}
