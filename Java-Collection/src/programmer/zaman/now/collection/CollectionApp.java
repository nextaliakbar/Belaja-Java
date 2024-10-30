package programmer.zaman.now.collection;

import java.util.ArrayList;;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        Collection<String> collections = new ArrayList<>();
        collections.add("Ali");
        collections.add("Akbar");
        collections.add("Rafsanjani");
        collections.addAll(List.of("Politeknik", "Negeri", "Jember"));

        for(String collection : collections) {
            System.out.println(collection);
        }

        System.out.println("Remove");
        collections.remove("Rafsanjani");
        collections.removeAll(List.of("Negeri", "Jember"));

        for(String collection : collections) {
            System.out.println(collection);
        }

        System.out.println(collections.contains("Ali"));
        System.out.println(collections.containsAll(List.of("Akbar", "Rafsanjani")));
        System.out.println(collections.containsAll(List.of("Akbar", "Politeknik")));
    }
}
