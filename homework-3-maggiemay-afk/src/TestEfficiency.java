import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.uwm.apc430.Ball;
import edu.uwm.apc430.BallSeq;
import edu.uwm.apc430.Point;
import edu.uwm.apc430.Vector;
import junit.framework.TestCase;


public class TestEfficiency extends TestCase {

	Ball p1 = new Ball(new Point(0,0), new Vector(), Color.BLACK);
	Ball p2 = new Ball(new Point(100,0), new Vector(10,0), Color.BLUE);
	Ball p3 = new Ball(new Point(100,100), new Vector(), Color.GREEN);
	Ball p4 = new Ball(new Point(0,-100), new Vector(10,20), Color.YELLOW);
	Ball p5 = new Ball(new Point(0,100), new Vector(0,-10), Color.RED);
	Ball p6 = new Ball(new Point(66,0), new Vector(6,0), Color.CYAN);
	Ball p7 = new Ball(new Point(0,-707), new Vector(7,11), Color.GRAY);
	Ball p8 = new Ball(new Point(88,88), new Vector(8,8), Color.WHITE);

	Ball p[] = {null, p1, p2, p3, p4, p5, p6, p7, p8};
	
	BallSeq s;
	Random r;
	
	@Override
	public void setUp() {
		s = new BallSeq();
		r = new Random();
		try {
			assert 1/(int)(p5.getLoc().x()) == 42 : "OK";
			assertTrue(true);
		} catch (ArithmeticException ex) {
			System.err.println("Go To Run > Run Configurations... and the Arguments tab.");
			System.err.println("Then remove '-ea' from the VM Arguments box.");
			assertFalse("Assertions must NOT be enabled while running efficiency tests.",true);
		}
	}

	private static final int MAX_LENGTH = 1000000;
	private static final int SAMPLE = 100;
	
	public void testLong() {
		for (int i=0; i < MAX_LENGTH; ++i) {
			s.addAfter(p[i%6]);
			s.advance();
		}
		
		int sum = 0;
		s.start();
		for (int j=0; j < SAMPLE; ++j) {
			int n = r.nextInt(MAX_LENGTH/SAMPLE);
			for (int i=0; i < n; ++i) {
				s.advance();
			}
			sum += n;
			assertSame(p[sum%6],s.getCurrent());
		}
	}
	
	private static final int MAX_WIDTH = 100000;
	
	public void testWide() {
		BallSeq[] a = new BallSeq[MAX_WIDTH];
		for (int i=0; i < MAX_WIDTH; ++i) {
			a[i] = s = new BallSeq();
			int n = r.nextInt(SAMPLE);
			for (int j=0; j < n; ++j) {
				s.addAfter(p[j%6]);
				s.advance();
			}
		}
		
		for (int j = 0; j < SAMPLE; ++j) {
			int i = r.nextInt(a.length);
			s = a[i];
			if (s.size() == 0) continue;
			int n = r.nextInt(s.size());
			s.start();
			for (int k=0; k < n; ++k) {
				s.advance();
			}
			assertSame(p[n%6],s.getCurrent());
		}
	}
	
	public void testStochastic() {
		List<BallSeq> ss = new ArrayList<BallSeq>();
		ss.add(s);
		int max = 1;
		for (int i=0; i < MAX_LENGTH; ++i) {
			if (r.nextBoolean()) {
				s = new BallSeq();
				s.addBefore(p3);
				ss.add(s);
			} else {
				s.addAll(s); // double size of s
				if (s.size() > max) {
					max = s.size();
					// System.out.println("Reached " + max);
				}
			}
		}
	}
}
