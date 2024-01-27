package edu.uwm.apc430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.uwm.cs.util.HTMLWordIterator;

/**
 * Class will tally up the number of times a word appears on a given web page
 * It will then print the most common words and the number of times those 
 * words appeared on the web page. 
 * 
 * @author Maggie Herms
 */
public class CommonWords implements Iterable<Entry<String,Integer>> {

	public static final Comparator<Entry<String,Integer>> entryComparator = new Comparator<Entry<String,Integer>>() {
		
		/**
		 * Compare two entries, sorting them in decreasing order based on the number
		 * of times the word appears in the web page
		 * Words with duplicate appearances are then sorted alphabetically
		 * @return integer
		 */
		public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2) {
			// complete this method
			if (e1.getValue() == e2.getValue()) {
				return (e1.getKey().compareTo(e2.getKey()));
			} else {
				return (e2.getValue().compareTo(e1.getValue()));
			}
		}
	};
	
	// Declare fields:
	// (1) a map from strings to count (integer), use hash map implement
	// (2) a set of entries from strings to counts, use tree set implementation configured with the entry comparator.
	// (3) a boolean to remember whether the instance can be added to
	HashMap<String, Integer> m;
	Set<Entry<String, Integer>> ts;
	private boolean requested;

	/**
	 * Initialize a new common words instance.
	 * The collection is ready to receive new words.
	 */
	public CommonWords() {
		//initialize fields here or in their declaration
		m = new HashMap<String, Integer>();
		ts = new TreeSet<>(entryComparator);
	}
	
	/**
	 * Add a word to this collection (HashMap)
	 * @param w word to add, must not be null
	 * @throws IllegalStateException if the iterator has already been requested
	 * @throws NullPointerException if the word is null
	 */
	public void add(String w) throws NullPointerException, IllegalStateException {
		//Implement this method
		if (requested == true) throw new IllegalStateException("Iterator has already been requested");
		if (w == null) throw new NullPointerException("Word cannot be null");
		
		if (m.containsKey(w)) {
			int val = m.get(w);
			m.put(w, val+1);
		} else {
			m.put(w, 1);
		}
		
	}
	
	/**
	 * Add the key-value pairs of HashMap to a TreeSet in descending order
	 * @return iterator
	 * @Override
	 */
	public Iterator<Entry<String,Integer>> iterator() {
		//implement this method
		ts.addAll(m.entrySet());
		requested = true;
		return ts.iterator();
		
	}
	
	/**
	 * Read in a web page from a URL string
	 * prints the top, highest occurring words and the number of appearances
	 * @param top, top appearing words
	 * @param urlString, web page 
	 */
	private static void doTask(int top, String urlString) {
		CommonWords self = new CommonWords();
		try {
			URL url = new URL(urlString);
			InputStream is = url.openStream();
			Reader r = new BufferedReader(new InputStreamReader(is,"UTF8"));
			Iterator<String> words = new HTMLWordIterator(r);
			while (words.hasNext()) {
				self.add(words.next());
			}
		} catch (MalformedURLException e) {
			System.err.println("Malformed URL: " + urlString + ": " + e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.println("Cannot read contents of URL: " + urlString + ": " + e.getLocalizedMessage());
		}
		
		// Print out top words.
		Iterator<Entry<String,Integer>> it = self.iterator();
		int count = 0;
		while (count < top && it.hasNext()) {
			Entry<String, Integer> value = it.next();
			System.out.format(value.getValue() + ": " + value.getKey() + "\n");
			count++;
		}
		
	}
	
	public static final int DEFAULT_TOP = 25;
	private static final String TOP_FLAG = "--top=";

	public static void main(String[] args) {
		int top = DEFAULT_TOP;
		int done = 0;
		for (String arg : args) {
			if (arg.startsWith(TOP_FLAG)) {
				top = Integer.parseInt(arg.substring(TOP_FLAG.length()));
			} else {
				doTask(top,arg);
				++done;
			}
		}
		if (done == 0) {
			System.out.print("URL: ");
			String url;
			try (Scanner sc = new Scanner(System.in)) {
				url = sc.nextLine();
			}
			doTask(top,url);
		}

	}
}
