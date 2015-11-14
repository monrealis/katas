package roman;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanParameterizedTest {
	private final int arab;
	private final String roman;

	public RomanParameterizedTest(int arab, String roman) {
		this.arab = arab;
		this.roman = roman;
	}

	@Parameters
	public static List<Object[]> x() throws IOException {
		List<Object[]> r = new ArrayList<Object[]>();
		Stream<String> lines = Files.lines(new File(
				"src/test/resources/input.txt").toPath());
		lines.map(s -> s.split("\t")).forEach(
				i -> r.add(new Object[] { Integer.parseInt(i[0]), i[1] }));
		lines.close();
		return r;
	}

	@Test
	public void test() {
		assertEquals(String.valueOf(arab), roman, new Roman(arab).toString());
	}
}
