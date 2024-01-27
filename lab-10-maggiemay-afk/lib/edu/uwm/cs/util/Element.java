package edu.uwm.cs.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parsed representation of an XML element.
 */
public class Element {

	private final String _name;
	private Map<String,String> _attrs;
	private List<Object> _contents;
	
	/**
	 * Create an element with the given name
	 * @param name name of element, must not be null
	 */
	public Element(String name) {
		if (name == null) throw new IllegalArgumentException("element name cannot be null");
		_name = name;
	}
	
	/**
	 * Create an element with the given name and contents.
	 * @param name name of element, must not be null
	 * @param contents strings and elements to be nested.
	 * @throws IllegalArgumentException if something other than a string or element 
	 * is used in the contents.
	 */
	public Element(String name, Object... contents) {
		this(name);
		_contents = new ArrayList<Object>();
		for (Object o : contents) {
			if (o instanceof Element || o instanceof String) {
				addContent(o);
			} else {
				throw new IllegalArgumentException("Element contents can only be elements or strings");
			}
		}
	}
	
	/** 
	 * Create an element with given names, attributes and contents.
	 * @param name name of element, must not be null
	 * @param attrs attribute name value pairs, none of which can be null
	 * @param contents strings and elements to be nested.
	 * @throws IllegalArgumentException if something other than a string or element
	 * is used in the contents or if an null atribute name or value occurs  
	 */
	public Element(String name, Map<String,String> attrs, Object... contents) {
		this(name,contents);
		for (Map.Entry<String,String> e : attrs.entrySet()) {
			if (e.getValue() == null) throw new IllegalArgumentException("no null attribute values permitted");
			setAttr(e.getKey(),e.getValue());
		}
	}
	
	/** Return name of element.
	 * @return name of element.
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * Return the binding of this attribute, or null if no such attribute
	 * @param aname name of attribute
	 * @return binding of attribute or null if no such attribute
	 */
	public String getAttr(String aname) {
		if (_attrs == null) return null;
		return _attrs.get(aname);
	}
	
	/**
	 * Set or modify the binding of an attribute.
	 * @param aname attribute name, must not be null
	 * @param avalue attribute value, if null then the binding is removed
	 * @return the old value (if any) of the binding
	 */
	public String setAttr(String aname, String avalue) {
		if (aname == null) throw new IllegalArgumentException("attribute name must not be null");
		if (_attrs == null) _attrs = new HashMap<String,String>();
		_savedHashCode = 0;
		if (avalue == null) return _attrs.remove(aname);
		return _attrs.put(aname, avalue);
	}
	
	/**
	 * Add text or subelement to this element.
	 * @param c either a string or an element, must not be null
	 */
	public void addContent(Object c) {
		if (!(c instanceof Element) && !(c instanceof String)) {
			throw new IllegalArgumentException("can only add text or elements");
		}
		if (_contents == null) _contents = new ArrayList<Object>();
		_contents.add(c);
		_savedHashCode = 0;
	}
	
	/**
	 * Return an unmodifiable map of attribute&rarr;value pairs.
	 * The result is never null. 
	 * @return map of attribute names to values
	 */
	public Map<String,String> attrMap() {
		if (_attrs == null) return Collections.emptyMap();
		return Collections.unmodifiableMap(_attrs);
	}
	
	/**
	 * Return a list of the sub-elements.
	 * The result is never null, and contains only strings and {@link Element} objects.
	 * @return list of contents of this element
	 */
	public List<Object> contentList() {
		if (_contents == null) return Collections.emptyList();
		return Collections.unmodifiableList(_contents);
	}
	
	@Override 
	public String toString() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		print(pw,0);
		pw.flush();
		return sw.toString();
	}
	
	/**
	 * Print the element in indented fashion to the print writer.
	 * @param p print writer to print to
	 * @param indent current indentation for the element
	 */
	public void print(PrintWriter p, int indent) {
		for (int i=0; i < indent; ++i) {
			p.print("  ");
		}
		p.print(_name);
		if (_attrs != null) {
			for (Map.Entry<String,String> e : _attrs.entrySet()) {
				p.print(" ");
				p.print(e.getKey());
				p.print("=");
				p.print(e.getValue());
			}
		}
		p.println();
		if (_contents != null) {
			for (Object x : _contents) {
				if (x instanceof Element) {
					((Element)x).print(p, indent+1);
				} else {
					for (int i=0; i <= indent; ++i) {
						p.print("  ");
					}
					p.println(x);
				}
			}
		}
	}
	
	private int _savedHashCode = 0;
	
	@Override
	public int hashCode() {
		if (_savedHashCode != 0) return _savedHashCode;
		_savedHashCode = _name.hashCode() + (_attrs == null ? 0 : _attrs.hashCode()) +
			(_contents == null ? 0 : _contents.size() * 83);
		return _savedHashCode;
	}
	
	@Override
	public boolean equals(Object x) {
		if (!(x instanceof Element)) return false;
		Element e = (Element)x;
		if (!_name.equals(e._name)) return false;
		if (_attrs == null) {
			if (e._attrs != null && !e._attrs.isEmpty()) return false;
		} else {
			if (e._attrs == null) {
				if (!_attrs.isEmpty()) return false;
			} else {
				if (!_attrs.equals(e._attrs)) return false;
			}
		}
		if (_contents == null) {
			if (e._contents != null && !e._contents.isEmpty()) return false;
		} else {
			if (e._contents == null) {
				if (!_contents.isEmpty()) return false;
			} else {
				if (!_contents.equals(e._contents)) return false;
			}
		}
		return true;
	}
}
