package programmer.zaman.now.sealed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.sealed.data.Cat;
import programmer.zaman.now.sealed.data.Dog;
import programmer.zaman.now.sealed.data.Human;
import programmer.zaman.now.sealed.data.SayHello;

public class ReflectionTest {

    @Test
    void testReflection() {
        Assertions.assertTrue(SayHello.class.isSealed());

        Class<?>[] subclasses = SayHello.class.getPermittedSubclasses();
        Assertions.assertEquals(3, subclasses.length);
        Assertions.assertEquals(Human.class, subclasses[0]);
        Assertions.assertEquals(Dog.class, subclasses[1]);
        Assertions.assertEquals(Cat.class, subclasses[2]);
    }
}
