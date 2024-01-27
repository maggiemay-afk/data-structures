package edu.uwm.apc430;

public class Collector {
	private final static String things[] = { "coin", "gem", "key", "ring", "stone" };
	
	public enum ThingType {
		NOTHING(-1), COIN(0), GEM(1), KEY(2), RING(3), STONE(4);
		
		private int value;
		
		private ThingType(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}	

		public final static String describe(ThingType t) {  
			if (t == ThingType.NOTHING) {
				return "nothing, check input!!"; 
			}
			else {
			   return things[t.getValue()];
			}
		}
	}
	
	private static class CollectorNode
	{
		ThingType thing;
		int count;
		CollectorNode next;
		
		public CollectorNode (ThingType thing, int count, CollectorNode next) {
			this.thing = thing;
			this.count = count;
			this.next = next;
		}
	}
	
	private CollectorNode head;
	
	public Collector() {
		head = null;
	}

	public Boolean hasNoThings() { 
		return head == null; 
	}

	public int howManyThings() {   
		int count = 0;
		for (CollectorNode cur = head; cur != null; cur=cur.next) {
			++count;
		}
		return count;
	}

	public int howManyOf(ThingType count_thing) {  
		for (CollectorNode cur = head; cur != null; cur=cur.next) {
			if (cur.thing == count_thing) return cur.count;
		}
		return 0;
	}

	public void grab(ThingType new_thing) {  
		// Being lazy is good. Never write two functions that are almost
		// the same if one can be written to use the other, without
		// change in function or in big-Oh efficiency.
		grabSome(new_thing,1);
	}
	
	/**
	 * Grab something, if the item already exists in the collector increment the existing count 
	 * by the new count
	 * 
	 * @param new_thing, new_thing of ThingType to add
	 * @param count, number of 
	 */
	public void grabSome(ThingType new_thing, int count) {  
		// if head is null construct a new node for head
		if (head==null) {
			head = new CollectorNode(new_thing,count,head); 
		}
		// if the head is the item we are adding then add here
		// reduces iterating through the linked list
		else if (head.thing == new_thing) {
			head.count += count;
		}
		else {   
			CollectorNode pre = null, cur = null;
			// start at the 2nd element 
			// (because we already checked the head)
			pre = head; 
			cur = head.next;
			
			// iterate through the elements in our list
			// and stop if we find it or hit the end
			while (cur != null && (new_thing != cur.thing)) {  
				pre = cur; 
				cur = cur.next;
			}
			
			//! --- Bug Section --- //
			if (cur == null) {
				CollectorNode n = new CollectorNode(new_thing,count,cur); // create the new node, hitching the current after it
				pre.next = n; // insert by hitching it after previous
			} else {
				if (cur.thing == new_thing) {
					cur.count += count;
					return;
				}
				
			}
		
			//! ---End of section--- //
		}
	}

	public void leave(ThingType lv_thing) {   
		CollectorNode pre = head, cur;
		if (head == null) {
			throw new IllegalStateException("No things to leave!");
		}
		else if (head.thing == lv_thing) {   
			if (head.count > 1) { 
				head.count--;
			}
			else {       
				head = head.next; 
			}
		} 
		else {   
			cur = head.next;
			while (cur != null && (lv_thing.getValue() > cur.thing.getValue())) {  
				pre = cur; 
				cur = cur.next;
			}
			if (cur != null && cur.thing == lv_thing) {  
				if (cur.count > 1) {
					cur.count--;
				}
				else {    
					pre.next = cur.next;
				}
			} 
			else {
				throw new IllegalStateException("No matching thing to leave!");
			}
		}
	}

	public void leaveAll(ThingType lv_thing) {  
		CollectorNode pre = head, cur;
		if (head == null) {
			throw new IllegalStateException("No things to leave!");
		}
		else if (head.thing == lv_thing) {    
			head = head.next;
		} 
		else {   
			cur = head.next;
			while (cur != null && (lv_thing.getValue() > cur.thing.getValue())) {   
				pre = cur; 
				cur = cur.next;
			}
			if (cur != null && cur.thing == lv_thing) {   
				pre.next = cur.next;
			} 
			else {
				throw new IllegalStateException("No matching thing to leave!");
			}
		}
	}

	public void leaveEverything() {  
		// while we have anything, drop all of what the first thing is.
		while (!hasNoThings()) {
			leaveAll(whatIs(0));
		}
	}

	public ThingType whatIs(int pos) {  
		if (pos < 0) {
			throw new IllegalStateException("list what_is position negative");
		}
		CollectorNode cur = head;
		for (int i = 0; i < pos; i++) {
			if (cur == null) {
				throw new IllegalStateException("list what_is position too large");
			}
			else {
				cur = cur.next;
			}
		}
		return cur.thing;
	}

	public int whereIs(ThingType loc_thing) {  
		int i = 0;
		CollectorNode cur = head;
		while (cur != null && loc_thing != cur.thing) {    
			cur = cur.next; 
			i++;
		}
		if (cur == null) {
			throw new IllegalStateException("Thing not found");
		}
		else return i;
	}
	
	public String show() {
		String s = "";
		if (!this.hasNoThings()) {   
    		s += "Collector has ";
    		int how_many = howManyThings();
            for (int j = 0; j < how_many; j++) {  
            	ThingType t = this.whatIs(j);
            	int how_many_of_this = this.howManyOf(t);
            	s += how_many_of_this + " " + ThingType.describe(t);
            	if (how_many_of_this > 1) {
            		s += "s";
            	}
            	if (j < how_many - 1) {
            		s += ", ";
            	}
            	if (j == (how_many -2)) {
            		s += "and ";
            	}
            }
        } 
        else {
        	s = "Collector has nothing.";
        }
		
		return s;
	}
}
