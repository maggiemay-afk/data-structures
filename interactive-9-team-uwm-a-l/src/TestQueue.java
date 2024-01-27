import junit.framework.TestCase;

import java.util.NoSuchElementException;

import edu.uwm.apc430.ArrayQueue;


public class TestQueue extends TestCase {
    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	

	private ArrayQueue<Integer> queue;
	
	protected void setUp() {
		queue = new ArrayQueue<>();
	}
	
	public void test00() {
		assertEquals(0,queue.size());
	}
	
	public void test01() {
		queue.enqueue(42);
		assertEquals(1,queue.size());
	}
	
	public void test02() {
		queue.enqueue(0);
		assertEquals(0,queue.peek().intValue());
		assertEquals(1,queue.size());
	}
	
	public void test03() {
		queue.enqueue(3);
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(0,queue.size());
	}
	
	public void test04() {
		assertException(NoSuchElementException.class, () -> queue.peek());
	}
	
	public void test05() {
		assertException(NoSuchElementException.class, () -> queue.dequeue());
	}
	
	public void test06() {
		queue.enqueue(6);
		queue.dequeue();
		assertException(NoSuchElementException.class, () -> queue.peek());		
	}
	
	public void test07() {
		queue.enqueue(7);
		queue.dequeue();
		assertException(NoSuchElementException.class, () -> queue.dequeue());		
	}
	
	public void test08() {
		queue.enqueue(8);
		queue.peek();
		assertEquals(8,queue.peek().intValue());
	}
	
	public void test09() {
		queue.enqueue(9);
		assertEquals(2,queue.capacity());
	}
	
	public void test10() {
		queue.enqueue(1);
		queue.enqueue(0);
		assertEquals(2,queue.size());
	}
	
	public void test11() {
		queue.enqueue(1);
		queue.enqueue(11);
		assertEquals(1,queue.peek().intValue());
	}
	
	public void test12() {
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(1,queue.dequeue().intValue());
	}
	
	public void test13() {
		queue.enqueue(1);
		queue.enqueue(3);
		queue.peek();
		assertEquals(2,queue.size());
	}
	
	public void test14() {
		queue.enqueue(1);
		queue.enqueue(4);
		queue.dequeue();
		assertEquals(1,queue.size());
	}
	
	public void test15() {
		queue.enqueue(1);
		queue.enqueue(5);
		queue.dequeue();
		assertEquals(5,queue.peek().intValue());
	}
	
	public void test16() {
		queue.enqueue(1);
		queue.enqueue(6);
		queue.dequeue();
		assertEquals(6,queue.dequeue().intValue());
	}
	
	public void test17() {
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(7);
		assertEquals(7,queue.peek().intValue());
	}
	
	public void test18() {
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(8);
		assertEquals(8,queue.dequeue().intValue());
	}
	
	public void test19() {
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(9);
		queue.dequeue();
		assertEquals(0,queue.size());
	}
	
	public void test20() {
		queue.enqueue(2);
		queue.enqueue(0);
		queue.dequeue();
		queue.dequeue();
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		assertEquals(0,queue.size());
	}
	
	public void test21() {
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(21);
		assertEquals(1,queue.size());
		assertEquals(21,queue.peek().intValue());
		assertEquals(2,queue.capacity());
		assertEquals(1,queue.size());
	}
	
	public void test22() {
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(22);
		queue.dequeue();
		queue.enqueue(222);
		assertEquals(222,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		assertEquals(0,queue.size());
		assertEquals(2,queue.capacity());
	}
	
	public void test23() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(3);
		assertEquals(2,queue.size());
		assertEquals(2,queue.peek().intValue());
		assertEquals(2,queue.size());
		int cap = queue.capacity();
		assertTrue(cap == 2 || cap == 4);
	}
	
	public void test24() {
		queue.enqueue(1);;
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(3);
		assertEquals(2,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(3,queue.peek().intValue());
		assertEquals(1,queue.size());
		int cap = queue.capacity();
		assertTrue(cap == 2 || cap == 4);
	}
	
	public void test25() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(3);
		queue.dequeue();
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		assertEquals(0,queue.size());
		int cap = queue.capacity();
		assertTrue(cap == 2 || cap == 4);
	}
	
