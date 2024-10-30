package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.UserService;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParamaterValidationTest extends AbstractValidatorTest{

    @Test
    void testCrossParamaterValidation() throws NoSuchMethodException {
        UserService userService = new UserService();

        Method method = UserService.class.
                getMethod("register", String.class, String.class, String.class);

        String username = "aliakbar";
        String password = "aliakbar123456";
        String retypePassowrd = "aliakbar12345";

        Set<ConstraintViolation<UserService>> violations = executableValidator.
                validateParameters(userService, method,
                        new Object[]{username, password, retypePassowrd});

        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("====================");
        });
    }
}
