package roman;

public class Roman {
	private static final String L = "L";
	private static final String X = "X";
	private static final String V = "V";
	private static final String I = "I";
	private final int number;

	public Roman(int number) {
		if (number < 0)
			throw new IllegalArgumentException("The number is negative");
		this.number = number;
	}

	@Override
	public String toString() {
		int numberOfOnes = number % 5;
		int numberOfFives = number / 5;
		int numberOfMinusOnes = 0;
		int numberOfTens = 0;
		int numberOfMinusTens = 0;
		int numberOfFifties = 0;
		if (numberOfOnes == 4) {
			numberOfOnes -= 4;
			numberOfMinusOnes++;
			numberOfFives++;
		}
		numberOfTens += numberOfFives / 2;
		numberOfFives -= numberOfFives / 2 * 2;
		if (numberOfTens == 4) {
			numberOfTens -= 4;
			numberOfMinusTens++;
			numberOfFifties++;
		}
		String r = "";
		r += repeat(numberOfMinusOnes, I);
		r += repeat(numberOfMinusTens, X);
		r += repeat(numberOfFifties, L);
		r += repeat(numberOfTens, X);
		r += repeat(numberOfFives, V);
		r += repeat(numberOfOnes, I);
		return r;
	}

	private String repeat(int numberOfOnes, String letter) {
		String r = "";
		for (int i = 0; i < numberOfOnes; ++i)
			r += letter;
		return r;
	}
}
