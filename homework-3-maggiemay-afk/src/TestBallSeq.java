import java.awt.Color;
import java.util.function.Supplier;

import edu.uwm.apc430.Ball;
import edu.uwm.apc430.BallSeq;
import edu.uwm.apc430.Point;
import edu.uwm.apc430.Vector;
import edu.uwm.cs.junit.LockedTestCase;



public class TestBallSeq extends LockedTestCase {
    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	

	private BallSeq s;
	Ball b1 = new Ball(new Point(0,0), new Vector(), Color.BLACK);
	Ball b2 = new Ball(new Point(100,0), new Vector(10,0), Color.BLUE);
	Ball b3 = new Ball(new Point(100,100), new Vector(), Color.GREEN);
	Ball b4 = new Ball(new Point(0,-100), new Vector(10,20), Color.YELLOW);
	Ball b5 = new Ball(new Point(0,100), new Vector(0,-10), Color.RED);
	
	Ball b[] = { null, b1, b2, b3, b4, b5 };
	
	// Using the above array
	// convert a Ball result to an integer:
	// 0 = null, 1 = b1, 2 = b2 etc.
	// if the expression causes an error, the index is -1.
	// If the ball is not in the array, the result "NONE OF THE ABOVE" is -2.
	int ix(Supplier<Ball> p) {
		try {
			Ball ball = p.get();
			if (ball == null) return 0;
			for (int i=0; i < b.length; ++i) {
				if (ball == b[i]) return i;
			}
			return -2;
		} catch (RuntimeException ex) {
			return -1;
		}
	}
	
	@Override
	public void setUp() {
		s = new BallSeq();
		try {
			assert 3/(int)b1.getLoc().x() == 42 : "OK";
			System.err.println("Assertions must be enabled to use this test suite.");
			System.err.println("In Eclipse: add -ea in the VM Arguments box under Run>Run Configurations>Arguments");
			assertFalse("Assertions must be -ea enabled in the Run Configuration>Arguments>VM Arguments",true);
		} catch (ArithmeticException ex) {
			return;
		}
	}

	// This test tests many things.
	// We recommend that you run the UnlockTests to unlock all its tests at once.
	public void test() {
		assertEquals(Ti(887770454),s.size());
		// In the following, if a Ball index is called for ("ix"), answer:
		// 0 if the result will be null
		// 1 if the result will be the Ball b1
		// 2 if the result will be the Ball b2
		// 3,4,5 etc.
		// -1 if the code will crash with an exception
		// -2 none of the above (some other ball)
		assertEquals(Ti(491728531),ix(() -> s.getCurrent()));
		s.addBefore(b1);
		assertEquals(Ti(1854083915),ix(() -> s.getCurrent()));
		s.addAfter(null);
		assertEquals(Ti(236938571),ix(() -> s.getCurrent()));
		s.addBefore(b3);
		assertEquals(Ti(710084632),ix(() -> s.getCurrent()));
		s.advance();
		assertEquals(Ti(565750963),ix(() -> s.getCurrent()));
		s.advance();
		assertEquals(Ti(371995505),ix(() -> s.getCurrent()));
		s.addBefore(b2.clone());
		assertEquals(Ti(221507525),ix(() -> s.getCurrent()));
		s.advance();
		assertEquals(Ti(25562286),ix(() -> s.getCurrent()));
		testcont(s);		
	}
	
	// Continuation of test:
	private void testcont(BallSeq s) {
		s.advance();
		assertEquals(3,ix(()->s.getCurrent()));
		// At this point s is [clone(b2),b1,*b3,null] with * marking current
		BallSeq s2 = new BallSeq();
		// In the following, if a Ball index is called for ("ix"), answer:
		// 0 if the result will be null
		// 1 if the result will be the Ball b1
		// 2 if the result will be the Ball b2, etc for 3, 4, 5
		// -1 if the code will crash with an exception
		// -2 none of the above (some other ball)
		s2.addBefore(b4);
		s2.addAfter(b5);
		assertEquals(Ti(1860957759),ix(() -> s2.getCurrent()));
		s.addAll(s2);
		assertEquals(Ti(566769707),s.size());
		// What does addAll() say about what is current afterwards?
		assertEquals(Ti(1724402076),ix(()->s.getCurrent()));
		assertEquals(Ti(1459925108),ix(() -> s2.getCurrent()));
		s.advance();
		assertEquals(Ti(1196621866),ix(()->s.getCurrent()));
		s.advance();
		assertEquals(Ti(1006831199),ix(()->s.getCurrent()));
		testremove(s);
	}
	
