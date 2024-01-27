package edu.uwm.apc430;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Name: Maggie Herms
 * Modified and stripped version of ArrayBag
 * from <a href="http://www.cs.colorado.edu/~main/docs/">
 * http://www.cs.colorado.edu/~main/docs/</a>
 * 
 * It is important to note that we did not implement the following methods.
 * <ul>
 *   <li>clone</li>
 *   <li>getCapacity</li>
 *   <li>grab</li>
 *   <li>remove</li>
 *   <li>trimToSize</li>
 *   <li>union</li>
 * </ul>
 * Though it also important to note, that we have made ArrayBag now
 * implement Iterable and Iterator to make ArrayBag have a cursor-style
 * iterator, in other words, be its own iterator
 */
public class StringArrayBag implements Iterable<String>, Iterator<String>  {

	private final static int INITIAL_CAPACTIY = 10;
	private String[] data;
	private int manyItems;
	
	/**
	 * Initializes a bag of INITIAL_CAPACITY
	 */
	public StringArrayBag() {
		this(INITIAL_CAPACTIY);
	}
	
	/**
	 * Initializes a bag of the given initial capacity
	 * @param initialCapacity, initial capacity of the bag
	 */
	public StringArrayBag(int initialCapacity) {
		if (initialCapacity < 0 ) throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
		this.manyItems = 0;
		this.data = new String[initialCapacity];
	}
	
	/**
	 * Add the element to end of the bag
	 * @param element, element to add
	 * @throws IllegalArgumentException, if element is null
	 */
	public void add(String element) {
		if (element == null) throw new IllegalArgumentException("element cannot be null");
		ensureCapacity(this.manyItems+1);
		this.data[manyItems++] = element;
	}
	
	/**
	 * Add many elements to the end of the bag in the order they are passed
	 * @param elements, elements to add to the end of the bag
	 * @throws IllegalArgumentException, if any element of the elements is null
	 */
	public void addMany(String... elements) {
		for (String element : elements) {
			if (element == null) throw new IllegalArgumentException("there cannot be a null element");
		}
		ensureCapacity(this.manyItems+elements.length);
		System.arraycopy(elements, 0, this.data, this.manyItems, elements.length);
		this.manyItems += elements.length;
		
	}

	/**
	 * Remove an element from the bag
	 * @param target, element to be removed
	 * @throws IllegalArgumentException, if the target is null
	 */
	public void remove(String target) {
		if (target == null) throw new IllegalArgumentException("target cannot be null");
		
		for (int index = 0; index < this.manyItems; index++)
			if (target.equals(this.data[index])) {
				data[index] = data[manyItems-1];
				manyItems--;
				return;
			}
	}
	
	/**
	 * Counts the occurrences of the target in the bag
	 * @param target, the element to count the occurrences of
	 * @return number of times the target appears in the bag
	 * @throws IllegalArgumentException, if the target is null
	 */
	public int countOccurrences(String target) {
		if (target == null) throw new IllegalArgumentException("target cannot be null");
		
		int answer = 0;
		// for a given target, loop through your elements
		// and count the times it shows. DO NOT use an iterator
		// as a cursor-style iterator will reset other iterators
		for(int i=0; i < data.length; i++) {
			if (data[i] != null && data[i].equals(target)) {
				answer++;
			}		
		}
		return answer;
		
	}
	
	/**
	 * Counts the occurrences of the target in the bag
	 * This version uses the iterator to count the occurrences
	 * @param target, the element to count the occurrences of
	 * @return number of times the target appears in the bag
	 * @throws IllegalArgumentException, if the target is null
	 */
	public int countOccurrencesWithIterator(String target) {
		if (target == null) throw new IllegalArgumentException("target cannot be null");
		
		
		// for a given target, loop through your elements
		// and count the times it shows. DO use an iterator
		// even though a cursor-style iterator will reset other iterators
		int answer = 0;
		
		for(Iterator <String> it = iterator(); it.hasNext();) {
			String temp = it.next();
			if(temp.equals(target)) {
				answer++;
			}
		}
		
		return answer;
	}
	
	/**
	 * Ensures the bag can hold the minimum capacity given, and
	 * resizes if needed to the minimum capacity.
	 * @param minimumCapacity
	 */
	public void ensureCapacity(int minimumCapacity) {
		if (this.data.length < minimumCapacity)
		{
			String[] biggerArray = new String[minimumCapacity];
			System.arraycopy(this.data, 0 , biggerArray, 0, this.manyItems);
			this.data = biggerArray;
		}
	}
	
	/**
	 * Returns the size of the bag, or number of elements in the bag
	 * @return size of the bag
	 */
	public int size() {
		return manyItems;
	}
	
	/**
	 * Prints the contents of the bag, along with its occurrences to console
	 * in the following format:
	 * element: occurrences
	 */
	public void printOccurrences() {
		ArrayList<String> printed = new ArrayList<String>();
		for (String element : this) { 
			if (!printed.contains(element)) {
				System.out.printf("%s: %d\n",element.toString(), this.countOccurrences(element));
				printed.add(element);
			}
		}
	}
	
	/**
	 * Prints the contents of the bag, along with its occurrences to console
	 * this method uses the iterator
	 * in the following format:
	 * element: occurrences
	 */
	public void printOccurrencesWithIterator() {
		ArrayList<String> printed = new ArrayList<String>();
		for (String element : this) {
			if (!printed.contains(element)) {
				System.out.printf("%s: %d\n",element.toString(), this.countOccurrencesWithIterator(element));
				printed.add(element);
			}
		}
	}


	/************************************************
	 * Iterator Methods
	 ************************************************/
	// Tracks the index of the current element of the iterator
	private int currentIndex = -1;
	
	/**
	 * Prepares the internal iterator for iteration
	 */
	@Override
	public Iterator<String> iterator() {
		this.currentIndex = -1;
		return this;
	}
	
	/**
	 * Checks to see if there is a next element
	 */
	@Override
	public boolean hasNext() {
		return this.currentIndex + 1 < this.manyItems;
	}
	
	/**
	 * Fetches and returns the next element
	 */
	@Override
	public String next() {
		if (!hasNext()) throw new NoSuchElementException("There is no next element");
		
		String nextElement = null;
		//Using the fields above, move to the next element and return it
		currentIndex++;
		nextElement = data[currentIndex];
		
		return nextElement;
	}
	
	/**
	 * Removes the current element if there is one
	 * 
	 * We will leave this method to the homework 
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("cannot remove element from bag");
	}
}
