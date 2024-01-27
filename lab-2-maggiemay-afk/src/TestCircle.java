import java.awt.Color;

import junit.framework.TestCase;
import edu.uwm.apc430.Circle;
import edu.uwm.apc430.Point;


public class TestCircle extends TestCase {

	protected static void assertException(Class<?> c, Runnable r) {
		try {
			r.run();
		} catch (RuntimeException e) {
			assertTrue("Expected throwing exception of " + c, c.isInstance(e));
			if (c != NullPointerException.class) {
				String s = e.getMessage();
				assertTrue("Should have a message: " + c, s.length() > 0);
			}
		}
	}
	
	public void testA() {
		Circle c = new Circle(new Point(1,2),3);
		c.move(10, -10);
		// if you fail this test, move isn't working:
		assertEquals(11, c.getCenter().x());
		// if you fail the next test, perhaps you didn't finish Point ?
		assertEquals(new Point(11,-8),c.getCenter());
	}
	
	public void testB() {
		Circle c = new Circle(new Point(100,100),20);
		assertEquals(20,c.getRadius());
		c.setRadius(50);
		assertEquals(50,c.getRadius());
	}
	
	public void testC() {
		Circle c = new Circle(new Point(100,100),20);
		assertException(IllegalArgumentException.class,() -> c.setRadius(-1));
	}
	
	public void testD() {
		Circle c = new Circle(new Point(100,100),20);
		assertException(IllegalArgumentException.class,() -> c.setRadius(0));
	}
	
	public void testE() {
		Circle c = new Circle(new Point(100,100),20);
		c.setRadius(1);
		assertEquals(1,c.getRadius());
	}
	
	public void testF() {
		Circle c = new Circle(new Point(30,50),10);
		Circle d = c.clone();
		assertFalse(c == d);
	}
	
	public void testG() {
		Circle c = new Circle(new Point(30,50),10);
		Circle d = c.clone();
		assertEquals(new Point(30,50),d.getCenter());
	}
	
	public void testH() {
		Circle c = new Circle(new Point(30,50),10);
		Circle d = c.clone();
		assertEquals(10,d.getRadius());
	}
	
	public void testI() {
		Circle c = new Circle(new Point(100,30),17,Color.GREEN);
		assertEquals(Color.GREEN,c.getColor());
	}
	
	public void testJ() {
		// If you fail this test, it means you didn't implement
		// clone() according to the textbook.
		// See pages 81-85.
		Circle cp = new Circle(new Point(100,30),17) {
			@Override
			public int getRadius() {
				return 2*super.getRadius();
			}
		};
		assertEquals(34,cp.getRadius());
		Circle dp = cp.clone();
		assertEquals(34,dp.getRadius());
		dp.setRadius(10);
		assertEquals(20,dp.getRadius());
	}
}
