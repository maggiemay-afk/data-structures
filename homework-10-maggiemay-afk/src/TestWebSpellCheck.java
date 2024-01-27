import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import edu.uwm.apc430.WebSpellCheck;
import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs.util.Element;


public class TestWebSpellCheck extends LockedTestCase {
	
	private void assertDone(Iterator<?> it) {
		if (it.hasNext()) {
			Object x = it.next();
			assertFalse("Iterator should be done, but still had " + x, true);
		}
	}
	
    // XML Syntax Questions
    public void testXMLSyntax(boolean ignored){
            // How would you go about opening/closing
            // an "apple" element with a single tag?
                    Ts(1325493464); // Hint: the contents will be empty
            
            // Say we wanted to add an attribute of ripe with the
            // value 'true', what would we need to add into the tag?
            // NB: Use single quote instead of double-quote for the value,
            //              and only answer with the attribute, not the entire tag.
                    Ts(1816582217);
                    
            // Great! Now, say you wanted to create an apple with
            // no attributes and the text content 'worm' (with no spaces or quotes).
            // What would that look like?
                    Ts(721024958);
    }
    
    public void testXMLSyntaxTrueFalse(boolean ignored){
            // Good! Now for some true/false questions...
            
            // T/F: Text is legal content of an XML element.
                    Tb(236098543);
                            
            // T/F: The element <orange/> might have contents.
                    Tb(2112063273);
                            
            // T/F: <cake> <cake> cream filling </cake> </cake>     ...is valid XML.
                    Tb(1083105664);
                                            
            // T/F: <bread> peanut butter & jelly </bread>     ...is valid XML.
                    Tb(440449791);
                    
            // T/F: An XML document may have multiple root elements.
                    Tb(90068664);
    }
    
    private Set<String> dictionary = new HashSet<>();
    private Set<String> misspelled = new TreeSet<>();
    
    @Override
    protected void setUp() {
    	testXMLSyntax(true);
    	testXMLSyntaxTrueFalse(true);
    	dictionary.add("a");
    	dictionary.add("the");
    	dictionary.add("and");
    	dictionary.add("cat");
    	dictionary.add("dog");
    	dictionary.add("chased");
    	dictionary.add("APC");
    	dictionary.add("is");
    	dictionary.add("it");
    	dictionary.add("A");
    	dictionary.add("The");
    	dictionary.add("Wisconsin");
    	dictionary = Collections.unmodifiableSet(dictionary);
    	misspelled.clear();
    }
    
    private Map<String,String> a(String...attrs) {
    	Map<String,String> result = new TreeMap<>();
    	for (int i=0; i < attrs.length; i += 2) {
    		result.put(attrs[i],attrs[i+1]);
    	}
    	return result;
    }
    
    private Element e(String name, Map<String,String> attrs, Object ...c) {
    	Element e = new Element(name, attrs);
    	for (Object x : c) {
    		e.addContent(x);
    	}
    	return e;
    }
    
    private Element e(String name) {
    	return e(name,a());
    }
    
    public void testA() {
    	WebSpellCheck.spellCheck(null, dictionary, misspelled);
    	assertDone(misspelled.iterator());
    	
    	WebSpellCheck.spellCheck("mispeled words", dictionary, misspelled);
    	Iterator<String> words = misspelled.iterator();
    	assertEquals("mispeled", words.next());
    	assertEquals("words", words.next());
    	assertDone(words);
    }
    
    public void testB() {
    	WebSpellCheck.spellCheck(e("foo"), dictionary, misspelled);
    	assertDone(misspelled.iterator());
    }
    
    public void testC() {
    	WebSpellCheck.spellCheck(e("foo",a("bar","baz")), dictionary, misspelled);
    	assertDone(misspelled.iterator());
    }
    
