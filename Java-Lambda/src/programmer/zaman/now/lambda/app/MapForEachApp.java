package programmer.zaman.now.lambda.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapForEachApp {
    public static void main(String[] args) {
        Map<String, String> map = Map.of(
                "firstname", "ali",
                "middlename", "akbar",
                "lastname", "rafsanjani"
        );

        // With anonymous
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " " + s2);
            }
        });

        // with lambda
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
}
