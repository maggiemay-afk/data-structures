import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import edu.uwm.apc430.Simulation;
import edu.uwm.cs.junit.LockedTestCase;


public class TestResource extends LockedTestCase {
    private StringWriter[] output;
    private PrintWriter[] outputCollector;

    public String[] getOutput(int i) {
            outputCollector[i].close();
            List<String> results = new ArrayList<>();
            BufferedReader br = new BufferedReader(new StringReader(output[i].toString()));
            String s;
            try {
                    while ((s = br.readLine()) != null) {
                            results.add(s);
                    }
            } catch (IOException e) {
                    assertFalse("Internal Error",true);
            }
            return results.toArray(new String[results.size()]);
    }

    private Simulation simulation;
	private Simulation.Resource resource;
	private MyEvent event;
	private MyEvent event2;
	private MyEvent event3;
	private MyEvent event4;
	
	private static final String RESOURCE_NAME = "R";
	private static final int COLLECTORS = 2;
	private static final int INITIAL = 2;
	
	@Override
	public void setUp() {
		output = new StringWriter[COLLECTORS];
		outputCollector = new PrintWriter[COLLECTORS];
		for (int i=0; i < COLLECTORS; ++i) {
			output[i] = new StringWriter();
			outputCollector[i] = new PrintWriter(output[i]);
		}
		simulation = new Simulation(outputCollector[0]);
		resource = simulation.new Resource(RESOURCE_NAME,INITIAL);
		event = new MyEvent(simulation, 1);
		event2 = new MyEvent(simulation, 2);
		event3 = new MyEvent(simulation, 3);
		event4 = new MyEvent(simulation, 4);
	}
	
	
	/// locked tests
	
	public void test() {
		resource = simulation.new Resource("Test",2);
		resource.acquire(event);
		assertEquals(Ti(769476388),resource.getAvailable());
		assertEquals(Ti(2114690378),resource.getQueueLength());
		resource.acquire(event);
		assertEquals(Ti(1630070176),resource.getAvailable());
		assertEquals(Ti(1525379774),resource.getQueueLength());		
		resource.acquire(event);
		assertEquals(Ti(74608142),resource.getAvailable());
		assertEquals(Ti(184946813),resource.getQueueLength());		
		assertEquals(Ti(464474128),event.getRuns()); // how many times has event run so far?
		resource.release();
		assertEquals(Ti(1894502665),resource.getAvailable());
		assertEquals(Ti(620042745),resource.getQueueLength());		
		assertEquals(Ti(547154842),event.getRuns()); // how many times has event run so far?
		resource.release();
		assertEquals(Ti(38999127),resource.getAvailable());
		assertEquals(Ti(1211762721),resource.getQueueLength());		
		assertEquals(Ti(906950457),event.getRuns()); // how many times has event run so far?		
	}
	
	
	/// test0x: tests without time or stats.
	
	public void test00() {
		assertEquals(INITIAL,resource.getAvailable());
	}
	
	public void test01() {
		assertEquals(0,resource.getQueueLength());
	}
	
	public void test02() {
		resource.acquire(event);
		assertEquals(1,resource.getAvailable());
		assertEquals(1,event.getRuns());
		assertEquals(0,resource.getQueueLength());
	}
	
	public void test03() {
		resource.acquire(event);
		resource.acquire(event);
		assertEquals(0,resource.getAvailable());
		assertEquals(2,event.getRuns());
		assertEquals(0,resource.getQueueLength());
	}
	
	public void test04() {
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		assertEquals(0,resource.getAvailable());
		assertEquals(2,event.getRuns());
		assertEquals(1,resource.getQueueLength());
	}
	
	public void test05() {
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		resource.release();
		assertEquals(3,event.getRuns());
		assertEquals(0,resource.getQueueLength());
	}
	
	public void test06() {
		resource.release();
		assertEquals(3,resource.getAvailable());
		assertEquals(0,resource.getQueueLength());
	}
	
	public void test07() {
		resource.release();
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		assertEquals(3,event.getRuns());		
	}
	
	public void test08() {
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		assertEquals(2,event.getRuns());
		assertEquals(2,resource.getQueueLength());
		assertEquals(0,resource.getAvailable());
	}
	
	public void test09() {
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		resource.acquire(event);
		resource.release();
		resource.release();
		resource.release();
		assertEquals(4,event.getRuns());
		assertEquals(0,resource.getQueueLength());
		assertEquals(1,resource.getAvailable());
	}
	
	


	


	


	


	


	/// test1x: tests using time
	
	public void test10() {
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		assertEquals(3,event.getTime());
	}
	
	public void test11() {
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.acquire(event);
		simulation.incrementTime(5);
		assertEquals(7,event.getTime());
	}
	
