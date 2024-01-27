import java.util.NoSuchElementException;

import edu.uwm.apc430.GridLoc;
import edu.uwm.apc430.LightsOut;
import edu.uwm.apc430.Plan;
import edu.uwm.cs.junit.LockedTestCase;


public class TestPlan extends LockedTestCase {
    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	

	private LightsOut lightsOut2 = new LightsOut(2,2);
	
	private GridLoc[][] loc = 
		{
			{GridLoc.get(0,0), GridLoc.get(0,1), GridLoc.get(0,2)},
			{GridLoc.get(1,0), GridLoc.get(1,1), GridLoc.get(1,2)},
			{GridLoc.get(2,0), GridLoc.get(2,1), GridLoc.get(2,2)}
	};

	private int OOOO = 0,  XOOO = 1,  OXOO = 2,  XXOO = 3;
	private int OOXO = 4,  XOXO = 5,  OXXO = 6,  XXXO = 7;
	private int OOOX = 8,  XOOX = 9,  OXOX = 10, XXOX = 11;
	private int OOXX = 12, XOXX = 13, OXXX = 14, XXXX = 15;
	
	public void test() {
		assertEquals(Ti(544317646),Plan.EMPTY_PLAN.length());
		// OO/OO = 0,  XO/OO = 1,  OX/OO = 2,  XX/OO = 3;
		// OO/XO = 4,  XO/XO = 5,  OX/XO = 6,  XX/XO = 7;
		// OO/OX = 8,  XO/OX = 9,  OX/OX = 10, XX/OX = 11;
		// OO/XX = 12, XO/XX = 13, OX/XX = 14, XX/XX = 15;
		assertEquals(Ti(1503352754), Plan.EMPTY_PLAN.apply(lightsOut2, OXOX));
		assertEquals(Ts(294738047),Plan.EMPTY_PLAN.toString());
		testNext(false);
	}
	
	private void testNext(boolean ignored) {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		// p is a plan to press the upper-right button
		// OO/OO = 0,  XO/OO = 1,  OX/OO = 2,  XX/OO = 3;
		// OO/XO = 4,  XO/XO = 5,  OX/XO = 6,  XX/XO = 7;
		// OO/OX = 8,  XO/OX = 9,  OX/OX = 10, XX/OX = 11;
		// OO/XX = 12, XO/XX = 13, OX/XX = 14, XX/XX = 15;
		// What happens if we press the upper-right button ...
		assertEquals(Ti(512727403), p.apply(lightsOut2, OOOO)); // starting with all off
		assertEquals(Ti(874464979), p.apply(lightsOut2, XXOX)); // starting with all on except lower left
		assertEquals(Ti(85616201), p.apply(lightsOut2, OXXO)); // starting with upper right and lower left on
		testTwo(!ignored);
	}
	
	private void testTwo(boolean ignored) {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		// p = press upper right and then lower left
		// OO/OO = 0,  XO/OO = 1,  OX/OO = 2,  XX/OO = 3;
		// OO/XO = 4,  XO/XO = 5,  OX/XO = 6,  XX/XO = 7;
		// OO/OX = 8,  XO/OX = 9,  OX/OX = 10, XX/OX = 11;
		// OO/XX = 12, XO/XX = 13, OX/XX = 14, XX/XX = 15;
		assertEquals(Ti(443873879),p.length());
		assertEquals(Ti(269374851), p.apply(lightsOut2, OOOO));
		assertEquals(Ti(782598533), p.apply(lightsOut2, OOOX));
		assertEquals(Ts(590666945),p.first().toString());
		assertEquals(Ts(1666365878),p.toString());
	}
	
	
	/// test0X: tests on the empty plan
	
	public void test01() {
		assertTrue(Plan.EMPTY_PLAN.equals(Plan.EMPTY_PLAN));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void test02() {
		assertFalse(Plan.EMPTY_PLAN.equals(0));
	}
	
	public void test03() {
		assertFalse(Plan.EMPTY_PLAN.equals(Plan.EMPTY_PLAN.add(loc[0][0])));
	}
	
	public void test04() {
		assertEquals(0,Plan.EMPTY_PLAN.hashCode());
	}
	
	public void test05() {
		assertEquals(0, Plan.EMPTY_PLAN.apply(lightsOut2, OOOO));
	}
	
	public void test06() {
		assertEquals(7, Plan.EMPTY_PLAN.apply(lightsOut2, XXXO));
	}
	
	public void test07() {
		assertException(NoSuchElementException.class,() -> Plan.EMPTY_PLAN.first());
	}
	
	public void test08() {
		assertFalse(Plan.EMPTY_PLAN.equals(null));
	}
	
	
	
	/// tests on a single-step plan
	
	public void test10() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertEquals(Ti(71074757),p.length());
	}
	
