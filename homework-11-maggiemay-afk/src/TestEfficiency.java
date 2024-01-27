import junit.framework.TestCase;
import edu.uwm.apc430.VisitableStringSet;


public class TestEfficiency extends TestCase {
   
	VisitableStringSet set;
	
	@Override
	protected void setUp() {
		set = new VisitableStringSet();
		try {
			assert 1/set.size() == 42 : "OK";
			// OK, the assertion didn't fail
		} catch (ArithmeticException ex) {
			System.err.println("Assertions must be disabled to use this test suite.");
			System.err.println("In Eclipse: remove -ea from the VM Arguments box under Run>Run Configurations>Arguments");
			assertFalse("Assertions must be disabled in the Run Configuration>Arguments>VM Arguments",true);
		}
	}
	
	private static final int POWER = 20;
	private static final int SIZE = (1 << (POWER-1)) - 1;
	
	private void makeBig() {
		int max = 1 << POWER;
		for (int p=POWER; p > 1; --p) {
			int diff = 1 << p;
			for (int i=1<<(p-1); i < max; i += diff) {
				set.add(Integer.toHexString(max+i));
			}
		}
	}
	
	public void testSize() {
		makeBig();
		for (int i=0; i < SIZE; ++i) {
			assertEquals(SIZE,set.size());
		}
	}
	
	private static class CheckAll implements VisitableStringSet.Visitor {
		final int max = 1 << POWER;
		int index = 0;
		int step;
		
		CheckAll(int i, int s) {
			index = i;
			step = s;
		}
		
		@Override
		public boolean visit(String s) {
			assertEquals(Integer.toHexString(max+index),s);
			index += step;
			return true;
		}
	};
	
	public void testAccept() {
		makeBig();
		for (int i=0; i < 10; ++i) {
			set.accept(new CheckAll(2,2));
		}
	}
	
	public void testRemove() {
		makeBig();
		set.accept((s) -> (Integer.parseInt(s, 16)%4) == 2);
		assertEquals((1+SIZE)/2,set.size());
		set.accept(new CheckAll(2,4));
	}
}
