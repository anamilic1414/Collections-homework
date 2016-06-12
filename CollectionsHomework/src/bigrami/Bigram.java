package bigrami;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Bigram {

	public static void main(String[] args) {

		String s = "anaaavoliiimilovana";

		HashMap<String, Integer> x = new HashMap<>();

		for (int i = 0; i < s.length() - 1; i++) {
			// System.out.println(s.substring(i, i+2));
			if (x.containsKey(s.substring(i, i + 2)))
				x.put(s.substring(i, i + 2), x.get(s.substring(i, i + 2)) + 1);
			else
				x.put(s.substring(i, i + 2), 1);
		}

		Iterator it = x.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry tekuci = (Entry) it.next();
			System.out.println(tekuci.getKey() + " " + tekuci.getValue());
		}

		/* racunanje verovatnoce */
		String novi = "lav";
		System.out.println("Ulazni string je: " + novi);


		int tri = 3;
		while (tri > 0) {
			String maxString = null;
			int maxFrekv = 0;

			Iterator iter = x.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry tekuci = (Entry) iter.next();
				String prvi = (String) tekuci.getKey();
				int tek = (int) tekuci.getValue();
				if (prvi.startsWith(novi.substring(novi.length() - 1))) {
					if (tek > maxFrekv) {
						maxString = prvi;
						maxFrekv = tek;
					}
				}
			}
			x.remove(maxString);
			if (maxFrekv > 1) {
				x.put(maxString, maxFrekv - 1);
			}

			if (maxString != null)
				novi = novi + maxString.substring(maxString.length() - 1);
			tri--;
		}
		System.out.println("A izlazni: " + novi);
		
	}
}


