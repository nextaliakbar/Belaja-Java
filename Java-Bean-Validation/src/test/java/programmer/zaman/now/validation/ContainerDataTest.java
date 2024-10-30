package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Addres;
import programmer.zaman.now.validation.data.Person;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest{

    @Test
    void testContainerData(){
        Person person = new Person();
        person.setFirstName("Ali");
        person.setLastName("Akbar");
        person.setAddres(new Addres());
        person.getAddres().setStreet("Bangsalsari");
        person.getAddres().setCity("Jember");
        person.getAddres().setCountry("Indonesia");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("");
        person.getHobbies().add("Gaming");

        validate(person);
    }
}
