package edu.uwm.apc430;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

/**
 * Name: Maggie Herms
 * An integer set class that can handle non-negative 
 * and not too big integers.
 */
public class BooleanArraySet extends AbstractSet<Integer> {
	private static final int DEFAULT_CAPACITY = 16;
	
	private boolean[] contents;
	private int count;
	
	/**
	 * Used by the invariant tester: do not delete or change.
	 */
	private BooleanArraySet(boolean ignored) {}
	
	private static boolean doReport = true; // changed only by invariant tester
	
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error: " + error);
		else System.out.println("Caught problem: " + error);
		return false;
	}

	private boolean wellFormed() {
		// Check the invariant.
		// 1. array is never null
		if (contents == null) return report("Array can never be null");
		
		// 2. The number of "true" elements = count.
		int number = 0;
		for (Boolean value : contents) {
			if (value == true) {
				number++;
			}
		}
		if ( number != count) {
			return report("Number of true elements does not equal count");
		}
		
		// If no problems discovered, return true
		return true;
	}

	/**
	 * Create an empty boolean array set.
	 */
	public BooleanArraySet() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Create an empty boolean array set with the given initial capacity
	 * @param initialCap initial capacity, must not be negative
	 */
	public BooleanArraySet(int initialCap) {
		contents = new boolean[initialCap];
		count = 0;
		assert wellFormed() : "invaeriant failed at end of constructor";
	}
	
	/**
	 * @return Integer, number of elements in the set
	 * @Override
	 */
	public int size() {
		assert wellFormed() : "invarint failed at start of size()";
		return count; //very easy
	}

	/**
	 * Change the current capacity of this set
	 * @param minimumCapacity
	 *   the new capacity for this sequence
	 * @postcondition
	 *   This sequence's capacity has been changed to at least minimumCapacity.
	 *   If the capacity was already at or greater than minimumCapacity,
	 *   then the capacity is left unchanged.
	 *   If the size is changed, it must be at least twice as big as before.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for: new array of minimumCapacity elements.
	 **/
	private void ensureCapacity(int minimumCapacity)
	{
		if (contents.length >= minimumCapacity) return;
		int newCap = contents.length*2;
		if (newCap < minimumCapacity) newCap = minimumCapacity;
		boolean[] newData = new boolean[newCap];
		for (int i=0; i < contents.length; ++i) {
			newData[i] = contents[i];
		}
		contents = newData;
	}

	/**
	 * ensure array capacity, then set array value to 'true' at the index 
	 * of the argument and increment count
	 * @Override
	 * @return boolean, true if array was updated, false otherwise
	 * @throws IllegalArgumentException, if argument is less than 0
	 */
	public boolean add(Integer e) throws IllegalArgumentException {
		assert wellFormed() : "Invariant failed at start of add()";
		if (e < 0) throw new IllegalArgumentException ("Integer cannot be negative");
		
		// add (conditionally)
		// (If already in set, make no changes and return false.)
		// add true at the index that == integer 
		ensureCapacity(e + 1);
		if (contents[e] == true) {
			return false;
		} else {
			contents[e] = true;
			count++;
		}
		
		assert wellFormed() : "invariant failed at end of add()";
		return true;
	}

	// If this were going to be a realistic class, we would override
	// "contains" and "remove" as well, but to keep this class
	// simple, we won't do it.
	
	@Override
	public Iterator<Integer> iterator() {
		assert wellFormed() : "Invariant failed at start of iterator()";
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Integer> {

		private int seen = 0; // how many values have we seen (and not removed)
		private int currentIndex = -1;
		
		/**
		 * @Override
		 * @return boolean, true is the number of values we've seen is
		 * less than total count of elements in set
		 */
		public boolean hasNext() {
			// NB: Don't assert the invariant (well formed) (see homework)
			return seen < count;
		}

		/**
		 * If hasNext returns true, get the next index of the array where the
		 * value stored is also 'true'. Increment seen and return the new index.
		 * @Override
		 * @return Integer, the new currentIndex
		 * @throws NoSuchElementException, if hasNext is false
		 */
		public Integer next() throws NoSuchElementException {
			if (!hasNext()) throw new NoSuchElementException("no more elements");
			
			currentIndex++;
			while (contents[currentIndex] == false) {
				currentIndex++;
			}
			
			seen++;
			return currentIndex;
		}

		/**
		 * Removes the value at current index by setting it 'false'
		 * updates seen and count to reflect removal of element 
		 * @Override
		 * @throws IllegalStateException, if next has not been called (i.e., current index < 0)
		 * or if the current index has nothing to remove
		 */
		public void remove() throws IllegalStateException {
			if (currentIndex < 0) throw new IllegalStateException("must call next first");
			if (contents[currentIndex] == false) throw new IllegalStateException("nothing to remove at current index");
			
			contents[currentIndex] = false;
			seen--;
			count--;
			
			assert wellFormed() : "invariant broken after remove()";
		}		
	}
	
	public static class TestInvariant extends TestCase {
		private BooleanArraySet self;
		
		protected void setUp() {
			self = new BooleanArraySet(false);
			self.contents = null;
			self.count = 0;
			doReport = false;
		}
		
		public void test0() {
			assertFalse(self.wellFormed());
			
			self.contents = new boolean[0];
			doReport = true;
			assertTrue(self.wellFormed());
		}
		
		public void test1() {
			self.count = 1;
			self.contents = new boolean[1];
			assertFalse(self.wellFormed());
			
			doReport = true;
			self.count = 0;
			assertTrue(self.wellFormed());
		}
		
		public void test2() {
			self.count = 1;
			self.contents = new boolean[1];
			assertFalse(self.wellFormed());
			
			doReport = true;
			self.contents[0] = true;
			assertTrue(self.wellFormed());
		}
		
		public void test3() {
			self.contents = new boolean[]{false,true,false,true};
			assertFalse(self.wellFormed());
			self.count = 1;
			assertFalse(self.wellFormed());
			self.count = 3;
			assertFalse(self.wellFormed());
			self.count = 4;
			assertFalse(self.wellFormed());
			
			doReport = true;
			self.count = 2;
			assertTrue(self.wellFormed());
		}
	}
}
