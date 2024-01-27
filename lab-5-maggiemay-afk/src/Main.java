import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import edu.uwm.apc430.Collector;
import edu.uwm.apc430.Collector.ThingType;


public class Main {

	private JFrame frame;
	private Collector collector = new Collector();
	private JTextArea txtContent;
	private LinkedListCanvas paneLinked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel grabPanel = new JPanel();
		grabPanel.setBorder(new TitledBorder(null, "Grab Something", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		grabPanel.setBounds(10, 11, 414, 91);
		frame.getContentPane().add(grabPanel);
		grabPanel.setLayout(null);
		
		JButton btnCoin = new JButton("Grab a Coin");
		btnCoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCollector(ThingType.COIN);
			}
		});
		btnCoin.setBounds(10, 22, 117, 23);
		grabPanel.add(btnCoin);
		
		JButton btnGem = new JButton("Grab a Gem");
		btnGem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCollector(ThingType.GEM);
			}
		});
		btnGem.setBounds(10, 56, 117, 23);
		grabPanel.add(btnGem);
		
		JButton btnKey = new JButton("Grab a Key");
		btnKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCollector(ThingType.KEY);
			}
		});
		btnKey.setBounds(137, 22, 117, 23);
		grabPanel.add(btnKey);
		
		JButton btnRing = new JButton("Grab a Ring");
		btnRing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCollector(ThingType.RING);
			}
		});
		btnRing.setBounds(137, 56, 117, 23);
		grabPanel.add(btnRing);
		
		JButton btnStone = new JButton("Grab a Stone");
		btnStone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCollector(ThingType.STONE);
			}
		});
		btnStone.setBounds(264, 22, 140, 23);
		grabPanel.add(btnStone);
		
		JButton btnLeaveAll = new JButton("Leave Everything");
		btnLeaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCollector(null);
			}
		});
		btnLeaveAll.setBounds(264, 56, 140, 23);
		grabPanel.add(btnLeaveAll);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Collector Contents", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setBounds(10, 113, 414, 65);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		txtContent = new JTextArea();
		txtContent.setLineWrap(true);
		txtContent.setBounds(10, 16, 394, 40);
		contentPanel.add(txtContent);
		txtContent.setText(collector.show());
		txtContent.setEditable(false);
		
		JButton btnPrintLinkedList = new JButton("Print Linked List");
		btnPrintLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneLinked.repaint();
			}
		});
		btnPrintLinkedList.setBounds(20, 183, 151, 23);
		frame.getContentPane().add(btnPrintLinkedList);
		
		paneLinked = new LinkedListCanvas();
		paneLinked.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		paneLinked.setBounds(10, 217, 414, 81);
		paneLinked.setBackground(Color.WHITE);
		
		frame.getContentPane().add(paneLinked);
	}
	
	private void addCollector(ThingType thing) {
		try {
			if (thing == null) collector.leaveEverything();
			else collector.grab(thing);
			txtContent.setText(collector.show());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "There was an exception thrown, view Console for more details", "Exception Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private class LinkedListCanvas extends JPanel {
		/**
		 * Keep Eclipse happy.
		 */
		private static final long serialVersionUID = 1L;
		private static final int BOX_WIDTH = 40, BOX_HEIGHT = 60, SECTION_HEIGHT = 20;
		private static final int X_SPACE = 10;
		private static final int Y = 10;
		private static final int ARROWSIZE = 5;
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (!collector.hasNoThings()) {   
				int x = 10;
	    		int how_many = collector.howManyThings();
	            for (int j = 0; j < how_many; j++) {  
	            	ThingType t = collector.whatIs(j);
	            	paintBox(g,x, ThingType.describe(t), collector.howManyOf(t));
	            	if (j < how_many - 1) {
	            		paintPointer(g,x);
	            	}
	            	x += BOX_WIDTH + X_SPACE;
	            }
	        } 
		}
		
		private void paintBox(Graphics g, int x, String description, int count) {
			g.drawRect(x, Y, BOX_WIDTH, BOX_HEIGHT);
			g.drawLine(x, Y + SECTION_HEIGHT, x + BOX_WIDTH, Y + SECTION_HEIGHT);
			g.drawLine(x, Y + SECTION_HEIGHT * 2, x + BOX_WIDTH, Y + SECTION_HEIGHT * 2);
			FontMetrics fm = getFontMetrics( getFont() );
			int textWidth = fm.stringWidth(description);
			int textX = x + (BOX_WIDTH - textWidth) / 2;
			g.drawString(description, textX, Y+ SECTION_HEIGHT - 5);
			textWidth = fm.stringWidth(Integer.toString(count));
			textX = x + (BOX_WIDTH - textWidth) / 2;
			g.drawString(Integer.toString(count), textX, Y + SECTION_HEIGHT * 2 - 5);
		}
		
		
		private void paintPointer(Graphics g, int x) {
			int startX = x+BOX_WIDTH/2;
			int startY = Y+BOX_HEIGHT-SECTION_HEIGHT/2;
			int endX = x+BOX_WIDTH+X_SPACE;
			int [] pointx = { endX, endX - ARROWSIZE, endX -ARROWSIZE};
			int [] pointy = { startY, startY + ARROWSIZE, startY - ARROWSIZE};
			g.drawLine(startX, startY, endX, startY);
			g.fillPolygon(pointx, pointy, pointx.length);
		}
		
	}
}
