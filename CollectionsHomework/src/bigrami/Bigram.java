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
		
		String s = "anaaaaavoliiimilovana";
		
		HashMap<String, Integer> x = new HashMap<>();
		
		for (int i = 0; i < s.length()-1; i++) {
//			System.out.println(s.substring(i, i+2)); 
			if(x.containsKey(s.substring(i,i+2)))
				x.put(s.substring(i,i+2), x.get(s.substring(i,i+2))+1);	
			else 
				x.put(s.substring(i,i+2), 1);
		}
	
		 Iterator it = x.entrySet().iterator();
		    while (it.hasNext()) {
		    	Map.Entry tekuci = (Entry) it.next();
		        System.out.println(tekuci.getKey()+ " "  + tekuci.getValue());
		        
		    }
		  
		
	}
}
