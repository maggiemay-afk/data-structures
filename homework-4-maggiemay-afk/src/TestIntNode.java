import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.uwm.apc430.IntNode;
import edu.uwm.cs.junit.LockedTestCase;

public class TestIntNode extends LockedTestCase {

	public void test() {
		// testing the string conversion code (for use by instructors)
		IntNode x = IntNode.stringToList("[1, 2, 3, ...2]");
		assertEquals("[1, 2, 3, ...2]",IntNode.listToString(x));
		x = IntNode.stringToList("[43, 45]");
		assertEquals("[43, 45]",IntNode.listToString(x));
	}
	
	
	/// test0x:  locked tests
	
	public void test00() {
		IntNode list1 = IntNode.stringToList("[1, 3, 5]");
		IntNode list2 = IntNode.stringToList("[2, 4, 6, 8]");
		
		IntNode result1 = IntNode.reverseCopy(list1);
		assertEquals(Ts(302367584),IntNode.listToString(result1));
		IntNode result2 = IntNode.evensCopy(list2);
		assertEquals(Ts(142086940), IntNode.listToString(result2));
		IntNode result3 = IntNode.zipCopy(list1, list2);
		assertEquals(Ts(417462484),IntNode.listToString(result3));
		IntNode result4 = IntNode.zipCopy(list2, list1);
		assertEquals(Ts(1010614361), IntNode.listToString(result4));
	}
	
	/// test1X: test of maximum
	
	public void test10() {
		assertEquals(Integer.MIN_VALUE,IntNode.maximum(null));
	}
	
	public void test11() {
		assertEquals(42,IntNode.maximum(IntNode.stringToList("[42]")));
	}
	
	public void test12() {
		assertEquals(2,IntNode.maximum(IntNode.stringToList("[1, 2]")));
	}
	
	public void test13() {
		assertEquals(2,IntNode.maximum(IntNode.stringToList("[1, 2, 0]")));
	}
	
	public void test14() {
		assertEquals(-100,IntNode.maximum(IntNode.stringToList("[-100, -200, -300]")));
	}
	
	public void test15() {
		assertEquals(5,IntNode.maximum(IntNode.stringToList("[1, 2, 3, 4, 5]")));
	}
	
	public void test16() {
		assertEquals(6,IntNode.maximum(IntNode.stringToList("[2, 4, 5, 3, 1, 6, 0]")));
	}
	
	
	/// test2X: test of copyList
	
	
	public void test20() {
		IntNode result = IntNode.copyList(null);
		assertNull(result);
	}
	
	public void test21() {
		IntNode input = IntNode.stringToList("[100]");
		IntNode result = IntNode.copyList(input);
		assertEquals("[100]",IntNode.listToString(input));
		assertEquals("[100]",IntNode.listToString(result));
		assertTrue(result != input);
	}
	
	public void test22() {
		IntNode input = IntNode.stringToList("[-1, -2]");
		IntNode result = IntNode.copyList(input);
		assertEquals("[-1, -2]",IntNode.listToString(input));
		assertEquals("[-1, -2]",IntNode.listToString(result));
		assertTrue(result != input);
		assertTrue(result.getNext() != input.getNext());
	}
	
	public void test23() {
		IntNode input = IntNode.stringToList("[1, 2, 3]");
		IntNode result = IntNode.copyList(input);
		assertEquals("[1, 2, 3]",IntNode.listToString(input));
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertTrue(result != input);
		assertTrue(result.getNext() != input.getNext());
		assertTrue(result.getNext().getNext() != input.getNext().getNext());
	}
	
	public void test24() {
		IntNode input = IntNode.stringToList("[0, 44, -17, 0]");
		IntNode result = IntNode.copyList(input);
		assertEquals("[0, 44, -17, 0]",IntNode.listToString(input));
		assertEquals("[0, 44, -17, 0]",IntNode.listToString(result));
		assertTrue(result != input);
		assertTrue(result.getNext() != input.getNext());
		assertTrue(result.getNext().getNext() != input.getNext().getNext());
		assertTrue(result.getNext().getNext().getNext() != 
				input.getNext().getNext().getNext());
	}
	
	private static final int LIST_LENGTH = 1_000_000;
	
