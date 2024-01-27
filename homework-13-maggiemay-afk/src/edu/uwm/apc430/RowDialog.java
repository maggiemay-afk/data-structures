package edu.uwm.apc430;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RowDialog extends JDialog {
	/**
	 * Keep Eclipse happy
	 */
	private static final long serialVersionUID = 1L;
	
	private SimpleDatabase database;
	private RowPanel panel;
	
	public RowDialog(JFrame f, SimpleDatabase db) {
		super(f,"Edit Row");
		database = db;
		panel = new RowPanel(db.getSchema());
		JPanel buttons = new JPanel();
		JButton addButton = new JButton("Add");
		JButton removeButton = new JButton("Remove");
		JButton cancelButton = new JButton("Cancel");
		buttons.add(addButton);
		buttons.add(removeButton);
		buttons.add(cancelButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doAdd();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doRemove();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doCancel();
			}
		});
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel,BorderLayout.CENTER);
		getContentPane().add(buttons,BorderLayout.SOUTH);
	}
	
	public void openOnRow(int row) {
		panel.setRow(database.getRow(row));
		setVisible(true);
	}
	
	private void doAdd() {
		database.addRow(panel.getRow());
	}
	
	private void doRemove() {
		if (!database.removeRow(panel.getRow())) {
			JOptionPane.showMessageDialog(this, "No such row to remove", "Remove Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void doCancel() {
		this.setVisible(false);
	}
}
