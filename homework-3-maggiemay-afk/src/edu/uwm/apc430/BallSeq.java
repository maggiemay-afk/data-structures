// This is an assignment for students to complete after reading Chapter 3 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.apc430;

import java.util.Arrays;

/******************************************************************************
 * Name: Maggie Herms
 * Date: 2/9/23
 * 
 * This class is a homework assignment;
 * A BallSeq is a collection of Balls.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods that are not available in the sequence class 
 * (start, getCurrent, advance and isCurrent).
 *
 * @note
 *   (1) The capacity of one a sequence can change after it's created, but
 *   the maximum capacity is limited by the amount of free memory on the 
 *   machine. The constructor, addAfter, 
 *   addBefore, clone, 
 *   and concatenation will result in an
 *   OutOfMemoryError when free memory is exhausted.
 *   <p>
 *   (2) A sequence's capacity cannot exceed the maximum integer 2,147,483,647
 *   (Integer.MAX_VALUE). Any attempt to create a larger capacity
 *   results in a failure due to an arithmetic overflow. 
 *   
 *   NB: Neither of these conditions require any work for the implementors (students).
 *
 * @see
 *   <A HREF="../../../../edu/colorado/collections/DoubleArraySeq.java">
 *   Java Source Code for the original class by Michael Main
 *   </A>
 *
 ******************************************************************************/
public class BallSeq implements Cloneable {
	// Implementation of the BallSeq class:
	//   1. The number of elements in the sequences is in the instance variable 
	//      manyItems.  The elements may be Ball objects or nulls.
	//   2. For any sequence, the elements of the
	//      sequence are stored in data[0] through data[manyItems-1], and we
	//      don't care what's in the rest of data.
	//   3. If there is a current element, then it lies in data[currentIndex];
	//      if there is no current element, then currentIndex equals manyItems. 

