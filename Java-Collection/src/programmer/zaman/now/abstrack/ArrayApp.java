package programmer.zaman.now.abstrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayApp {
    public static void main(String[] args) {
        List<String> list = List.of("Ali", "Akbar", "Rafsanjani");

        Object[] objects = list.toArray();
        String[] strings = list.toArray(new String[list.size()]);

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));
    }
}
