package roman;

public enum RomanDigit {
	M(1000), D(500), C(100) {
		@Override
		public String repeat(int numberOfTimes) {
			if (numberOfTimes == 9)
				return "CM";
			if (numberOfTimes == 4)
				return "CD";
			return super.repeat(numberOfTimes);
		}
	},
	L(50), X(10) {
		@Override
		public String repeat(int numberOfTimes) {
			if (numberOfTimes == 9)
				return "XC";
			if (numberOfTimes == 4)
				return "XL";
			return super.repeat(numberOfTimes);
		}
	},
	V(5), I(1) {
		@Override
		public String repeat(int numberOfTimes) {
			if (numberOfTimes == 4)
				return "IV";
			if (numberOfTimes == 9)
				return "IX";
			return super.repeat(numberOfTimes);
		}
	};
	private final int value;

	private RomanDigit(int value) {
		this.value = value;
	}

	public String repeat(int numberOfTimes) {
		return repeat(numberOfTimes, name());
	}

	private String repeat(int numberOfOnes, String letter) {
		String r = "";
		for (int i = 0; i < numberOfOnes; ++i)
			r += letter;
		return r;
	}

	public int getValue() {
		return value;
	}
}