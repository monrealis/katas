package roman;

import java.util.Map;
import java.util.TreeMap;

public class RomanBuilder {
	private int n;
	private Map<RomanDigit, Integer> counts = new TreeMap<>();

	public RomanBuilder(int n) {
		this.n = n;
	}

	public RomanBuilder build() {
		fillInitialValues();
		handleExceptions();
		return this;
	}

	private void fillInitialValues() {
		for (RomanDigit rd : RomanDigit.values()) {
			counts.put(rd, n / rd.getValue());
			n = n % rd.getValue();
		}
	}

	private void handleExceptions() {
		replaceOneTimesFivePlusFourToNine(RomanDigit.V, RomanDigit.I);
		replaceOneTimesFivePlusFourToNine(RomanDigit.L, RomanDigit.X);
		replaceOneTimesFivePlusFourToNine(RomanDigit.D, RomanDigit.C);
	}

	private void replaceOneTimesFivePlusFourToNine(RomanDigit five,
			RomanDigit one) {
		if (counts.get(five) == 1 && counts.get(one) == 4) {
			counts.put(five, 0);
			counts.put(one, 9);
		}
	}

	@Override
	public String toString() {
		String r = "";
		for (RomanDigit d : RomanDigit.values())
			r += d.repeat(counts.get(d));
		return r;
	}
}
