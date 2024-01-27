

import edu.uwm.apc430.IntNode;
import junit.framework.TestCase;

public class LabExercises extends TestCase {

	public void test0() {
		assertEquals("[]",IntNode.listToString(IntNode.exercise0()));
	}
	
	public void test1() {
		assertEquals("[42]",IntNode.listToString(IntNode.exercise1()));
	}
	
	public void test2() {
		assertEquals("[1, 2, 3]",IntNode.listToString(IntNode.exercise2()));
	}
	
	public void test3() {
		assertEquals("[9, ...1]",IntNode.listToString(IntNode.exercise3()));
	}
	
	public void test4() {
		assertEquals("[4, 3, 2, 1, ...2]",IntNode.listToString(IntNode.exercise4()));
	}
	
	public void test5() {
		IntNode list = IntNode.exercise2();
		IntNode n1 = list;
		IntNode n2 = n1.getNext();
		IntNode n3 = n2.getNext();
		IntNode result = IntNode.exercise5(list);
		assertEquals("[1, 4, 3]",IntNode.listToString(result));
		assertSame(n1,result);
		assertSame(n2,result.getNext());
		assertSame(n3,result.getNext().getNext());
	}
	
	public void test6() {
		IntNode list = IntNode.exercise2();
		IntNode n1 = list;
		IntNode n2 = n1.getNext();
		IntNode n3 = n2.getNext();
		IntNode result = IntNode.exercise6(list);
		assertEquals("[1, 3]",IntNode.listToString(result));
		assertSame(n1,result);
		assertSame(n3,result.getNext());
	}
	
	public void test7() {
		assertEquals(0,IntNode.exercise7(null));
		assertEquals(1,IntNode.exercise7(IntNode.exercise1()));
		assertEquals(3,IntNode.exercise7(IntNode.exercise2()));
	}
	
	public void test8() {
		IntNode input = null;
		IntNode result = IntNode.exercise8(input);
		assertEquals("[]",IntNode.listToString(result));
		
		input = IntNode.exercise1();
		result = IntNode.exercise8(input);
		assertEquals("[42]",IntNode.listToString(result));
		assertEquals("[42]",IntNode.listToString(input));
		assertTrue("result should not share nodes with input",result != input);
		
		input = IntNode.exercise2();
		result = IntNode.exercise8(input);
		assertEquals("[1, 2, 3]", IntNode.listToString(result));
		assertEquals("[1, 2, 3]", IntNode.listToString(input));
		assertTrue("Result should not share first node with input", result != input);
		assertTrue("Result should not share second node with input", result.getNext() != input.getNext());
		assertTrue("Result should not share third node with input", result.getNext().getNext() != input.getNext().getNext());
	}
	
	public void test9() {
		IntNode list;
		IntNode result;
		list = IntNode.exercise1();
		result = IntNode.exercise9(list, 8);
		assertEquals("[42, 8]",IntNode.listToString(result));
		assertSame(list,result);
		list = IntNode.exercise2();
		result = IntNode.exercise9(list, 4);
		assertEquals("[1, 2, 3, 4]",IntNode.listToString(result));
		assertSame(list,result);
	}
}
