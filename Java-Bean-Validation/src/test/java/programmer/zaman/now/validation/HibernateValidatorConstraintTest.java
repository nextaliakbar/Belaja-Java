package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Payment;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest{

    @Test
    void testHibernateValidatorConstraintInvalid() {

        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("00001");
        payment.setCreditCard("433");

        validate(payment);
    }

    @Test
    void testHibernateValidatorConstraintSucces() {

        Payment payment = new Payment();
        payment.setAmount(10_000_000L);
        payment.setOrderId("00001");
        payment.setCreditCard("4111111111111111");

        validate(payment);
    }
}
