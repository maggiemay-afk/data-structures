package edu.uwm.apc430;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.uwm.cs.util.Element;
import edu.uwm.cs.util.XMLParseException;
import edu.uwm.cs.util.XMLReader;

/**
 * @author Maggie Herms
 * 
 * A program to spell check a web page given by a URL.
 * It has two static methods {@link #spellCheck(Object, Set, Set)}
 * and {@link #main(String[])}.
 * <p> The first operates on XML document trees, and puts any misspelled words
 * in the second set (he first set being the dictionary).  The two set parameters should be declared as a
 * <code>Set&lt;String&gt;</code>. </p> 
 * <p> The main method is passed
 * an array of URL strings.  It first reads in the dictionary from the <code>lib</code> folder.
 * For each string in the array, it opens the URL, reads the XML and calls the first method.
 * If it is passed no arguments, then it asks the user for a URL to check.
 * At the end, it prints all the misspelled words.  if there are none, it prints a message to that effect.
 * </p>
 */
public class WebSpellCheck {
	// Portfolio assignment: You write the entire class.
	// Hint: First add stubs to fix compiler errors.
	// Make sure not to use "raw types"; e.g., use "Set<String>" rather than "Set".
	
	
	/**
	 * Checks words in the parameter object against the dictionary set to see if they are misspelled
	 * Misspelled words from the object are put into a separate set
	 * @param obj, object to spell check
	 * @param dictionary, set of correctly spelled words
	 * @param misspelled, set of incorrectly spelled words
	 */
	public static void spellCheck(Object obj, Set<String> dictionary, Set<String> misspelled) {
		
		if (obj instanceof String) {
			String newWords = ((String) obj).replaceAll("[^a-zA-Z\\s']", " ");
			String newestWords = newWords.replaceAll("[\\t\\r\\n]", " ");
			String[] words = newestWords.split(" ");
			
			for (String word : words) {
				if (word == "") continue;
				
				if (word.matches("[A-Z]+")) {
					
					if (!dictionary.contains(word)) {
						String capital = word.substring(0, 1) + word.substring(1).toLowerCase();
						if (!dictionary.contains(capital) && !misspelled.contains(capital)) {
							misspelled.add(word);
						}	
					}
					
				} else {
					if (!dictionary.contains(word)) {
						misspelled.add(word);
					}
				}
			}
			
		} else if (obj instanceof Element) {
			
			String elemName = ((Element)obj).getName();
			if (elemName.equals("script") || elemName.equals("style")) {
				return;
			}
			
			for (Object x : ((Element)obj).contentList()) {
				spellCheck(x, dictionary, misspelled);
			}
		}
	}
	
	
	/**
	 * Creates a URL object with the provided String and gets the input stream from the URL
	 * to create an XMLReader. Uses spellCheck to find misspelled words in the XMLReader.
	 * Prints the list of misspelled words
	 * 
	 * @param str, String representation of a URL
	 * @param dictionary, set of correctly spelled words
	 * @param misspelled, set of incorrectly spelled words
	 */
	private static void checkXML(String str, Set<String> dictionary, Set<String> misspelled) {
		
		try {
			
			URL url = new URL(str);
			InputStream stream = url.openStream();
			Reader read = new InputStreamReader(stream);
			XMLReader xml = new XMLReader(read);
			
			xml.addCDATA("script");
			xml.addCDATA("style");
			Object element = xml.next();
			
			spellCheck(element, dictionary, misspelled);
			
			if (!misspelled.isEmpty()) {
				System.out.println(misspelled);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParseException e) {
			e.printStackTrace();
		} 
		
	}

	
	/**
	 * Takes an array of URL strings and spell checks them against a dictionary 
	 * @param urlStrings, array of different URLs
	 */
	public static void main(String[] urlStrings) {
		
		Set<String> misspelled = new TreeSet<String>();
		Set<String> dictionary = new TreeSet<String>();
		BufferedReader br = null;
		Scanner scan = null;
		
		try {
			br = new BufferedReader(new FileReader("." + File.separatorChar + "lib" + File.separatorChar + "dictionary.txt"));
			scan = new Scanner(System.in);
			
			String currentLine = br.readLine();
			while(currentLine != null) {
				dictionary.add(currentLine);
				currentLine = br.readLine();
			}

			if (urlStrings == null) {
				System.out.println("Please provide a URL");
				urlStrings = new String[1];
				urlStrings[0] = scan.next();
				
			} else if (urlStrings.length == 0) {
				System.out.println("Please provide a URL");
				urlStrings[0] = scan.next();
			} 
			
			for (int i=0; i < urlStrings.length; i++) {
				checkXML(urlStrings[i], dictionary, misspelled);
			}	
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
			
		} finally {
			try {
				br.close();
				scan.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
