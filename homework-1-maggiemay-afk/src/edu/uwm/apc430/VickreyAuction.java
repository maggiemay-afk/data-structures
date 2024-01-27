package edu.uwm.apc430;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A class to implement an auction using sealed secret bids in which
 * the winner (highest bidder) pays the <i>second</i> highest bid.
 * @see https://en.wikipedia.org/wiki/Vickrey_auction
 */
public class VickreyAuction {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			try (PrintWriter pw = new PrintWriter(System.out, true)) {
				run(input,pw);
			}
		}
	}
	
	/**
	 * Run an auction reading bids from the input and writing messages to the output.
	 * @param input source of bids
	 * @param output place to report results.
	 */
	public static void run(Scanner input, PrintWriter output) {
		// 1. read bids
		// 2. check that we have enough bids
		// 3. figure out the winner and print the price they pay
		
		Bid[] results = Bid.readBids(input, output);
		
		Arrays.sort(results); // use compareTo in Bid class
		
		if(results.length >= 2) { 
			output.println("Winner: " + results[0].getBidder());
			output.println("Price: " + results[1].getPrice());			
		} else if (results.length == 0) {
			output.println("No auctions recorded");
		} else { //if there's only 1 auction
			output.println("Not enough auctions recorded");				
		}
		
	}
}
