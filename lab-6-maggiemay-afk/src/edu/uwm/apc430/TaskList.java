package edu.uwm.apc430;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Comparator;

import javax.swing.JPanel;

import junit.framework.TestCase;


/**
 * Name: Maggie Herms
 * This TaskList represents a list of course tasks. It is implemented as
 * a doubly linked list. TaskList supports the notion of a current task
 * and has various methods to change the current task. The list supports 
 * adding and removing elements, and sorting the tasks. The list supports
 * null and duplicate elements.
 *  
 * @author cs351
 *
 */
public class TaskList {
	
	private Node _head, _cursor, _tail;
	
	public TaskList() {
		_head = _cursor = _tail = null;
		sortByDueDate();
	}
	
	/**
	 * create and add a task with the given description, due date and importance
	 * 
	 * @param description, description of the task
	 * @param dueDate, string due date of the task in the format ("hh:mm aa MM/dd/yyyy")
	 * @param importance, integer value of importance (greater is more important)
	 */
	public void add(String description, String dueDate, int importance) {
		add(new Task(description, dueDate, importance));
	}
	
	/**
	 * add a Task to the end of the list. If the list is empty
	 * then the element is added and becomes the current element
	 * 
	 * @param t, task to be added
	 */
	public void add(Task t) {
		// if empty add an element
		if (_head == null) _tail = _cursor = _head = new Node(t, null, null);
		else {
			_tail = _tail.after = new Node(t, _tail, _tail.after);
		}
	}
	
	/**
	 * moves the cursor the starting element if there is one
	 */
	public void start() {
		_cursor = _head;
	}
	
	/**
	 * moves the cursor the last element if there is one
	 */
	public void end() {
		_cursor = _tail;
	}
	
	/**
	 * If possible move forwards to the next node
	 */
	public void forward() {
		if (_cursor != null && _cursor.after != null) _cursor = _cursor.after;
	}
	
	/**
	 * If possible move backwards to the previous node
	 */
	public void backward() {
		if (_cursor != null && _cursor.before != null) _cursor = _cursor.before;
	}
	
	/**
	 * Return the current element or null if there is none
	 * @return the current element or null
	 */
	public Task getCurrent() {
		if (_cursor == null) return null;
		return _cursor.task;
	}
	
	/**
	 * Attempts to remove the current element. If there is none
	 * return false, otherwise remove and return true. The cursor
	 * after a successful removal should move back to the starting
	 * element
	 * 
	 * @return true if removal was successful
	 * @postcondition if the removal was successful, the cursor
	 * will now point to the starting element
	 */
	public boolean removeCurrent() {
		if (_cursor == null) return false;

		// TODO Think of the three cases
		
		if (_cursor.before == null && _cursor.after == null) {
			_cursor = null;
			_head = null;
			_tail = null;
		} else if (_cursor.before == null) { // 1. If the cursor is at the head
			_head = _cursor.after;
			_head.before = null;
		} else if (_cursor.after == null) { // 2. If the cursor is at the tail
			_tail = _tail.before;
			_tail.after = null;
		} else { // 3. If the cursor is anywhere else
			_cursor.before.after = _cursor.after;
			_cursor.after.before = _cursor.before;
		}
		
		// Done for you, but we reset the _cursor back to _head. 
		_cursor = _head;
		
		return true;
	}
	
	/**
	 * Sort using the given comparator
	 * 
	 * @param comparator
	 */
	public void sort(Comparator<Task> comparator) {
		if (_head == null || _head.after == null) return;
		bubbleSort(comparator);
		_cursor = _head;
	} 


	/**
	 * using bubbleSort, sort the elements by the given comparator
	 * @precondition assume that there is at least one element and therefore _head is not null
	 * 
	 * Note: Comparator usage
	 *    comparator.compare(t1,t2) returns and integer
	 *       if t1 comes before t2,  returns a negative number
	 *       if t1 comes after t2,  returns a positive number
	 *       if t1 and t2 are interchangeable, returns 0
	 */
	private void bubbleSort(Comparator<Task> comparator) {
		boolean swapped = false;
		Node current = _head;
		
		while (current.after != null) {
			//TODO 
			// compare current and the next element
			// if they are out of order then swap
			if (comparator.compare(current.task, current.after.task) > 0 ) {
				swap(current);
				swapped = true;
			} else{
				current = current.after;
			}
		}
		if (swapped) bubbleSort(comparator); 

	}
	
	/**
	 * Swaps the given current node with the following node
	 * 
	 * @param current, current node to swap with current.next
	 */
	private void swap(Node current) {
		Node next = current.after;
		
		if (next.after != null) next.after.before = current;
		if (current.before != null) current.before.after = next;
		current.after = next.after;
		next.before = current.before;
		next.after = current;
		current.before = next;
		if (current == _head) _head = next;
		if (next == _tail) _tail = current;
	}
	
