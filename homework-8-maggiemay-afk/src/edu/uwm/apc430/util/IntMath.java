package edu.uwm.apc430.util;

import junit.framework.TestCase;

public class IntMath {

	/**
	 * Return the integer square root (rounded down) of an unsigned 64 bit integer.
	 * @param x value to perform square root on, treated unsigned
	 * @return largest value y for which y*y <= x where x is treated as unsigned. 
	 */
	public static long isqrt(long x) {
		// System.out.println("isqrt(" + x + ")");
		if (x > 1) {
			long y = 2;
			do {
				// System.out.println(" "+y + " is isqrt of " + x + " ?");
				long r = x/y;
				if (r == y) return y;
				if (r > y && (y+1)*(y+1) > x) return y;
				y = (y + r)/2;
			} while (true);
		} else if (x < -1) {
			long y = Integer.MAX_VALUE;
			do {
				// System.out.println(" "+y + " is isqrt of " + x + " ?");
				long r = (x+Long.MAX_VALUE+2)/y + Long.MAX_VALUE/y;
				// System.out.println(" quotient = " + r);
				if (r == y) return r;
				if (r == y+1) {
					long z = y - Integer.MAX_VALUE;
					// y + 1 = z + (2^31)
					long nextSquare = z*z + (z << 32) + (1L << 62);
					// System.out.println(" (y+1)^2 = " + nextSquare);
					if (nextSquare > x) return y;
					return r;
				}
				y = (y + r)/2;
			} while (true);
		} else if (x == -1) {
			return (1L << 32) -1;
		} else return x; // 0 and 1
	}
	
	public static class Test extends TestCase {
		public void testFirst25() {
			assertEquals(0,isqrt(0));
			assertEquals(1,isqrt(1));
			assertEquals(1,isqrt(2));
			assertEquals(1,isqrt(3));
			assertEquals(2,isqrt(4));
			assertEquals(2,isqrt(5));
			assertEquals(2,isqrt(6));
			assertEquals(2,isqrt(7));
			assertEquals(2,isqrt(8));
			assertEquals(3,isqrt(9));
			assertEquals(3,isqrt(10));
			assertEquals(3,isqrt(11));
			assertEquals(3,isqrt(12));
			assertEquals(3,isqrt(13));
			assertEquals(3,isqrt(14));
			assertEquals(3,isqrt(15));
			assertEquals(4,isqrt(16));
			assertEquals(4,isqrt(17));
			assertEquals(4,isqrt(18));
			assertEquals(4,isqrt(19));
			assertEquals(4,isqrt(20));
			assertEquals(4,isqrt(21));
			assertEquals(4,isqrt(22));
			assertEquals(4,isqrt(23));
			assertEquals(4,isqrt(24));
			assertEquals(5,isqrt(25));
		}
		
		public void testLarge() {
			long l = Integer.MAX_VALUE;
			long l2 = l*l;
			assertEquals(l,isqrt(l2));
			assertEquals(l-1,isqrt(l2-1));
			assertEquals(l,isqrt(l2+1));
		}
		
		public void testLarger() {
			long l = Integer.MAX_VALUE+10L;
			long l2 = Integer.MAX_VALUE*20L+100L;
			l2 += Integer.MAX_VALUE*(long)Integer.MAX_VALUE;
			assertTrue(l2 > 0);
			assertEquals(l,isqrt(l2));
			assertEquals(l-1,isqrt(l2-1));
			assertEquals(l,isqrt(l2+1));
		}
		
		public void testEvenLarger() {
			long l = Integer.MAX_VALUE+(1L << 30);
			long l2 = Integer.MAX_VALUE*(1L << 31)+(1L<<60);
			l2 += Integer.MAX_VALUE*(long)Integer.MAX_VALUE; // overflow
			assertFalse(l2 > 0);
			assertEquals(l,isqrt(l2));
			assertEquals(l-1,isqrt(l2-1));
			assertEquals(l,isqrt(l2+1));
		}
		
		public void testLargerStill() {
			long l = Integer.MAX_VALUE + (long)Integer.MAX_VALUE;
			long l2 = Integer.MAX_VALUE*(long)Integer.MAX_VALUE;
			l2 += l2; // still OK
			assertTrue(l2 > 0);
			l2 += l2; // overflow
			assertFalse(l2 > 0);
			assertEquals(l,isqrt(l2));
			assertEquals(l-1,isqrt(l2-1));
			assertEquals(l,isqrt(l2+1));			
		}
		
		public void testLargest() {
			assertEquals((1L<<32)-1,isqrt(-1));
		}
	}
}