	public void test29() {
		Random r = new Random();
		IntNode input = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			input = new IntNode(r.nextInt(),input);
		}
		IntNode result = IntNode.copyList(input);
		for (int i=0; i < LIST_LENGTH; ++i) {
			assertTrue(input != null && result != null);
			assertTrue(input != result);
			assertEquals(input.getData(), result.getData());
			input = input.getNext();
			result = result.getNext();
		}
		assertNull(result);
		assertNull(input);
	}
	
	
	/// test3X: test of reverseCopy
	
	public void test30() {
		IntNode result = IntNode.reverseCopy(null);
		assertNull(result);
	}
	
	public void test31() {
		IntNode input = IntNode.stringToList("[100]");
		IntNode result = IntNode.reverseCopy(input);
		assertEquals("[100]",IntNode.listToString(input));
		assertEquals("[100]",IntNode.listToString(result));
		assertTrue(result != input);
	}
	
	public void test32() {
		IntNode input = IntNode.stringToList("[-1, -2]");
		IntNode result = IntNode.reverseCopy(input);
		assertEquals("[-1, -2]",IntNode.listToString(input));
		assertEquals("[-2, -1]",IntNode.listToString(result));
		assertTrue(result != input.getNext());
		assertTrue(result.getNext() != input);
	}
	
	public void test33() {
		IntNode input = IntNode.stringToList("[1, 2, 3]");
		IntNode result = IntNode.reverseCopy(input);
		assertEquals("[1, 2, 3]",IntNode.listToString(input));
		assertEquals("[3, 2, 1]",IntNode.listToString(result));
		assertTrue(result != input.getNext().getNext());
		assertTrue(result.getNext() != input.getNext());
		assertTrue(result.getNext().getNext() != input);
	}
	
	public void test34() {
		IntNode input = IntNode.stringToList("[0, 44, -17, 0]");
		IntNode result = IntNode.reverseCopy(input);
		assertEquals("[0, 44, -17, 0]",IntNode.listToString(input));
		assertEquals("[0, -17, 44, 0]",IntNode.listToString(result));
		assertTrue(result != input.getNext().getNext().getNext());
		assertTrue(result.getNext() != input.getNext().getNext());
		assertTrue(result.getNext().getNext() != input.getNext());
		assertTrue(result.getNext().getNext().getNext() != input);
	}
	
	
	public void test39() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			input = new IntNode(r.nextInt(),input);
			nodes.add(input);
			ints.add(input.getData());
		}
		IntNode result = IntNode.reverseCopy(input);
		for (int i=0; i < LIST_LENGTH; ++i) {
			assertSame(nodes.get(LIST_LENGTH-i-1),input);
			assertEquals(ints.get(LIST_LENGTH-i-1).intValue(),input.getData());
			assertEquals(ints.get(i).intValue(), result.getData());
			input = input.getNext();
			result = result.getNext();
		}
		assertNull(result);
		assertNull(input);
	}

	
	/// test4X: test of reverseDestructive

	public void test40() {
		IntNode result = IntNode.reverseDestructive(null);
		assertNull(result);
	}
	
	public void test41() {
		IntNode input = IntNode.stringToList("[100]");
		IntNode result = IntNode.reverseDestructive(input);
		assertEquals("[100]",IntNode.listToString(input));
		assertEquals("[100]",IntNode.listToString(result));
		assertTrue(result == input);
	}
	
	public void test42() {
		IntNode input = IntNode.stringToList("[-1, -2]");
		IntNode inputNext = input.getNext();
		IntNode result = IntNode.reverseDestructive(input);
		assertEquals("[-2, -1]",IntNode.listToString(result));
		assertTrue(result == inputNext);
		assertTrue(result.getNext() == input);
	}
	
	public void test43() {
		IntNode input = IntNode.stringToList("[1, 2, 3]");
		IntNode inputNext = input.getNext();
		IntNode inputNextNext = input.getNext().getNext();
		IntNode result = IntNode.reverseDestructive(input);
		assertEquals("[3, 2, 1]",IntNode.listToString(result));
		assertTrue(result == inputNextNext);
		assertTrue(result.getNext() == inputNext);
		assertTrue(result.getNext().getNext() == input);
	}
	
	public void test44() {
		IntNode input = IntNode.stringToList("[0, 44, -17, 0]");
		IntNode inputNext = input.getNext();
		IntNode inputNextNext = input.getNext().getNext();
		IntNode inputNextNextNext = input.getNext().getNext().getNext();
		IntNode result = IntNode.reverseDestructive(input);
		assertEquals("[0, -17, 44, 0]",IntNode.listToString(result));
		assertTrue(result == inputNextNextNext);
		assertTrue(result.getNext() == inputNextNext);
		assertTrue(result.getNext().getNext() == inputNext);
		assertTrue(result.getNext().getNext().getNext() == input);
	}
	
	
	public void test49() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			input = new IntNode(r.nextInt(),input);
			nodes.add(input);
			ints.add(input.getData());
		}
		IntNode result = IntNode.reverseDestructive(input);
		for (int i=0; i < LIST_LENGTH; ++i) {
			assertSame(nodes.get(i),result);
			assertEquals(ints.get(i).intValue(), result.getData());
			result = result.getNext();
		}
		assertNull(result);
	}
	

	/// text5X: test of evensCopy
	
	
	public void test50() {
		IntNode result = IntNode.evensCopy(null);
		assertNull(result);
	}
	
	public void test51() {
		IntNode input = IntNode.stringToList("[100]");
		IntNode result = IntNode.evensCopy(input);
		assertEquals("[100]",IntNode.listToString(input));
		assertEquals("[100]",IntNode.listToString(result));
		assertTrue(result != input);
	}
	
	public void test52() {
		IntNode input = IntNode.stringToList("[-1, -2]");
		IntNode result = IntNode.evensCopy(input);
		assertEquals("[-1, -2]",IntNode.listToString(input));
		assertEquals("[-1]",IntNode.listToString(result));
	}
	
	public void test53() {
		IntNode input = IntNode.stringToList("[1, 2, 3]");
		IntNode result = IntNode.evensCopy(input);
		assertEquals("[1, 2, 3]",IntNode.listToString(input));
		assertEquals("[1, 3]",IntNode.listToString(result));
		assertTrue(result.getNext() != input.getNext().getNext());
	}
	
	public void test54() {
		IntNode input = IntNode.stringToList("[0, 44, -17, 0]");
		IntNode result = IntNode.evensCopy(input);
		assertEquals("[0, 44, -17, 0]",IntNode.listToString(input));
		assertEquals("[0, -17]",IntNode.listToString(result));
	}
	
	public void test55() {
		IntNode input = IntNode.stringToList("[0, 1, 2, 3, 4]");
		IntNode result = IntNode.evensCopy(input);
		assertEquals("[0, 1, 2, 3, 4]",IntNode.listToString(input));
		assertEquals("[0, 2, 4]",IntNode.listToString(result));
		assertTrue(result.getNext().getNext() != 
				input.getNext().getNext().getNext().getNext());
	}
	
	
	public void test59() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			input = new IntNode(r.nextInt(),input);
			nodes.add(input);
			ints.add(input.getData());
		}
		IntNode result = IntNode.evensCopy(input);
		for (int i=0; i < LIST_LENGTH; ++i) {
			assertSame(nodes.get(LIST_LENGTH-i-1),input);
			assertEquals(ints.get(LIST_LENGTH-i-1).intValue(),input.getData());
			input = input.getNext();
			if ((i & 1) == 0) {
				assertEquals(ints.get(LIST_LENGTH-i-1).intValue(), result.getData());
				result = result.getNext();
			}
		}
		assertNull(result);
		assertNull(input);
	}


	/// test6X: test of unzipDestructive

	public void test60() {
		IntNode result = IntNode.unzipDestructive(null);
		assertNull(result);
	}
	
	public void test61() {
		IntNode input = IntNode.stringToList("[100]");
		IntNode result = IntNode.unzipDestructive(input);
		assertEquals("[100]",IntNode.listToString(input));
		assertEquals("[]",IntNode.listToString(result));
	}
	
	public void test62() {
		IntNode input = IntNode.stringToList("[-1, -2]");
		IntNode inputNext = input.getNext();
		IntNode result = IntNode.unzipDestructive(input);
		assertEquals("[-1]",IntNode.listToString(input));
		assertEquals("[-2]",IntNode.listToString(result));
		assertTrue(result == inputNext);
	}
	
	public void test63() {
		IntNode input = IntNode.stringToList("[1, 2, 3]");
		IntNode inputNext = input.getNext();
		IntNode inputNextNext = inputNext.getNext();
		IntNode result = IntNode.unzipDestructive(input);
		assertEquals("[1, 3]",IntNode.listToString(input));
		assertEquals("[2]",IntNode.listToString(result));
		assertTrue(input.getNext() == inputNextNext);
		assertTrue(result == inputNext);
	}
	
	public void test64() {
		IntNode input = IntNode.stringToList("[0, 44, -17, 0]");
		IntNode inputNext = input.getNext();
		IntNode inputNextNext = inputNext.getNext();
		IntNode inputNextNextNext = inputNextNext.getNext();
		IntNode result = IntNode.unzipDestructive(input);
		assertEquals("[0, -17]",IntNode.listToString(input));
		assertEquals("[44, 0]",IntNode.listToString(result));
		assertTrue(input.getNext() == inputNextNext);
		assertTrue(result == inputNext);
		assertTrue(result.getNext() == inputNextNextNext);
	}
	
	public void test65() {
		IntNode input = IntNode.stringToList("[0, 1, 2, 3, 4]");
		IntNode inputNext = input.getNext();
		IntNode inputNextNext = inputNext.getNext();
		IntNode inputNextNextNext = inputNextNext.getNext();
		IntNode inputNextNextNextNext = inputNextNextNext.getNext();
		IntNode result = IntNode.unzipDestructive(input);
		assertEquals("[0, 2, 4]",IntNode.listToString(input));
		assertEquals("[1, 3]",IntNode.listToString(result));
		assertTrue(input.getNext() == inputNextNext);
		assertTrue(input.getNext().getNext() == inputNextNextNextNext);
		assertTrue(result == inputNext);
		assertTrue(result.getNext() == inputNextNextNext);
	}
	
	
	public void test69() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			input = new IntNode(r.nextInt(),input);
			nodes.add(input);
			ints.add(input.getData());
		}
		Collections.reverse(nodes);
		Collections.reverse(ints);
		IntNode result = IntNode.unzipDestructive(input);
		for (int i=0; i < LIST_LENGTH; ++i) {
			// no data should change:
			assertEquals(ints.get(i).intValue(),nodes.get(i).getData());
			if ((i & 1) == 0) {
				assertSame(nodes.get(i), input);
				input = input.getNext();
			} else {
				assertSame(nodes.get(i), result);
				result = result.getNext();
			}
		}
		assertNull(result);
		assertNull(input);
	}

	
	/// text7x: test of zipCopy
	
	public void test70() {
		assertNull(IntNode.zipCopy(null, null));
	}
	
	public void test71() {
		IntNode input1 = new IntNode(3,null);
		
		IntNode result = IntNode.zipCopy(input1, null);
		assertEquals("[3]",IntNode.listToString(result));
		assertTrue(result != input1);
		
		result = IntNode.zipCopy(null, input1);
		assertEquals("[3]",IntNode.listToString(result));
		assertTrue(result != input1);
	}
	
	public void test72() {
		IntNode input1 = new IntNode(-10,new IntNode(8,null));
		
		IntNode result = IntNode.zipCopy(input1, null);
		assertEquals("[-10, 8]",IntNode.listToString(result));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input1.getNext());
		
		result = IntNode.zipCopy(null, input1);
		assertEquals("[-10, 8]",IntNode.listToString(result));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input1.getNext());
		
		input1 = new IntNode(1, new IntNode (2, new IntNode(3, null)));
		result = IntNode.zipCopy(input1, null);
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertEquals("[1, 2, 3]",IntNode.listToString(input1));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input1.getNext());
		assertTrue(result.getNext().getNext() != input1.getNext().getNext());
		
		result = IntNode.zipCopy(null, input1);
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertEquals("[1, 2, 3]",IntNode.listToString(input1));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input1.getNext());	
		assertTrue(result.getNext().getNext() != input1.getNext().getNext());
	}
	
	public void test73() {
		IntNode input1 = new IntNode(77,null);
		IntNode input2 = new IntNode(-2,null);
		
		IntNode result = IntNode.zipCopy(input1, input2);
		assertEquals("[77, -2]",IntNode.listToString(result));
		assertEquals("[77]",IntNode.listToString(input1));
		assertEquals("[-2]",IntNode.listToString(input2));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input2);
		
		result = IntNode.zipCopy(input2, input1);
		assertEquals("[-2, 77]",IntNode.listToString(result));
		assertEquals("[77]",IntNode.listToString(input1));
		assertEquals("[-2]",IntNode.listToString(input2));
		assertTrue(result != input2);
		assertTrue(result.getNext() != input1);
	}

	public void test74() {
		IntNode input1 = new IntNode(1,new IntNode(3,null));
		IntNode input2 = new IntNode(2,null);
		
		IntNode result = IntNode.zipCopy(input1, input2);
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertEquals("[1, 3]",IntNode.listToString(input1));
		assertEquals("[2]",IntNode.listToString(input2));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input2);
		assertTrue(result.getNext().getNext() != input1.getNext());
		
		result = IntNode.zipCopy(input2, input1);
		assertEquals("[2, 1, 3]",IntNode.listToString(result));
		assertEquals("[1, 3]",IntNode.listToString(input1));
		assertEquals("[2]",IntNode.listToString(input2));
		assertTrue(result.getNext() != input1);
		assertTrue(result.getNext().getNext() != input1.getNext());
	}

	public void test75() {
		IntNode input1 = new IntNode(1,new IntNode(3,null));
		IntNode input2 = new IntNode(2,new IntNode(4,null));
		
		IntNode result = IntNode.zipCopy(input1, input2);
		assertEquals("[1, 2, 3, 4]",IntNode.listToString(result));
		assertEquals("[1, 3]",IntNode.listToString(input1));
		assertEquals("[2, 4]",IntNode.listToString(input2));
		assertTrue(result != input1);
		assertTrue(result.getNext() != input2);
		assertTrue(result.getNext().getNext() != input1.getNext());
		assertTrue(result.getNext().getNext().getNext() != input2.getNext());
		
		input1 = new IntNode(1,new IntNode(3, new IntNode(9,null)));
		input2 = new IntNode(2,null);
		result = IntNode.zipCopy(input1, input2);
		assertEquals("[1, 2, 3, 9]",IntNode.listToString(result));
		assertEquals("[1, 3, 9]",IntNode.listToString(input1));
		assertEquals("[2]",IntNode.listToString(input2));
		assertTrue(result.getNext().getNext() != input1.getNext());
		assertTrue(result.getNext().getNext().getNext() != 
				input1.getNext().getNext());
		
		result = IntNode.zipCopy(input2, input1);
		assertEquals("[2, 1, 3, 9]",IntNode.listToString(result));
		assertEquals("[1, 3, 9]",IntNode.listToString(input1));
		assertEquals("[2]",IntNode.listToString(input2));
		assertTrue(result.getNext() != input1);
		assertTrue(result.getNext().getNext() != input1.getNext());
		assertTrue(result.getNext().getNext().getNext() != 
				input1.getNext().getNext());
	}

	public void test76() {
		IntNode input1 = new IntNode(1,new IntNode(3, new IntNode(5, null)));
		IntNode input2 = new IntNode(2,new IntNode(4, new IntNode(6, null)));
		
		IntNode result = IntNode.zipCopy(input1, input2);
		assertEquals("[1, 2, 3, 4, 5, 6]",IntNode.listToString(result));
		assertEquals("[1, 3, 5]",IntNode.listToString(input1));
		assertEquals("[2, 4, 6]",IntNode.listToString(input2));
		
		input1 = new IntNode(3,new IntNode(7, new IntNode(11, new IntNode(13, null))));
		input2 = new IntNode(2,new IntNode(5, null));
		result = IntNode.zipCopy(input1, input2);
		assertEquals("[3, 2, 7, 5, 11, 13]",IntNode.listToString(result));
		assertEquals("[3, 7, 11, 13]",IntNode.listToString(input1));
		assertEquals("[2, 5]",IntNode.listToString(input2));
		assertTrue(result.getNext().getNext().getNext().getNext()
				!= input1.getNext().getNext());
		
		result = IntNode.zipCopy(input2, input1);
		assertEquals("[2, 3, 5, 7, 11, 13]",IntNode.listToString(result));
		assertEquals("[3, 7, 11, 13]",IntNode.listToString(input1));
		assertEquals("[2, 5]",IntNode.listToString(input2));
		assertTrue(result.getNext().getNext().getNext().getNext()
				!= input1.getNext().getNext());
	}

	public void test79() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input1 = null;
		IntNode input2 = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			int nextInt = r.nextInt();
			if ((i & 1) == 0) {
				input1 = new IntNode(nextInt,input1);
				nodes.add(input1);
			} else {
				input2 = new IntNode(nextInt,input2);
				nodes.add(input2);
			}
			ints.add(nextInt);
		}
		input1 = IntNode.reverseDestructive(input1);
		input2 = IntNode.reverseDestructive(input2);	
		IntNode result = IntNode.zipCopy(input1, input2);
		
		for (int i=0; i < LIST_LENGTH; ++i) {
			// no data should change:
			assertEquals(ints.get(i).intValue(),nodes.get(i).getData());
			if ((i & 1) == 0) {
				assertTrue(result != input1);
				assertEquals(input1.getData(), result.getData());
				input1 = input1.getNext();
			} else {
				assertTrue(result != input2);
				assertEquals(input2.getData(), result.getData());
				input2 = input2.getNext();
			}
			result = result.getNext();
		}
		assertNull(result);
		assertNull(input1);
		assertNull(input2);
	}
	
	
	/// test8X: test of zipDestructive
	
	public void test80() {
		assertNull(IntNode.zipDestructive(null, null));
	}
	
	public void test81() {
		IntNode input1 = new IntNode(3,null);
		
		IntNode result = IntNode.zipDestructive(input1, null);
		assertEquals("[3]",IntNode.listToString(result));
		assertTrue(result == input1);
		
		result = IntNode.zipDestructive(null, input1);
		assertEquals("[3]",IntNode.listToString(result));
		assertTrue(result == input1);
	}
	
	public void test82() {
		IntNode input1 = new IntNode(-10,new IntNode(8,null));
		
		IntNode result = IntNode.zipDestructive(input1, null);
		assertEquals("[-10, 8]",IntNode.listToString(result));
		assertTrue(result == input1);
		
		result = IntNode.zipDestructive(null, input1);
		assertEquals("[-10, 8]",IntNode.listToString(result));
		assertTrue(result == input1);
		
		input1 = new IntNode(1, new IntNode (2, new IntNode(3, null)));
		result = IntNode.zipDestructive(input1, null);
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertEquals("[1, 2, 3]",IntNode.listToString(input1));
		assertTrue(result == input1);
		
		result = IntNode.zipDestructive(null, input1);
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertEquals("[1, 2, 3]",IntNode.listToString(input1));
		assertTrue(result == input1);
	}
	
	public void test83() {
		IntNode input1 = new IntNode(77,null);
		IntNode input2 = new IntNode(-2,null);
		
		IntNode result = IntNode.zipDestructive(input1, input2);
		assertEquals("[77, -2]",IntNode.listToString(result));
		assertEquals("[-2]",IntNode.listToString(input2));
		assertTrue(result == input1);
		assertTrue(result.getNext() == input2);
		
		input1 = new IntNode(77,null);
		input2 = new IntNode(-2,null);		
		result = IntNode.zipDestructive(input2, input1);
		assertEquals("[-2, 77]",IntNode.listToString(result));
		assertEquals("[77]",IntNode.listToString(input1));
		assertTrue(result == input2);
		assertTrue(result.getNext() == input1);
	}

	public void test84() {
		IntNode input1 = new IntNode(1,new IntNode(3,null));
		IntNode input2 = new IntNode(2,null);
		
		IntNode result = IntNode.zipDestructive(input1, input2);
		assertEquals("[1, 2, 3]",IntNode.listToString(result));
		assertTrue(result == input1);
		assertTrue(result.getNext() == input2);
		
		input1 = new IntNode(1,new IntNode(3,null));
		input2 = new IntNode(2,null);
		result = IntNode.zipDestructive(input2, input1);
		assertEquals("[2, 1, 3]",IntNode.listToString(result));
		assertEquals("[1, 3]",IntNode.listToString(input1));
		assertTrue(result == input2);
		assertTrue(result.getNext() == input1);
	}

	public void test85() {
		IntNode input1 = new IntNode(1,new IntNode(3,null));
		IntNode input2 = new IntNode(2,new IntNode(4,null));
		IntNode input1Next = input1.getNext();
		IntNode input2Next = input2.getNext();
		IntNode result = IntNode.zipDestructive(input1, input2);
		assertEquals("[1, 2, 3, 4]",IntNode.listToString(result));
		assertTrue(result == input1);
		assertTrue(result.getNext() == input2);
		assertTrue(result.getNext().getNext() == input1Next);
		assertTrue(result.getNext().getNext().getNext() == input2Next);
		
		input1 = new IntNode(1,new IntNode(3, new IntNode(9,null)));
		input2 = new IntNode(2,null);
		result = IntNode.zipDestructive(input1, input2);
		assertEquals("[1, 2, 3, 9]",IntNode.listToString(result));
		assertTrue(result == input1);
		assertTrue(result.getNext() == input2);
		
		input1 = new IntNode(1,new IntNode(3, new IntNode(9,null)));
		input2 = new IntNode(2,null);
		input1Next = input1.getNext();
		result = IntNode.zipDestructive(input2, input1);
		assertEquals("[2, 1, 3, 9]",IntNode.listToString(result));
		assertTrue(result == input2);
		assertTrue(result.getNext() == input1);
		assertTrue(result.getNext().getNext() == input1Next);
	}

	public void test86() {
		IntNode input1 = new IntNode(1,new IntNode(3, new IntNode(5, null)));
		IntNode input2 = new IntNode(2,new IntNode(4, new IntNode(6, null)));
		IntNode input1Next = input1.getNext();
		IntNode input2Next = input2.getNext();
		IntNode input1NextNext = input1Next.getNext();
		IntNode input2NextNext = input2Next.getNext();
		
		IntNode result = IntNode.zipDestructive(input1, input2);
		assertEquals("[1, 2, 3, 4, 5, 6]",IntNode.listToString(result));
		assertTrue(result == input1);
		assertTrue(result.getNext() == input2);
		assertTrue(result.getNext().getNext() == input1Next);
		assertTrue(result.getNext().getNext().getNext() == input2Next);
		assertTrue(result.getNext().getNext().getNext().getNext() 
				== input1NextNext);
		assertTrue(result.getNext().getNext().getNext().getNext().getNext() 
				== input2NextNext);
		
		input1 = new IntNode(3,new IntNode(7, new IntNode(11, new IntNode(13, null))));
		input2 = new IntNode(2,new IntNode(5, null));
		input1Next = input1.getNext();
		input1NextNext = input1Next.getNext();
		result = IntNode.zipDestructive(input1, input2);
		assertEquals("[3, 2, 7, 5, 11, 13]",IntNode.listToString(result));
		assertTrue(result.getNext().getNext().getNext().getNext() 
				== input1NextNext);

		input1 = new IntNode(3,new IntNode(7, new IntNode(11, new IntNode(13, null))));
		input2 = new IntNode(2,new IntNode(5, null));
		result = IntNode.zipDestructive(input2, input1);
		assertEquals("[2, 3, 5, 7, 11, 13]",IntNode.listToString(result));
	}

	public void test89() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input1 = null;
		IntNode input2 = null;
		for (int i=0; i < LIST_LENGTH; ++i) {
			int nextInt = r.nextInt();
			if ((i & 1) == 0) {
				input1 = new IntNode(nextInt,input1);
				nodes.add(input1);
			} else {
				input2 = new IntNode(nextInt,input2);
				nodes.add(input2);
			}
			ints.add(nextInt);
		}
		input1 = IntNode.reverseDestructive(input1);
		input2 = IntNode.reverseDestructive(input2);	
		IntNode result = IntNode.zipDestructive(input1, input2);
		
		for (int i=0; i < LIST_LENGTH; ++i) {
			// no data should change:
			assertEquals(ints.get(i).intValue(),nodes.get(i).getData());
			assertTrue(result == nodes.get(i));
			result = result.getNext();
		}
		assertNull(result);
	}
	
	
	/// test9X: test of removeDuplicatesCopy (ALL THESE TESTS ARE OPTIONAL!)
	
	public void test90() {
		assertNull(IntNode.removeDuplicatesCopy(null));
	}
	
	public void test91() {
		IntNode input = new IntNode(5,null);
		
		IntNode result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[5]",IntNode.listToString(result));
		assertEquals("[5]",IntNode.listToString(input));
		assertTrue(result != input);
	}
	
	public void test92() {
		IntNode input = new IntNode(5, new IntNode(5, null));

		IntNode result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[5]",IntNode.listToString(result));
		assertEquals("[5, 5]",IntNode.listToString(input));
		assertTrue(result.getNext() != input);
		
		input = new IntNode(6, new IntNode(7, null));
		result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[6, 7]",IntNode.listToString(result));
		assertEquals("[6, 7]",IntNode.listToString(input));
		assertTrue(result != input);
		assertTrue(result.getNext() != input.getNext());
	}
	
	public void test93() {
		IntNode input = new IntNode(6, new IntNode(6, new IntNode(6, null)));

		IntNode result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[6]",IntNode.listToString(result));
		assertEquals("[6, 6, 6]",IntNode.listToString(input));
		assertTrue(result != input.getNext().getNext());
		
		input = new IntNode(7, new IntNode(4, new IntNode(7, null)));
		result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[7, 4]",IntNode.listToString(result));
		assertEquals("[7, 4, 7]",IntNode.listToString(input));
		
		input = new IntNode(0, new IntNode(0, new IntNode(7, null)));
		result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[0, 7]",IntNode.listToString(result));
		assertEquals("[0, 0, 7]",IntNode.listToString(input));
		assertTrue(result != input.getNext());
		assertTrue(result.getNext() != input.getNext().getNext());
		
		input = new IntNode(9, new IntNode(1, new IntNode(1, null)));
		result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[9, 1]",IntNode.listToString(result));
		assertEquals("[9, 1, 1]",IntNode.listToString(input));
		assertTrue(result.getNext() != input.getNext().getNext());
		
		input = new IntNode(7, new IntNode(8, new IntNode(9, null)));
		result = IntNode.removeDuplicatesCopy(input);		
		assertEquals("[7, 8, 9]",IntNode.listToString(result));
		assertEquals("[7, 8, 9]",IntNode.listToString(input));
		assertTrue(result != input);
		assertTrue(result.getNext() != input.getNext());
		assertTrue(result.getNext().getNext() != input.getNext().getNext());
	}
	
	public void test94() {
		IntNode input = IntNode.stringToList("[4, 4, 4, 4]");
		IntNode result = IntNode.removeDuplicatesCopy(input);
		
		assertEquals("[4]",IntNode.listToString(result));
		assertEquals("[4, 4, 4, 4]",IntNode.listToString(input));
		assertTrue(result != input.getNext().getNext().getNext());
		
		input = IntNode.stringToList("[3, 3, 9, 3]");
		result = IntNode.removeDuplicatesCopy(input);
		assertEquals("[3, 9]",IntNode.listToString(result));
		assertEquals("[3, 3, 9, 3]",IntNode.listToString(input));
		
		input = IntNode.stringToList("[1, 8, 8, 1]");
		result = IntNode.removeDuplicatesCopy(input);
		assertEquals("[1, 8]",IntNode.listToString(result));
		assertEquals("[1, 8, 8, 1]",IntNode.listToString(input));
		
		input = IntNode.stringToList("[1, 2, 3, 4]");
		result = IntNode.removeDuplicatesCopy(input);
		assertEquals("[1, 2, 3, 4]",IntNode.listToString(result));
		assertEquals("[1, 2, 3, 4]",IntNode.listToString(input));
		assertTrue(result != input);
		assertTrue(result.getNext() != input.getNext());
		assertTrue(result.getNext().getNext() != input.getNext().getNext());
		assertTrue(result.getNext().getNext().getNext() != 
				input.getNext().getNext().getNext());
	}
	
	public void test99() {
		Random r = new Random();
		List<Integer> ints = new ArrayList<>();
		List<Integer> unique = new ArrayList<>();
		List<IntNode> nodes = new ArrayList<>();
		IntNode input = null;
		for (int i=0; i < LIST_LENGTH/100; ++i) {
			int nextInt = r.nextInt(1000);
			ints.add(nextInt);
			if (!unique.contains(nextInt)) unique.add(nextInt);
			input = new IntNode(nextInt,input);
			nodes.add(input);
		}
		input = IntNode.reverseDestructive(input);
		IntNode result = IntNode.removeDuplicatesCopy(input);
		for (int i=0; i < unique.size(); ++i) {
			assertEquals(unique.get(i).intValue(), result.getData());
			result = result.getNext();
		}
		assertNull(result);
	}
}
