import edu.uwm.apc430.BreadthFirstLightsOut;
import edu.uwm.apc430.GridLoc;
import edu.uwm.apc430.LightsOut;
import edu.uwm.cs.junit.LockedTestCase;


//@SuppressWarnings("unused")
public class TestBFS extends LockedTestCase {

	LightsOut lo1 = new LightsOut(1,1);
	LightsOut lo2 = new LightsOut(2,2);
	LightsOut lo3 = new LightsOut(3,3);
	LightsOut lo4 = new LightsOut(4,4);

	public void testLocked() {
		// OO/OO = 0,  XO/OO = 1,  OX/OO = 2,  XX/OO = 3;
		// OO/XO = 4,  XO/XO = 5,  OX/XO = 6,  XX/XO = 7;
		// OO/OX = 8,  XO/OX = 9,  OX/OX = 10, XX/OX = 11;
		// OO/XX = 12, XO/XX = 13, OX/XX = 14, XX/XX = 15;
		// BFS tries in order (0,0), (0,1), (1,0), (1,1)
		// but finds shortest sequence that works:
		assertEquals(Ts(1729846718),BreadthFirstLightsOut.findSolution(lo2, XXXO, true)+"");
		assertEquals(Ts(1977566189),BreadthFirstLightsOut.findSolution(lo2, XXOX, true)+"");
		assertEquals(Ts(1502372433),BreadthFirstLightsOut.findSolution(lo2, OXXO, true)+"");		
	}
	
	public void testB10() {
		// Give the string rep for the Plan (or null).
		assertEquals("[]",BreadthFirstLightsOut.findSolution(lo1, lo1.allOff(), true)+"");
	}
	
	public void testB11() {
		assertEquals("[]",BreadthFirstLightsOut.findSolution(lo1, lo1.allOff(), false)+"");
	}

	public void testB12() {
		// Give the String rep for the Plan (or null),
		assertEquals("[(0,0)]",BreadthFirstLightsOut.findSolution(lo1, lo1.allOn(), true)+"");
	}
	
	public void testB13() {
		assertEquals("[(0,0)]",BreadthFirstLightsOut.findSolution(lo1, lo1.allOn(), false)+"");
	}
	
	public void testB19() {
		assertEquals("null",BreadthFirstLightsOut.findSolution(lo1, XXXX, false)+"");
	}
	
	private int OOOO = 0,  XOOO = 1,  OXOO = 2,  XXOO = 3;
	private int OOXO = 4,  XOXO = 5,  OXXO = 6,  XXXO = 7;
	private int OOOX = 8,  XOOX = 9,  OXOX = 10, XXOX = 11;
	private int OOXX = 12, XOXX = 13, OXXX = 14, XXXX = 15;
	
	public void testB20() {
		assertEquals("[]",BreadthFirstLightsOut.findSolution(lo2, OOOO, true)+"");
		assertEquals("[]",BreadthFirstLightsOut.findSolution(lo2, OOOO, false)+"");		
	}
	
	public void testB21() {
		assertEquals("[(1,0)]",BreadthFirstLightsOut.findSolution(lo2, XOXX, false)+"");
		assertEquals("[(1,0)]",BreadthFirstLightsOut.findSolution(lo2, XOXX, true)+"");
	}
	
