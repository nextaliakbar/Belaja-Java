package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.PaymentGroup;

public class GroupSquenceTest extends AbstractValidatorTest{

    @Test
    void testGroupSquence() {
        Payment payment = new Payment();
        payment.setOrderId("000001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");

        validateWithGroups(payment, PaymentGroup.class);
    }
}
