package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class OrderingOperationTest {

    @Test
    public void testSorted() {
        List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .sorted().forEach(System.out::println);
    }

    @Test
    public void testSortedWithComparator() {
        Comparator<String> comaparatorReversed = Comparator.reverseOrder();
        List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .sorted(comaparatorReversed).forEach(System.out::println);
    }
}
