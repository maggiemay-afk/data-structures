/*
 * Name: Maggie Herms
 */
package edu.uwm.apc430;

import java.util.Comparator;

public class SmartWarPlayer extends PlayWar{
	
	public SmartWarPlayer() {
		super();
	}
	
	/**
	 * Play the highest card in the given hand
	 * @param disputed, number of disputed cards on table
	 * @return Card, the highest card in the hand
	 * @Override
	 */
	public Card play(Comparator<Card> cmp, int disputed) {
		
		Card first = hand.getFirst();
		Card highest = first;
		
		while (first != null && highest !=null) {
			if (cmp.compare(first, highest) > 0) {
				highest = first;
			}
			first = first.getNext();
		}
		
		if (highest == null) {
			return null; 
		}
		
		hand.remove(highest);
		return highest;
	}
	
}
