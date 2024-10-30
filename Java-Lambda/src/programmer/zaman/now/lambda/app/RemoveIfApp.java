package programmer.zaman.now.lambda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfApp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("Ali", "Akbar", "Rafsanjani"));

        // RemoveIf with anonymous
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });

        // RemoveIf with lambda
        list.removeIf(values -> values.length() == 3);

        System.out.println(list);
    }
}
