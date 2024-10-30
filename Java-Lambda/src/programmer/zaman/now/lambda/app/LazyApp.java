package programmer.zaman.now.lambda.app;

import java.util.function.Supplier;

public class LazyApp {
    public static void main(String[] args) {
        testScore(90, () -> getName());
        testScore(60, () -> getName());
    }

    private static void testScore(int value, Supplier<String> name) {
        if(value > 80) {
            System.out.println("Selamat " + name.get() + " Anda Lulus");
        } else {
            System.out.println("Coba Lagi Tahun Depan");
        }
    }

    private static String getName() {
        System.out.println("Method ini dipanggil");
        return "Ali Akbar";
    }
}
