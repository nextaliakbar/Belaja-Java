package programmer.zaman.now.application;

import programmer.zaman.now.generic.MyData;

public class ContravariantApp {
    public static void main(String[] args) {
        MyData<Object> objectMyData = new MyData<>("Ali Akbar");
        objectMyData.setData(10000); // Aman
        procces(objectMyData);
    }

    private static void procces(MyData<? super String> myData) {
        Object object = myData.getData(); // Disarankan menggunakan objek jika ingin subtitusi
        System.out.println("Paramater value " + object);

    }
}
