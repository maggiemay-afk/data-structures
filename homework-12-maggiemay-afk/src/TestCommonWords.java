import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import edu.uwm.apc430.CommonWords;
import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs.util.AbstractEntry;
import edu.uwm.cs.util.DefaultEntry;


public class TestCommonWords extends LockedTestCase {
	protected static void assertNegative(String message, int value) {
		assertTrue(message + " should be negative: " + value, value < 0);
	}
	
	protected static void assertPositive(String message, int value) {
		assertTrue(message + " should be positive: " + value, value > 0);
	}

    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	

	private void assertDone(Iterator<?> it) {
		if (it.hasNext()) {
			Object x = it.next();
			assertFalse("Iterator should be done, but still had " + x, true);
		}
	}

	
	private CommonWords cw;
	
	@Override
	protected void setUp() {
		cw = new CommonWords();
	}
	
	
	/// Locked Tests
	
	public void test() {
		cw = new CommonWords();
		cw.add("Red");
		cw.add("Red");
		cw.add("Green");
		cw.add("Blue");
		Iterator<Entry<String,Integer>> it = cw.iterator();
		// should give the most common words first,
		// and then by alphabetical order
		Entry<String,Integer> e = it.next();
		assertEquals(Ts(780653132),e.getKey());
		assertEquals(Ti(1854096895),e.getValue().intValue());
		e = it.next();
		assertEquals(Ts(248200609),e.getKey());
		assertEquals(Ti(484590692),e.getValue().intValue());
		e = it.next();
		assertEquals(Ts(1832979271),e.getKey());
		assertEquals(1,e.getValue().intValue());
	}
	
	
	/// test0X: testing the comparator
	
	private static class TestEntry extends AbstractEntry<String,Integer> {		
		@Override
		public String getKey() {
			return "Answer";
		}

		@Override
		public Integer getValue() {
			return 42;
		}
	}
	
	public void test00() {
		Entry<String,Integer> e = new TestEntry();
		assertEquals(0,CommonWords.entryComparator.compare(e,e));
	}

	public void test01() {
		Entry<String,Integer> e = new TestEntry();
		assertEquals(0,CommonWords.entryComparator.compare(e,new TestEntry()));
	}
	
	public void test02() {
		Entry<String,Integer> e = new TestEntry();
		assertEquals(0,CommonWords.entryComparator.compare(new DefaultEntry<>("Answer",42),e));		
	}
	
	public void test03() {
		Entry<String,Integer> e = new TestEntry();
		assertPositive("Count 43 should be after 42: result",CommonWords.entryComparator.compare(e,new DefaultEntry<>("Wrong Answer",43)));
	}
	
	public void test04() {
		Entry<String,Integer> e = new TestEntry();
		assertNegative("Count 43 should be after 42: result",CommonWords.entryComparator.compare(new DefaultEntry<>("Wrong Answer",43),e));		
	}
	
	public void test05() {
		Entry<String,Integer> e = new TestEntry();
		assertPositive("W should come after A: result",CommonWords.entryComparator.compare(new DefaultEntry<>("Wrong Answer",42),e));		
		
	}
	
	public void test06() {
		Entry<String,Integer> e = new TestEntry();
		assertNegative("W should come after A: result",CommonWords.entryComparator.compare(e,new DefaultEntry<>("Wrong Answer",42)));				
	}
	
	public void test07() {
		Map<String,Integer> m = new TreeMap<String,Integer>();
		m.put("Apples", 10);
		Entry<String,Integer> e = m.entrySet().iterator().next();
		assertEquals(0,CommonWords.entryComparator.compare(new DefaultEntry<String,Integer>("Apples",10),e));
	}
	
	public void test08() {
		assertPositive("Watermelon=10 should come after Pears=20",CommonWords.entryComparator.compare(new DefaultEntry<>("Watermelon",10),new DefaultEntry<>("Pears",20)));
	}
	