	public void test26() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(3);
		queue.dequeue();
		queue.enqueue(4);
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(4,queue.peek().intValue());
		assertEquals(1,queue.size());
		int cap = queue.capacity();
		assertTrue(cap == 2 || cap == 4);
	}
	
	public void test27() {
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		queue.enqueue(2);
		assertEquals(1,queue.size());
		assertEquals(2,queue.peek().intValue());
		assertEquals(2,queue.capacity());
	}
	
	public void test28() {
		queue.enqueue(2);
		queue.dequeue();
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		queue.enqueue(5);
		assertEquals(1,queue.size());
		assertEquals(5,queue.peek().intValue());
		assertEquals(2,queue.capacity());
	}
	
	public void test29() {
		queue.enqueue(2);
		queue.enqueue(9);
		queue.dequeue();
		queue.dequeue();
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		queue.enqueue(29);
		assertEquals(1,queue.size());
		assertEquals(29,queue.peek().intValue());
	}
	
	public void test30() {
		queue.enqueue(3);
		queue.enqueue(null);
		queue.enqueue(30);
		assertEquals(3,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(3,queue.peek().intValue());
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(null,queue.peek());
		assertEquals(null,queue.dequeue());
		assertEquals(1,queue.size());
		assertEquals(30,queue.peek().intValue());
		assertEquals(30,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
	}
	
	public void test31() {
		queue.enqueue(3);
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(31);
		queue.enqueue(13);
		assertEquals(3,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(1,queue.peek().intValue());
		assertEquals(1,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(31,queue.peek().intValue());
		assertEquals(31,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(13,queue.peek().intValue());
		assertEquals(13,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
	}
	
	public void test32() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(3);
		queue.dequeue();
		queue.enqueue(23);
		queue.enqueue(32);
		assertEquals(3,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(3,queue.peek().intValue());
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(23,queue.peek().intValue());
		assertEquals(23,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(32,queue.peek().intValue());
		assertEquals(32,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
	}
	
	public void test33() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(4);
		queue.dequeue();
		queue.enqueue(23);
		queue.enqueue(33);
		assertEquals(3,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(4,queue.peek().intValue());
		assertEquals(4,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(23,queue.peek().intValue());
		assertEquals(23,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(33,queue.peek().intValue());
		assertEquals(33,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
	}
	
	public void test34() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.enqueue(4);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(12);
		queue.enqueue(23);
		queue.enqueue(34);;
		assertEquals(3,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(12,queue.peek().intValue());
		assertEquals(12,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(4,queue.capacity());
		assertEquals(23,queue.peek().intValue());
		assertEquals(23,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(34,queue.peek().intValue());
		assertEquals(34,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
	}
	
	public void test35() {
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(35);
		queue.clear();
		assertEquals(0, queue.size());
		assertEquals(ArrayQueue.INITIAL_CAPACITY, queue.capacity());
	}

	public void test36() {
		queue.enqueue(3);
		queue.enqueue(6);
		queue.enqueue(36);
		queue.dequeue();
		queue.clear();
		assertEquals(0, queue.size());
	}
	
	public void test37() {
		queue.enqueue(3);
		queue.enqueue(7);
		queue.dequeue();
		queue.clear();
		queue.enqueue(37);
		assertEquals(1, queue.size());
		assertEquals(Integer.valueOf(37), queue.dequeue());
	}
	
	public void test38() {
		queue.enqueue(3);
		queue.enqueue(8);
		queue.enqueue(38);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(3);
		queue.dequeue();
		queue.enqueue(8);
		assertEquals(2, queue.size());
		assertEquals(4, queue.capacity());
		queue.clear();
		assertException(NoSuchElementException.class, () -> queue.dequeue());
		assertEquals(0, queue.size());
		queue.enqueue(3);
		queue.enqueue(8);
		assertEquals(3, queue.dequeue().intValue());
	}
	
	public void test40() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(4,queue.size());
		assertEquals(1,queue.peek().intValue());
		assertEquals(1,queue.dequeue().intValue());
		assertEquals(3,queue.size());
		assertEquals(2,queue.peek().intValue());
		assertEquals(2,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(3,queue.peek().intValue());
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(4,queue.peek().intValue());
		assertEquals(4,queue.dequeue().intValue());
		assertEquals(0,queue.size());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
	}
	
	public void test42() {
		queue.enqueue(1);;
		queue.enqueue(11);
		queue.dequeue();
		queue.enqueue(2);
		queue.enqueue(22);
		queue.dequeue();
		queue.enqueue(3);
		queue.enqueue(33);
		assertEquals(4,queue.size());
		assertEquals(2,queue.peek().intValue());
		assertEquals(2,queue.dequeue().intValue());
		assertEquals(3,queue.size());
		assertEquals(22,queue.peek().intValue());
		assertEquals(22,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(3,queue.peek().intValue());
		assertEquals(3,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(33,queue.peek().intValue());
		assertEquals(33,queue.dequeue().intValue());
		assertEquals(0,queue.size());
	}
	
	public void test44() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(11);
		queue.enqueue(22);
		queue.enqueue(33);
		queue.enqueue(44);
		assertEquals(4,queue.size());
		assertEquals(11,queue.peek().intValue());
		assertEquals(11,queue.dequeue().intValue());
		assertEquals(3,queue.size());
		assertEquals(22,queue.peek().intValue());
		assertEquals(22,queue.dequeue().intValue());
		assertEquals(2,queue.size());
		assertEquals(33,queue.peek().intValue());
		assertEquals(33,queue.dequeue().intValue());
		assertEquals(1,queue.size());
		assertEquals(44,queue.peek().intValue());
		assertEquals(44,queue.dequeue().intValue());
		assertEquals(0,queue.size());
	}
	
	public void test45() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.dequeue();
		queue.dequeue();
		
		queue.clear();
		assertEquals(ArrayQueue.INITIAL_CAPACITY, queue.capacity());
		
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(3, queue.dequeue().intValue());
	}
	
	public void test50() {
		queue.enqueue(-2);
		queue.enqueue(-1);
		queue.enqueue(0);
		queue.enqueue(1);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(5, queue.size());
		assertEquals(8, queue.capacity());
		assertEquals(1,  queue.dequeue().intValue());
		queue.enqueue(6);
		assertEquals(5, queue.size());
		assertEquals(8, queue.capacity());		
	}
	
	public void test60() {
		queue.enqueue(-2);
		queue.enqueue(-1);
		queue.enqueue(0);
		queue.enqueue(1);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		assertEquals(6, queue.size());
		assertEquals(8, queue.capacity());
		assertEquals(1,  queue.dequeue().intValue());
		queue.enqueue(7);
		assertEquals(6, queue.size());
		assertEquals(8, queue.capacity());	
	}
	
	public void test99() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		assertEquals(9,queue.size());
		assertEquals(16,queue.capacity());
		assertEquals(1,queue.dequeue().intValue());
		queue.enqueue(10);
		assertEquals(2,queue.dequeue().intValue());
		assertEquals(3,queue.dequeue().intValue());
		queue.enqueue(11);
		queue.enqueue(12);
		assertEquals(9,queue.size());
		assertEquals(4,queue.dequeue().intValue());
		assertEquals(5,queue.dequeue().intValue());
		assertEquals(6,queue.dequeue().intValue());
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(15);
		assertEquals(9,queue.size());
		assertEquals(7,queue.dequeue().intValue());
		assertEquals(8,queue.dequeue().intValue());
		assertEquals(9,queue.dequeue().intValue());
		assertEquals(10,queue.dequeue().intValue());
		queue.enqueue(16);
		queue.enqueue(17);
		assertEquals(11,queue.dequeue().intValue());
		assertEquals(12,queue.dequeue().intValue());
		assertEquals(13,queue.dequeue().intValue());
		queue.enqueue(18);
		assertEquals(14,queue.dequeue().intValue());
		assertEquals(15,queue.dequeue().intValue());
		assertEquals(16,queue.dequeue().intValue());
		queue.enqueue(19);
		assertEquals(17,queue.dequeue().intValue());
		assertEquals(18,queue.dequeue().intValue());
		assertEquals(19,queue.dequeue().intValue());
		assertException(NoSuchElementException.class,() -> queue.peek());
		assertException(NoSuchElementException.class,() -> queue.dequeue());	
		queue.enqueue(20);
		queue.enqueue(21);
		queue.enqueue(22);
		queue.enqueue(23);
		queue.enqueue(24);
		queue.enqueue(25);
		assertEquals(20,queue.dequeue().intValue());
		assertEquals(5,queue.size());
		queue.enqueue(26);
		queue.enqueue(27);
		queue.enqueue(28);
		queue.enqueue(29);
		assertEquals(9,queue.size());;
		assertEquals(16,queue.capacity());
		assertEquals(21,queue.peek().intValue());
	}
}
