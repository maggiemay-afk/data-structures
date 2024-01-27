/**
 * Name: Maggie Herms
 * Date: 2/2/2023
 * 
 */
package edu.uwm.apc430;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShowCircles extends JFrame {
	/**
	 * Keep Eclipse Happy
	 */
	private static final long serialVersionUID = 1L;
	
	private Circle c1, c2, c3, c4;
	
	public ShowCircles() {
		c1 = new Circle(new Point(50,50),20,Color.RED);
		c2 = c1.clone();
		c2.move(0, 50);
		c2.setColor(Color.YELLOW);
		c3 = c2.clone();
		c3.move(0, 50);
		c3.setColor(Color.GREEN);
		c4 = new Circle(new Point(100,100),10);
		c4.setRadius(50);
		setContentPane(new ContentPane());
	}
	
	private class ContentPane extends JPanel {
		/**
		 * Keep Eclipse Happy
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			c4.draw(g);
			c1.draw(g);
			c2.draw(g);
			c3.draw(g);
		}
		
	}
	
	public static void run() {
		JFrame frame = new ShowCircles();
		frame.setSize(300,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> run());
	}
}
