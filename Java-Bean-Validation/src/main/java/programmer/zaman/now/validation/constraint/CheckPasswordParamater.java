package programmer.zaman.now.validation.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CheckPasswordParamaterValidator.class}
)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParamater {

    int passwordParam();

    int retypePasswordParam();

    String message() default "Password and retype password must same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
