package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;
import programmer_zaman_now.Java_Reflection.validations.Validator;

public class AnnotationsTest {

    @Test
    void testValidateUsingAnnotation() throws IllegalAccessException {
        Person person = new Person("Ali", " ");
        Validator.validateNotBlank(person);
    }
}
