package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {

    @Test
    public void testStreamOperation() {
        List<String> listName = List.of("Ali", "Akbar", "Rafsanjani");
        Stream<String> streamName = listName.stream();
        Stream<String> names =  streamName.map(name -> name.toUpperCase());
        names.forEach(value -> System.out.println(value)); // Manpulasi data di stream bersifat immutable
        listName.forEach(value -> System.out.println(value));
    }
}
