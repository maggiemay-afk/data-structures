package edu.uwm.apc430;

/**
 * A point on the (2D) screen.
 */
public class Point {

	private final int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int x() { return x; }
	public int y() { return y; }
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Point) {
			return (this.x == ((Point) obj).x && this.y == ((Point) obj).y);
			
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (x << 8) ^ y; 
	}

	@Override
	public String toString() {
		return "Point(" + this.x + "," + this.y + ")";
		
	}	
	
	/**
	 * Return a new point made by starting with
	 * this points fields with the given adjustments
	 * @param dx amount to adjust the x coordinate
	 * @param dy amount to adjust the y coordinate
	 * @return new point
	 */
	public Point move(int dx, int dy) {
		return new Point(x + dx, y + dy);
	}
}
