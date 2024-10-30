package programmer.zaman.now.collection;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> names = new TreeSet<String>();
        names.addAll(Set.of("Ali", "Akbar", "Rafsanjani", "Politeknik", "Negeri", "Jember"));

        NavigableSet<String> namesReverse = names.descendingSet();
        NavigableSet<String> namesHeadSet = names.headSet("Ali", true); // Paling paling depan sampai element
        NavigableSet<String> namesTailSet = names.tailSet("Ali", true); // dari elemen sampai paling belakang
        for(var name : namesTailSet) {
            System.out.println(name);
        }

        NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(names);
        immutable.add("Tidak bisa menambah");
    }
}
