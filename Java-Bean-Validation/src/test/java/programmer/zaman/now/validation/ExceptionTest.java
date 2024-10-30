package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Person;

public class ExceptionTest extends AbstractValidatorTest{

    @Test
    void testException() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validateWithException(person);
        });

    }
}
