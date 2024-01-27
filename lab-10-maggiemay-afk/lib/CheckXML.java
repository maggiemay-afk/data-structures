import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import edu.uwm.cs.util.Element;
import edu.uwm.cs.util.XMLParseException;
import edu.uwm.cs.util.XMLReader;


public class CheckXML {
	private static void checkXML(String urlString) {
		try {
			URL url = new URL(urlString);
			InputStream is = url.openStream();
			XMLReader r = new XMLReader(new InputStreamReader(is,"UTF8"));
			r.addCDATA("script");
			r.addCDATA("style");
			Object e = r.next();
			if (!(e instanceof Element)) {
				System.err.println("Not XML: " + urlString + ".");
			}
			System.out.println(e);
		} catch (MalformedURLException e) {
			System.err.println("Malformed URL: " + urlString + ": " + e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.println("Cannot read contents of URL: " + urlString + ": " + e.getLocalizedMessage());
		} catch (XMLParseException e) {
			System.out.println("XML error for " + urlString + ": " + e.getLocalizedMessage());
		}
	}
	
	public static void main(String[] args) {
		for (String arg : args) {
			checkXML(arg);
		}
		if (args.length == 0) {
			System.out.print("URL: ");
			String url;
			try (Scanner sc = new Scanner(System.in)) {
				url = sc.nextLine();
			}
			checkXML(url);
		}
	}
}
