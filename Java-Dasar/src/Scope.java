public class Scope {
    public static void main(String[] args) {
        System.out.println("Akbar");
    }

    static void sayHello(String name) {
        String hello = "Hello " + name;
        if(!hello.isBlank()) {
            String hi = "Hi " + name;
            System.out.println(hi);
        }

        System.out.println(hello);
    //  System.out.println(hi); // error
    }
}
