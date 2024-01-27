package edu.uwm.apc430;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;

/**
 * @author Maggie Herms
 */
public class BreadthFirstLightsOut {
	// TODO: fields
	ArrayDeque<Plan> plans = new ArrayDeque<>();
	BitSet bs = new BitSet();
	
	private BreadthFirstLightsOut(LightsOut lo, int initial, boolean onlyLit) {
		// TODO: initial fields with arguments
	}
	
	private Plan solve() {
		// TODO: 
		// You should maintain a queue of plans to investigate.
		// Each time we get a plan out of the queue,
		// we figure out what state we are on, and then try each of
		// the buttons to see if (1) it is legal (normally all buttons are
		// legal but if "only lit" is set, then only lit buttons can be
		// pressed) and (2) it gets to a state that hasn't been seen before.  
		// If so, we add the new plan to the queue.
		// Our solution prints out the current plan every 10,000 times through the
		// loop so that the user can see that progress is happening.
		// For a 5x5 grid, it can take over 10 seconds to find a plan.
		// (An earlier version of the solution took 2 minutes.)
		return null;
	}
	
	/**
	 * Find a solution (sequences of lights to press so that the state is all off)
	 * using depth first search starting from the given state.
	 * @param lo lights out instance
	 * @param from state to start from
	 * @param onlyLit if a button can only be pressed if it is lit.
	 * @return plan, or null if no such sequence exists.
	 */
	public static Plan findSolution(LightsOut lo, int from, boolean onlyLit) {
		BreadthFirstLightsOut bfs = new BreadthFirstLightsOut(lo, from, onlyLit);
		return bfs.solve();
	}

}
