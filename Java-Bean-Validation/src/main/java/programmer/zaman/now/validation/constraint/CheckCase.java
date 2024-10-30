package programmer.zaman.now.validation.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import programmer.zaman.now.validation.enums.CaseMode;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CheckCaseValidator.class}
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "invalid case format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
