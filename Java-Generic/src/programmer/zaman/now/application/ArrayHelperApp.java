package programmer.zaman.now.application;

import programmer.zaman.now.util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {
        String[] names = {"Ali","Akbar","Rafsanjani"};
        Integer[] numbers = {1,2,3,4,5};
        System.out.println(ArrayHelper.count(names));
        System.out.println(ArrayHelper.count(numbers));
    }
}
