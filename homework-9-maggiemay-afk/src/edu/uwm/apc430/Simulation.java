/**
 * Name: Maggie Herms
 */
package edu.uwm.apc430;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class Simulation {
	protected PrintWriter logActions = null;
	private int currentTime;
	private Random random = new Random();
	private PriorityQueue<Event> events = new PriorityQueue<>();
	
	public Simulation(PrintWriter log) {
		logActions = log;
	}
	
	private void log(String prefix, Event e) {
		if (logActions != null) {
			logActions.println(String.format("%5d", currentTime) +": " + prefix + e);			
		}
	}
	
	/**
	* A statistic measured over time.
	 */
	public class TimedStatistic extends Statistic {
		private int value;
		private int timeLastSet;
		
		/**
		 * Create a datum with an initial value.
		 * The initial value is projected back to the start of the simulation.
		 * @param v initial value.
		 */
		public TimedStatistic(int v) {
			value = v;
			timeLastSet = 0;
		}
		private void update() {
			assert timeLastSet <= currentTime : "time going backwards?";
			while (timeLastSet < currentTime) {
				super.record(value);
				++timeLastSet;
			}
		}
		
		public int getValue() {
			update();
			return value;
		}
		
		public void setValue(int newValue) {
			update();
			value = newValue;
		}
		
		public void adjustValue(int incr) {
			update();
			value += incr;
		}
				
		@Override
		public void record(int value) {
			setValue(value);
		}
		
		@Override
		public double getAverage() {
			update();
			return super.getAverage();
		}
		
		@Override
		public int getMin() {
			update();
			return super.getMin();
		}
		
		@Override
		public int getMax() {
			update();
			return super.getMax();
		}
		
		@Override
		public String toString() {
			update();
			return super.toString();
		}
		
		
	}
	
	/**
	 * A resource with a given number of units.
	 * A unit of the resource may be acquired in which case it cannot 
	 * be used by anyone else until it is released.
	 */
	public class Resource {
		// fields
		String name; //resource name
		int availableUnits; //number of available units of resource
		PriorityQueue<Event> queue = new PriorityQueue<>(); 
		
		TimedStatistic numberAvailable; //number of available resources over time
		TimedStatistic queueSize; //size of queue over time
		Statistic waitTime; //wait time until acquiring resource
		
		
		/**
		 * Create a resource with the given name (for reporting
		 * purposes) and the given number of available units. 
		 * @param String, name name of resource, should not be null
		 * @param integer, units initial number of available units, must not be negative
		 * @throws IllegalArgumentException, if name is null or units is negative
		 */
		public Resource(String name, int units) throws IllegalArgumentException {
			if (name == null || units < 0) {
				throw new IllegalArgumentException("Name cannot be null, units cannot be negative");
			}
			
			this.name = name;
			this.availableUnits = units;
			numberAvailable = new TimedStatistic(units);
			queueSize = new TimedStatistic(0);
			waitTime = new Statistic();
			
		}
		
		/**
		 * Create a resource with a single unit.
		 * @param name, should not be null
		 * @throws IllegalArgumentException, if name is null
		 */
		public Resource(String name) throws IllegalArgumentException {
			// TODO
			if (name == null) throw new IllegalArgumentException("Name cannot be null");
			
			this.name = name;
			this.availableUnits = 1;
			numberAvailable = new TimedStatistic(availableUnits);
			queueSize = new TimedStatistic(0);
			waitTime = new Statistic();
			
		}
		
		/**
		 * Returns the number of available units
		 * @return integer, available units
		 */
		public int getAvailable() {
			return availableUnits;
		}
		
		/**
		 * Returns the length of the queue
		 * @return integer, size of the queue
		 */
		public int getQueueLength() {
			return queue.size(); 
		}
		
		/**
		 * The event wants a unit of this resource,
		 * and then should be executed.  If no resource is available
		 * the event is held in a FIFO queue until a unit is available.
		 * @param e Event that needs the resource, may not be null
		 * @throws IllegalArgumentException, if Event is null
		 */
		public void acquire(Event e) throws IllegalArgumentException {
			if (e == null) throw new IllegalArgumentException("Event cannot be null");
			
			if (getAvailable() == 0) {
	
				e.setStartTime();
				queue.add(e);
				queueSize.setValue(getQueueLength());
				log("DELAYED: ", e);
				
			} else {
				
				availableUnits--;
				e.setStartTime();
				e.run();
				log("", e);
				
				waitTime.record(currentTime - e.getTime());
				numberAvailable.setValue(availableUnits);
			}
			
		}
		
		/**
		 * The unit is no longer needed and can be given to the next
		 * event waiting in the queue, or (if no one is waiting)
		 * added to the free resources.
		 * An event's run method should call this method
		 * only if they had acquired the resource unit already.
		 */
		public void release() {
		
			availableUnits++;
			
			if (getQueueLength() > 0) {
				Event tempEvent = queue.remove();
				
				availableUnits--;
				waitTime.record(currentTime - tempEvent.getTime());
				queueSize.setValue(getQueueLength());
				
				tempEvent.setStartTime();
				tempEvent.run();
				log("", tempEvent);
				
			} else {
				numberAvailable.setValue(availableUnits);
			}
		}
		
		/**
		 * Report the statistics about this resource:
		 * <ol>
		 * <li> The name, how many available and the queue size
		 * <li> The number available, averaged over time
		 * <li> The queue size, averaged over time
		 * <li> The average wait time before acquiring.
		 * </ol>
		 * @param pw print writer to use, must not be null
		 */
		public void report(PrintWriter pw) {
			pw.println("Resource " + name + " has " + getAvailable() + " units available and " + getQueueLength() + " waiting.");
			pw.println("  available: " + numberAvailable.toString());
			pw.println("  queue size: " + queueSize.toString());
			pw.println("  waiting time: " + waitTime.toString());
		}
	}
	
	/**
	 * An event in the discrete event simulation.
	 * Each event should override {@link #toString()}
	 * to describe the event, in case it is logged.
	 */
	public abstract class Event implements Comparable<Event> {
		private int startTime;
		
		public int getTime() { return startTime; }
		
		public void setStartTime() { startTime = currentTime; }
		
		public void setStartTime(DelayDistribution dd) {
			startTime = currentTime + dd.getDelay(random);
		}
				
		@Override
		public int compareTo(Event o) {
			return startTime - o.startTime;
		}

		public abstract void run();
	}
	
	/**
	 * Move clock ahead by time amount.  This method
	 * should not be called if there are events in the queue.
	 * It is used to test other parts of the simulation without
	 * running the simulation.
	 * @param amount amount to change time by, must be non-negative.
	 */
	public void incrementTime(int amount) {
		if (!events.isEmpty()) throw new IllegalStateException("event queue is non-empty; cannot adjust time directly");
		if (amount < 0) throw new IllegalArgumentException("Time cannot go backwards");
		currentTime += amount;
	}
	
	/**
	 * Set the random source to be a deterministic sequence
	 * using the given seed.
	 * @param seed
	 */
	public void setRandom(long seed) {
		random.setSeed(seed);
	}
	
	/**
	 * Schedule an event in the future according to the given
	 * delay distribution.
	 * @param e event to schedule, must not be null.
	 * @param d delay distribution, must not be null.
	 */
	public void schedule(Event e, DelayDistribution d) {
		e.setStartTime(d);
		events.add(e);
	}
	
	/**
	 * Run the simulation until the given time is reached.
	 * (If the event coming from the queue starts at a time
	 * not before the max time, we stop the simulation
	 * with the time set equal to the max time.)
	 * If the event queue becomes empty, an exception is thrown.
	 * (NB: You don't need to handle this in a special case.)
	 * @param maxTime maximum time point to use.
	 */
	public void run(int maxTime) {
		currentTime = 0;
		for (;;) {
			Event e = events.remove();
			int nextTime = e.getTime();
			assert (nextTime >= currentTime) : " Time going backwards from " + currentTime + " to " + nextTime;
			currentTime = nextTime;
			if (currentTime >= maxTime) break;
			log("",e);
			e.run();
		}
		currentTime = maxTime; // keep stats to range [0,maxTime)
	}
}
