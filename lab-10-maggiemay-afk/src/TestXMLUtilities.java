import java.util.Map;
import java.util.TreeMap;

import edu.uwm.apc430.XMLUtilities;
import edu.uwm.cs.util.Element;
import junit.framework.TestCase;


public class TestXMLUtilities extends TestCase {

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

    
    /// tests of hasScript:
    
    public void testH0() {
    	assertFalse(XMLUtilities.hasScript(null));
    	assertFalse(XMLUtilities.hasScript("Text"));
    }
    
    public void testH1() {
    	Element e1 = e("foo",a(),"Test",e("bar"));
    	assertFalse(XMLUtilities.hasScript(e1));
    }
    
    public void testH2() {
    	Element e1 = e("script",a("lang","javascript"),";;");
    	assertTrue(XMLUtilities.hasScript(e1));
    }
    
    public void testH3() {
    	Element e1 = e("style",a("lang","CSS"),"color=blue;");
    	assertFalse(XMLUtilities.hasScript(e1));
    }
    
    public void testH4() {
    	Element e1 = e("foo",a(),"Test",e("script"));
    	assertTrue(XMLUtilities.hasScript(e1));
    }
    
    public void testH5() {
    	Element e1 = e("foo",a(),e("bar"),e("baz",a(),e("quux")),e("script"),e("quod"));
    	assertTrue(XMLUtilities.hasScript(e1));
    }
    
    public void testH6() {
    	Element e1 = e("script",a("lang","java"),"if (System.vurrentTimeMillis() == 42) System.out.println(\"Hello, world!\");");
    	Element e2 = e("p",a(),"This is a ",e("em",a(),"non","script")," sentence.");
    	Element e3 = e("p",a(),"This is not a ",e("em",a(),"script")," sentence");
    	Element e4 = e("body",a(),e2,e3);
    	Element e5 = e("html",a(),e("head",a(),e1),e4);
    	assertFalse(XMLUtilities.hasScript(e4));
    	assertTrue(XMLUtilities.hasScript(e5));
    }
    
    
    /// test of numText
    // The number of TEXT nodes found in the whole tree
    // outside of "script" elements
    
    public void testN0() {
    	assertEquals(0, XMLUtilities.numText(null));
    }
    
    public void testN1() {
    	assertEquals(1, XMLUtilities.numText("Something"));
    }
    
    public void testN2() {
    	Element e1 = e("foo",a("font","34"),e("bar"),e("baz"));
    	assertEquals(0,XMLUtilities.numText(e1));
    }
    
    public void testN3() {
    	Element e1 = e("foo",a("font","34"),e("bar"),"1 2 3",e("baz"));
    	assertEquals(1,XMLUtilities.numText(e1));
    }
    
    public void testN4() {
       	Element e1 = e("script",a("lang","javascript"),"foo(42);");
    	assertEquals(0,XMLUtilities.numText(e1));
    }
    
    public void testN5() {
    	Element e1 = e("script",a("lang","java"),"if (System.vurrentTimeMillis() == 42) System.out.println(\"Hello, world!\");");
    	Element e2 = e("p",a(),"This is a ",e("em",a(),"non","script")," sentence.");
    	Element e3 = e("p",a(),"This is not a ",e("em",a(),"script")," sentence");
    	Element e4 = e("body",a(),e2,e3);
    	Element e5 = e("html",a(),e("head",a(),e1),e4,"End");
    	assertEquals(0,XMLUtilities.numText(e1));
    	assertEquals(4,XMLUtilities.numText(e2));
    	assertEquals(3,XMLUtilities.numText(e3));
    	assertEquals(7,XMLUtilities.numText(e4));
    	assertEquals(8,XMLUtilities.numText(e5));
    }
}