    public void testD() {
    	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"cat"), dictionary, misspelled);
    	assertDone(misspelled.iterator());
    }
    
    public void testE() {
    	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"The","cat","chased","the","dog"), dictionary, misspelled);
    	assertDone(misspelled.iterator());
    }
    
    public void testF() {
       	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"The cat chased the dog."), dictionary, misspelled);
       	assertDone(misspelled.iterator());
    }
    
    public void testG() {
    	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"The bar chased the foo."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("bar",words.next());
       	assertEquals("foo",words.next());
      	assertDone(words);
    }
    
    public void testH() {
     	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"The bar (a dog) chased the foo (a cat) and the bar (a dog again)."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("again",words.next());
       	assertEquals("bar",words.next());
       	assertEquals("foo",words.next());  	
       	assertDone(words);
    }
    
    public void testI() {
       	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"Cat chased the apc."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("Cat",words.next());
       	assertEquals("apc",words.next());
    	assertDone(words);
    }
    
    public void testJ() {
       	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"APC 430 is fun and hard."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("fun",words.next());
       	assertEquals("hard",words.next());
    	assertDone(words);
    }
    
    public void testK() {
    	WebSpellCheck.spellCheck(e("foo",a("bar","baz"),"A DOG ATE THE APC 430 HOMEWORK."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("ATE",words.next());
       	assertEquals("DOG",words.next());
       	assertEquals("HOMEWORK",words.next());
    	assertDone(words);
    }
    
    public void testL() {
       	WebSpellCheck.spellCheck(e("script",a("bar","baz"),"The wind in the willows is ignored."), dictionary, misspelled);
       	assertDone(misspelled.iterator());
    	
    }
    
    public void testM() {
       	WebSpellCheck.spellCheck(e("style",a("bar","baz"),"The wind in the willows is ignored."), dictionary, misspelled);
       	assertDone(misspelled.iterator());
    }
    
    public void testN() {
       	WebSpellCheck.spellCheck(e("p",a(),"The cat--named Wilbur--chased the dog outside."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("Wilbur",words.next());
       	assertEquals("named",words.next());
       	assertEquals("outside",words.next());
    	assertDone(words);
    }
    
    public void testO() {
       	WebSpellCheck.spellCheck(e("p",a(),"Car chased the DOG; but Dog did not chase the CAR."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("Car",words.next());
       	assertEquals("DOG",words.next());
       	assertEquals("Dog",words.next());
       	assertEquals("but",words.next());
       	assertEquals("chase",words.next());
       	assertEquals("did",words.next());
       	assertEquals("not",words.next());
    	assertDone(words);    	
    }
    
    public void testP() {
    	WebSpellCheck.spellCheck(e("p",a(),"The cat,\r\nthe dog\t and the mouse chased the car."), dictionary, misspelled);
       	Iterator<String> words = misspelled.iterator();
       	assertEquals("car",words.next());
       	assertEquals("mouse",words.next());
    	assertDone(words);    	
    }
    
    public void testQ() {
    	Element e1 = e("h1",a(),"The introduction.");
    	Element e2 = e("p",a("font","blue"),"The cat chased the dog around the room.");
    	Element e3 = e("p",a(),"Then, the dog ate the cat!");
    	Element e0 = e("html",a(),e1,e2,"APC 430: Homework #10 is tricky, isn't it?",e3);
    	WebSpellCheck.spellCheck(e0, dictionary, misspelled);
    	Iterator<String> words = misspelled.iterator();
       	assertEquals("Homework",words.next());
       	assertEquals("Then",words.next());
       	assertEquals("around",words.next());
       	assertEquals("ate",words.next());
       	assertEquals("introduction",words.next());
       	assertEquals("isn't",words.next());
       	assertEquals("room",words.next());
       	assertEquals("tricky",words.next());
    	assertDone(words);
    }
    
    public void testR() {
    	Element e1 = e("b",a(),e("it",a(),"The"),e("br"),e("font",a("size","+1"),"red dog"),"and CAT");
    	Element e2 = e("p",a(),e1,"and then the dog chased the rat.");
    	Element e3 = e("body",a(),e("h1",a(),"A life is fun."),e2,"APC 450",e("address"));
    	Element e4 = e("script",a("language","EMCA-script/8.0"),"if (x < button.pressed) alsert(\"This shouldmn't show.\");");
    	Element e5 = e("html",a(),e("head",a(),e("Title",a(),"DOG is Cat"),e4),e3);
    	WebSpellCheck.spellCheck(e5, dictionary, misspelled);
    	Iterator<String> words = misspelled.iterator();
       	assertEquals("Cat",words.next());
       	assertEquals("DOG",words.next());
       	assertEquals("fun",words.next());
       	assertEquals("life",words.next());
       	assertEquals("rat",words.next());
       	assertEquals("red",words.next());
       	assertEquals("then",words.next());
    	assertDone(words);
    }
    
    public void testS() {
    	Element e1 = e("script", a("language","javascript"),"alert('hello');");
    	Element e2 = e("i",a("script","uncial"),"style");
    	Element e3 = e("text",a(), e1,"script","is","a",e2,"word");
    	WebSpellCheck.spellCheck(e3, dictionary, misspelled);
    	Iterator<String> words = misspelled.iterator();
    	assertEquals("script",words.next());
    	assertEquals("style",words.next());
    	assertEquals("word",words.next());
    	assertDone(words);
    }
}
