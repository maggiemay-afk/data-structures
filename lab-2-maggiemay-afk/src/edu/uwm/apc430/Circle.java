package edu.uwm.apc430;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A mutable class representing a graphical object
 */
public class Circle implements Cloneable {
	public static final Color DEFAULT_COLOR = Color.WHITE;
	
	private Point center;
	private int radius;
	private Color color;
	
	public Point getCenter() { return center; }
	public int getRadius() { return radius; }
	public Color getColor() { return color; }
	
	/**
	 * Create a circle with default color and the given center and radius
	 * @param c center, must not be null
	 * @param r radius, must be positive
	 * @exception IllegalArgumentException if radius is not positive.
	 */
	public Circle(Point c, int r) {
		this(c,r,DEFAULT_COLOR);
	}

	/**
	 * Create a circle with the given center, radius, and fill color
	 * @exception IllegalArgumentException if radius is not positive
	 * @exception NullPointerException if center value or fill color are null
	 * 
	 * @param c Center of circle
	 * @param r Radius of circle
	 * @param fill Circle color
	 */
	public Circle(Point c, int r, Color fill) {
		if (c == null) throw new NullPointerException("cannot have null center");
		if (fill == null) throw new NullPointerException("cannot have null fill");
		if (r <= 0) throw new IllegalArgumentException("radius must be positive");
		
		center = c;
		radius = r;
		color = fill;
	}
	
	/**
	 * Move the circle using the given adjustments
	 * @param dx amount to adjust the x coordinates
	 * @param dy amount to adjust the y coordinates
	 */
	public void move(int dx, int dy) {
		center = new Point((center.x() + dx), (center.y() + dy));
	}
	
	/**
	 * Change the radius of this circle.
	 * @param newR the new radius, must be positive
	 * @exception IllegalArgumentException if newR is not positive
	 */
	public void setRadius(int newR) {
		if (newR <= 0) throw new IllegalArgumentException("Radius must be positive");
		this.radius = newR;
	}
	
	/**
	 * Set the color of a circle.
	 * @param c new color, must not be null
	 */
	public void setColor(Color c) {
		if (c == null) throw new NullPointerException("cannot use a null color");
		color = c;
	}
	
	/** Makes a copy of the Circle object
	 * @Override
	 * @exception CloneNotSupportedException if class does not implement cloneable interface
	 * @throws RuntimeException if class does not implement cloneable interface
	 */
	public Circle clone() {
		Circle newCircle = null;
		
		try {
			newCircle = (Circle) super.clone();
			
		} catch(CloneNotSupportedException CNS) {
			throw new RuntimeException("Class must implement Cloneable");
		}
		
		return newCircle;
	 
	}
	
	/**
	 * Render the circle in the given graphical context.
	 * @param g
	 */
	public void draw(Graphics g) {
		int diameter = radius*2;
		int left = center.x()-radius;
		int top = center.y()-radius;
		g.setColor(color);
		g.fillOval(left, top, diameter, diameter);
		g.setColor(Color.BLACK);
		g.drawOval(left, top, diameter, diameter);
	}
}
