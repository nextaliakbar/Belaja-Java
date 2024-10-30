package programmer.zaman.now.validation.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErroPayload implements Payload {

    public void sendEmail(ConstraintViolation<?> violations) {
        System.out.println("Send email because error " + violations.getMessage());
    }

}