	public void test09() {
		assertNegative("Apples=20 should come before Pears=20",CommonWords.entryComparator.compare(new DefaultEntry<>("Apples",20),new DefaultEntry<>("Pears",20)));
	}
	
	
	/// test1X: Small tests of common words
	
	public void test10() {
		assertFalse(cw.iterator().hasNext());
	}
	
	public void test11() {
		cw.iterator();
		assertException(IllegalStateException.class,() -> cw.add("Apples"));	
	}
	
	public void test12() {
		cw.add("Apples");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("Apples",1),it.next());
	}
	
	public void test13() {
		cw.add("Apples");
		cw.iterator();
		assertException(IllegalStateException.class,() -> cw.add("Apples"));			
	}
	
	public void test14() {
		cw.add("Apples");
		cw.add("Apples");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("Apples",2),it.next());		
		assertDone(it);
	}
	
	public void test15() {
		assertException(NullPointerException.class,() -> cw.add(null));
	}
	
	public void test16() {
		cw.add("Apples");
		assertException(NullPointerException.class,() -> cw.add(null));
	}
	
	
	/// test2X: larger but still small tests
	
	public void test20() {
		cw.add("one");
		cw.add("two");
		cw.add("one");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("one",2),it.next());
		assertEquals(new DefaultEntry<>("two",1),it.next());
		assertDone(it);
	}
	
	public void test21() {
		cw.add("one");
		cw.add("two");
		cw.add("two");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("two",2),it.next());
		assertEquals(new DefaultEntry<>("one",1),it.next());
	}
	
	public void test22() {
		cw.add("one");
		cw.add("two");
		cw.add("one");
		cw.add("two");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("one",2),it.next());
		assertEquals(new DefaultEntry<>("two",2),it.next());
	}
	
	public void test23() {
		cw.add("one");
		cw.add("two");
		cw.add("three");
		cw.add("two");
		cw.add("one");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("one",2),it.next());
		assertEquals(new DefaultEntry<>("two",2),it.next());
		assertEquals(new DefaultEntry<>("three",1),it.next());
		assertDone(it);
	}
	
	public void test24() {
		cw.add("one");
		cw.add("two");
		cw.add("three");
		cw.add("one");
		cw.add("two");
		cw.add("one");
		Iterator<?> it = cw.iterator();
		assertEquals(new DefaultEntry<>("one",3),it.next());
		assertEquals(new DefaultEntry<>("two",2),it.next());
		assertEquals(new DefaultEntry<>("three",1),it.next());
		assertDone(it);
	}
	
	
	/// test3X: test of order
	
	public void test31() {
		cw.add("Oshkosh");
		cw.add("Milwaukee");
		cw.add("Platteville");
		Iterator<Entry<String,Integer>> it = cw.iterator();
		assertEquals(new DefaultEntry<>("Milwaukee",1),it.next());
		assertEquals("Need to create new sorted set: can't simply use the map's entry set iterator",new DefaultEntry<>("Oshkosh",1),it.next());
	}
	
	public void test32() {
		cw.add("Oshkosh");
		cw.add("Milwaukee");
		cw.add("Platteville");
		cw.add("Platteville");
		Iterator<Entry<String,Integer>> it = cw.iterator();
		assertEquals("Need to create new sorted set: can't simple use the map's entry set iterator",new DefaultEntry<>("Platteville",2),it.next());
	}
	
	public void test33() {
		cw.add("River Falls");
		cw.add("Stevens Point");
		cw.add("Oshkosh");
		cw.add("Milwaukee");
		cw.add("Platteville");
		cw.add("River Falls");
		cw.add("Stevens Point");
		Iterator<?> it1 = cw.iterator();
		assertEquals(new DefaultEntry<>("River Falls",2),it1.next());
		Iterator<?> it2 = cw.iterator();
		assertEquals(new DefaultEntry<>("River Falls",2),it2.next());
		// the first iterator shouldn't be affected.
		assertEquals(new DefaultEntry<>("Stevens Point",2),it1.next());
	}
}
