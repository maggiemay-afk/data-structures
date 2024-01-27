package edu.uwm.apc430;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bid implements Comparable<Bid>{
	
	private String bidder;
	private double price;
	
	
	/**
	 * @param bidderName String, name or email address
	 * @param bidPrice double, bid price
	 */
	public Bid(String bidderName, double bidPrice) {
		this.bidder = bidderName;
		this.price = bidPrice;
		
	}
	
	/**Takes a string as input, splits the string into bid price and bidder name
	 * returns the new instance of Bid class 
	 * @param input String, one bid
	 * @return instance of Bid class
	 * @throws NumberFormatException
	 */
	public static Bid fromString(String input) throws NumberFormatException {

		String toSplit = input.trim();
		int bound = 0;
		
		for (int i=0; i < toSplit.length(); i++) {
			if(toSplit.charAt(i) == ' ' || toSplit.charAt(i) == '\t') { //find middle 'bound' between price and name
				bound = i;
				break;
			}
		}
		
		String bidderName = toSplit.substring(bound + 1, toSplit.length());
		String bidPrice = toSplit.substring(0, bound);
		//will throw number format exception if auction is input incorrectly
		double price = Double.parseDouble(bidPrice.toString()); 
		
		Bid newBidder = new Bid(bidderName.trim(), price); //call bid class constructor
		return newBidder;
		
	}
	
	/**
	 * reads lines from scanner, creates Bid objects, calls fromString
	 * end-of-file marker (Ctrl + Z or Ctrl + D) ends the auction
	 * @param input Scanner object
	 * @param output PrintWriter object
	 * @return array of Bid objects, Bid[]
	 */
	public static Bid[] readBids(Scanner input, PrintWriter output) {
		
		List<Bid> allBids = new ArrayList<>();
		
		while(input.hasNextLine()) {
			try {
				String bid = input.nextLine();
				
				if (bid.equals("")) { //don't allow blank lines
					throw new NumberFormatException();					
				} else {
					Bid newBid = fromString(bid);
					allBids.add(newBid);
				}
				
			} catch(NumberFormatException nfe) {
				//nfe.printStackTrace();
				output.println("Cannot convert input to numeric value");
			}
		}
		
		Bid[] bidArr = new Bid[allBids.size()];
		allBids.toArray(bidArr);
		return bidArr;		
			
	}
	
	
	/** @return double, price of bid
	 */
	public double getPrice() {
		return this.price;
	}
	
	/** @return String, name of bidder
	 */
	public String getBidder() {
		return this.bidder;
	}

	
	/** Compare prices of 2 different bids to sort bids from highest to lowest
	 * @Override
	 */
	public int compareTo(Bid o) {
		
		if (this.getPrice() == o.getPrice()) {
			return 0;
		} else if (this.getPrice() > o.getPrice()) {
			return -1;
		} else {
			return 1;
		}
	}

}
