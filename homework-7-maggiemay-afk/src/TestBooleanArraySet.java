import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.uwm.apc430.BooleanArraySet;
import edu.uwm.cs.junit.LockedTestCase;


public class TestBooleanArraySet extends LockedTestCase {
    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	

	private BooleanArraySet set;
	private Iterator<Integer> it;
	
	@Override
	protected void setUp() {
		try {
			assert set.size() == 42 : "OK";
			System.err.println("Assertions must be enabled to use this test suite.");
			System.err.println("In Eclipse: add -ea in the VM Arguments box under Run>Run Configurations>Arguments");
			assertFalse("Assertions must be -ea enabled in the Run Configuration>Arguments>VM Arguments",true);
		} catch (NullPointerException ex) {
			// good!
		}
		set = new BooleanArraySet();
	}
	
	/// Locked tests
	
	public void test() {
		set = new BooleanArraySet(16);
		assertEquals(Ti(1099901513),set.size());
		set.add(1);
		set.add(2);
		set.add(4);
		set.add(8);
		set.add(4);
		set.add(2);
		set.add(1);
		assertEquals(Ti(1600413609),set.size());
		set.clear();
		test1(false);
	}

	public void test1(boolean ignored) {
		// set is empty and then...
		set.add(10);
		set.add(2);
		set.add(20);
		it = set.iterator();
		assertEquals(Ti(1064518884),it.next().intValue());
		assertEquals(Ti(1475110700),it.next().intValue());
		assertEquals(Ti(1344982798),it.next().intValue());
		set.clear();
		test2(false);
	}
	
	public void test2(boolean ignored) {
		set.add(10);
		set.add(20);
		set.add(30);
		it = set.iterator();
		assertEquals(10,it.next().intValue());
		assertEquals(20,it.next().intValue());
		it.remove();
		assertEquals(Tb(1133555556),set.contains(20));
		assertEquals(Ti(247634351),set.size());
		assertEquals(Tb(171172910),it.hasNext());
		assertEquals(Ti(1513173901),it.next().intValue());
		it.remove();
		assertEquals(Tb(527398275),it.hasNext());
	}
	
	
	// test0X: tests of add and size
	
	public void test00() {
		assertEquals(0,set.size());
	}
	
	public void test01() {
		set = new BooleanArraySet(100);
		assertEquals(0,set.size());
	}
	
	public void test02() {
		assertTrue(set.add(3));
	}
	
	public void test03() {
		set.add(3);
		assertFalse(set.add(3));
	}
	
	public void test04() {
		set.add(3);
		assertEquals(1,set.size());
	}
	
	public void test05() {
		set.add(2);
		set.add(2);
		assertEquals(1,set.size());
	}
	
	public void test06() {
		set.add(2);
		assertTrue(set.add(3));
	}
	
	public void test07() {
		set.add(4);
		set.add(7);
		assertFalse(set.add(4));
	}
	
	public void test08() {
		set.add(5);
		set.add(8);
		set.add(5);
		set.add(8);
		assertEquals(2,set.size());
	}
	
	public void test09() {
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(1);
		set.add(3);
		set.add(5);
		assertEquals(5,set.size());
		assertTrue(set.add(10));
		assertFalse(set.add(5));
	}
	
	
	/// test1X : harder tests of add
	
	public void test10() {
		set.add(1000);
		assertTrue(set.add(32767));
	}
	
	public void test11() {
		set.add(0);
		assertEquals(1,set.size());
	}
	
	public void test12() {
		set.add(12000);
		set.add(12001);
		assertEquals(2,set.size());
	}
	
	public void test13() {
		set.add(1000000);
		set.add(5);
		assertFalse(set.add(1000000));
	}
	
	public void test14() {
		set.add(0);
		set.add(1);
		set.add(21);
		set.add(321);
		set.add(4321);
		set.add(54321);
		set.add(654321);
		set.add(7654321);
		set.add(87654321);
		set.add(987654321); // will be slow, that's OK
		assertEquals(10,set.size());
	}
	
	public void test15() {
		assertException(IllegalArgumentException.class,() -> set.add(-1));
	}
	
	public void test16() {
		set.add(16);
		assertException(IllegalArgumentException.class,() -> set.add(-5));
		assertEquals(1,set.size());
	}
	
	
	/// test2X : tests of iterators
	
	public void test20() {
		it = set.iterator();
		assertFalse(it.hasNext());
	}
	
	public void test21() {
		set.add(3);
		it = set.iterator();
		assertTrue(it.hasNext());
	}
	
	public void test22() {
		set.add(6);
		it = set.iterator();
		assertEquals(6,it.next().intValue());
	}
	
	public void test23() {
		set.add(23);
		it = set.iterator();
		it.next();
		assertFalse(it.hasNext());
	}
	
	public void test24() {
		set.add(2);
		set.add(4);
		it = set.iterator();
		assertTrue(it.hasNext());
		assertEquals(2,it.next().intValue());
		assertEquals(4,it.next().intValue());
		assertFalse(it.hasNext());
	}
	
