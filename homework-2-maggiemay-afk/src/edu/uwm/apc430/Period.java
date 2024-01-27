/**
 * Name: Maggie Herms
 * Date: 2/5/2023
 */
package edu.uwm.apc430;

import java.util.Objects;

/**
 * A time period within historical time.
 */
public class Period {
	// TODO: Fields (should be final)
	// Use the ADTs created already
	
	private final Duration lengthOfTime;
	private final Time startTime;
	private final Time endTime;
	
	/**
	 * Construct a period given the start time and length.
	 * @param s start time, must not be null
	 * @param l length, must not be null
	 */
	public Period(Time s, Duration l) {
		if (s == null || l == null) throw new NullPointerException("Time nor Duration can be null");
		
		this.startTime = s;
		this.lengthOfTime = l;
		this.endTime = getStop();
	}
	
	/**
	 * Construct a period given the start and end time
	 * @param from start time, must not be null
	 * @param to end time, must not be null or before the start time
	 */
	public Period(Time from, Time to) {
		if(from == null || to == null) throw new NullPointerException("Start time nor end time can be null");
		if(to.add(to.difference(from)).equals(from) && !to.equals(from)) throw new IllegalArgumentException("End time cannot be before start time");
			
		this.startTime = from;
		this.endTime = to;
		this.lengthOfTime = getLength();
		
	}
	
	/**
	 * Construct a period given the length and end time.
	 * @param len length of the period, must not be null
	 * @param end end time of the period.
	 */
	public Period(Duration len, Time end) {
		if (len == null) throw new NullPointerException("Length of time must not be null");
		
		this.lengthOfTime = len;
		this.endTime = end;
		this.startTime = getStart(); 
	}
	
	/**
	 * Return the start time of the period.
	 * @return beginning time
	 */
	public Time getStart() {
		return (this.endTime.subtract(this.lengthOfTime));
		
	}
	
	/**
	 * Return the stop time of the period.
	 * @return end time
	 */
	public Time getStop() {
		return (this.startTime.add(this.lengthOfTime));
		
	}
	
	/**
	 * Return the length of the period.
	 * @return the amount of time in this period
	 */
	public Duration getLength() {
		return this.startTime.difference(this.endTime);
	}
	
	@Override
	public boolean equals(Object x) {
		// NB: If you find yourself failing tests using assertEquals,
		// watch out that you defined this method correctly
		// Remember that for immutable ADTs, one shouldn't use ==.
		if (x instanceof Period) {
			return this.hashCode() == x.hashCode();
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// return Objects.hash(...all the fields...);
		return Objects.hash(this.startTime, this.endTime, this.lengthOfTime); 
	}
	
	@Override
	public String toString() {
		return "[" + this.startTime + "; " + this.lengthOfTime + "]";
		
	}
}
