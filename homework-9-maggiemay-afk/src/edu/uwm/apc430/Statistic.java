package edu.uwm.apc430;

/**
 * A measurement for which we keep the minimum, maximum and average value.
 */
public class Statistic {
	private int min, max;
	private long sum;
	private int n;
	
	/**
	 * Create a statistic with no values yet.
	 */
	public Statistic() {}
	
	/**
	 * Add another datum to this statistic,
	 * @param value
	 */
	public void record(int value) {
		if (n == 0) min = max = value;
		else {
			if (min > value) min = value;
			if (max < value) max = value;
		}
		sum += value;
		++n;
	}
	
	public int getMin() { return min; }
	public int getMax() { return max; }

	/**
	 * Return the arithmetic average of all data.
	 * If these are no data, return 0.
	 * @return arithmetic average of data
	 */
	public double getAverage() { 
		if (n == 0) return 0;
		return sum / (double)n; 
	}
	
	@Override
	public String toString() {
		return "[" + min + ":" + String.format("%.1f",getAverage()) + ":" + max + "](" + n + ")";
	}
}
