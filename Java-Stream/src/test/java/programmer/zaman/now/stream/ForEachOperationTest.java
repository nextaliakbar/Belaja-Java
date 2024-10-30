package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ForEachOperationTest {

    @Test
    public void testBeforePeek() {
        List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .map(name -> {
                    System.out.println("Before to upper " + name);
                    System.out.println("After to upper " + name.toUpperCase());
                    return name.toUpperCase();
                })
                .forEach(name -> {
                    System.out.println("Final name " + name);
                    System.out.println("========================");
                });
    }

    @Test
    public void testAfterPeek() {
        List.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember").stream()
                .peek(name -> System.out.println("Before to upper " + name))
                .map(name -> name.toUpperCase())
                .peek(name -> System.out.println("After to upper " + name))
                .forEach(name -> {
                    System.out.println("Final name " + name);
                    System.out.println("===================");
                });
    }
}
