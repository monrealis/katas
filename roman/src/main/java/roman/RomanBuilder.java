package roman;

public class RomanBuilder {
	private static final String L = "L";
	private static final String X = "X";
	private static final String V = "V";
	private static final String I = "I";
	private int n;
	private int numberOfMinusOnes;
	private int numberOfMinusTens;
	private int numberOfFifties;
	private int numberOfTens;
	private int numberOfFives;
	private int numberOfOnes;

	public RomanBuilder(int n) {
		this.n = n;
	}

	public RomanBuilder build() {
		numberOfFifties = n / 50;
		n = n % 50;
		numberOfTens = n / 10;
		n = n % 10;
		numberOfFives = n / 5;
		n = n % 5;
		numberOfOnes = n;
		numberOfMinusOnes = 0;
		numberOfMinusTens = 0;
		if (numberOfOnes == 4) {
			numberOfOnes -= 4;
			numberOfMinusOnes++;
			numberOfFives++;
		}
		numberOfTens += numberOfFives / 2;
		numberOfFives -= numberOfFives / 2 * 2;
		numberOfFifties += numberOfTens / 5;
		numberOfTens -= numberOfTens / 5 * 5;
		if (numberOfTens == 4) {
			numberOfTens -= 4;
			numberOfMinusTens++;
			numberOfFifties++;
		}
		return this;
	}

	@Override
	public String toString() {
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
