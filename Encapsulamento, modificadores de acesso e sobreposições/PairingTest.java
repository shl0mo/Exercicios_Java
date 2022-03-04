package br.unicap.eng2.atividade01.question03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairingTest {

	private static String MESSAGE = "Cannot obtain pairs with different sizes!";

	@Test
	public void getPairsZero() {
		String s1 = "";
		String s2 = "";
		try {
			Pairing pairing = new Pairing(s1, s2);
			Pair[] actual = pairing.getPairs();
			Pair[] expected = new Pair[0];
			Assertions.assertArrayEquals(expected, actual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}

	}

	@Test
	public void printPairsZero() {
		String s1 = "";
		String s2 = "";
		try {
			Pairing pairing = new Pairing(s1, s2);
			String actual = pairing.toString();
			String expected = "";
			Assertions.assertEquals(expected, actual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}
	}

	@Test
	public void getPairsOne() {
		String s1 = "Person 1";
		String s2 = "Person 2";
		try {
			Pairing pairing = new Pairing(s1, s2);
			Pair[] actual = pairing.getPairs();
			Pair pairOne = new Pair("Person 1", "Person 2");
			Pair[] expected = new Pair[1];
			expected[0] = pairOne;
			Assertions.assertArrayEquals(expected, actual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}
	}

	@Test
	public void printPairsOne() {
		String s1 = "Person 1";
		String s2 = "Person 2";
		try {
			Pairing pairing = new Pairing(s1, s2);
			String actual = pairing.toString();
			String expected = "(Person 1, Person 2)";
			Assertions.assertEquals(expected, actual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}

	}

	@Test
	public void threePairings() {
		String s1 = "Person 1, Person 3, Person 5";
		String s2 = "Person 2, Person 4, Person 6";

		try {
			Pairing pairing = new Pairing(s1, s2);
			String actual = pairing.toString();
			String expected = "(Person 1, Person 2), "
					+ "(Person 3, Person 4), "
					+ "(Person 5, Person 6)";
			Assertions.assertEquals(expected, actual);
		} catch (Exception e) {
			Assertions.fail(e.getMessage());
		}

	}

	@Test
	public void threePairingsDifferentSizesLeftGreater() {
		String s1 = "Person 1, Person 3, Person 5";
		String s2 = "Person 2, Person 4";

		try {
			new Pairing(s1, s2);
			Assertions.fail(MESSAGE);
		} catch (Exception e) {
			Assertions.assertEquals(MESSAGE, e.getMessage());
		}

	}

	@Test
	public void threePairingsDifferentSizesRightGreater() {
		String s1 = "Person 1, Person 3";
		String s2 = "Person 2, Person 4, Person 6";
		try {
			new Pairing(s1, s2);
			Assertions.fail(MESSAGE);
		} catch (Exception e) {
			Assertions.assertEquals(MESSAGE, e.getMessage());
		}
	}
}
