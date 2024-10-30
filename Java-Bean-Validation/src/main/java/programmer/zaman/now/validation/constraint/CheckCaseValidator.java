package programmer.zaman.now.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import programmer.zaman.now.validation.enums.CaseMode;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return true; // not validate null value

        if(caseMode == CaseMode.UPPER) {
            return s.equals(s.toUpperCase());
        } else if(caseMode == CaseMode.LOWER) {
            return s.equals(s.toLowerCase());
        }

        return false;
    }

}
