package programmer.zaman.now.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {
        //Set<String> names = new HashSet<>(); // Untuk memeriksa data duplicate dengan tidak terurut
        Set<String> names = new LinkedHashSet<>(); // Untuk memeriksa data duplicate dengan tururut
        names.add("Ali");
        names.add("Akbar");
        names.add("Rafsanjani");
        names.add("Ali");
        names.add("Akbar");
        names.add("Rafsanjani");
        for(var name : names) {
            System.out.println(name);
        }
    }
}