	public void test12() {
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.acquire(event);
		simulation.incrementTime(5);
		resource.acquire(event);
		simulation.incrementTime(6);
		assertEquals(12,event.getTime());
	}
	
	public void test13() {
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.acquire(event);
		simulation.incrementTime(5);
		resource.acquire(event);
		simulation.incrementTime(6);
		resource.release();
		simulation.incrementTime(7);
		assertEquals(18,event.getTime());
	}
	
	public void test14() {
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.acquire(event2);
		simulation.incrementTime(5);
		resource.acquire(event3);
		simulation.incrementTime(6);
		resource.acquire(event4);
		simulation.incrementTime(7);
		resource.release();
		simulation.incrementTime(8);
		resource.release();
		simulation.incrementTime(9);
		assertEquals(3,event.getTime());
		assertEquals(7,event2.getTime());
		assertEquals(25,event3.getTime());
		assertEquals(33,event4.getTime());
	}
	
	
	/// test2x: tests that check whether run() is called correctly
	
	public void test21() {
		MyEvent event1 = new MyEvent(simulation, 1, () -> {
			assertEquals(1,resource.getAvailable());
			assertEquals(0,resource.getQueueLength());
		});
		simulation.incrementTime(1);
		resource.acquire(event1);
	}


	public void test22() {
		MyEvent event5 = new MyEvent(simulation, 5, () -> {
			assertEquals(0,resource.getAvailable());
			assertEquals(0,resource.getQueueLength());
		});
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.acquire(event5);
	}


