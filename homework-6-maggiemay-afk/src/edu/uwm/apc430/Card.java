package edu.uwm.apc430;

import static edu.uwm.apc430.Card.Rank.ACE;
import static edu.uwm.apc430.Card.Rank.DEUCE;
import static edu.uwm.apc430.Card.Rank.KING;
import static edu.uwm.apc430.Card.Rank.SIX;
import static edu.uwm.apc430.Card.Suit.CLUB;
import static edu.uwm.apc430.Card.Suit.DIAMOND;
import static edu.uwm.apc430.Card.Suit.HEART;
import static edu.uwm.apc430.Card.Suit.SPADE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.uwm.cs.junit.LockedTestCase;

/**
 * Traditional playing cards.
 * Name: Maggie Herms
 * @author boyland
 */
public class Card {
	public enum Suit { CLUB, DIAMOND, HEART, SPADE };
	public enum Rank {
		ACE(1), DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT (8), NINE(9), TEN(10),
		JACK(11), QUEEN(12), KING(13);

		private final int rank;
		private Rank(int r) {
			rank = r;
		}

		public int asInt() {
			return rank;
		}
	}

	private final Suit suit;
	private final Rank rank;
	private Card prev, next;

	private Card() {
		rank = null;
		suit = null;
	}
	
	public Card(Rank r, Suit s) {
		if (r == null || s == null) throw new IllegalArgumentException("Not a legal card");
		rank = r;
		suit = s;
	}

	// getters for all fields:

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Card getPrevious() {
		if (prev == null || prev.suit == null) return null;
		return prev;
	}

	public Card getNext() {
		if (next == null || next.suit == null) return null;
		return next;
	}

	// no setters!

	@Override
	/** Return true if the suit and rank are the same.
	 * Caution: do not use this method to check if you have the same card!
	 */
	public boolean equals(Object x) {
		if (!(x instanceof Card)) return false;
		Card other = (Card)x;
		return suit == other.suit && rank == other.rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit + "S";
	}


	/**
	 * An endogenous DLL of card objects.
	 */
	public static class Group {
		private Card dummy;

		private Group(boolean ignored) {} // do not change
		
		private static boolean reportErrors = true; // do not change
		private boolean report(String s) {
			if (reportErrors) System.err.println("Invariant error: " + s);
			return false;
		}
		
		private boolean wellFormed() {
			// (1) dummy is not null, but has null suit and rank.
			// (2) the cards are linked in a cycle starting and ending at the dummy.		
			// (3) Whenever c1.next == c2 is in the cycle, the c2.prev == c1
			// (4) no cards except the dummy have null suit or rank.
			// Implement the invariant:
			// This code must terminate and must not crash even if there are problems.			
			
			if (dummy == null) return report ("Dummy cannot be null");
			if (dummy.rank != null && dummy.suit != null) return report ("Dummy rank and suit must be null");			
			
			Card testOne = dummy;
			Card testOneAhead = testOne.next; 
			
			while (testOneAhead != dummy) {
				
				if (testOneAhead == null) {
					return report ("No card can be null");
				} else if ((testOneAhead.rank == null || testOneAhead.suit == null)){
					return report("No card other than dummy can have null suit or rank");
				} else if (testOne.next == testOneAhead && testOneAhead.prev != testOne){
					return report("Card 1 . next == Card 2, but Card 2 prev != Card 1");
				} 
				
				testOne = testOne.next;
				testOneAhead = testOne.next;
				
			}
			
			if (testOne.next == testOneAhead && testOneAhead.prev != testOne) {
				return report ("Card 1 . next == Card 2, but Card 2 prev != Card 1");
			}
				
			return true;
		}

		/**
		 * Create an empty group.
		 */
		public Group() {
			//initialize empty group
			dummy = new Card();
			dummy.next = dummy;
			dummy.prev = dummy;
			
			assert wellFormed() : "Group initialized wrong";
		}

		public Card getFirst() { return dummy.getNext(); }
		public Card getLast() { return dummy.getPrevious(); }

