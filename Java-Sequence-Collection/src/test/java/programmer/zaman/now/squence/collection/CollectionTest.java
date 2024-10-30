package programmer.zaman.now.squence.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class CollectionTest {

    @Test
    void testCollection() {
        SequencedCollection<String> list = new ArrayList<>();
        list.addLast("Rafsanjani"); // Rafsanjani
        list.addFirst("Akbar"); // Akbar Rafsanjani
        list.addFirst("Ali"); // Ali Akbar Rafsanjani

        Assertions.assertEquals(List.of("Ali", "Akbar", "Rafsanjani"), list);
        list.forEach(value -> {
            System.out.println(value);
        });
        System.out.println("==================");

        SequencedCollection<String> reversed = list.reversed();
        Assertions.assertEquals(List.of("Rafsanjani", "Akbar", "Ali"), reversed);
        reversed.forEach(value -> {
            System.out.println(value);
        });
        System.out.println("==================");

        String value = list.removeFirst();
        Assertions.assertEquals("Ali", value);
        list.forEach(val -> {
            System.out.println(val);
        });
        System.out.println("==================");

        value = list.removeFirst();
        Assertions.assertEquals("Akbar", value);
        list.forEach(val -> {
            System.out.println(val);
        });

    }
}
