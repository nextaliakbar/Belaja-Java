package classes;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        joiner.add("Ali");
        joiner.add("Akbar");
        joiner.add("Rafsanjani");
        String name = joiner.toString();
        System.out.println(name);
    }
}
