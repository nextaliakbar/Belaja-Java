package programmer.zaman.now.stream;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    public void testCreateEmptyOrSingleStream() {
        Stream<String> emptyStream = Stream.empty(); // Empty data
        emptyStream.forEach(data -> {
            System.out.println(data);
        });

        Stream<String> oneStream = Stream.of("Akbar"); // Single data
        oneStream.forEach(data -> {
            System.out.println(data);
        });

        String data = null;
        Stream<String> nullStream = Stream.ofNullable(data);
        nullStream.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void testCreateStreamFromArray() {
        Stream<String> arrayStream = Stream.of("Ali", "Akbar", "Rafsanjani");
        arrayStream.forEach(data -> {
            System.out.println(data);
        });

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(data -> {
            System.out.println(data);
        });

        String[] array = new String[]{"Ali", "Akbar", "Rafsanjani"};
        Stream<String> stringStream = Arrays.stream(array);
        stringStream.forEach(data -> {
            System.out.println(data);
        });
    }

    @Test
    public void testCreateStreamFromCollection() {
        Collection<String> collections = List.of("Ali", "Akbar", "Rafsanjani");
        Stream<String> stringStream = collections.stream();
        stringStream.forEach(data -> {
            System.out.println(data);
        });

        /**
        stringStream.forEach(data -> {
            System.out.println(data);
        });
         */
    }

    @Test
    public void testCreateInfiniteStream() {
        Stream<String> infiniteStream = Stream.generate(() -> "Ali Akbar Rafsanjani");
        //infiniteStream.forEach(data -> System.out.println(data));

        Stream<Integer> integerStream = Stream.iterate(1, value -> value + 1);
        //infiniteStream.forEach(data -> System.out.println(data));
    }

}