	private Ball[ ] data;
	private int manyItems; //number of items in data array
	private int currentIndex; //current 'pointer' index
	private static int INITIAL_CAPACITY = 1;
	private static boolean doReport = true; // changed only by invariant tester
	
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error: " + error);
		else System.out.println("Caught problem: " + error);
		return false;
	}

	private boolean wellFormed() {
		// Check the invariant.
		// 1. data is never null
		if (data == null) return report("data is null"); // test the NEGATION of the condition

		// 2. The data array is at least as long as the number of items
		//    claimed by the sequence.
		if (data.length < manyItems) return report("data is too short");

		// 3. currentIndex is never negative and never more than the number of
		//    items claimed by the sequence.
		if (currentIndex < 0 || currentIndex > manyItems) return report("currentIndex is out of range");

		// If no problems discovered, return true
		return true;
	}

	/**
	 * Initialize an empty sequence with an initial capacity of INITIAL_CAPACITY.
	 * The addAfter and addBefore methods work
	 * efficiently (without needing more memory) until this capacity is reached.
	 * @param - none
	 * @postcondition
	 *   This sequence is empty and has an initial capacity of INITIAL_CAPACITY
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for initial array.
	 **/   
	public BallSeq() {
		// NB: NEVER assert the invariant at the START of the constructor.
		// (Why not?  Think about it.)
		this.data = new Ball[INITIAL_CAPACITY];
		assert wellFormed() : "Invariant false at end of constructor";
	}


	/**
	 * Initialize an empty sequence with a specified initial capacity. Note that
	 * the addAfter and addBefore methods work
	 * efficiently (without needing more memory) until this capacity is reached.
	 * @param initialCapacity
	 *   the initial capacity of this sequence
	 * @precondition
	 *   initialCapacity is non-negative.
	 * @postcondition
	 *   This sequence is empty and has the given initial capacity.
	 * @exception IllegalArgumentException
	 *   Indicates that initialCapacity is negative.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for an array with this many elements.
	 *   new Ball[initialCapacity].
	 **/   
	public BallSeq(int initialCapacity) {
		if (initialCapacity < 0) throw new IllegalArgumentException("Initial Capacity cannot be negative");
		
		this.data = new Ball[initialCapacity];
		assert wellFormed() : "Invariant false at end of constructor";
	}

	/**
	 * Determine the number of elements in this sequence.
	 * @param - none
	 * @return - integer, number of elements in this sequence
	 *   the number of elements in this sequence
	 **/ 
	public int size() {
		assert wellFormed() : "invariant failed at start of size";
		return this.manyItems;
		// size() should not modify anything, so we omit testing the invariant here
		
	}

	/**
	 * The first element (if any) of this sequence is now current.
	 * @param - none
	 * @postcondition
	 *   The front element of this sequence (if any) is now the current element (but 
	 *   if this sequence has no elements at all, then there is no current 
	 *   element).
	 **/ 
	public void start() {
		assert wellFormed() : "invariant failed at start of start";
	
		this.currentIndex = 0;
		assert wellFormed() : "invariant failed at end of start";
	}

	/**
	 * Accessor method to determine whether this sequence has a specified 
	 * current element (a Ball or null) that can be retrieved with the 
	 * getCurrent method. This depends on the status of the cursor.
	 * @param - none
	 * @return
	 *   true (there is a current element) or false (there is no current element at the moment)
	 **/
	public boolean isCurrent() {
		assert wellFormed() : "invariant failed at start of isCurrent";
		
		if (currentIndex < manyItems && (data[currentIndex] instanceof Ball || data[currentIndex] == null)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Accessor method to get the current element of this sequence. 
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @return
	 *   the current element of this sequence, possibly null
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   getCurrent may not be called.
	 **/
	public Ball getCurrent() throws IllegalStateException {
		assert wellFormed() : "invariant failed at start of getCurrent";
		
		Boolean test = isCurrent();
		if (test == false) {
			throw new IllegalStateException("No current element");
		} else {
			return data[currentIndex];
		}
	}

	/**
	 * Move forward, so that the next element is now the current element in
	 * this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true. 
	 * @postcondition
	 *   If the current element was already the end element of this sequence 
	 *   (with nothing after it), then there is no longer any current element. 
	 *   Otherwise, the new current element is the element immediately after the 
	 *   original current element.
	 * @exception IllegalStateException
	 *   If there was no current element, so 
	 *   advance may not be called (the precondition was false).
	 **/
	public void advance() throws IllegalStateException {
		assert wellFormed() : "invariant failed at start of advance";
		
		Boolean test = isCurrent();
		if (test == false) {
			throw new IllegalStateException("No current element");
		} else {
			currentIndex++;
		}
		
		assert wellFormed() : "invariant failed at end of advance";
	}

	/**
	 * Remove the current element from this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @postcondition
	 *   The current element has been removed from this sequence, and the 
	 *   following element (if there is one) is now the new current element. 
	 *   If there was no following element, then there is now no current 
	 *   element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   removeCurrent may not be called. 
	 **/
	public void removeCurrent() {
		assert wellFormed() : "invariant failed at start of removeCurrent";

		// You will need to shift elements in the array.
		Boolean test = isCurrent();
		if (test == false) {
			throw new IllegalStateException("No current element");
		} else {
			for (int i=currentIndex; i < manyItems; i++) {
				if (i == data.length - 1) {
					data[i] = null;
					break;
				}
				data[i] = data[i+1];
			}
			--manyItems;
		}
		assert wellFormed() : "invariant failed at end of removeCurrent";
	}

	/**
	 * Add a new element to this sequence, before the current element. 
	 * If the new element would take this sequence beyond its current capacity,
	 * then the capacity is increased before adding the new element.
	 * @param element
	 *   the new element that is being added, it is allowed to be null
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed before the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the start of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for increasing the sequence's capacity.
	 * @note
	 *   An attempt to increase the capacity beyond
	 *   Integer.MAX_VALUE will cause the sequence to fail with an
	 *   arithmetic overflow.
	 **/
	public void addBefore(Ball element) {
		assert wellFormed() : "invariant failed at start of addBefore";
		ensureCapacity(manyItems+1); // make sure there is enough space
		
		if (currentIndex == manyItems) { // special case, mandated by javadoc
			currentIndex = 0; // add at beginning
		}

		// make space for the new element:
		int i;
		for (i=manyItems; i > currentIndex; --i) {
			data[i] = data[i-1];
		}
		
		data[i] = element; // drop it in:
		currentIndex = i;
		++manyItems; // record that we are using more of the array
		
		assert wellFormed() : "invariant failed at end of addBefore";
	}

	/**
	 * Add a new element to this sequence, after the current element. 
	 * If the new element would take this sequence beyond its current capacity,
	 * then the capacity is increased before adding the new element.
	 * @param element
	 *   the new element that is being added, may be null
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed after the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the end of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for increasing the sequence's capacity.
	 * @note
	 *   An attempt to increase the capacity beyond
	 *   Integer.MAX_VALUE will cause the sequence to fail with an
	 *   arithmetic overflow.
	 **/
	public void addAfter(Ball element) {
		assert wellFormed() : "invariant failed at start of addAfter";
		ensureCapacity(manyItems + 1);
		
		if (isCurrent() == false)  {
			data[manyItems] = element;
			currentIndex = manyItems;
			++manyItems;
			return;
		}
		
		int i;
		for(i = manyItems; i > currentIndex; i--) {
			data[i] = data[i-1];
		}
		
		data[i+1] = element;
		currentIndex = i+1;
		++manyItems;
		
		assert wellFormed() : "invariant failed at end of addAfter";
	}


	/**
	 * Place the contents of another sequence at the end of this sequence.
	 * @param addend
	 *   a sequence whose contents will be placed at the end of this sequence
	 * @precondition
	 *   The parameter, addend, is not null. 
	 * @postcondition
	 *   The elements from addend have been placed at the end of 
	 *   this sequence. The current element of this sequence if any,
	 *   remains unchanged.   The addend is unchanged.
	 * @exception NullPointerException
	 *   Indicates that addend is null. 
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory to increase the size of this sequence.
	 * @note
	 *   An attempt to increase the capacity beyond
	 *   Integer.MAX_VALUE will cause an arithmetic overflow
	 *   that will cause the sequence to fail.
	 **/
	public void addAll(BallSeq addend) {
		assert wellFormed() : "invariant failed at start of addAll";
		if (addend == null) throw new NullPointerException("Sequence to add cannot be null");
		ensureCapacity(this.manyItems + addend.manyItems);
		
		boolean validCurrentIndex = this.isCurrent();
		int paramTotal = addend.manyItems;
		int thisCounter = this.manyItems;

		for (int i = 0; i < paramTotal; i++) {
			data[thisCounter] = addend.data[i];
			thisCounter++;
		}
		this.manyItems = (this.manyItems + addend.manyItems);
		
		if(validCurrentIndex == false) {
			this.currentIndex = manyItems;
		}

		assert wellFormed() : "invariant failed at end of addAll";
	}   


	/**
	 * Change the current capacity of this sequence.
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
	private void ensureCapacity(int minimumCapacity) {
		// This is a private method: don't check invariants
		if (minimumCapacity <= data.length) return;
		
		int newSize = (data.length * 2);
		if (newSize < minimumCapacity) {
			newSize = minimumCapacity;
		}
		
		Ball[] tempArray = new Ball[newSize];
		for (int i=0; i < manyItems; i++) {
			tempArray[i] = data[i];
		}
		
		data = tempArray;
	}

	/**
	 * Generate a copy of this sequence.
	 * @param - none
	 * @return
	 *   The return value is a copy of this sequence. Subsequent changes to the
	 *   copy will not affect the original, nor vice versa.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for creating the clone.
	 **/ 
	public BallSeq clone( ) {  // Clone a BallSeq object.
		assert wellFormed() : "invariant failed at start of clone";
		BallSeq answer;

		try
		{
			answer = (BallSeq) super.clone( );
		}
		catch (CloneNotSupportedException e)
		{  // This exception should not occur. But if it does, it would probably
			// indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable");
		}

		answer.data = data.clone( ); // all that's needed for Homework #2

		assert wellFormed() : "invariant failed at end of clone";
		assert answer.wellFormed() : "invariant failed for clone";
		
		return answer;
	}
	
	@Override
	public String toString() { 
		String dataString = null;

		for(Ball item : data) {
			dataString =  "[ Location: " + item.getLoc() + ", Radius: " + item.getRadius() + ", Vector: " + item.getVector() + " ]";
			System.out.println(dataString);
		}
		return dataString;
	}
}

