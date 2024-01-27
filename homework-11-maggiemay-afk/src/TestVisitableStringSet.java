import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.uwm.apc430.VisitableStringSet;
import edu.uwm.cs.junit.LockedTestCase;


public class TestVisitableStringSet extends LockedTestCase {
    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	

	private void assertDone(Iterator<?> it) {
		if (it.hasNext()) {
			Object x = it.next();
			assertFalse("Iterator should be done, but still had " + x, true);
		}
	}
	
	private VisitableStringSet set = new VisitableStringSet();
	
	private List<String> list = new ArrayList<>();
	VisitableStringSet.Visitor intoList = (s) -> { list.add(s); return true; };
	
	@Override
	protected void setUp() {
		try {
			assert 42/list.size() < 15;
			System.out.println("Go to Run > Run Configurations.");
			System.out.println("Open the Arguments tab and put -ea in the VM arguments Box.");
			assertFalse("Must assert exceptions to run test",true);
		} catch (ArithmeticException ex) {
			// OK!
		}
		set = new VisitableStringSet();
		list.clear();
	}
	
	
	/// Locked tests
	
	public void test() {
		assertEquals(Tb(856650111),set.add("hello"));
		assertEquals(Tb(1816614951),set.add("hello"));
		assertEquals(Ti(1853559662),set.size());
		assertEquals(true,set.add("world"));
		assertEquals(true,set.add("WORLD"));
		assertEquals(Ti(524803930),set.size());
		
		// now we put all the elements into a list:
		set.accept(intoList);
		
		// Remember that UPPERCASE letters come before lowercase letters
		assertEquals(Ts(2060240187),list.get(0));
		
		// Remember that returning "true" means "keep this element"
		set.accept((s) -> !s.equals("hello"));
		
		list.clear(); // start fresh
		set.accept(intoList); // put all into list
		assertEquals(Ti(893621976),list.size()); // how many after possible removal
		
		assertEquals(Ts(512006538),list.get(1));
	}

	
	/// test0X: tests with the empty set
	
	public void test00() {
		assertEquals(0,set.size());
	}
	
	public void test01() {
		set.accept((s) -> { throw new IllegalStateException("should not be called");} ); 
	}
	
	public void test02() {
		assertException(NullPointerException.class,() -> set.add(null));
	}
	
	
	/// test1X: tests of add ing one element
	
	public void test10() {
		assertTrue(set.add("hello"));
	}
	
	public void test11() {
		set.add("Wisconsin");
		assertEquals(1,set.size());
	}
	
	public void test12() {
		set.add("USA");
		assertFalse(set.add("USA"));
	}
	
	public void test13() {
		set.add("Milwaukee");
		set.add("Milwaukee");
		assertEquals(1,set.size());
	}
	
	public void test14() {
		set.add("Oshkosh");
		assertException(NullPointerException.class,() -> set.add(null));
	}
	
	public void test15() {
		set.add("Platteville");
		set.accept(intoList);
		assertEquals(1,list.size());
	}
	
	public void test16() {
		set.add("River Falls");
		set.accept(intoList);
		assertEquals("River Falls",list.get(0));
	}
	
	public void test17() {
		set.add("Stevens Point");
		set.add("Stevens Point");
		set.accept(intoList);
		assertEquals(1,list.size());
	}
	
	
	/// test2X: tests of adding 2 items
	
	public void test20() {
		set.add("apples");
		assertTrue(set.add("bread"));
	}
	
	public void test21() {
		set.add("cheese");
		set.add("apples");
		assertEquals(2,set.size());
	}
	
	public void test22() {
		set.add("eggs");
		set.add("bread");
		assertFalse(set.add("bread"));
	}
	
	public void test23() {
		set.add("carrots");
		set.add("celery");
		assertFalse(set.add("celery"));
	}
	
	public void test24() {
		set.add("fish");
		set.add("bacon");
		set.add("fish");
		set.add("bacon");
		assertEquals(2,set.size());
	}
	
	public void test25() {
		set.add("apples");
		set.add("oranges");
		set.accept(intoList);
		assertEquals(2,list.size());
	}
	
	public void test26() {
		set.add("bread");
		set.add("coffee");
		set.accept(intoList);
		assertEquals("bread",list.get(0));
	}
	
	public void test27() {
		set.add("cherries");
		set.add("cheese");
		set.accept(intoList);
		assertEquals("cheese",list.get(0));
	}
	
	public void test28() {
		set.add("grapes");
		set.add("apricots");
		set.accept(intoList);
		assertEquals("grapes",list.get(1));
	}
	
	
	/// test3X: tests of 3 items
	
	public void test30() {
		set.add("Milwaukee");
		set.add("Oshkosh");
		assertTrue(set.add("River Falls"));
	}
	
