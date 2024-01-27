
import java.util.Arrays;

import edu.uwm.apc430.Person;
import edu.uwm.apc430.util.MergeSort;

public class Driver {

	public static void main(String[] args) {
		
		Person[] brewers = { 
				new Person("Carlos", "Gomez"),
				new Person("Ryan", "Braun"),
				new Person("Jeremy", "Jeffress"),
				new Person("Prince", "Fielder"),
				new Person("Casey", "McGehee"),
				new Person("Corey", "Hart"),
				new Person("Gregg", "Zaun"),
				new Person("Alcides", "Escobar"),
				new Person("Yovani", "Gallardo"),
				new Person("Corey", "Knebel")
		};
			
		System.out.println("original list: " + Arrays.toString(brewers));
		
		Person[] sortedBrewers = MergeSort.sort(brewers);
		
		System.out.println("sorted list:   " + Arrays.toString(sortedBrewers));
	}
}
