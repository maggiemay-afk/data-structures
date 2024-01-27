import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.uwm.apc430.StringArrayBag;

/**
 * The ArrayBagDriver will read a document
 * and for each word that exists in the document
 * will count the occurrences of each word
 * 
 * Note: assume the document is on a single line
 * @author xiong239
 *
 */
public class ArrayBagDriver {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String filename = (args.length == 0) ? "document.txt" : args[0];
		
		//Create an ArrayBag of Strings
		StringArrayBag ab = new StringArrayBag();
		try {
			String[] words;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			words = br.readLine().split(" ");
			
			//Add the words to your bag of Strings
			// Check the StringArrayBag class for useful methods
			ab.addMany(words);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("\n\nContents of Bag:\n\n");
		
		//call the printOccurrences function of your bag
		ab.printOccurrences();

		System.out.println("\n\nContents of Bag using Iterator:\n\n");
		
		//call the printOccurrencesWithIterator function of your bag
		ab.printOccurrencesWithIterator();

	}

}
