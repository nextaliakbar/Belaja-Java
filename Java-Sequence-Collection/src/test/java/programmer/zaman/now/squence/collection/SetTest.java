package programmer.zaman.now.squence.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.SequencedSet;
import java.util.TreeSet;

public class SetTest {

    @Test
    void testSet() {
        SequencedSet<String> set = new TreeSet<>();
        set.add("Ali"); // Ali
        set.add("Akbar"); // Akbar, Ali
        set.add("Rafsanjani"); // Akbar, Ali, Rafsanjani
        set.forEach(value -> System.out.println(value));
        System.out.println("=======================");
        Assertions.assertEquals("Akbar", set.getFirst());
        Assertions.assertEquals("Rafsanjani", set.getLast());

        SequencedSet<String> reversed = set.reversed();
        reversed.forEach(value -> System.out.println(value));
        System.out.println("======================");
        Assertions.assertEquals("Akbar", reversed.getLast());
        Assertions.assertEquals("Rafsanjani", reversed.getFirst());
    }
}
