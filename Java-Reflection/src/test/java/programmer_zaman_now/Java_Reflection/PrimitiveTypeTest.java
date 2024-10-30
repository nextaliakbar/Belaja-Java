package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrimitiveTypeTest {

    @Test
    void testClass() {
        Class<Integer> integerClass = int.class;
        Class<Long> longClass = long.class;
        Class<Boolean> booleanClass = boolean.class;

        System.out.println(integerClass.isPrimitive());
        System.out.println(longClass.isPrimitive());
        System.out.println(booleanClass.isPrimitive());
    }

    @Test
    void testGetFieldsPrimitive() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;

        Field age = personClass.getDeclaredField("age");

        System.out.println(age.getType().isPrimitive());
    }

    @Test
    void testGetFieldsValuePrimitive() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Field age = personClass.getDeclaredField("age");

        System.out.println(age.getType().isPrimitive());

        age.setAccessible(true);

        Person person = new Person("Ali", "Akbar");

        person.setAge(21);

        System.out.println(age.getInt(person));
    }

    @Test
    void testInvokeMethodPrimitive() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        Method setAge = personClass.getDeclaredMethod("setAge", int.class);

        Person person = new Person("Ali", "Akbar");
        setAge.invoke(person, 21);

        System.out.println(person);
    }
}
