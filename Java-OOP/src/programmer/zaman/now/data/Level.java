package programmer.zaman.now.data;

import programmer.zaman.now.annotation.Fancy;

@Fancy(name = "Level", tags = {"Application", "Java"})
public enum Level {
    STANDART("Standart Level"),
    PREMIUM("Premium Level"),
    VIP("Vip Level"),;

    private String description;

    Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
