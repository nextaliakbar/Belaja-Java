package programmer.zaman.now.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
    public static void main(String[] args) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        SortedMap<String, String> map = new TreeMap<String, String>(comparator);
        map.put("Ali", "Ali");
        map.put("Akbar", "Akbar");
        map.put("Rafsanjani", "Rafsanjani");

        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        SortedMap<String, String> empty = Collections.emptySortedMap();
        SortedMap<String, String> immutable = Collections.unmodifiableSortedMap(map);
    }
}
