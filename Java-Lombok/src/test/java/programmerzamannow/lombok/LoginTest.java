package programmerzamannow.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void testLogin() {
        var login1 = Login.createEmpty();
        var login2 = Login.create("aliakbar", "12345");

        Assertions.assertEquals(null, login1.getUsername());
        Assertions.assertEquals(null, login1.getPassword());

        Assertions.assertEquals("aliakbar", login2.getUsername());
        Assertions.assertEquals("12345", login2.getPassword());
    }

    @Test
    void testToString() {
        var login2 = Login.create("aliakbar", "12345");
        System.out.println(login2);
    }
}
