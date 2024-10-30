package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>(10);
        List<String> stringList2 = new LinkedList<>();

        stringList1.add("Ali");
        stringList1.add("Akbar");
        stringList1.add("Rafsanjani");

        stringList2.add("Politeknik");
        stringList2.add("Negeri");
        stringList2.add("Jember");

        stringList1.remove(2);
        System.out.println(stringList1.get(0));
        for(String value : stringList1) {
            System.out.println(value);
        }

        for(String value : stringList2) {
            System.out.println(value);
        }
    }
}
