package roman;

public class RomanBuilder {
	private int n;
	private int numberOfFifties;
	private int numberOfTens;
	private int numberOfFives;
	private int numberOfOnes;

	public RomanBuilder(int n) {
		this.n = n;
	}

	public RomanBuilder build() {
		fillInitialValues();
		handleExceptions();
		return this;
	}

	private void fillInitialValues() {
		numberOfFifties = n / 50;
		n = n % 50;
		numberOfTens = n / 10;
		n = n % 10;
		numberOfFives = n / 5;
		n = n % 5;
		numberOfOnes = n;
	}

	private void handleExceptions() {
		if (numberOfFives == 1 && numberOfOnes == 4) {
			numberOfFives--;
			numberOfOnes += 5;
		}
	}

	@Override
	public String toString() {
		String r = "";
		r += RomanDigit.L.repeat(numberOfFifties);
		r += RomanDigit.X.repeat(numberOfTens);
		r += RomanDigit.V.repeat(numberOfFives);
		r += RomanDigit.I.repeat(numberOfOnes);
		return r;
	}

}
