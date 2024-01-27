package edu.uwm.apc430;

/**
 * A constant delay distribution (always the same).
 */
public class ConstantDelay extends UniformDelay {
	/**
	 * Create a constant delay distribution for the given delay
	 * @param d delay, must not be negative.
	 */
	public ConstantDelay(int d) { super(d,d+1); }
}
