import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import edu.uwm.apc430.Duration;
import edu.uwm.apc430.Time;
import edu.uwm.cs.junit.LockedTestCase;


public class TestTime extends LockedTestCase {

	private static Calendar homeworkDue() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
		cal.set(2022, Calendar.FEBRUARY, 6, 22, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	private static void shortDelay() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// ignore.  We've woken up anyway
		}
	}

	protected static void assertNotEquals(Object o1, Object o2) {
		assertFalse(o1 + " should not be equal to " + o2, o1.equals(o2));
	}
	
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
	
    
    // Locked tests
    
    public void test() {
    	Calendar cal = homeworkDue();
    	Time t = new Time(cal);
    	String homeworkDueDay = Ts(1810847165); // Homework due NEXT day in yyyy/mm/dd format (next day because it's in Greenwich mean time)
    	String homeworkDueTime = Ts(52824056); // Homework time in hh:mm format (Greenwich mean time!)
    	assertEquals("UTC AD " + homeworkDueDay + " " + homeworkDueTime + ":00",t.toString());
    	
    	Time t2 = t.add(Duration.DAY);
    	assertEquals(Ts(1781127927),t2.toString()); // don't forget seconds: ":00"

    	Time t3 = t2.subtract(Duration.MINUTE);
    	assertEquals(Ts(639908865),t3.toString()); // don't forget seconds: ":00"
    	
    	Duration d = t3.difference(t2);
    	assertEquals(Ts(942264642),d.toString()); // don't forget ".0"
    }
    
    
    /// test0X: equals tests
    
    public void test00() {
    	Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		assertFalse(t1.equals(null));
    }
    
    public void test01() {
    	Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		Time t1a = new Time(cal);
		assertEquals(t1,t1a);
    }
    
    public void test02() {
    	Time t1 = new Time();
    	shortDelay();
    	Time t2 = new Time();
    	assertNotEquals(t1,t2);
    }

	public void test03() {
    	Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.MINUTE, 1);
		Time t2 = new Time(cal);
		assertNotEquals(t2,t1);
    }
    
	public void test09() {
		assertException(NullPointerException.class, () -> new Time(null));
	}
	
	
	/// text1X: testing hash codes
	
    public void test11() {
    	Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		Time t1a = new Time(cal);
		assertEquals(t1.hashCode(),t1a.hashCode());
    }
    
    public void test12() {
    	Time t1 = new Time();
    	shortDelay();
    	Time t2 = new Time();
    	assertNotEquals(t1.hashCode(),t2.hashCode());
    }

	public void test13() {
    	Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.MINUTE, 1);
		Time t2 = new Time(cal);
		assertNotEquals(t2.hashCode(),t1.hashCode());
    }
	

	/// test2X: (nothing now)
	

	/// test3X: testing toString()
	
	public void test31() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		assertEquals("UTC AD 2022/02/07 04:00:00",t1.toString());
	}
	
	public void test32() {
		Calendar cal = homeworkDue();
		cal.add(Calendar.YEAR, -3000);
		// Three thousand years ago, homework probably was NOT
		// due on the topic of Data structures at 10:00pm.
		Time t1 = new Time(cal);
		assertEquals("UTC BC 0979/02/07 04:00:00",t1.toString());
	}
	
	public void test33() {
		Calendar cal = homeworkDue();
		cal.set(1776, Calendar.JULY, 4, 12, 0, 0);
		Time t = new Time(cal);
		assertEquals("UTC AD 1776/07/04 18:00:00",t.toString());
	}
	
	
	/// test4X: test difference
	
	public void test40() {
		Time t = new Time();
		Duration d0 = t.difference(t);
		assertEquals(Duration.INSTANTANEOUS,d0);
	}
	
	public void test41() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		Time t1a = new Time(cal);
		assertEquals(Duration.INSTANTANEOUS,t1.difference(t1a));
	}
	
	public void test42() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.MINUTE, 1);
		Time t2 = new Time(cal);
		assertEquals(Duration.MINUTE,t1.difference(t2));
	}
	
	public void test43() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.MINUTE, 1);
		Time t2 = new Time(cal);
		assertEquals(Duration.MINUTE,t2.difference(t1));
	}

	public void test49() {
		Time t = new Time();
		assertException(NullPointerException.class,() -> t.difference(null));
	}

	
	/// test5X: test add
	
	public void test50() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		assertEquals(t1,t1.add(Duration.INSTANTANEOUS));
	}
	
	public void test51() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		assertNotEquals(t1,t1.add(Duration.MILLISECOND));
	}
	
	public void test52() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		Time t1a = new Time(cal);
		t1.add(Duration.DAY); // shouldn't have side-effect
		assertEquals(t1a,t1);
	}
	
	public void test53() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		Time t2 = t1.add(Duration.DAY);
		assertEquals("UTC AD 2022/02/08 04:00:00",t2.toString());
	}
	
	public void test54() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		Time t2 = t1.add(Duration.YEAR.scale(4));
		assertEquals("UTC AD 2026/02/07 04:00:00",t2.toString());
	}
	
	public void test55() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.MINUTE, 1);
		Time t2 = new Time(cal);
		assertEquals(t2,t1.add(Duration.MINUTE));
	}
	
	public void test59() {
		Time t = new Time();
		assertException(NullPointerException.class,() -> t.add(null));
	}
	
	
	// test 6X: testing subtract
	
	public void test60() {
		Time t = new Time();
		assertEquals(t, t.subtract(Duration.INSTANTANEOUS));
	}
	
	public void test61() {
		Time t = new Time();
		assertNotEquals(t, t.subtract(Duration.MILLISECOND));
	}
	
	public void test62() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.MINUTE, 1);
		Time t2 = new Time(cal);
		assertEquals(t1,t2.subtract(Duration.MINUTE));	
	}
	
	public void test63() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		cal.set(Calendar.HOUR_OF_DAY, 21);
		Time t2 = new Time(cal);
		assertEquals(t2,t1.subtract(Duration.HOUR));
	}
	
	public void test69() {
		Calendar cal = homeworkDue();
		Time t1 = new Time(cal);
		assertException(NullPointerException.class,() -> t1.subtract(null));
	}

	
	public void test99() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(0));
		Time t = new Time(c);
		assertEquals("UTC AD 1970/01/01 00:00:00",t.toString());
		assertFalse(t.equals(c));
		assertFalse(t.equals(Duration.INSTANTANEOUS));
	}
}
