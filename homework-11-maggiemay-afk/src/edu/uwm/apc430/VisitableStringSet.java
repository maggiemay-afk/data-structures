package edu.uwm.apc430;

import java.util.IllegalFormatException;

import junit.framework.TestCase;

/**
 * Name: Maggie Herms
 * A class representing a set of strings.  Rather than an iterator, 
 * a visitor is supported: the client can indicate for each string
 * in the set whether to keep it or remove it.
 */
public class VisitableStringSet {

	/**
	 * Clients should create instances of this class
	 * or use "lambda" expressions and call
	 * {@link #accept} to get access to all the elements.
	 */
	public static interface Visitor {
		/**
		 * Called with a string from the set.
		 * The method should return false if the
		 * string should be removed from the set.
		 * @param s a string in the set, not null
		 * @return whether the string should be kept in the set.
		 */
		public abstract boolean visit(String s);
	}
	
	private static class Node {
		Node left, right;
		String data;
		Node(String d) { data = d; }
		@Override
		public String toString() {
			return "Node(" + data + ")@" + System.identityHashCode(this);
		}
	}
	
	private Node root;
	private int numElements;
	
	/// Invariant checker and helper methods
	
	private static boolean doReport = true;
	
	private static boolean report(String s) {
		if (doReport) System.out.println("Invariant error: " + s);
		return false;
	}
	
	/**
	 * Check if all the nodes in the subtree rooted at r are
	 * in the proper order.  In particular, that there are no null data
	 * (but of course null nodes are allowed!) and that all the data
	 * in the nodes are in the range (lo,hi), exclusive bounds.
	 * If either bound is null, then there is no bound in that direction.  For example,
	 * if the lower bound lo is null, then there is no lower bound on the 
	 * data in the subtree.  But if lo is not null then all data in the subtree
	 * must be lexicographically <em>after</em> it.
	 * Furthermore, the subtrees must themselves also be ordered
	 * with respect to each other.
	 * @param r subtree to evaluate, may be null
	 * @param lo exclusive lower bound; if null, then no lower bound
	 * @param hi exclusive upper bound; if null, then no upper bound
	 * @return whether the subtree is properly order within the  range given.
	 */
	private static boolean isInProperOrder(Node r, String lo, String hi) {
		// write this recursive method
		
		if (r == null) {
			return true;
			
		} else if (r.data == null){ 
			return report("no null data allowed");
			
		} else {
	
			if (lo != null && lo.compareTo(r.data) >= 0) {
				return report("out of bounds of lo");
				
			} else if (hi != null && hi.compareTo(r.data) <= 0) {
				return report("out of bounds of hi");	
			}
			
			return isInProperOrder(r.left, lo, r.data) && isInProperOrder(r.right, r.data, hi);
		}
		
	}
	
	/**
	 * Return the number of nodes in the subtree rooted at r.
	 * @param r root of a subtree, may be null
	 * @return number of nodes in the subtree.
	 */
	private static int countNodes(Node r) {
		// write this recursive method
		if (r == null) {
			return 0;
		} else {
			return 1 + countNodes(r.left) + countNodes(r.right);
		}
		
	}
	
	private boolean wellFormed() {
		if (!isInProperOrder(root,null,null)) return false;
		int n = countNodes(root);
		if (numElements != n) return report("numElements is " + numElements + ", but should be " + n);
		return true;
	}
	
	private VisitableStringSet(boolean ignored) {} // do not change this constructor!
	
	
	/// Public methods
	
	public VisitableStringSet() {
		// nothing to do!
		assert wellFormed() : "Problem in constructor";
	}
	
	/**
	 * Return number of elements in the set.
	 * @return size of the set.
	 */
	public int size() {
		assert wellFormed() : "Invariant failed in size()";
		return numElements;
	}
	
	/**
	 * Add the string x to this subtree and return the new root
	 * of the subtree.  If a new node is created.
	 * the number of elements must be incremented.
	 * @param r original subtree, may be null
	 * @param x string to add, will not be null.
	 * @return new root of subtree after x is added to it.
	 */
	private Node doAdd(Node r, String x) {
		// complete this method, recursively
		
		if (r == null) {
			this.numElements++;
			return new Node(x);
			
		} else if (r.data.compareTo(x) > 0){
			r.left = doAdd(r.left, x);
			return r;
			
		} else if (r.data.compareTo(x) < 0) {
			r.right = doAdd(r.right, x);
			return r;
			
		} else {
			return r;
		}
		
	}
	
