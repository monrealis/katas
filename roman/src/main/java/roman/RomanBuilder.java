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
		if (counts.get(RomanDigit.V) == 1 && counts.get(RomanDigit.I) == 4) {
			counts.put(RomanDigit.V, 0);
			counts.put(RomanDigit.I, 9);
		}
		if (counts.get(RomanDigit.L) == 1 && counts.get(RomanDigit.X) == 4) {
			counts.put(RomanDigit.L, 0);
			counts.put(RomanDigit.X, 9);
		}
		if (counts.get(RomanDigit.D) == 1 && counts.get(RomanDigit.C) == 4) {
			counts.put(RomanDigit.D, 0);
			counts.put(RomanDigit.C, 9);
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
