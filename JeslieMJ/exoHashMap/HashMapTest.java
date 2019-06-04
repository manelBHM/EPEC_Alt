package exoHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	


	public static void main(String[] args) {
		
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(5, "A");
        hmap.put(11, "C");
        hmap.put(4, "Z");
        hmap.put(77, "Y");
        hmap.put(9, "P");
        hmap.put(66, "Q");
        hmap.put(0, "R");

        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        System.out.println("Avant le tri: ");
       
        while(iterator.hasNext()) {
           Map.Entry me = (Map.Entry)iterator.next();
           System.out.print(me.getKey() + ": ");
           System.out.println(me.getValue());
           
        }
        System.out.println("\n");
        Map sortedMap = new HashMap(hmap);

        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        System.out.println("Après le tri: ");
     
        while(iterator2.hasNext()) {
           Map.Entry me2 = (Map.Entry)iterator2.next();
           System.out.print(me2.getKey() + ": ");
           System.out.println(me2.getValue());
        }
     }

	}

