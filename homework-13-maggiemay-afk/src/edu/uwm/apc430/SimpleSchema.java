package edu.uwm.apc430;

import java.util.AbstractList;

/**
 * A schema for a {@link SimpleDatabase}.
 * It is "simple" in that there is no way to indicate type (assumed String)
 * or column size.  It merely specifies the number of columns
 * and records a descriptive label for each column.
 */
public class SimpleSchema extends AbstractList<String> {
	private final String[] names;
	
	public SimpleSchema(String allNames) {
		names = allNames.split(SimpleDatabase.SEPARATOR+"");
	}
	
	public SimpleSchema(String... names) {
		this.names = names.clone();
		for (String s : names) {
			if (s.indexOf(SimpleDatabase.SEPARATOR) >= 0) {
				throw new IllegalArgumentException("cannot include separator in field name: " + s);
			}
		}
	}
	
	@Override
	public int size() {
		return names.length;
	}

	@Override
	public String get(int i) {
		return names[i];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String n : names) {
			if (sb.length() > 0) sb.append(SimpleDatabase.SEPARATOR);
			sb.append(n);
		}
		return sb.toString();
	}
}
