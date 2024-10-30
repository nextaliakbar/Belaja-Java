package programmer.zaman.now.validation.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    @NotBlank(message = "Email can't blank")
    @Email(message = "Email must valid format")
    private String email;

    @NotBlank(message = "Name can't blank")
    private String name;

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Customer() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
