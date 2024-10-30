package programmerzamannow.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void testConstructorNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
           var member = new Member(null, null);
        });
    }

    @Test
    void testSetNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
           var member = new Member("id", "name");
           member.setName(null);
           member.setName(null);
        });
    }

    @Test
    void testMethodNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            var member = new Member("id", "name");
            member.sayHello(null);
        });
    }
}
