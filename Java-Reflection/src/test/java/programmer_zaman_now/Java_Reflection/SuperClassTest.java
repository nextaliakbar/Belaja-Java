package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.util.Arrays;

public class SuperClassTest {

    @Test
    void testGetSuperClass() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass);

        Class<? super Person> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass);
    }

    @Test
    void testSuperInterfaces() {
        Class<Person> personClass = Person.class;
        System.out.println(Arrays.toString(personClass.getInterfaces()));
    }
}
