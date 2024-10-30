package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;

import java.util.Locale;

public class CustomConstraintTes extends AbstractValidatorTest{

    @Test
    void testCustomConstraint() {

        Locale.setDefault(new Locale("id", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("test");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
