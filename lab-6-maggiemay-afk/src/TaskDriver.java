import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JTextPane;

import edu.uwm.apc430.Task;
import edu.uwm.apc430.TaskList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TaskDriver {

	JFrame frmLab;
	private JTextPane txtCurrent;
	private JPanel canvas;
	private TaskList list = new TaskList();
	private Object lock = new Object();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskDriver window = new TaskDriver();
					window.frmLab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaskDriver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		reset();
		
		frmLab = new JFrame();
		frmLab.setTitle("Lab 5");
		frmLab.setBounds(100, 100, 493, 324);
		frmLab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLab.getContentPane().setLayout(null);
		
		JButton btnFoward = new JButton("Foward");
		btnFoward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				synchronized(lock) {
					list.forward();
					listUpdate();
				}
			}
		});
		btnFoward.setBounds(116, 11, 100, 23);
		frmLab.getContentPane().add(btnFoward);
		
		JButton btnBackward = new JButton("Backward");
		btnBackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(lock) {
					list.backward();
					listUpdate();
				}
			}
		});
		btnBackward.setBounds(6, 11, 100, 23);
		frmLab.getContentPane().add(btnBackward);
		
		JPanel currentPanel = new JPanel();
		currentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Task List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		currentPanel.setBounds(6, 45, 463, 235);
		frmLab.getContentPane().add(currentPanel);
		currentPanel.setLayout(null);
		
		canvas = list.makeCanvas();
		canvas.setBounds(6, 84, 445, 140);
		currentPanel.add(canvas);
		canvas.setBackground(Color.WHITE);
		
		JLabel lblCurrentTaskDescription = new JLabel("Current Task:");
		lblCurrentTaskDescription.setBounds(10, 56, 92, 14);
		currentPanel.add(lblCurrentTaskDescription);
		
		txtCurrent = new JTextPane();
		txtCurrent.setBounds(94, 53, 357, 20);
		txtCurrent.setText(list.getCurrent().toString());
		currentPanel.add(txtCurrent);
		txtCurrent.setEditable(false);
		
		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setBounds(10, 22, 46, 14);
		currentPanel.add(lblSortBy);
		
		final JComboBox<String> dropSort = new JComboBox<>();
		dropSort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				synchronized(lock) {
					if (dropSort.getSelectedIndex() == 1) {
						list.sortByImportance();
					} else {
						list.sortByDueDate();
					}
					listUpdate();
				}
			}
		});
		dropSort.setBounds(62, 19, 97, 20);
		currentPanel.add(dropSort);
		dropSort.setModel(new DefaultComboBoxModel<>(new String[] {"Due Date", "Importance"}));
		dropSort.setSelectedIndex(0);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(lock) {
					list.removeCurrent();
					listUpdate();
				}
			}
		});
		btnRemove.setBounds(259, 11, 100, 23);
		frmLab.getContentPane().add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dropSort.setSelectedIndex(0);
				reset();
				listUpdate();
			}
		});
		btnReset.setBounds(369, 11, 100, 23);
		frmLab.getContentPane().add(btnReset);
		
	}
	
	protected void listUpdate() {
		if (list.getCurrent()== null) txtCurrent.setText("No current element");
		else txtCurrent.setText(list.getCurrent().toString());
		canvas.repaint();
	}
	
	protected void reset() {
		while (list.removeCurrent()) ;
		list.add(new Task("Homework 5","10:00 PM 2/25/2013",9));
		list.add(new Task("Lab 5","11:00 AM 2/21/2013",2));
		list.add(new Task("Lecture","9:00 AM 2/26/2013",5));
		
		list.sortByDueDate();
	}
}
