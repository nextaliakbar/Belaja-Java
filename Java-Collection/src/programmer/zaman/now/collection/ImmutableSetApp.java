package programmer.zaman.now.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetApp {
    public static void main(String[] args) {
        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("One");

        Set<String> mutable = new HashSet<>();
        mutable.add("Ali");
        mutable.add("Akbar");
        mutable.add("Rafsanjani");

        Set<String> immutable = Collections.unmodifiableSet(mutable);
        //immutable.add("Ali"); // Error
        Set<String> immutableCopy = Set.of("Ali", "Akbar", "Rafsanjani");
    }
}
