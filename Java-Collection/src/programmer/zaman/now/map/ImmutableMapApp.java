package programmer.zaman.now.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapApp {
    public static void main(String[] args) {
        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> singleTon = Collections.singletonMap("firstname", "Akbar");
        System.out.println(singleTon.get("firstname"));
        Map<String, String> mutable = new HashMap<>();
        mutable.put("firstname", "Akbar");
        mutable.put("secondname", "Rafsanjani");
        Map<String, String> immutable = Collections.unmodifiableMap(mutable);
        //immutable.put("lastname", "Rafsanjani"); // Error

        Map<String, String> immutableCopy = Map.of(
          "fisrt", "Ali",
          "second", "Akbar",
          "three", "Rafsanjani"
        );

        //immutableCopy.put("four", "Rafsanjani"); // Error

        immutableCopy.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }
}
