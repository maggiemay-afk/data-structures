package edu.uwm.apc430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SimpleDatabase extends AbstractTableModel {
	/**
	 * @author Maggie Herms
	 * Keep Eclipse happy.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The separator character ':' (colon) */
	public static final char SEPARATOR = ':';
	private static final String SEPSTRING = ""+SEPARATOR;

	private final SimpleSchema schema;
	private final List<String[]> contents = new ArrayList<String[]>();
	
	private boolean report(String error) {
		System.out.println("Invariant error: " + error);
		return false;
	}
	
	private boolean wellFormed() {
		if (schema == null) return report("schema is null");
		if (contents == null) return report("contents is null");
		for (String[] row : contents) {
			if (row == null) return report("row is null");
			if (row.length != schema.size()) return report("row is wrong size: " + Arrays.toString(row));
			for (String elem : row) {
				if (elem.indexOf(SEPARATOR) >= 0) return report("element contains separator");
				if (elem.indexOf('\n') >= 0) return report("element contains newline");
			}
		}
		return true;
	}
	
	// Add constructor (which takes a schema)
	/**
	 * Create an instance of SimpleSchema for this SimpleDatabase
	 * @param schema, SimpleSchema, cannot be null
	 */
	public SimpleDatabase(SimpleSchema schema) {
		if (schema == null) throw new NullPointerException("schema cannot be null");
		this.schema = schema;
	}
	
	
	/**
	 * Add a row to the data base.  The row must fit the schema
	 * (have the correct number of columns).
	 * @param row an array of strings, none of which can be null or include
	 * an instance of the {@link #SEPARATOR} or newline character.
	 * @throws IllegalArgumentException 
	 */
	public void addRow(String[] row) throws IllegalArgumentException {
		assert wellFormed() : "invariant broken at start of addRow";
		// check the parameter extensively, then add to contents.
		if (row.length != getColumnCount()) throw new IllegalArgumentException("row doesn't match number of columns");
		
		for (int i=0; i < row.length; i++) {
			if (row[i] == null || row[i].contains(SEPSTRING) || row[i].contains("\n")) {
				throw new IllegalArgumentException("Illegal value for row");
			}
		}
		
		contents.add(row);
		
		super.fireTableRowsInserted(contents.size()-1, contents.size()-1);
		assert wellFormed() : "invariant broken at end of addRow";
	}
	
	/**
	 * Add a row by separating the argument at the colons.
	 * @param row column values separated by {@link #SEPARATOR} ; cannot be null or include newline
	 * The number of columns must match the schema.
	 */
	public void addRow(String row) {
		addRow(row.split(SEPSTRING));
	}

	/**
	 * Remove a row from the database that matches the parameter exactly;
	 * the field values must be exactly equal (but not identical objects).
	 * This method never removes more than one row.
	 * @param row array of column values, must not be null
	 * @return true if a matching row was found and removed, false otherwise
	 */
	public boolean removeRow(String[] row) {
		assert wellFormed() : "invariant broken at start of removeRow";
		// check the parameter.
		if (row == null) return false;
		
		// Then see if this parameter is in the contents using Arrays.equals(_,_) to compare rows.
		// If a match is found, remove it, and then "super.fireTableRowsDeleted(i, i);"
		// before checking the invariant and returning true. If it isn't found, return false
		for (int i=0; i < contents.size(); i++) {
			String [] line = contents.get(i);
			
			if (Arrays.equals(line, row)) {
				contents.remove(i);
				super.fireTableRowsDeleted(i, i);
				assert wellFormed() : "invariant broken at end of removeRow";
				return true;
			}
		}
		
		assert wellFormed() : "invariant broken at end of removeRow";
		return false;
		
	}

	/**
	 * Try to remove a row that matches the argument
	 * @param row, row to remove, must not be null.
	 * Should consist of strings separated by {@link #SEPARATOR}. 
	 * Otherwise false will be returned.
	 * @return true if a matching row was found and removed, false otherwise
	 */
	public boolean removeRow(String row) {
		if (row == null) return false;
		return removeRow(row.split(SEPSTRING));
	}

	/**
	 * Sort the table using the given column.
	 * @param integer, column index to sort
	 * @param boolean, whether or not to sort in ascending order
	 */
	public void sort(final int column, final boolean ascending) {
		assert wellFormed() : "invariant broken at start of sort";
		// Check the parameter(s), then call Collections.sort with an appropriate row comparator
		RowComparator rc = new RowComparator(column, ascending);
		Collections.sort(contents, rc);
		
		super.fireTableRowsUpdated(0, contents.size()-1);
		assert wellFormed() : "invariant broken at end of sort";
	}

	/**
	 * Read a database from a reader. The entirety of the reader is consumed.
	 * @param r reader to use, must not be null
	 * @return database using schema specified on first line read from reader
	 * @throws IOException if reader fails for some reason
	 */
	public static SimpleDatabase read(BufferedReader r) throws IOException {
		if (r == null) throw new NullPointerException("BufferedReader cannot be null");
		
		SimpleSchema schema = new SimpleSchema(r.readLine());
		SimpleDatabase result = new SimpleDatabase(schema);
		
		//take each line from the file and add to result
		try {
			String row = r.readLine();
			
			while (row != null) {
				if (row.split(SEPSTRING).length != result.getColumnCount()) {
					throw new IOException("illegal Column count");
				}
				
 				result.addRow(row);
				row = r.readLine();
			}
		
		} catch (IOException ioe) {
			throw new IOException("IOE in Read");
		} 
		
		assert result.wellFormed() : "invariant broken at end of read";
		return result;
	}
	
	/**
	 * Write all rows of the data base to the given writer. No sentinel is written.
	 * @param w writer to send strings to, must not be null
	 * @throws IOException if writer fails for some reason
	 */
	public void write(Writer w) throws IOException {
		// write the schema and each row after putting SEPARATOR between elements
		if (w == null) throw new NullPointerException("Writer cannot be null");
		
		try {
			w.write(schema.toString() + "\n");
			
			for (int i=0; i < contents.size(); i++) {
				String[] row = contents.get(i);
				
				for (int k=0; k<row.length; k++) {
					
					if (k == schema.size()-1) {
						w.write(row[k]);
					} else {
						w.write(row[k] + SEPARATOR);
					}
				}
				w.write("\n");
			}
			
		} catch(IOException ioe) {
			throw new IOException("IOE in write");
		}
	}
	
	// and add simple accessors: getSchema and getRow
	// plus all the required methods form the abstract super class
	// plus getColumnName (to use the schema to get name for the column).
	
	/**
	 * Returns the schema for this SimpleDatabase 
	 * @return SimpleSchema, this schema
	 */
	public SimpleSchema getSchema() {
		return this.schema;
	}
	
	
	/**
	 * Returns a copy of the row and it's data at the parameter index
	 * @param integer, row index
	 * @return array, copy of row at given index
	 */
	public String[] getRow(int row) {
		return Arrays.copyOf(contents.get(row), getColumnCount());
	}

	
	/**
	 * Returns the number of rows in this SimpleDatabase
	 * @Override
	 * @return integer, number of rows
	 */
	public int getRowCount() {
		return contents.size();
	}

	
	/**
	 * Returns the number of columns for this schema
	 * @Override
	 * @return integer, number of columns
	 */
	public int getColumnCount() {
		return schema.size();
	}
	
	
	/**
	 * Returns the Name of the column at the parameter index
	 * @Override
	 * @return String, name of the column at given index
	 */
	public String getColumnName(int column) {
		return schema.get(column);
	}

	
	/**
	 * Returns the String data stored at the given row and column index
	 * @Override
	 * @return Object, data stored at the given row and column index
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		String[] row = contents.get(rowIndex);
		return row[columnIndex];
		
	}
	
}


