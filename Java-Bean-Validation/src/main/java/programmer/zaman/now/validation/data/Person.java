package programmer.zaman.now.validation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    @NotBlank(message = "First name can't blank ")
    @Size(max = 20, message = "First name length max must 20 characters")
    private String firstName;

    @NotBlank(message = "Last name can't blank ")
    @Size(max = 20, message = "Last name length max must 20 characters")
    private String lastName;

    @Valid
    @NotNull(message = "Addres can't null")
    private Addres addres;

    private List<@NotBlank(message = "Hobbie can't blank")String> hobbies;

    @Valid
    public Person(@NotBlank(message = "First name can't blank") String firstName,
                  @NotBlank(message = "Last name cant't blank") String lastName,
                  @Valid @NotNull(message = "Addres can't null") Addres addres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addres = addres;
    }

    @Valid
    public Person(@NotBlank(message = "First name can't blank") String firstName,
                  @NotBlank(message = "Last name cant't blank") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Valid
    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Addres getAddres() {
        return addres;
    }

    public void setAddres(Addres addres) {
        this.addres = addres;
    }

    public List<String> getHobbies() {
        return hobbies;
    };

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "Name can't blank") String name) {
        System.out.println("Hello " + name + " my first name is " + firstName);
    }

    @NotBlank(message = "Full name can't blank")
    public String fullName() {
        return firstName + " " + lastName;
    }
}
