package edu.uwm.apc430;

import java.util.Random;

/**
 * A delay distribution where every delay 
 * over a range[lo, hi) is equally likely.
 *
 */
public class UniformDelay implements DelayDistribution {
	private final int low, high;
	
	/**
	 * Create a uniform delay distribution for [lo,hi)
	 * @param lo lower (inclusive) bound, must not be negative
	 * @param hi upper (exclusive) bound, must be greater than lo
	 */
	public UniformDelay(int lo, int hi) {
		low = lo;
		high = hi;
		if (lo < 0) throw new IllegalArgumentException("lower bound cannot be negative");
		if (lo >= hi) throw new IllegalArgumentException("empty range [" + lo + "," + hi + ")");
	}
	
	/**
	 * Create a uniform delay distribution for [0,hi)
	 * @param hi upper (exclusive) bound, must be positive
	 */
	public UniformDelay(int hi) {
		this(0,hi);
	}
	
	@Override
	public int getDelay(Random r) {
		return r.nextInt(high-low) + low;
	}
	
	@Override
	public String toString() {
		return "[" + low + "," + high + ")";
	}
}
