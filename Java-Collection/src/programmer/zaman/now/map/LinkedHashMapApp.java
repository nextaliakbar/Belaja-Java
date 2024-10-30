package programmer.zaman.now.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapApp {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("first", "Ali");
        map.put("second", "Akbar");
        map.put("third", "Rafsanjani");

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }

        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        for(var value : map.values()) {
            System.out.println(value);
        }
    }
}