		/**
		 * Return true if there are no cards,
		 * that is, if and only if getFirst() == null. O(1)
		 * @return boolean, true if there are no cards, false otherwise
		 */
		public boolean isEmpty() {
			assert wellFormed() : "invariant false on entry to isEmpty()";

			if (getFirst() == null) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Return the number of cards in this pile. O(n)
		 * @return int, number of cards in this group
		 */
		public int count() {
			assert wellFormed() : "invariant false on entry to count()";
			//(a loop will be necessary)
			
			Card newCard = getFirst();
			int counter = 0;
			if(isEmpty()) return counter;
			counter++;
			
			while (newCard.next != dummy) {
				counter++;
				newCard = newCard.next;
			}
			return counter;
		}

		/**
		 * Add a card to the end of this pile/hand. O(1)
		 * @param c card to add, must not be null or in a group already.
		 * @throws IllegalArgumentException if the card is in a group already.
		 */
		public void add(Card c) throws IllegalArgumentException {
			// No loops or special cases allowed!
			// (Use "if" only to check errors)
			// Make sure to test invariant at start and before returning.
			assert wellFormed() : "Invariant failed at start of add";
			
			if (c == null || c.next != null || c.prev != null) {
				throw new IllegalArgumentException("Card can't be null or in another list");
			}
			
			if (dummy.next == null) {
				dummy.next = c;
				dummy.prev = c;
				c.next = dummy;
				c.prev = dummy;
			} else {
				Card end = dummy.prev;
				end.next = c;
				c.prev = end;
				c.next = dummy;
				dummy.prev = c;				
			}
			
			assert wellFormed() : "Invariant failed at end of add";
			
		}

		/**
		 * Remove the first card and return it.
		 * The group must not be empty.  The resulting card
		 * will not belong to any group afterwards. O(1)
		 *@throws IllegalStateException if group empty
		 *@return Card, the card that's been removed from this group
		 */
		public Card draw() throws IllegalStateException {
			// No loops or special cases allowed!
			// The only "if" needed is for error checking.
			// Make sure to test invariant at start and before returning.
			assert wellFormed() : "Invariant failed at start of draw";
			if(isEmpty()) throw new IllegalStateException("group must not be empty");
			
			Card first = dummy.next;
			Card afterFirst = first.next;
			
			dummy.next = afterFirst;
			afterFirst.prev = dummy;
			
			first.next = null;
			first.prev = null;
			
			assert wellFormed() : "Invariant failed at end of draw";
			return first;
		}

		/**
		 * Remove the given card from what group it is in.
		 * Afterwards the card is not in any group. O(1)
		 * @param c, card in this group, must not be null
		 * @throws IllegalArgumentException if c is not in a group
		 */
		public void remove(Card c) throws IllegalArgumentException {
			// No loops or special cases allowed!
			// The only "if"(s) are need for error checks.
			// Make sure to test invariant!
			assert wellFormed() : "Invariant failed at start of remove";
			
			if (c == null || c.next == null || c.prev == null) {
				throw new IllegalArgumentException("Card must not be null, or not in a list");
			} if (isEmpty()) {
				throw new IllegalStateException("group must not be empty");
			}
			
			Card previous = c.prev;
			Card next = c.next;
			
			previous.next = next;
			next.prev = previous;
			
			c.next = null;
			c.prev = null;
			
			assert wellFormed() : "Invariant failed at end of remove";
		}

		/**
		 * Sort the cards using the given comparison, so that
		 * after sorting for all cards c in the group that is not last
		 * <code>cmp.compare(c,c.next)</code> is never positive.
		 * This code must use insertion sort so that it is efficient
		 * on (mostly) sorted lists.
		 * @param cmp comparator to use for sorting.  Must not be null.
		 * The comparator should work correctly, or the final result is undefined.
		 */
		public void sort(Comparator<Card> cmp) {
			assert wellFormed() : "invariant false on entry to sort()";
			
			for (Card c = dummy.next.next; c != dummy; ) {
				Card next = c.next; // the next card to insert
				Card prev = c.prev; // the card after which to insert c
				
				// Move prev back as necessary so that
				// it is the card that that c should go after:
				// (You will need to use the comparator.)
				
				while (prev != dummy && (cmp.compare(prev, c) > 0)) {
					prev = prev.prev;	
				} 
				
				if (c.prev != prev) { // if it's the same, the card doesn't move!
					// we have to swap, which has two steps:
					// (1) remove it from where it is:
					c.prev.next = c.next;
					c.next.prev = c.prev;
					// (2) stick in new location:
					c.prev = prev;
					c.next = prev.next;
					c.next.prev = c;
					c.prev.next = c;
				}
				
				c = next;
			}
			assert wellFormed() : "invariant false on exit to sort()";
		}

		/**
		 * Randomize the order of the cards in this group.
		 */
		public void shuffle() {
			assert wellFormed() : "invariant false on entry to shuffle()";
			/*
			 * This is very different from the sort method because:
			 * @ we decant the cards into an array list;
			 * @ we use a library function to do the work;
			 * The implementation we write for the sort method will
			 * have *neither* of these characteristics.
			 */
			List<Card> cards = new ArrayList<Card>();
			while (!isEmpty()) {
				cards.add(draw());
			}
			Collections.shuffle(cards);
			for (Card c: cards) {
				add(c);
			}
			assert wellFormed() : "invariant false on exit of shuffle()";
		}
	}
	
	// Do not change this code!
	public static class TestInvariant extends LockedTestCase {
		private Group self;
		private Card blank = new Card();
		private Card blank2 = new Card();
		private Card c[] = { null,
				new Card(ACE,DIAMOND),
				new Card(DEUCE,DIAMOND),
				new Card(KING,DIAMOND),
				new Card(DEUCE,CLUB),
				new Card(KING,HEART),
				new Card(SIX,HEART),	
				new Card(ACE,SPADE),
		};
		private Card c2[] = { null,
				new Card(ACE,DIAMOND),
				new Card(DEUCE,DIAMOND),
				new Card(KING,DIAMOND),
				new Card(DEUCE,CLUB),
				new Card(KING,HEART),
				new Card(SIX,HEART),	
				new Card(ACE,SPADE),
		};

