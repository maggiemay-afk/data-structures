/**
 * Name: Maggie Herms
 */
package edu.uwm.apc430;

import java.io.PrintWriter;

public class IceCream extends Simulation {
	
	public IceCream(PrintWriter log) {
		super(log);
	}

	private int served = 0;
	private int gaveup = 0;
	private Resource counter = new Resource("Order Counter");
	private static final int maxLineLength = 2;
	private static final int numTables = 3;
	private Resource tables = new Resource("Tables",3);
	private DelayDistribution arrive = new UniformDelay(300);
	private DelayDistribution order = new UniformDelay(60,300);
	private DelayDistribution eat = new UniformDelay(60,600);

	private static int customerNumber = 0;
	
	private class ArriveEvent extends Event {
		private int customer = ++customerNumber;
		
		@Override
		public String toString() {
			return "Customer " + customer + " arrives.";
		}
		
		@Override
		public void run() {
			// Someone shows up.
			// They decide whether to go in and order ice cream,
			// or whether to give up since the line is too long.
			// Then schedule the next arrival according to the "arrive" distribution.
			
			if (counter.getQueueLength() < maxLineLength) {
				counter.acquire(new OrderEvent(customer));
			} else {
				gaveup++;
			}
			schedule(new ArriveEvent(), arrive);
		}
	}
	
	private class OrderEvent extends Event {
		private final int customer;
		public OrderEvent(int c) { customer = c; }
		
		@Override
		public String toString() {
			return "Customer " + customer + " orders ice cream.";
		}
		
		@Override
		public void run() {
			// The customer arrives at the front of the line.
			// "Um, ah, how many flavors do you have?"
			schedule(new SitEvent(customer), order);
		}
	}
	
	private class SitEvent extends Event {
		private final int customer;
		public SitEvent(int c) { customer = c; }
		
		@Override
		public String toString() {
			return "Customer " + customer + " gets ice cream.";
		}
		
		@Override
		public void run() {
			// The customer gets their ice cream, and moves away from
			// the counter and looks for a table.
			counter.release();
			tables.acquire(new EatEvent(customer));
		}
	}
	
	private class EatEvent extends Event {
		private final int customer;
		public EatEvent(int c) { customer = c; }
		
		@Override
		public String toString() {
			return "Customer " + customer + " sits and eats ice cream.";
		}
		
		@Override
		public void run() {
			// Slurp, lick, swallow
			// Checks phone?
			// Mind wanders...
			schedule(new LeaveEvent(customer), eat);
		}
	}

	private class LeaveEvent extends Event {
		private final int customer;
		public LeaveEvent(int c) { customer = c; }
		
		@Override
		public String toString() {
			return "Customer " + customer + " leaves satisfied.";
		}
		
		@Override
		public void run() {
			// Customer gets up from table and heads on out.
			// NB: Management counts them as they leave.
			tables.release();
			served++;
		}
	}

	public void printStats() {
		PrintWriter pw = logActions;
		pw.println("Ice-Cream Simulation");
		pw.println("Parameters");
		pw.println("  arrival: " + arrive);
		pw.println("  max queue: " + maxLineLength);
		pw.println("  num tables: " + numTables);
		pw.println("  order time: " + order);
		pw.println("  eat time: " + eat);
		pw.println("Results");
		pw.println("  served: " + served);
		pw.println("  gave up: " + gaveup);
		counter.report(pw);
		tables.report(pw);
		pw.flush();
	}
	
	@Override
	public void run(int maxTime) {
		schedule(new ArriveEvent(), (r) -> 0);
		super.run(maxTime);
	}
	
	public static void main(String[] args) {
		IceCream sim = new IceCream(new PrintWriter(System.out));
		sim.run(36000);
		sim.printStats();
	}
}
