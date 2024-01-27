package edu.uwm.apc430;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class DatabaseFrame extends JFrame {

	/**
	 * Keep Eclipse happy.
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private SimpleDatabase base;
	private RowDialog dialog;
	
	public DatabaseFrame(File source) {
		super(source.getName());
		file = source;
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				doQuit();
			}
		});
		
		try {
			Reader r = new FileReader(file);
			final BufferedReader br = new BufferedReader(r);
			base = SimpleDatabase.read(br);
			br.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Read error", JOptionPane.ERROR_MESSAGE);
			base = new SimpleDatabase(new SimpleSchema("First:Last"));
		}
		
		final JTable table = new JTable(base);
		JScrollPane sp = new JScrollPane(table);
		getContentPane().add(sp);
		
		dialog = new RowDialog(this, base);
		dialog.setSize(300,500);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() > 1) {
					doEdit(table.convertRowIndexToModel(table.rowAtPoint(arg0.getPoint())));
				}
			}
		});
		
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ev) {
				doSort(table.convertColumnIndexToModel(table.columnAtPoint(ev.getPoint())),
						ev.getClickCount());
			}
		});
	}
	
	private void doEdit(int row) {
		if (row < 0) return;
		dialog.openOnRow(row);
	}
	
	private void doSort(int column, int clicks) {
		if (column < 0) return;
		base.sort(column, clicks == 1);
	}
	
	private void doQuit() {
		switch (JOptionPane.showConfirmDialog(this, "Save before quitting?", "Confirm Quit", JOptionPane.YES_NO_CANCEL_OPTION)) {
		default:
		case JOptionPane.CANCEL_OPTION:
			return;
		case JOptionPane.YES_OPTION:
			try {
				Writer w = new FileWriter(file);
				base.write(w);
				w.close();
			} catch(IOException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Write Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// fall through
		case JOptionPane.NO_OPTION:
			System.exit(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = "tmp.txt";
		if (args.length > 0) filename = args[0];
		final File file = new File(filename);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame f = new DatabaseFrame(file);
				f.setSize(500,300);
				f.setVisible(true);
			}
		});
	}

}
