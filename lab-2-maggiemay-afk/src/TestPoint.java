import junit.framework.TestCase;
import edu.uwm.apc430.Point;


public class TestPoint extends TestCase {

	protected static void assertNotEquals(Object o1, Object o2) {
		if (o1 == null) assertNull(o2);
		else assertFalse(o1.equals(o2));
	}
	
	public void test0() {
		Point p = new Point(0,0);
		assertEquals(0,p.x());
		assertEquals(0,p.y());
		Point q = new Point(0,0);
		assertTrue(p.equals(q));
		assertEquals(p,q);
	}
	
	public void test1() {
		Point p = new Point(0,0);
		Point q = new Point(0,1);
		assertFalse(p.equals(q));
		assertNotEquals(p,q);
	}
	
	public void test2() {
		Point p = new Point(47,55);
		Point q = new Point(47,55);
		assertTrue(p.equals(q));
		assertEquals(p,q);
	}
	
	public void test3() {
		Point p = new Point(-4,5);
		assertEquals("Point(-4,5)",p.toString());
	}
	
	public void test4() {
		Point p = new Point(400,-3);
		assertEquals("Point(400,-3)",p.toString());
	}
}
