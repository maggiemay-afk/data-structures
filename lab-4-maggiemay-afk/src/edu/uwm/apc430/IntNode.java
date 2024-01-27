package edu.uwm.apc430;

import java.util.IdentityHashMap;

public class IntNode implements Cloneable {
	private int data;
	private IntNode next;
	
	public IntNode(int d, IntNode n) {
		data = d;
		next = n;
	}
	
	public IntNode getNext() {
		return next;
	}
	
	
	/// Override methods from Object
	
	@Override
	public boolean equals(Object obj) {
		throw new UnsupportedOperationException("Don't use .equals to compare nodes!");
	}
	
	@Override
	public IntNode clone() {
		try {
			return (IntNode)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("IntNodes should be cloneable!");
		}
	}
	
	protected String originalToString() {
		return super.toString();
	}
	
	@Override
	public String toString() {
		String nextString = "null";
		if (next != null) nextString = next.originalToString();
		return super.toString() + "(" + data + "." + nextString + ")";
	}
	
	
	/// Print method that is used for testing
	/**
	 * Convert a list to a string for debugging purposes.
	 * The string is of the form [n1, n2, n3, ...].
	 * if the list ends in a cycle then we have "..." followed by
	 * the one-based index of the node we go back to. 
	 * @param head list t print, may be null
	 * @return string representation of the whole list.
	 */
	public static String listToString(IntNode head) {
		if (head == null) return "[]";
		IdentityHashMap<IntNode,Integer> m = new IdentityHashMap<>();
		StringBuilder sb = new StringBuilder("[");
		sb.append(head.data);
		m.put(head, 0);
		int n = 1;
		for (IntNode p = head.next; p != null; p = p.next) {
			Integer boxed = m.get(p);
			if (boxed != null) {
				sb.append(", ..." + (n-boxed));
				break;
			}
			m.put(p, n++);
			sb.append(", " + p.data);
		}
		sb.append("]");
		return sb.toString();
	}	
	
	/// Exercises
	
	public static IntNode exercise0() {
		return null; // []
	}
	
	public static IntNode exercise1() {
		// [42]
		return new IntNode(42, null);
	}
	
	public static IntNode exercise2() {
		// [1, 2, 3]
		IntNode first, second, third;
		
		third = new IntNode(3, null);
		second = new IntNode(2, third);
		first = new IntNode(1, second);
		
		return first;
	}
	
	public static IntNode exercise3() {
		// [9, ...1]  Update the next link after creating the node
		IntNode nine = new IntNode(9, null);
		nine.next = nine;
		
		return nine;
	}
	
	public static IntNode exercise4() {
		// [4, 3, 2, 1, ...3]
		IntNode four = new IntNode(4, null);
		IntNode three = new IntNode(3, null);
		IntNode two = new IntNode(2, null);
		IntNode one = new IntNode(1, null);
		
		four.next = three;
		three.next = two;
		two.next = one;
		one.next = two;
		
		return four;
	}
	
	public static IntNode exercise5(IntNode param) {
		// change second element to 4
		param.next.data = 4;
		return param;
	}
	
	public static IntNode exercise6(IntNode param) {
		// TODO: remove second element
		param.next = param.next.next;
		return param;
	}
	
	public static int exercise7(IntNode param) {
		// count number of nodes in list (use NORMAL loop)
		int counter = 0;
		for (IntNode p = param; p != null; p = p.next) {
			++counter;
		}
		return counter;
	}
	
	public static IntNode exercise8(IntNode param) {
		final IntNode dummy = new IntNode(999,null);
		IntNode last = dummy; // "last" node currently is the fake node.
		// copy list by tacking on each element to the last node
		// of the result list.  Use the NORMAL idiom
		for(IntNode p = param; p != null; p = p.next) {
			
			IntNode temp = new IntNode(p.data, null);
			last.next = temp;
			last = temp;
			
		}
		
		return dummy.next;
	}
	
	public static IntNode exercise9(IntNode param, int v) {
		// add v to the end of a non-empty list (in general!)
		// NB: We recommend using the FOLLOWER idiom
		IntNode lag = null;
		for (IntNode p=param; p != null; lag=p, p=p.next) {
			
		}
		
		lag.next = new IntNode(v, null);
		return param;
	}
}








