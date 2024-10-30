package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import java.util.List;

public class FilteringOperationTest {
    @Test
    public void testFilter() {
        List.of("Ali", "Akbar", "Rafsanjani").stream()
                .filter(name -> name.length() > 3)
                .forEach(result -> System.out.println(result));

        List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .filter(number -> number % 2 == 0)
                .forEach(result -> System.out.println(result));
    }

    @Test
    public void testDistinct() {
        List.of("Ali", "Akbar", "Rafsanjani", "Ali").stream()
                .distinct()
                .forEach(result -> System.out.println(result));
    }
}
