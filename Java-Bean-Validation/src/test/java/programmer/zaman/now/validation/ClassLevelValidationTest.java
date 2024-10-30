package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Register;

public class ClassLevelValidationTest extends AbstractValidatorTest{

    @Test
    void testClassLevelValidation() {
        Register register = new Register();
        register.setUsername("Akbar");
        register.setPassword("12345");
        register.setRetypePassword("123456");

        validate(register);
    }
}
