package edu.uwm.apc430;

import java.io.PrintWriter;


/**
 * Simulate a mass vaccination site where people can show up without
 * appointments.  We have a number of stations where people can get shots,
 * and each can work independently, taking whoever is in front of the line.
 * The number of stations is a constructor parameter.
 * The simulation uses "minutes" as the time unit.
 */
public class MassVaccination extends Simulation {

	// we remember how many people we have vaccinated
	private int vaccinated = 0;
	
	private final int numberStations;
	
	// where people get their shot
	private final Resource station;
	
	// how often do people show up? 5 = randomly between 0 and 5 minutes
	private final DelayDistribution arrival = new UniformDelay(5);
	
	// how long does it take to give someone the vaccination?
	private final DelayDistribution vaxTime = new ConstantDelay(5);
	
	// how long do people need to wait around after their shot
	// to see if they have (extremely rare) side-effects?
	private final DelayDistribution waitTime = new ConstantDelay(15);
	
	// We keep track of how many people are waiting around
	private final TimedStatistic waiting = new TimedStatistic(0);
	
	public MassVaccination(PrintWriter log, int stations) {
		super(log);
		numberStations = stations;
		station = new Resource("Vaccination station",stations);
	}

	static private int patientNumber = 0;
	
	private class ArriveEvent extends Event {
		private int patient = ++patientNumber;
		
		@Override
		public String toString() {
			return "Patient " + patient + " arrives.";
		}
		
		@Override
		public void run() {
			// schedule the next arrival:
			schedule(new ArriveEvent(),arrival);
			// this patient gets in line at the stations:
			station.acquire(new ShotEvent(patient));
		}
	}
	
	private class ShotEvent extends Event {
		private final int patient;
		public ShotEvent(int p) { patient = p; }
		
		@Override
		public String toString() {
			return "Patient " + patient + " sits down and bares shoulder.";
		}
		
		@Override
		public void run() {
			// schedule when the shot is done:
			schedule(new StartWaitingEvent(patient),vaxTime);
		}
	}
	
	private class StartWaitingEvent extends Event {
		private final int patient;
		public StartWaitingEvent(int p) { patient = p; }
		
		@Override
		public String toString() {
			return "Patient " + patient + "'s shot is done.  They stand up and move to waiting area.";
		}
		
		@Override
		public void run() {
			++vaccinated; // record someone has their dose
			station.release(); // gets out of the way for next person
			waiting.adjustValue(+1); // one more person is waiting
			// schedule when the waiting will be over:
			schedule(new LeaveEvent(patient),waitTime);
		}
	}
	
	private class LeaveEvent extends Event {
		private final int patient;
		public LeaveEvent(int p) { patient = p; }
		
		@Override
		public String toString() {
			return "Patient " + patient + " is done waiting and leaves.";
		}
		
		@Override
		public void run() {
			waiting.adjustValue(-1); // leave waiting area
		}
	}

	public void printStats() {
		PrintWriter pw = logActions;
		pw.println("Mass Vaccination Simulation");
		pw.println("Parameters");
		pw.println("  arrival: " + arrival);
		pw.println("  number stations: " + numberStations);
		pw.println("  vax time: " + vaxTime + " min.");
		pw.println("  wait time: " + waitTime + " min.");
		pw.println("Results");
		pw.println("  vaccinated: " + vaccinated);
		station.report(pw);
		pw.println("  in waiting area: " + waiting);
		pw.flush();
	}
	
	@Override
	public void run(int maxTime) {
		schedule(new ArriveEvent(), (r) -> 0);
		super.run(maxTime);
	}
	
	public static void main(String[] args) {
		MassVaccination sim = new MassVaccination(new PrintWriter(System.out),3);
		sim.run(600); // run for 10 hours
		sim.printStats();
	}
}
