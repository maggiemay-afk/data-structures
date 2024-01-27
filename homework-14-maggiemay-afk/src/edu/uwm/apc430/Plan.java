package edu.uwm.apc430;

import java.util.NoSuchElementException;

/**
 * @author Maggie Herms
 * A sequence of button presses (noted by grid locations) in the LightsOut game.
 * This class is immutable.
 */
public class Plan {
	private final Plan previous;
	private final GridLoc light;
	
	private Plan() {
		previous = null;
		light = null;
	}
	
	/**
	 * The empty plan: nothing is pressed.
	 * The only plan with a null previous or light.
	 */
	public static final Plan EMPTY_PLAN = new Plan();
	
	/**
	 * Create a plan given an existing plan followed by a second press.
	 * @param previous plan being extended, must not be null
	 * @param light location of light next pressed, must not be null.
	 */
	public Plan(Plan previous, GridLoc light) {
		if (previous == null || light == null) throw new IllegalArgumentException("Invalid plan");
		this.previous = previous;
		this.light = light;
	}
	
	/**
	 * Given a state of the system, return the new state after executing the plan.
	 * @param lo lights out description, must not be null
	 * @param state current state
	 * @return new state.
	 * @throws IllegalArgumentException
	 */
	public int apply(LightsOut lo, int state) throws IllegalArgumentException {
		if (lo == null) throw new IllegalArgumentException("LightsOut cannot be null");
		return 0; // TODO 
	}
	
	/**
	 * Return the plan that starts with this plan and adds 
	 * the given button press.
	 * @param loc location pressed, must not be null
	 * @return new plan (never null).
	 * @throws IllegalArgumentException
	 */
	public Plan add(GridLoc loc) throws IllegalArgumentException {
		if (loc == null) throw new IllegalArgumentException("GridLoc cannot be null");
		return new Plan(this,loc);
	}
	
	/**
	 * Return the location of the first light pressed.
	 * @return the first grid location of the plan (never null).
	 * @throws NoSuchElementException if the plan is empty.
	 */
	public GridLoc first() {
		return null; // TODO
	}
	
	/**
	 * Compute the length of this plan.  This is the number
	 * of lights pressed.
	 * @return length of this plan.
	 */
	public int length() {
		return 0; // TODO
	}
	
	// TODO: override equals and hashCode
	
	@Override
	public String toString() {
		if (this == EMPTY_PLAN) return "[]";
		if (previous == EMPTY_PLAN) return "[" + light + "]";
		String ps = previous.toString();
		return ps.substring(0, ps.length()-1) + "," + light + "]";
	}

	/**
	 * Create a plan from an array of button presses.
	 * @param a array of locations of buttons to press, must not be null
	 * @return Plan (never null) that presses the buttons in order.
	 */
	public static Plan create(GridLoc... a) {
		Plan p = EMPTY_PLAN;
		// TODO
		return p;
	}
}
