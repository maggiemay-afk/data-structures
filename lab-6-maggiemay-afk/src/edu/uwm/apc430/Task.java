package edu.uwm.apc430;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task {
	final public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm aa MM/dd/yyyy", Locale.ENGLISH);
	final public static String DELIMITER = ":";
	final public String description;
	final public int importance;
	private Date _dueDate;
	
	public Task(String Description, String dueDate, int Importance) {
		description = Description;
		importance = Importance;
		try {
			_dueDate = DATE_FORMAT.parse(dueDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Date getDueDateAsDate() {
		return _dueDate;
	}
	
	public String getDueDate() {
		return DATE_FORMAT.format(_dueDate);
	}
	
	public String toString() {
		return description + DELIMITER + " Due at " + getDueDate();
	}
	
}
