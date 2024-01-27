package edu.uwm.apc430;

import edu.uwm.cs.util.Element;

/**
 * A collection of methods useful for
 * operating on XML processed into
 * elements.
 */
public class XMLUtilities {

	/** Return true if there is a "script" element somewhere in the
	 * document tree passed
	 * @param d document tree, may be null
	 * @return whether the document tree contains a "script" element.
	 */
	public static boolean hasScript(Object d) {
		// TODO: complete this method using recursion.
		
		if (d == null) {
			return false;
			
		} if (d instanceof String)  {
			 
			return false;
			
		} else if (d instanceof Element) {
			Element temp = (Element)d;
			if (temp.getName().equals("script")) {
				return true;
			}
			
			for (Object x : ((Element)d).contentList()) {
				boolean result = hasScript(x);
				if(result == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Return the number of textual elements in the document tree.
	 * @param d document tree, may be null
	 * @return the total number of textual elements (Strings) in the document.
	 */
	public static int numText(Object d) {
		int sum = 0;
		
		if (d instanceof String) {
			sum++;
			
		} else if (d instanceof Element) {
			Element temp = (Element)d;
			if (temp.getName().equals("script")) {
				return 0;
			}
			
			for (Object x : ((Element)d).contentList()) {
				
				sum += numText(x);
			}
		}
		
		return sum;
	}
	
	
}
