package edu.uwm.apc430;

import java.util.NoSuchElementException;

public class LinkedQueue<E> {
	
	private static class Node<E> {
		E data;
		Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private int _numItems;
	private Node<E> _head, _tail;
	
	/**
	 * Create an empty queue
	 * @param - none
	 * @postcondition
	 *   This queue is empty 
	 **/   
	public LinkedQueue()
	{
		_head = _tail = null;
		_numItems = 0;
	}

	
	/**
	 * Add a new element to this queue at the end
	 * @param element
	 *   the new element that is being added
	 * @postcondition
	 *   A new copy of the element has been added to this queue
	 *   in order,
	 **/
	public boolean add(E element)
	{
		if (element == null) throw new IllegalArgumentException("element added can't be null");

		assert _wellFormed() : "invariant wrong at start of add()";

		if (_tail == null) {
			_head = _tail = new Node<E>(element, null);
		} else {
			_tail = _tail.next = new Node<E>(element, null);
		}
			
		_numItems++;
		
		assert _wellFormed() : "invariant wrong at end of add()";
		return true;
	}
	
	/**
	 * Removes the element from the start of the queue
	 * 
	 * @return element at the start of the queue 
	 * @throws NoSuchElementException if there is no element to remove
	 */
	public E remove() 
	{
		if (_head == null) throw new NoSuchElementException("Queue underflow.");

		assert _wellFormed() : "invariant wrong at start of remove()";
		
		E result = _head.data;
		_head = _head.next;
		_numItems--;
		
		if (_head == null) {
			_tail = _head;
		}
		
		assert _wellFormed() : "invariant wrong at end of remove()";
		return result;
	}
	
	/**
	 * Clears the queue
	 */
	public void clear() {
		_tail = _head = null;
		_numItems = 0;
		
		assert _wellFormed() : "invariant wrong at end of clear()";
	}

	/**
	 * Determine the number of elements in this queue
	 * @param - none
	 * @return
	 *   the number of elements in this queue
	 **/ 
	public int size( )
	{
		assert _wellFormed() : "invariant wrong at start of size()";
		
		return _numItems;
	}
	
	public String toString() {
		assert _wellFormed() : "invariant wrong at start of toString()";
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		if (_numItems!=0) {
			for (Node<E> p = _head; p != null; p = p.next) {
				if (p != _head) sb.append(" | ");
				sb.append(p.data);
			}
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
		if (_head == null || _tail == null) {
			if (_head == null && _tail != null) return _report("tail should be null if head is null");
			if (_head != null && _tail == null) return _report("head should be null if tail is null");
			if (_numItems != 0 ) return _report("numItems should be 0 if the list is empty");
		}
		else {
			int count = 1;
			Node<E> end = _head;
			for (; end.next != null; end = end.next) {
				count++;
			}
			if (count != _numItems) return _report("numItems is incorrect");
			if (end != _tail) return _report("tail is not reachable from head");
		}
		
		return true;
	}
}
