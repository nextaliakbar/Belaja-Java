package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Customer;
import programmer.zaman.now.validation.data.Payment;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;

public class GroupConvertTest extends AbstractValidatorTest {

    @Test
    void testGroupConvert() {
        Payment payment = new Payment();
        payment.setOrderId("00001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer("",""));

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
