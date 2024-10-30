package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Genders;

import java.util.Arrays;

public class EnumTest {

    @Test
    void testEnum() {
        Class<Genders> gendersClass = Genders.class;

        System.out.println(gendersClass.getName());
        System.out.println(gendersClass.getSuperclass());
        System.out.println(Arrays.toString(gendersClass.getEnumConstants()));
        System.out.println(gendersClass.isEnum());
        System.out.println(Arrays.toString(gendersClass.getDeclaredFields()));
        System.out.println(Arrays.toString(gendersClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(gendersClass.getDeclaredMethods()));
    }
}
