public class ForLoop {
    public static void main(String[] args) {
//      For Loop tanpa kondisi
//        for(;;) {
//            System.out.println("Perulangan");
//        }

//      Foor Loop dengan kondisi
        int counter = 1;
        for(;counter <=10;) {
            System.out.println("Perulangan " + counter);
            counter++;
        }
        System.out.println("Counter "+counter);

//      Foor Loop dengan init statement, kondisi, post statement
        for(int c = 1; c <=10; c++) {
            System.out.println("Counter ke " + c);
        }
    }
}