	/**
	 * sorts the list by the due date
	 */
	public void sortByDueDate() {
		Comparator<Task> comp = TaskList.dueDateComparator();
		sort(comp);
	}
	
	private static Comparator<Task> dueDateComparator() {
		return new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				return o1.getDueDateAsDate().compareTo(o2.getDueDateAsDate());
			}
		};
	}
	
	/**
	 * sorts the list by the importance
	 * where the higher the importance value the more important a task is
	 */
	public void sortByImportance() {
		// TODO   
		// Set the comparator to an anonymous class implementing
		// the interface Comparator<Task>(). You may use the 
		// sortByDueDate() as an example, but compare by the 
		// importance of the tasks (greater the number the greater the importance).
		// You should use the importanceComparator() method to
		// create the anonymous comparator.
		Comparator<Task> comp = TaskList.importanceComparator();
		
		sort(comp);
	}
	
	private static Comparator<Task> importanceComparator(){
		return new Comparator<Task>() {
			// TODO
			// Make this comparator actually compare these tasks according to importance.
			// Tasks should be sorted in descending order.
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.importance > o2.importance) {
					return -1;
				} else if (o1.importance < o2.importance) {
					return 1;
				} else {
					return 0;
				}
			
			}
		};
	}
	
	/**
	 * private Node class
	 */
	private static class Node {
		Task task;
		Node before, after;
		
		Node(Task t, Node p, Node n) {
			task = t;
			before = p;
			after = n;
		}
	}
	
	/**
	 * Creates a canvas to reflect the state of the Task List
	 * @return
	 */
	public JPanel makeCanvas() {
		return new TaskListCanvas();
	}
	
	private class TaskListCanvas extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2226594746308463675L;
		
		private static final int BOX_WIDTH = 130, BOX_HEIGHT = 100, SECTION_HEIGHT = 20;
		private static final int X_SPACE = 15;
		private static final int Y = 10;
		private static final int ARROWSIZE = 5;
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Node cursor = _head;
			int x = 10;
			while (cursor != null) {
				paintBox(g,x,cursor);
				x+= BOX_WIDTH + X_SPACE;
				cursor = cursor.after;
			}
		}
		
		private void paintBox(Graphics g, int x, Node cursor) {
			if (cursor == _cursor) paintRectangle(g,x,Color.YELLOW);
			else paintRectangle(g,x,null);
			paintText(g, x, Y+ SECTION_HEIGHT - 5, cursor.task.description );
			paintText(g, x, Y + SECTION_HEIGHT * 2 - 5, "Importance: " + Integer.toString(cursor.task.importance));
			paintText(g, x, Y + SECTION_HEIGHT * 3 - 5, cursor.task.getDueDate());
			if (cursor.before != null) paintPrevPointer(g, x);
			if (cursor.after != null) paintNextPointer(g, x);
		}
		
		private void paintRectangle(Graphics g, int x, Color color) {
			if (color != null) {
				Color previous = g.getColor();
				g.setColor(color);
				g.fillRect(x, Y, BOX_WIDTH, BOX_HEIGHT);
				g.setColor(previous);
			}
			g.drawRect(x, Y, BOX_WIDTH, BOX_HEIGHT);
			for (int y2 = SECTION_HEIGHT; y2 < BOX_HEIGHT; y2 += SECTION_HEIGHT) {
				g.drawLine(x, Y + y2, x + BOX_WIDTH, Y + y2);
			}
		}
		
		private void paintText(Graphics g, int x, int y, String text ) {
			FontMetrics fm = getFontMetrics( getFont() );
			int textWidth = fm.stringWidth(text);
			if (textWidth > BOX_WIDTH) {
				int textX = x + (BOX_WIDTH - 10) / 2;
				g.drawString("...", textX, y );
			} else {
				int textX = x + (BOX_WIDTH - textWidth) / 2;
				g.drawString(text, textX, y );
			}
		}
		
		private void paintNextPointer(Graphics g, int x) {
			int startX = x+BOX_WIDTH/2;
			int startY = Y+BOX_HEIGHT-SECTION_HEIGHT/2;
			int endX = x+BOX_WIDTH+X_SPACE;
			int [] pointx = { endX, endX - ARROWSIZE, endX -ARROWSIZE};
			int [] pointy = { startY, startY + ARROWSIZE, startY - ARROWSIZE};
			g.drawLine(startX, startY, endX, startY);
			g.fillPolygon(pointx, pointy, pointx.length);
		}
		
		private void paintPrevPointer(Graphics g, int x) {
			int startX = x-X_SPACE;
			int startY = Y+BOX_HEIGHT-SECTION_HEIGHT-SECTION_HEIGHT/2;
			int endX = x+BOX_WIDTH/2;
			int [] pointx = { startX, startX + ARROWSIZE, startX + ARROWSIZE};
			int [] pointy = { startY, startY + ARROWSIZE, startY - ARROWSIZE};
			g.drawLine(startX, startY, endX, startY);
			g.fillPolygon(pointx, pointy, pointx.length);
		}
	}
	
	public static class TestTaskList extends TestCase {
		protected static Task t1 = new Task("Task 1","7:00 AM 2/21/2013",5);
		protected static Task t2 = new Task("Task 2","8:00 AM 2/21/2013",10);
		protected static Task t3 = new Task("Task 3","9:00 AM 2/21/2013",0);
		protected TaskList list;
		
		@Override
		public void setUp() {
			list = new TaskList();
			list.add(t1);
			list.add(t2);
			list.add(t3);
			list.start();
		}
		
		public void testDueDateComparator() {
			assertTrue(TaskList.dueDateComparator().compare(t1, t1) == 0);
			assertTrue(TaskList.dueDateComparator().compare(t2, t2) == 0);
			assertTrue(TaskList.dueDateComparator().compare(t3, t3) == 0);
			assertTrue(TaskList.dueDateComparator().compare(t1, t2) < 0);
			assertTrue(TaskList.dueDateComparator().compare(t2, t1) > 0);
			assertTrue(TaskList.dueDateComparator().compare(t1, t3) < 0);
			assertTrue(TaskList.dueDateComparator().compare(t3, t1) > 0);
			assertTrue(TaskList.dueDateComparator().compare(t2, t3) < 0);
			assertTrue(TaskList.dueDateComparator().compare(t3, t2) > 0);
		}
		
		public void testImportanceComparator() {
			assertTrue(TaskList.importanceComparator().compare(t1, t1) == 0);
			assertTrue(TaskList.importanceComparator().compare(t2, t2) == 0);
			assertTrue(TaskList.importanceComparator().compare(t3, t3) == 0);
			assertTrue(TaskList.importanceComparator().compare(t1, t2) > 0);
			assertTrue(TaskList.importanceComparator().compare(t2, t1) < 0);
			assertTrue(TaskList.importanceComparator().compare(t1, t3) < 0);
			assertTrue(TaskList.importanceComparator().compare(t3, t1) > 0);
			assertTrue(TaskList.importanceComparator().compare(t2, t3) < 0);
			assertTrue(TaskList.importanceComparator().compare(t3, t2) > 0);
		}
		
		public void testRemoveSingle(){
			list = new TaskList();
			list.add(t1);
			list.start();
			list.removeCurrent();
			assertTrue(list._head==null);
			assertTrue(list._tail==null);
			assertTrue(list._cursor==null);
		}
		
		
		public void testRemoveBeginning() {
			assertSame(t1, list.getCurrent());
			assertTrue( list.removeCurrent());
			assertListForwardEquals(list,t2,t3);
			assertListBackwardEquals(list,t3,t2);
			assertTrue(list._head.before == null);
			
		}
		
		public void testRemoveMiddle() {
			list.forward();
			assertSame(t2, list.getCurrent());
			assertTrue( list.removeCurrent());
			assertListForwardEquals(list,t1,t3);
			assertListBackwardEquals(list,t3,t1);
		}
		
		public void testRemoveEnding() {
			list.end();
			assertSame(t3, list.getCurrent());
			assertTrue( list.removeCurrent());
			assertListForwardEquals(list,t1,t2);
			assertListBackwardEquals(list,t2,t1);
			assertTrue(list._tail.after == null);
		}
		
		public void testBubbleSort() {
			list.add(t3);
			list.add(t1);
			list.sortByDueDate();
			assertListForwardEquals(list,t1,t1,t2,t3,t3);
			assertListBackwardEquals(list,t3,t3,t2,t1,t1);
			
		}
		
		public void testSortByImportance() {
			list.sortByImportance();
			assertListForwardEquals(list,t2,t1,t3);
			assertListBackwardEquals(list,t3,t1,t2);
		}
		
		/**
		 * Tests that the list is in the correct order starting from node 0 to node n-1
		 * where n is the size of the list
		 */
		private void assertListForwardEquals(TaskList list, Task... tasks) {
			int i = 0;
			for (Task task : tasks) {
				assertSame("On node "+ i + ":",task, list.getCurrent());
				list.forward();
				++i;
			}
		}

		
		/**
		 * Tests that the list is in the correct order starting from node n-1 to node 0
		 * where n is the size of the list
		 */
		private void assertListBackwardEquals(TaskList list, Task... tasks) {
			list.end();
			int i = tasks.length-1;
			for (Task task : tasks) {
				assertSame("On node "+ i + ":",task, list.getCurrent());
				list.backward();
				--i;
			}
		}
	}

}
