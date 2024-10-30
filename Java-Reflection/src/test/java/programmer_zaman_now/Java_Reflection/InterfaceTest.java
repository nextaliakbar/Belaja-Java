package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Namable;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.util.Arrays;

public class InterfaceTest {

    @Test
    void testInterface() {
        Class<Namable> namableClass = Namable.class;

        System.out.println(namableClass.getName());
        System.out.println(namableClass.isInterface());
        System.out.println(namableClass.getSuperclass());
        System.out.println(Arrays.toString(namableClass.getInterfaces()));
        System.out.println(Arrays.toString(namableClass.getDeclaredFields()));
        System.out.println(Arrays.toString(namableClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(namableClass.getDeclaredConstructors()));
    }
}
