package roman;

public class Roman {
	private final int number;

	public Roman(int number) {
		if (number < 0)
			throw new IllegalArgumentException("The number is negative");
		this.number = number;
	}

	@Override
	public String toString() {
		return new RomanBuilder(number).build().toString();
	}
}