	public void test11() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertTrue(p.equals(Plan.EMPTY_PLAN.add(GridLoc.get(0,1))));
	}
	
	public void test12() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertFalse(p.equals(Plan.EMPTY_PLAN.add(GridLoc.get(0,0))));
	}
	
	public void test13() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertFalse(p.equals(Plan.EMPTY_PLAN));
	}
	
	public void test14() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertFalse(Plan.EMPTY_PLAN.equals(p));		
	}
	
	public void test15() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertFalse(p.equals(p.add(loc[0][0])));
	}
	
	public void test16() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertEquals(1+loc[0][1].hashCode(),p.hashCode());
	}
	
	public void test17() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertEquals(15, p.apply(lightsOut2, OOXO));
	}
	
	public void test18() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]);
		assertEquals(Ts(826571918),p.first().toString());
	}
	
	public void test19() {
		Plan p = Plan.EMPTY_PLAN.add(loc[1][1]);
		assertEquals("[(1,1)]",p.toString());
		assertEquals(1+GridLoc.get(1, 1).hashCode(),p.hashCode());
		assertFalse(p.equals(Plan.EMPTY_PLAN));
		assertFalse(Plan.EMPTY_PLAN.equals(p));
		assertFalse(p.equals(Plan.EMPTY_PLAN.add(loc[0][1])));
		assertTrue(p.equals((Object)Plan.create(GridLoc.get(1, 1))));
	}

	
	/// test2X: tests on plans with two presses
	
	public void test20() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertTrue(p.equals(Plan.EMPTY_PLAN.add(GridLoc.get(0,1)).add(GridLoc.get(1,0))));
	}
	
	public void test21() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][2]).add(loc[0][1]);
		assertFalse(p.equals(Plan.EMPTY_PLAN.add(loc[1][0])));
	}
	
	public void test22() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertFalse(p.equals(Plan.EMPTY_PLAN));
		assertFalse(Plan.EMPTY_PLAN.equals(p));		
	}

	public void test23() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertFalse(p.equals(Plan.EMPTY_PLAN.add(loc[1][0])));
	}

	public void test24() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertFalse(p.equals(Plan.EMPTY_PLAN.add(loc[1][0]).add(loc[0][1])));
	}
	
	public void test25() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertEquals((1+loc[0][1].hashCode())*5+(1+loc[1][0].hashCode()),p.hashCode());
	}

	public void test26() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertEquals(OXXO, p.apply(lightsOut2, OOOO));
	}
	
	public void test27() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertEquals(OXXX, p.apply(lightsOut2, OOOX));
	}
	
	public void test28() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertEquals(XOOX, p.apply(lightsOut2, XXXX));
	}
	
	public void test29() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][1]).add(loc[1][0]);
		assertEquals(3, p.apply(lightsOut2, XOXO));
	}
	
	
	
	/// test3X: tests of three presses
	
	public void test30() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);
		assertEquals(3,p.length());
	}
	
	public void test31() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		Plan p2 = Plan.create(GridLoc.get(0,0), GridLoc.get(1,0), GridLoc.get(0,1));
		assertEquals(3,p2.length());
		assertTrue(p.equals(p2));
	}
	
	public void test32() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertFalse(p.equals(Plan.create(GridLoc.get(0,1), GridLoc.get(1,0), GridLoc.get(0,0))));
		assertFalse(p.equals(Plan.EMPTY_PLAN.add(loc[1][0]).add(loc[0][1])));
	}
	
	public void test33() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][0]).add(loc[0][1]);		
		assertFalse(p.equals(Plan.create(GridLoc.get(0,2), GridLoc.get(0,0))));
	}
	
	public void test34() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertEquals((1+loc[0][0].hashCode())*25+(1+loc[1][0].hashCode())*5+1+loc[0][1].hashCode(),p.hashCode());
	}
	
	public void test35() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertEquals(XOOO, p.apply(lightsOut2, OOOO));
	}
	
	public void test36() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertEquals(OOOO, p.apply(lightsOut2, XOOO));
	}
	
	public void test37() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertEquals(OOXX, p.apply(lightsOut2, XOXX));
	}
	
	public void test38() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertEquals(OOOX,p.apply(lightsOut2, XOOX));
	}
	
	public void test39() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]);		
		assertEquals("(0,0)",p.first().toString());
	}
	
	
	/// test4X: tests of paths of length 4
	
	public void test40() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		assertEquals(4,p.length());
	}
	
	public void test41() {
		Plan p2 = Plan.create(GridLoc.get(0,0), GridLoc.get(1,0), GridLoc.get(0,1), GridLoc.get(1,1));
		assertEquals(4,p2.length());
	}
	
	public void test42() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		Plan p2 = Plan.create(GridLoc.get(0,0), GridLoc.get(1,0), GridLoc.get(0,1), GridLoc.get(1,1));
		assertTrue(p.equals(p2));
	}
	
	public void test43() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][0]).add(loc[0][1]);
		assertFalse(p.equals(Plan.create(GridLoc.get(1, 0), GridLoc.get(0, 0), GridLoc.get(0, 1))));
		assertFalse(p.equals(Plan.create(GridLoc.get(1, 1), GridLoc.get(1, 1), GridLoc.get(1, 0))));
	}
	
	public void test44() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		assertEquals("(0,0)",p.first().toString());
	}
	
	public void test45() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		assertEquals(XXXX, p.apply(lightsOut2, OOOO));
	}
	
	public void test46() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		assertEquals(XOXX, p.apply(lightsOut2, OXOO));
	}
	
	public void test47() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		assertEquals(OXOO, p.apply(lightsOut2, XOXX));
	}
	
	public void test48() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		assertEquals(XXOO, p.apply(lightsOut2, OOXX));
	}
	
	public void test49() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[1][0]).add(loc[0][1]).add(loc[1][1]);
		int h = 0;
		h += GridLoc.get(0, 0).hashCode()+1;
		h *= 5;
		h += GridLoc.get(1, 0).hashCode()+1;
		h *= 5;
		h += GridLoc.get(0, 1).hashCode()+1;
		h *= 5;
		h += GridLoc.get(1, 1).hashCode()+1;
		assertEquals(h,p.hashCode());
	}
	
	
	
	public void test50() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		assertEquals(5,p.length());
	}
	
	public void test51() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		assertEquals("(0,0)",p.first().toString());
	}
	
	public void test52() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		assertEquals(11, p.apply(lightsOut2, OOOO));
	}
	
	public void test53() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		assertEquals(8, p.apply(lightsOut2, XXOO));
	}
	
	public void test54() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		assertEquals(5, p.apply(lightsOut2, OXXX));
	}
	
	public void test55() {
		Plan p1 = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		Plan p2 = Plan.create(loc[0][0], loc[0][1], loc[1][1], loc[0][0], loc[1][1]);
		Plan p3 = Plan.create(loc[0][1], loc[0][0], loc[1][1], loc[0][0], loc[1][1]);
		Plan p4 = Plan.create(loc[0][1], loc[0][1], loc[1][1], loc[0][0], loc[1][1]);
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
		assertFalse(p1.equals(p4));
		assertFalse(p3.equals(p4));
	}
	
	public void test56() {
		Plan p = Plan.EMPTY_PLAN.add(loc[0][0]).add(loc[0][1]).add(loc[1][1]).add(loc[0][0]).add(loc[1][1]);
		int h = 0;
		h += GridLoc.get(0, 0).hashCode()+1;
		h *= 5;
		h += GridLoc.get(0, 1).hashCode()+1;
		h *= 5;
		h += GridLoc.get(1, 1).hashCode()+1;
		h *= 5;
		h += GridLoc.get(0, 0).hashCode()+1;
		h *= 5;
		h += GridLoc.get(1, 1).hashCode()+1;
		assertEquals(h,p.hashCode());	
	}


	/// test6X:
	
	public void test61() {
		Plan p = Plan.create(loc[2][2],loc[0][2],loc[1][1],loc[2][0],loc[0][0],loc[1][0]);
		assertFalse(p.equals(Plan.create()));
	}

	public void test62() {
		Plan p = Plan.create(loc[2][2],loc[0][2],loc[1][1],loc[2][0],loc[0][0],loc[1][0]);
		assertFalse(p.equals(Plan.create(loc[2][1],loc[0][2],loc[1][1],loc[2][0],loc[0][0],loc[1][0])));
	}

	public void test63() {
		Plan p = Plan.create(loc[2][2],loc[0][2],loc[1][1],loc[2][0],loc[0][0],loc[1][0]);
		assertEquals(6,p.length());
	}

	public void test64() {
		Plan p = Plan.create(loc[2][2],loc[0][2],loc[1][1],loc[2][0],loc[0][0],loc[1][0]);
		assertEquals("(2,2)",p.first().toString());
	}
}
