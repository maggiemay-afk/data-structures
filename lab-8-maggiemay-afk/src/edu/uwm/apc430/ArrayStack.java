package edu.uwm.apc430;

import java.util.NoSuchElementException;

public class ArrayStack<E> {
	
	private int _tail;
	private E[] _data;
	
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * Create an empty stack, with a max capacity of DEFAULT_CAPACITY
	 **/   
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Create an empty stack, with a max capacity of the given amount
	 * @param capacity, max capacity of the stack
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity)
	{
		_tail = 0;
		_data = (E[]) new Object[capacity];
		
		assert _wellFormed() : "invariant failed in constructor";
	}

	
	/**
	 * Add a new element to this stack at the end
	 * @param element
	 *   the new element that is being added
	 * @postcondition
	 *   A new copy of the element has been added to this stack
	 *   in order,
	 * @return
	 * 	 true if element is added onto the stack, false otherwise
	 **/
	public boolean push(E element)
	{
		if (element == null) throw new IllegalArgumentException("element added can't be null");

		assert _wellFormed() : "invariant wrong at start of push()";
		
		
		if (_tail >= _data.length) {
			return false;
		} else {
			_data[_tail++] = element;
		}	
		
		assert _wellFormed() : "invariant wrong at end of push()";
		return true;
	}
	
	/**
	 * Remove the element at the top of the stack
	 * @return the element at the top of the stack
	 */
	public E pop() 
	{
		if (_tail <= 0) throw new NoSuchElementException("Queue underflow.");

		assert _wellFormed() : "invariant wrong at start of pop()";
		
		E result = _data[--_tail];
		
		assert _wellFormed() : "invariant wrong at start of pop()";
		return result;
	}
	
	/**
	 * Clears the stack
	 */
	public void clear() {
		_tail = 0;
		
		assert _wellFormed() : "invariant wrong at start of clear()";
	}

	/**
	 * Determine the number of elements in this stack
	 * @param - none
	 * @return
	 *   the number of elements in this stack
	 **/ 
	public int size( )
	{
		assert _wellFormed() : "invariant wrong at start of size()";
		
		return _tail;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int p = 0; p < _tail; p++) {
			if (p != 0) sb.append(" | ");
			sb.append(_data[p]);
		}
		sb.append(" ]");
		return sb.toString();
	}
	

	/**
	 * Used to report an error found when checking the invariant.
	 * By providing a string, this will help debugging the class if the invariant should fail.
	 * @param error string to print to report the exact error found
	 * @return false always
	 */
	private boolean _report(String error) {
		System.out.println("Invariant error found: " + error);
		return false;
	}

	/**
	 * Check the invariant.
	 * Return false if any problem is found.  Returning the result
	 * of {@link #report(String)} will make it easier to debug invariant problems.
	 * @return whether invariant is currently true
	 */
	private boolean _wellFormed() {
		if (_data == null) return _report("data array should not be null");
		if (_tail < 0 || _tail > _data.length) return _report("_head pointer should not be beyond the array scope: " + _tail);
		
		return true;
	}
}
