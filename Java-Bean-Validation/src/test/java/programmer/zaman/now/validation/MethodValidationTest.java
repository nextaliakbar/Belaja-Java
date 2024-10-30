package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Person;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest{

    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();
        String name = "";

        Method method = person.getClass().getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, method, new Object[]{name});

        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===========");
        });
    }

    @Test
    void testFullName() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("Akbar");
        person.setLastName("");

        String returnValue = person.fullName();

        Method method = person.getClass().getMethod("fullName");

        Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, method, returnValue);
        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");
        });
    }
}
