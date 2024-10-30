package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Stream;

public class CreateStreamBuilderTest {
    @Test
    public void testCreateStreamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Ali");
        builder.add("Akbar").add("Rafsanjani");

        Stream<String> stream = builder.build();
        stream.forEach(data -> System.out.println(data));
    }

    @Test
    public void testCreateStreamBuilderSimplyfy() {
        Stream<Object> stream  = Stream.builder().add("Ali").add("Akbar").add("Rafsanjani").build();
        stream.forEach(data -> System.out.println(data));
    }
}
