package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableApp {
    public static void main(String[] args) {
        List<String> one = Collections.singletonList("Satu");
        System.out.println(one.get(0));
        List<String> empty = Collections.emptyList();
        System.out.println(empty.isEmpty());

        System.out.println("Mutabel / Dapat Berubah-Ubah");
        List<String> mutable = new ArrayList<>();
        mutable.addAll(List.of("Ali", "Akbar", "Rafsanjani"));
        mutable.add("Polije");

        for(String value : mutable) {
            System.out.println(value);
        }
        System.out.println("Immutable / Tidak Dapat Berubah-Ubah");
        List<String> immutable = Collections.unmodifiableList(mutable);
        for(String value : immutable) {
            System.out.println(value);
        }
//        immutable.add("Tidak dapat menambah");

        for(String value : immutable) {
            System.out.println(value);
        }

        List<String> immutableList = List.of("one", "two", "three");
//        immutableList.add("Tidak dapat menambah");
        for(String value : immutableList) {
            System.out.println(value);
        }
    }
}
