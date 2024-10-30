package programmer.zaman.now.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("firstname", "Ali");
        map.put("middlename", "Akbar");
        map.put("lastname", "Rafsanjani");

        System.out.println(map.get("firstname"));
        System.out.println(map.get("middlename"));
        System.out.println(map.get("lastname"));
    }
}
