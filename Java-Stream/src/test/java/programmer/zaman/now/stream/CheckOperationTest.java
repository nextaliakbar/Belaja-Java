package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationTest {

    @Test
    public void testAnyMatch() {
        // Apakah terdapat data yang memenuhi kondisi lambda
        boolean result = List.of(1,2,3,4,5,6,7,8,9,21).stream()
                .anyMatch(number -> number > 20);
        System.out.println(result);
    }

    @Test
    public void testAllMatch() {
        // Apakah semua data memenuhi kondisi lambda
        boolean result = List.of(2,2,3,4,5,6,7,8,9,10).stream()
                .allMatch(number -> number > 1);
        System.out.println(result);
    }

    @Test
    public void testNoneMatch() {
        boolean result = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .noneMatch(number -> number > 0);
        System.out.println(result);
    }
}
