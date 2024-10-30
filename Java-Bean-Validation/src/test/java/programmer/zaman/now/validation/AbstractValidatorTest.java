package programmer.zaman.now.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import programmer.zaman.now.validation.extractor.DataIntegerValueExtractor;
import programmer.zaman.now.validation.extractor.DataValueExtractor;
import programmer.zaman.now.validation.extractor.EntryValueExtractorKey;
import programmer.zaman.now.validation.extractor.EntryValueExtractorValue;

import java.util.Set;

public class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator interpolator;

    @BeforeEach
    public void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        interpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);

        violations.forEach(violation -> {
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());
            System.out.println("===============");
        });
    }

    void validateWithGroups(Object object, Class<?>... gorupClass) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object, gorupClass);
        violations.forEach(violation -> {
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());
            System.out.println("===============");
        });
    }

    void validateWithException(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
