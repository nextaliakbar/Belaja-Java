package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends AbstractValidatorTest{

    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("123456789010");
        payment.setAmount(10L);
        payment.setVirtualAccount("312313");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