	/**
	 * Add an element to the set.
	 * Return false if the element was already in the set.
	 * @param s element to add, must not be null
	 * @return whether anything was added.
	 */
	public boolean add(String s) {
		assert wellFormed() : "invariant broken at start of add(" + s + ")";
		if (s == null) throw new NullPointerException("cannot add null");
		int oldSize = numElements;
		root = doAdd(root,s);
		assert wellFormed() : "invariant broken at end of add(" + s + ")";
		return (numElements > oldSize);
	}
	
	/**
	 * Return the first element in this subtree.
	 * @param r subtree root, must NOT be null
	 * @return first (leftmost) string data in subtree
	 */
	private static String getFirst(Node r) {
		// write this recursive method
		
		if (r == null) {
			return null;
			
		} else {
			String result = getFirst(r.left);
			
			if (result == null) {
				return r.data;
			} else {
				return result;
			}
		}
	}
	
	/**
	 * Remove the first (leftmost) node in this non-empty tree.
	 * We return the new subtree which is usually the same as the original one.
	 * @param r subtree to remove from, must not be null
	 * @return new subtree after removal.
	 */
	private static Node removeFirst(Node r) {
		// write this recursive method
		
		Node result;
		
		if (r.left != null) {
			result = removeFirst(r.left);
			
			r.left = result;
			return r;
			
		} else {
			return r.right;
		}	
		
	}
	
	/**
	 * Visit each node in this subtree, in order.
	 * if the visitor returns false, then the data should be removed from the tree.
	 * @param r subtree to traverse, may be null
	 * @param v visitor to use
	 * @return new subtree, after (perhaps) some subtrees are removed.
	 */
	private Node doAccept(Node r, Visitor v) {
		// Write this recursive method
		// The helper methods getFirst and removeFirst
		// are helpful.
		
		Boolean result;
		if (r == null) { //action for null
			return r;
			
		} else {
			//Pre-order action
			r.left = doAccept(r.left, v);
			
			//in order action
			result = (v.visit(r.data));
			r.right = doAccept(r.right, v);
			
			//post order action
			if (!result) {
				
				this.numElements--;
					
				if (r.right!= null && r.left!=null) {
					r.data = getFirst(r.right);
					r.right = removeFirst(r.right);
					return r;
				
				} else if (r.left==null) {
					return r.right;
					
				} else if (r.right==null) {
					return r.left;
				} 
			}
		}
		return r;
	}
	
	/**
	 * Call the visitor on every data in the set in order.
	 * if the visitor returns 'false' for any data, that data should be removed.
	 * @param v visitor to use, must not be null
	 */
	public void accept(Visitor v) {
		root = doAccept(root,v);
	}
	
	public static class TestInternals extends TestCase {
		VisitableStringSet self = new VisitableStringSet(false);
		String h1 = "1";
		String h2 = "2";
		String h3 = "3";
		String h4 = "4";
		String h5 = "5";
		String h6 = "6";
		String h7 = "7";
		String h8 = "8";
		String h9 = "9";

		String h1x = "1x";
		String h2x = "2x";
		String h3x = "3x";
		String h4x = "4x";
		String h5x = "5x";
		String h6x = "6x";
		String h7x = "7x";
		String h8x = "8x";

		@Override
		protected void setUp() {
			self = new VisitableStringSet(false);
			doReport = false;
		}
		
		protected Node copyNode(Node p) {
			Node result = new Node(p.data);
			result.left = p.left;
			result.right = p.right;
			return result;
		}
		
		
		/// test Gx: getFirst tests
		
		public void testG1() {
			Node a = new Node(h1);
			assertEquals(h1,getFirst(a));
		}
		
		public void testG2() {
			Node a = new Node(h2);
			a.right = new Node(h1);
			assertEquals(h2,getFirst(a));
		}
		
		public void testG3() {
			Node c = new Node(h3);
			c.left = new Node(h1);
			c.right = new Node(h5);
			assertEquals(h1,getFirst(c));
		}
		
