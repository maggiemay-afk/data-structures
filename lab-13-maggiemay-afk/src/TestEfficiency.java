import edu.uwm.apc430.util.MergeSort;
import junit.framework.TestCase;


public class TestEfficiency extends TestCase {
   
	String[] input;
	
	@Override
	protected void setUp() {
		try {
			assert 1/input.length == 42 : "OK";
			// OK, the assertion didn't fail
		} catch (NullPointerException ex) {
			System.err.println("Assertions must be disabled to use this test suite.");
			System.err.println("In Eclipse: remove -ea from the VM Arguments box under Run>Run Configurations>Arguments");
			assertFalse("Assertions must be disabled in the Run Configuration>Arguments>VM Arguments",true);
		}
	}
		
	private void create(int power) {
		int size = 1 << power;
		input = new String[size];
		for (int i=0; i < size; ++i) {
			input[i] = "" + i;
		}
	}
	
	public void test00() {
		create(0);
		input = MergeSort.sort(input);
		assertEquals(1,input.length);
		assertEquals("0",input[0]);
	}
	
	public void test01() {
		create(1);
		input = MergeSort.sort(input);
		assertEquals(2,input.length);
		assertEquals("0",input[0]);
		assertEquals("1",input[1]);
	}
	
	public void test02() {
		create(2);
		input = MergeSort.sort(input);
		assertEquals(4,input.length);
		assertEquals("0",input[0]);
		assertEquals("1",input[1]);
		assertEquals("2",input[2]);
		assertEquals("3",input[3]);
	}
	
	public void test03() {
		create(3);
		input = MergeSort.sort(input);
		assertEquals(8,input.length);
		assertEquals("0",input[0]);
		assertEquals("1",input[1]);
		assertEquals("2",input[2]);
		assertEquals("3",input[3]);
		assertEquals("4",input[4]);
		assertEquals("5",input[5]);
		assertEquals("6",input[6]);
		assertEquals("7",input[7]);
	}
	
	public void test04() {
		create(4);
		input = MergeSort.sort(input);
		assertEquals(16,input.length);
		assertEquals("0",input[0]);
		assertEquals("1",input[1]);
		assertEquals("10",input[2]);
		assertEquals("11",input[3]);
		assertEquals("12",input[4]);
		assertEquals("13",input[5]);
		assertEquals("14",input[6]);
		assertEquals("15",input[7]);
		assertEquals("2",input[8]);
		assertEquals("3",input[9]);
		assertEquals("4",input[10]);
		assertEquals("5",input[11]);
		assertEquals("6",input[12]);
		assertEquals("7",input[13]);
		assertEquals("8",input[14]);
		assertEquals("9",input[15]);
	}
	
	public void test05() {
		create(5);
		input = MergeSort.sort(input);
		assertEquals(32,input.length);
		assertEquals("0",input[0]);
		assertEquals("1",input[1]);
		assertEquals("19",input[11]);
		assertEquals("2",input[12]);
		assertEquals("20",input[13]);
		assertEquals("29",input[22]);
		assertEquals("3",input[23]);
		assertEquals("30",input[24]);
		assertEquals("31",input[25]);
		assertEquals("4",input[26]);
		assertEquals("9",input[31]);
	}
	
	public void test06() {
		create(6);
		input = MergeSort.sort(input);
		assertEquals(64,input.length);
		assertEquals("31",input[25]);
		assertEquals("39",input[33]);
		assertEquals("49",input[44]);
		assertEquals("59",input[55]);
		assertEquals("63",input[60]);
		assertEquals("7",input[61]);
		assertEquals("9",input[63]);
	}
	
	public void test07() {
		create(7);
		input = MergeSort.sort(input);
		assertEquals("100",input[3]);
		assertEquals("109",input[12]);
		assertEquals("119",input[23]);
		assertEquals("127",input[32]);
		assertEquals("13",input[33]);
		assertEquals("19",input[39]);
		assertEquals("29",input[50]);
		assertEquals("39",input[61]);
		assertEquals("59",input[83]);
		assertEquals("79",input[105]);
		assertEquals("99",input[127]);
	}
	
	public void test08() {
		create(8);
		input = MergeSort.sort(input);
		assertEquals("127",input[32]);
		assertEquals("137",input[43]);
		assertEquals("147",input[54]);
		assertEquals("197",input[109]);
		assertEquals("200",input[114]);
		assertEquals("250",input[169]);
		assertEquals("255",input[174]);
		assertEquals("26",input[175]);
		assertEquals("29",input[178]);
		assertEquals("39",input[189]);
		assertEquals("49",input[200]);
		assertEquals("99",input[255]);
	}
	
	public void test09() {
		create(9);
		input = MergeSort.sort(input);
		assertEquals("255",input[174]);
		assertEquals("256",input[175]);
		assertEquals("299",input[222]);
		assertEquals("300",input[225]);
		assertEquals("390",input[324]);
		assertEquals("400",input[336]);
		assertEquals("490",input[435]);
		assertEquals("500",input[447]);
		assertEquals("52",input[460]);
		assertEquals("92",input[504]);
		assertEquals("99",input[511]);
	}
	
	private void checkAll(int p) {
		int size = 1 << p;
		assertEquals(size,input.length);
		assertEquals("0",input[0]);
		for (int i=1; i < size; ++i) {
			if (input[i-1].compareTo(input[i]) >= 0) {
				assertFalse("test" + p + ": out of order: input[" + (i-1) + "] = '"
						+ input[i-1] + "', input[" + i + "] = '" + input[i] + "'", true);
			}
			int num = -1;
			try {
				num = Integer.parseInt(input[i]);
			} catch (NumberFormatException ex) {
				// ignored;
			}
			if (num < 0 || num >= size || input[i].startsWith("0")) {
				assertFalse("test" + p + ": string added: '" + input[i] + "'", true);
			}
		}
	}
	
	public void test10() {
		create(10);
		input = MergeSort.sort(input);
		checkAll(10);
	}
	
	public void test11() {
		create(11);
		input = MergeSort.sort(input);
		checkAll(11);
	}
	
	public void test12() {
		create(12);
		input = MergeSort.sort(input);
		checkAll(12);
	}
	
	public void test13() {
		create(13);
		input = MergeSort.sort(input);
		checkAll(13);
	}
	
	public void test14() {
		create(14);
		input = MergeSort.sort(input);
		checkAll(14);
	}
	
	public void test15() {
		create(15);
		input = MergeSort.sort(input);
		checkAll(15);
	}
	
	public void test16() {
		create(16);
		input = MergeSort.sort(input);
		checkAll(16);
	}
	
	public void test17() {
		create(17);
		input = MergeSort.sort(input);
		checkAll(17);
	}
	
	public void test18() {
		create(18);
		input = MergeSort.sort(input);
		checkAll(18);
	}
	
	public void test19() {
		create(19);
		input = MergeSort.sort(input);
		checkAll(19);
	}
}
