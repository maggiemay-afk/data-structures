/**
 * Name: Maggie Herms
 * Date: 2/5/2023
 */
package edu.uwm.apc430;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * A point in time.
 */
public class Time {
	// declare a final long field representing milliseconds since the Java epoch.
	// The solution also has a private constructor,
	// which is very useful -- we recommend you declare it here.
	
	private final long SINCEEPOCH;
	
	/**
	 * Create instance of Time based on input value
	 * @param sinceEpoch, time in milliseconds since the java epoch
	 */
	private Time(long sinceEpoch) {
		this.SINCEEPOCH = sinceEpoch;
	}
	
	/**
	 * Create a time for now.
	 */
	public Time() {
		this.SINCEEPOCH = System.currentTimeMillis();
	}
	
	/**
	 * Create a time according to the time parameter.
	 * @param c calendar object representing a time, must not be null
	 */
	public Time(Calendar c) {
		if (c == null) throw new NullPointerException("C must not be null");
		this.SINCEEPOCH = c.getTimeInMillis();
	}
	
	// Override/implement three methods standard for immutable classes.
	@Override
	public int hashCode() {
		return Objects.hash(this.SINCEEPOCH);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Time) {
			Time temp = (Time) obj;
			return (temp.SINCEEPOCH == this.SINCEEPOCH);
		} else {
			return false;
		}
		
	}

	@Override
	public String toString() {
		
		SimpleDateFormat newDate = new SimpleDateFormat("z G yyyy/MM/dd HH:mm:ss");
		newDate.setTimeZone(TimeZone.getTimeZone("UTC"));
		return newDate.format(this.SINCEEPOCH);
				
	}	
	
	/**
	 * Return the difference between two time points.
	 * The order doesn't matter --- the difference is always a
	 * (positive) Duration.
	 * @param t time point to compute difference with
	 * @return duration between two time points.
	 */
	public Duration difference(Time t) {
		// Duration has an easy way to create 'n' times some constant duration
		return Duration.MILLISECOND.scale(Math.abs(this.SINCEEPOCH - t.SINCEEPOCH));		

	}

	/**
	 * Return the time point after a particular duration.
	 * If the point advances too far into the future,
	 * more than a hundred million years from now, this
	 * method may malfunction.
	 * @param d duration to advance, must not be null
	 * @return new time after given duration
	 */
	public Time add(Duration d) {
		// Duration has an easy way to ask how many of some constant Duration it is.
		double temp = d.divide(Duration.MILLISECOND);
		return new Time(this.SINCEEPOCH + (long) temp);
		
	}
	
	/**
	 * Return the time point before a particular duration.
	 * If a point regresses too far into the past,
	 * more than a hundred million years from now,
	 * this method may malfunction.
	 * @param d duration to regress, must not be null
	 * @return new time before this one by the given duration.
	 */
	public Time subtract(Duration d) {		
		double temp = d.divide(Duration.MILLISECOND);
		return new Time(this.SINCEEPOCH - (long) temp);
		
	}

	
}