	public void testB22() {
		assertEquals("[(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OXXX, false)+"");
		assertEquals("[(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OXXX, true)+"");
	}
	
	public void testB23() {
		assertEquals("[(0,0),(0,1)]",BreadthFirstLightsOut.findSolution(lo2, OOXX, false)+"");		
		assertEquals("[(1,0),(0,0),(0,1),(1,0)]",BreadthFirstLightsOut.findSolution(lo2, OOXX, true)+"");		
		assertEquals("[(0,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, XOOX, true)+"");		
	}
	
	public void testB24() {
		assertEquals("[(0,0),(0,1),(1,0)]",BreadthFirstLightsOut.findSolution(lo2, XOOO, false)+"");		
		assertEquals("[(0,0),(0,1),(1,0)]",BreadthFirstLightsOut.findSolution(lo2, XOOO, true)+"");		
	}
	
	public void testB25() {
		assertEquals("[(0,0),(0,1),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OXOO, false)+"");		
		assertEquals("[(0,1),(0,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OXOO, true)+"");		
	}
	
	public void testB26() {
		assertEquals("[(0,0),(1,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OOXO, false)+"");		
		assertEquals("[(1,0),(0,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OOXO, true)+"");		
	}
	
	public void testB27() {
		assertEquals("[(0,1),(1,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, OOOX, false)+"");		
		assertEquals("[(1,1),(0,1),(1,0)]",BreadthFirstLightsOut.findSolution(lo2, OOOX, true)+"");		
	}
	
	public void testB28() {
		assertEquals("[(1,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, XXOO, false)+"");		
		assertEquals("[(0,0),(1,0),(0,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, XXOO, true)+"");		
	}
	
	public void testB29() {
		assertEquals("[(0,0),(0,1),(0,0),(1,1)]",BreadthFirstLightsOut.findSolution(lo2, XOXO, true)+"");		
		assertEquals("[(0,1),(0,0),(0,1),(1,0)]",BreadthFirstLightsOut.findSolution(lo2, OXOX, true)+"");		
		assertEquals("[(0,0),(1,1),(0,1),(1,0)]",BreadthFirstLightsOut.findSolution(lo2, XXXX, true)+"");				
	}
	
	
	/// testB3X: 3x3 game
	
	public void testB30() {
		assertEquals("[]",BreadthFirstLightsOut.findSolution(lo3, lo3.allOff(), true)+"");	
	}
	
	public void testB31() {
		assertEquals("[(0,0),(0,2),(1,1),(2,0),(2,2)]",BreadthFirstLightsOut.findSolution(lo3, lo3.allOn(), true)+"");	
	}
	
	public void testB32() {
		assertEquals("[(0,0),(0,2),(1,1),(2,0),(2,2)]",BreadthFirstLightsOut.findSolution(lo3, lo3.allOn(), false)+"");	
	}
	
	public void testB33() {
		int state = lo3.toggle(lo3.allOff(), GridLoc.get(1, 1));
		assertEquals("[(0,1),(1,0),(1,1),(1,2),(2,1)]",BreadthFirstLightsOut.findSolution(lo3, state, false)+"");	
	}
	
	public void testB39() {
		int state = 341; // XOX/OXO/XOX
		assertEquals("[(0,0),(0,1),(0,2),(1,0),(1,1),(1,2),(2,0),(2,1),(2,2)]",BreadthFirstLightsOut.findSolution(lo3, state, false)+"");		
	}
	
	
	/// testB4X: 4x4 game
	
	public void testB41() {
		assertEquals("[(0,1),(1,3),(2,0),(3,2)]",BreadthFirstLightsOut.findSolution(lo4, lo4.allOn(), true)+"");						
	}
	
	public void testB42() {
		assertEquals("[(0,1),(1,3),(2,0),(3,2)]",BreadthFirstLightsOut.findSolution(lo4, lo4.allOn(), false)+"");						
	}
	
	// some starting states are impossible to solve!
	
	public void testB47() {
		assertNull(BreadthFirstLightsOut.findSolution(lo4,lo4.toggle(lo4.allOff(), GridLoc.get(0,0)), false));
	}
	
	public void testB48() {
		assertNull(BreadthFirstLightsOut.findSolution(lo4,lo4.toggle(lo4.allOff(), GridLoc.get(0,1)), false));
	}
	
	public void testB49() {
		assertNull(BreadthFirstLightsOut.findSolution(lo4,lo4.toggle(lo4.allOff(), GridLoc.get(1,1)), false));
	}
}
