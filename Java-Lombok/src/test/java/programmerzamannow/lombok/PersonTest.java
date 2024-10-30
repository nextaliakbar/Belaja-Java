package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    @Test
    void testCreateViaConstructor() {

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Hobby1");
        hobbies.add("Hobby2");
        hobbies.add("Hobby3");

        Person person = new Person("id", "name", 21, hobbies);
    }

    @Test
    void testCreateViaSetter() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Hobby1");
        hobbies.add("Hobby2");
        hobbies.add("Hobby3");

        Person person = new Person();
        person.setId("id");
        person.setName("name");
        person.setAge(21);
        person.setHobbies(hobbies);
    }

    @Test
    void testCreateViaBuilder() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Hobby1");
        hobbies.add("Hobby2");
        hobbies.add("Hobby3");
        var person1 = Person.builder()
                .id("id")
                .name("name")
                .age(21)
                .hobbies(hobbies)
                .build();

        var person2 = Person.builder()
                .id("id")
                .name("name")
                .age(21)
                .hobby("Hobyy1")
                .hobby("Hobyy2")
                .hobby("Hobyy3")
                .build();

        System.out.println(person1);
        System.out.println(person2);
    }
}
