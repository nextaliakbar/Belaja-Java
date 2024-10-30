package programmer.zaman.now.map;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("Ali", "Ali");
        map.put("Akbar", "Akbar");
        map.put("Rafsanjani", "Rafsanjani");

        for(var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.lowerKey("Akbar")); // <
        System.out.println(map.higherKey("Akbar")); // >
        System.out.println(map.floorKey("Ali")); // =<
        System.out.println(map.ceilingKey("Ali")); // =>

        NavigableMap<String, String> descMap = map.descendingMap();
        for(var desc : descMap.keySet()) {
            System.out.println(desc);
        }

        NavigableMap<String, String> emptyMap = Collections.emptyNavigableMap();
        System.out.println(emptyMap.isEmpty());
        NavigableMap<String, String> immutable = Collections.unmodifiableNavigableMap(map);
        immutable.put("Rafsanjani", "Rafsanjani");
    }
}
