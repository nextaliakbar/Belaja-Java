package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class AggregatOperationTest {

    @Test
    public void testMax() {
        List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }

    @Test
    public void testMin() {
        List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .min(Comparator.naturalOrder()).ifPresent(System.out::println);
    }

    @Test
    public void testCount() {
        Long count = List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .count();
        System.out.println(count);
    }

    @Test
    public void testSum() {
        var result = List.of(1,2,3,4,5).stream().reduce(0, (value , item) -> value + item);
        /**
         dimulai dari 0
         1.value = 0, item = 1 -> 1
         2.value = 1, item = 2 -> 3
         3.value = 3, item = 3 -> 6
         4.value = 6, item = 4 -> 10
         5.value = 10, item = 5 -> 15
         */
        System.out.println(result);
    }

    @Test
    public void testFactorial() {
        var resultFactorial = List.of(1,2,3,4,5).stream().reduce(1, (value , item) -> value * item);
        System.out.println(resultFactorial);
    }
}