	private void testremove(BallSeq s) {
		// s is [clone(b2), b1, b3, null, *b4, b5] where * marks current element
		// In the following, if a Ball index is called for ("ix"), answer:
		// 0 if the result will be null
		// 1 if the result will be the Ball b1
		// 2 if the result will be the Ball b2, etc for 3, 4, 5
		// -1 if the code will crash with an exception
		// -2 none of the above (some other ball)
		s.removeCurrent();
		assertEquals(Ti(980256184),ix(() -> s.getCurrent()));
		s.removeCurrent();
		assertEquals(Ti(1957337308),ix(() -> s.getCurrent()));
		s.start();
		s.removeCurrent();
		assertEquals(Ti(1557219254),ix(() -> s.getCurrent()));
		s.advance();
		assertEquals(Ti(1191281444),ix(() -> s.getCurrent()));
	}

	
	/// IMPORTANT!
	// You will be graded on the first failure.
	// So if you fail test01, 
	// then you will get no credit for passing any other tests.
	// So concentrate on passing the earlier tests.
	
	// These tests assume that the "addBefore" method which we gave you is working.
	// If you change the implementation we gave you, these are likely to fail.
	
	
	/// test0X tests of constructors and size()

	public void test00() {
		assertEquals(0, s.size());
	}
	
	public void test01() {
		s.addBefore(b1);
		assertEquals(1, s.size());
	}
	
	public void test02() {
		s = new BallSeq(1);
		s.addBefore(b2);
		s.addBefore(b3);
		assertEquals(2, s.size());
	}
	
	public void test03() {
		s = new BallSeq(0);
		s.addBefore(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		assertEquals(3, s.size());
	}
	
	public void test04() {
		s.addBefore(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		s.addBefore(null);
		assertEquals(4, s.size());
	}
	
	public void test05() {
		s = new BallSeq(1000);
		assertEquals(0, s.size());
	}
	
	public void test06() {
		s.addBefore(null);
		s.addBefore(null);
		s.addBefore(null);
		s.addBefore(null);
		s.addBefore(null);
		assertEquals(5, s.size());
	}

	public void test09() {
		assertException(IllegalArgumentException.class, () -> new BallSeq(-1));
	}
	
	
	/// test1X tests of isCurrent()
	
	public void test10() {
		assertFalse(s.isCurrent());
	}
	
	public void test11() {
		s.addBefore(b1);
		assertTrue(s.isCurrent());
	}
	
	public void test12() {
		s.addBefore(b1);
		s.addBefore(b2);
		assertTrue(s.isCurrent());
	}
	
	public void test13() {
		s = new BallSeq(88);
		assertFalse(s.isCurrent());
		
		s.addBefore(b2);
		assertTrue(s.isCurrent());
	}
	
	public void test14() {
		s.addBefore(b1);
		s.addBefore(null);
		
		assertTrue(s.isCurrent());
	}
	
	
	/// test2X of getCurrent()
	
	public void test20() {
		s.addBefore(b2);
		assertSame(b2, s.getCurrent());
	}
	
	public void test21() {
		s.addBefore(b2);
		s.addBefore(b3);
		assertSame(b3, s.getCurrent());
	}
	
	public void test22() {
		s.addBefore(b2);
		s.addBefore(null);
		
		assertNull(s.getCurrent());
	}
	
	public void test23() {
		assertException(IllegalStateException.class, () -> s.getCurrent());
	}
	
	
	/// test3x: now we add "advance()"
	
	public void test30() {
		s.addBefore(b2);
		s.advance();
		assertFalse(s.isCurrent());
		assertException(IllegalStateException.class, () -> s.getCurrent());
	}
	
	public void test31() {
		s.addBefore(b2);
		s.addBefore(b4);
		
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2, s.getCurrent());
	}

	public void test32() {
		s.addBefore(b2);
		s.advance();
		s.addBefore(b5);
		
		assertTrue(s.isCurrent());
		assertSame(b5, s.getCurrent());
		
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2, s.getCurrent());
		
		s.advance();
		assertFalse(s.isCurrent());
		assertException(IllegalStateException.class, () -> s.advance());
	}
	