	public void test31() {
		set.add("Madison");
		set.add("Platteville");
		set.add("Stevens Point");
		assertEquals(3,set.size());
	}
	
	public void test32() {
		set.add("Huron");
		set.add("Michigan");
		set.add("Superior");
		assertFalse(set.add("Superior"));
	}
	
	public void test33() {
		set.add("Platteville");
		set.add("Madison");
		assertTrue(set.add("Steves Point"));
	}
	
	public void test34() {
		set.add("Oshkosh");
		set.add("River Falls");
		set.add("Milwaukee");
		assertEquals(3,set.size());
	}
	
	public void test35() {
		set.add("Michigan");
		set.add("Huron");
		set.add("Superior");
		assertFalse(set.add("Superior"));
		assertFalse(set.add("Huron"));
	}
	
	public void test36() {
		set.add("River Falls");
		set.add("Oshkosh");
		assertTrue(set.add("Madison"));
		assertEquals(3,set.size());
		assertFalse(set.add("Madison"));
	}
	
	public void test37() {
		set.add("Huron");
		set.add("Michigan");
		set.add("Superior");
		set.accept(intoList);
		assertEquals("Huron",list.get(0));
		assertEquals("Michigan",list.get(1));
		assertEquals("Superior",list.get(2));
		assertEquals(3,list.size());
	}
	
	public void test38() {
		set.add("Portage");
		set.add("Winnebago");
		set.add("Pierce");
		set.accept(intoList);
		assertEquals("Pierce",list.get(0));
		assertEquals("Portage",list.get(1));
		assertEquals("Winnebago",list.get(2));
		assertEquals(3,list.size());
	}
	
	public void test39() {
		set.add("Milwaukee");
		set.add("Grant");
		set.add("Dane");
		set.accept(intoList);
		assertEquals("Dane",list.get(0));
		assertEquals("Grant",list.get(1));
		assertEquals("Milwaukee",list.get(2));
		assertEquals(3,list.size());
	}
	
	
	/// test4X: tests of 4 or more items
	
	public void test40() {
		set.add("2");
		set.add("1");
		set.add("3");
		assertTrue(set.add("4"));
		assertFalse(set.add("1"));
		assertFalse(set.add("2"));
		assertFalse(set.add("3"));
		assertEquals(4,set.size());
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		assertEquals("1",it.next());
		assertEquals("2",it.next());
		assertEquals("3",it.next());
		assertEquals("4",it.next());
		assertDone(it);
	}
	
	public void test41() {
		assertTrue(set.add("green"));
		assertTrue(set.add("yellow"));
		assertTrue(set.add("black"));
		assertTrue(set.add("blue"));
		assertTrue(set.add("red"));
		assertEquals(5,set.size());
		assertFalse(set.add("green"));
		assertFalse(set.add("yellow"));
		assertFalse(set.add("black"));
		assertFalse(set.add("blue"));
		assertFalse(set.add("red"));
		assertEquals(5,set.size());
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		assertEquals("black",it.next());
		assertEquals("blue",it.next());
		assertEquals("green",it.next());
		assertEquals("red",it.next());
		assertEquals("yellow",it.next());
		assertDone(it);
	}
	
	public void test42() {
		assertTrue(set.add("Milwaukee"));
		assertTrue(set.add("Oshkosh"));
		assertTrue(set.add("River Falls"));
		assertTrue(set.add("Platteville"));
		assertTrue(set.add("Stevens Point"));
		assertTrue(set.add("Madison"));
		assertEquals(6,set.size());
		assertFalse(set.add("Milwaukee"));
		assertFalse(set.add("Oshkosh"));
		assertFalse(set.add("River Falls"));
		assertFalse(set.add("Platteville"));
		assertFalse(set.add("Stevens Point"));
		assertFalse(set.add("Madison"));
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		assertEquals("Madison",it.next());
		assertEquals("Milwaukee",it.next());
		assertEquals("Oshkosh",it.next());
		assertEquals("Platteville",it.next());
		assertEquals("River Falls",it.next());
		assertEquals("Stevens Point",it.next());
		assertDone(it);
	}
	
	public void test43() {
		assertTrue(set.add("Monday"));
		assertTrue(set.add("Tuesday"));
		assertTrue(set.add("Wednesday"));
		assertTrue(set.add("Thursday"));
		assertTrue(set.add("Friday"));
		assertTrue(set.add("Saturday"));
		assertTrue(set.add("Sunday"));
		assertEquals(7,set.size());
		assertFalse(set.add("Monday"));
		assertFalse(set.add("Tuesday"));
		assertFalse(set.add("Wednesday"));
		assertFalse(set.add("Thursday"));
		assertFalse(set.add("Friday"));
		assertFalse(set.add("Saturday"));
		assertFalse(set.add("Sunday"));
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		assertEquals("Friday",it.next());
		assertEquals("Monday",it.next());
		assertEquals("Saturday",it.next());
		assertEquals("Sunday",it.next());
		assertEquals("Thursday",it.next());
		assertEquals("Tuesday",it.next());
		assertEquals("Wednesday",it.next());
		assertDone(it);
	}
	