	public void test23() {
		MyEvent event6 = new MyEvent(simulation, 6, () -> {
			assertEquals(0,resource.getAvailable());
			assertEquals(0,resource.getQueueLength());
		});
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event6);
		resource.release();
	}


	public void test24() {
		MyEvent event10 = new MyEvent(simulation, 10, () -> {
			assertEquals(0,resource.getAvailable());
			assertEquals(1,resource.getQueueLength());
		});
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event10);
		simulation.incrementTime(4);
		resource.acquire(event3);
		resource.release();
		assertEquals(1,event10.getRuns());
	}


	public void test25() {
		MyEvent event15 = new MyEvent(simulation, 15, () -> {
			assertEquals(0,resource.getAvailable());
			assertEquals(2,resource.getQueueLength());
		});
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event15);
		simulation.incrementTime(4);
		resource.acquire(event3);
		simulation.incrementTime(5);
		resource.acquire(event4);
		resource.release();
		resource.release();
		assertEquals(1,event15.getRuns());
	}


	/// test3x: tests of resources with statistics (no waiting)
	
	public void test30() {
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals(4,stats.length);
		assertEquals("Resource " + RESOURCE_NAME + " has 2 units available and 0 waiting.",stats[0]);
	}


	public void test31() {
		simulation.incrementTime(10);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals("  available: [2:2.0:2](10)",stats[1]);
	}
	
	public void test32() {
		simulation.incrementTime(10);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals("  queue size: [0:0.0:0](10)",stats[2]);
	}
	
	public void test33() {
		simulation.incrementTime(10);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals("  waiting time: [0:0.0:0](0)",stats[3]);
	}
	
	public void test34() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(3);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals(4,stats.length);
		assertEquals("Resource " + RESOURCE_NAME + " has 1 units available and 0 waiting.",stats[0]);
		assertEquals("  queue size: [0:0.0:0](4)",stats[2]);
	}
	
	public void test35() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals("  available: [1:1.2:2](5)",stats[1]);		
	}
	
	public void test36() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);	
		assertEquals("  waiting time: [0:0.0:0](1)",stats[3]);
	}
	
	public void test37() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.release();
		simulation.incrementTime(2);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals(4,stats.length);
		assertEquals("Resource " + RESOURCE_NAME + " has 2 units available and 0 waiting.",stats[0]);
		assertEquals("  queue size: [0:0.0:0](5)",stats[2]);
	}
	
	public void test38() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.release();
		simulation.incrementTime(2);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);
		assertEquals("  available: [1:1.6:2](5)",stats[1]);		
	}
	
	public void test39() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.release();
		simulation.incrementTime(2);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);		
		assertEquals("  waiting time: [0:0.0:0](1)",stats[3]);
	}
	
	
	/// test4x: reporting testing (multiple events)
	
	public void test40() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event);
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);	
		assertEquals(4,stats.length);
		assertEquals("Resource " + RESOURCE_NAME + " has 0 units available and 1 waiting.",stats[0]);		
	}
	
	public void test41() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event);
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);		
		assertEquals("  available: [0:0.4:2](10)",stats[1]);		
	}
	
	public void test42() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event);
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);		
		assertEquals("  queue size: [0:0.4:1](10)",stats[2]);
	}
	
	public void test43() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event);
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);		
		assertEquals("  waiting time: [0:0.0:0](2)",stats[3]);
	}
	
	public void test44() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event);
		simulation.incrementTime(3);
		resource.acquire(event);
		simulation.incrementTime(4);
		resource.release(); // too late to affect timed statistics
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);		
		assertEquals("Resource " + RESOURCE_NAME + " has 0 units available and 0 waiting.",stats[0]);		
		assertEquals("  available: [0:0.4:2](10)",stats[1]);		
		assertEquals("  queue size: [0:0.4:1](10)",stats[2]);
		assertEquals("  waiting time: [0:1.3:4](3)",stats[3]);
	}
	
	public void test45() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		simulation.incrementTime(2);
		resource.acquire(event4);
		simulation.incrementTime(1);
		resource.release(); 
		resource.release();
		simulation.incrementTime(1);
		resource.report(outputCollector[1]);
		String[] stats = getOutput(1);		
		assertEquals("Resource " + RESOURCE_NAME + " has 0 units available and 0 waiting.",stats[0]);		
		assertEquals("  available: [0:0.4:2](10)",stats[1]);		
		assertEquals("  queue size: [0:0.4:2](10)",stats[2]);
		assertEquals("  waiting time: [0:1.0:3](4)",stats[3]);
	}

	
	/// text5x: testing logging
	
	public void test50() {
		String[] ss = getOutput(0);
		assertEquals(0,ss.length);
	}
	
	public void test51() {
		simulation.incrementTime(1);
		resource.acquire(event);
		String[] ss = getOutput(0);
		assertEquals(1,ss.length);
		assertEquals("    1: Event#1",ss[0]);
	}
	
	public void test52() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.release();
		String[] ss = getOutput(0);
		assertEquals(1,ss.length);
		assertEquals("    1: Event#1",ss[0]);
	}
	
	public void test53() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		String[] ss = getOutput(0);
		assertEquals(2,ss.length);
		assertEquals("    3: Event#2",ss[1]);		
	}
	
	public void test54() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		String[] ss = getOutput(0);
		assertEquals(3,ss.length);
		assertEquals("    6: DELAYED: Event#3",ss[2]);
	}
	
	public void test55() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		simulation.incrementTime(4);
		resource.release();
		String[] ss = getOutput(0);
		assertEquals(4,ss.length);
		assertEquals("   10: Event#3",ss[3]);
	}
	
	public void test56() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		simulation.incrementTime(4);
		resource.acquire(event4);
		String[] ss = getOutput(0);
		assertEquals(4,ss.length);
		assertEquals("   10: DELAYED: Event#4",ss[3]);
	}
	
	public void test57() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		simulation.incrementTime(4);
		resource.acquire(event4);
		simulation.incrementTime(5);
		resource.release();
		String[] ss = getOutput(0);
		assertEquals(5,ss.length);
		assertEquals("   15: Event#3",ss[4]);
	}
	
	public void test58() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		simulation.incrementTime(4);
		resource.acquire(event4);
		simulation.incrementTime(5);
		resource.release();
		simulation.incrementTime(6);
		resource.release();
		String[] ss = getOutput(0);
		assertEquals(6,ss.length);
		assertEquals("   21: Event#4",ss[5]);
	}
	
	public void test59() {
		simulation.incrementTime(1);
		resource.acquire(event);
		simulation.incrementTime(2);
		resource.acquire(event2);
		simulation.incrementTime(3);
		resource.acquire(event3);
		simulation.incrementTime(4);
		resource.acquire(event4);
		simulation.incrementTime(5);
		resource.release();
		simulation.incrementTime(6);
		resource.release();
		simulation.incrementTime(7);
		resource.release(); // no one waiting.
		String[] ss = getOutput(0);
		assertEquals(6,ss.length);
		assertEquals("   21: Event#4",ss[5]);
	}
	
	
	/// test6x: miscellaneous tests
	
	public void test60() {
		resource = simulation.new Resource("Test");
		assertEquals(1,resource.getAvailable());
		assertEquals(0,resource.getQueueLength());
	}
	
	public void test61() {
		resource = simulation.new Resource("Test");
		resource.report(outputCollector[1]);
		String[] ss = getOutput(1);
		assertEquals("Resource Test has 1 units available and 0 waiting.",ss[0]);
	}
	
	
	private class MyEvent extends Simulation.Event {
		int runs = 0;
		private final int number;
		private final Runnable runCheck;
		
		public MyEvent(Simulation s, int n, Runnable r) {
			s.super();
			number = n;
			runCheck = r;
		}
		public MyEvent(Simulation s, int n) {
			this(s,n,() -> {});
		}
		
		public int getRuns() {
			return runs;
		}
		
		@Override
		public void run() {
			++runs;
			runCheck.run();
		}
		
		@Override
		public String toString() {
			return "Event#" + number;
		}
	}
}
