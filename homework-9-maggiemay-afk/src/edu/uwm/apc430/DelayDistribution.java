package edu.uwm.apc430;

import java.util.Random;

/**
 * A distribution of non-negative integers indicating
 * how long after the current time some event in the future will occur.
 *
 */
public interface DelayDistribution {
	/**
	 * Compute a delay using the given random source.
	 * @param r source of random numbers, must not be null
	 * @return amount of delay, must not be negative.
	 */
	public int getDelay(Random r);
}
