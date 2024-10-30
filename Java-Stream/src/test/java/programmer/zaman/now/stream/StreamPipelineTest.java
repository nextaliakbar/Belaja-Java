package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineTest {

    @Test
    public void testStreamPipeline() {
        List<String> listNames = List.of("Ali", "Akbar", "Rafsanjani");

        listNames.stream().map(name -> name.toUpperCase())
                .map(name -> "Mr." + name)
                .forEach(result -> System.out.println(result));
    }
}
