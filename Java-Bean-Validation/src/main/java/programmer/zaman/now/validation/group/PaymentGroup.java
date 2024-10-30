package programmer.zaman.now.validation.group;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence(value = {
        // jika group kedua error maka group selanjutnya tidak divalidasi
        Default.class,
        CreditCardPaymentGroup.class,
        VirtualAccountPaymentGroup.class
    }
)

public interface PaymentGroup {
}
