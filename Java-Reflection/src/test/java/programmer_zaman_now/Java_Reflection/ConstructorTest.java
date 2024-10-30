package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {

    @Test
    void testGetConstructor() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();

        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("==================");
        }
    }

    @Test
    void testCreateObjectUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructorEmpty = personClass.getConstructor();
        Constructor<Person> constructorParamaters = personClass.getConstructor(String.class, String.class);

        Person person1 = constructorEmpty.newInstance();
        Person person2 = constructorParamaters.newInstance("Akbar", "Rafsanjani");

        System.out.println(person1);
        System.out.println(person2);

    }
}
