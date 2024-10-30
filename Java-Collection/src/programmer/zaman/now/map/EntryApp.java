package programmer.zaman.now.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryApp {
    public static void main(String[] args) {
        Map<String, String> entryMap = new HashMap<>();
        entryMap.put("first", "Ali");
        entryMap.put("second", "Akbar");
        entryMap.put("third", "Rafsanjani");


        Set<Map.Entry<String, String>> entries =  entryMap.entrySet();
        for(var entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
