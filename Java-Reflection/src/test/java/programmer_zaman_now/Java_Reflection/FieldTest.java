package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldsValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Ali", "Akbar");
        String result1 = (String) firstName.get(person1);
        System.out.println(result1);

        Person person2 = new Person("Budi", "Nugraha");
        String result2 = (String) firstName.get(person2);
        System.out.println(result2);
    }

    @Test
    void testSetFieldsValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Ali", "Akbar");
        firstName.set(person1, "Rafsanjani"); // person1.set("Rafsanjani")
        String result1 = (String) firstName.get(person1);
        System.out.println(result1);

        Person person2 = new Person("Budi", "Nugraha");
        firstName.set(person2, "Tono"); // person2.set("Tono")
        String result2 = (String) firstName.get(person2);
        System.out.println(result2);
    }
}