	public void test48() {
		assertTrue(set.add("January"));
		assertTrue(set.add("February"));
		assertTrue(set.add("March"));
		assertTrue(set.add("April"));
		assertTrue(set.add("May"));
		assertTrue(set.add("June"));
		assertTrue(set.add("July"));
		assertTrue(set.add("August"));
		assertTrue(set.add("September"));
		assertTrue(set.add("October"));
		assertTrue(set.add("November"));
		assertTrue(set.add("December"));
		assertFalse(set.add("January"));
		assertFalse(set.add("February"));
		assertFalse(set.add("March"));
		assertFalse(set.add("April"));
		assertFalse(set.add("May"));
		assertFalse(set.add("June"));
		assertFalse(set.add("July"));
		assertFalse(set.add("August"));
		assertFalse(set.add("September"));
		assertFalse(set.add("October"));
		assertFalse(set.add("November"));
		assertFalse(set.add("December"));
		assertEquals(12,set.size());
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		assertEquals("April",it.next());
		assertEquals("August",it.next());
		assertEquals("December",it.next());
		assertEquals("February",it.next());
		assertEquals("January",it.next());
		assertEquals("July",it.next());
		assertEquals("June",it.next());
		assertEquals("March",it.next());
		assertEquals("May",it.next());
		assertEquals("November",it.next());
		assertEquals("October",it.next());
		assertEquals("September",it.next());
		assertDone(it);
	}
	
	
	/// test5X: removal from small sets
	
	public void test50() {
		set.add("Milwaukee");
		set.accept((s) -> false);
		assertEquals(0,set.size());
		assertTrue(set.add("Milwaukee"));
	}
	
	public void test51() {
		set.add("Mississippi");
		set.add("Fox");
		set.accept((s) -> s.equals("Fox"));
		assertEquals(1,set.size());
		assertFalse(set.add("Fox"));
		assertTrue(set.add("Milwaukee"));
	}
	
	public void test52() {
		set.add("Wisconsin");
		set.add("Kinnickinnic");
		set.accept((s)->s.equals("Wisconsin"));
		assertEquals(1,set.size());
		assertFalse(set.add("Wisconsin"));
		assertTrue(set.add("Kinnickinnic"));
	}
	
	public void test53() {
		set.add("Menominee");
		set.add("Kinnickinnic");
		set.accept((s) -> false);
		assertEquals(0,set.size());
	}
	
	public void test54() {
		set.add("Milwaukee");
		set.add("Fox");
		set.add("Wisconsin");
		set.accept((s) -> !s.equals("Milwaukee"));
		assertEquals(2,set.size());
		assertTrue(set.add("Milwaukee"));
	}
	
	public void test55() {
		set.add("Kinnickinnic");
		set.add("St Croix");
		set.add("Fox");
		set.accept((s)->s.equals("Kinnickinnic"));
		assertEquals(1,set.size());
		assertFalse(set.add("Kinnickinnic"));
	}
	
	public void test56() {
		set.add("Milwaukee");
		set.add("Wisconsin");
		set.add("Fox");
		set.add("Kinnickinnic");
		set.add("Mississippi");
		set.accept((s)->false);
		assertEquals(0,set.size());
	}
	
	public void test57() {
		set.add("Milwaukee");
		set.add("Wisconsin");
		set.add("Fox");
		set.add("Kinnickinnic");
		set.add("Mississippi");
		set.accept((s)->!s.equals("Milwaukee"));
		assertEquals(4,set.size());
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		assertEquals("Fox",it.next());
		assertEquals("Kinnickinnic",it.next());
		assertEquals("Mississippi",it.next());
		assertEquals("Wisconsin",it.next());
		assertDone(it);
	}
	
	
	/// test6X: tests removing a single element from a big tree
	
	private void makeBig() {
		// (((1)2(((3(4))5)6((7(8))9)))10((11)12(13)))
		set.add("10");
		set.add("02");
		set.add("01");
		set.add("06");
		set.add("05");
		set.add("03");
		set.add("04");
		set.add("09");
		set.add("07");
		set.add("08");
		set.add("12");
		set.add("11");
		set.add("13");
	}
	
