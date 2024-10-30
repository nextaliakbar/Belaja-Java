package classes;

import java.util.UUID;

public class UuidApp {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            UUID uuid = UUID.randomUUID();
            String strUuid = uuid.toString();
            System.out.println(strUuid);
        }
    }
}
