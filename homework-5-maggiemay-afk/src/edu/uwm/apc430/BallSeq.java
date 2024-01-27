// Name: Maggie Herms
// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.apc430;

import java.awt.Color;

import junit.framework.TestCase;

/******************************************************************************
 * Name: Maggie Herms
 * This class is a homework assignment;
 * A BallSeq is a collection of Balls.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods
 * (start, getCurrent, advance and isCurrent).
 *
 * The methods several times mention possible @{link OutOfMemoryError}
 * but generating these exceptions requires no work by the implementor (student).
 ******************************************************************************/
public class BallSeq implements Cloneable {
	/** 
	 * A data class used for the linked structure for the linked list implementation of BallSeq.
	 */
	private static class Node {
		Ball data;
		Node next;

		public Node(Ball data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	
	private int manyNodes;
	private Node head;
	private Node precursor;
	// Remember that two of the fields are "model fields"
	// and will not be declared as real fields.
	
	// Define private getters for the two model fields (cursor and tail).
	/**
	 * Return the tail (last node) of this list
	 * @param - none
	 * @return tail, last element (Node) of a list, or null if the list is empty
	 */
	private Node getTail() {
		for (Node p = this.head; p!=null; p=p.next) {
			if (p.next == null) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Return the current element of this list
	 * @return cursor, the "current" element (Node) of this list, or null if the list is empty
	 */
	private Node getCursor() {
		
		if (precursor == null && head == null) {
			return null;
		} else if(precursor == null) {
			return head; 
		} else if (precursor.next == null) {
			return null;
		} else {
			return precursor.next;
		}
	}
	
	private static boolean doReport = true; // do not edit: used in invariant checking

	/**
	 * Used to report an error found when checking the invariant.
	 * By providing a string, this will help debugging the class if the invariant should fail.
	 * @param error string to print to report the exact error found
	 * @return false always
	 */
	private boolean report(String error) {
		if (doReport) System.out.println("Invariant error found: " + error);
		return false;
	}

	/**
	 * Check the invariant.
	 * Return false if any problem is found.  Returning the result
	 * of {@link #report(String)} will make it easier to debug invariant problems.
	 * @return whether invariant is currently true
	 */
	private boolean wellFormed() {
		// Invariant:
		// 1. list must not include a cycle.
		// 2. manyNodes is number of nodes in list.
		// 3. the precursor must be null or point to a node in the list.
						
		// 1. check that list is not cyclic
		if (head != null) {
			// Floyd's Tortoise and Hare Algorithm
			Node fast = head.next;
			for (Node p = head; fast != null && fast.next != null; p = p.next) {
				if (p == fast) return report("list is cyclic!");
				fast = fast.next.next;
			}
		}
		
		// Implement conditions 2 and 3
		// 2. check number of nodes
		// Hint: condition 2 simply requires counting nodes as we've done 
		// elsewhere in this and the previous lesson.		
		int counter = 0;
		for (Node p=head; p!=null; p=p.next) {
			counter++;
		}
		if (counter != manyNodes) {
			return report("Number of nodes in list does not match many nodes!");
		}
		
		// 3. Check that precursor is null or a node in the list
		// For condition 3: if precursor isn't null, go through the list and see if the precursor 
		// is any node in the list. After you have looked at all nodes, if you never found the precursor, then report the problem.
		if (precursor != null) {
			boolean found = false;
			for (Node p=head; p!=null; p=p.next) {
				if (p == precursor) {
					found = true;
					break;
				}
			}
			
			if (found == false) {
				return report("Precursor must either be null or a node in the list");
			}
		}
		// If no problems found, then return true:
		return true;
	}

	/** Private constructor for testing the invariant. Do not modify */
	private BallSeq(boolean testInvariant) {}	
	
	/**
	 * Create an empty sequence.
	 * @param - none
	 * @postcondition
	 *   This sequence is empty 
	 **/   
	public BallSeq( ) {
		// Implemented by student.
		this.manyNodes = 0;
		this.head = null;
		this.precursor = null;
		
		assert wellFormed() : "invariant failed at end of constructor";
	}

	/**
	 * Determine the number of elements in this sequence.
	 * @param - none
	 * @return size of the list, number of nodes in this sequence
	 *   the number of elements in this sequence
	 **/ 
	public int size( ) {
		assert wellFormed() : "invariant wrong at start of size()";
		//Implemented by student.
		return this.manyNodes; 
		// This method shouldn't modify any fields, hence no assertion at end
	}

	/**
	 * Set the current element at the front of this sequence.
	 * @param - none
	 * @postcondition
	 *   The front element of this sequence is now the current element (but 
	 *   if this sequence has no elements at all, then there is no current 
	 *   element).
	 **/ 
	public void start( ) {
		assert wellFormed() : "invariant wrong at start of start()";
		// Implemented by student.
		this.precursor = null;
		assert wellFormed() : "invariant wrong at end of start()";
	}

	/**
	 * Accessor method to determine whether this sequence has a specified 
	 * current element that can be retrieved with the 
	 * getCurrent method. 
	 * @param - none
	 * @return
	 *   true (there is a current element) or false (there is no current element at the moment)
	 **/
	public boolean isCurrent( ) {
		assert wellFormed() : "invariant wrong at start of isCurrent()";
		
		// Implemented by student.
		if(getCursor() == null) {
			return false;
		} else {
			return true;
		}
		// This method shouldn't modify any fields, hence no assertion at end
		
	}

	/**
	 * Accessor method to get the current element of this sequence. 
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @return
	 *   the current element of this sequence
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   getCurrent may not be called.
	 **/
	public Ball getCurrent( ) throws IllegalStateException {
		assert wellFormed() : "invariant wrong at start of getCurrent()";
		if (!isCurrent()) throw new IllegalStateException("No Current Element");
		
		// Implemented by student.
		return getCursor().data;
		// This method shouldn't modify any fields, hence no assertion at end
	}

	/**
	 * Move forward, so that the current element is now the next element in
	 * this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true. 
	 * @postcondition
	 *   If the current element was already the end element of this sequence 
	 *   (with nothing after it), then there is no longer any current element. 
	 *   Otherwise, the new element is the element immediately after the 
	 *   original current element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   advance may not be called.
	 **/
	public void advance( ) throws IllegalStateException {
		assert wellFormed() : "invariant wrong at start of advance()";
		if (!isCurrent()) throw new IllegalStateException("No Current Element");
		
		if (precursor == null) {
			precursor = head;
		} else if(precursor.next.next == null) {
			precursor = precursor.next;
		} else {
			precursor = precursor.next;
		}
		
		assert wellFormed() : "invariant wrong at end of advance()";
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
	public void removeCurrent( ) throws IllegalStateException {
		assert wellFormed() : "invariant wrong at start of removeCurrent()";
		
		// Implemented by student.
		if (!isCurrent()) throw new IllegalStateException("No Current element");
		
		if (precursor == null) {
			head = head.next;
		} else {
			precursor.next = precursor.next.next;
		}
		--manyNodes;
		
		// See textbook pp. 183-85, 188-191
		assert wellFormed() : "invariant wrong at end of removeCurrent()";
	}

	/**
	 * Add a new element to this sequence, before the current element. 
	 * @param element
	 *   the new element that is being added
	 * @postcondition
	 *   The element has been added to this sequence. If there was
	 *   a current element, then the new element is placed before the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the start of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 * @exception OutOfMemoryError
	 **/
	public void addBefore(Ball element) {
		assert wellFormed() : "invariant wrong at start of addBefore";
		
		if (precursor == null || precursor.next == null) {
			head = new Node(element,head);
			precursor = null;
		} else {
			precursor.next = new Node(element,precursor.next);
		}
		++manyNodes;
		
		assert wellFormed() : "invariant wrong at end of addBefore";
	}

	/**
	 * Add a new element to this sequence, after the current element. 
	 * @param element
	 *   the new element that is being added
	 * @postcondition
	 *   The element has been added to this sequence. If there was
	 *   a current element, then the new element is placed after the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the end of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 **/
	public void addAfter(Ball element) {
		assert wellFormed() : "invariant wrong at start of addAfter";
		
		// Implemented by student. Several cases:
		if (precursor == null && head == null) { // (1) sequence is empty
			head = new Node (element, head);
			precursor = null;

		} else if (precursor == null)  {
			head.next = new Node (element, head.next);
			precursor = head;
			
		} else if (precursor.next == null) { // (3) inserting elsewhere
			precursor.next = new Node(element, this.precursor.next);
			
		} else {// (2) inserting at tail
			precursor.next.next = new Node(element, precursor.next.next);
			precursor = precursor.next;
		}
		++manyNodes;
		
		assert wellFormed() : "invariant wrong at end of addAfter";
	}


	/**
	 * Place the contents of another sequence at the end of this sequence.
	 * @param addend
	 *   a sequence whose contents will be placed at the end of this sequence
	 * @precondition
	 *   The parameter, addend, is not null. 
	 * @postcondition
	 *   The elements from addend have been placed at the end of 
	 *   this sequence. The current element of this sequence remains unchanged, 
	 *   and the addend is also unchanged (unless it's the same as this).
	 * @exception NullPointerException
	 *   Indicates that addend is null. 
	 **/
	public void addAll(BallSeq addend) throws NullPointerException {
		assert wellFormed() : "invariant wrong at start of addAll";
		assert addend.wellFormed() : "invariant of parameter wrong at start of addAll";
		if (addend == null) throw new NullPointerException("addend is null");
		
		// Implemented by student. We found that using clone() to do most of the work saved some time.
		BallSeq cloneAddend = addend.clone();
		
		if (this.head == null) {
			this.head = cloneAddend.head;
			this.precursor = getTail();
			
		} else if (!isCurrent()){
			this.getTail().next = cloneAddend.head;
			this.precursor = this.getTail();
			
		} else {
			this.getTail().next = cloneAddend.head;
		}
		
		this.manyNodes += cloneAddend.manyNodes;
		
		// The fact that the current element must not change, does NOT mean that precursor field is always unchanged!
		assert wellFormed() : "invariant wrong at end of addAll";
		assert addend.wellFormed() : "invariant of parameter wrong at end of addAll";
	}   


	/**
	 * Generate a copy of this sequence.
	 * @param - none
	 * @return
	 *   The return value is a copy of this sequence. Subsequent changes to the
	 *   copy will not affect the original, nor vice versa.
	 *   Whatever was current in the original object is now current in the clone.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for creating the clone.
	 **/ 
	public BallSeq clone( ) {  	 
		assert wellFormed() : "invariant wrong at start of clone()";
		
		BallSeq result;

		try {
			result = (BallSeq) super.clone( );
			
		} catch (CloneNotSupportedException e) {  
			// This exception should not occur. But if it does, it would probably indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable" clause at the start of this class.
			throw new RuntimeException ("This class does not implement Cloneable");
		}
		// Implemented by student. Now do the hard work of cloning the list.
		// See pp. 200-204, 235. Setting precursor correctly is difficult
		if (this.head == null) return result;
		
		Node copyHead = new Node (this.head.data, null);
		Node copyTail = copyHead;
		
		for(Node n=this.head.next; n!=null; n=n.next) {
			copyTail.next = new Node(n.data, null);
			copyTail = copyTail.next;
		}
		result.head = copyHead;
		
		if (this.precursor == null) {
			result.precursor = null;
		} else {
			int count=0;
			for (Node p=this.head; p!=null; p=p.next) {
				
				if(p == this.precursor) {
					break;
				} else {
					count++;
				}
			}
			
			result.precursor = null;
			result.start();
			for (int i=0; i <= count; i++) {
				result.advance();
			}
		}

		assert wellFormed() : "invariant wrong at end of clone()";
		assert result.wellFormed() : "invariant wrong for result of clone()";
		return result;
	}


	/**
	 * Create a new sequence that contains all the elements from one sequence
	 * followed by another.
	 * @param s1
	 *   the first of two sequences
	 * @param s2
	 *   the second of two sequences
	 * @precondition
	 *   Neither s1 nor s2 is null.
	 * @return
	 *   a new sequence that has the elements of s1 followed by the
	 *   elements of s2 (with no current element)
	 * @exception NullPointerException.
	 *   Indicates that one of the arguments is null.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for the new sequence.
	 **/   
	public static BallSeq catenation(BallSeq s1, BallSeq s2) {
		BallSeq res = s1.clone();
		res.addAll(s2);
		while (res.isCurrent()) res.advance();
		return res;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		// implement this method
		for (Node n=head; n!=null; n=n.next) {
			
			if (n == getCursor()) {
				sb.append("*");
			}
			sb.append(n.data);
			
			if (n.next != null){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();

	}
	
	public static class TestInvariant extends TestCase {
		protected BallSeq bs;
		Ball b1 = new Ball(new Point(0,0), new Vector(), Color.BLACK);
		Ball b2 = new Ball(new Point(100,0), new Vector(10,0), Color.BLUE);
		Ball b3 = new Ball(new Point(100,100), new Vector(), Color.GREEN);
		Ball b4 = new Ball(new Point(0,-100), new Vector(10,20), Color.YELLOW);
		Ball b5 = new Ball(new Point(0,100), new Vector(0,-10), Color.RED);
		
		Node n0, n1, n2, n3, n4, n5;
		Node n0a, n1a, n2a, n3a, n4a, n5a; // decoys: never legal in our test cases.
		
		public void setUp() {
			doReport = false;
			bs = new BallSeq(false);
			n0 = new Node(null,null); n0a = new Node(null,null);
			n1 = new Node(b1,null);   n1a = new Node(b1,null);
			n2 = new Node(b2,null);   n2a = new Node(b2,null);
			n3 = new Node(b3,null);   n3a = new Node(b3,null);
			n4 = new Node(b4,null);   n4a = new Node(b4,null);
			n5 = new Node(b5,null);   n5a = new Node(b5,null);
		}

		/// testing getters for model fields.
		
		public void test00() {
			assertNull(bs.getTail());
			assertNull(bs.getCursor());
		}

		public void test01() {
			bs.head = n2;
			assertSame(n2,bs.getTail());
			assertSame(n2,bs.getCursor());
			bs.precursor = n2;
			assertNull(bs.getCursor());
		}

		public void test02() {
			bs.head = n4;
			n4.next = n1;
			assertSame(n1,bs.getTail());
			assertSame(n4,bs.getCursor());
			bs.precursor = n4;
			assertSame(n1,bs.getCursor());
			bs.precursor = n1;
			assertSame(null,bs.getCursor());
		}

		public void test03() {
			bs.head = n3;
			n3.next = n5;
			n5.next = n0;
			assertSame(n0,bs.getTail());
			assertSame(n3,bs.getCursor());
			bs.precursor = n3;
			assertSame(n5,bs.getCursor());
			bs.precursor = n5;
			assertSame(n0,bs.getCursor());
			bs.precursor = n0;
			assertSame(null,bs.getCursor());
		}

		
		/// testing wellFormed
		
		public void test10() {
			doReport = true;
			assertTrue("all with defaults values should have been ok",bs.wellFormed());
		}
				
		public void test11() {
			bs.precursor = n0;
			assertFalse("precursor cannot be set if no nodes",bs.wellFormed());
		}
				
		public void test13() {
			bs.manyNodes = 1;
			assertFalse("how can there be an element without nodes?",bs.wellFormed());
			bs.manyNodes = -1;
			assertFalse("how can there be an element without nodes?",bs.wellFormed());
			bs.manyNodes = 2;
			assertFalse("how can there be an element without nodes?",bs.wellFormed());
		}
		
		public void test14() {
			bs.head = n0;
			bs.manyNodes = 1;
			assertTrue(bs.wellFormed());
		}
				
		public void test15() {
			bs.head = n0;
			bs.manyNodes = 1;
			bs.precursor = n0a;
			assertFalse("precursor messed up",bs.wellFormed());
		}
		
		public void test16() {
			bs.head = n0;
			bs.manyNodes = 1;
			doReport = true;
			bs.precursor = n0;
			assertTrue("everything should be OK for 'no current'",bs.wellFormed());
			bs.precursor = null;
			assertTrue("everything should be OK for starting with 1 element",bs.wellFormed());
		}
				
		public void test17() {
			bs.head = n1;
			bs.manyNodes = 1;
			bs.precursor = n1a;
			assertFalse("precursor messed up",bs.wellFormed());
		}
		
		public void test18() {
			bs.head = n1;
			bs.manyNodes = 1;
			doReport = true;
			bs.precursor = n1;
			assertTrue("everything should be OK for 'no current'",bs.wellFormed());
			bs.precursor = null;
			assertTrue("everything should be OK for starting with 1 element",bs.wellFormed());
		}

		public void test21() {
			bs.head = n2;
			n2.next = n3;
			assertFalse("manyNodes is wrong",bs.wellFormed());
			bs.manyNodes = 1;
			assertFalse("manyNodes is wrong",bs.wellFormed());
			bs.manyNodes = -1;
			assertFalse("manyNodes is wrong",bs.wellFormed());
			bs.manyNodes = 3;
			assertFalse("manyNodes is wrong",bs.wellFormed());
			bs.manyNodes = 2;
			doReport = true;
			assertTrue("All OK",bs.wellFormed());
		}
		
		public void test22() {
			bs.head = n2;
			n2.next = n3;
			n3.next = n2;
			bs.manyNodes = 2;
			assertFalse("cycle should have been found",bs.wellFormed());
			n3.next = n3;
			assertFalse("cycle should have been found",bs.wellFormed());
		}
		
		public void test23() {
			doReport = true;
			bs.head = n2;
			n2.next = n3;
			bs.manyNodes = 2;
			assertTrue("should be OK setup of precursor",bs.wellFormed());
			bs.precursor = n2;
			assertTrue("should be OK setup of precursor",bs.wellFormed());
			bs.precursor = n3;
			assertTrue("should be OK setup of precursor",bs.wellFormed());
		}
		
		public void test25() {
			bs.head = n2;
			n2.next = n3;
			n1a.next = n2; // decoy;
			bs.manyNodes = 2;
			bs.precursor = n0;
			assertFalse("precursor is wrong", bs.wellFormed());
			bs.precursor = n1a;
			assertFalse("precursor is wrong",bs.wellFormed());
			bs.precursor = n2;
			assertTrue("precursor is OK",bs.wellFormed());
			bs.precursor = n3;
			assertTrue("precursor is OK",bs.wellFormed());
		}
		
		public void test26() {
			bs.head = n2;
			n2.next = n3;
			n2a.next = n3; // decoy
			bs.manyNodes = 2;
			bs.precursor = n2a;
			assertFalse("precursor is wrong",bs.wellFormed());
		}
		
		public void test31() {
			bs.head = n4;
			n4.next = n0; n4a.next = n0;
			n0.next = n5; 
			assertFalse("manyNodes wrong",bs.wellFormed());
			bs.manyNodes = 1;
			assertFalse("manyNodes wrong",bs.wellFormed());
			bs.manyNodes = 2;
			assertFalse("manyNodes wrong",bs.wellFormed());
			bs.manyNodes = -1;
			assertFalse("manyNodes wrong",bs.wellFormed());
			bs.manyNodes = 4;
			assertFalse("manyNodes wrong",bs.wellFormed());
			bs.manyNodes = 3;
			assertTrue("manyNodes OK",bs.wellFormed());
		}
		
		public void test32() {
			bs.head = n4;
			n4.next = n0; n4a.next = n0;
			n0.next = n5;
			bs.manyNodes = 3;
			
			n5.next = n4;
			assertFalse("should have detected cycle",bs.wellFormed());
			n5.next = n4a;
			assertFalse("should have detected cycle",bs.wellFormed());
			n5.next = n0;
			assertFalse("should have detected cycle",bs.wellFormed());
			n5.next = n0a;
			assertFalse("should have detected cycle",bs.wellFormed());
			n5.next = n5;
			assertFalse("should have detected cycle",bs.wellFormed());
		}
		
		public void test33() {
			doReport = true;
			bs.head = n4;
			n4.next = n0; 
			n0.next = n5;
			bs.manyNodes = 3;
			
			assertTrue("OK setup for pre/cursor",bs.wellFormed());
			bs.precursor = n4;
			assertTrue("OK setup for pre/cursor",bs.wellFormed());
			bs.precursor = n0;
			assertTrue("OK setup for pre/cursor",bs.wellFormed());
			bs.precursor = n5;
			assertTrue("OK setup for pre/cursor",bs.wellFormed());
		}
	}
}

