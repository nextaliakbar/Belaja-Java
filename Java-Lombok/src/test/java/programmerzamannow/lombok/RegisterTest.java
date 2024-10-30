package programmerzamannow.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterTest {

    @Test
    void testWith() {
        var register1 = new Register("Ali", "Akbar");
        var register2 = register1.withName("Rafsanjani");

        Assertions.assertEquals(register1.getPassword(), register2.getPassword());
        Assertions.assertNotEquals(register1.getName(), register2.getName());
    }
}