	private void checkContents(String... elems) {
		set.accept(intoList);
		Iterator<String> it = list.iterator();
		for (int i=0; i < elems.length; ++i) {
			assertEquals(elems[i],it.next());
		}
		assertDone(it);
	}
	
	public void test60() {
		makeBig();
		set.accept((s) -> !s.equals("01"));
		checkContents("02","03","04","05","06","07","08","09","10","11","12","13");
	}
	
	public void test61() {
		makeBig();
		set.accept((s) -> !s.equals("02"));
		checkContents("01","03","04","05","06","07","08","09","10","11","12","13");
	}
	
	public void test62() {
		makeBig();
		set.accept((s) -> !s.equals("03"));
		checkContents("01","02","04","05","06","07","08","09","10","11","12","13");
	}
	
	public void test63() {
		makeBig();
		set.accept((s) -> !s.equals("05"));
		checkContents("01","02","03","04","06","07","08","09","10","11","12","13");
	}
	
	public void test64() {
		makeBig();
		set.accept((s) -> !s.equals("06"));
		checkContents("01","02","03","04","05","07","08","09","10","11","12","13");
	}
	
	public void test65() {
		makeBig();
		set.accept((s) -> !s.equals("07"));
		checkContents("01","02","03","04","05","06","08","09","10","11","12","13");
	}
	
	public void test66() {
		makeBig();
		set.accept((s) -> !s.equals("09"));
		checkContents("01","02","03","04","05","06","07","08","10","11","12","13");
	}
	
	public void test67() {
		makeBig();
		set.accept((s) -> !s.equals("10"));
		checkContents("01","02","03","04","05","06","07","08","09","11","12","13");
	}
	
	public void test68() {
		makeBig();
		set.accept((s) -> !s.equals("12"));
		checkContents("01","02","03","04","05","06","07","08","09","10","11","13");
	}
	
	public void test69() {
		makeBig();
		set.accept((s) -> !s.equals("13"));
		checkContents("01","02","03","04","05","06","07","08","09","10","11","12");
	}
	
	
	/// test7X: removing multiple elements at a time.
	
	public void test70() {
		makeBig();
		set.accept((s) -> s.compareTo("05") <= 0);
		checkContents("01","02","03","04","05");
	}
	
	public void test71() {
		makeBig();
		set.accept((s) -> s.compareTo("10") <= 0);
		checkContents("01","02","03","04","05","06","07","08","09","10");
	}
	
	public void test72() {
		makeBig();
		set.accept((s) -> s.compareTo("05") >= 0);
		checkContents("05","06","07","08","09","10","11","12","13");
	}
	
	public void test73() {
		makeBig();
		set.accept((s) -> s.compareTo("10") >= 0);
		checkContents("10","11","12","13");		
	}
	
	public void test74() {
		makeBig();
		set.accept((s) -> (Integer.parseInt(s) % 2) == 0);
		checkContents("02","04","06","08","10","12");
	}
	
	public void test75() {
		makeBig();
		set.accept((s) -> (Integer.parseInt(s) % 2) == 1);
		checkContents("01","03","05","07","09","11","13");
	}
	
	public void test79() {
		makeBig();
		set.accept((s) -> false);
		assertEquals(0,set.size());
	}
	
	
	/// test8X: all but on element removed
	
	public void test80() {
		makeBig();
		set.accept((s) -> s.equals("01"));
		checkContents("01");
	}
	
	public void test81() {
		makeBig();
		set.accept((s) -> s.equals("02"));
		checkContents("02");
	}
	
	public void test82() {
		makeBig();
		set.accept((s) -> s.equals("03"));
		checkContents("03");
	}
	
	public void test83() {
		makeBig();
		set.accept((s) -> s.equals("04"));
		checkContents("04");
	}
	
	public void test84() {
		makeBig();
		set.accept((s) -> s.equals("05"));
		checkContents("05");
	}
	
	public void test85() {
		makeBig();
		set.accept((s) -> s.equals("07"));
		checkContents("07");
	}
	
	public void test86() {
		makeBig();
		set.accept((s) -> s.equals("08"));
		checkContents("08");
	}
	
	public void test87() {
		makeBig();
		set.accept((s) -> s.equals("09"));
		checkContents("09");
	}
	
	public void test88() {
		makeBig();
		set.accept((s) -> s.equals("11"));
		checkContents("11");
	}
	
	public void test89() {
		makeBig();
		set.accept((s) -> s.equals("13"));
		checkContents("13");
	}
	
	
	/// test9X: weird tests
	
	public void test95() {
		set.add("0");
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.add("6");
		set.add("7");
		set.add("8");
		set.add("9");
		set.accept((s) -> !s.equals("5"));
		checkContents("0","1","2","3","4","6","7","8","9");
	}
}
