package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    @Test
    void testArrayClass() {
        Class<String[]> strArrayClass = String[].class;
        Class<int[]> intArrayClass = int[].class;
        Class<Person> personClass = Person.class;

        System.out.println(strArrayClass.isArray());
        System.out.println(intArrayClass.isArray());
        System.out.println(personClass.isArray());
    }

    @Test
    void testArrayMembers() {
        Class<String[]> strArrayClass = String[].class;

        System.out.println(Arrays.toString(strArrayClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(strArrayClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(strArrayClass.getDeclaredFields()));
        System.out.println(strArrayClass.getComponentType());
    }

    @Test
    void testArrayManipulations() {
        Class<String[]> strArrayClass = String[].class;
        String[] array = (String[]) Array.newInstance(strArrayClass.getComponentType(), 6);

        System.out.println(Arrays.toString(array));

        Array.set(array, 0, "Ali");
        Array.set(array, 1, "Akbar");
        Array.set(array, 2, "Rafsanjani");
        Array.set(array, 3, "Politeknik");
        Array.set(array, 4, "Negeri");
        Array.set(array, 5, "Jember");

        System.out.println(Arrays.toString(array));

        System.out.println(Array.get(array, 5));
    }
}
