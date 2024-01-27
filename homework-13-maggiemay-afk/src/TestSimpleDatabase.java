import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import edu.uwm.apc430.SimpleDatabase;
import edu.uwm.apc430.SimpleSchema;
import edu.uwm.cs.junit.LockedTestCase;


public class TestSimpleDatabase extends LockedTestCase {
    protected static void assertException(Class<? extends Throwable> c, Runnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (RuntimeException ex) {
        	assertTrue("should throw exception of " + c + ", not of " + ex.getClass(), c.isInstance(ex));
        }	
    }	
    
    public static interface IORunnable {
    	public void run() throws IOException;
    }
    
    protected static void assertIOException(IORunnable r) {
    	try {
    		r.run();
    		assertFalse("Exception should have been thrown",true);
        } catch (Exception ex) {
        	assertTrue("should throw exception of IOException, not of " + ex.getClass(), IOException.class.isInstance(ex));
        }
    }

	@Override
	protected void setUp() {
		try {
			assert new SimpleSchema((String)null).size() == 17;
			assertTrue("Assertions not enabled.  Add -ea to VM Args Pane in Arguments tab of Run Configuration",false);
		} catch (NullPointerException ex) {
			assertTrue(true);
		} catch (AssertionError ex) {
			assertTrue(true);
		}
	}

	public static String[] row(String... row) {
		return row;
	}

	private class AbstractTableModelListener implements TableModelListener {
		private boolean eventFound;
		
		protected void assertTrue(String s, boolean b) {
			if (b) {
				if (eventFound) {
					assertFalse("Duplicate event fired for " + s, true);
				}
				eventFound = true;
			} else {
				assertFalse(s,true);
			}
		}
		
		public void tableChanged(TableModelEvent arg0) {
			assertFalse("Unexpected event: " + arg0, true);
		}
		
		public void checkEventFound(String s) {
			assertFalse(s,!eventFound);
		}
		
		public void checkNoEvent() {
			assertFalse("Should not have triggered an event",eventFound);
		}
		
		public void clear(int ignored) {
			eventFound = false;
		}
	}
	
	protected void testWrite(SimpleDatabase db, String contents) {
		StringWriter sw = new StringWriter();
		try {
			db.write(sw);
		} catch (IOException e) {
			assertFalse("write threw exception " + e,true);
		}
		assertEquals(contents,sw.toString());
	}

	
	/// Locked Tests
	
	public void test() {
		SimpleSchema s1 = new SimpleSchema("First:Last");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow("Jason:Thompson");
		db.addRow("Tony:Brown");
		db.addRow("Blake:Martinez");
		
		assertEquals(Ti(981997341),db.getColumnCount());
		assertEquals(Ti(569833380),db.getRowCount());
		assertEquals(Ts(484650593),db.getColumnName(1));
		assertEquals(Ts(164536652),db.getValueAt(1, 1));
		
		db.sort(0,false);
		assertEquals(Ts(1207461924),db.getValueAt(2, 1));
		
		assertEquals(Tb(1167897999),db.removeRow("Jason:Brown"));
		assertEquals(Tb(302587755),db.removeRow("Tony:Brown"));
		assertEquals(Ti(1483090379),db.getRowCount());
	}
	
	
	/// test0x: testing the constructor
	
	public void test01() {
		SimpleSchema s1 = new SimpleSchema("Name","age");
		SimpleDatabase db = new SimpleDatabase(s1);		
		assertSame(s1,db.getSchema());
	}
	
	public void test02() {
		SimpleSchema s1 = new SimpleSchema("Name","age");
		SimpleDatabase db = new SimpleDatabase(s1);
		assertEquals(2,db.getColumnCount());
	}
	
	public void test03() {
		SimpleSchema s1 = new SimpleSchema("Name","age");
		SimpleDatabase db = new SimpleDatabase(s1);
		assertEquals(0,db.getRowCount());
	}
	
	public void test04() {
		SimpleSchema s1 = new SimpleSchema("Name","age");
		SimpleDatabase db = new SimpleDatabase(s1);
		assertEquals("Name",db.getColumnName(0));
	}
	
	public void test05() {
		SimpleSchema s1 = new SimpleSchema("Name","age");
		SimpleDatabase db = new SimpleDatabase(s1);
		assertEquals("age",db.getColumnName(1));
	}
	
