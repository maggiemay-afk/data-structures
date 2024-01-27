import java.util.NoSuchElementException;

import edu.uwm.apc430.LinkedQueue;
import junit.framework.TestCase;


public class TestLinkedQueue extends TestCase {
	LinkedQueue<String> q = new LinkedQueue<String>();
	
	
	public void setUp() {
	    try {
	    	assert 1/(5^5) == 42 : "OK";
	    	System.err.println("Make sure assertions are enabled while testing");
	    	System.err.println("In Eclipse: add -ea in the VM Arguments box under Run>Run Configurations>Arguments");
	    	assertFalse("Assertions must be -ea enabled in the Run Configuration>Arguments>VM Arguments",true);
	    } catch (ArithmeticException ex) {
	    	return;
	   	}
	}
	
	
	public void testRemoveEmpty() {
		try {
			q.remove();
			assertFalse("Shouldn't have been able to remove from empty queue", true);
		}
		catch (Exception e) {
			assertTrue("wrong exception thrown", e instanceof NoSuchElementException);
		}
	}
	
	public void testAddOne() {
		q.add("hello");
		assertEquals("hello",q.remove());
	}
	
	public void testAddMultiple() {
		q.add("1");
		q.add("2");
		q.add("3");
		q.add("4");
		q.add("5");
		assertEquals("1",q.remove());
		assertEquals("2",q.remove());
		assertEquals("3",q.remove());
		assertEquals("4",q.remove());
		assertEquals("5",q.remove());
	}
	
	public void testAddMultiple2() {
		q.add("1");
		q.add("2");
		q.add("3");
		assertEquals("1",q.remove());
		assertEquals("2",q.remove());
		q.add("4");
		q.add("5");
		assertEquals("3",q.remove());
		assertEquals("4",q.remove());
		assertEquals("5",q.remove());
	}
	
	public void testAddMultiple3() {
		q.add("1");
		q.add("2");
		assertEquals("1",q.remove());
		assertEquals("2",q.remove());
		q.add("3");
		q.add("4");
		q.add("5");
		assertEquals("3",q.remove());
		assertEquals("4",q.remove());
		assertEquals("5",q.remove());
	}
}
