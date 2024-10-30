package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class LazyValuationTest {

    @Test
    public void testLazyOperation() {
        List<String> listNames = List.of("Ali", "Akbar", "Rafsanjani");
        Stream<String> streamNames = listNames.stream().map(name -> {
            System.out.println("Change " + name + " toUpperCase");
            return name.toUpperCase();
        });
    }

    @Test
    public void testTerminalOperation() {
        List<String> listNames = List.of("Ali", "Akbar", "Rafsanjani");
        listNames.stream().map(name -> {
            System.out.println("Change " + name + " toUpperCase");
            return name.length() * 10;
        }).map(name -> {
            System.out.println("Hello Mr." + name);
            return name.intValue();
        }) .forEach(result -> System.out.println(result));
    }
}
