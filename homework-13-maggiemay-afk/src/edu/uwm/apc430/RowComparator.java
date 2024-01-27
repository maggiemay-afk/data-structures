package edu.uwm.apc430;

import java.util.Comparator;

/**
 * @author Maggie Herms
 * Compare rows (arrays of strings) according to one element in the row.
 * The ordering can be either ascending or descending.
 */
public class RowComparator implements Comparator<String[]> {

	private final int column;
	private final boolean ascending;
	
	/**
	 * Create a row comparator that sorts on the given column.
	 * @param col column to sort on
	 * @param asc whether to use ascending (or descending order)
	 */
	public RowComparator(int col, boolean asc) {
		column = col;
		ascending = asc;
	}
	
	@Override
	public int compare(String[] a, String[] b) {
		// write this method
		if (ascending == true) {
			return (a[column].compareTo(b[column])); 
		} else {
			return -1 * (a[column].compareTo(b[column])); 
		}
	}

	
}
