package programmer.zaman.now.application;

import programmer.zaman.now.generic.MyData;

public class CovariantApp {
    public static void main(String[] args) {
        // Covariant -> Read only
        MyData<Double> doubleMyData = new MyData<>(20.05);
        procces(doubleMyData);

        MyData<? extends Object> objectMyData = doubleMyData;
        System.out.println(objectMyData.getData());
    }

    private static void procces(MyData<? extends Object> myData) {
        System.out.println(myData.getData()); // Aman
        //myData.setData("Ali Akbar"); // Tidak bisa karena dapat merubah isi data
    }
}
