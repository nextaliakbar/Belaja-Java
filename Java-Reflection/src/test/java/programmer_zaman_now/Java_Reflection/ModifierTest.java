package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.lang.reflect.Modifier;

public class ModifierTest {

    @Test
    void testModifier() {
        Class<Person> personClass = Person.class;
        System.out.println(Modifier.isPublic(personClass.getModifiers()));
        System.out.println(Modifier.isFinal(personClass.getModifiers()));
        System.out.println(Modifier.isStatic(personClass.getModifiers()));
    }
}
