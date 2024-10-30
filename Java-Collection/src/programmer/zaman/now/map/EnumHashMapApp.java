package programmer.zaman.now.map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumHashMapApp {

    private static enum Level {
        PREMIUM, VIP, STANDART;
    }

    public static void main(String[] args) {
        Map<Level, String> enumHashMap = new EnumMap<>(Level.class);
        enumHashMap.put(Level.PREMIUM, "Premium");
        enumHashMap.put(Level.VIP, "Vip");
        enumHashMap.put(Level.STANDART, "Standard");

        for(var key : enumHashMap.keySet()) {
            System.out.println(key);
        }

        for(Level level : Level.values()) {
            System.out.println(level);
        }

        enumHashMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
