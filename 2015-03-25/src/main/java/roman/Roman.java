package roman;

public class Roman {
	private final int number;

	public Roman(int number) {
		if (number < 0)
			throw new IllegalArgumentException();
		if (number > 3000)
			throw new IllegalArgumentException();
		this.number = number;
	}

	@Override
	public String toString() {
		return new RomanBuilder(number).build().toString();
	}
}
