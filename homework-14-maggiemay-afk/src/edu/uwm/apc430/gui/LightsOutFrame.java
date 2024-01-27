package edu.uwm.apc430.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.uwm.apc430.BreadthFirstLightsOut;
import edu.uwm.apc430.GridLoc;
import edu.uwm.apc430.LightsOut;
import edu.uwm.apc430.Plan;

public class LightsOutFrame extends JFrame {
	/**
	 * Keep Eclipse Happy
	 */
	private static final long serialVersionUID = 1L;

	private final LightsOut lightsOut;
	private final LightsOutPanel main;
	private final JCheckBox litOnlyBox = new JCheckBox("lit only");
	private Random random = new Random();
	private Stack<Integer> undoLog = new Stack<>();
	
	public LightsOutFrame(LightsOut lo) {
		lightsOut = lo;
		JButton allOnButton = new JButton("All On");
		JButton allOffButton = new JButton("All Off");
		JButton randomButton = new JButton("Random");
		JButton stepButton = new JButton("Step");
		JButton undoButton = new JButton("Undo");
		allOnButton.addActionListener((ae) -> doAllOn());
		allOffButton.addActionListener((ae) -> doAllOff());
		randomButton.addActionListener((ae) -> doRandom());
		stepButton.addActionListener((ae) -> doStep());
		undoButton.addActionListener((ae) -> doUndo());
		JPanel topButtonPanel = new JPanel();
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setLayout(new BoxLayout(leftButtonPanel,BoxLayout.PAGE_AXIS));
		topButtonPanel.add(allOnButton);
		topButtonPanel.add(allOffButton);
		topButtonPanel.add(randomButton);
		
		leftButtonPanel.add(stepButton);
		leftButtonPanel.add(undoButton);
		main = new LightsOutPanel(lo);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(topButtonPanel,BorderLayout.NORTH);
		contentPane.add(leftButtonPanel,BorderLayout.WEST);
		contentPane.add(main,BorderLayout.CENTER);
		contentPane.add(litOnlyBox,BorderLayout.SOUTH);
		main.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				doClick(e);
			}			
		});
		setContentPane(contentPane);
	}
	
	private void doAllOn() {
		undoLog.push(main.getState());
		main.setState(lightsOut.allOn());
	}
	
	private void doAllOff() {
		undoLog.push(main.getState());
		main.setState(lightsOut.allOff());		
	}
	
	private void doRandom() {
		int state = lightsOut.allOff();
		for (GridLoc l : lightsOut.getLights()) {
			if (random.nextBoolean()) {
				state = lightsOut.next(state, l);
			}
		}
		undoLog.push(main.getState());
		main.setState(state);
	}
	
	private void doStep() {
		int state = main.getState();
		long startTime = System.currentTimeMillis();
		Plan p = BreadthFirstLightsOut.findSolution(lightsOut,state,litOnlyBox.isSelected());
		System.out.println("Plan: " + p);
		System.out.println("Solve time: " + (System.currentTimeMillis()-startTime) + " ms.");
		if (p == null) {
			JOptionPane.showMessageDialog(this, "Can't solve", "Step Error", JOptionPane.ERROR_MESSAGE);			
		} else if (p == Plan.EMPTY_PLAN) {
			JOptionPane.showMessageDialog(this, "Already solved ?", "Step Warning", JOptionPane.WARNING_MESSAGE);						
		} else if (litOnlyBox.isSelected() && !lightsOut.isOn(state, p.first())) {
			JOptionPane.showMessageDialog(this, "Invalid solution computed: " + p, "Step Error", JOptionPane.ERROR_MESSAGE);
		} else {
			undoLog.push(state);
			main.setState(lightsOut.next(state, p.first()));
		}
	}
	
	private void doUndo() {
		if (undoLog.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No further undo available", "Undo Warning", JOptionPane.ERROR_MESSAGE);
		} else {
			main.setState(undoLog.pop());
		}
	}
	
	private void doClick(MouseEvent e) {
		GridLoc loc = main.translatePoint(e.getPoint());
		int state = main.getState();
		if (litOnlyBox.isSelected() && !lightsOut.isOn(state, loc)) {
			JOptionPane.showMessageDialog(this, "Can only flip switch if light is on", "Click error", JOptionPane.ERROR_MESSAGE);
		} else {
			undoLog.push(main.getState());
			main.setState(lightsOut.next(state, loc));
		}
	}
	
	public void run() {
		main.setState(lightsOut.allOn());
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// System.out.println("About to make visible");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		int rows = Integer.parseInt(args[0]);
		int cols = Integer.parseInt(args[1]);
		SwingUtilities.invokeLater(() -> new LightsOutFrame(new LightsOut(rows,cols)).run());
	}
}
