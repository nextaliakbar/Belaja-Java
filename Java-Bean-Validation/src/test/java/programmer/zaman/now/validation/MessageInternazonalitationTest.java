package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;

import java.util.Locale;
import java.util.Set;

public class MessageInternazonalitationTest extends AbstractValidatorTest{

    @Test
    void testMessageInternazonalitation() {
        Locale.setDefault(new Locale("id", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("123456789010");
        payment.setAmount(10L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {
        Payment payment = new Payment();
        payment.setOrderId("123456789010");
        payment.setAmount(10L);

        Set<ConstraintViolation<Payment>> violations =
                validator.validate(payment, CreditCardPaymentGroup.class);

        Locale locale = new Locale("id", "ID");

        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolatorContext contex =
                    new MessageInterpolatorContext(violation.getConstraintDescriptor(),
                            violation.getInvalidValue(), violation.getRootBeanClass(),
                            violation.getPropertyPath(), violation.getConstraintDescriptor()
                            .getAttributes(), violation.getConstraintDescriptor()
                            .getAttributes(), ExpressionLanguageFeatureLevel.VARIABLES, true);

            String message = interpolator.interpolate(violation.getMessageTemplate(), contex, locale);
            System.out.println(message);

            System.out.println("=================");
        });
    }
}
