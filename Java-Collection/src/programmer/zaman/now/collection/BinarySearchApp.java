package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchApp {
    public static void main(String[] args) {
        List<Integer> binarySearchList = new ArrayList<Integer>(1000);

        for (int i = 1; i <= 1000; i++) {
            binarySearchList.add(i);
        }

        int index1 = Collections.binarySearch(binarySearchList, 333);
        System.out.println(index1);

        Comparator<Integer> reverse = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int index2 = Collections.binarySearch(binarySearchList, 333);
        System.out.println(index2);
    }
}