	public void test06() {
		SimpleSchema s0 = new SimpleSchema();
		SimpleDatabase db = new SimpleDatabase(s0);

		assertSame(s0,db.getSchema());		
		assertEquals(0,db.getColumnCount());
		assertEquals(0,db.getRowCount());		
	}

	public void test09() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);

		assertSame(s1,db.getSchema());		
		assertEquals(3,db.getColumnCount());
		assertEquals(0,db.getRowCount());
		assertEquals("Name",db.getColumnName(0));
		assertEquals("age",db.getColumnName(1));
		assertEquals("nationality",db.getColumnName(2));		
	}
	
	
	/// test1x: testing a single row
	
	public void test10() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow("John:53:USA");
		assertTrue(true); // addRow didn't crash
	}
	
	public void test11() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","54","USA"));
		assertTrue(true); // addRow didn't crash
	}
	
	public void test12() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow("John:55:USA");
		assertEquals(1,db.getRowCount());
		assertEquals(3,db.getColumnCount());
	}
	
	public void test13() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","56","USA"));
		assertEquals(1,db.getRowCount());
		assertEquals(3,db.getColumnCount());
	}
	
	public void test14() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow("John:57:USA");
		assertEquals("John",db.getValueAt(0, 0));
		assertEquals("57",db.getValueAt(0, 1));
		assertEquals("USA",db.getValueAt(0, 2));
	}
	
	public void test15() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","58","USA"));
		assertEquals("John",db.getValueAt(0, 0));
		assertEquals("58",db.getValueAt(0, 1));
		assertEquals("USA",db.getValueAt(0, 2));
	}
	
	public void test16() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow("John:59:USA");
		String[] row0 = db.getRow(0);
		assertEquals("John",row0[0]);
		assertEquals("59",row0[1]);
		assertEquals("USA",row0[2]);
	}
	
	public void test17() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","60","USA"));
		String[] row0 = db.getRow(0);
		assertEquals("John",row0[0]);
		assertEquals("60",row0[1]);
		assertEquals("USA",row0[2]);
	}
	
	public void test18() {
		SimpleSchema s0 = new SimpleSchema();
		SimpleDatabase db = new SimpleDatabase(s0);

		db.addRow(row());		
		assertEquals(1,db.getRowCount());
		String[] a = db.getRow(0);
		assertEquals(0,a.length);
	}
	
	/// test2X: test listeners and 2 rows
	
	public void test20() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		assertEquals(4,db.getColumnCount());
		assertEquals(0,db.getRowCount());
		assertEquals("Name",db.getColumnName(0));
		assertEquals("age",db.getColumnName(1));
		assertEquals("nationality",db.getColumnName(2));
		
		db.addRow(row("John","61","USA","CompSci"));
		assertEquals(1,db.getRowCount());
		assertEquals(4,db.getColumnCount());
		assertEquals("John",db.getValueAt(0, 0));
		assertEquals("61",db.getValueAt(0, 1));
		assertEquals("CompSci",db.getValueAt(0, 3));
		
		db.addRow("Michael:76:UK:Theology");
		assertEquals(2,db.getRowCount());
		assertEquals(4,db.getColumnCount());
	}
	
	public void test21() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		db.addRow("John:62:USA:CompSci");
		db.addRow(row("Michael","77","UK","Theology"));
		assertEquals("John",db.getValueAt(0, 0));
		assertEquals("62",db.getValueAt(0, 1));
		assertEquals("CompSci",db.getValueAt(0, 3));		
	}
	
	public void test22() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		db.addRow("John:63:USA:CompSci");
		db.addRow(row("Michael","78","UK","Theology"));
		assertEquals("Michael",db.getValueAt(1, 0));
		assertEquals("78",db.getValueAt(1, 1));
		assertEquals("Theology",db.getValueAt(1, 3));		
	}
	
	public void test23() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","64","USA","CompSci"));
		db.addRow("Michael:79:UK:Theology");
		
		String[] row0 = db.getRow(0);
		assertEquals("John",row0[0]);
		assertEquals("64",row0[1]);
		assertEquals("USA",row0[2]);
		assertEquals("CompSci",row0[3]);
		
		String[] row1 = db.getRow(1);
		assertEquals("Michael",row1[0]);
		assertEquals("79",row1[1]);
		assertEquals("UK",row1[2]);
		assertEquals("Theology",row1[3]);
	}
	
	public void test24() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		db.addRow("John:65:USA:CompSci");
		db.addRow(row("Michael","80","UK","Theology"));
		
		String[] row1 = db.getRow(1);
		row1[2] = "USA"; // should not affect the DB
		assertEquals("UK",db.getValueAt(1, 2));
	}
	
	public void test25() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","66","USA","CompSci"));
		
		AbstractTableModelListener l = new AbstractTableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("got change event",true);
			}
		};
		db.addTableModelListener(l);
		
		db.addRow("Michael:81:UK:Theology");
		l.checkEventFound("didn't fire an insert event");		
	}
	
	public void test26() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","67","USA","CompSci"));
		
		AbstractTableModelListener l = new AbstractTableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("Expected INSERT event",arg0.getType() == TableModelEvent.INSERT);
			}
		};
		db.addTableModelListener(l);
		
		db.addRow("Michael:82:UK:Theology");		
	}
	
	public void test27() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","68","USA","CompSci"));
		
		AbstractTableModelListener l = new AbstractTableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("got change event",true);
				assertEquals(1,arg0.getFirstRow());
				assertEquals(1,arg0.getLastRow());
			}
		};
		db.addTableModelListener(l);
		
		db.addRow("Michael:83:UK:Theology");		
	}
	
	public void test28() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		db.addRow(row("John","68","USA","CompSci"));
		
		AbstractTableModelListener l = new AbstractTableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("got change event",true);
				assertEquals(TableModelEvent.ALL_COLUMNS,arg0.getColumn());
			}
		};
		db.addTableModelListener(l);
		
		db.addRow("Michael:83:UK:Theology");
	}
	
	public void test29() {
		SimpleSchema s1 = new SimpleSchema("Name","age","nationality","subject");
		SimpleDatabase db = new SimpleDatabase(s1);
		
		assertEquals(4,db.getColumnCount());
		assertEquals(0,db.getRowCount());
		assertEquals("Name",db.getColumnName(0));
		assertEquals("age",db.getColumnName(1));
		assertEquals("nationality",db.getColumnName(2));
		
		db.addRow(new String[]{"John","69","USA","CompSci"});
		assertEquals(1,db.getRowCount());
		assertEquals(4,db.getColumnCount());
		assertEquals("John",db.getValueAt(0, 0));
		assertEquals("69",db.getValueAt(0, 1));
		assertEquals("CompSci",db.getValueAt(0, 3));
		
		AbstractTableModelListener l = new AbstractTableModelListener() {
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("Expected INSERT event",arg0.getType() == TableModelEvent.INSERT);
				assertEquals(1,arg0.getFirstRow());
				assertEquals(1,arg0.getLastRow());
				assertEquals(TableModelEvent.ALL_COLUMNS,arg0.getColumn());
			}
		};
		db.addTableModelListener(l);
		db.addRow("Michael:84:UK:Theology");
		l.checkEventFound("didn't fire an insert event");

		String[] row0 = db.getRow(0);
		assertEquals("John",row0[0]);
		assertEquals("69",row0[1]);
		assertEquals("USA",row0[2]);
		assertEquals("CompSci",row0[3]);
		
		String[] row1 = db.getRow(1);
		assertEquals("Michael",row1[0]);
		assertEquals("84",row1[1]);
		assertEquals("UK",row1[2]);
		assertEquals("Theology",row1[3]);
	}
	
	public void test30() {
		SimpleSchema s = new SimpleSchema("R:G:B:Name");
		SimpleDatabase db = new SimpleDatabase(s);
		
		assertEquals(4,db.getColumnCount());
		assertEquals(0,db.getRowCount());
		assertEquals("R",db.getColumnName(0));
		assertEquals("G",db.getColumnName(1));
		assertEquals("B",db.getColumnName(2));
		assertEquals("Name",db.getColumnName(3));
	
		AbstractTableModelListener l = new AbstractTableModelListener() {
			private int row;
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("Expected INSERT event",arg0.getType() == TableModelEvent.INSERT);
				assertEquals(row,arg0.getFirstRow());
				assertEquals(row,arg0.getLastRow());
				assertEquals(TableModelEvent.ALL_COLUMNS,arg0.getColumn());
			}
			@Override
			public void clear(int r) {
				row = r;
				super.clear(r);
			}
		};
		
		db.addTableModelListener(l);
		
		l.clear(0);
		db.addRow("ff:ff:ff:white");
		l.checkEventFound("didn't fire an insert event");
		
		l.clear(1);
		db.addRow(new String[] {"00","00","00","black"});
		l.checkEventFound("didn't fire an insert event");
		
		l.clear(2);
		db.addRow(new String[] {"ff","ff","00","yellow"});
		l.checkEventFound("didn't fire an insert event");
	}
	
	
	/// test4X: reading
	
	public void test40() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertTrue(db != null);
	}
	
	public void test41() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals(3,db.getColumnCount());
	}
	
	public void test42() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals(3,db.getRowCount());
	}
	
	public void test43() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals("name",db.getColumnName(0));
		assertEquals("course",db.getColumnName(1));
		assertEquals("credits",db.getColumnName(2));
	}
	
	public void test44() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals(new SimpleSchema(row("name","course","credits")),db.getSchema());
	}
	
	public void test45() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals("Boyland",db.getValueAt(0, 0));
		assertEquals("APC 430",db.getValueAt(0, 1));
		assertEquals("3",db.getValueAt(0, 2));
	}
	
	public void test46() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals("Rock",db.getValueAt(1, 0));
		assertEquals("APC 450",db.getValueAt(1, 1));
		assertEquals("3",db.getValueAt(1, 2));
	}
	
	public void test47() {
		StringReader sr = new StringReader("name:course:credits\nBoyland:APC 430:3\nRock:APC 450:3\nZhao:APC 420:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals("Zhao",db.getValueAt(2, 0));
		assertEquals("APC 420",db.getValueAt(2, 1));
		assertEquals("3",db.getValueAt(2, 2));
	}
	
	public void test48() {
		StringReader sr = new StringReader("name:course:title:credits\n"+
				"Rock:APC 450:Operating Systems Theory and Practice:3\n"+
				"Xu:APC 480:Computer Security II:3\n"+
				"Zhao:APC 420:Computer Security I:3\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals(4,db.getColumnCount());
		assertEquals(3,db.getRowCount());
		assertEquals("title",db.getColumnName(2));
		assertEquals("APC 450",db.getValueAt(0, 1));
		assertEquals("Xu",db.getValueAt(1, 0));
		assertEquals("Zhao",db.getValueAt(2, 0));
	}
	
	public void test49() {
		StringReader sr = new StringReader("month\nJanuary\nFebruary\n");
		SimpleDatabase db;
		try {
			db = SimpleDatabase.read(new BufferedReader(sr));
		} catch (IOException e) {
			assertFalse("threw exception: " + e.toString(),true);
			return;
		}
		assertEquals(1,db.getColumnCount());
		assertEquals(2,db.getRowCount());
		assertEquals("month",db.getColumnName(0));
		assertEquals("February",db.getValueAt(1, 0));
	}
	
	
	/// test5X: test write
	
	public void test50() {
		SimpleDatabase db = new SimpleDatabase(new SimpleSchema("Name"));
		db.addRow("Pat");
		db.addRow("Sandy");
		db.addRow("Chris");
		testWrite(db,"Name\nPat\nSandy\nChris\n");
	}
	
	public void test51() {
		SimpleSchema sc = new SimpleSchema("Name","R","G","B");
		SimpleDatabase db = new SimpleDatabase(sc);
		db.addRow("Yellow:ff:ff:00");
		db.addRow("White:ff:ff:ff");
		testWrite(db,"Name:R:G:B\nYellow:ff:ff:00\nWhite:ff:ff:ff\n");
	}
	
	
	/// Mascot DB (used in many later tests)
	
	protected SimpleDatabase db;
	protected AbstractTableModelListener listener;
	
	protected void setupMascots() {
		SimpleSchema ss = new SimpleSchema("name:mascot:color(s)");
		db = new SimpleDatabase(ss);
		db.addRow("UWM:Panthers:black & gold");
		db.addRow("UWO:Titans:black & gold");
		db.addRow("UWP:Pioneers:orange & blue");
		db.addRow("UWRF:Falcons:red & white");
		db.addRow(row("UWSP","Pointers","purple & gold"));
		assertEquals(5,db.getRowCount()); // other things must be working!
		listener = new AbstractTableModelListener() {
			private int row;
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("Expected DELETE event",arg0.getType() == TableModelEvent.DELETE);
				assertEquals(row,arg0.getFirstRow());
				assertEquals(row,arg0.getLastRow());
				assertEquals(TableModelEvent.ALL_COLUMNS,arg0.getColumn());
			}
			@Override
			public void clear(int r) {
				row = r;
				super.clear(r);
			}
		};
		db.addTableModelListener(listener);
	}
	
	
	/// test6X: test ineffective remove
	
	public void test60() {
		setupMascots();
		db.removeRow("UWM:Panthers");
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test61() {
		setupMascots();
		db.removeRow("UWM:Panthers:black & gold:Milwaukee");
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test62() {
		setupMascots();
		db.removeRow("UW:Panthers:black & gold");
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test63() {
		setupMascots();
		db.removeRow("UWM:Panther:black & gold");
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test64() {
		setupMascots();
		db.removeRow("UWM:Panthers:black & gold & white");
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test65() {
		setupMascots();
		db.removeRow(row("UWM","Panthers"));
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test66() {
		setupMascots();
		db.removeRow(row("UWM","Panthers","black & gold","Milwaukee"));
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test67() {
		setupMascots();
		db.removeRow(row("UW","Panthers","black & gold"));
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test68() {
		setupMascots();
		db.removeRow(row("UWM","Panther","black & gold"));
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	public void test69() {
		setupMascots();
		db.removeRow(row("UWM","Panthers","black & gold & white"));
		assertEquals(5,db.getRowCount());
		listener.checkNoEvent();
	}
	
	
	/// test7X: testing working remove
	
	public void test70() {
		setupMascots();
		listener.clear(0);
		assertTrue(db.removeRow("UWM:Panthers:black & gold"));
	}
	
	public void test71() {
		setupMascots();
		listener.clear(1);
		db.removeRow(row("UWO","Titans","black & gold"));
		assertEquals(4,db.getRowCount());
	}
	
	public void test72() {
		setupMascots();
		listener.clear(2);
		db.removeRow("UWP:Pioneers:orange & blue");
		assertEquals("UWRF",db.getValueAt(2, 0));
	}
	
	public void test73() {
		setupMascots();
		listener.clear(3);
		db.removeRow(row("UWRF","Falcons","red & white"));
		listener.checkEventFound("should have deleted UWRF(row 3)");;
	}
	
	public void test74() {
		setupMascots();
		listener.clear(4);
		db.removeRow("UWSP:Pointers:purple & gold");
		assertFalse(db.removeRow(row("UWSP","Pointers","purple & gold")));
		assertEquals(4,db.getRowCount());
	}
	
	public void test75() {
		setupMascots();
		listener.clear(2);
		db.removeRow(row("UWP","Pioneers","orange & blue"));
		listener.clear(0);
		assertTrue(db.removeRow(row("UWM","Panthers","black & gold")));
		listener.checkEventFound("should have deleted UWM(row 0)");
		assertEquals(3,db.getRowCount());
	}
	
	public void test76() {
		setupMascots();
		listener.clear(1);
		db.removeRow("UWO:Titans:black & gold");
		listener.clear(2);
		db.removeRow("UWRF:Falcons:red & white");
		listener.checkEventFound("should have deleted UWRF(row 3->2)");
		assertEquals(3,db.getRowCount());
	}
	
	public void test77() {
		setupMascots();
		listener.clear(4);
		db.removeRow(row("UWSP","Pointers","purple & gold"));
		listener.clear(2);
		db.removeRow("UWP:Pioneers:orange & blue");
		listener.clear(0);
		assertTrue(db.removeRow("UWM:Panthers:black & gold"));
		listener.checkEventFound("should have deleted UWM(row 0)");
		assertEquals(2,db.getRowCount());
		assertFalse(db.removeRow(row("UWP","Pioneers","orange & blue")));
		assertEquals("Titans",db.getValueAt(0, 1));
		assertEquals("UWRF",db.getValueAt(1, 0));
	}
	
	public void test78() {
		setupMascots();
		listener.clear(1);
		assertTrue(db.removeRow("UWO:Titans:black & gold"));
		listener.clear(1);
		assertTrue(db.removeRow("UWP:Pioneers:orange & blue"));
		listener.clear(1);
		assertTrue(db.removeRow("UWRF:Falcons:red & white"));
		listener.clear(1);
		assertTrue(db.removeRow("UWSP:Pointers:purple & gold"));
		listener.checkEventFound("should have deleted all but UWM");
		assertEquals(1,db.getRowCount());
		assertEquals("Panthers",db.getValueAt(0, 1));
	}
	
	public void test79() {
		SimpleSchema s0 = new SimpleSchema();
		db = new SimpleDatabase(s0);
		db.addRow(row());
		db.addRow(row());
		assertTrue(db.removeRow(row()));
		assertEquals(1,db.getRowCount());
	}
	
	
	/// artificial DB
	
	public void setupArtificial() {
		SimpleSchema s = new SimpleSchema("U:#:l");
		db = new SimpleDatabase(s);
		
		db.addRow("A:1:y");
		db.addRow("B:3:x");
		db.addRow("C:2:z");
		
		testWrite(db,"U:#:l\nA:1:y\nB:3:x\nC:2:z\n");
	}
	
	
	/// test8x: sort tests
	
	public void test80() {
		setupArtificial(); // if you don't pass this, don't bother with the rest!
	}
	
	public void test81() {
		setupArtificial();
		
		db.sort(0, false);
		testWrite(db,"U:#:l\nC:2:z\nB:3:x\nA:1:y\n");
	}
	
	public void test82() {
		setupArtificial();

		db.sort(0, true);
		testWrite(db,"U:#:l\nA:1:y\nB:3:x\nC:2:z\n");
	}
	
	public void test83() {
		setupArtificial();
		
		db.sort(1,false);
		testWrite(db,"U:#:l\nB:3:x\nC:2:z\nA:1:y\n");
	}
	
	public void test84() {
		setupArtificial();

		db.sort(1,true);
		testWrite(db,"U:#:l\nA:1:y\nC:2:z\nB:3:x\n");		
	}
	
	public void test85() {
		setupArtificial();

		db.sort(2, false);
		testWrite(db,"U:#:l\nC:2:z\nA:1:y\nB:3:x\n");
	}
	
	public void test86() {
		setupArtificial();

		db.sort(2, true);
		testWrite(db,"U:#:l\nB:3:x\nA:1:y\nC:2:z\n");		
	}
	
	public void test87() {
		setupArtificial();
		listener = new AbstractTableModelListener() {
			private int row;
			@Override
			public void tableChanged(TableModelEvent arg0) {
				assertTrue("Expected UPDATE event",arg0.getType() == TableModelEvent.UPDATE);
				assertEquals(0,arg0.getFirstRow());
				assertEquals(row,arg0.getLastRow());
				assertEquals(TableModelEvent.ALL_COLUMNS,arg0.getColumn());
			}
			@Override
			public void clear(int r) {
				row = r;
				super.clear(r);
			}
		};
		db.addTableModelListener(listener);
		listener.clear(2);
		db.sort(0, false);
		testWrite(db,"U:#:l\nC:2:z\nB:3:x\nA:1:y\n");
		listener.checkEventFound("no update event fired");
	}
	
	
	/// test9X: error testing
	
	public void test90() {
		assertException(NullPointerException.class, () -> new SimpleDatabase(null));
	}
	
	public void test91() {
		db = new SimpleDatabase(new SimpleSchema("first:last"));
		assertException(NullPointerException.class, () -> db.addRow((String[])null));
	}
	
	public void test92() {
		db = new SimpleDatabase(new SimpleSchema("first:last"));
		assertException(IllegalArgumentException.class,() -> db.addRow("one"));
		assertException(IllegalArgumentException.class,() -> db.addRow(row("one")));
	}
	
	public void test93() {
		db = new SimpleDatabase(new SimpleSchema("first:last"));
		assertException(IllegalArgumentException.class,() -> db.addRow("one:two:three"));
		assertException(IllegalArgumentException.class,() -> db.addRow(row("one","two","three")));
	}
	
	public void test94() {
		db = new SimpleDatabase(new SimpleSchema("first:last"));
		assertException(IllegalArgumentException.class,() -> db.addRow(row("one:two","three")));
		assertException(IllegalArgumentException.class,() -> db.addRow(row("one","two:three")));		
	}
	
	public void test95() {
		db = new SimpleDatabase(new SimpleSchema("first:last"));
		assertException(IllegalArgumentException.class,() -> db.addRow(row("one\ntwo","three")));
		assertException(IllegalArgumentException.class,() -> db.addRow(row("one","two\nthree")));		
	}
	
	public void test96() {
		StringReader sr = new StringReader("first:last\nJohn:Boyland\nChristoff\n");
		assertIOException(() -> SimpleDatabase.read(new BufferedReader(sr)));
	}
	
	public void test97() {
		StringReader sr = new StringReader("first:last\nJohn:Boyland\nHarry:S:Truman\n");
		assertIOException(() -> SimpleDatabase.read(new BufferedReader(sr)));		
	}
	
}
