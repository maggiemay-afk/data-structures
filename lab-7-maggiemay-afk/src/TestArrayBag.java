import java.util.Iterator;

import edu.uwm.apc430.StringArrayBag;
import junit.framework.TestCase;


public class TestArrayBag extends TestCase {
	StringArrayBag bag;
	
	@Override
	public void setUp() {
		bag = new StringArrayBag();
		bag.addMany("One","Three","Negative Three","Five","Three","Negative Three","Negative One","Zero","Zero","Zero","Negative Three","Zero");
	}
	
	public void testCountOccurencesForEmpty() {
		bag = new StringArrayBag();
		assertEquals(0,bag.countOccurrences("Ten"));
	}
	
	public void testCountOccurencesForNone() {
		assertEquals(0,bag.countOccurrences("Ten"));
		assertEquals(0,bag.countOccurrences("Negative Two"));
	}
	
	public void testCountOccurencesForOne() {
		assertEquals(1,bag.countOccurrences("Five"));
		assertEquals(1,bag.countOccurrences("Negative One"));
	}
	
	public void testCountOccurencesForMultiple() {
		assertEquals(2,bag.countOccurrences("Three"));
		assertEquals(3,bag.countOccurrences("Negative Three"));
		assertEquals(4,bag.countOccurrences("Zero"));
	}
	
	public void testCountOccurencesForMultipleObject() {
		bag=new StringArrayBag();
		bag.addMany(new String("One"), new String("Three"), new String("Negative Three"), new String("Five"),
					new String("Three"), new String("Negative Three"), new String("Negative One"), new String("Zero"),
					new String("Zero"), new String("Zero"), new String("Negative Three"), new String("Zero"));
		assertEquals(2,bag.countOccurrences("Three"));
		assertEquals(3,bag.countOccurrences("Negative Three"));
		assertEquals(4,bag.countOccurrences("Zero"));
	}
	
	public void testCountOccurrencesWithIterator() {
		assertEquals(0,bag.countOccurrencesWithIterator("Ten"));
		assertEquals(0,bag.countOccurrencesWithIterator("Negative Two"));
		
		assertEquals(1,bag.countOccurrencesWithIterator("Five"));
		assertEquals(1,bag.countOccurrencesWithIterator("Negative One"));
		
		assertEquals(2,bag.countOccurrencesWithIterator("Three"));
		assertEquals(3,bag.countOccurrencesWithIterator("Negative Three"));
		assertEquals(4,bag.countOccurrencesWithIterator("Zero"));
		
		bag = new StringArrayBag();
		assertEquals(0,bag.countOccurrencesWithIterator("Ten"));
		
		bag=new StringArrayBag();
		bag.addMany(new String("One"), new String("Three"), new String("Negative Three"), new String("Five"),
					new String("Three"), new String("Negative Three"), new String("Negative One"), new String("Zero"),
					new String("Zero"), new String("Zero"), new String("Negative Three"), new String("Zero"));
		assertEquals(2,bag.countOccurrencesWithIterator("Three"));
		assertEquals(3,bag.countOccurrencesWithIterator("Negative Three"));
		assertEquals(4,bag.countOccurrencesWithIterator("Zero"));
		bag.remove("Zero");
		assertEquals(3,bag.countOccurrencesWithIterator("Zero"));
	}
	
	public void testNext() {
		assertSameCollection("One","Three","Negative Three","Five","Three","Negative Three","Negative One","Zero","Zero","Zero","Negative Three","Zero");
	}
	
	private void assertSameCollection(String... expectedCollection) {
		if (bag.size() > expectedCollection.length ) assertFalse("intBag was greater than the expected collection size", true);
		if (bag.size() < expectedCollection.length ) assertFalse("intBag was less than the expected collection size", true);
		
		Iterator<String> itr = bag.iterator();
		for (int i = 0; i < expectedCollection.length; i++) {
			String str = itr.next();
			if (!str.equals(new String(expectedCollection[i]))) {
				assertFalse("On " + i + " element, Expected: " + expectedCollection[i] + " but was: " + str.toString(), true);
			}
		}
	}
}
