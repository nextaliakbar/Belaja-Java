package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Addres;
import programmer.zaman.now.validation.data.Person;

import java.util.Set;

public class NestedValidationTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testNestedValidationFailed() {
        Person person = new Person();
        person.setFirstName("Ali");
        person.setLastName("Akbar");

        Addres addres = new Addres();
        person.setAddres(addres);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(0, violations.size());
        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
        });
    }

    @Test
    void testNestedValidationSucces() {
        Person person = new Person();
        person.setFirstName("Ali");
        person.setLastName("Akbar");

        Addres addres = new Addres("Bangsalsari","Jember","Indonesia");
        person.setAddres(addres);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(0, violations.size());
        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
        });
    }
}
