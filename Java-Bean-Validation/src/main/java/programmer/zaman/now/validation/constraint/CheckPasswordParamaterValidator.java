package programmer.zaman.now.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParamaterValidator implements ConstraintValidator<CheckPasswordParamater, Object[]> {

    private int passwordParam;

    private int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParamater constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        passwordParam = constraintAnnotation.passwordParam();
        retypePasswordParam = constraintAnnotation.retypePasswordParam();
    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {

        String password = (String) objects[passwordParam];
        String retypePassword = (String) objects[retypePasswordParam];

        if(password == null || retypePassword == null) return true; // skip validation

        return password.equals(retypePassword);
    }
}