		@Override
		protected void setUp() {
			Group.reportErrors = false;
			self = new Group(false);
		}

		public void testA() {
			assertFalse(self.wellFormed());
		}
		
		public void testB() {
			self.dummy = c[1];
			c[1].next = c[1].prev = c[1];
			assertFalse(self.wellFormed());
		}
		
		public void testC() {
			self.dummy = blank;
			assertFalse(self.wellFormed());
		}

		public void testD() {
			self.dummy = blank;
			blank.next = blank;
			assertFalse(self.wellFormed());
			blank.prev = blank2;
			assertFalse(self.wellFormed());
			blank.prev = c[1];
			assertFalse(self.wellFormed());
		}

		public void testE() {
			self.dummy = blank;
			blank.next = blank2;
			blank.prev = blank;
			blank2.prev = blank;
			blank2.next = blank;
			assertFalse(self.wellFormed());
		}
		
		public void testF() {
			self.dummy = blank;
			blank.next = blank.prev = blank;
			Group.reportErrors = true;
			assertTrue(self.wellFormed());
		}

		public void testG() {
			Card ace = c[1];
			self.dummy = blank;
			blank.next = ace;
			blank.prev = ace;
			ace.prev = blank;
			ace.next = blank;
			Group.reportErrors = true;
			assertTrue(self.wellFormed());
		}

		public void testH() {
			Card ace = c[1];
			self.dummy = blank;
			// blank.next = ace;
			blank.prev = ace;
			ace.prev = blank;
			ace.next = blank;
			assertFalse(self.wellFormed());
			Card ace2 = c2[1];
			ace2.prev = blank;
			ace2.next = blank;
			blank.next = ace2;
			assertFalse(self.wellFormed());
		}

		public void testI() {
			Card ace = c[1];
			self.dummy = blank;
			blank.next = ace;
			// blank.prev = ace;
			ace.prev = blank;
			ace.next = blank;
			assertFalse(self.wellFormed());
			Card ace2 = c2[1];
			ace2.prev = blank;
			ace2.next = blank;
			blank.prev = ace2;
			assertFalse(self.wellFormed());
		}

		public void testJ() {
			Card ace = c[1];
			self.dummy = blank;
			blank.next = ace;
			blank.prev = ace;
			// ace.prev = blank;
			ace.next = blank;
			assertFalse(self.wellFormed());
			blank2.prev = ace;
			blank2.next = ace;
			ace.prev = blank2;
			assertFalse(self.wellFormed());
		}

		public void testK() {
			Card ace = c[1];
			self.dummy = blank;
			blank.next = ace;
			blank.prev = ace;
			ace.prev = blank;
			// ace.next = blank;
			assertFalse(self.wellFormed());
			blank2.prev = ace;
			blank2.next = ace;
			ace.next = blank2;
			assertFalse(self.wellFormed());
		}

		public void testL() {
			Card ace = c[1];
			self.dummy = blank;
			blank.next = ace;
			blank.prev = ace;
			ace.prev = blank;
			ace.next = ace;
			assertFalse(self.wellFormed());
		}

		// the remainder of the tests create a list of 7 cards
		// and then experiment with single errors.
		
		public void testM() {
			self.dummy = blank;
			for (int i=1; i < c.length; ++i) {
				c[i].prev = c[i-1];
				c2[i].prev = c[i-1];
				Card myNext = (i == c.length-1) ? blank : c[i+1];
				c[i].next = myNext;
				c2[i].next = myNext;
			}
			c[1].prev = blank;
			c2[1].prev = blank2;
			blank2.next = blank.next = c[1];
			blank2.prev = blank.prev = c[c.length-1];
			Group.reportErrors = true;
			assertTrue(self.wellFormed());
			Group.reportErrors = false;
		}

		public void testN() {
			testM();
			c[3].prev = c2[2];
			assertFalse(self.wellFormed());
		}
		
		public void testO() {
			testM();
			c[4].next = null;
			assertFalse(self.wellFormed());
		}
		
		public void testP() {
			testM();
			c[5].next = c[3];
			assertFalse(self.wellFormed());
		}
		
		public void testQ() {
			testM();
			c[6].next = blank;
			assertFalse(self.wellFormed());
		}
		
		public void testR() {
			testM();
			c[7].next = c[1];
			assertFalse(self.wellFormed());
		}
		
		public void testS() {
			testM();
			c[7].next = blank2;
			assertFalse(self.wellFormed());
		}
		
		public void testT() {
			testM();
			c[6].prev = blank;
			assertFalse(self.wellFormed());
		}
		
		public void testU() {
			testM();
			c[7].prev = null;
			assertFalse(self.wellFormed());
		}
		
		public void testV() {
			testM();
			c[5].prev = c[2];
			assertFalse(self.wellFormed());
		}
	}


	/** Create and return a fresh pack of cards.
	 * A "static" method is a class method.  It is invoked using
	 * the class, not an instance.
	 * @return a fresh pack of 52 cards
	 */
	public static Group newDeck() {
		Group g = new Group();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r,s);
				g.add(c);
			}
		}
		return g;
	}
}
