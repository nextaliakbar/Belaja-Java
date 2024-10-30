package programmer.zaman.now.collection;

import java.util.EnumSet;

public class EnumSetApp {

    private static enum Gender {
        MALE, FEMALE, NO_MENTION
    }

    public static void main(String[] args) {
//        EnumSet<Gender> genders = EnumSet.allOf(Gender.class);
        EnumSet<Gender> genders = EnumSet.of(Gender.MALE, Gender.FEMALE);
        for(Gender gender : genders) {
            System.out.println(gender);
        }

        for(Gender gender : Gender.values()) {
            System.out.println(gender);
        }
    }
}
