package edu.uwm.apc430;

import java.util.NoSuchElementException;

/**
 * A Queue implementation using an array that
 * grows as needed.  It uses the "circular array" data structure.
 * @param E element type
 */
public class ArrayQueue<E> {
	public static final int INITIAL_CAPACITY = 2; // to permit easier testing
	private Object[] contents;
	private int front, rear;
	
	/**
	 * Create an empty queue with an initial capacity.
	 */
	public ArrayQueue() {
		contents = new Object[INITIAL_CAPACITY];
	}
	
	/**
	 * Add an element to the back of the queue.
	 * The queue's capacity is increased as necessary.
	 * @param element element added
	 */
	public void enqueue(E element) {
		//check capacity first (not done)
		if (rear >= INITIAL_CAPACITY) {
			Object[] newContents = new Object[contents.length*2];
			for (int i=0; i < contents.length; ++i) {
				newContents[i] = contents[i];
			}
			contents = newContents;
		}
		/* because arrays start at the 0 index 
		 * this will ensure that rear is pointing to the last item. 
		 * Previously rear pointed to the index after the last item.
		 */
//		if (size()==0) {
//			rear = 0;
//			contents[rear] = element;
//			return;
//			}
		
		//then add new element to end of queue
		contents[rear] = element;
		++rear;
		
		
	}
	
	
	
	/**
	 * Remove and return the front of the queue.
	 * @return first element in the queue.
	 * @exception NoSuchElementException if queue is empty
	 */
	public E dequeue() throws NoSuchElementException {
		if (size()==0) throw new NoSuchElementException("Queue is empty, no elements removed");
		
		E result = peek();
		if (front >= INITIAL_CAPACITY) front = 0;
		contents[front] = result;//sets first item to result
		contents[front] = null;// set the item at front to null so that it is removed from the array- Jessie
		front++;	
		return result;
	}
	
	/**
	 * Return the front of the queue without removing it.
	 * @return the first element in the queue.
	 * @exception NoSuchElementException if queue is empty
	 */
	public E peek() throws NoSuchElementException {
		if(size()==0)throw new NoSuchElementException("No Elements to call peek method");
		@SuppressWarnings("unchecked")
		E result = (E)contents[front];
		return result;
	}
	
	/**
	 * Return the number of elements in the queue.
	 * @return number of elements in the queue.
	 */
	public int size() {
		//Scenario #1, Empty Array Condition
		if(front==rear)return 0;
		//Scenario #2, rear has not rolled over yet
		if(rear>front) {
			return rear-front;
		}
		//Scenario #3, rear has rolled over, and we now have two separate data clumps
		//One group of data from the front pointer, to the end of the array
		//A second group of data, from zero to the rear pointer (n+1) to account for the zero position
		else {//front>rear scenario 
			return((rear+1)+(contents.length-front));
		}

	}
	
	/**
	 * Return the capacity of the queue.
	 * The result can be as small as the initial capacity.
	 * But if it is bigger, it shouldn't more more than
	 * twice one more than the maximum size the queue had since
	 * since the beginning or since the last clear().
	 * The capacity shouldn't change except when ...<ol>
	 * <li> the queue is cleared, or
	 * <li> a new element is added and the new size is
	 * greater or equal to the previous capacity.
	 * </ol>
	 * @return current capacity of the queue
	 */
	public int capacity() {
		//return capacity of the queue/length of the array
		return contents.length;
		
	}
	
	/**
	 * Remove everything from the queue.
	 */
	public void clear() {
	    contents = new Object[INITIAL_CAPACITY]; // new object is empty
	    front = 0; // update front and rear
		rear = 0;
	}
}
