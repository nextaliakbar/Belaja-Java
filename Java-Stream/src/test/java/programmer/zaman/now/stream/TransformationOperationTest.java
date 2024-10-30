package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TransformationOperationTest {

    @Test
    public void testMap() {
        List.of("Ali", "Akbar", "Rafsanjani")
                .stream().map(value -> value.toUpperCase())
                .map(value -> value.length())
                .forEach(value -> System.out.println(value));
    }

    @Test
    public void testFlatMap() {
        List.of("Ali", "Akbar", "Rafsanjani")
                .stream().map(value -> value.toUpperCase())
                .flatMap(value -> Stream.of(value, value.length()))
                .flatMap(value -> Stream.of(value, value, value))
                .forEach(value -> System.out.println(value));
    }
}
