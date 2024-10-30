package programmer.zaman.now.application;

import programmer.zaman.now.generic.MyData;

public class WildcardApp {
    public static void main(String[] args) {
        printData(new MyData<>("Ali Akbar"));
        printData(new MyData<>('A'));
        printData(new MyData<>(1000));
        printData(new MyData<>(1000L));
        printData(new MyData<>(true));
        printData(new MyData<MultipleConstraintApp.Manager>(new MultipleConstraintApp.Manager()));
    }

    private static void printData(MyData<?> data) {
        Object object = data.getData();
        System.out.println(object);
    }
}
