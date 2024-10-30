package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;

public class ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition() {
        Payment payment = new Payment();
        payment.setOrderId("2324232424224odr");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
