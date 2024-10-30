package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Addres;
import programmer.zaman.now.validation.data.Person;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest{

    @Test
    void testConstructorValidation() throws NoSuchMethodException {

        String firstName = "";
        String lastName = "";
        Addres addres = new Addres();

        Constructor<Person> constructor = Person.class.getConstructor
                (String.class, String.class, Addres.class);

        Set<ConstraintViolation<Object>> violations =
                executableValidator.validateConstructorParameters
                        (constructor, new Object[]{firstName, lastName, addres});

        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");
        });
    }

    @Test
    void testConstructorReturnValueValidation() throws NoSuchMethodException {

        String firstName = "Ali Akbar";
        String lastName = "Rafsanjani";
        Addres addres = new Addres("Bangsalsari", "Jember", "Indonesia");

        Constructor<Person> constructor = Person.class.getConstructor
                (String.class, String.class, Addres.class);

        Person person = new Person(firstName, lastName, addres);

        Set<ConstraintViolation<Object>> violations = executableValidator.
                validateConstructorReturnValue(constructor, person);

        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");
        });
    }
}