		public void testG4() {
			Node a = new Node(h4);
			Node b = new Node(h3);
			Node c = new Node(h2);
			Node d = new Node(h1);
			c.left = a;
			a.right = b;
			c.right = d;
			// malformed tree, but getFirst shouldn't care:
			assertEquals(h4,getFirst(c));
		}
		
		public void testG5() {
			Node a = new Node(h4);
			Node b = new Node(h3);
			Node c = new Node(h2);
			Node d = new Node(h1);
			Node e = new Node(h5);
			c.left = b;
			b.left = a;
			a.right = d;
			b.right = e;
			assertEquals(h4,getFirst(c));
		}
		
		
		/// test Ix: is in order tests. 
		
		public void testI0() {
			assertEquals("null tree",true,isInProperOrder(null, null, null));
			assertEquals("null tree",true,isInProperOrder(null, null, null));
			assertEquals("null tree",true,isInProperOrder(null, null, h3));
			assertEquals("null tree",true,isInProperOrder(null, null, h3));
		}
		
		public void testI1() {
			Node a1 = new Node(h1);
			Node b2 = new Node(h2);
			assertEquals("one node tree",true,VisitableStringSet.isInProperOrder(a1,null,null));
			assertEquals("one node tree",true,VisitableStringSet.isInProperOrder(a1,null,h2));
			assertEquals("one node tree out of range",false,VisitableStringSet.isInProperOrder(a1,h1,null));
			assertEquals("one node tree out of range",false,VisitableStringSet.isInProperOrder(b2,null,h2));
			assertEquals("one node tree in range",true,VisitableStringSet.isInProperOrder(b2,h1,null));
			assertEquals("one node tree in range",true,VisitableStringSet.isInProperOrder(b2,h1,h3));
		}
		
		public void testI2() {
			Node a1 = new Node(h1);
			Node a2 = new Node(h1);
			Node b2 = new Node(h2);
			a1.left = a2;
			
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a1,null,null));

