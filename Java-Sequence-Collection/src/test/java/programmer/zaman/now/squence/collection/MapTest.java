package programmer.zaman.now.squence.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.SequencedMap;
import java.util.TreeMap;

public class MapTest {

    @Test
    void testMap() {
        SequencedMap<String, String> map = new TreeMap<>();
        map.put("c", "Rafsanjani");
        map.put("b", "Akbar");
        map.put("a", "Ali");

        Assertions.assertEquals("Ali", map.firstEntry().getValue());
        Assertions.assertEquals("Rafsanjani", map.lastEntry().getValue());

        SequencedMap<String, String> reversed = map.reversed();
        Assertions.assertEquals("Rafsanjani", reversed.firstEntry().getValue());
        Assertions.assertEquals("Ali", reversed.lastEntry().getValue());
    }

    @Test
    void testLinkedHashMap() {
        SequencedMap<String, String> map = new LinkedHashMap<>();
        map.putFirst("a", "Ali"); // a
        map.putFirst("b", "Akbar"); // b, a
        map.putFirst("c", "Rafsanjani"); // c,b,a
        Assertions.assertEquals("Rafsanjani", map.firstEntry().getValue());
        Assertions.assertEquals("Ali", map.lastEntry().getValue());
    }
}
