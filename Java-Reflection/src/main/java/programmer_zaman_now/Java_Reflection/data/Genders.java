package programmer_zaman_now.Java_Reflection.data;

public enum Genders {

    MALE("Male"),
    FEMALE("Female");

    private final String description;

    Genders(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