	public void test33() {
		s.addBefore(null);
		s.addBefore(b2);
		
		s.advance();
		assertTrue(s.isCurrent());
		assertNull(s.getCurrent());
	}
	
	public void test34() {
		assertException(IllegalStateException.class, () -> s.advance());
	}
	
	
	/// test4x tests with start. isCurrent, getCurrent and advance
	
	public void test40() {
		s.start();
		assertFalse(s.isCurrent());
	}
	
	public void test41() {
		s.addBefore(b1);
		s.start();
		
		assertSame(b1, s.getCurrent());
		
		s.advance();
		assertException(IllegalStateException.class, () -> s.getCurrent());
		assertFalse(s.isCurrent());
	}
	
	public void test42() {
		s.addBefore(b2);
		s.addBefore(b3);
		
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b3, s.getCurrent());
		
		s.advance();
		assertSame(b2, s.getCurrent());
		assertTrue(s.isCurrent());
		
		s.advance();
		assertFalse(s.isCurrent());
		assertFalse(s.isCurrent());
	}
	
	public void test43() {
		s.addBefore(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		
		assertSame(b1, s.getCurrent());
		
		s.advance();
		
		assertSame(b2, s.getCurrent());
		
		s.start();
		
		assertSame(b1, s.getCurrent());
		
		s.advance();
		
		assertSame(b2, s.getCurrent());
		
		s.advance();
		
		assertSame(b3, s.getCurrent());
		
		s.advance();
		
		assertException(IllegalStateException.class, () -> s.advance());
		assertFalse(s.isCurrent());
			
		s.start();
		
		assertTrue(s.isCurrent());
	}
	
	public void test44() {
		s.addBefore(b3);
		s.addBefore(b4);
		s.addBefore(null);
		
		s.start();
		
		assertEquals(3, s.size());
		assertNull(s.getCurrent());
		assertTrue(s.isCurrent());
		
		s.advance();
		
		assertSame(b4, s.getCurrent());
	}
		
	public void test46() {
		s.start();
		assertException(IllegalStateException.class, () -> s.getCurrent());
	}
	
	public void test47() {
		s.start();
		assertException(IllegalStateException.class, () -> s.removeCurrent());
	}
	
	public void test49() {
		s.start();
		assertException(IllegalStateException.class, () -> s.advance());
	}
	
	
	/// test5x: tests of removeCurrent
	
	public void test50() {
		assertException(IllegalStateException.class, () -> s.removeCurrent());
		assertEquals(0, s.size());
	}
	
	public void test51() {
		s.addBefore(b1);
		s.removeCurrent();
		
		assertEquals(0, s.size());
		assertFalse(s.isCurrent());
	}
	
	public void test52() {
		s.addBefore(b4);
		s.addBefore(b2);
		
		s.removeCurrent();
		
		assertEquals(1, s.size());
		assertSame(b4, s.getCurrent());
		
		s.start();
		
		assertSame(b4, s.getCurrent());
	}
	
	public void test53() {
		s.addBefore(b4);
		s.addBefore(b3);
		
		s.advance();
		s.removeCurrent();
		
		assertEquals(1, s.size());
		assertFalse(s.isCurrent());
		
		s.start();
		
		assertSame(b3, s.getCurrent());
	}
	
	public void test54() {
		s.addBefore(b3);
		s.addBefore(b2);
		s.addBefore(b1);
		
		s.start();
		s.removeCurrent();
		
		assertTrue(s.isCurrent());
		assertSame(b2, s.getCurrent());
		
		s.advance();
		
		assertTrue(s.isCurrent());
		assertSame(b3, s.getCurrent());
		
		s.advance();
		
		assertException(IllegalStateException.class, () -> s.getCurrent());
		assertFalse(s.isCurrent());
	}
	
	public void test55() {
		s.addBefore(b3);
		s.addBefore(b4);
		s.addBefore(b5);
		
		s.advance();
		s.removeCurrent();
		
		assertEquals(2, s.size());
		assertTrue(s.isCurrent());
		assertSame(b3, s.getCurrent());
		
		s.advance();
		
		assertFalse(s.isCurrent());
		assertException(IllegalStateException.class, () -> s.getCurrent());
		
		s.start();
		
		assertTrue(s.isCurrent());
		assertSame(b5, s.getCurrent());
	}
	
	public void test56() {
		s.addBefore(b4);
		s.addBefore(b3);
		s.addBefore(b2);
		
		s.advance();
		s.advance();
		s.removeCurrent();
		
		assertException(IllegalStateException.class, () -> s.getCurrent());
		assertEquals(2, s.size());
		
		s.start();
		
		assertSame(b2, s.getCurrent());
		
		s.advance();
		
		assertSame(b3, s.getCurrent());
	}
	
	public void test57() {
		s.addBefore(b1);
		s.addBefore(null);
		s.addBefore(b2);
		s.addBefore(null);
		s.addBefore(b4);
		
		assertEquals(5, s.size());
		
		s.removeCurrent();
		
		assertEquals(4, s.size());
		assertNull(s.getCurrent());
		
		s.advance();
		
		assertSame(b2, s.getCurrent());
		
		s.advance();
		
		assertNull(s.getCurrent());
		
		s.advance();
		
		assertSame(b1, s.getCurrent());
	}
	
	public void test58() {
		s.addBefore(b4);
		s.addBefore(b2);
		s.addBefore(null);
		
		s.advance();
		s.advance();
		s.removeCurrent();
		
		assertException(IllegalStateException.class, () -> s.removeCurrent());
	}
	
	
	/// test6x: tests of addAfter
	
	public void test60() {
		s.addAfter(b1);
		
		assertEquals(1,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
	}

	public void test61() {
		s.addAfter(b1);
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertEquals(1,s.size());
		assertFalse(s.isCurrent());
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(1,s.size());
	}

	public void test62() {
		s.addAfter(b1);
		s.removeCurrent();
		
		assertException(IllegalStateException.class, ()->s.getCurrent());

		assertEquals(0,s.size());	
		s.addAfter(b2);
		s.start();
		assertSame(b2,s.getCurrent());
		assertEquals(1,s.size());
	}
	
	public void test63() {
		s.addAfter(b2);
		s.advance();
		
		assertException(IllegalStateException.class, () -> s.advance());
	}
	
	public void test64() {
		s.addBefore(b1);
		s.addAfter(b2);
		
		assertSame(b2, s.getCurrent());
		assertEquals(2,s.size());

		s.advance();
		assertFalse(s.isCurrent());
		
		s.start();
		assertSame(b1, s.getCurrent());
		s.advance();
		assertSame(b2, s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void test65() {
		s.addBefore(b1);
		s.advance();
		s.addAfter(b2);
		
		assertSame(b2, s.getCurrent());
		assertEquals(2,s.size());

		s.advance();
		assertFalse(s.isCurrent());
		
		s.start();
		assertSame(b1, s.getCurrent());
		s.advance();
		assertSame(b2, s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
		
	public void test66() {
		s.addBefore(b1);
		s.addBefore(b3);
		s.addAfter(b2);
		
		assertEquals(3,s.size());
		assertSame(b2, s.getCurrent());
		
		s.advance();
		assertSame(b1, s.getCurrent());
		
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b2,s.getCurrent());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
		s.start();
		assertSame(b3,s.getCurrent());
		s.advance();
		s.start();
		assertSame(b3,s.getCurrent());
	}
	
	public void test67() {
		s.addBefore(b1);
		s.addBefore(b2);
		s.advance();
		s.addAfter(b3);
		
		assertEquals(3,s.size());
		assertSame(b3, s.getCurrent());
		
		s.advance();
		assertFalse(s.isCurrent());
		
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
	}

	public void test68() {
		s.addBefore(b1);
		s.addBefore(b2);
		s.advance();
		s.advance();
		s.addAfter(b3);

		assertEquals(3,s.size());
		assertSame(b3, s.getCurrent());
		
		s.advance();
		assertFalse(s.isCurrent());
		
		s.start();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
	}
	
	public void test69() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAfter(b5);
		assertSame(b5,s.getCurrent());
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAfter(b5);
		s.addAfter(b1);
		s.addAfter(b2);
		assertEquals(12,s.size());
		s.removeCurrent();
		assertFalse(s.isCurrent());
		s.start();
		s.removeCurrent();
		assertSame(b2,s.getCurrent());
		assertEquals(10,s.size());
		s.start();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());
	}
	
	
	/// test7X: testing addAll without aliasing
	
	public void test70() {
		BallSeq se = new BallSeq();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
		s.addBefore(b1);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(1,s.size());
		assertEquals(0,se.size());
		assertSame(b1,s.getCurrent());
		s.advance();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(1,s.size());
		assertEquals(0,se.size());
		s.addAfter(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(2,s.size());
		assertEquals(0,se.size());
		s.start();
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		assertEquals(2,s.size());
		assertEquals(0,se.size());
	}
	
	public void test71() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertTrue(se.isCurrent());
		assertEquals(1,s.size());
		assertEquals(1,se.size());
		s.start();
		assertSame(b1,s.getCurrent());
		assertSame(b1,se.getCurrent());
	}
	
	public void test72() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(2,s.size());
		assertEquals(1,se.size());
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}
	
	public void test73() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(2,s.size());
		assertEquals(1,se.size());
		assertTrue(se.isCurrent());
		assertSame(b1,se.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}
	
	public void test74() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		se.advance();
		s.addAfter(b3);
		s.addBefore(b2);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertFalse(se.isCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());	
	}
	
	public void test75() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
	}
	
	public void test76() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		s.addAfter(b2);
		s.addAfter(b3);
		s.advance();
		assertFalse(s.isCurrent());
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertEquals(3,s.size());
		assertEquals(1,se.size());
		assertSame(b1,se.getCurrent());
		s.start();
		assertSame(b2,s.getCurrent());
		s.advance();
		assertSame(b3,s.getCurrent());
		s.advance();
		assertSame(b1,s.getCurrent());
	}

	public void test77() {
		BallSeq se = new BallSeq();
		se.addAfter(b2);
		se.addBefore(b1);	
		s.addAfter(b4);
		s.addBefore(b3);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
	}

	public void test78() {
		BallSeq se = new BallSeq();
		se.addAfter(b2);
		se.addBefore(b1);
		se.advance();
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAll(se);
		assertTrue(s.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		assertSame(b2,se.getCurrent()); se.advance();
		assertFalse(se.isCurrent());
		// check s
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
		s.start();
		assertSame(b3,s.getCurrent());
	}

	public void test79() {
		BallSeq se = new BallSeq();
		se.addBefore(b2);
		se.addBefore(b1);
		se.advance();
		se.advance();
		s.addAfter(b3);
		s.addAfter(b4);
		s.advance();
		assertFalse(s.isCurrent());
		assertFalse(se.isCurrent());
		s.addAll(se);
		assertFalse(s.isCurrent());
		assertFalse(se.isCurrent());
		assertEquals(4,s.size());
		assertEquals(2,se.size());
		s.start();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());	
	}

	
	/// test8X: testing addAll in difficult situations
	
	public void test80() {
		// lots of adding:
		BallSeq se = new BallSeq();
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		se.addAfter(b3);
		se.addAfter(b4);
		se.addAfter(b5);
		// se has 24 elements
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(se);
		assertEquals(26,s.size());
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		s.addAll(se);
		assertEquals(50,s.size());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent()); s.advance();
		assertSame(b5,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b4,s.getCurrent());
	}
	
	public void test81() {
		s.addAll(s);
		assertFalse(s.isCurrent());
		assertEquals(0,s.size());
	}
	
	
	public void test82() {
		s.addAfter(b1);
		s.addAll(s);
		assertEquals(2,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent());
		s.advance();
		assertFalse(s.isCurrent());
	}
	
	public void test83() {
		s.addAfter(b1);
		s.advance();
		s.addAll(s);
		assertEquals(2,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void test84() {
		s.addAfter(b1);
		s.removeCurrent();
		assertEquals(0,s.size());
		assertFalse(s.isCurrent());
	}
	
	public void test85() {
		s.addAfter(b2);
		s.addBefore(b1);
		s.addAll(s);
		assertEquals(4,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}
	
	public void test86() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(s);
		assertEquals(4,s.size());
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}

	public void test87() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.advance();
		assertFalse(s.isCurrent());
		s.addAll(s);
		assertFalse(s.isCurrent());
		assertEquals(4,s.size());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}

	public void test88() {
		s.addAfter(b1);
		s.addAfter(b2);
		s.addAll(s);
		s.removeCurrent();
		s.addBefore(b3);
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());
		s.start();
		assertSame(b1,s.getCurrent()); s.advance();
		s.advance();
		s.addAll(s);
		assertEquals(8,s.size());
		assertTrue(s.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b3,s.getCurrent()); s.advance();
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b2,s.getCurrent()); s.advance();
		assertFalse(s.isCurrent());		
	}
	
	public void test89() {
		BallSeq se = new BallSeq();
		se.addAfter(b1);
		se.addAfter(b2);	
		s.addAfter(b3);
		s.addAfter(b4);
		s.addAll(se);
		s.advance();
		s.addAfter(b5);
		s.advance();
		assertTrue(s.isCurrent());
		assertSame(b2,s.getCurrent());
		assertEquals(5,s.size());
		assertEquals(2,se.size());
		assertSame(b2,se.getCurrent());
		se.advance();
		assertFalse(se.isCurrent());
		se.start();
		assertSame(b1,se.getCurrent());
	}
	
	
	/// test9x: tests of clone.  
	// (We give this to you so the tests should all pass.)
	
	public void test90() {
		BallSeq c = s.clone();
		assertFalse(c.isCurrent());
		assertEquals(0, c.size());
	}
	
	public void test91() {
		s.addAfter(b1);
		BallSeq c = s.clone();
		
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent()); s.advance();
		assertSame(b1,c.getCurrent()); c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}
	
	public void test92() {
		s.addAfter(b1);
		s.advance();
		BallSeq c = s.clone();
		
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
	}

	public void test93() {
		BallSeq c = s.clone();
		assertFalse(c.isCurrent());
		
		s.addAfter(b1);
		c = s.clone();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		
		s.addAfter(b2);
		c = s.clone();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		
		s.addAfter(b3);
		c = s.clone();
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		s.start();
		c.start();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		
		s.start();
		c = s.clone();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());		
	}
	
	public void test94() {
		s.addAfter(b1);
		s.addAfter(b3);
		s.addBefore(b2);
		s.removeCurrent();
		
		BallSeq c = s.clone();
		
		assertEquals(2,c.size());
		
		assertTrue(s.isCurrent());
		assertTrue(c.isCurrent());
		
		assertSame(b3,s.getCurrent());
		assertSame(b3,c.getCurrent());
	}

	public void test95() {
		s.addAfter(b1);
		s.addAfter(b2);
		
		BallSeq c = s.clone();
		s.addBefore(b3);
		c.addBefore(b4);
		
		assertSame(b3,s.getCurrent());
		assertSame(b4,c.getCurrent());
		s.advance();
		c.advance();
		assertSame(b2,s.getCurrent());
		assertSame(b2,c.getCurrent());
		s.advance();
		c.advance();
		assertFalse(s.isCurrent());
		assertFalse(c.isCurrent());
		
		s.start();
		c.start();
		assertSame(b1,s.getCurrent());
		assertSame(b1,c.getCurrent());
		s.advance();
		c.advance();
		assertSame(b3,s.getCurrent());
		assertSame(b4,c.getCurrent());
	}

}
