package programmer.zaman.now.application;

import programmer.zaman.now.generic.MyData;

public class InvariantApp {
    public static void main(String[] args) {
        // Invariant
        MyData<String> stringMyData = new MyData<>("Ali Akbar");
        //MyData<Object> objectMyData = stringMyData; // Error
        MyData<Object> objectMyData = new MyData<>(1000);
        //MyData<Integer> integerMyData = objectMyData; // Error
        doIt(objectMyData);
    }

    private static void doIt(MyData<Object> objectMyData) {

    }
}
