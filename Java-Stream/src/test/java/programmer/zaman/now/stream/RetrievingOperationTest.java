package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RetrievingOperationTest {

    @Test
    public void testLimit() {
        List.of("Ali", "Akbar", "Rafsanjani")
                .stream().limit(2).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        List.of("Ali", "Akbar", "Rafsanjani")
                .stream().skip(2).forEach(System.out::println);
    }

    @Test
    public void testTakeWhile() {
        List.of("Ali", "Akbar", "Rafsanjani", "AAA")
                .stream().takeWhile(name -> name.length() == 3).forEach(System.out::println);
    }

    @Test
    public void testDropWhile() {
        List.of("Ali", "Akbar", "AAA", "Rafsanjani")
                .stream().dropWhile(name -> name.length() == 3).forEach(System.out::println);
    }

    @Test
    public void testFindAny() {
        List.of("Ali", "Akbar", "AAA", "Rafsanjani")
                .stream().findAny().ifPresent(name -> System.out.println(name));
    }

    @Test
    public void testFindFirst() {
        List.of("Ali", "Akbar", "AAA", "Rafsanjani")
                .stream().findFirst().ifPresent(name -> System.out.println(name));
    }
}