	public void test25() {
		set.add(2);
		set.add(5);
		set.add(25);
		it = set.iterator();
		assertEquals(2,it.next().intValue());
		assertTrue(it.hasNext());
		assertEquals(5,it.next().intValue());
		assertEquals(25,it.next().intValue());
		assertFalse(it.hasNext());
	}
	
	public void test26() {
		set.add(26);
		set.add(13);
		set.add(2);
		it = set.iterator();
		assertEquals(2,it.next().intValue());
		Iterator<Integer> it2 = set.iterator();
		assertEquals(13,it.next().intValue());
		assertEquals(2,it2.next().intValue());
		assertEquals(26,it.next().intValue());
		assertTrue(it2.hasNext());
	}
	
	public void test27() {
		set.add(9);
		set.add(3);
		set.add(27);
		set.add(3);
		set.add(9);
		set.add(3);
		set.add(1);
		set.add(3);
		set.add(1);
		it = set.iterator();
		Iterator<Integer> it2 = set.iterator();
		assertEquals(1,it.next().intValue());
		assertEquals(3,it.next().intValue());
		assertEquals(1,it2.next().intValue());
		assertEquals(9,it.next().intValue());
		assertEquals(27,it.next().intValue());
		Iterator<Integer> it3 = set.iterator();
		assertFalse(it.hasNext());
		assertEquals(3,it2.next().intValue());
		assertEquals(9,it2.next().intValue());
		assertEquals(1,it3.next().intValue());
		assertEquals(27,it2.next().intValue());
		assertTrue(it3.hasNext());
	}
	
	public void test28() {
		it = set.iterator();
		assertException(NoSuchElementException.class,() -> it.next());
	}
	
	public void test29() {
		set.add(9);
		it = set.iterator();
		it.next();
		assertException(NoSuchElementException.class,() -> it.next());
	}
	
	
	/// test3X: Testing removal using an iterator
	
	public void test30() {
		set.add(3);
		it = set.iterator();
		it.next();
		it.remove();
		assertEquals(0,set.size());
	}
	
	public void test31() {
		set.add(3);
		set.add(1);
		it = set.iterator();
		it.next();
		it.remove();
		assertEquals(3,it.next().intValue());
	}
	
	public void test32() {
		set.add(3);
		set.add(2);
		it = set.iterator();
		it.next();
		it.next();
		it.remove();
		assertEquals(1,set.size());
		it = set.iterator();
		assertEquals(2,it.next().intValue());
	}
	
	public void test33() {
		set.add(3);
		set.add(33);
		it = set.iterator();
		it.next();
		it.remove();
		it.next();
		it.remove();
		assertEquals(0,set.size());
		assertFalse(it.hasNext());
	}
	
	public void test34() {
		set.add(3);
		set.add(4);
		set.add(34);
		it = set.iterator();
		it.next();
		it.remove();
		assertEquals(4,it.next().intValue());
		assertTrue(it.hasNext());
		assertEquals(34,it.next().intValue());
		assertFalse(it.hasNext());
	}
	
	public void test35() {
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(2);
		set.add(4);
		
		it = set.iterator();
		it.next();
		it.next();
		it.next();
		it.remove();
		it.next();
		it.next();
		it.remove();
		assertFalse(it.hasNext());
		
		it = set.iterator();
		assertEquals(1,it.next().intValue());
		assertEquals(2,it.next().intValue());
		assertEquals(4,it.next().intValue());
	}
	
	public void test36() {
		set.add(3);
		set.add(6);
		it = set.iterator();
		it.next();
		it.next();
		it.remove();
		assertException(NoSuchElementException.class,() -> it.next());
	}
	
	public void test37() {
		set.add(3);
		set.add(7);
		it = set.iterator();
		// next() not called yet, 
		assertException(IllegalStateException.class, () -> it.remove());
		assertEquals(2,set.size());
	}
	
	public void test38() {
		set.add(3);
		set.add(8);
		it = set.iterator();
		it.next();
		it.remove();
		// already removed: cannot remove again
		assertException(IllegalStateException.class, () -> it.remove());
		assertEquals(1,set.size());
	}
	
	public void test39() {
		set.add(1);
		set.add(3);
		set.add(9);
		set.add(13);
		set.add(39);
		
		it = set.iterator();
		it.next();
		it.next();
		it.remove();
		it.next();
		it.remove();
		// already removed: cannot remove again
		assertException(IllegalStateException.class, () -> it.remove());
		assertEquals(3,set.size());
	}
	
	private static final int TESTS = 1_000_000;
	
	public void test40() {
		set.add(123456789);
		it = set.iterator();
		for (int i=0; i < TESTS; ++i) {
			assertTrue(it.hasNext());
		}
		assertEquals(123456789,it.next().intValue());
		for (int i=0; i < TESTS; ++i) {
			assertFalse(it.hasNext());
		}
	}
}
