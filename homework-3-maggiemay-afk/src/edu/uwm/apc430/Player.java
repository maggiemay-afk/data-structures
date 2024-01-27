package edu.uwm.apc430;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class Player.
 */
public class Player{
	private Point loc;
	private volatile int radius;
	private volatile BufferedImage playerImg;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param loc the initial location
	 */
	public Player(Point loc){this.loc=loc;radius = DodgeBall.PLAYER_RADIUS;}
	
	/**
	 * Sets the current image.
	 *
	 * @param img the new player image
	 */
	public void setImg(BufferedImage img){playerImg = img;}
	
	/**
	 * Increases the player's radius.
	 * 
	 * @see DodgeBall.makeHarder()
	 */
	public void grow(){radius += 2;}
	
	/**
	 * Checks if colliding with parameter ball.
	 *
	 * @param b the ball
	 * @return true if colliding
	 */
	public boolean isColliding(Ball b){
		return DodgeBall.MORTAL && loc.distance(b.getLoc()) <= (radius + b.getRadius());}
	
	/**
	 * Update the player's location.
	 *
	 * @param mouseLoc the current [adjusted] mouse location
	 */
	public void update(Point mouseLoc){
		int new_x = Math.max(radius, mouseLoc.getX());
		int new_y = Math.max(radius, mouseLoc.getY());
		new_x = Math.min(new_x, DodgeBall.BOUNDS.width -radius);
		new_y = Math.min(new_y, DodgeBall.BOUNDS.height - radius);
		loc = new Point(new_x, new_y);
	}
	
	/**
	 * Draws the player.
	 *
	 * @param g the Graphics context on which to draw
	 */
	public void draw(Graphics g){
		g.drawImage(playerImg,
					loc.getX() - radius, loc.getY() - radius,
					radius*2, radius*2, null);
	}
}
