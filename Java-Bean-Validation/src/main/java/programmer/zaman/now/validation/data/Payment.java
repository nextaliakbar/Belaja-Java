package programmer.zaman.now.validation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import programmer.zaman.now.validation.constraint.CheckCase;
import programmer.zaman.now.validation.constraint.CheckOrderId;
import programmer.zaman.now.validation.enums.CaseMode;
import programmer.zaman.now.validation.group.CreditCardPaymentGroup;
import programmer.zaman.now.validation.group.VirtualAccountPaymentGroup;
import programmer.zaman.now.validation.payload.EmailErroPayload;

public class Payment {

    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
    message = "{order.id.invalid}")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Amount can't null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
            ,min = 10_000L, max = 100_000_000L, message = "{amount.range}")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class},message = "Credit card can't blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class},message = "Invalid credit card number",
                payload = {EmailErroPayload.class})
    private String creditCard;


    @NotBlank(groups = {VirtualAccountPaymentGroup.class},message = "Virtual account can't blank")
    private String virtualAccount;


    @Valid
    @NotNull(message = "Customer cant't null", groups = {CreditCardPaymentGroup.class,
            VirtualAccountPaymentGroup.class})
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Payment(String orderId, Long amount, String creditCard, String virtualAccount, Customer customer) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
        this.virtualAccount = virtualAccount;
        this.customer = customer;
    }

    public Payment() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
