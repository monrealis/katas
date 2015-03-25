package roman;

public class RomanBuilder {
	private int n;
	private int m;
	private int d;
	private int c;
	private int l;
	private int x;
	private int v;
	private int i;

	public RomanBuilder(int n) {
		this.n = n;
	}

	public RomanBuilder build() {
		fillInitialValues();
		handleExceptions();
		return this;
	}

	private void fillInitialValues() {
		m = n / 1000;
		n = n % 1000;
		d = n / 500;
		n = n % 500;
		c = n / 100;
		n = n % 100;
		l = n / 50;
		n = n % 50;
		x = n / 10;
		n = n % 10;
		v = n / 5;
		n = n % 5;
		i = n;
	}

	private void handleExceptions() {
		if (v == 1 && i == 4) {
			v--;
			i += 5;
		}
		if (l == 1 && x == 4) {
			l--;
			x += 5;
		}
		if (d == 1 && c == 4) {
			d--;
			c += 5;
		}
	}

	@Override
	public String toString() {
		String r = "";
		r += RomanDigit.M.repeat(m);
		r += RomanDigit.D.repeat(d);
		r += RomanDigit.C.repeat(c);
		r += RomanDigit.L.repeat(l);
		r += RomanDigit.X.repeat(x);
		r += RomanDigit.V.repeat(v);
		r += RomanDigit.I.repeat(i);
		return r;
	}

}
