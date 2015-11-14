package conway;

public enum Cell {
	ALIVE(1), DEAD(0);
	private final int asInt;

	private Cell(int asInt) {
		this.asInt = asInt;
	}

	public int toInt() {
		return asInt;
	}
}
