package programmer.zaman.now.data;

public class Application {

    public static final int PROCCESORS;

    static {
        System.out.println("Mengakses Application");
        PROCCESORS = Runtime.getRuntime().availableProcessors();
    }
}
