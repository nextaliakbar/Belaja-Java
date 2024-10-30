package programmer.zaman.now.validation.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import programmer.zaman.now.validation.enums.CaseMode;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;
import programmer.zaman.now.validation.group.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        message = "{order.id.notblank}")
@Size(min = 1, max = 10, message = "{order.id.size}",
        groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
@CheckCase(mode = CaseMode.UPPER, message = "{order.id.upper}",
        groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {

    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