			b2.left = a2;
			assertEquals("OK tree (ba)",true,VisitableStringSet.isInProperOrder(b2,null,null));
		}

		public void testI3() {
			Node a1 = new Node(h1);
			Node a2 = new Node(h1);
			Node b2 = new Node(h2);
			a1.right = a2;
			
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a1,null,null));
			a1.right = b2;
			doReport = true;
			assertEquals("OK tree (ab)",true,VisitableStringSet.isInProperOrder(a1,null,null));
			a1.left = a1.right = null;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(a1,null,null));
		}
		
		public void testI4() {
			Node a1 = new Node(h1);
			Node b2 = new Node(h2);
			Node c3 = new Node(h3);
			
			b2.left = a1;
			
			b2.right = c3;
			
			assertEquals("OK tree (bac)",true,VisitableStringSet.isInProperOrder(b2,null,null));
			assertEquals("OK tree (bac) in range",true,VisitableStringSet.isInProperOrder(b2,null,h3x));
			assertEquals("tree (bac) not in hi range",false,VisitableStringSet.isInProperOrder(b2,null,h3));
			assertEquals("tree (bac) not in lo range",false,VisitableStringSet.isInProperOrder(b2,h1,null));
		}
		
		public void testI5() {
			Node a1 = new Node(h1);
			Node a2 = new Node(h1);
			Node a3 = new Node(h1);
			
			a1.left = a2;
			
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a1,null,null));
			a1.left=null;
			a1.right = a2;
			
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a1,null,null));
			a1.left=a3;
			
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a1,null,null));
			a1.left = a1.right = null;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(a1,null,null));
		}


		public void testI6() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			Node d = new Node(h4);
			Node e = new Node(h5);
			Node f = new Node(h6);
			
			c.left = b; 
			b.left = a; 
			c.right = e; 
			e.left = d; 
			
			e.data = null;
			assertEquals("null data in tree",false, VisitableStringSet.isInProperOrder(c,null,null));
			e.data = h5;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(c,null,null));
			
			e.left=f; 
			f.left=d; 
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(c,null,null));
			e.left = null;
			e.right=f;
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(c,null,null));			
			f.left = null;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(c,null,null));
			e.left=d;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(c,null,null));
			
			Node aa = new Node(h1x);
			a.left=aa;
			
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(c,null,null));
			a.left=null;
			a.right=aa;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(c,null,null));
		}
		
		public void testI7() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			Node d = new Node(h4);
			Node e = new Node(h5);
			Node f = new Node(h6);
			
			a.right = b; 
			b.right = c; 
			c.right = d; 
			d.right = e; 
			e.left=f; 
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a,null,null));
			e.left=null;
			a.left=f;
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a,null,null));
			a.left=b;
			a.right=null;
			assertEquals("malformed tree",false, VisitableStringSet.isInProperOrder(a,null,null));
			b.right=null;
			a.left=null;
			a.right=c;
			c.left=b;
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(a,null,null));
		}
		
		public void testI8() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			Node d = new Node(h4);
			Node e = new Node(h5);
			Node f = new Node(h6);
			Node g = new Node(h7);
			d.left = b; 
			d.right = f; 
			b.left = a; 
			b.right = c; 
			f.left = e; 
			f.right = g; 
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(d,null,null));	
			
			Node p = new Node(h8);
			p.left = d;
			
			assertEquals("good tree",true, VisitableStringSet.isInProperOrder(d,null,null));	
		}
		
		public void testI9() {
			Node n1 = new Node(h1);
			Node n2 = new Node(h2);
			Node n3 = new Node(h3);
			Node n4 = new Node(h4);
			n2.left = n1; 
			n2.right = n3; 
			n1.right = n2; 
			assertEquals("cyclic tree",false,VisitableStringSet.isInProperOrder(n2,null,null));
			n1.right = null;
			n3.left = n2; 
			assertEquals("cyclic tree",false,VisitableStringSet.isInProperOrder(n2,null,null));
			n3.left = null; 
			n3.right = n3; 
			assertEquals("cyclic tree",false,VisitableStringSet.isInProperOrder(n2,null,null));
			n3.right = n4; 
			assertEquals("acyclic tree",true,VisitableStringSet.isInProperOrder(n2,null,null));
			n4.left = n3; 
			assertEquals("cyclic tree",false,VisitableStringSet.isInProperOrder(n2,null,null));
		}
		
		
		/// testNx: testing countNodes
		
		public void testN1() {
			Node a = new Node(h1);
			assertEquals(1,countNodes(a));
		}
		
		public void testN2() {
			Node a1 = new Node(h1);
			Node a2 = new Node(h2);
			Node a3 = new Node(h3);
			a1.left =a2;
			a2.right = a3;
			assertEquals(3,countNodes(a1));
		}
		
		public void testN3() {
			Node a1 = new Node(h1);
			Node a2 = new Node(h2);
			Node a3 = new Node(h3);
			a1.left = a1.right = a2; a2.left = a2.right = a3;
			assertEquals(7,countNodes(a1));
		}
		
		
		/// testRx: tests for removeFirst

		public void testR1() {
			Node a = new Node(h1);
			assertEquals(null,removeFirst(a));
		}
		
		public void testR2() {
			Node a = new Node(h2);
			Node b = new Node(h1);
			a.right = b;
			assertEquals(b,removeFirst(a));
		}
		
		public void testR3() {
			Node c = new Node(h3);
			c.left = new Node(h1);
			c.right = new Node(h5);
			assertEquals(c,removeFirst(c));
			assertNull(c.left);
		}
		
		public void testR4() {
			Node a = new Node(h4);
			Node b = new Node(h3);
			Node c = new Node(h2);
			Node d = new Node(h1);
			c.left = a;
			a.right = b;
			c.right = d;
			// malformed tree, but removeFirst shouldn't care:
			assertEquals(c,removeFirst(c));
			assertEquals(b,c.left);
			assertEquals(d,c.right);
		}
		
		public void testR5() {
			Node a = new Node(h4);
			Node b = new Node(h3);
			Node c = new Node(h2);
			Node d = new Node(h1);
			Node e = new Node(h5);
			c.left = b;
			b.left = a;
			a.right = d;
			b.right = e;
			assertEquals(c,removeFirst(c));
			assertEquals(b,c.left);
			assertEquals(d,b.left);
			assertEquals(e,b.right);
		}
		
		
		/// textWx: Tests for wellFormed
		
		public void testW0() {
			self.numElements = 1;
			assertFalse(self.wellFormed());
			self.numElements = 0;
			doReport = true;
			assertTrue(self.wellFormed());
		}
		
		public void testW1() {
			self.root = new Node(h1);
			assertFalse(self.wellFormed());
			self.numElements = 1;
			assertTrue(self.wellFormed());
			self.numElements = 2;
			assertFalse(self.wellFormed());
			self.numElements = 1;
			self.root.data = null;
			assertFalse(self.wellFormed());
		}
		
		public void testW2() {
			Node a1 = new Node(h1);
			Node a2 = new Node(h1);
			Node b = new Node(h2);
			self.numElements = 2;
			assertFalse(self.wellFormed());
			self.root = a1;
			assertFalse(self.wellFormed());
			a1.right = a2; 
			assertEquals(false, self.wellFormed());
			a1.right = a1; 
			assertEquals(false, self.wellFormed());
			a1.right = b;  
			assertEquals(true, self.wellFormed());
			
			b.left = a1; 
			assertFalse(self.wellFormed());
			self.root = b; 
			assertFalse(self.wellFormed());
			a1.right = null;
			assertTrue(self.wellFormed());
			
			b.right = b;
			assertFalse(self.wellFormed());
		}
		
		public void testW3() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			c.left = a; 
			c.right = b; 
			self.root = c;
			
			self.numElements = 3;			
			assertEquals(false, self.wellFormed());
			self.numElements = 1;
			assertFalse(self.wellFormed());
		}
		
		public void testW4() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			Node d = new Node(h4);
			Node e = new Node(h5);
			Node f = new Node(h6);
			Node g = new Node(h7);
			Node h = new Node(h8);
			Node i = new Node(h9);
			
			self.root = e;
			e.left = c; 
			c.right = d; 
			c.left = a; 
			a.right = b; 
			e.right = h; 
			h.left = g; 
			g.left = f; 
			h.right = i; 
			self.numElements = 9;
			//you may want to draw a picture
			assertEquals(true, self.wellFormed());
			
			self.numElements = 10;
			assertFalse("incorrect count", self.wellFormed());
			
			a.left = new Node(h1x); 
			assertFalse(self.wellFormed());
			a.left = null;
			
			b.left = new Node(h1); 
			assertFalse(self.wellFormed());
			b.left = null;
			b.right = new Node(h3x); 
			assertFalse(self.wellFormed());
			b.right = null;
			
			--self.numElements;
			assertTrue(self.wellFormed());
			++self.numElements;
			
			d.left = new Node(h2x); 
			assertFalse(self.wellFormed());
			d.left = null;
			d.right = new Node(h5x);
			assertFalse(self.wellFormed());
			d.right = null;
			
			f.left = new Node(h4x);
			assertFalse(self.wellFormed());
			f.left = null;
			f.right = new Node(h7x);
			assertFalse(self.wellFormed());
			f.right = null;
			
			g.right = new Node(h8x);
			assertFalse(self.wellFormed());
			g.right = null;
			
			--self.numElements;
			assertTrue(self.wellFormed());
			++self.numElements;
			
			i.left = new Node(h7x);
			assertFalse(self.wellFormed());
			i.left = null;
			i.right = new Node(h8x); 
			assertFalse(self.wellFormed());
			i.right = null;
			
			--self.numElements;
			assertTrue(self.wellFormed());			
		}
		
		public void testW5() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			Node d = new Node(h4);
			Node e = new Node(h5);
			Node f = new Node(h6);
			Node g = new Node(h7);
			Node h = new Node(h8);
			Node i = new Node(h9);
			
			self.root = e;
			e.left = c; 
			c.right = d; 
			c.left = a; 
			a.right = b; 
			e.right = h; 
			h.left = g; 
			g.left = f; 
			h.right = i; 
			self.numElements = 9;
			//you may want to draw a picture
			assertEquals(true, self.wellFormed());
		}
		
		public void testW6() {
			Node a = new Node(h1);
			Node b = new Node(h2);
			Node c = new Node(h3);
			Node d = new Node(h4);
			Node e = new Node(h5);
			Node f = new Node(h6);
			Node g = new Node(h7);
			Node h = new Node(h8);
			Node i = new Node(h9);
			
			self.root = e;
			e.left = c; 
			c.right = d; 
			c.left = a; 
			a.right = b; 
			e.right = h; 
			h.left = g; 
			g.left = f; 
			h.right = i; 
			self.numElements = 9;
			//you may want to draw a picture
			assertEquals(true, self.wellFormed());
		}
	}

}
