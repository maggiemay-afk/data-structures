import java.util.Comparator;

import edu.uwm.apc430.RowComparator;
import edu.uwm.cs.junit.LockedTestCase;


public class TestRowComparator extends LockedTestCase {
	protected static void assertNegative(String message, int value) {
		assertTrue(message + " should be negative: " + value, value < 0);
	}
	
	protected static void assertPositive(String message, int value) {
		assertTrue(message + " should be positive: " + value, value > 0);
	}

	public static String[] row(String... row) {
		return row;
	}
	
	/**
	 * Return the sign of a number.  Return -1, 0 or 1.
	 * @param v number to check
	 * @return sign of number
	 */
	private static int sgn(int v) {
		if (v < 0) return -1;
		if (v > 0) return 1;
		return 0;
	}

	private Comparator<String[]> rc;
	
	
	/// Locked Tests
	
	public void test() {
		rc = new RowComparator(1,true);
		// sgn returns -1 for a negative number, 1 for a positive number and 0 for zero
		assertEquals(Ti(1644554732),sgn(rc.compare(row("0","house"),row("0","hovel"))));
		rc = new RowComparator(0,false);
		assertEquals(Ti(1465964561),sgn(rc.compare(row(""),row("hello"))));
		// choose a column to get result 0
		String[] row1 = row("A","0","a");
		String[] row2 = row("B","","a");
		assertEquals(0,new RowComparator(Ti(1520733897),true).compare(row1,row2));
	}
	
	
	/// Regular Tests
	
	public void testA() {
		rc = new RowComparator(1,true);
		assertEquals(0,rc.compare(row("a","1","A"), row("b","1","B")));
	}
	
	public void testB() {
		rc = new RowComparator(0,true);
		assertPositive("B>A",rc.compare(row("B","1","a"), row("A","2","a")));
	}
	
	public void testC() {
		rc = new RowComparator(1,true);
		assertNegative("1<2",rc.compare(row("a","1","B"), row("a","2","A")));
	}
	
	public void testD() {
		rc = new RowComparator(1,false);
		assertEquals(0,rc.compare(row("1","b","A"), row("2","b","B")));
	}
	
	public void testE() {
		rc = new RowComparator(1,false);
		assertPositive("1<2",rc.compare(row("a","1","B"), row("A","2","A")));
	}
	
	public void testF() {
		rc = new RowComparator(1,false);
		assertNegative("b>a",rc.compare(row("A","b","1"), row("B","a","1")));
	}
	
	public void testG() {
		rc = new RowComparator(1,true);
		assertEquals(0,rc.compare(row("A","1"), row("B","1")));
	}
	
	public void testH() {
		rc = new RowComparator(0,false);
		assertNegative("2>1",rc.compare(row("2"), row("1")));
	}
	
	public void testI() {
		rc = new RowComparator(2,true);
		assertPositive("AB>AA",rc.compare(row("","A","AB"), row("","B","AA")));
	}
	
	public void testJ() {
		rc = new RowComparator(0,false);
		assertNegative("AA>A",rc.compare(row("AA"),row("A")));
	}
}
