package edu.uwm.apc430;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Name: Maggie Herms
 * Class of linked list nodes for Homework {@link #exercise4()}, APC 430.
 * We follow the style of the textbook.
 */
public class IntNode implements Cloneable {
	private int data;
	private IntNode next;
	
	public IntNode(int d, IntNode n) {
		data = d;
		next = n;
	}
	
	public int getData() {
		return data;
	}
	
	public IntNode getNext() {
		return next;
	}
	
	
	/// Override methods from Object (don't change these)
	
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
	
	
	/// Print method that is used for testing (don't change)
	
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
	
	public static IntNode stringToList(String s) {
		if (s.equals("[]")) return null;
		if (!s.startsWith("[") || !s.endsWith("]")) throw new IllegalArgumentException("Bad list string, needs to be of form [...]: '" + s + "'");
		List<IntNode> nodes = new ArrayList<>();
		s = s.substring(1, s.length()-1);
		while (s.length() > 0) {
			if (s.charAt(0) == '.') {
				if (!s.startsWith("...")) throw new IllegalArgumentException("Expected ...: '" + s + "'");
				int loopSize = Integer.parseInt(s.substring(3));
				if (loopSize > nodes.size()) throw new IllegalArgumentException("bad loop size: " + loopSize);
				nodes.add(nodes.get(nodes.size()-loopSize));
				break;
			}
			int nn = s.indexOf(',');
			if (nn < 0) nn = s.length();
			nodes.add(new IntNode(Integer.parseInt(s.substring(0,nn)),null));
			s = s.substring(nn);
			if (s.length() > 0) {
				if (!s.startsWith(", ")) throw new IllegalArgumentException("Missing ', ' in '" + s + "'");
				s = s.substring(2);
			}
		}
		IntNode prev = null;
		for (IntNode n : nodes) {
			if (prev != null) {
				prev.next = n;
			}
			prev = n;
		}
		return nodes.get(0);
	}
	
	
	/// Tasks
	
	/**
	 * Computes the maximum value in a list of integers
	 * @param head of original list, may be null
	 * @return int, the largest value in a given list
	 */
	public static int maximum(IntNode head) {
		if (head == null) return (Integer.MIN_VALUE);
	
		int maxVal = head.getData();
		for (IntNode p = head; p != null; p=p.getNext()) {
			if (p.getData() > maxVal) {
				maxVal = p.getData();
			}
		}
		return maxVal;
	}
	
	
	/**
	 * Return a list with the same elements in the same order which shares
	 * no nodes with the original list.
	 * @param head list to copy, may be null
	 * @return copied list
	 */
	public static IntNode copyList(IntNode head) {
		if (head == null) return head;
		
		IntNode copyHead = new IntNode(head.getData(), null);
		IntNode copyTail = copyHead;
		
		for (IntNode p=head.getNext(); p !=null; p=p.getNext()) {
	
			IntNode temp = new IntNode(p.getData(), null);
			copyTail.next = temp;
			copyTail = copyTail.getNext();
		}
		return copyHead;
	}


	
	/**
	 * Return a list with the same elements as the parameter but
	 * in the opposite order.  The original list should not be modified
	 * @param head head of the original list, may be null
	 * @return new reversed list
	 */
	public static IntNode reverseCopy(IntNode head) {
		if (head == null) return head;
		
		IntNode reverseTail = new IntNode(head.getData(), null);
		IntNode reverseHead = reverseTail;
		
		for (IntNode p=head.getNext(); p != null; p=p.getNext()) {	
			IntNode temp = new IntNode(p.getData(), reverseHead);
			reverseHead = temp;
		}
		return reverseHead;
	}
	
	/**
	 * Return a reverse of the parameter list without allocating any new
	 * nodes---the result uses the nodes of the original list.
	 * The original list will not be usable afterwards.
	 * @param head list to reverse, may be null
	 * @return reversed list using the same nodes
	 */
	public static IntNode reverseDestructive(IntNode head) {
		if (head == null || head.getNext() == null) return head;
		
		IntNode lag = null;
		IntNode current = head;
		IntNode next = head.getNext();
		
		while(current != null) {
			
			current.next = lag;
			
			if (next == null) {
				break;
			} else {
				lag = current;
				current = next;
				next = next.getNext();
			}
		}
		return current;
	}
	
	/**
	 * Return a new list with elements from index 0, 2, 4, ,,,
	 * The new list should share no nodes with the original list.
	 * The original list should be untouched.
	 * @param head list to get evens from, may be null
	 * @return new list containing even elements from the parameter.
	 */
	public static IntNode evensCopy(IntNode head) {
		// Hint: if you special case the empty list, and then handle the first element before the loop,
		// a dummy node won't be needed. (A dummy isn't as much help anyway because of the loop structure.)
		if (head == null) return head;
		
		IntNode evensHead = new IntNode(head.getData(), null);
		IntNode last = evensHead;
		
		int counter = 1;
		for(IntNode p=head.getNext(); p != null; p=p.getNext()) {
			
			if(counter % 2 == 0) {
				IntNode temp = new IntNode(p.getData(), null);
				last.next = temp;
				last = temp;
			} 
			++counter;
		}
		return evensHead;
		
	}
	
	/**
	 * Return a list made using existing nodes with elements at indices 1, 3, 5, ... .
	 * The even elements (starting with the original head) should also be connected together.  
	 * No new nodes should be allocated.
	 * @param head list to unzip, may be null
	 * @return list of odd elements constructed using existing nodes.
	 */
	public static IntNode unzipDestructive(IntNode head) {
		// Hint: special case if the list fewer than two elements.
		// Re-assign .next fields of each node to bypass the next node.
		if (head == null) return head;
		if (head.getNext() == null) return null;
		
		IntNode currentEven = head;
		IntNode oddList = head.getNext();
		IntNode currentOdd = head.getNext();
		int counter = 0;
		
		while (currentOdd != null && currentEven != null) {
			
			if (counter % 2 == 0) {
				currentEven.next = currentOdd.getNext();
				if (currentOdd.getNext() == null) {
					break;
				} else {
					currentEven = currentOdd.getNext();
				}
			} else {
				currentOdd.next = currentEven.getNext();
				if (currentEven.getNext() == null) {
					break;
				} else {
					currentOdd = currentEven.getNext();
				}
			}
			++counter;
		}
		return oddList;
	}

	/**
	 * Zip together two lists with alternating elements from each list.
	 * Once one of the lists finishes, the other lists elements are used
	 * to finish the result.  The result should share no nodes with the
	 * parameters.
	 * @param l1 first list, may be null
	 * @param l2 second list, may be null
	 * @return zip of two lists with all new nodes.
	 */
	public static IntNode zipCopy(IntNode l1, IntNode l2) {
		return zipDestructive(copyList(l1),copyList(l2));
		// Already done for you!
	}
	
	/**
	 * Zip the elements of l1 and l2 together into a combined list
	 * with alternate elements from the two lists until one
	 * list runs out of elements after which we have
	 * the remaining elements from the other list.
	 * No new nodes re created: the nodes of the two lists are reused
	 * for the new list.
	 * @param l1 first list, may be null
	 * @param l2 second list, may be null
	 * @return combined list of two lists reusing the original nodes.
	 */
	public static IntNode zipDestructive(IntNode l1, IntNode l2) {
		if (l1 == null && l2 == null) return l1;
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		IntNode currentlist1 = l1;
		IntNode list1Next = l1.getNext();
		IntNode currentlist2 = l2; 
		IntNode list2Next = l2.getNext();
		IntNode answer = l1;
		
		while (currentlist1 != null && currentlist2 != null) {
			
			currentlist1.next = currentlist2;
			
			if (list2Next == null) {
				currentlist1.next.next = list1Next;
				break;
			} else if (list1Next == null){
				currentlist1.next.next = list2Next;
				break;
			} else {
				currentlist1.next.next = list1Next;
			} 
			
			currentlist1 = list1Next;
			currentlist2 = list2Next;
			list1Next = list1Next.getNext();
			list2Next = list2Next.getNext();

		}
		return answer;
	}
	
	
	/// The following task is optional.
	
	/**
	 * Create a new list including the first instance of each unique element from the parameter.
	 * The new list should share no nodes with the original list.
	 * @param head list to find unique elements in
	 * @return list of unique elements.
	 */
	public static IntNode removeDuplicatesCopy(IntNode head) {
		return null; // Optional: fix this method
		// Hint: the solution uses a dummy node.
	}
}
