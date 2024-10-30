package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;
import programmer.zaman.now.validation.payload.EmailErroPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testPayloadTest() {
        Payment payment = new Payment();
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        violations.forEach(violation -> {
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("Message : " + violation.getMessage());

            Set<Class<? extends Payload>> payloads = violation.getConstraintDescriptor().getPayload();
            payloads.forEach(payload -> {
                if(payload == EmailErroPayload.class) {
                    new EmailErroPayload().sendEmail(violation);
                }
            });

            System.out.println("===================");
        });
    }
}
