package programmer.zaman.now.data;

import programmer.zaman.now.annotation.Fancy;

@Fancy(name = "Car", tags = {"Application", "Java"})
public interface Car extends HashBrand {
    void drive();

    int getTire();

    default boolean isBig() {
        return false;
    }
}
