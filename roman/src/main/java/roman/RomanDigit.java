package roman;

public enum RomanDigit {
	M, D, C {
		@Override
		public String repeat(int numberOfTimes) {
			if (numberOfTimes == 9) 
				return "CM";
			if (numberOfTimes == 4)
				return "CD";
			return super.repeat(numberOfTimes);
		}
	}
	, L, X {
		@Override
		public String repeat(int numberOfTimes) {
			if (numberOfTimes == 9)
				return "XC";
			if (numberOfTimes == 4)
				return "XL";
			return super.repeat(numberOfTimes);
		}
	},
	V, I {
		@Override
		public String repeat(int numberOfTimes) {
			if (numberOfTimes == 4)
				return "IV";
			if (numberOfTimes == 9)
				return "IX";
			return super.repeat(numberOfTimes);
		}
	};

	public String repeat(int numberOfTimes) {
		return repeat(numberOfTimes, name());
	}

	private String repeat(int numberOfOnes, String letter) {
		String r = "";
		for (int i = 0; i < numberOfOnes; ++i)
			r += letter;
		return r;
	}
}