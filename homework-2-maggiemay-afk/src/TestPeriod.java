import java.util.Calendar;
import java.util.TimeZone;

import edu.uwm.apc430.Duration;
import edu.uwm.apc430.Period;
import edu.uwm.apc430.Time;
import edu.uwm.cs.junit.LockedTestCase;


public class TestPeriod extends LockedTestCase {
	protected static void assertNotEquals(Object o1, Object o2) {
		assertFalse(o1 + " should not be equal to " + o2, o1.equals(o2));
	}

	protected static void assertException(Class<? extends Throwable> c, Runnable r) {
		try {
			r.run();
			assertFalse("Exception should have been thrown",true);
		} catch (RuntimeException ex) {
			assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
		}       
	}   
	
	private static Calendar pollOpen() {
		// Spring primary 2022: Make sure you vote!
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
		cal.set(2022, Calendar.FEBRUARY, 15, 7, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	
	/// locked tests
	
	public void test() {
		Calendar cal = pollOpen(); // 7am on election day
		Time pollsOpen = new Time(cal);
		cal.set(Calendar.HOUR_OF_DAY, 20);
		Time pollsClose = new Time(cal);
		
		Period polls = new Period(pollsOpen,pollsClose);
		assertEquals(Ts(82369862),polls.getLength().toString()); // don't forget .0!
	}
	
	/// testAX: constructor calls and accessors
	
	public void testA1() {
		Calendar now = pollOpen(); // 7am on election day
		Time start = new Time(now);
		now.add(Calendar.MINUTE,50);
		Time stop = new Time(now);
		Duration length = Duration.MINUTE.scale(50);
		Period p;
		
		p = new Period(start,length);
		assertEquals(start,p.getStart());
		assertEquals(length,p.getLength());
		assertEquals(stop,p.getStop());
	}
		
	public void testA2() {
		Calendar now = pollOpen();
		Time start = new Time(now);
		now.add(Calendar.MINUTE,50);
		Time stop = new Time(now);
		Duration length = Duration.MINUTE.scale(50);
		Period p;

		p = new Period(start,stop);
		assertEquals(start,p.getStart());
		assertEquals(length,p.getLength());
		assertEquals(stop,p.getStop());
	}
	
	public void testA3() {
		Calendar now = pollOpen();
		Time start = new Time(now);
		now.add(Calendar.MINUTE,50);
		Time stop = new Time(now);
		Duration length = Duration.MINUTE.scale(50);
		Period p;

		p = new Period(length,stop);
		assertEquals(start,p.getStart());
		assertEquals(length,p.getLength());
		assertEquals(stop,p.getStop());
		
	}
	
	public void testA5() {
		Calendar now = pollOpen();
		Time start = new Time(now);
		now.add(Calendar.MINUTE,50);
		Duration length = Duration.INSTANTANEOUS;
		Period p;
		
		p = new Period(start,length);
		assertEquals(start,p.getStart());
		assertEquals(length,p.getLength());
		assertEquals(start,p.getStop());
	}
	
	public void testA6() {
		Calendar now = pollOpen();
		Time start = new Time(now);
		now.add(Calendar.MINUTE,50);
		Duration length = Duration.INSTANTANEOUS;
		Period p;
		
		p = new Period(start,start);
		assertEquals(start,p.getStart());
		assertEquals(length,p.getLength());
		assertEquals(start,p.getStop());
	}
	
	public void testA7() {
		Calendar now = pollOpen();
		now.add(Calendar.MINUTE,50);
		Time stop = new Time(now);
		Duration length = Duration.INSTANTANEOUS;
		Period p;

		p = new Period(length,stop);
		assertEquals(stop,p.getStart());
		assertEquals(length,p.getLength());
		assertEquals(stop,p.getStop());
	}

	public void testA8() {
		assertException(NullPointerException.class, () -> new Period(new Time(), (Time)null));
		assertException(NullPointerException.class, () -> new Period(new Time(), (Duration)null));
	}

	public void testA9() {
		Calendar open = pollOpen();
		Time start = new Time(open);
		Time later = start.add(Duration.HOUR);

		// Hint: try adding a difference!
		assertException(IllegalArgumentException.class, () -> new Period(later,start));
	}
	
	
	
	/// testEX: testing equality
		
	public void testE1() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p1a = new Period(Duration.HOUR,p1.getStop());

		assertEquals(p1,p1a);
	}

	public void testE2() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p1b = new Period(p1.getStart(),p1.getStop());

		assertEquals(p1,p1b);
	}

	public void testE3() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p1a = new Period(Duration.HOUR,p1.getStop());
		Period p1b = new Period(p1.getStart(),p1.getStop());
		
		assertEquals(p1a,p1b);
	}

	public void testE4() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p2 = new Period(p1.getStart(), Duration.MINUTE);
		
		assertFalse(p1.equals(p2));
		assertFalse(p2.equals(p1));
	}

	public void testE5() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p3 = new Period(p1.getStop(), Duration.HOUR);
		
		assertFalse(p1.equals(p3));
		assertFalse(p3.equals(p1));
	}

	public void testE6() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		
		assertFalse(p1.equals(null));
	}

	public void testE7() {
		Period p1 = new Period(new Time(), Duration.HOUR);

		assertFalse(p1.equals(Duration.HOUR));
	}

	public void testE8() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		
		assertNotEquals(p1,p1.getStart());
	}

	
	/// testHX: testing hashcode
	
	public void testH1() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p1a = new Period(Duration.HOUR,p1.getStop());
		
		assertEquals(p1.hashCode(),p1a.hashCode());
	}

	public void testH2() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p1b = new Period(p1.getStart(),p1.getStop());
		
		assertEquals(p1.hashCode(),p1b.hashCode());		
	}

	public void testH3() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p2 = new Period(p1.getStart(), Duration.MINUTE);

		assertNotEquals(p1.hashCode(),p2.hashCode());
	}

	public void testH4() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p2 = new Period(p1.getStart(), Duration.MINUTE);
		Period p3 = new Period(p1.getStop(), Duration.HOUR);
		
		assertNotEquals(p2.hashCode(),p3.hashCode());
	}

	public void testH5() {
		Period p1 = new Period(new Time(), Duration.HOUR);
		Period p3 = new Period(p1.getStop(), Duration.HOUR);
		
		assertNotEquals(p3.hashCode(),p1.hashCode());
	}
	
	
	/// toString
	
	public void testS1() {
		Calendar open = pollOpen();
		Period p = new Period(new Time(open),Duration.MINUTE.scale(50));
		assertEquals("[UTC AD 2022/02/15 13:00:00; 50.0 min.]",p.toString());
	}

	
	
	// bad errors
	
	public void testX9() {
		// 9 different ways to pass null to a constructor
		try {
			new Period((Time)null,(Duration)null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period((Time)null,(Time)null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period((Duration)null,(Time)null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period(new Time(),(Duration)null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period(new Time(),(Time)null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period(Duration.HOUR,(Time)null);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period((Time)null,Duration.HOUR);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period((Time)null,new Time());
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		try {
			new Period((Duration)null,new Time());
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
		
		Time t = new Time();
		try {
			new Period(t,t.subtract(Duration.MILLISECOND));
		} catch (ArithmeticException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			assertTrue("threw wrong exception: " + ex,ex instanceof IllegalArgumentException);
		}		
	}
}
