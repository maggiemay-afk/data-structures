import java.util.NoSuchElementException;

import edu.uwm.apc430.ArrayStack;
import junit.framework.TestCase;


public class TestArrayStack extends TestCase {
	ArrayStack<String> s = new ArrayStack<String>();
	
	public void testRemoveEmpty() {
		try {
			s.pop();
			assertFalse("Shouldn't have been able to remove from empty queue", true);
		}
		catch (Exception e) {
			assertTrue("wrong exception thrown", e instanceof NoSuchElementException);
		}
	}
	
	public void testAddOne() {
		s.push("hello");
		assertEquals("hello",s.pop());
	}
	
	public void testAddMultiple() {
		s.push("1");
		s.push("2");
		s.push("3");
		s.push("4");
		s.push("5");
		assertEquals("5",s.pop());
		assertEquals("4",s.pop());
		assertEquals("3",s.pop());
		assertEquals("2",s.pop());
		assertEquals("1",s.pop());
		
	}
	
	public void testAddMultiple2() {
		s.push("1");
		s.push("2");
		s.push("3");
		assertEquals("3",s.pop());
		assertEquals("2",s.pop());
		s.push("4");
		s.push("5");
		assertEquals("5",s.pop());
		assertEquals("4",s.pop());
		assertEquals("1",s.pop());
	}
	
	public void testAddMax() {
		for (int i = 0; i < 10; i++) {
			assertTrue("Failed add on " + i + "th enqueue", s.push(Integer.toString(i)));
		}
		
		assertFalse("Should've failed on 11th add, over capacity", s.push("return false"));
	}

}
