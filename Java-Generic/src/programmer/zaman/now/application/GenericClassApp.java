package programmer.zaman.now.application;

import programmer.zaman.now.generic.MyData;

public class GenericClassApp {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<String>("Ali Akbar");
        MyData<Boolean> booleanMyData = new MyData<Boolean>(true);
        System.out.println(stringMyData.getData());
        System.out.println(booleanMyData.getData());
    }
}
