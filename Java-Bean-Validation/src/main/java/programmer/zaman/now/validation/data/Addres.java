package programmer.zaman.now.validation.data;

import jakarta.validation.constraints.NotBlank;

public class Addres {

    @NotBlank(message = "Street can't blank")
    private String street;

    @NotBlank(message = "City can't blank")
    private String city;

    @NotBlank(message = "Country can't blank")
    private String country;

    public Addres(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Addres() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Addres{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
