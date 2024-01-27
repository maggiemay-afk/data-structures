package edu.uwm.apc430;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RowPanel extends JPanel {
	/**
	 * Keep Eclipse happy.
	 */
	private static final long serialVersionUID = 1L;
	private final SimpleSchema schema;
	private final JTextField[] contextFields;
	
	public RowPanel(SimpleSchema sch) {
		this.schema = sch;
		contextFields = new JTextField[sch.size()];
		this.setLayout(new GridLayout(0,2));
		for (int i=0; i < sch.size(); ++i) {
			add(new JLabel(sch.get(i)));
			contextFields[i] = new JTextField(sch.get(i).length());
			add(contextFields[i]);
		}
	}
	
	public void setRow(String[] init) {
		final int size = schema.size();
		if (init.length != size) {
			throw new IllegalArgumentException("wrong size: " + init);
		}
		for (int i=0; i < size; ++i) {
			contextFields[i].setText(init[i]);
		}
	}
	
	public String[] getRow() {
		final int size = schema.size();
		String[] result = new String[size];
		for (int i=0; i < size; ++i) {
			String text = contextFields[i].getText();
			text = text.replace(':', '.').replace('\n', '/');
			result[i] = text;
		}
		return result;
	}
}
