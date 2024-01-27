/**
 * Name: Maggie Herms
 * Date: 2/5/2023
 */
package edu.uwm.apc430;

import java.util.Objects;


/**
 * An amount of time, always positive.
 * To create a duration, scale an existing duration.
 */
public class Duration {
	private final long extent; // this must remain private.  Do NOT add a getter!
	
	/**
	 * this constructor must remain private:
	 * Create instance of Duration based on parameter
	 * @param length of time in milliseconds
	 */
	private Duration(long milliseconds) {
		extent = milliseconds;
	}
	
	// For all constants, have a line:
	// public static final Duration CONSTANT = new Duration(...);
	public static final Duration INSTANTANEOUS = new Duration(0);
	public static final Duration MILLISECOND = new Duration(1);
	public static final Duration SECOND = new Duration(1000);
	public static final Duration MINUTE = new Duration(60000);
	public static final Duration HOUR = new Duration(3600000L);
	public static final Duration DAY = new Duration(86400000L);
	public static final Duration YEAR = new Duration(31557600000L);
	// A long literal needs a "L" at the end, as in 1234567890L
	
	// If you are overriding a method from a super class, always
	// annotate it "@Override" as here, overriding Object#equals(Object)
	@Override 
	public boolean equals(Object x) {
		// TODO 
		if (x instanceof Duration) {
			return (this.extent == ((Duration) x).extent);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// the recommended way to define hashCode:
		// call Objects.hash(...) listing all the fields.
		// The "hash" method takes multiple parameters
		return Objects.hash(extent);
	}
	
	// If you are overriding a method from an interface, then Java 5
	// says you CANNOT use Override, but anything later says you MAY.
	// Please always do unless you write a javadoc comment. 
	@Override
	public String toString() {
		
		if (this.extent >= 0 && this.extent < SECOND.extent) { 
			return (((double)this.extent / MILLISECOND.extent)  + " ms.");
			
		} else if (this.extent >= SECOND.extent && this.extent < MINUTE.extent) {
			return (((double)this.extent / SECOND.extent) + " s.");
			
		} else if (this.extent >= MINUTE.extent && this.extent < HOUR.extent) {
			return (((double)this.extent / MINUTE.extent) + " min.");
			
		} else if (this.extent >= HOUR.extent && this.extent < DAY.extent) {
			return (((double)this.extent / HOUR.extent) + " hr.");
			
		} else if (this.extent >= DAY.extent && this.extent < YEAR.extent) {
			return (((double)this.extent / DAY.extent) + " days");
			
		} else {
			return (((double)this.extent / YEAR.extent) + " years");
		}
	}
	
	// Methods that are not standard or private must have a documentation comment:
	
	/**
	 * Add two durations together to get a larger duration.
	 * @param d duration being added to this, must not be null
	 * @return new duration equal to the combined duration of this and the argument.
	 * @throws NullPointerException if d is null
	 */
	public Duration add(Duration d) {
		// Remember that you can access the fields of "d"
		// even though they are private, because this is your class!
		if(d == null) throw new NullPointerException("Argument duration must not be null");
		return new Duration(this.extent + d.extent);
	}
	
	/**
	 * Return the duration remaining if the argument duration
	 * 'is removed.  The argument must not be longer than this.
	 * @param d duration to remove, must not be null, must not be bigger than this
	 * @return remaining duration after subtracting d
	 * @throws NullPointerException if d is null
	 * @throws ArithmeticException if d is too big
	 */
	public Duration subtract(Duration d) {
		// Need one check before doing something similar to add.
		if (d == null) throw new NullPointerException("Argument duration must not be null");
		if (d.extent > this.extent) throw new ArithmeticException("Argument duration cannot be less than this duration");
		return new Duration(this.extent - d.extent);
	}

	/**
	 * Return the duration by scaling this duration by the given amount.
	 * The result is rounded.
	 * @param d amount to scale by, must not be negative.
	 * @return new scaled duration
	 * @throws IllegalArumentException if scale factor is negative.
	 */
	public Duration scale(double d) {
		// Read the Javadoc if you find yourself failing tests.
		if (d < 0) {
			throw new IllegalArgumentException("multiplicative factor must not be negative");
		}else {
			double temp = ((double)this.extent * d);
			return new Duration((long) Math.round(temp));
		}
		
	}
	
	/**
	 * Return the scale of this duration against the argument.
	 * @param d duration to divide by, must not be null or instantaneous
	 * @return how many of the argument fit in this duration
	 * @throws NullPointerException if d is null
	 * @throws ArithmeticException if d is instantaneous
	 */
	public double divide(Duration d) {
		if(d.extent == 0) {
			throw new ArithmeticException("divisor must not be 0");
		} else {
			double temp = ((double)this.extent / (double)d.extent);
			return temp;
		}
	}
}
