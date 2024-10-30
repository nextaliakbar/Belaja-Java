package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;
import programmer.zaman.now.validation.group.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest{

    @Test
    void testCreditCardGroupInvalid() {
        Payment payment = new Payment();
        payment.setOrderId("01111");
        payment.setAmount(20_000L);
        payment.setCreditCard("123");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccountPaymentGroupInvalid() {
        Payment payment = new Payment();
        payment.setOrderId("01111");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
